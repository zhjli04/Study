/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1){
            return;
        }
        int n = nums.length;
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i-1]) {
            i--;
        }
        i--;
        // for(i = n-1;i>0;i--){
        //     if(nums[i]>nums[i-1])
        //         break;
        // }
        // i--;
        
        int j = nums.length - 1;
        if (i >= 0){
            for (; j > i; j--){
                if (nums[j] > nums[i]) {
                    swap(nums, i , j);
                    break;
                }
            }
        }
        
       // i++;
        
        // for(j = i+1;j<=(n+i)/2;j++)
        //     swap(nums,j,n+i-j);
        i++;
        j = n-1;
        while (j > i) {
            swap(nums, i, j);
            i++;
            j--;
        }
        
    }
    
    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
