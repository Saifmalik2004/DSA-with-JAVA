class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    /**
     * Function to skip M nodes and then delete N nodes repeatedly
     * until the end of the linked list.
     */
    public void skipMdeleteN(ListNode head, int m, int n) {
        ListNode current = head; // Start from the head
        ListNode temp;

        while (current != null) {
            // Skip M nodes
            for (int count = 1; count < m && current != null; count++) {
                current = current.next;
            }

            // If reached end after skipping, break
            if (current == null) return;

            // Start deleting next N nodes
            temp = current.next;
            for (int count = 1; count <= n && temp != null; count++) {
                temp = temp.next;
            }

            // Connect the skipped part to the remaining list
            current.next = temp;

            // Move current to the next segment
            current = temp;
        }
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

    // Helper function to create LinkedList from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Main method with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: Basic example
        ListNode head1 = createList(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.print("Original: ");
        printList(head1);
        sol.skipMdeleteN(head1, 2, 3);
        System.out.print("Modified: ");
        printList(head1); // Expected: 1 -> 2 -> 6 -> 7

        // Test case 2: m=1, n=1 (alternate delete)
        ListNode head2 = createList(new int[]{1,2,3,4,5});
        System.out.print("\nOriginal: ");
        printList(head2);
        sol.skipMdeleteN(head2, 1, 1);
        System.out.print("Modified: ");
        printList(head2); // Expected: 1 -> 3 -> 5

        // Test case 3: m=3, n=0 (no deletion)
        ListNode head3 = createList(new int[]{10,20,30,40,50});
        System.out.print("\nOriginal: ");
        printList(head3);
        sol.skipMdeleteN(head3, 3, 0);
        System.out.print("Modified: ");
        printList(head3); // Expected: 10 -> 20 -> 30 -> 40 -> 50

        // Test case 4: m=0, n=2 (delete everything)
        ListNode head4 = createList(new int[]{1,2,3,4});
        System.out.print("\nOriginal: ");
        printList(head4);
        sol.skipMdeleteN(head4, 0, 2);
        System.out.print("Modified: ");
        printList(head4); // Expected: (empty list)
    }
}
