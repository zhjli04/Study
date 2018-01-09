public class Solution {
    /*
    Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
Example
Given S = "rabbbit", T = "rabbit", return 3.


If S=rabb T=ra, there is only one subsequence of S equal to T: ra *.
If S=rabb T=rab, there are two distinct subsequence of S equal to T: ra * b and rab *.
If S=rsabb T=rab, there are two distinct subsequence of S equal to T: r * a * b and r * ab *.
If S=rarab T=ra, there are three distinct subsequence of S equal to T: ra *, * ra *, and r * a *.



     * @param : A string
     * @param : A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
          if (T.length() == 0)
	        return 1;
	        
	    int[] counts = new int[T.length()];
	    for (int indexS = 0; indexS < S.length(); indexS++) {
	        char charS = S.charAt(indexS);
	        for (int indexT = T.length() - 1; indexT >= 0; indexT--) {
	            if (T.charAt(indexT) == charS) {
	                if (indexT == 0)
	                    counts[0]++;
	                else
	                    counts[indexT] += counts[indexT-1];
	            }
	        }
	    }
	    
	    return counts[counts.length-1];
    }
};
