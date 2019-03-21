/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        
        int row = triangle.size();
	     int [] sum = new int[triangle.get(row-1).size()];
         List<Integer> list = triangle.get(row-1);
         for (int j=0; j<list.size(); j++) {
             sum[j] = list.get(j);
         }
        
         for (int i=row-2; i>=0; i--){
            List<Integer> li = triangle.get(i);
            for (int j=0; j<i+1; j++){
                int cur = li.get(j);
                if (sum[j] < sum[j+1]) {
	            		sum[j] = cur + sum[j];
	            	}else {
	            		sum[j] = cur + sum[j+1];
	            	}
            }
        }
        return sum[0];
	    /*
        int col = triangle.get(row-1).size();
        int [][] sum = new int[row][col];
	        for (int j=0; j<row; j++) {
	        	 List<Integer> list = triangle.get(row-1);
	        	 sum[row-1][j] = list.get(j);
	        }
        for (int i=row-2; i>=0; i--){
            List<Integer> list = triangle.get(i);
            for (int j=0; j<i+1; j++){
                int cur = list.get(j);
                if (sum[i+1][j] < sum[i+1][j+1]) {
	            		sum[i][j] = cur + sum[i+1][j];
	            	}else {
	            		sum[i][j] = cur + sum[i+1][j+1];
	            	}
            }
        }
        return sum[0][0];
	*/
    }
}
