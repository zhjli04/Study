public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0){
            return 0;
        }
        
        if (height.length == 1){
            return height[0];
        }
        
        int max = height[0];
        
        for (int i=0; i<height.length; i++){
            int left = i;
            int right = i;
            while((left >= 0) && (height[left] >= height[i])){
                left--;
            }
            
            while((right < height.length) && (height[right] >= height[i])){
                right++;
            }
            
            int sum = height[i] * (right - left - 1);
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }
}
