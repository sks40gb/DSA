package com.sunil.dsa.categories.h_linked_list;

/*
https://leetcode.com/problems/merge-two-sorted-lists/

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */

import t150.linkedlist.ListNode;
import util.LinkedListUtil;

public class P3_MergeTwoSortedLists {

    public static void main(String[] args) {
        P3_MergeTwoSortedLists o = new P3_MergeTwoSortedLists();
        ListNode list1 = LinkedListUtil.constructLinkedList(1, 2, 4);
        ListNode list2 = LinkedListUtil.constructLinkedList(1, 3, 4);
        ListNode result = o.mergeTwoLists(list1, list2);
        LinkedListUtil.print(result);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode header = null;
        ListNode cur = null;
        while (list1 != null || list2 != null) {
            int value = 0;

            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    value = list1.val;
                    list1 = list1.next;
                } else {
                    value = list2.val;
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                value = list1.val;
                list1 = list1.next;
            } else if (list2 != null) {
                value = list2.val;
                list2 = list2.next;
            }
            if (header == null) {
                header = new ListNode(value);
                cur = header;
            } else {
                ListNode node = new ListNode(value);
                cur.next = node;
                cur = node;
            }
        }
        return header;
    }

}
