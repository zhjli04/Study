public class Solution {
    /**
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     * 
     * Example
Given s = "lintcode", return 0.

Given s = "lovelintcode", return 2.

     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        // write your code here
        if (s == null || s.isEmpty()){
            return -1;
        }
        
        if (s.length() == 1){
            return 0;
        }
        
        char[] sc = s.toCharArray();
        int [] v = new int[256];
        for (int i=0; i<sc.length; i++){
            v[sc[i]] += 1;
        }
        
        for (int i=0; i<sc.length; i++){
            if (v[sc[i]] == 1){
                return i;
            }
        }
        return -1;
    }
}
