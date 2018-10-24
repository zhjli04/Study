public class Solution {
    /**
     * A robot is located at the top-left corner of a m x n grid.

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.

How many possible unique paths are there?

Example
Given m = 3 and n = 3, return 6.
Given m = 4 and n = 5, return 35.

     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if (m == 0 || n == 0){
            return 0;
        }
        
        if (m == 1 || n == 1){
            return 1;
        }
        
        int [][] steps = new int [m][n];
        for (int i=0; i<m; i++){
            steps[i][0] = 1;
        }
        
        for (int i=0; i<n; i++){
            steps[0][i] = 1;
        }
        
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                steps[i][j] = steps[i-1][j] + steps[i][j-1];
            }
        }
        return steps[m-1][n-1];
    }
}
