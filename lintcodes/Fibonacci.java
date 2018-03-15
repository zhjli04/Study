public class Solution {
    /**
     * Find the Nth number in Fibonacci sequence.

A Fibonacci sequence is defined as follow:

The first two numbers are 0 and 1.
The i th number is the sum of i-1 th number and i-2 th number.
The first ten numbers in Fibonacci sequence is:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

Example
Given 1, return 0

Given 2, return 1

Given 10, return 34


     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        
        int[] nums = new int[2];
        nums[0] = 0;
        nums[1] = 1;
        
        for (int i=3; i<=n; i++){
            int sum = nums[0] + nums[1];
            nums[0] = nums[1];
            nums[1] = sum;
        }
        return  nums[1];
    }
}
