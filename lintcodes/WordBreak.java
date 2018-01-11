public class Solution {
    /*
    Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.
    Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".


     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
  /*       boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];*/
         if(s == null || s.length() == 0){
            return true;
        }
        int n = s.length();
        boolean [] dp = new boolean[n+1];
        dp[0] = true ;
        
        int maxLength = 0;
        for(String t : dict){
            maxLength = Math.max(maxLength, t.length());
        }
        
        for(int i = 1; i <= n; i++){
            dp[i] = false;
            for(int j = i-1; j >= Math.max(0, i - maxLength) && !dp[i]; j--){
                if(dp[j]){
                    if(dict.contains(s.substring(j, i))){
                        dp[i] = true;
                    }
                }
            }

        }
        
        return dp[n];
    }
}
