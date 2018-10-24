/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Example
Given binary tree {3,9,20,#,#,15,7}

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
Return its vertical order traversal as:
[[9],[3,15],[20],[7]]

Given binary tree {3,9,8,4,0,1,7}

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
Return its vertical order traversal as:
[[4],[9],[3,0,1],[8],[7]]

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
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root==null)
        return result;
 
    // level and list    
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
 
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    LinkedList<Integer> pos = new LinkedList<Integer>();
 
    queue.offer(root);
    pos.offer(0);
 
    int minPos=0;
    int maxPos=0;
 
    while(!queue.isEmpty()){
        TreeNode p = queue.poll();
        int l = pos.poll();
 
        //track min and max levels
        minPos=Math.min(minPos, l);
        maxPos=Math.max(maxPos, l);
 
        if(map.containsKey(l)){
            map.get(l).add(p.val);
        }else{
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(p.val);
            map.put(l, list);
        }
 
        if(p.left!=null){
            queue.offer(p.left);
            pos.offer(l-1);
        }
 
        if(p.right!=null){
            queue.offer(p.right);
            pos.offer(l+1);
        }
    }
 
 
    for(int i=minPos; i<=maxPos; i++){
        if(map.containsKey(i)){
            result.add(map.get(i));
        }
    }
 
    return result;
    }
}
