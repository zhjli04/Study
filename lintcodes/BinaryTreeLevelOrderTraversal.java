/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null){
            return res;
        }
        
      
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.offer(root);
        while(list.size() > 0){
             List<Integer> ll = new ArrayList<Integer>();
             LinkedList<TreeNode> nl = new LinkedList<TreeNode>();
             while(list.size() > 0){
                   TreeNode node = list.poll();
                   ll. add(node.val);
                   if (node.left != null){
                      nl.offer(node.left);
                   }
                   if (node.right != null){
                     nl.offer(node.right);
                   }
             }
             res.add(ll);
             list = nl;
        }
        return res;
    }
}
