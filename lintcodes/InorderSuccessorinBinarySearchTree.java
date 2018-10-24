/**
 * Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.

example
Given tree = [2,1] and node = 1:

  2
 /
1
return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3
return node 3.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    List<TreeNode> nodes = new ArrayList<TreeNode>();
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null){
            return null;
        }
        
        inorder(root);
        for (int i=0; i<nodes.size(); i++){
            if (nodes.get(i) == p){
                if (i < nodes.size() -1 ){
                    return nodes.get(i+1);
                }
            }
        }
        return null;
    }
    
    public void inorder(TreeNode root){
        if (root.left != null){
           inorder(root.left);
        }
        nodes.add(root);
        if (root.right != null){
            inorder(root.right);
        }
    }
    
}
