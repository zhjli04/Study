/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0){
            return res;
        }
        gen(res, 0, 0, n, "");
        return res;
    }
    
    public void gen(List<String> res, int left, int right, int n, String s){
        if (left == right && left == n){
            res.add(s);
            return;
        }
        
        if (left < n){
            gen(res, left+1, right, n, s+"(");
        }
        if (left > right && right < n){
            gen(res, left, right + 1, n, s + ")");
        }
    }
}
