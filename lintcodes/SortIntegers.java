public class Solution {
    /**
     * Given an integer array, sort it in ascending order. Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.
     * 
     * Example
Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].

     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // write your code here
        if (A == null || A.length <= 1){
            return;
        }
        
        for (int i=1; i<A.length; i++){
            for (int j=i; j>=1; j--){
                if (A[j] < A[j-1]){
                    int t = A[j];
                    A[j] = A[j-1];
                    A[j-1] = t;
                }
            }
        }
    }
}
