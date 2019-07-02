/*
173. Binary Search Tree Iterator
Medium

1404

246

Favorite

Share
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

 

Example:



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 

Note:

next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
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
class BSTIterator {

    TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) {
            return root.val;
        }
        
        if (root.left != null){
            return next(root, root.left);
        }
        
        int val = root.val;
        if (root.right == null) {
            root = null;
        }else{
            root = root.right;
        }
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (root == null) {
            return false;
        }
        return true;
    }
    
    public int next(TreeNode parent, TreeNode node) {
        TreeNode pre = parent;
        TreeNode cur = node;
        while (cur != null && cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        
        pre.left = cur.right;
        return cur.val;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
