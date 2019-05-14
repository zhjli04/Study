/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length-1] < target) {
            return res;
        }
        
        if (nums[0] == nums[nums.length-1] && nums[0] == target) {
            res[0] = 0;
            res[1] = nums.length-1;
            return res;
        }
        
        int mid = search(nums, target);
        if (mid == -1) {
            return res;
        }
        
        int start = mid;
        while (start >= 0 && nums[start] == target) {
            start--;
        }
        res[0] = start+1;
        
        int end = mid;
        while (end < nums.length && nums[end] == target) {
            end++;
        }
        res[1] = end-1;
        return res;
    }
    
    private int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        
        while (start <= end) {
            if (nums[start] == target) {
                return start;
            }
            
            if (nums[end] == target) {
                return end;
            }
            
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[mid] > target) {
                end = mid - 1;
            }else{
                start = mid +1;
            }
        }
        return -1;
    }
}
