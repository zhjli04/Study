/*
81. Search in Rotated Sorted Array II
Medium

662

312

Favorite

Share
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
*/
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (target == nums[start]) {
                return true;
            }
            
            if (target == nums[end]) {
                return true;
            }
            
            int mid = (start + end)/2;
            if (target == nums[mid]) {
                return true;
            }
            
           if (nums[start] < nums[mid]) {
                if (nums[mid] < target || nums[start] > target) {
	            		start = mid+1;
	            	}else {
	            		start += 1;
	            	}
            }else if (nums[start] > nums[mid]){
                if (nums[end] < target || nums[mid] > target) {
	            		end = mid - 1;
	            	}else {
	            		end--;
	            	}
            }else{
                start++;
                end--;
            }
        }
         return false;   
    }
}
