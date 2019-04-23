/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        
        if (k >count) {
           return head;
        }
        
        int pos = 0;
        node = head;
        ListNode pre = head;
        ListNode dummy = new ListNode(0);
        ListNode nnn = dummy;
        nnn.next = head;
        while (node != null) {
            pos++;
            if (pos % k == 0 ) {
                ListNode next = node.next;
                ListNode ln = revert(pre, node);
                nnn.next = ln;
                nnn = pre;
                node = next;
                pre = next;
            }else{
                node = node.next;
            }
        }
        nnn.next = pre;
        return dummy.next;
    }
    
    private ListNode revert(ListNode head, ListNode end) {
        ListNode pre = null;
        ListNode cur = head;
        
        while (cur != null && cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return cur;
    }
    
}
