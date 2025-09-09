// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // Function to reverse nodes between 'left' and 'right'
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode dummy = new ListNode(-1);  // dummy node before head
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move 'prev' to the node before 'left'
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse the sublist from left → right
        ListNode curr = prev.next;
        ListNode prevRev = null, next = null;
        for (int i = 0; i <= right - left; i++) {
            next = curr.next;
            curr.next = prevRev;
            prevRev = curr;
            curr = next;
        }

        // Step 3: Reconnect the reversed part
        prev.next.next = curr; // old 'left' node now tail → connect with remainder
        prev.next = prevRev;   // connect node before 'left' with new head of sublist

        return dummy.next;
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    // Main method with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: Reverse sublist in the middle
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.print("Original: ");
        printList(head1);
        head1 = sol.reverseBetween(head1, 2, 4);
        System.out.print("After reverse(2,4): ");
        printList(head1);
        System.out.println();

        // Test 2: Reverse the whole list
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.print("Original: ");
        printList(head2);
        head2 = sol.reverseBetween(head2, 1, 3);
        System.out.print("After reverse(1,3): ");
        printList(head2);
        System.out.println();

        // Test 3: Reverse only one node (should stay same)
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        System.out.print("Original: ");
        printList(head3);
        head3 = sol.reverseBetween(head3, 2, 2);
        System.out.print("After reverse(2,2): ");
        printList(head3);
        System.out.println();

        // Test 4: Reverse starting part
        ListNode head4 = new ListNode(10);
        head4.next = new ListNode(20);
        head4.next.next = new ListNode(30);
        head4.next.next.next = new ListNode(40);
        System.out.print("Original: ");
        printList(head4);
        head4 = sol.reverseBetween(head4, 1, 2);
        System.out.print("After reverse(1,2): ");
        printList(head4);
    }
}
