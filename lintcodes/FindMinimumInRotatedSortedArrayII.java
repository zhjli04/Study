public class Solution {
    /*
    
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.
Example
Given [4,4,5,6,7,0,1,2] return 0.
    
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }
        
        if (nums.length == 1){
            return nums[0];
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end){
            int mid = (start + end) / 2;
            
            if ((mid > 0) && (nums[mid] < nums[mid - 1])){
                return nums[mid];
            }
            
            if ((nums[start]<=nums[mid]) && (nums[mid] >= nums[end])){
                if (nums[start] < nums[end]){
                    return nums[start];
                }else{
                  start = mid + 1;
                }
            }else{
                end = mid - 1;
            }
        }
        return nums[start];
       
    }
    
   
}
