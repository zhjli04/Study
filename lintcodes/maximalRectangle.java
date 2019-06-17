/*
85. Maximal Rectangle
Hard

1453

51

Favorite

Share
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
*/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int res = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                }else{
                    heights[j] += 1;
                }
            }
            res = Math.max(res, largestRec(heights));
        }
        return res;
    }
    
    public int largestRec(int[] hs) {
        int len = hs.length;
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for (int i=0; i<=len; i++) {
            while (!s.isEmpty() && (i==len || hs[s.peek()] > hs[i])) {
                int left = -1;
                int h = s.pop();
                if(!s.isEmpty()){
                    left = s.peek();
                }
                res = Math.max(res, (i-left-1)*hs[h]);
            }
            s.push(i);
        }
        return res;
    }
}
