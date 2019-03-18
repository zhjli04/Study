/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.
*/

class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board[0].length == 0){
            return;
        }
        
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j] == '.'){
                    for (char c='1'; c<='9';c++){
                        if (isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                  return false;
                }
            }
          
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col, char c){
        for (int i=0; i<9; i++){
            if (board[i][col] != '.' && board[i][col] == c){
                return false;
            }
            
            if (board[row][i] != '.' && board[row][i] == c){
                return false;
            }
            
            int rowi = (row/3)*3 + i/3;
            int coli = (col/3) *3+i%3;
            if (board[rowi][coli] != '.' && board[rowi][coli] == c){
                return false;
            }
        }
        return true;
    }
}
