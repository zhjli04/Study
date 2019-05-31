/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/
class Solution {
    
    private int carry = 0;
    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        
        if (b == null) {
            return a;
        }
        
        int enda = a.length() - 1;
        int endb = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (enda >= 0 && endb >= 0) {
            char c = add(a.charAt(enda), b.charAt(endb));
            sb.append(c);
            enda--;
            endb--;
        }
        
        while(enda >= 0) {
            char c = add(a.charAt(enda));
            sb.append(c);
            enda--;
        }
        
        while(endb >= 0) {
            char c = add(b.charAt(endb));
            sb.append(c);
            endb--;
        }
        
        if (carry == 1) {
            sb.append('1');
        }
        
        return sb.reverse().toString();
    }
    
    public char add(char a){
        if (a == '1') {
             if (carry == 1) {
                 return '0';
             }
            return '1';
        }
        
         if (carry == 1) {
             carry = 0;
             return '1';
         }
         return '0';
    }
    
    public char add(char a, char b) {
        char c;
        if (a == '1' && b == '1') {
            c = '0';
            if (carry == 1) {
                c = '1';
            }
            carry = 1;
            return c;
        }
        
        if (a == '0' && b == '0') {
            c = '0';
            if (carry == 1) {
                c = '1';
            }
            carry = 0;
            return c;
        }
        
        c = '1';
        if (carry == 0) {
            return c;
        }
        
        c = '0';
        return c;
    }
}
