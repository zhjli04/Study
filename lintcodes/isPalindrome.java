/*
125. Valid Palindrome
Easy

599

1748

Favorite

Share
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        char[] chs = s.toLowerCase().toCharArray();
        int start = 0;
        int end = chs.length - 1;
        while (start <= end) {
            if ((chs[start] < 'a' || chs[start] > 'z') && (chs[start] < '0' || chs[start] > '9') ) {
                start++;
                continue;
            }
            
            if ((chs[end] < 'a' || chs[end] > 'z') && (chs[end] < '0' || chs[end] > '9')){
                end--;
                continue;
            }
            
            if (chs[start] != chs[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
