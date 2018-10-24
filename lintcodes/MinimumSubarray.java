public class Solution {
    /*
    Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.
Example
For [1, -1, -2, 1], return -3.

     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.isEmpty()){
            return Integer.MIN_VALUE;
        }
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        for (Integer i : nums){
            sum += i;
            if (sum < min){
                min = sum;
            }
            if (sum >= 0){
                sum = 0;
            }
        }
        return min;
    }
}
