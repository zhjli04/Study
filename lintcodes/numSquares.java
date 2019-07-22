/*
279. Perfect Squares
Medium

1548

125

Favorite

Share
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/
class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            for(int k=1; k*k<=i; k++){
                dp[i] = Math.min(dp[i], dp[i-k*k]+1);
            }
        }
        return dp[n];
    }
}
