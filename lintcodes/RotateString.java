public class Solution {
    /**
     * Given a string and an offset, rotate string by offset. (rotate from left to right)
     * 
     * Example
Given "abcdefg".

offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"

     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0 || offset <= 0){
            return;
        }
        
        offset %= str.length;
        for (int i=0; i<offset; i++){
            char c = str[str.length-1];
            for (int j=str.length-1; j>0; j--){
                str[j] = str[j-1];
            }
            str[0] = c;
        }
    }
}
