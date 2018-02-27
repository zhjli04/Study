/**
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null){
            return 0;
        }
        
        if ((root.left == null) && (root.right == null)){
            return 1;
        }
        
        if (root.left == null){
            return 1 + minDepth(root.right);
        }
        
        if (root.right == null){
            return 1 + minDepth(root.left);
        }
        
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
