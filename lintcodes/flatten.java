/*
114. Flatten Binary Tree to Linked List
Medium

1494

192

Favorite

Share
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flat(root);
    }
    
    public TreeNode flat(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode left = flat(root.left);
        TreeNode right = flat(root.right);
        if (left != null) {
            root.right = left;
            TreeNode node = left;
            while (node != null && node.right != null) {
                node = node.right;
            }
            node.right = right;
        }else{
            root.right = right;
        }
        root.left = null;
        return root;
    }
}
