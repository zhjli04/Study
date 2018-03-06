/**
 * Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
 * 
 * Example
Given binary search tree:

    5
   / \
  3   6
 / \
2   4
Remove 3, you can either return:

    5
   / \
  2   6
   \
    4
or

    5
   / \
  4   6
 /
2
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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null){
            return null;
        }
        
        if (root.val == value){
            if ((root.left == null) && (root.right==null)){
                return null;
            }
        }
        
        TreeNode node = find(root, value);
        if (node == null){
            return root;
        }
        
        if ((node.left == null) && (node.right == null)){
            node = null;
            return root;
        }
        
        if (node.left == null){
            copy(node, node.right);
        }else if (node.right == null){
            copy(node, node.left);
        }else{
            TreeNode[] reps = findRep(node.right);
	            if (reps[1] == null){
	                copy(node, reps[0]);
	            }else{
	              node.val = reps[1].val;
	              reps[0].left = null;
	             // rep = null;
	            }
        }
        return root;
    }
    
    public void copy(TreeNode node, TreeNode copy){
        node.val = copy.val;
        node.left = copy.left;
        node.right = copy.right;
    }
    
    public TreeNode find(TreeNode node, int value){
        if (node == null){
            return null;
        }
        
        if (node.val == value){
            return node;
        }
        
        if (node.val > value){
            return find(node.left, value);
        }
        return find(node.right, value);
    }
    
      public static  TreeNode [] findRep(TreeNode node){
	    	TreeNode[] ret  = new TreeNode[2];
	        TreeNode parent = node;
	        TreeNode cur = node.left;
	        if (cur != null){
	        	while(cur.left != null){
	        		parent = cur;
	        		cur = cur.left;
	        	}
	        }
	      
	        ret[0] = parent;
	        ret[1] = cur;
	        return ret;
	    }
}
