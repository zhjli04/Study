/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return res;
        }
        
        Set<List<Integer>> set = combinationSum2(candidates, target, 0);
        return new ArrayList<>(set);
    }
    
    private Set<List<Integer>> combinationSum2(int[] candidates, int target, int start) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i=start; i<candidates.length; i++) {
            if (candidates[i] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i] );
                set.add(list);
                break;
            }
            
            if (candidates[i] > target) {
                break;
            }
            
            Set<List<Integer>> next = combinationSum2(candidates, target - candidates[i], i+1);
            if (next.size() > 0) {
                Iterator it = next.iterator();
                while (it.hasNext()) {
                    List<Integer> ll = (List<Integer>) it.next();
                    List<Integer> list = new ArrayList<>();
                    list.add(candidates[i]);
                    list.addAll(ll);
                    set.add(list);
                }
            }
        }
        return set;
    }
}
