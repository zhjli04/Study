/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
*/
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i=0; i<s.length(); i++) {
            if (stack.peek() == -1) {
                stack.push(i);
            }else{
                char c = s.charAt(i);
                if (c == ')' && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    max = Math.max(max, i-stack.peek());
                    
                }else{
                    stack.push(i);
                }
            }
        }
        return max;
    }
}
