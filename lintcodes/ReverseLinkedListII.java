/**
 * Reverse a linked list from position m to n.
 * Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

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
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (m >= n){
            return head;
        }
        
        if (m == 1){
            ListNode node = reverse(head, n - m + 1);
            return node;
        }
        
        ListNode cur = head;
        ListNode next = cur.next;
        int count = 2;
        
        while(next != null){
            if (count == m){
               ListNode node =  reverse(next, n - m + 1);
               cur.next = node;
               return head;
            }
            count++;
            cur = next;
            next = next.next;
        }
        return head;
    }
    
    public ListNode reverse(ListNode head, int count){
        ListNode ser = head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        
        int c = 1;
        while(c < count){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
            c++;
        }
        
        cur.next = pre;
        ser.next = next;
        
        return cur;
    }
}
