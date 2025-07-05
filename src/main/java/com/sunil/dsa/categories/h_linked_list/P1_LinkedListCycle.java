package com.sunil.dsa.categories.h_linked_list;

import t150.linkedlist.ListNode;
import util.LinkedListUtil;

/*

https://leetcode.com/problems/linked-list-cycle

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true

Example 2:
Input: head = [1,2], pos = 0
Output: true
 */
public class P1_LinkedListCycle {

    public static void main(String[] args) {
        P1_LinkedListCycle o = new P1_LinkedListCycle();
        int[] arr = {3, 2, 0, -4};
        ListNode head = LinkedListUtil.constructLinkedList(arr);
        LinkedListUtil.print(head);
        System.out.println(o.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }

}
