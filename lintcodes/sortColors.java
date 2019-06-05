/*
75. Sort Colors
Medium

1630

156

Favorite

Share
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
*/
class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int end = nums.length - 1;
        int start = 0;
        for (int i=0; i<nums.length; i++) {
            if (i > end) {
                break;
            }
            
            if (nums[i] == 0 ) {
                swap(nums, start, i);
                start++;
            }
            
            if (nums[i] == 2 ) {
                swap(nums, i, end);
                end--;
                i--;
            }
        }
    }
    
    public void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
