public class Solution {
    /**
     * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
     * Example
Given N = 3 and the array [0, 1, 3], return 2.

     * @param nums: An array of integers
     * @return: An integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        int n = nums.length;
        long sum = n*(n+1)/2;
        for (int i=0; i<n; i++){
            sum -= nums[i];
        }
        return (int)sum;
    }
}
