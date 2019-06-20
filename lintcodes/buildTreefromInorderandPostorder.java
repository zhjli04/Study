/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Medium

873

19

Favorite

Share
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
        if (is > ie || ps > pe) {
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[pe]);
        int pos = is;
        for (; pos <= ie; pos++) {
            if (inorder[pos] == postorder[pe]) {
                break;
            }
        }
        
        int len = pos - is;
        node.left = build(inorder, is, is + len - 1, postorder, ps, ps+len - 1);
        node.right = build(inorder, pos+1, ie, postorder, ps + len, pe-1);
        return node;
    }
}
