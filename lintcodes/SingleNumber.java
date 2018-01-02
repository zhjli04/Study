import java.util.Map;
import java.util.HashMap;
public class Solution {
    /**
     * Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
      *@param A : an integer array
      *return : a integer 
      * 
      * Example
Given [1,2,2,1,3,4,3], return 4
      */
    public int singleNumber(int[] A) {
        // Write your code here
        if (A == null || A.length == 0){
            return 0;
        }
        int res = 0;
        for (int val : A){
            res = res ^ val;
        }
        return res;
        
  /*      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int val : A){
            if (map.containsKey(val)){
                map.remove(val);
            }else{
                map.put(val, val);
            }
        }
        
        
        return (int)map.get(map.keySet().iterator().next());
        */
    }
}
