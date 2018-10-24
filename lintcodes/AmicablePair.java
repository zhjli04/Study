public class Solution {
    /*
    An amicable pair (m,n) consists of two integers m,n for which the sum of proper divisors (the divisors excluding the number itself) of one number equals the other.

Given an integer k, find all amicable pairs between 1 and k.

Example
Given 300, return [[220, 284]].


     * @param k: An integer
     * @return: all amicable pairs
     */
    public List<List<Integer>> amicablePair(int k) {
        // write your code here
     /*   List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < k; i++){
            for (int j = i + 1; j <= k; j++){
                if (isAmicable(i, j)){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;*/
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for (int i = 1; i <= k; i++) {
            int second = sumDivisor(i);
            if (second > k) {
                continue;
            }
            
            int first = sumDivisor(second);
            if(first == i && first < second) {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(first);
                pair.add(second);
                
                list.add(pair);
            }
        }
        
        return list;
    }
    
    public int sumDivisor(int n) {
        int sum = 1, i;
        for (i = 2; i * i < n; ++i) {
            if (n % i == 0) {
                sum += i + n / i;
            }
        }
        if (i * i == n) {
            sum += i;
        }
        return sum;
    }
    
    int sumOfDiv(int x)
    {
         
        // 1 is a proper divisor
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                sum += i;
 
                // To handle perfect squares
                if (x / i != i)
                    sum += x / i;
            }
        }
         
        return sum;
    }
 
    // Check if pair is amicable
     boolean isAmicable(int a, int b)
    {
        return (sumOfDiv(a) == b && sumOfDiv(b) == a);
    }
}
