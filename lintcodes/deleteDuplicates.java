/*
82. Remove Duplicates from Sorted List II
Medium

826

72

Favorite

Share
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                break;
            }
            
            if (cur.val != next.val) {
                pre = cur;
                cur = next;
                continue;
            }
            
            while (next.next != null && next.val == next.next.val) {
                next = next.next;
            }
            
            pre.next = next.next;
            cur = next.next;
        }
        return dummy.next;
    }
}
