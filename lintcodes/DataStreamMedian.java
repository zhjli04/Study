public class Solution {
    /**
     * Clarification
What's the definition of Median?
- Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].

     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return null;
        }
        
        if (nums.length == 1){
            return nums;
        }
        
        int [] ret = new int[nums.length];
        
        ret[0] = nums[0];
        
        for (int i=1; i<nums.length; i++){
            if (nums[i] < nums[i-1]){
                for (int j=i; j>=1; j--){
                    if (nums[j] < nums[j-1]){
                        swap(nums, j, j-1);
                    }
                }
            }
            ret[i] = nums[i/2];
        }
        return ret;
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
