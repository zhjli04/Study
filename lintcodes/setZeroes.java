/*
 73. Set Matrix Zeroes
Medium

1051

191

Favorite

Share
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        // if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        //     return;
        // }
        
        boolean isFirstRowZero=false;
        boolean isFirstColZero=false;
        
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                if(matrix[row][col]==0){
                    if(row==0) isFirstRowZero=true;
                    if(col==0) isFirstColZero=true;
                    matrix[row][0]=0;
                    matrix[0][col]=0;
                }
            }
        }
        
        for(int row=1;row<matrix.length;row++){
            for(int col=1;col<matrix[0].length;col++){
                if(matrix[row][0]==0 || matrix[0][col]==0){
                    matrix[row][col]=0;
                }
            }
        }
        
        if(isFirstRowZero){
            for(int col=0;col<matrix[0].length;col++){
                matrix[0][col]=0;
            }
        }
        
        if(isFirstColZero){
            for(int row=0;row<matrix.length;row++){
                matrix[row][0]=0;
            }
        }
        
        
        // int row = matrix.length;
        // int col = matrix[0].length;
        
    /*    boolean[][] visited = new boolean[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    fill(matrix, i, j, visited);
                }
            }
        }*/
        
        
//        Set<Integer> rowSet = new HashSet<>();
//         Set<Integer> colSet = new HashSet<>();
      
//         for (int i=0; i<row; i++) {
//             for (int j=0; j<col; j++) {
//                 if (matrix[i][j] == 0) {
//                     rowSet.add(i);
//                     colSet.add(j);
//                 }
//             }
//         }
        
//         for (int i=0; i<row; i++) {
//             for (int j=0; j<col; j++) {
//                 if (rowSet.contains(i) || colSet.contains(j)) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
        
//         for (int i : rowSet) {
//             for (int j=0; j<col; j++) {
//                 matrix[i][j] = 0;
//             }
//         }
        
//         for (int i : colSet) {
//              for (int j=0; j<row; j++) {
//                 matrix[j][i] = 0;
//              }
//         }
        
    }
    
//     public void fill(int[][] matrix, int i, int j, boolean [][] visited) {
//          int row = matrix.length;
//          int col = matrix[0].length;
//          for (int c=0; c<col; c++) {
//              if (matrix[i][c] != 0) {
//                  matrix[i][c] = 0;
//                  visited[i][c] = true;
//              }
//          }
        
//          for (int r=0; r<row; r++) {
//              if (matrix[r][j] != 0) {
//                  matrix[r][j] = 0;
//                  visited[r][j] = true;
//              }
//          }
//     }
    
    
}
