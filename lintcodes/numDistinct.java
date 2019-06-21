/*
115. Distinct Subsequences
Hard

695

36

Favorite

Share
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
*/
class Solution {
    int count = 0;
    public int numDistinct(String s, String t) {
//         if ((s == t) || (s == null && t == null) || (t == null)) {
//             return 1;
//         }
        
//         if (s == null || s.length() < t.length()) {
//             return 0;
//         }
        
//         if (s.length() == 0 && t.length() == 0) {
//         	return 1;
//         }
        
//         if (s.length() > 0 && t.length() == 0) {
//             return 1;
//         }
        
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for(int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= sLen; i++) {
            for(int j = 1; j <= tLen; j++) {
                dp[i][j] = dp[i - 1][j];
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[sLen][tLen];
        
      /*  if (s.charAt(0) == t.charAt(0)) {
            return numDistinct(s.substring(1), t) + numDistinct(s.substring(1), t.substring(1));
        }
        return numDistinct(s.substring(1), t);
        */
        
//         int end = s.length() - t.length();
        
//         int sum = 0;
//         for (int i=0; i<end; i++) {
//             if (s.charAt(i) == t.charAt(0)) {
//                 sum += match(s.substring(i), 0, t, 0);
//             }
//         }
//         return sum;
    }
    
    public int match(String s, int n, String t, int p) {
        if (p == t.length() - 1 && s.charAt(n) == t.charAt(p)) {
            count++;
        }
        
        for (int i=n; i<s.length(); i++) {
            
        }
        return 0;
    }
}
