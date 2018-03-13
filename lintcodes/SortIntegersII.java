public class Solution {
    /**
     * Given an integer array, sort it in ascending order. Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.
     * 
     * Example
Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].

     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        quickSort(A, 0, A.length-1);
    }
    
    public void quickSort(int[] A, int start, int end){
        if (start < end){
            int pos = findPos(A, start, end);
            quickSort(A, start, pos - 1);
            quickSort(A, pos+1, end);
        }
    }
    
    public int findPos(int[] A, int start, int end){
        if (start >= end){
            return -1;
        }
        
        int value = A[start];
        while(start < end){
            while((start < end) && (A[end] >= value)){
                end--;
            }
            
            if (start < end){
                A[start++] = A[end];
            }
            
            while((start < end) &&  (A[start] <=value)){
                start++;
            }
            
            if (start < end){
                A[end--] = A[start];
            }
        }
        A[start] = value;
        return start;
    }
}
