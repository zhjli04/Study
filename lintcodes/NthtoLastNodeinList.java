/**
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
    Find the nth to last element of a singly linked list. 

The minimum number of nodes in list is n.

Example
Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.


     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null || n <= 0){
            return null;
        }
        
        ListNode first = head;
        ListNode sec = head;
        
        for (int i=0; i<n-1; i++){
            first = first.next;
            if (first == null){
               return null;
            }
        }
        
        while((first != null) && (first.next != null)){
            first = first.next;
            sec = sec.next;
        }
        return sec;
    }
}
