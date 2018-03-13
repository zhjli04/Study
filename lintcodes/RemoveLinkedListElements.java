/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5


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
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        if (head == null){
            return null;
        }
        
        if (head.next == null && head.val == val){
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode cur = head;
        
        while(cur != null){
            if (cur.val != val){
                pre = cur;
                cur = cur.next;
            }else{
                ListNode node = cur.next;
                cur = node;
                pre.next = cur;
            }
        }
        return dummy.next;
    }
}
