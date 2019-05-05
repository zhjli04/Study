/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        int pos = 0;
        while (pos < n) {
            first = first.next;
            pos++;
        }
        
        if (first == null) {
            return head.next;
        }
        
        while (first != null && first.next != null) {
            first = first.next;
            second = second.next;
        }
        
        ListNode del = second.next;
        if (del != null) {
            second.next = del.next;
        }else{
            second.next = null;
        }
        del = null;
        return head;
    }
}
