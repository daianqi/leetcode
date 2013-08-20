/*
Swap Nodes in Pairs.
Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null)    return head;

        ListNode result = head.next;

        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode node3 = head.next.next;

        while(node1 != null && node2 != null) {
            if(node3 == null || node3.next == null)   node1.next = node3;
            else node1.next = node3.next;

            node2.next = node1;

            node1 = node3;
            node2 = (node1 == null)?null:node1.next;
            node3 = (node2 == null)?null:node2.next;

        }
        return result;
    }
}