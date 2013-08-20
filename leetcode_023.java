/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while(l1 != null && l2 != null) {
            if(l1.val<l2.val) {
                cur.next=l1;
                l1=l1.next;
            } else {
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }

        if(l1!=null) {
            cur.next=l1;
        } else if(l2!=null) {
            cur.next=l2;
        }

        return head.next;
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists.size()==0)  return null;
        if(lists.size()==1)  return lists.get(0);

        ListNode merged = merge2Lists(lists.get(0),lists.get(1));

        for(int i = 2;i<lists.size();i++) {
            merged = merge2Lists(merged,lists.get(i));
        }
        return merged;
    }
}