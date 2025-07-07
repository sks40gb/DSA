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

    //TODO
    public ListNode reverseKGroup(ListNode head, int k) {
        
        return head;
    }

}
