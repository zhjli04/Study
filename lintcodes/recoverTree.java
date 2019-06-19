/*
99. Recover Binary Search Tree
Hard

777

47

Favorite

Share
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
  
如果将这个二叉树按照中序遍历，那么遍历完了之后得到的序列，是一个递增序列，如果将其中两个结点交换位置，那么此时的中序遍历必然不是一个递增序列，而是其中一个结点大于两边的数，其中一个结点小于两边的数，这两个结点就是被交换的两个结点。如将[1,...,i,...,j,...,n]换成[1,...,j,...,i,...,n]，其中 j 大于两边的数，i 小于两边的数。

所以要找到这两个结点也是比较容易的，中序遍历交换过的二叉树，根据上面的描述，找到两个被交换的结点，然后将结点的值相互交换，便可以得到原来的二叉搜索树。
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
    TreeNode fir, sec, pre;
    public void recoverTree(TreeNode root) {
        trav(root);
        int tmp = fir.val;
        fir.val = sec.val;
        sec.val = tmp;
    }
    
    public void trav(TreeNode node) {
        if (node == null) {
            return;
        }
        trav(node.left);
        if (pre != null && pre.val > node.val) {
            if (fir == null) {
                fir = pre;
            }
            sec = node;
        }
        
        pre = node;
        trav(node.right);
    }
}
