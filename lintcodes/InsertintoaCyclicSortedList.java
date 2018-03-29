/**
 * Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be any single node in the list. Return the inserted new node.

 Notice
3->5->1 is a cyclic list, so 3 is next node of 1.
3->5->1 is same with 5->1->3

Example
Given a list, and insert a value 4:
3->5->1
Return 5->1->3->4

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
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here
        ListNode n = new ListNode(x);
        if (node == null){
            n.next = n;
            return n;
        }
        
        if (node.next == null || node.next == node){
            node.next = n;
            n.next = node;
            return node;
        }
        
        ListNode cur = node;
        while(cur.val <= cur.next.val){
            cur = cur.next;
            if (cur == node){
                break;
            }
        }
        
        ListNode next = cur.next;
        if (cur.val <= x || next.val >= x){
            cur.next = n;
            n.next = next;
            return next;
        }
        
        cur = next;
        while(cur.val <= x){
          next = cur.next;
          if (next.val >= x ){
              cur.next = n;
              n.next = next;
              return next;
          }
          cur = cur.next;
        }
      
        return null;
    }
}
