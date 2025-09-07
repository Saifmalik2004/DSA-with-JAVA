class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
   
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int i = 0;

        while (i <= n) {
            fast = fast.next;
            i++;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
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

        // Test Case 1: Remove 2nd node from end (list: 1 -> 2 -> 3 -> 4 -> 5)
        ListNode t1 = new ListNode(1);
        t1.next = new ListNode(2);
        t1.next.next = new ListNode(3);
        t1.next.next.next = new ListNode(4);
        t1.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(t1);
        ListNode r1 = sol.removeNthFromEnd(t1, 2); // should remove 4
        System.out.print("After removing 2nd from end: ");
        printList(r1);
        System.out.println();

        // Test Case 2: Remove last node (list: 1 -> 2 -> 3)
        ListNode t2 = new ListNode(1);
        t2.next = new ListNode(2);
        t2.next.next = new ListNode(3);

        System.out.print("Original: ");
        printList(t2);
        ListNode r2 = sol.removeNthFromEnd(t2, 1); // should remove 3
        System.out.print("After removing last node: ");
        printList(r2);
        System.out.println();

        // Test Case 3: Remove head node (list: 1 -> 2 -> 3 -> 4, n=4)
        ListNode t3 = new ListNode(1);
        t3.next = new ListNode(2);
        t3.next.next = new ListNode(3);
        t3.next.next.next = new ListNode(4);

        System.out.print("Original: ");
        printList(t3);
        ListNode r3 = sol.removeNthFromEnd(t3, 4); // should remove 1
        System.out.print("After removing head node: ");
        printList(r3);
        System.out.println();

        // Test Case 4: Single element list (list: 1, n=1)
        ListNode t4 = new ListNode(1);

        System.out.print("Original: ");
        printList(t4);
        ListNode r4 = sol.removeNthFromEnd(t4, 1); // should become empty
        System.out.print("After removing only node: ");
        printList(r4);
        System.out.println();
    }
}
