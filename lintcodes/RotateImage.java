public class Solution {
    /**
     * You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Example
Given a matrix

[
    [1,2],
    [3,4]
]
rotate it by 90 degrees (clockwise), return

[
    [3,1],
    [4,2]
]

     * @param matrix: a lists of integers
     * @return: nothing
     */
    public void rotate(int[][] matrix) {
        // write your code here
         for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}
