/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for (int i=1; i<nums.length; i++){
            int curMax = max * nums[i];
            int curMin = min * nums[i];
            
            max = Math.max(nums[i], Math.max(curMax, curMin));
            min = Math.min(nums[i], Math.min(curMax, curMin));
            
            if (max > res){
                res = max;
            }
        }
        return res;
    }
}
