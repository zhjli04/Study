public class Solution {
    /*
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    Example
Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int row = triangle.length;
        int col = triangle[0].length;
        
        for (int i=row-2; i>=0; i--){
            for (int j=0; j<i+1; j++){
                if (triangle[i+1][j] < triangle[i+1][j+1]){
                    triangle[i][j] += triangle[i+1][j];
                }else{
                    triangle[i][j] += triangle[i+1][j+1];
                }
            }
        }
        return triangle[0][0];
    }
}
