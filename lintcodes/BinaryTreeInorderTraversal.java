/**
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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
         if (root == null){
            return null;
        }
        List<Integer> ret = new ArrayList<Integer>();
        inVisit(root, ret);
        return ret;
    }
    
    public void inVisit(TreeNode root, List<Integer> ret){
        if (root.left != null){
            inVisit(root.left, ret);
        }
        ret.add(root.val);
        if (root.right != null){
            inVisit(root.right, ret);
        }
    }
}
