class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            while (temp.next != null && temp.next.val == temp.val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
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

        // Test Case 1: 1 -> 1 -> 2 -> 3 -> 3
        ListNode t1 = new ListNode(1);
        t1.next = new ListNode(1);
        t1.next.next = new ListNode(2);
        t1.next.next.next = new ListNode(3);
        t1.next.next.next.next = new ListNode(3);

        System.out.print("Original: ");
        printList(t1);
        ListNode r1 = sol.deleteDuplicates(t1);
        System.out.print("After removing duplicates: ");
        printList(r1);
        System.out.println();

        // Test Case 2: 1 -> 1 -> 1 -> 1
        ListNode t2 = new ListNode(1);
        t2.next = new ListNode(1);
        t2.next.next = new ListNode(1);
        t2.next.next.next = new ListNode(1);

        System.out.print("Original: ");
        printList(t2);
        ListNode r2 = sol.deleteDuplicates(t2);
        System.out.print("After removing duplicates: ");
        printList(r2);
        System.out.println();

        // Test Case 3: 1 -> 2 -> 3 -> 4 (No duplicates)
        ListNode t3 = new ListNode(1);
        t3.next = new ListNode(2);
        t3.next.next = new ListNode(3);
        t3.next.next.next = new ListNode(4);

        System.out.print("Original: ");
        printList(t3);
        ListNode r3 = sol.deleteDuplicates(t3);
        System.out.print("After removing duplicates: ");
        printList(r3);
        System.out.println();

        // Test Case 4: Empty list
        ListNode t4 = null;
        System.out.print("Original: ");
        printList(t4);
        ListNode r4 = sol.deleteDuplicates(t4);
        System.out.print("After removing duplicates: ");
        printList(r4);
    }
}
