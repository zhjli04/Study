public class Solution {
    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * 
     * Example
Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        for (int i=1; i<nums.length; i++){
            if (nums[i] != 0){
                for (int j=i; j>=1; j--){
                    if (nums[j-1] == 0){
                        nums[j-1] = nums[j];
                        nums[j] = 0;
                    }
                }
            }
        }
    }
}
