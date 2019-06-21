/*
118. Pascal's Triangle
Easy

726

79

Favorite

Share
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        
        List<Integer> one = new ArrayList<>();
        one.add(1);
        res.add(one);
        
        for (int i=1; i<numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> pre = res.get(i-1);
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }else{
                    list.add(pre.get(j-1) + pre.get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}
