class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode next = current.next;

            // swap
            current.next = next.next;
            next.next = current;
            prev.next = next;

            // move pointers forward
            prev = current;
            current = current.next;
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

        // Test Case 1: 1 -> 2 -> 3 -> 4
        ListNode t1 = new ListNode(1);
        t1.next = new ListNode(2);
        t1.next.next = new ListNode(3);
        t1.next.next.next = new ListNode(4);

        System.out.print("Original: ");
        printList(t1);
        ListNode r1 = sol.swapPairs(t1);
        System.out.print("After Swap: ");
        printList(r1);
        System.out.println();

        // Test Case 2: 1 -> 2 -> 3
        ListNode t2 = new ListNode(1);
        t2.next = new ListNode(2);
        t2.next.next = new ListNode(3);

        System.out.print("Original: ");
        printList(t2);
        ListNode r2 = sol.swapPairs(t2);
        System.out.print("After Swap: ");
        printList(r2);
        System.out.println();

        // Test Case 3: 1
        ListNode t3 = new ListNode(1);

        System.out.print("Original: ");
        printList(t3);
        ListNode r3 = sol.swapPairs(t3);
        System.out.print("After Swap: ");
        printList(r3);
        System.out.println();

        // Test Case 4: Empty list
        ListNode t4 = null;
        System.out.print("Original: ");
        printList(t4);
        ListNode r4 = sol.swapPairs(t4);
        System.out.print("After Swap: ");
        printList(r4);
    }
}
