/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        res = combinationSum(candidates, target, 0);
        return res;
    }
    
    private List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
         List<List<Integer>> res = new ArrayList<>();
         for (int i=start; i<candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            
            if (candidates[i] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                res.add(list);
                break;
            }
             
            int loop = target / candidates[i];
            for (int j=1; j<=loop; j++) {
                int sum = target - j * candidates[i];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    for (int k=0; k<j; k++) {
                        list.add(candidates[i]);
                    }
                    res.add(list);
                }else{
                    List<List<Integer>>  nextList = combinationSum(candidates, sum, i+1);
                    if (nextList.size() > 0) {
                         for (List<Integer> ll : nextList) {
                             List<Integer> list = new ArrayList<>();
                             for (int k=0; k<j; k++) {
                                 list.add(candidates[i]);
                             }
                             list.addAll(ll);
                             res.add(list);
                         }
                    }
                }
            }
        }
        return res;
    }
}
