/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.


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
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        
    /*    int ml = minDepth(root.left);
        int mr = minDepth(root.right);
        if (ml == 0 || mr == 0){
            return ml + mr + 1;
        }
        return 1 + Math.min(ml, mr);
   */     
        int min = 0;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.offer(root);
        while(list.size() > 0){
            min++;
            int size = list.size();
            for (int i=0; i<size; i++){
                TreeNode n = list.poll();
                if (n.left==null && n.right==null){
                    return min;
                }
                if (n.left != null){
                    list.offer(n.left);
                }
                if (n.right != null){
                    list.offer(n.right);
                }
            }
        }
        return min;
        
    }
}
