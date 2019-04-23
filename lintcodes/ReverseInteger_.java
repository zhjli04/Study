/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/
class Solution {
    public int reverse(int x) {
        long sum = 0;
        int sig = x < 0 ? -1 : 1;
        x = x < 0 ? -x : x;
        
        while (x > 0) {
            sum *= 10;
            sum += x % 10;
            x /= 10;
        }
        
        if (sum > Integer.MAX_VALUE) {
            return 0;
        }
        
        return (int)sum*sig;
    }
}
