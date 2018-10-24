public class Solution {
    /*
    Find the contiguous subarray within an array (containing at least one number) which has the largest product.
    Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.


     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null | nums.length == 0){
            return 0;
        }
        int total = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for (int i=1; i<nums.length; i++){
            int tmp = max;
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(tmp*nums[i], min*nums[i]), nums[i]);
            if (max > total){
                total = max;
            }
        }
        return total;
    }
}
