/*
140. Word Break II
Hard

978

252

Favorite

Share
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/
class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return bt(s, wordDict);
    }
    
    public List<String> bt(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> ret = new ArrayList<>();
        if (wordDict.contains(s)) {
             ret.add(s);
        }
       
        for (int i=1; i<s.length(); i++) {
            String pre = s.substring(0,i);
            if (wordDict.contains(pre)) {
                List<String> list = bt(s.substring(i), wordDict);
                if (list != null) {
                    for (String next : list) {
                        ret.add(pre + " " + next);
                    }
                }
            }
        }
        map.put(s, ret);
        return ret;
    }
}
