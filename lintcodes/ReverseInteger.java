public class Solution {
    /**
     * Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).
     * 
     * Example
Given x = 123, return 321

Given x = -123, return -321

     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        // write your code here
        int m = n;
        boolean minus = false;
        if (n < 0){
            m = -n;
            minus = true;
        }
        
        int [] ret = new int[12];
        
        int i = 0;
        while(m > 9){
            ret[i++] = m % 10;
            m /= 10;
        }
        ret[i] = m;
        
        long sum = 0;
        for (int j=0; j<=i; j++){
            long s = 1;
            for (int k=1; k<=i-j; k++){
                s *= 10;
            }
            sum += ret[j] * s;
           // sum += ret[j] + j*10;
        }
        
        if (sum > Integer.MAX_VALUE){
            //sum = 0;
            return 0;
        }
        
        if (minus){
            return (int)-sum;
        }
        return (int)sum;
    }
}
