public class Solution {
    /**
     * Given an integer, convert it to a roman numeral.

The number is guaranteed to be within the range from 1 to 3999.

Clarification
What is Roman Numeral?

https://en.wikipedia.org/wiki/Roman_numerals
https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
http://baike.baidu.com/view/42061.htm
Example
4 -> IV

12 -> XII

21 -> XXI

99 -> XCIX

more examples at: http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm

     * @param n: The integer
     * @return: Roman representation
     */
    public String intToRoman(int n) {
        // write your code here
        String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[n/1000] + C[(n%1000)/100] + X[(n%100)/10] + I[n%10];
    }
    
     public String intToRoman(int num) {
        Map<Integer, String> map = init();
        String s = "";
        if (num < 10) {
            return map.get(num);
        }
        
        int th = num / 1000;
        if (th > 0) {
            s += map.get(th * 1000);
        }
        
        num -= th * 1000;
        
        int h = num / 100;
        if (h > 0) {
            s += map.get(h * 100);
        }
        
        num -= h * 100;
        
        int t = num / 10;
        if (t > 0) {
            s += map.get(t * 10);
        }
        
        num -= t*10;
        
        if (num > 0) {
            s += map.get(num);
        }
        return s;
    }
    
    private Map<Integer, String> init() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V"); 
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(20, "XX"); 
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX"); 
        map.put(90, "XC");
        map.put(100, "C");
        map.put(200, "CC");
        map.put(300, "CCC");
        map.put(400, "CD");
        map.put(500, "D"); 
        map.put(600, "DC");
        map.put(700, "DCC");
        map.put(800, "DCCC");
        map.put(900, "CM");
        map.put(1000, "M");
        map.put(2000, "MM"); 
        map.put(3000, "MMM");
        return map;
    }
}
