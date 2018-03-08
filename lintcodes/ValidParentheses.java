public class Solution {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * 
     * Example
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.



     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        if (s == null || s.length() == 0){
            return true;
        }
        
        LinkedList<Character> ls = new LinkedList<Character>();
        int len = s.length();
        for (int i=0; i<len; i++){
            char c = s.charAt(i);
            if (ls.isEmpty()){
                ls.push(c);
            }else{
                if (((c == ')') && (ls.peek() == '('))
                || ((c == ']') && (ls.peek() == '['))
                || ((c == '}') && (ls.peek() == '{'))){
                    ls.pop();
                }else{
                    ls.push(c);
                }
            }
        }
        return ls.isEmpty();
    }
}
