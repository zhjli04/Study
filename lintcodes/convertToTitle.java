/*
168. Excel Sheet Column Title
Easy

735

145

Favorite

Share
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
*/
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            if (n <= 26) {
                int a = 'A' + n - 1;
                char c = (char)a;
                sb.append(c);
            }else{
                 int t = n % 26;
                 if (t == 0)  {
                   sb.append('Z');
                 }else{
                    int a = 'A' + t - 1;
                    char c = (char)a;
                    sb.append(c);
                 }
            }
            n = --n / 26;
        }
        return sb.reverse().toString();
    }
}
