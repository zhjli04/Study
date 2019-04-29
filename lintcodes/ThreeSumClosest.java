/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        
        Arrays.sort(nums);
        if (nums.length == 3 ) {
            return nums[0] + nums[1] + nums[2];
        }
        
        int res = nums[0] + nums[1] + nums[2];
        for (int i=0; i<nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return target;
                }
                
                if (Math.abs(sum - target) < Math.abs(res-target)) {
                    res = sum;
                }
                
                if (sum > target) {
                    end--;
                }else{
                    start++;
                }
            }
        }
         return res;
    }
}
