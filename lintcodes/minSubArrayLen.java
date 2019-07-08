/*
209. Minimum Size Subarray Sum
Medium

1165

75

Favorite

Share
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums[0] >= s) {
            return 1;
        }
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;//nums[0];
        for (int i=1; i<sum.length; i++) {
            if (nums[i-1] >= s) {
                return 1;
            }
            
            sum[i] = nums[i-1] + sum[i-1];
        }
        
        if (sum[sum.length-1] < s) {
            return 0;
        }
        
        int min = sum.length;
        for (int i=0; i<sum.length-1; i++) {
            for (int j=i+1; j<sum.length; j++) {
                    if (sum[j] - sum[i] >= s) {
                    int t = j - i ;
                    if (t < min) {
                        min = t;
                    }
                }
            }
        }
        return min;
    }
}
