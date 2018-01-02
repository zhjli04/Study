public class Solution {
    /*
    Given 2*n + 2 numbers, every numbers occurs twice except two, find them.
    Example
Given [1,2,2,3,4,4,5,3] return 1 and 5

     * @param A: An integer array
     * @return: An integer array
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> ret = new ArrayList<Integer>();
        if (A == null || A.length < 2){
            return ret;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i : A){
            if (map.containsKey(i)){
                map.remove(i);
            }else{
                map.put(i, 0);
            }
        }
        
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            ret.add((Integer)it.next());
        }
        return ret;
    }
}
