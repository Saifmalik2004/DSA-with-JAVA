// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    // Reverse a linked list
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Add two numbers represented by linked lists.
     * Each number is stored in forward order.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Step 1: Reverse both lists
        l1 = reverse(l1);
        l2 = reverse(l2);

        // Step 2: Add like normal numbers
        ListNode dummy = new ListNode(-1);
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int a = (l1 != null) ? l1.val : 0;
            int b = (l2 != null) ? l2.val : 0;

            int sum = a + b + carry;
            int digit = sum % 10;
            carry = sum / 10;

            // Insert at head (so no need to reverse at end)
            ListNode newNode = new ListNode(digit);
            newNode.next = dummy.next;
            dummy.next = newNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    // Helper function to print LinkedList
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test locally
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("Number 1: ");
        printList(l1);
        System.out.println("Number 2: ");
        printList(l2);

        ListNode result = sol.addTwoNumbers(l1, l2);

        System.out.println("Result: ");
        printList(result);
    }
}
