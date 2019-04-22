public class Solution {
    /**
     * Check a positive number is a palindrome or not.

A palindrome number is that if you reverse the whole number you will get exactly the same number.

 Notice
It's guaranteed the input number is a 32-bit integer, but after reversion, the number may exceed the 32-bit integer.

Example
11, 121, 1, 12321 are palindrome numbers.

23, 32, 1232 are not palindrome numbers.



     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here
        int[] res = new int[10];
        int n = 0; //num % 10;
        int i = 0;
        while(num != 0){
            n = num % 10;
            res[i++] = n;
            num /= 10;
        }
        
        int start = 0;
        int end = i-1;
        
        while(start <= end){
            if(res[start] != res[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        if (x < 10) {
            return true;
        }
        
        String s = String.valueOf(x);
        int start = 0;
        int end = s.length() -1;
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
