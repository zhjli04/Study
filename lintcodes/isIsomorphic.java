/*
205. Isomorphic Strings
Easy

770

220

Favorite

Share
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        
        map.put(s.charAt(0), t.charAt(0));
        used.add(t.charAt(0));
        
        for (int i=1; i<s.length(); i++) {
            char sc = s.charAt(i);
            char st = t.charAt(i);
            
            if (map.containsKey(sc)) {
                if (map.get(sc) != st) {
                    return false;
                }
            }else{
                if (used.contains(st)) {
                    return false;
                }else{
                    map.put(sc, st);
                    used.add(st);
                }
            }
        }
        return true;
    }
}
