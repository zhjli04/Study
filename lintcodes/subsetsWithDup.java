/*
90. Subsets II
Medium

887

50

Favorite

Share
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        dfs(res, nums, 0, nums.length-1);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        
        if (start == end) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[start]);
            res.add(l);
            return;
        }
        
        for (int i=start; i<=end; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            
            List<Integer> l = new ArrayList<>();
            l.add(nums[i]);
            res.add(l);
            List<List<Integer>> tmp = new ArrayList<>();
            dfs(tmp, nums, i+1, end);
            for (List<Integer> list : tmp) {
                List<Integer> ll = new ArrayList<>();
                ll.add(nums[i]);
                ll.addAll(list);
                res.add(ll);
            }
        }
    }
}
