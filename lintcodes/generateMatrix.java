/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        
        long sum = n * n;
        int j=1;
        while (top <= right && left <= right && j <= sum) {
            for (int i=left; i<=right; i++) {
                res[top][i] = j++;
            }
            top++;
            
            for (int i=top; i<=down; i++) {
                res[i][right] = j++;
            }
            right--;
            
            for (int i=right; i>=left; i--) {
                res[down][i] = j++;
            }
            down--;
            
            for (int i=down; i>=top; i--) {
                res[i][left] = j++;
            }
            
            left++;
        }
        return res;
    }
}
