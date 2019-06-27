/*
128. Longest Consecutive Sequence
Hard

1898

92

Favorite

Share
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int lon = 1;
                int cur = num;
                while (set.contains(cur + 1)) {
                    lon++;
                    cur = cur+1;
                }
                
                longest = longest > lon ? longest : lon;
            }
        }
        return longest;
    }
}
