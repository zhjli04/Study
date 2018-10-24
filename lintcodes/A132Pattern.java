public class Solution {
    /**
     * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

n will be less than 20,000.

Example
Given nums = [1, 2, 3, 4]
return False // There is no 132 pattern in the sequence.

Given nums = [3, 1, 4, 2]
return True // There is a 132 pattern in the sequence: [1, 4, 2].


     * @param nums: a list of n integers
     * @return: true if there is a 132 pattern or false
     */
    public boolean find132pattern(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 3){
            return false;
        }
        
       int n = nums.length, top = n, third = Integer.MIN_VALUE;

    for (int i = n - 1; i >= 0; i--) {
        if (nums[i] < third) return true;
        while (top < n && nums[i] > nums[top]) {
          //  if (third < nums[top]){
                 
               third = nums[top++];
         //   }
        }
       // nums[--top] = nums[i];
       top--;
    }
    
    return false;
    }
    
}
