/*
289. Game of Life
Medium

971

191

Favorite

Share
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/
class Solution {
    public void gameOfLife(int[][] board) {
       
//         // Neighbors array to find 8 neighboring cells for a given cell
//         int[] neighbors = {0, 1, -1};

//         int rows = board.length;
//         int cols = board[0].length;

//         // Create a copy of the original board
//         int[][] copyBoard = new int[rows][cols];

//         // Create a copy of the original board
//         for (int row = 0; row < rows; row++) {
//             for (int col = 0; col < cols; col++) {
//                 copyBoard[row][col] = board[row][col];
//             }
//         }

//         // Iterate through board cell by cell.
//         for (int row = 0; row < rows; row++) {
//             for (int col = 0; col < cols; col++) {

//                 // For each cell count the number of live neighbors.
//                 int liveNeighbors = 0;

//                 for (int i = 0; i < 3; i++) {
//                     for (int j = 0; j < 3; j++) {

//                         if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
//                             int r = (row + neighbors[i]);
//                             int c = (col + neighbors[j]);

//                             // Check the validity of the neighboring cell.
//                             // and whether it was originally a live cell.
//                             // The evaluation is done against the copy, since that is never updated.
//                             if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
//                                 liveNeighbors += 1;
//                             }
//                         }
//                     }
//                 }

//                 // Rule 1 or Rule 3
//                 if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
//                     board[row][col] = 0;
//                 }
//                 // Rule 4
//                 if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
//                     board[row][col] = 1;
//                 }
//             }
//         }
        
        
        
         // Neighbors array to find 8 neighboring cells for a given cell
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // Iterate through board cell by cell.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // For each cell count the number of live neighbors.
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // Check the validity of the neighboring cell.
                            // and whether it was originally a live cell.
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // Rule 1 or Rule 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 signifies the cell is now dead but originally was live.
                    board[row][col] = -1;
                }
                // Rule 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 signifies the cell is now live but was originally dead.
                    board[row][col] = 2;
                }
            }
        }

        // Get the final representation for the newly updated board.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
    
}
