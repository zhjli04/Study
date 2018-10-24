public class Solution {
    /*
    Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.
    
    Example
Given [1,1,2,3,3,3,2,2,4,1] return 4
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumberII(int[] A) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i : A){
            if (!map.containsKey(i)){
                map.put(i, 1);
            }else {
                int v = map.get(i);
                if (v == 1){
                    map.put(i, 2);
                }else if (v == 2){
                    map.remove(i);
                }
            }
        }
        return map.keySet().iterator().next();
    }
}
