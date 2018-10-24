/**
 * Insert a node in a sorted linked list.
 * 
 * Example
Given list = 1->4->6->8 and val = 5.

Return 1->4->5->6->8.

 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        // write your code here
        ListNode node = new ListNode(val);
        if (head == null){
            return node;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        
        while((cur != null) && (cur.val <= val)){
            pre = cur;
            cur = cur.next;
        }
        
        pre.next = node;
        node.next = cur;
        return dummy.next;
    }
}
