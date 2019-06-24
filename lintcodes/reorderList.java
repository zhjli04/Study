/*
143. Reorder List
Medium

899

65

Favorite

Share
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        ListNode one = head;
        ListNode two = head;
        while (one != null && two != null && two.next != null && two.next.next != null) {
            one = one.next;
            two = two.next.next;
        }
        
        ListNode next = one.next;
        one.next = null;
        
        ListNode second = revert(next);
        
        ListNode cur = head;
        ListNode first = head.next;
        boolean f = false;
        while (first != null && second != null) {
            if (f) {
                cur.next = first;
                cur = cur.next;
                first = first.next;
            }else{
                cur.next = second;
                cur = cur.next;
                second = second.next;
            }
            f = !f;
        }
        
         while (first != null){
              cur.next = first;
              cur = cur.next;
              first = first.next;
         }
        
         while (second != null){
              cur.next = second;
              cur = cur.next;
              second = second.next;
         }
    }
    
    public ListNode revert(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
