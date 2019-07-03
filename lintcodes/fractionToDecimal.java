/*
166. Fraction to Recurring Decimal
Medium

473

1051

Favorite

Share
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
*/
class Solution {
    public String fractionToDecimal(int num, int den) {
        if (den == 1) {
            return String.valueOf(num);
        }
        
        if (num == 0) {
            return "0";
        }
        
        if (den == 0) {
            return "";
        }
        
        if (num == den) {
            return "1";
        }
        
        boolean positive = true;
        // 为解决整型越界的问题 将int转为long
        long nLong = (long)num, dLong = (long)den;
        // 判断正负
        if (nLong * dLong < 0L)
            positive = false;
        nLong = Math.abs(nLong);
        dLong = Math.abs(dLong);
        // System.out.println(nLong);
        long intPart = nLong / dLong, rem = nLong % dLong; // 得到整数部分 和 余数
        if (rem == 0)
            return positive ? Long.toString(intPart) : "-" + Long.toString(intPart);
        StringBuilder sb = new StringBuilder(); // 得到小数部分 可能含有"()"
        Map<Long, Integer> map = new HashMap<>(); // 存储余数rem和rem / d所在的StringBuilder中的位置
        // 当余数为0 或者 map中出现过该余数时，跳出循环
        int index = 0;
        while (rem != 0L && !map.containsKey(rem)) {
            map.put(rem, index++);
            nLong = rem * 10; // 模拟除法
            rem = nLong % dLong;
            sb.append(nLong / dLong);
        }
        if (rem == 0) {
            String res = intPart + "." + sb.toString();
            return positive ? res : "-" + res;
        }
        sb.insert(map.get(rem), "(");
        sb.append(")");
        String res = intPart + "." + sb.toString();
        return positive ? res : "-" + res;
    }
}
