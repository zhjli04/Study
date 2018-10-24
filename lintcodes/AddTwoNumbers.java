/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * 
 * 
 * Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.

Return 2->1->9. That is 912.

Given 3->1->5 and 5->9->2, return 8->0->8.


 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null){
            return l2;
        }
        
        if (l2 == null){
            return l1;
        }
        
        ListNode head = null;
        ListNode cur = head;
        
        int carry = 0;
        
        while((l1 != null) && (l2 != null)){
            int sum = l1.val + l2.val + carry;
            if ( sum >= 10){
                sum = sum % 10;
                carry = 1;
            }else{
                carry = 0;
            }
            
            if (head == null){
                head = new ListNode(sum);
                cur = head;
            }else{
                ListNode node = new ListNode(sum);
                cur.next = node;
                cur = node;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
            while(l1 != null){
                int sum = l1.val + carry;
                if ( sum >= 10){
                    sum = sum % 10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                ListNode n = new ListNode(sum);
                cur.next = n;
                cur = n;
                l1 = l1.next;
            }
            
            while(l2 != null){
                int sum = l2.val + carry;
                if ( sum >= 10){
                    sum = sum % 10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                ListNode n = new ListNode(sum);
                cur.next = n;
                cur = n;
                l2 = l2.next;
            }
        
         if (carry == 1){
                ListNode c = new ListNode(carry);
                cur.next = c;
            }
        
        return head;
    }
}
