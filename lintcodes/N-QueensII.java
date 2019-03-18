/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

class Solution {
    Set<Integer> cols = new HashSet<Integer>();
    Set<Integer> p = new HashSet<Integer>();
    Set<Integer> na = new HashSet<Integer>();
    public int totalNQueens(int n) {
        if (n <= 0){
            return 0;
        }
        
        List<List<Integer>> lli = new ArrayList<List<Integer>>();
        List<Integer> lr = new ArrayList<Integer>();
        dfs(lli, 0, n, lr);
        return lli.size();
    }
    
     public void dfs(List<List<Integer>> lli, int row, int n, List<Integer> state){
        if (row >= n){
            lli.add(state);
            return;
        }
        
        for (int col=0; col<n; col++){
            if(cols.contains(col) || p.contains(col + row) || na.contains(row-col)){
                continue;
            }
          //  state.add(col);
            cols.add(col);
            p.add(col+row);
            na.add(row - col);
            List<Integer> ns = new ArrayList<Integer>();
            ns.addAll(state);
            ns.add(col);
            dfs(lli, row+1, n, ns);
            cols.remove(col);
            p.remove(col+row);
            na.remove(row-col);
        }
    }
}
