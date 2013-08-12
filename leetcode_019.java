/*
Remove Nth Node From End of List.
Given a linked list, remove the nth node from the end of list and return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
*/

import java.lang.System;

public class leetcode_019 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void printList(ListNode head) {
        ListNode l = head;
        while(l!=null) {
            System.out.print(l.val+"->");
            l = l.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode slow = head, fast = head;
        while(n>0) {
            fast = fast.next;
            n--;
        }
        if(fast == null) return head.next;

        if(fast.next == null) {
            slow.next = slow.next.next;
            return head;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return  head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        printList(removeNthFromEnd(head,1));
    }
}