/*
110. Balanced Binary Tree
Easy

1265

112

Favorite

Share
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

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
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        boolean bal =  Math.abs(depth(root.left) - depth(root.right)) <= 1;
        if (!bal) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        if (node.left == null && node.right == null) {
            return 1;
        }
        
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
