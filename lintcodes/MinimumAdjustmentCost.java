public class Solution {
    /*
    Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

Example
Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

Return 2.

     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
         if (A == null || A.size() == 0) {
            return 0;
        }
        
        // D[i][v]: 把index = i的值修改为v，所需要的最小花费
 /*       int[][] D = new int[A.size()][101];
        
        int size = A.size();
        
        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= 100; j++) {
                D[i][j] = Integer.MAX_VALUE;
                if (i == 0) {
                    // The first element.
                    D[i][j] = Math.abs(j - A.get(i));
                } else {
                    for (int k = 1; k <= 100; k++) {
                        // 不符合条件 
                        if (Math.abs(j - k) > target) {
                            continue;
                        }
                        
                        int dif = Math.abs(j - A.get(i)) + D[i - 1][k];
                        D[i][j] = Math.min(D[i][j], dif);
                    }
                }
            }
        }
        
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            ret = Math.min(ret, D[size - 1][i]);
        }
        
        return ret;*/
        
        int[][] dp = new int[A.size() + 1][101];  
        for (int i = 1; i <= A.size(); i++) {  
            for (int j = 0; j < 101; j++) {  
                dp[i][j] = Integer.MAX_VALUE;  
                int upper = Math.min(100, j + target);  
                int lower = Math.max(0, j - target);  
                for (int k = lower; k <= upper; k++) {  
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(j - A.get(i - 1)));  
                }  
            }  
        }  
        int res = Integer.MAX_VALUE;  
        for (int i = 0; i < 101; i++) {  
            res = Math.min(res, dp[A.size()][i]);  
        }  
        return res;  
    }
}
