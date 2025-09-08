class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Find length and last node
        int length = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        // 2. Effective rotation
        k = k % length;
        if (k == 0) return head;

        // 3. Find new head (length - k steps from start)
        int stepsToNewHead = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // 4. Rotate
        ListNode newHead = newTail.next;
        newTail.next = null;
        last.next = head;

        return newHead;
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

        // Test Case 1: Rotate [1 -> 2 -> 3 -> 4 -> 5] by 2
        ListNode t1 = new ListNode(1);
        t1.next = new ListNode(2);
        t1.next.next = new ListNode(3);
        t1.next.next.next = new ListNode(4);
        t1.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(t1);
        ListNode r1 = sol.rotateRight(t1, 2);
        System.out.print("After rotate by 2: ");
        printList(r1);
        System.out.println();

        // Test Case 2: Rotate [0 -> 1 -> 2] by 4
        ListNode t2 = new ListNode(0);
        t2.next = new ListNode(1);
        t2.next.next = new ListNode(2);

        System.out.print("Original: ");
        printList(t2);
        ListNode r2 = sol.rotateRight(t2, 4);
        System.out.print("After rotate by 4: ");
        printList(r2);
        System.out.println();

        // Test Case 3: Rotate single element [1] by 10
        ListNode t3 = new ListNode(1);

        System.out.print("Original: ");
        printList(t3);
        ListNode r3 = sol.rotateRight(t3, 10);
        System.out.print("After rotate by 10: ");
        printList(r3);
        System.out.println();

        // Test Case 4: Empty list
        ListNode t4 = null;
        System.out.print("Original: ");
        printList(t4);
        ListNode r4 = sol.rotateRight(t4, 3);
        System.out.print("After rotate by 3: ");
        printList(r4);
    }
}
