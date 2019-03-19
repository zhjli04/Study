/*
mplement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
*/

class Solution {
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        int start = 1;
        int end = x/2 + 1;
        
        while(start < end){
            int mid = (start + end) / 2;
            if (x / mid >= mid){
                start = mid + 1;
            }else{
                end = mid ;
            }
        }
        return end -1;
    }
}
