package com.sunil.dsa.categories.h_linked_list;

import t150.linkedlist.ListNode;
import util.LinkedListUtil;

public class P5_ReverseLinkedList {

    /*
    https://leetcode.com/problems/reverse-linked-list/

    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]

    Example 2:
    Input: head = [1,2]
    Output: [2,1]
     */

    public static void main(String[] args) {
        P5_ReverseLinkedList o = new P5_ReverseLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = o.reverseList(head);
        LinkedListUtil.print(result);
        // Output: 5 4 3 2 1
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
