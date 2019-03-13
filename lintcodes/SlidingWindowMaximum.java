/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0){
            return new int[0];
        }
        
        if (nums.length <= k){
            return findMax(nums);
        }
        
        int res[] = new int[nums.length - k + 1];
        int pos = 0;
        LinkedList ll = new LinkedList();
        for (int i=0; i< nums.length; i++){
            if (i >= k && (int)ll.peekLast() <= (i - k)){
                ll.pollLast();
            }
            
            while(ll.size() > 0 && nums[(int)ll.peek()] < nums[i]){
                ll.poll();
            }
            ll.push(i);
            if (i >= k-1){
              res[pos++] = nums[(int)ll.peekLast()];
            }
        }
        return res;
        
    }
    
    public int[] findMax(int[] nums){
        int [] res = new int[1];
        res[0] = nums[0];
        for (int i=0; i<nums.length; i++){
            if (res[0] < nums[i]){
                res[0] = nums[i];
            }
        }
        return res;
    }
