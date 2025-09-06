class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;

        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }

    // Helper function to print LinkedList
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
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

        // Test Case 1: Remove 3 from 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 3
        ListNode t1 = new ListNode(1);
        t1.next = new ListNode(2);
        t1.next.next = new ListNode(6);
        t1.next.next.next = new ListNode(3);
        t1.next.next.next.next = new ListNode(4);
        t1.next.next.next.next.next = new ListNode(5);
        t1.next.next.next.next.next.next = new ListNode(3);

        System.out.print("Original: ");
        printList(t1);
        ListNode r1 = sol.removeElements(t1, 3);
        System.out.print("After removing 3: ");
        printList(r1);
        System.out.println();

        // Test Case 2: Remove 1 from 1 -> 1 -> 1 -> 1
        ListNode t2 = new ListNode(1);
        t2.next = new ListNode(1);
        t2.next.next = new ListNode(1);
        t2.next.next.next = new ListNode(1);

        System.out.print("Original: ");
        printList(t2);
        ListNode r2 = sol.removeElements(t2, 1);
        System.out.print("After removing 1: ");
        printList(r2);
        System.out.println();

        // Test Case 3: Remove 7 from 7 -> 7 -> 7 -> 7
        ListNode t3 = new ListNode(7);
        t3.next = new ListNode(7);
        t3.next.next = new ListNode(7);
        t3.next.next.next = new ListNode(7);

        System.out.print("Original: ");
        printList(t3);
        ListNode r3 = sol.removeElements(t3, 7);
        System.out.print("After removing 7: ");
        printList(r3);
        System.out.println();

        // Test Case 4: Remove 5 from 1 -> 2 -> 3 -> 4
        ListNode t4 = new ListNode(1);
        t4.next = new ListNode(2);
        t4.next.next = new ListNode(3);
        t4.next.next.next = new ListNode(4);

        System.out.print("Original: ");
        printList(t4);
        ListNode r4 = sol.removeElements(t4, 5);
        System.out.print("After removing 5: ");
        printList(r4);
        System.out.println();

        // Test Case 5: Empty list
        ListNode t5 = null;
        System.out.print("Original: ");
        printList(t5);
        ListNode r5 = sol.removeElements(t5, 1);
        System.out.print("After removing 1: ");
        printList(r5);
    }
}

