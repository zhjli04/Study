/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int max = 1;
        int count = 1;
        int start = 0;
        for (int i=1; i<s.length(); i++) {
            int pos = exist(s, start, i, s.charAt(i));
            if (pos == -1) {
                count++;
                if (count > max) {
                    max = count;
                }
            }else{
                count = i-pos;
                start = pos+1;
            }
        }
        return max;
    }
    
    private int exist(String s, int start, int end, char c) {
        int pos = end - 1;
        while (pos >= start) {
            if (s.charAt(pos) == c) {
                return pos;
            }
            pos--;
        }
        return -1;
    }
    
}
             
