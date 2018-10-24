/**
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
                        
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
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null || (root.left == null && root.right == null)){
            return;
        }
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorder(list, root);
        for (int i=0; i<list.size()-1; i++){
            TreeNode n1 = list.get(i);
            TreeNode n2 = list.get(i+1);
            n1.left = null;
            n1.right = n2;
        }
       // return root;
    }
    
    public void preorder(List<TreeNode> list, TreeNode root){
        list.add(root);
        if (root.left != null){
            preorder(list, root.left);
        }
        if (root.right != null){
            preorder(list, root.right);
        }
    }
}
