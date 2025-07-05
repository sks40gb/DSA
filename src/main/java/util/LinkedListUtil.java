package util;

import t150.linkedlist.ListNode;

public class LinkedListUtil {

    public static ListNode constructLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = null;
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            if (cur == null) {
                cur = node;
                head.next = cur;
            } else {
                cur.next = node;
                cur = node;
            }
        }
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.format("[%s]-->", head.val);
            head = head.next;
        }
        System.out.println();
    }

}
