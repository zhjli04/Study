/*
109. Convert Sorted List to Binary Search Tree
Medium

1021

68

Favorite

Share
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        
        ListNode one = head;
        ListNode two = head;
        ListNode pre = head;
        
        while (one != null && two != null && two.next != null) {
            pre = one;
            one = one.next;
            two = two.next.next;
        }
        
        if (one == two) {
            one = one.next;
        }
        
        TreeNode node = new TreeNode(one.val);
        pre.next = null;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(one.next);
        return node;
    }
}
