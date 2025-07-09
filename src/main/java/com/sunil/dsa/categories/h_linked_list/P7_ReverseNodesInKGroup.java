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
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        ListNode endNode = dummy;
        while (curr != null) {
            ListNode kth = getKthNode(curr, k);
            if (kth != null) {
                ListNode nextGroupHead = kth.next;
                kth.next = null;
                endNode.next = reverse(curr);
                endNode = curr;
                curr = nextGroupHead;
            } else {
                endNode.next = curr;
                break;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode next = node;
        while (next != null) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        return prev;
    }

    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node;
    }


}
