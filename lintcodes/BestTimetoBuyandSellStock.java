public class Solution {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example
Given array [3,2,3,1,2], return 1.

     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length <= 1){
            return 0;
        }
        
        int min = prices[0];
        int max = prices[1];
        int profit = max-min;
        profit =  profit > 0 ? profit : 0;
        if (prices.length == 2){
            return profit ;
        }
        
        for (int i=3; i<prices.length; i++){
            if (prices[i] > max){
                max = prices[i];
                min = min(prices, 0, i-1);
                int s = max - min;
                if (s > profit){
                    profit = s;
                }
            }
            
            if ((i < prices.length-1) && (prices[i] < min)){
                min = prices[i];
                max = prices[i+1];
                int s = max - min;
                if (s > profit){
                    profit = s;
                }
                i+=2;
            }
        }
        return profit;
    }
    
    public int min(int[] nums, int start, int end){
        int m = nums[start];
        for (int i=start+1; i<=end; i++){
            if (nums[i] < m){
                m = nums[i];
            }
        }
        return m;
    }
}
