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
     * Partitions a linked list around value x,
     * such that all nodes < x come before nodes >= x.
     * Preserves the original relative order of nodes.
     */
    public ListNode partition(ListNode head, int x) {
        // Dummy heads for two separate lists
        ListNode smaller = new ListNode(-1);  // list of nodes < x
        ListNode currS = smaller;
        ListNode greater = new ListNode(-1);  // list of nodes >= x
        ListNode currG = greater;

        // Traverse the original list
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                // Append to "smaller" list
                currS.next = temp;
                currS = currS.next;
            } else {
                // Append to "greater" list
                currG.next = temp;
                currG = currG.next;
            }
            temp = temp.next;
        }

        // End the "greater" list properly
        currG.next = null;
        // Connect smaller list with greater list
        currS.next = greater.next;

        // Return new head
        return smaller.next;
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

        // Test Case 1: 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
        ListNode t1 = new ListNode(1);
        t1.next = new ListNode(4);
        t1.next.next = new ListNode(3);
        t1.next.next.next = new ListNode(2);
        t1.next.next.next.next = new ListNode(5);
        t1.next.next.next.next.next = new ListNode(2);

        System.out.print("Original: ");
        printList(t1);
        ListNode r1 = sol.partition(t1, 3);
        System.out.print("Partitioned around 3: ");
        printList(r1);
        System.out.println();

        // Test Case 2: 2 -> 1, x = 2
        ListNode t2 = new ListNode(2);
        t2.next = new ListNode(1);

        System.out.print("Original: ");
        printList(t2);
        ListNode r2 = sol.partition(t2, 2);
        System.out.print("Partitioned around 2: ");
        printList(r2);
        System.out.println();

        // Test Case 3: All nodes smaller than x (1 -> 1 -> 1, x = 5)
        ListNode t3 = new ListNode(1);
        t3.next = new ListNode(1);
        t3.next.next = new ListNode(1);

        System.out.print("Original: ");
        printList(t3);
        ListNode r3 = sol.partition(t3, 5);
        System.out.print("Partitioned around 5: ");
        printList(r3);
        System.out.println();

        // Test Case 4: All nodes greater than or equal to x (4 -> 5 -> 6, x = 3)
        ListNode t4 = new ListNode(4);
        t4.next = new ListNode(5);
        t4.next.next = new ListNode(6);

        System.out.print("Original: ");
        printList(t4);
        ListNode r4 = sol.partition(t4, 3);
        System.out.print("Partitioned around 3: ");
        printList(r4);
        System.out.println();

        // Test Case 5: Empty list
        ListNode t5 = null;
        System.out.print("Original: ");
        printList(t5);
        ListNode r5 = sol.partition(t5, 1);
        System.out.print("Partitioned around 1: ");
        printList(r5);
    }
}
