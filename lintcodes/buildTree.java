/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Medium

1749

50

Favorite

Share
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie ) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[ps]);
        int ipos = is;
        for (; ipos <= ie; ipos++ ) {
            if (inorder[ipos] == preorder[ps]) {
                break;
            }
        }
        
        int len = ipos - is;
        node.left = build(preorder, ps+1, ps+len, inorder, is, ipos-1);
        node.right = build(preorder, ps+len+1, pe, inorder, ipos+1, ie);
        return node;
    }
}
