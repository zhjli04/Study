/*
306. Additive Number
Medium

215

314

Favorite

Share
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:

Input: "112358"
Output: true 
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true 
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199
*/
class Solution {
    public boolean isAdditiveNumber(String a) {
          for (int i = 1; i < a.length(); i++) {
            for (int j = i; j < a.length(); j++) {
                String first = a.substring(0, i);
                String second = a.substring(i, j + 1);
                String third = a.substring(j + 1);
                if (first.length() > 1 && first.charAt(0) == '0')
                    continue;
                if (second.length() > 1 && second.charAt(0) == '0')
                    continue;
                if (third.length() > 1 && third.charAt(0) == '0')
                    continue;
                String added = add(first,second); 
                if(third.equals(added) || third.startsWith(added) && isAdditiveNumber(second + third))
                    return true;
            }
        }
        return false;
    }
    
      private String add(String a, String b){
        Long x = Long.valueOf(a); 
        Long y = Long.valueOf(b); 
        return String.valueOf(x + y); 
    }
}
