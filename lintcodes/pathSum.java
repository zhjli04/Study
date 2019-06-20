/*
113. Path Sum II
Medium

911

34

Favorite

Share
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        List<Integer> list = new ArrayList<>();
        visit(res, root, sum, list);
        return res;
    }
    
    public void visit(List<List<Integer>> res, TreeNode node, int sum,  List<Integer> list) {
        if (node == null) {
            return;
        }
        
//         List<Integer> ll = new ArrayList<>();
//         if (list.size() > 0) {
//             ll.addAll(list);
//         }
        list.add(node.val);
        if (node.val == sum && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
            // list.remove(list.size()-1);
            // return;
        }
        visit(res, node.left, sum-node.val, list);
        visit(res, node.right, sum-node.val, list);
        list.remove(list.size()-1);
    }
}
