public class Solution {
    /**
     * Given a number n, return the factorial of the number as a string.
     * 
     * Example
Given a number n = 20
return 2432902008176640000


     * @param n: an integer
     * @return:  the factorial of n
     */
    public String factorial(int n) {
        // write your code here
        if (n <= 1){
            return "1";
        }
        int res[] = new int[50000];
 
        // Initialize result
        res[0] = 1;
        int res_size = 1;
 
        // Apply simple factorial formula 
        // n! = 1 * 2 * 3 * 4...*n
        for (int x = 2; x <= n; x++){
            res_size = multiply(x, res, res_size);
        }
        char[] ch = new char[res_size];
        for (int i=0; i<res_size; i++){
            ch[i] = int2char(res[res_size - i - 1]);
        }
        return String.valueOf(ch);
    }
    
    char int2char(int i){
        switch(i){
            case 0:
                return '0';
            case 1:
              return '1';
            case 2:
                return '2';
            case 3:
              return '3';
            case 4:
                return '4';
            case 5:
              return '5';
            case 6:
                return '6';
            case 7:
              return '7';
            case 8:
                return '8';
            case 9:
              return '9';
            default:
              return ' ';
        }
    //    return ' ';
    }
    
    int multiply(int x, int res[], int res_size)
    {
        int carry = 0; // Initialize carry
 
        // One by one multiply n with individual 
        // digits of res[]
        for (int i = 0; i < res_size; i++)
        {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of 
                                // 'prod' in res[]
            carry = prod/10; // Put rest in carry
        }
 
        // Put carry in res and increase result size
        while (carry!=0)
        {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }
}
