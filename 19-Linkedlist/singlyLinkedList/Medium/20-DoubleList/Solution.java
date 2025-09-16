// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    // Function to reverse a linked list
    public ListNode reverse(ListNode li) {
        ListNode curr = li;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Function to double the number represented by the linked list.
     * Example:  [1 -> 2 -> 3] represents 123 → doubled = 246 → [2 -> 4 -> 6]
     */
    public ListNode doubleIt(ListNode head) {
        // Reverse the list to start doubling from least significant digit
        ListNode l1 = reverse(head);

        ListNode dummy = new ListNode(-1);
        int carry = 0;

        // Traverse reversed list
        while (l1 != null) {
            int total = l1.val * 2 + carry;
            int digit = total % 10;
            carry = total / 10;

            // Insert digit at front (since we are already reversed)
            ListNode newNode = new ListNode(digit);
            newNode.next = dummy.next;
            dummy.next = newNode;

            l1 = l1.next;
        }

        // If carry remains
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = dummy.next;
            dummy.next = newNode;
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

    // Main method to test locally
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: Normal number
        int[] arr1 = {1, 2, 3}; // 123
        ListNode head1 = createList(arr1);
        System.out.print("Original: ");
        printList(head1);
        ListNode ans1 = sol.doubleIt(head1);
        System.out.print("Doubled : ");
        printList(ans1); // Expected: 2 -> 4 -> 6

        // Test case 2: Number with carry
        int[] arr2 = {9, 9}; // 99
        ListNode head2 = createList(arr2);
        System.out.print("\nOriginal: ");
        printList(head2);
        ListNode ans2 = sol.doubleIt(head2);
        System.out.print("Doubled : ");
        printList(ans2); // Expected: 1 -> 9 -> 8

        // Test case 3: Single digit number
        int[] arr3 = {5}; // 5
        ListNode head3 = createList(arr3);
        System.out.print("\nOriginal: ");
        printList(head3);
        ListNode ans3 = sol.doubleIt(head3);
        System.out.print("Doubled : ");
        printList(ans3); // Expected: 1 -> 0

        // Test case 4: Large number
        int[] arr4 = {1, 0, 0, 0}; // 1000
        ListNode head4 = createList(arr4);
        System.out.print("\nOriginal: ");
        printList(head4);
        ListNode ans4 = sol.doubleIt(head4);
        System.out.print("Doubled : ");
        printList(ans4); // Expected: 2 -> 0 -> 0 -> 0
    }
}
