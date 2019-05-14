/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/
class Solution {
    public int trap(int[] height) {
         if (height == null || height.length <= 1) {
            return 0;
        }
        int maxIndex = 0;
        
        for (int i = 0; i < height.length; i++) {
            maxIndex = height[maxIndex] >= height[i] ? maxIndex : i;
        }
        
        int leftSum = 0;
        int rightSum = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        
        for (int j = 0; j < maxIndex; j++) {
            if (height[leftIndex] > height[j]) {
                leftSum +=  height[leftIndex] - height[j];
            } else {
                leftIndex = j;
            }
        } 
        
        for (int k = height.length -1 ; k > maxIndex; k --) {
            if (height[rightIndex] > height[k]) {
                rightSum += height[rightIndex] - height[k];
            } else {
                rightIndex = k;
            }
        }
        
        return leftSum+rightSum;
    }
}
