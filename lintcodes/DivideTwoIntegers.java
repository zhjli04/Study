public class Solution {
    /**
     * Divide two integers without using multiplication, division and mod operator.

If it is overflow, return 2147483647

Have you met this question in a real interview? Yes
Example
Given dividend = 100 and divisor = 9, return 11.

     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        int sign = 1;
	if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
		sign = -1;
	long ldividend = Math.abs((long) dividend);
	long ldivisor = Math.abs((long) divisor);
	
	//Take care the edge cases.
	if (ldivisor == 0) return Integer.MAX_VALUE;
	if ((ldividend == 0) || (ldividend < ldivisor))	return 0;
	
	long lans = ldivide(ldividend, ldivisor);
	
	int ans;
	if (lans > Integer.MAX_VALUE){ //Handle overflow.
		ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
	} else {
		ans = (int) (sign * lans);
	}
	return ans;
    }
    private long ldivide(long ldividend, long ldivisor) {
	// Recursion exit condition
	if (ldividend < ldivisor) return 0;
	
	//  Find the largest multiple so that (divisor * multiple <= dividend), 
	//  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
	//  Think this as a binary search.
	long sum = ldivisor;
	long multiple = 1;
	while ((sum+sum) <= ldividend) {
		sum += sum;
		multiple += multiple;
	}
	//Look for additional value for the multiple from the reminder (dividend - sum) recursively.
	return multiple + ldivide(ldividend - sum, ldivisor);
}
}
