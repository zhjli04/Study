/*
103. Binary Tree Zigzag Level Order Traversal
Medium

976

60

Favorite

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        visit(ans, nodes, true);
        return ans;
    }
    
    public void visit(List<List<Integer>> ans, LinkedList<TreeNode> nodes, boolean order) {
        if (nodes.size() == 0) {
            return;
        }
        
        LinkedList<TreeNode> next = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (nodes.size() > 0) {
            TreeNode node = nodes.poll();
            if (order) {
                list.add(node.val);
            }else{
                list.add(0, node.val);
            }
            
            if (node.left != null) {
                next.offer(node.left);
            }
            
            if (node.right != null) {
                 next.offer(node.right);
            }
        }
        ans.add(list);
        visit(ans, next, !order);
    }
}
