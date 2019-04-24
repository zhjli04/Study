/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

*/
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows <= 1) {
            return s;
        }
        
      /*  int len = s.length();
        char [][] chs = new char[numRows][len];
        
        char[] cs = s.toCharArray();
        int pos = 0;
        for (int i=0; i<len; i++) {
            if (pos >= len) {
                break;
            }
            if (i % (numRows - 1) == 0) {
                for (int j=0; j<numRows; j++) {
                        if (pos >= len) {
                           break;
                         }
                        chs[j][i] = cs[pos++];
                }
            }else{
                int row = numRows -  i % (numRows-1) - 1;
                chs[row][i] = cs[pos++];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<numRows; i++) {
            for (int j=0; j<len; j++) {
                    sb.append(chs[i][j]);
            }
        }
        return sb.toString();
        */
         int size = s.length();
        char[] cs = s.toCharArray();
        String[] scs = new String[numRows];
        String r = "";
        int j = 0, k = 1;
               
        for(int i = 0; i < size; i++){
            scs[j] = (scs[j] == null ?  "" + cs[i] :  scs[j] + cs[i]);
            if(j == 0){
                k=1;
            } else if(j == numRows-1){
                k=-1;
            }
            j+=k;
        }
        
        for(String x : scs){
            r += x;
        }
        return r;
    }
}
