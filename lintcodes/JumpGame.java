public class Solution {
    /**
     *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index. 
 Example

A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length <= 1){
            return true;
        }
        
        if (A[0] == 0){
            return false;
        }
        
        int end = A.length - 1;
        
        int max = A[0];
        
        
        for (int i=0; i<=max; i++){
            if (canJump(A, i)){
                return true;
            }
        }
        return false;
    }
    
    public boolean canJump(int[] A, int start){
        int end = A.length - 1;
        if ((start < end) && (start + A[start] >= end)){
           return true;
        }
        
        if ((start < end) &&  ( A[start] == 0)){
            return false;
        }
        
        return canJump(A, start + A[start]);
    }
}
