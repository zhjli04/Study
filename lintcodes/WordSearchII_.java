/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
*/

class Solution {
    TrieNode root = new TrieNode(' ', "");
    Set<TrieNode> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board[0].length == 0 || words == null || words.length == 0){
         return res;   
        }
        
        for (String word: words) {
            insert(word);
        }
        
        int row = board.length;
        int col = board[0].length;
        
        boolean [][] visited = new boolean[row][col];
        
        TrieNode td = root;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                search(board, visited, i, j, root);
            }
        }
        
        Iterator<TrieNode> it = set.iterator();
        String [] ss = new String[set.size()];
        int pos = 0;
        while(it.hasNext()){
            TrieNode node = (TrieNode)it.next();
            ss[pos++] = node.str.trim();
        }
        
        Arrays.sort(ss);
        for (String s : ss){
            res.add(s);
        }
        return res;
    }
    
    public void search(char[][] board,  boolean [][] visited, int i, int j, TrieNode node){
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]){
            return;
        }
        
        char c = board[i][j];
        if (node == null || node.children[c - 'a'] == null){
            return;
        }
         
        node = node.children[c - 'a'];
        if (node.isWord){
            set.add(node);
        }
        
        visited[i][j] = true;
        search(board, visited, i-1, j, node);
        search(board, visited, i+1, j, node);
        search(board, visited, i, j-1, node);
        search(board, visited, i, j+1, node);
        visited[i][j] = false;
    }
    
    public void insert(String word) {
        if (word == null || word.length() == 0){
            return;
        }
        
        TrieNode tn = root;
        for (char c : word.toCharArray()){
            if (tn.children[c - 'a'] == null){
                tn.children[c - 'a'] = new TrieNode(c, tn.str);
            }
            tn = tn.children[c - 'a'];
        }
        tn.isWord = true;
    }
    
     class TrieNode{
        char c;
        String str = "";
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
        public TrieNode(char ch, String s){
            c = ch;
            str = s + String.valueOf(ch);
        }
     }
}
