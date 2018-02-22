/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 
 * Example
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
    /*
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next = cur.next;
        
        while(next != null){
            if (cur.val == next.val){
                while((next != null) && (cur.val == next.val)){
                    next = next.next;
                }
                
                if (next == null){
                    pre.next = null;
                    break;
                }else{
                    cur = next;
                    pre.next = cur;
                    next = next.next;
                }
            }else{
                pre = cur;
                cur = next;
                next = next.next;
            }
            
        }
        return dummy.next;
    }
}
