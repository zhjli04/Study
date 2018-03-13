public class Solution {
    /**
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 40,000.

The order of output does not matter

Example
Given s = "cbaebabacd" p = "abc"

return [0, 6]

The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // write your code here
        List<Integer> ret = new ArrayList<Integer>();
        if (s.length() < p.length()){
            return ret;
        }
        
        int end = s.length() - p.length();
        
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        for (int i=0; i<=end; i++){
            if (isAnagram(s.substring(i, i + p.length()), p)){
                ret.add(i);
            }
         /*   if (isAnagram(sc, i, pc)){
                ret.add(i);
            }*/
        }
        return ret;
    }
    
    public boolean isAnagram(char[] sc, int start, char[] pc){
        int [] si = new int[26];
        int [] pi = new int[26];
        for (int i=start; i<start+pc.length; i++){
            si[sc[i] - 'a'] += 1;
        }
        
        for (int i=0; i<pc.length; i++){
            pi[pc[i] - 'a'] += 1;
        }
        
        for (int i=0; i<26; i++){
            if (si[i] != pi[i]){
                return false;
            }
        }
        return true;
    }
    
    public boolean isAnagram(String s, String p){
        int [] si = new int[26];
        int [] pi = new int[26];
        for (int i=0; i<s.length(); i++){
            si[s.charAt(i)-'a'] += 1;
        }
        
        for (int i=0; i<p.length(); i++){
            pi[p.charAt(i) - 'a'] += 1;
        }
        
        for (int i=0; i<26; i++){
            if (si[i] != pi[i]){
                return false;
            }
        }
        return true;
    }
}
