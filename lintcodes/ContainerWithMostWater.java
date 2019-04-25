/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 



The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/
class Solution {
    public int maxArea(int[] height) {
     /*   int max = 0;
        for (int i=0; i<height.length - 1; i++) {
            for (int j=i+1; j<height.length; j++) {
                int sum = 0;
                if (height[i] < height[j]) {
                    sum = height[i] * (j-i);
                }else{
                    sum = height[j] * (j-i);
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
        */
        
        int left = 0;
	int right = height.length - 1;
	int maxArea = 0;
	
	while(left < right){
	
		int diff = right - left;
		int minVal = Math.min(height[left],height[right]);
		int TotalWater = diff * minVal;
		maxArea = Math.max(maxArea,TotalWater);
		
		if(height[left] < height[right]){
			left++;
		}else{
			right--;
		}
	}
	return maxArea;
    }
}
