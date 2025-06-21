package t150.linkedlist;


public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = null;
        ListNode head = null;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int val = 0;
            if (sum > 9) {
                carry = 1;
                val = sum % 10;
            } else {
                val = sum;
                carry = 0;
            }
            if (current == null) {
                head = current = new ListNode(val);
            } else {
                current.next = new ListNode(val);
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // 2 4 3
        // 5 6 4
        AddTwoNumbers solution = new AddTwoNumbers();

        ListNode result = solution.addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 7 0 8 (since 342 + 465 = 807)
    }

}
