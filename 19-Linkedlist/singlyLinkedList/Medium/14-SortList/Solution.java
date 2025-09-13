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
     * Sorts a linked list using Merge Sort algorithm.
     * @param head head of the linked list
     * @return sorted linked list
     */
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    /**
     * Finds the middle node of the linked list.
     * Using slow and fast pointer approach.
     */
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // fast ek step aage start karega

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; // mid return karega
    }

    /**
     * Recursive merge sort for linked list.
     */
    public ListNode mergeSort(ListNode head) {
        // Base condition: 0 or 1 node
        if (head == null || head.next == null) return head;

        // Step 1: Find middle
        ListNode mid = findMid(head);

        // Step 2: Split into two halves
        ListNode rightHead = mid.next;
        mid.next = null;

        // Step 3: Recursive sort on both halves
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(rightHead);

        // Step 4: Merge both sorted halves
        return merge(left, right);
    }

    /**
     * Merges two sorted linked lists.
     */
    public ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (leftHead != null && rightHead != null) {
            if (leftHead.val <= rightHead.val) {
                temp.next = leftHead;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        if (leftHead != null) temp.next = leftHead;
        if (rightHead != null) temp.next = rightHead;

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

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Create unsorted linked list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        // Sort the list
        head = sol.sortList(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
