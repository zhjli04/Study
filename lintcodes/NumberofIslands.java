/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int count = 0;
        
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0;i < grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    fill(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    
    public void fill(char[][] grid, int i, int j, boolean[][] visited){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]){
            return;
        }
        visited[i][j] = true;
       // grid[i][j] = '0';
        
        fill(grid, i-1, j, visited);
        fill(grid, i+1, j, visited);
        fill(grid, i, j-1, visited);
        fill(grid, i, j + 1, visited);
    }
}
