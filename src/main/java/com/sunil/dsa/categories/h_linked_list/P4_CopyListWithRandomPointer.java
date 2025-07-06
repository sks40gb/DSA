package com.sunil.dsa.categories.h_linked_list;

import t150.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/

Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 */

public class P4_CopyListWithRandomPointer {

    public static void main(String[] args) {

        P4_CopyListWithRandomPointer o = new P4_CopyListWithRandomPointer();

        Node head = new Node(7);
        head.next = new Node(13);
        head.next.random = head;
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        Node copiedHead = o.copyRandomList(head);
        while (copiedHead != null) {
            System.out.println("Val: " + copiedHead.val
                    + ", Random: "
                    + (copiedHead.random != null ?
                    copiedHead.random.val : "null"));
            copiedHead = copiedHead.next;
        }

    }

    public Node copyRandomList(Node head) {

        // clone
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            Node next = cur.next;
            cur.next = clone;
            clone.next = next;
            cur = next;
        }

        // set the random node
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // detach the link
        Node cloneHead = head != null ? head.next : null;
        cur = head;
        while (cur != null) {
            Node clone = cur.next;
            cur.next = clone.next;
            if (clone.next != null) {
                clone.next = clone.next.next;
            }
            cur = cur.next;
        }
        return cloneHead;
    }

    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        while(cur != null){
            Node clone = new Node(cur.val);
            map.put(cur, clone);
            cur = cur.next;
        }

        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);
    }
}
