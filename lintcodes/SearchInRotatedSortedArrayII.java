public class Solution {
    /*
    Follow up for Search in Rotated Sorted Array:

What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

Example
Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
Given [1, 1, 1, 1, 1, 1] and target = 0, return false.

     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0){
            return false;
        }
        
        if (A.length == 1){
            return A[0] == target;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            if (A[mid] == target || A[start] == target || A[end] == target){
                return true;
            }
            
            if (A[start] < A[mid]){
                if ((A[start] < target) && (target < A[mid])){
                    end = mid - 1;
                }else{
                    start += 1;
                }
            }else if (A[start] > A[mid]){
                if ((A[mid] < target) && (target < A[end])){
                    start = mid + 1;
                }else{
                    end -= 1;
                }
            }else{
                start++;
            }
            
        }
        return false;
    }
}
