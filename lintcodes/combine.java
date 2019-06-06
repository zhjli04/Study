/*
77. Combinations
Medium

773

45

Favorite

Share
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 0 || k <= 0 || n < k) {
            return res;
        } 
        combine(res, n, 1, k);
        return res;
    }
    
    public void combine(List<List<Integer>> res, int n, int start, int k) {
        if (k == 1) {
            getOne(res, n, start);
            return;
        }
        
        for (int i=start; i<=n-k+1; i++) {
            List<List<Integer>> next = new ArrayList<>();
            combine(next, n, i+1, k-1);
            for (List<Integer> list : next) {
                List<Integer> rl = new ArrayList<>();
                rl.add(i);
                rl.addAll(list);
                res.add(rl);
            }
        }
    }
    
    public void getOne(List<List<Integer>> res, int n, int start) {
         for (int i=start; i<=n; i++) {
             List<Integer> one = new ArrayList<>();
             one.add(i);
             res.add(one);
         }
    }
}
