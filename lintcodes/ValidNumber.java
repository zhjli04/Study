public class Solution {
    /**
     * Validate if a given string is numeric.
     * 
     * Example
"0" => true

" 0.1 " => true

"abc" => false

"1 a" => false

"2e10" => true

     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // write your code 
        if (s == null){
            return false;
        }
        
        s = s.trim();
        if (s.length() == 0){
           return false; 
        }
        if (s.length() == 1){
            return isInt(s.charAt(0));
        }
        
        char sc = s.charAt(0);
        if (sc != '+' && sc != '-' && sc !='.' && !isInt(sc)){
            return false;
        }
        
        char ec = s.charAt(s.length()-1);
        if (ec != '.' && !isInt(ec)){
            return false;
        }
        
        int dot = 0;
        int e = 0;
        
        int index = 0;
        if (sc == '+' || sc == '-' ){
            if (s.charAt(1) != '.' && !isInt(s.charAt(1))){
                return false;
            }
            index = 1;
        }
        
        if (sc == '.'){
            dot = 1;
            index = 1;
        }
        
        for (int i=index; i<s.length(); i++){
            char c = s.charAt(i);
            if (c == '.'){
                if (dot > 0 || e > 0){
                    return false;
                }
                dot = 1;
            }else if (c == 'e'){
                if (dot > 0 || e > 0){
                    return false;
                }
                e = 1;
            }else if (!isInt(c)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isInt(char c){
        return c == '0' || c == '1' || c == '2' || c == '3'
        || c == '4' || c == '5' || c == '6' || c == '7'
        || c == '8' || c == '9';
    }
}
