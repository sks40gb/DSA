package com.sunil.dsa.categories.h_linked_list;

/*
https://leetcode.com/problems/partition-list/

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
 */

import t150.linkedlist.ListNode;
import util.LinkedListUtil;

public class P11_PartitionList {

    public static void main(String[] args) {
        P11_PartitionList o = new P11_PartitionList();
        ListNode head = LinkedListUtil.constructLinkedList(1, 4, 3, 2, 5, 2); //[1,2,2,4,3,5]
        int x = 3;
        ListNode result = o.partition(head, x);
        LinkedListUtil.print(result);
    }

    public ListNode partition(ListNode head, int x) {

        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);

        ListNode left = leftHead;
        ListNode right = rightHead;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        right.next = null; //End of right
        left.next = rightHead.next;
        return leftHead.next;
    }

}
