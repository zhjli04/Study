/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums){
            if (!map.containsKey(i)){
                map.put(i, 1);
            }else{
                Integer c = map.get(i);
                if (c + 1 > nums.length / 2){
                    return i;
                }else{
                    map.put(i, c + 1);
                }
            }
        }
        return nums[0];
    }
}
