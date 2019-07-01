/*
131. Palindrome Partitioning
Medium

944

39

Favorite

Share
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
       
        split(ret, s, 0, new ArrayList<String>());
        return ret;
    }
    
    public void split(List<List<String>> ret, String s, int idx, List<String> list) {
        if (idx == s.length()) {
            ret.add(new ArrayList<String>(list));
            return;
        }
        
        
        for (int i=idx+1; i<=s.length(); i++) {
            if (isPalin(s.substring(idx,i))) {
                list.add(s.substring(idx,i));
                split(ret, s, i, list);
                list.remove(list.size()-1);
            }
        }
       
        
    }
    
    public boolean isPalin(String s) {
        int start = 0;
        int end = s.length() -1 ;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
