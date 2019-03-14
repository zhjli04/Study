/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null){
            return true;
        }
        
        if (s != null && t != null && s.length() != t.length()){
            return false;
        }
        
        int [] ss = new int[256];
        int [] tt = new int[256];
        
        for (int i=0; i <s.length(); i++){
            ss[s.charAt(i)] += 1;
            tt[t.charAt(i)] += 1;
        }
        
        for (int i=0; i<256; i++){
            if (ss[i] != tt[i]){
                return false;
            }
        }
        return true;
    }
}
