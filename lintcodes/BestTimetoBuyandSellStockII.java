public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0){
            return 0;
        }
        
        if (prices.length == 1){
            return 0;
        }
        
        int buy = prices[0];
        int profit = 0;
        int sum = 0;
        
        for (int i=1; i<prices.length; i++){
            if (prices[i] < prices[i-1]){
                buy = prices[i];
                profit += sum;
                sum = 0;
            }
            
            if (prices[i] > prices[i-1]){
                sum = prices[i] - buy;
            }
        }
        
        profit += sum;
        
        return profit;
        
    }
}
