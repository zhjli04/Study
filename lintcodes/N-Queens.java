/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
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
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n <= 0){
            return res;
        }
        List<List<Integer>> lli = new ArrayList<List<Integer>>();
        List<Integer> lr = new ArrayList<Integer>();
        dfs(lli, 0, n, lr);
        return gen( lli, n);
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
    
    public List<List<String>> gen(List<List<Integer>> lli, int n){
        List<List<String>> res = new ArrayList<List<String>>();
        for (int i=0; i<lli.size(); i++){
            List<Integer> c = lli.get(i);
            List<String> s = new ArrayList<String>();
            for (int j=0; j<n; j++){
                int val = c.get(j);
                String str = "";
                for (int k=0; k<n; k++){
                    if (k == val){
                        str += "Q";
                    }else{
                        str += ".";
                    }
                }
                s.add(str);
            }
            res.add(s);
        }
        return res;
    }
}
