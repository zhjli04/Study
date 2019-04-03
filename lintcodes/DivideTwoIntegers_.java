/*
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
*/
class Solution {
    public int divide(int dividend, int divisor) {
     /*   if (dividend == Integer.MIN_VALUE && divisor == -1) {
          return Integer.MAX_VALUE;
        }
        boolean sign = dividend < 0 == divisor < 0;
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;
        int quotient = div(dividend, divisor);
        return sign ? quotient : -quotient;
        */
        // make sure it can work when both the dividend and the divisor are the Integer.MIN_VALUE
        if (dividend == divisor)
        {
            return 1;
        }
        
		// make sure it can work when judging and setting the divisor to a positive number
        if (divisor == Integer.MIN_VALUE)
        {
            return 0;
        }
        
        int count = 0;
        int sign = 1;
		// make sure the divisor to be a positive number
        if (divisor < 0)
        {
            sign = -sign;
            divisor = -divisor;
        }
      
	   // make sure the dividend to be a positive number
        if (dividend < 0)
        {
            sign = -sign;
            // make sure it can work when change the dividend from the Integer.MIN_VALUE to a positive  number
            if (dividend == Integer.MIN_VALUE)
            {
                dividend += divisor;
                count++;
            }
            dividend = -dividend;
        }
        
        int quotient = dividePositiveNum(dividend, divisor);
		// make sure it will not exceed the range of Integer
        if (quotient > Integer.MAX_VALUE - count)
        {
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        quotient = count + quotient;
        return sign > 0 ? quotient: -quotient;
    }
    
     private int dividePositiveNum(int dividend, int divisor)
    {
        if (dividend < divisor)
        {
            return 0;
        }
        
        if (dividend == divisor)
        {
            return 1;
        }
        
        int powCount = -1;
        int tempDividend = dividend;
        while (tempDividend > divisor)
        {
            tempDividend = tempDividend >> 1;
            powCount++;
        }

        int partQuotient = 1 << powCount;
        int partMultiNum = divisor << powCount;
        int remaindDividend = dividend - partMultiNum;
        return partQuotient + dividePositiveNum(remaindDividend, divisor);
    }
    
    private int div(int dividend, int divisor) {
        int total = divisor, result = 0, prev = 0;

        while (dividend <= total) {
            result = result == 0 ? 1 : result + result;
            prev = total;
            total += total;
            // overflow
            if (total > prev) {
              break;
            }
        }
        return result == 0 ? result : result + div(dividend - prev, divisor);
  }
}
