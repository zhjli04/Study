/*
148. Sort List
Medium

1480

77

Favorite

Share
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        if (head.next.next == null) {
            if (head.val <= head.next.val) {
                return head;
            }
            
            ListNode n = head.next;
            head.next = null;
            n.next = head;
            return n;
        }
        
        ListNode one = head;
        ListNode two = head;
        while (one != null && two != null && two.next != null && two.next.next != null) {
            one = one.next;
            two = two.next.next;
        }
        
        ListNode next = one.next;
        one.next = null;
        
        ListNode first = sortList(head);
        ListNode second = sortList(next);
        return merge(first, second);
    }
    
    public ListNode merge( ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (first != null && second != null) {
            if (first.val <= second.val) {
                cur.next = first;
                cur = cur.next;
                first = first.next;
            }else{
                cur.next = second;
                cur = cur.next;
                second = second.next;
            }
        }
        
        while (first != null) {
            cur.next = first;
            cur = cur.next;
            first = first.next;
        }
        
        while (second != null) {
            cur.next = second;
            cur = cur.next;
            second = second.next;
        }
        return dummy.next;
    }
}
