package com.sunil.dsa.categories.h_linked_list;

import t150.linkedlist.ListNode;
import util.LinkedListUtil;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]
 */
public class P9_RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        P9_RemoveDuplicatesFromSortedListII o = new P9_RemoveDuplicatesFromSortedListII();
        ListNode head = LinkedListUtil.constructLinkedList(1, 2, 3, 3, 4, 4, 5);
        ListNode result = o.deleteDuplicates(head);
        LinkedListUtil.print(result);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            boolean isDuplicate = false;

            //move all duplicate
            while (current.next != null && current.val == current.next.val) {
                isDuplicate = true;
                current = current.next;
            }

            if (isDuplicate) {
                // Skip all duplicates
                prev.next = current.next;
            } else {
                // No duplicates: move prev forward
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
    }

}
