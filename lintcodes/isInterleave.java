/*
97. Interleaving String
Hard

786

36

Favorite

Share
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
*/
class Solution {
       public boolean is_Interleave(String s1,int i,String s2,int j,String res,String s3)
    {
        if(res.equals(s3) && i==s1.length() && j==s2.length())
            return true;
        boolean ans=false;
        if(i<s1.length())
            ans|=is_Interleave(s1,i+1,s2,j,res+s1.charAt(i),s3);
        if(j<s2.length())
            ans|=is_Interleave(s1,i,s2,j+1,res+s2.charAt(j),s3);
        return ans;

    }
    public boolean isInterleave(String s1, String s2, String s3) {
       // return is_Interleave(s1,0,s2,0,"",s3);
        
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) 
                    || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
        
   /*       if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) 
                        || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
        
        */
        
      /*   int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while (p3 < s3.length() && p1 < s1.length() && p2 < s2.length()) {
            if (s3.charAt(p3) != s1.charAt(p1) 
                && s3.charAt(p3) != s2.charAt(p2)) {
               return false;
            }
            
            if (s3.charAt(p3) == s1.charAt(p1) 
                && s3.charAt(p3) != s2.charAt(p2)) {
                p1++;
                p3++;
                continue;
            }
            
            if (s3.charAt(p3) != s1.charAt(p1) 
                && s3.charAt(p3) == s2.charAt(p2)) {
                p2++;
                p3++;
                continue;
            }
            
            int pp1 = p1;
            int pp2 = p2;
            while (pp1 < s1.length() 
                   && pp2 < s2.length() 
                   && p3 < s3.length() 
                   && s3.charAt(p3) == s1.charAt(pp1) 
                   && s3.charAt(p3) == s2.charAt(pp2)) {
                pp1++;
                pp2++;
                p3++;
            }
            
            if (pp1 < s1.length() 
                   && p3 < s3.length() && s3.charAt(p3) == s1.charAt(pp1)) {
                p1 = pp1;
                p1++;
                p3++;
                continue;
            }
            
             if (pp2 < s2.length() 
                   && p3 < s3.length() && s3.charAt(p3) == s2.charAt(pp2)) {
                p2 = pp2;
                p2++;
                p3++;
                continue;
            }
        }
        
        while (p1 < s1.length() && p3 < s3.length()) {
        	if (s1.charAt(p1) != s3.charAt(p3)) {
        		return false;
        	}
        	p1++;
        	p3++;
        }
        
        while (p2 < s2.length() && p3 < s3.length()) {
        	if (s2.charAt(p2) != s3.charAt(p3)) {
        		return false;
        	}
        	p2++;
        	p3++;
        }
        
        return p3 == s3.length() && p1 == s1.length() && p2 == s2.length();
        */
    }
}
