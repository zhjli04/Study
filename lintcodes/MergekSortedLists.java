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
 * 
 * Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.


 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0){
            return null;
        }
        // write your code here
        return getMergedNode(lists, 0, lists.size()-1);
    }
    
    public ListNode getMergedNode(List<ListNode> nodes, int start, int end){
		if (start == end){
			return nodes.get(start);
		}
		
		if (start + 1 == end){
			return mergeNode(nodes.get(start), nodes.get(end));
		}
		
		int pos = (start + end) / 2;
		ListNode left = getMergedNode(nodes, start, pos);
		ListNode right = getMergedNode(nodes, pos + 1, end);
		
		return mergeNode(left, right);
	}
    
    public ListNode mergeNode(ListNode n1, ListNode n2){
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		while ((n1 != null) && (n2 != null)){
			if (n1.val < n2.val){
				node.next = n1;
				n1 = n1.next;
			}else{
				node.next = n2;
				n2 = n2.next;
			}
			node = node.next;
		}
		
		while(n1 != null){
			node.next = n1;
			node  = node.next;
			n1 = n1.next;
		}
		
		while(n2 != null){
			node.next = n2;
			node  = node.next;
			n2 = n2.next;
		}
		
		return dummy.next;
	}
}
