/*
107. Binary Tree Level Order Traversal II
Easy

741

138

Favorite

Share
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        visit(ans, nodes);
        return ans;
    }
    
    public void visit(List<List<Integer>> ans, LinkedList<TreeNode> nodes) {
        if (nodes.size() == 0) {
            return;
        }
        
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        while (nodes.size() > 0) {
            TreeNode node = nodes.poll();
            list.add(node.val);
            if (node.left != null) {
                next.offer(node.left);
            }
            if (node.right != null) {
                next.offer(node.right);
            }
        }
        ans.add(0, list);
        visit(ans, next);
    }
}
