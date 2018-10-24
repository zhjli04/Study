public class Solution {
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null || A.length == 0){
            return B;
        }
        
        if (B == null || B.length == 0){
            return A;
        }
        
        int size = A.length + B.length;
        int [] ret = new int[size];
        
        int i = 0;
        int j = 0;
        int pos = 0;
        
        while (( i < A.length) && ( j < B.length)){
            if (A[i] < B[j]){
                ret[pos++] = A[i++];
            }else{
                ret[pos++] = B[j++];
            }
        }
        
        while ( i < A.length ) {
            ret[pos++] = A[i++];
        }
        
        while ( j < B.length ){
            ret[pos++] = B[j++];
        }
        
        return ret;
    }
}
