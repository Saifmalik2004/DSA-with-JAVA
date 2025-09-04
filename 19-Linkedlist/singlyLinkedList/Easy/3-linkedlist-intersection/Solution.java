class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // if a & b have different len, we will stop the loop after second iteration
        while (a != b) {
            // for the end of first iteration, reset pointer to the head of another linkedlist
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a; // either intersection node or null
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
        /*
         Example:
         List A: 1 -> 9 -> 1 \
                              2 -> 4
                   List B:    3 /
         Intersection at node with value 2
        */

        // Create intersection part
        ListNode intersect = new ListNode(2);
        intersect.next = new ListNode(4);

        // List A: 1 -> 9 -> 1 -> 2 -> 4
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = intersect;

        // List B: 3 -> 2 -> 4
        ListNode headB = new ListNode(3);
        headB.next = intersect;

        Solution sol = new Solution();
        ListNode result = sol.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection Node Value: " + result.val); // should print 2
        } else {
            System.out.println("No intersection");
        }
    }
}
