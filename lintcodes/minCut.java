/*
132. Palindrome Partitioning II
Hard

602

23

Favorite

Share
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int minCut(String s) {
        if (s.length() <= 1 || isPalin(s)) {
            return 0;
        }
        
        List<Integer> pos = new ArrayList<>();
        for (int i=1; i<s.length(); i++) {
             if (isPalin(s.substring(0, i))) {
                if (isPalin(s.substring(i))) {
                    return 1;
                }else{
                    pos.add(i);
                }
             }
        }
        
        int min = s.length() - 1 ;
        
        for (int idx : pos) {
            int num = 0;
            String str = s.substring(idx);
            if (map.get(str) == null) {
                num =  minCut(str);
                map.put(str, num);
                num += 1 ;
            }else{
                num = map.get(str) + 1;
            }
            
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    
    public boolean isPalin(String s) {
        int start = 0;
        int end = s.length() -1 ;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
