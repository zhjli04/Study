/*
221. Maximal Square
Medium

1385

34

Favorite

Share
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
         int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
      /*  int [] hs = new int[matrix[0].length];
        int max = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    hs[j] = 0;
                }else{
                    hs[j] += 1;
                }
            }
            int m = maxSqr(hs);
            max = m > max ? m : max;
        }
        return max;
        */
    }
    
    private int maxSqr(int[] hs) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i=0; i<=hs.length; i++) {
            while (!st.empty() && (i==hs.length || hs[i] < hs[st.peek()])) {
                int cur = st.pop();
                int left = -1;
                if (!st.empty()) {
                    left = st.peek();
                }
                int diff = i - left - 1;
                int min = Math.min(diff, hs[cur]);
                int sqr = min * min;
                max = sqr > max ? sqr : max;
            }
            st.push(i);
        }
         return max;
    }
}
