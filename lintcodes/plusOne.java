/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int end = digits.length - 1;
        if (digits[end] + 1 < 10) {
            digits[end] += 1;
            return digits;
        }
        
        digits[end] = 0;
        end--;
        while (end >= 0) {
            if (digits[end] + 1 < 10) {
                 digits[end] += 1;
                 return digits;
            }
            digits[end] = 0;
            end--;
        }
        
        int [] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
