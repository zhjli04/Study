public class Solution {
    /*
    Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

Find it.
Example
Given [1, 2, 1, 2, 1, 3, 3], return 1.
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int size = nums.size();
        int max = (int)Math.ceil(size / 3.0);
        
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
