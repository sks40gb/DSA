package com.sunil.dsa.categories.h_linked_list;

import t150.linkedlist.ListNode;
import util.LinkedListUtil;

/*
https://leetcode.com/problems/rotate-list/

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
 */
public class P10_RotateList {

    public static void main(String[] args) {
        P10_RotateList o = new P10_RotateList();
        ListNode head = LinkedListUtil.constructLinkedList(1, 2, 3, 4, 5);
        int k = 2;
        ListNode result = o.rotateRight(head, k);
        LinkedListUtil.print(result);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int size = 1;
        ListNode current = head;

        // Step 1: Find the length of the list
        while (current.next != null) {
            size++;
            current = current.next;
        }

        // Step 2: Create a circular list
        current.next = head;

        k = k % size;

        // Step 3: Find the new tail and break the cycle
        ListNode newTail = head;
        for (int i = 1; i < size - k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

}
