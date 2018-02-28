/**
 * Given a linked list, return the node where the cycle begins.

If there is no cycle, return null.

 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        
        if (head == null || head.next == null){
            return null;
        }
        
        ListNode first = head;
        ListNode sec = head;
        
        Boolean isCycle = false;
        while((first != null) && (sec != null)){
            first = first.next;
            if (sec.next == null){
                return null;
            }
            sec = sec.next.next;
            if (first == sec){
                isCycle = true;
                break;
            }
        }
        
        if (!isCycle){
            return null;
        }
        
        first = head;
        while(first != sec){
            first = first.next;
            sec = sec.next;
        }
        return first;
    }
}
