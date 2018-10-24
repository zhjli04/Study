/**
 * iven a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example
For example,

   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null){
            return 1;
        }
        
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(root, 1);
        
        LinkedList<TreeNode> ls = new LinkedList<TreeNode>();
        ls.offer(root);
        
        while(!ls.isEmpty()){
            TreeNode node = ls.poll();
         //   LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
            int count = (int)map.get(node);
            if (node.left != null){
                TreeNode left = node.left;
                if (left.val == node.val + 1){
                    map.put(left, count+1);
                }else{
                    map.put(left, 1);
                }
                ls.offer(left);
            }
            
            if (node.right != null){
                TreeNode right = node.right;
                if (right.val == node.val + 1){
                    map.put(right, count+1);
                }else{
                    map.put(right, 1);
                }
                ls.offer(right);
            }
        }
        
        int max = 1;
        
        for (Map.Entry<TreeNode, Integer> entry: map.entrySet()){
            int value = entry.getValue();
            if (value > max){
                max = value;
            }
        }
        
        return max;
    }
}
