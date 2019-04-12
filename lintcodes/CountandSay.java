/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/
class Solution {
    public String countAndSay(int n) {
       StringBuilder prev = new StringBuilder();
        prev.append("1");
        for (int i = 2; i <= n; i++) {
            prev = buildNext(prev);
        }
        return prev.toString();
    }
    
    private StringBuilder buildNext(StringBuilder prev) {
        StringBuilder cur = new StringBuilder();
        int j = 0;
        while (j < prev.length()) {
            int count = 1;
            char c = prev.charAt(j);
            j++;
            while (j < prev.length() && prev.charAt(j) == c) {
                j++;
                count++;
            }
            cur.append(count);
            cur.append(c);
        }
        return cur;
    }
}
