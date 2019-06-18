/*
91. Decode Ways
Medium

1408

1627

Favorite

Share
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        if (s.startsWith("0")) {
            return 0;
        }
        
        int length = s.length();
        int[] dp = new int[length + 1];
        char[] arr = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            if (arr[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1) {
                int num = (arr[i - 2] - '0') * 10 + arr[i - 1] - '0';
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[length];
    }
}
