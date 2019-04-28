/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        if (strs.length == 1) {
            return strs[0];
        }
        
        int len = strs[0].length();
        for (int i=1; i<strs.length; i++) {
            if (strs[i].length() < len) {
                len = strs[i].length();
            }
        }
            
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
            char c = strs[0].charAt(i);
            boolean failed = false;
            for (int j=1; j<strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    failed = true;
                    break;
                }
            }
            
            if (failed) {
                break;
            }
            
            sb.append(c);
        }
        return sb.toString();
    }
}
