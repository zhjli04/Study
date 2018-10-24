class Solution {
    /**
     * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        if (nums[0] == target){
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                if (nums[mid] > nums[mid - 1]){
                    return mid;
                }else{
                    while((start < mid) && (nums[mid] == target)){
                        mid--;
                    }
                    return mid+1;
                }
            }else if (nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
