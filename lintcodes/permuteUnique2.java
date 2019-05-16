/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, res, new ArrayList<>());
        return res;
    }
    
    public void dfs(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == nums.length) {
          //  res.add(new ArrayList<Integer>(list));
            res.add(list);
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i-1] && !used[i-1]) || used[i]) {
                continue;
            }
            List<Integer> ll = new ArrayList<>(list);
            
           // list.add(nums[i]);
            ll.add(nums[i]);
            used[i] = true;
            dfs(nums, used, res, ll);
            used[i] = false;
        //    list.remove(list.size()-1);
        }
    }
    
}
