public class Solution {
    /*
    Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        if (s == null || s.isEmpty()){
            return s;
        }

        char[] sc = s.trim().toCharArray();
        reverse(sc, 0, sc.length-1);
        
        int start = 0;
        int end = 0;
        while(end < sc.length){
            while((end < sc.length) && (sc[end] != ' ')){
                end++;
            }
            reverse(sc, start, end-1);
            if (end < sc.length){
                while( sc[end] == ' '){
                    end++;
                }
                start = end;
            }
        }
        return String.valueOf(sc);
        
    }
    
    public void reverse(char[] chs, int start, int end){
        while(start < end){
            char c = chs[start];
            chs[start] = chs[end];
            chs[end] = c;
            start++;
            end--;
        }
    }
}
