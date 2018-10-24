public class Solution {
    /*
    Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)
    
    Example
Give [-3, 1, 3, -3, 4], return [1,4].


     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySum(int[] A) {
        // write your code here
        List<Integer> list = new ArrayList<Integer>();
        if (A == null || A.length == 0){
            return list;
        }
        if (A.length == 1){
            list.add(0);
            list.add(0);
            return list;
        }
        
        int s = 0;
        int e = 0;
        int ss = 0;
        
        int minSum = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<A.length; i++){
            if (minSum > sum){
                minSum = sum;
                ss = i;
            }
            
            sum += A[i];
            
            if (sum - minSum > max){
                max = sum - minSum;
                e = i;
                if (ss <= i){
                    s = ss;
                }
            }
            
            
            
            // if (sum < 0){
            //     s = i;
            //  /*   if (sum > sum - A[i]){
                    
            //       ss = i;
            //     }else{
            //         ss = i + 1;
            //     }*/
            //     sum = 0;
            // }
            // if (sum > max){
            //     max = sum;
            //     e = i;
            //   //  s = ss;
            // }
        }
        list.add(s);
        list.add(e);
        return list;
    }
}
