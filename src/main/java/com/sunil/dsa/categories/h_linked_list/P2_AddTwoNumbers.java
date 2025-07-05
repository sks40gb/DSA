package com.sunil.dsa.categories.h_linked_list;

/*
https://leetcode.com/problems/add-two-numbers

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */

import t150.linkedlist.ListNode;
import util.LinkedListUtil;

public class P2_AddTwoNumbers {

    public static void main(String[] args) {
        P2_AddTwoNumbers o = new P2_AddTwoNumbers();
        ListNode l1 = LinkedListUtil.constructLinkedList(2, 4, 3);
        ListNode l2 = LinkedListUtil.constructLinkedList(5, 6, 4);
        ListNode result = o.addTwoNumbers(l1, l2);
        LinkedListUtil.print(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            if(sum > 9){
                sum = sum - 10;
                carry = 1;
            }else{
                carry = 0;
            }
            if (head == null) {
                head = new ListNode(sum);
                cur = head;
            }else{
                ListNode node = new ListNode(sum);
                cur.next = node;
                cur = node;
            }
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return head;
    }

}
