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

    /**
     * Rearranges the linked list so that all nodes at odd indices
     * come before all nodes at even indices.
     *
     * Example:
     * Input:  1 -> 2 -> 3 -> 4 -> 5
     * Output: 1 -> 3 -> 5 -> 2 -> 4
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // keep track of start of even list

        while (even != null && even.next != null) {
            odd.next = odd.next.next;   // link odd to next odd
            even.next = even.next.next; // link even to next even
            odd = odd.next;
            even = even.next;
        }

        // join odd list end with even list start
        odd.next = evenHead;
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

        // Create LinkedList: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Apply oddEvenList
        ListNode result = sol.oddEvenList(head);

        System.out.println("After odd-even rearrangement:");
        printList(result);
    }
}
