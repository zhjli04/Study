public class Solution {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example
Given an example n=3 , 1+1+1=2+1=1+2=3

return 3

     * @param n: An integer
     * @return: An integer
     */
     
     Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        // write your code here
        if (n <= 0){
            return 0;
        }
        
        if (n == 1){
            return 1;
        }
        
        if (n == 2){
            return 2;
        }
        
        if (map.containsKey(n)){
            return map.get(n);
        }
        
        int v = climbStairs(n-1) + climbStairs(n-2);
        map.put(n, v);
        return v;
    }
    
}
