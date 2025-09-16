class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    // Function to swap kth node from start and kth node from end
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return null;

        // Step 1: Move to kth node from start
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode kthFromStart = fast;

        // Step 2: Find kth node from end using two pointers
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode kthFromEnd = slow;

        // Step 3: Swap values
        int temp = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = temp;

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

        // Example: Linked list = 1 -> 2 -> 3 -> 4 -> 5, k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        head = sol.swapNodes(head, 2);

        System.out.print("After Swapping: ");
        printList(head);
    }
}
