/*
229. Majority Element II
Medium

902

111

Favorite

Share
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        
        Arrays.sort(nums);
        int count = 1;
        int len = nums.length;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            }else{
                if (count * 3 > len) {
                     ret.add(nums[i-1]);
                }
                count = 1;
            }
        }
        
        if (count * 3 > len) {
            ret.add(nums[len-1]);
        }
        return ret;
    }
}
