package com.sunil.dsa.categories.h_linked_list;

/*
https://leetcode.com/problems/reverse-nodes-in-k-group/

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 */

import t150.linkedlist.ListNode;
import util.LinkedListUtil;

public class P7_ReverseNodesInKGroup {

    public static void main(String[] args) {
        P7_ReverseNodesInKGroup o = new P7_ReverseNodesInKGroup();
        ListNode head = LinkedListUtil.constructLinkedList(1, 2, 3, 4, 5);
        ListNode result = o.reverseKGroup(head, 2);
        LinkedListUtil.print(result);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;   //[x]

        while (true) {
            ListNode kth = getKthNode(groupPrev, k); // [x], [1], [2], [3], [4], [5] => [2]
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;    //[3]

            // Reverse the group
            ListNode prev = groupNext;        //[3]
            ListNode curr = groupPrev.next;   //[1]

            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // Connect previous group to new head
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode head, int k) {
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }

}
