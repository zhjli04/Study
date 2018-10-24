public class Solution {
    /*
    Count the number of k's between 0 and n. k can be 0 - 9.
    
    Example
if n = 12, k = 1 in

[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
we have FIVE 1's (1, 10, 11, 12)


     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        if (k > n){
            return 0;
        }
        
        if (n <= 9){
            return 1;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<=9; i++){
            map.put(i, 1);
        }
        
        for (int i=10; i<=n; i++){
            int s = i % 10;
            int count = map.get(s);
            map.put(s, count+1);
            
            int t = i / 10;
            while(t != 0){
                s = t % 10;
                count = map.get(s);
                map.put(s, count+1);
                t = t / 10;
            }
        }
        
        return map.get(k);
    }
};
