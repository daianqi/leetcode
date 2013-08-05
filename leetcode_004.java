/*
Add Two Numbers with Reverse Order.
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of
their nodes contain a single digit. Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return addition(l1,l2,0);

    }
    public ListNode addition(ListNode n1, ListNode n2, int carry) {
        /*
        if both node is null, return null
        else:
            sum = n1.item + n2.item (if not null) + carry
            carry = sum/10

            result.item = sum%10
            result.setNext(addition(n1.next, n2.next, carry))

            return result
        */
        if(n1 == null && n2 == null && carry ==0)
            return null;
        ListNode result = new ListNode(carry);
        int sum = carry;
        if(n1 != null)
            sum += n1.val;
        if(n2 != null)
            sum+= n2.val;
        result.val = sum%10;
        if(n1 != null || n2 != null)
            result.next = addition(n1 == null? null: n1.next, n2 == null? null: n2.next, sum/10);
        return result;
    }
}

