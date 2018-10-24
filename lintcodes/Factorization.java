public class Solution {
    /**
     * A non-negative numbers can be regarded as product of its factors.
Write a function that takes an integer n and return all possible combinations of its factors.

 Notice
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combination.

Example
Given n = 8
return [[2,2,2],[2,4]]
// 8 = 2 x 2 x 2 = 2 x 4.

Given n = 1
return []

Given n = 12
return [[2,6],[2,2,3],[3,4]]

     * @param n: An integer
     * @return: a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here
   /*     List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        getFactorsHelper(n,2,current,result);
        return result;*/
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
         if (n <= 1) {
             return result;
         }
         List<Integer> list = new ArrayList<>();
         helper(result, list, n, 2);
         return result;
    }
    
    public void getFactorsHelper(int n,int start,List<Integer> current, List<List<Integer>> result){
        if(n<=1 && current.size()>1){
            result.add(new ArrayList<>(current));
            return;

        }
        for(int i=start;i<=n;i++){

            if(n%i==0) {
                current.add(i);
                getFactorsHelper(n/i,i,current,result);
                current.remove(current.size()-1);
            }            

        }

    }
    
    public void helper (List<List<Integer>> result, List<Integer> list, int n, int index) {
        if (index <= 1){
            return;
        }
        for (int i = index; i <= (int)Math.sqrt(n) ; i++) {
            if (n % i == 0 && n / i >= i) {
                list.add(i);
                list.add(n / i);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                helper(result, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
        
    }
}
