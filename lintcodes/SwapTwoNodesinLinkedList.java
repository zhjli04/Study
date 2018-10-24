/**
 * Given a linked list and two values v1 and v2. Swap the two nodes in the linked list with values v1 and v2. It's guaranteed there is no duplicate values in the linked list. If v1 or v2 does not exist in the given linked list, do nothing.
 * 
 * Example
Given 1->2->3->4->null and v1 = 2, v2 = 4.

Return 1->4->3->2->null.

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
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode node = head;
        ListNode first = null;
        ListNode sec = null;
        
        while(node != null){
            if (node.val == v1){
                first = node;
            }
            
            if (node.val == v2){
                sec = node;
            }
            
            node = node.next;
        }
        
        if (first!=null && sec!=null){
            int t = first.val;
            first.val = sec.val;
            sec.val = t;
        }
        return head;
    }
}
