/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/
class Solution {
    Node root = null;
    boolean valid = false;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        if (word == null || word.length() == 0) {
            return true;
        }
        boolean [][] visited = new boolean [board.length][board[0].length];
        root = add(word);
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == root.c) {
                    isValid (board, visited, i, j, root);
                }
                if (valid) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void isValid (char[][] board, boolean [][] visited, int i, int j, Node node) {
        if (valid || i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || node == null || board[i][j] != node.c) {
            return;
        }
        
        if (node.isWord) {
            valid = true;
            return;
        }
        
        visited[i][j] = true;
        isValid(board, visited, i+1, j, node.next);
        isValid(board, visited, i-1, j, node.next);
        isValid(board, visited, i, j+1, node.next);
        isValid(board, visited, i, j - 1, node.next);
        visited[i][j] = false;
    }
    
    private Node add (String word) {
        char[] chs = word.toCharArray();
        Node node = new Node(chs[0]);
        Node cur = node;
        
        for (int i=1; i<chs.length; i++) {
            Node n = new Node(chs[i]);
            cur.next = n;
            cur = n;
        }
        
        cur.isWord = true;
        return node;
    }
}

class Node {
    boolean isWord = false;
    char c;
    Node next;
    public Node (char c) {
        this.c = c;
        next = null;
    }
}
