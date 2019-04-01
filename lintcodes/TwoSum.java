/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[2];
        if (nums == null || nums.length <= 1) {
            return res;
        }
        
      /*  for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int n = target - nums[i];
            if (map.get(n) != null) {
                res[0] = map.get(n);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
