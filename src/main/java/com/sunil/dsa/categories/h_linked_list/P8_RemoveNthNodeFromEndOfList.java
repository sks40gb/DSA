package com.sunil.dsa.categories.h_linked_list;

import t150.linkedlist.ListNode;
import util.LinkedListUtil;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
 */
public class P8_RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        P8_RemoveNthNodeFromEndOfList o = new P8_RemoveNthNodeFromEndOfList();
        ListNode head = LinkedListUtil.constructLinkedList(1,2,3,4,5); //[1,2,3,5]
        int n = 2;
        ListNode result = o.removeNthFromEnd(head, n);
        LinkedListUtil.print(result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;

        //move right pointer
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        //move both the pointers
        while(right.next != null){
            left = left.next;
            right = right.next;
        }

        // Remove the nth node
        left.next = left.next.next;
        return head;
    }

}
