public class Solution {
    /*
    Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.

Find it.
Example
Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        int size = nums.size();
        int max = (int)Math.ceil(size / (double)k);
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (Integer i : nums){
            if (!map.containsKey(i)){
                map.put(i, 1);
            }else{
                int v = map.get(i);
                if (v + 1 >= max){
                    return i;
                }
                map.put(i, v+1);
            }
        }
        return nums.get(0);
    }
}
