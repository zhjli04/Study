/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int limitUp = 0;
        int limitDown = matrix.length-1;
        
        int limitRight = matrix[0].length-1;
        int limitLeft = 0;
        
        
        int total = matrix[0].length * matrix.length;
        
        int l=0,c = 0;
        
        for(int i=1; i<=total; i++){
        	
        	res.add( matrix[l][c]);
        	
        	if( l == limitUp && c< limitRight) { c++; continue; }
        	if( c== limitRight && l< limitDown) { l++; continue;}
        	if(l== limitDown && c > limitLeft) { c--; continue;}
        	
        	if(c==limitLeft) { l--;if(l != limitUp) continue;}
        	
        	if(l==limitUp) {
        		limitUp++;
        		limitDown--;
        		limitLeft++;
        		limitRight--;
        	}
        	l++;c++;
        }
        
        return res;
    }
}
