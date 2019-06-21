/*
119. Pascal's Triangle II
Easy

484

167

Favorite

Share
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
      
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        res.add(one);
        
        for (int i=1; i<=rowIndex; i++) {
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
        return res.get(rowIndex);
    }
}
