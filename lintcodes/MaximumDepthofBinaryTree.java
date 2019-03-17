/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
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
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return 1 + Math.max(maxLeft, maxRight);
        
    /*    Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 0;
        int max = 0;
        while(q.size() > 0){
            level++;
            if (level > max){
                max = level;
            }
            
            int size = q.size();
            for (int i=0; i<size; i++){
                TreeNode n = q.poll();
                if (n.left != null){
                    q.offer(n.left);
                }
                if (n.right != null){
                    q.offer(n.right);
                }
            }
        }
        return max;
        */
    }
}
