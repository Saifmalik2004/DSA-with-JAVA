class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // Reorder list: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 ...
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find middle using slow/fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null, curr = second;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        second = prev; // head of reversed half

        // Step 3: Merge two halves
        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: Even length list
        ListNode t1 = new ListNode(1);
        t1.next = new ListNode(2);
        t1.next.next = new ListNode(3);
        t1.next.next.next = new ListNode(4);

        System.out.print("Original: ");
        printList(t1);
        sol.reorderList(t1);
        System.out.print("Reordered: ");
        printList(t1);
        System.out.println();

        // Test 2: Odd length list
        ListNode t2 = new ListNode(1);
        t2.next = new ListNode(2);
        t2.next.next = new ListNode(3);
        t2.next.next.next = new ListNode(4);
        t2.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(t2);
        sol.reorderList(t2);
        System.out.print("Reordered: ");
        printList(t2);
        System.out.println();

        // Test 3: Single node
        ListNode t3 = new ListNode(10);
        System.out.print("Original: ");
        printList(t3);
        sol.reorderList(t3);
        System.out.print("Reordered: ");
        printList(t3);
        System.out.println();

        // Test 4: Empty list
        ListNode t4 = null;
        System.out.print("Original: ");
        printList(t4);
        sol.reorderList(t4);
        System.out.print("Reordered: ");
        printList(t4);
    }
}
