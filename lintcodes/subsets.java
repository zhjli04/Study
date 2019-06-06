/*
Subsets
Medium

1921

50

Favorite

Share
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i=1; i<= nums.length; i++) {
            subsets(res, nums, 0, i);
        }
        return res;
    }
    
    public void subsets(List<List<Integer>> res, int[] nums,int start, int k) {
        if (k == 1) {
            for (int i=start; i<nums.length; i++) {
                List<Integer> one = new ArrayList<>();
                one.add(nums[i]);
                res.add(one);
            }
             return;
        }
        
        for (int i=start; i<=nums.length-k; i++) {
            List<List<Integer>> next = new ArrayList<>();
            subsets(next, nums, i+1, k-1);
            for (List<Integer> list:next) {
                List<Integer> rl  = new ArrayList<>();
                rl.add(nums[i]);
                rl.addAll(list);
                res.add(rl);
            }
        }
    }
    
    
}
