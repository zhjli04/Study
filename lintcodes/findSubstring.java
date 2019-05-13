/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
*/
class Solution {
    private int len = 0;
    private Map<String, Integer> map = new HashMap<>();
    public List<Integer> findSubstring(String s, String[] words) {
/*         List<Integer> resultList = new ArrayList<Integer>();
    if( s == null || s.length() < 1 || words.length < 1)
        return resultList;
		
    Map<String, Integer> wordToFreq = new HashMap<String, Integer>();
    for(int i = 0; i < words.length; i++) {
        wordToFreq.put(words[i], wordToFreq.getOrDefault(words[i], 0) + 1);
    }
	
    int length = words[0].length();
    String str[] = new String[s.length()];
    for(int i = 0; i < length; i++) { 
		// initialize slide window
        int begin = i;
        Map<String, Integer> current = new HashMap<String, Integer>();
        int size = 0;	
		
        for(int j = i; j <= s.length() - length; j += length) { // slide by the length of word
            str[j] = s.substring(j, j + length);
            if( wordToFreq.containsKey(str[j]) ) { // update slide window
                begin = begin == -1 ? j : begin;
                current.put(str[j], current.getOrDefault(str[j], 0) + 1);
                size++;
                if( size == words.length ) {
                    if( current.equals(wordToFreq) )
                        resultList.add(begin);
                    current.put(str[begin], current.get(str[begin]) - 1);
                    size--;
                    begin += length;
                }
            } else { // reset the slide window
                begin = -1;
                current.clear();
                size = 0;
            }
        }
    }
    return resultList;
    
    */
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        
        for (String w : words) {
            len += w.length();
        }
        
        if (s.length() < len) {
            return res;
        }
        
        for (int i=0; i<=s.length()-len; i++) {
            if (sub(s, words, i)) {
                res.add(i);
            }
        }
        return res;
        
    }
    
    
    private boolean sub(String s, String[] words, int start) {
        int length = words[0].length();
        int[] opt = new int[words.length];
        int pos = start;
        while (pos != start + len) {
            boolean find = false;
            for (int i=0; i<words.length; i++) {
                if ( opt[i] == 1){ 
                    continue;
                }
                
                String w = words[i];
                if (s.startsWith(w, pos)) {
                    find = true;
                    pos += w.length();
                    opt[i] = 1;
                    break;
                }
            }
            
            if (!find) {
                return false;
            }
        }
        
        for (int i=0; i<opt.length; i++ ) {
            if (opt[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
