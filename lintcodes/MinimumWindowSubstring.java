public class Solution {
    /**
     * Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

 Notice
If there is no such window in source that covers all characters in target, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

Clarification
Should the characters in minimum window has the same order in target?

Not necessary.
Example
For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"

     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    int left = 0;
    int minLen = Integer.MAX_VALUE;
    boolean find = false;
    public String minWindow(String source , String target) {
        // write your code here
        if (source == null || source.length() == 0 || target == null || target.length() == 0){
            return "";
        }
        
        Map<Character, Integer> tmap = new HashMap<Character, Integer>();
        for (int i=0; i<target.length(); i++){
            char c = target.charAt(i);
            if (tmap.containsKey(c)){
                tmap.put(c, tmap.get(c) + 1);
            }else{
                tmap.put(c, 1);
            }
        }
        
        for (int i=0; i<=source.length()-target.length(); i++){
            if (!tmap.containsKey(source.charAt(i))){
                continue;
            }
            
            process(source, i, tmap, target.length());
        }
        
        if (!find){
            return "";
        }
        return source.substring(left, left+minLen);
    }
    
    public void process(String s, int start, Map<Character, Integer> tmap, int size){
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=start; i<s.length(); i++){
            char c = s.charAt(i);
            if (tmap.containsKey(c)){
                if (!map.containsKey(c)){
                    map.put(c, 1);
                    count++;
                }else{
                    if (map.get(c) < tmap.get(c)){
                        map.put(c, map.get(c) + 1);
                        count++;
                    }
                }
                if (count == size){
                    find = true;
                    if (i - start + 1 < minLen){
                        minLen = i - start + 1;
                        left = start;
                    }
                }
            }
        }
    }
}
