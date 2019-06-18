/*
95. Unique Binary Search Trees II
Medium

1248

113

Favorite

Share
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            build(res, i, 1, n);
        }
        return res;
    }
    
    public void build(List<TreeNode> res, int root, int min, int max) {
        if (min > max) {
            return;
        }
        if (max == min) {
            TreeNode rn = new TreeNode(root);
            res.add(rn);
            return;
        }
        
        List<TreeNode> left = new ArrayList<>();
        for (int i=min; i<root; i++) {
            build(left, i, min, root-1);
        }
        
        List<TreeNode> right = new ArrayList<>();
        for (int i=root+1; i<=max; i++) {
            build(right, i, root+1, max);
        }
        
        if (left.size() == 0) {
            for (TreeNode node : right) {
                TreeNode tn = new TreeNode(root);
                tn.right = node;
                res.add(tn);
            }
            return;
        }
        
        if (right.size() == 0) {
            for (TreeNode node : left) {
                TreeNode tn = new TreeNode(root);
                tn.left = node;
                res.add(tn);
            }
            return;
        }
        
        for (TreeNode ln : left) {
            for (TreeNode rn : right) {
                TreeNode tn = new TreeNode(root);
                tn.left = ln;
                tn.right = rn;
                res.add(tn);
            }
        }
        
    }
}
