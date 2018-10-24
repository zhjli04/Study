public class Solution {
    /*
    Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 

Example
Given matrix:

doaf
agai
dcan
and dictionary:

{"dog", "dad", "dgdg", "can", "again"}

return {"dog", "dad", "can", "again"}


     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
     HashSet<Node> visited = new HashSet<Node>();
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> ret = new ArrayList<String>();
        
        if (board == null || words == null || words.isEmpty()){
            return ret;
        }
        
  /*      int row = board.length;
        int col = board[0].length;
        
       int [] a = new int[256];
        int [] b = new int[256];
        
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                a[board[i][j]]++;
            }
        }
        
        for (String word : words){
            for (int k=0; k<256; k++){
                b[k] = 0;
            }
            
            char[] ch = word.toCharArray();
            for (char c: ch){
                b[c]++;
            }
            
            boolean in = true;
            for (char c : ch){
                if (b[c] > a[c]){
                    in = false;
                    break;
                }
            }
            
            if (in){
                ret.add(word);
            }
        }*/
        
        
    /*    List<Node> nodes = new ArrayList<Node>();
          for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                Node node = new Node(board[i][j]);
                nodes.add(node);
            }
        }
        
        Node root = nodes.get(0);
        root.next = nodes.get(1);
        root.down = nodes.get(col);

        for (int i=1; i<nodes.size(); i++){
            Node node = nodes.get(i);
            if ((i + 1) % col != 0){
                node.next = nodes.get(i+1);
            }
            
            if (i % col != 0){
                node.pre = nodes.get(i-1);
            }
            
            if ( (i / col + 1) % row != 0){
                node.down = nodes.get( i + col );
            }
            
            if (i / col > 0){
                node.up = nodes.get(i - col);
            }
        }*/
        
        for (String word : words){
            if (exist(board, word)){
                ret.add(word);
            }
        }
        
        return ret;
    }
    
    public boolean exist(char[][] board, String word) {
      if (word == null || word.length() == 0) {
        return true;
      }
      if (board == null) {
        return false;
      }
      
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          if (board[i][j] == word.charAt(0)) {
            boolean rst = search(board, word, i, j, 0);
            if (rst) {
              return true;
            }
          }
        }
      }
      return false;
    }

    public boolean search(char[][] board, String word, int i, int j, int start) {
      if (start == word.length()) {
        return true;
      }
      if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
        return false;
      }
      board[i][j] = ' ';
      boolean rst = search(board, word, i, j - 1, start + 1)
      || search(board, word, i, j + 1, start + 1)
      || search(board, word, i + 1, j, start + 1)
      || search(board, word, i - 1, j, start + 1);   
      board[i][j] = word.charAt(start);
      return rst;
    }
    
    
    
    public boolean isIn(Node root, String str, int start){
        if (root  == null){
            return false;
        }
        
        if (visited.contains(root)){
            return false;
        }
        
        
        
        if ((start == str.length() - 1) && (str.charAt(start) == root.val)){
            return true;
        }
        
        visited.add(root);
        
        if (str.charAt(start) == root.val){
            boolean up = isIn(root.up, str, start+1);
            if (up){
                return true;
            }
            
            boolean n = isIn(root.next, str, start+1);
            if (n){
                return true;
            }
            
            boolean pre = isIn(root.pre, str, start+1);
            if (pre){
                return true;
            }
            
            boolean d = isIn(root.down, str, start+1);
            if (d){
                return true;
            }
        }
        visited.clear();
        
        return isIn(root.up, str, start) || isIn(root.pre, str, start) || isIn(root.next, str, start) || isIn(root.down, str, start);
    }
    
    public class Node{
        char val;
        Node pre;
        Node next;
        Node up;
        Node down;
        
        public Node(char val){
            this.val = val;
        }
    }
}
