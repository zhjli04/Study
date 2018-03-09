/**
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.

 Notice
A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.

Example
T2 is a subtree of T1 in the following case:

       1                3
      / \              / 
T1 = 2   3      T2 =  4
        /
       4
T2 isn't a subtree of T1 in the following case:

       1               3
      / \               \
T1 = 2   3       T2 =    4
        /
       4
       
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
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
       if (T2 == null){
           return true;
       }
       
       if (T1 == null){
           return false;
       }
       
       if (isEqual(T1, T2)){
           return true;
       }
       
       return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    
    public boolean isEqual(TreeNode n1, TreeNode n2){
         if (n1 == null && n2 == null){
            return true;
        }
        
        if (n1 == null || n2 == null){
            return false;
        }
        
        return (n1.val == n2.val) && (isEqual(n1.left, n2.left))
             && isEqual(n1.right, n2.right);
    }
}
