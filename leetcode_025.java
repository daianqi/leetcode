/*
Reverse Nodes in k-Group.
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/

/**
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || k <= 0) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;    //in order to save a node for return, which is dummy.next
        head = dummy;
        for(int i = 0; head.next != null; head = head.next)
            if(i++ % k == 0) head.next = reverse(head.next, k);
        return dummy.next;
    }

    public ListNode reverse(ListNode node, int k){
        ListNode ptr = node;
        int i = 0;
        for(; ptr != null && i < k; i++) ptr = ptr.next;
        if(i < k) return node;     //not a multiple of k
        ListNode pp = node.next;
        node.next = ptr;
        for(; i > 1; i--){
            ListNode tmp = pp.next;
            pp.next = node;
            node = pp;
            pp = tmp;
        }
        return node;
    }
}