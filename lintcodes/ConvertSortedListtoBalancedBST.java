/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Example
               2
1->2->3  =>   / \
             1   3
             
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if (head == null){
            return null;
        }
        
        if (head.next == null){
            return new TreeNode(head.val);
        }
        
        ListNode pos = head;
        ListNode twice = head;
        
        while((twice != null) && (twice.next !=null)){
            twice = twice.next.next;
            pos = pos.next;
        }
        
        ListNode cur = head;
        
        while(cur.next != pos){
            cur = cur.next;
        }
        cur.next = null;
        
        TreeNode root = new TreeNode(pos.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(pos.next);
        return root;
    }
}
