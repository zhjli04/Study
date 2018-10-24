class Solution {
    /**
     * There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peak if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

 Notice
It's guaranteed the array has at least one peak.
The array may contain multiple peeks, find any of them.
The array has at least 3 numbers in it.

Example
Given [1, 2, 1, 3, 4, 5, 7, 6]

Return index 1 (which is number 2) or 6 (which is number 7)

     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A==null || A.length<3){
            return -1;
        }
        
        return helper(A,0,A.length-1);
        
   /*     int len = A.length;
        for (int i=1; i<len-1; i++){
            if ((A[i] > A[i-1]) && (A[i]>A[i+1])){
                return i;
            }
        }
        return -1;*/
    }
    
    public int helper(int[] num,int start,int end){
        if(start == end){
            return start;
        }else if(start+1 == end){
            if(num[start] > num[end]) return start;
            return end;
        }else{
            int m = (start+end)/2;
            if(num[m] > num[m-1] && num[m] > num[m+1]){
                return m;
            }else if(num[m-1] > num[m] && num[m] > num[m+1]){
                return helper(num,start,m-1);
            }else{
                return helper(num,m+1,end);
            }
        
        }
    }
}
