public class Solution {
    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0
        || obstacleGrid[0] == null || obstacleGrid[0].length == 0){
            return 0;
        }
        
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        for (int i=0; i<col; i++){
            if (obstacleGrid[0][i] == 0){
                obstacleGrid[0][i] = 1;
            }else if (obstacleGrid[0][i] == 1){
                while( i < col){
                    obstacleGrid[0][i++] = 0;
               //     i++;
                }
            }
        }
        
        for (int i=1; i<row; i++){
            if (obstacleGrid[i][0] == 0){
                obstacleGrid[i][0] = 1;
            }else if (obstacleGrid[i][0] == 1){
                  while( i < row){
                    obstacleGrid[i++][0] = 0;
                   // i++;
                }
            }
        }
        
        for (int i=1; i<row; i++){
              for (int j=1; j<col; j++){
                  if (obstacleGrid[i][j] == 1){
                      obstacleGrid[i][j] = 0;
                  }else{
                      obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                  }
              }
        }
        
        return obstacleGrid[row-1][col-1];
    }
}
