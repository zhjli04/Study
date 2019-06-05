/*
76. Minimum Window Substring
Hard

2283

155

Favorite

Share
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:
*/
class Solution {
    public String minWindow(String s, String t) {
        if (s == t) {
            return s;
        }
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        
         int[] count = new int[128];
        for(char c : t.toCharArray()) count[c]++;
        
        int min = s.length() + 1, i = 0, j = 0, remain = t.length();
        
        String res = "";
        while(i < s.length()) {
            if(--count[s.charAt(i++)] >= 0) remain--;
            while(remain == 0) {
                if(i - j < min) {
                    min = i - j;
                    res = s.substring(j, i);
                }
                if(++count[s.charAt(j++)] > 0) remain++;
            }
        }
        return res;
    }
}
