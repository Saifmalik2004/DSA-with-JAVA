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
     * Find the k-th node from the current head.
     * Returns null if there are fewer than k nodes left.
     */
    public ListNode findKthNode(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            if (count == k) return temp;
            temp = temp.next;
        }
        return null;
    }

    /**
     * Reverse a linked list and return new head.
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * Reverse nodes in k-group.
     * Example: [1,2,3,4,5], k=2 → [2,1,4,3,5]
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        ListNode temp = head;
        ListNode prevGroupEnd = null;

        while (temp != null) {
            // Find the k-th node from current start
            ListNode kth = findKthNode(temp, k);
            if (kth == null) break; // Not enough nodes left

            ListNode nextGroupStart = kth.next; // Save next group
            kth.next = null; // Temporarily break the list

            // Reverse this k-group
            ListNode newGroupHead = reverse(temp);

            // If reversing first group, update head
            if (temp == head) {
                head = newGroupHead;
            } else {
                prevGroupEnd.next = newGroupHead;
            }

            // Connect end of reversed group to next part
            prevGroupEnd = temp;
            temp = nextGroupStart;
        }

        // Attach any remaining nodes
        if (prevGroupEnd != null) {
            prevGroupEnd.next = temp;
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
        // Example: Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2
        // Output: 2 -> 1 -> 4 -> 3 -> 5

        // Build linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        Solution sol = new Solution();
        int k = 2;
        ListNode newHead = sol.reverseKGroup(head, k);

        System.out.print("Reversed in k=" + k + " groups: ");
        printList(newHead);
    }
}
