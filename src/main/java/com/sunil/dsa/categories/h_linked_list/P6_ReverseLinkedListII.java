package com.sunil.dsa.categories.h_linked_list;

import t150.linkedlist.ListNode;
import util.LinkedListUtil;

public class P6_ReverseLinkedListII {

    /*
    https://leetcode.com/problems/reverse-linked-list-ii/

    Example 1:
    Input: head = [1,2,3,4,5], left = 2, right = 4
    Output: [1,4,3,2,5]

    Example 2:
    Input: head = [5], left = 1, right = 1
    Output: [5]
     */
    public static void main(String[] args) {
        P6_ReverseLinkedListII o = new P6_ReverseLinkedListII();

//        head = [1,2,3,4,5], left = 2, right = 4

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = o.reverseBetween(head, 2, 4);
        LinkedListUtil.print(result);
        // Output: 1 4 3 2 5
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftNode = dummy;
        for(int i=1; i < left; i++){
            leftNode = leftNode.next;
        }

        ListNode prev = leftNode.next;
        ListNode start = prev;
        ListNode next = prev.next;

        for(int i=0; i < right - left && next != null; i++){
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        leftNode.next = prev;
        start.next = next;
        return dummy.next;
    }

}
