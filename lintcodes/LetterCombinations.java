/* Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
class Solution {
    
        public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        
        List<String> list = new ArrayList<>();
        for (int i=0; i<digits.length(); i++) {
            char c = digits.charAt(i);
            switch (c){
                case '2':
                    list.add("abc");
                    break;
                case '3':
                    list.add("def");
                    break;
                case '4':
                    list.add("ghi");
                    break;
                case '5':
                    list.add("jkl");
                    break;
                case '6':
                    list.add("mno");
                    break;
                case '7':
                    list.add("pqrs");
                    break;
                case '8':
                    list.add("tuv");
                    break;
                case '9':
                    list.add("wxyz");
                    break;
            }
        }
        
        List<String> res = new ArrayList<>();
        if (list.size() == 0) {
            return res;
        }
        
        if (list.size() == 1) {
            String s = list.get(0);
            for (int i=0; i<s.length(); i++) {
                res.add(String.valueOf(s.charAt(i)));
            }
            return res;
        }
        return combine(list, 0);
    }
    
    public List<String> combine(List<String> list, int start) {
        if (list.size() - start == 2) {
            return combinetwo(list, start);
        }
        
         List<String> res = new ArrayList<>();
	        String cur = list.get(start);
	        for (int j=0; j<cur.length(); j++) {
	               String c = String.valueOf(cur.charAt(j));
	               List<String> next = combine(list, start+1);
	               for (String s : next) {
	                   res.add(c+s);
	               }
	        }
        return res;
    }
    
    public List<String> combinetwo(List<String> list, int start) {
        String one = list.get(start);
        String two = list.get(start+1);
        List<String> res = new ArrayList<>();
        
        for (int i=0; i<one.length(); i++) {
            String c = String.valueOf(one.charAt(i));
            for (int j=0; j<two.length(); j++) {
                res.add(c + String.valueOf(two.charAt(j)));
            }
        }
        return res;
    }
}
