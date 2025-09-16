class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    // ✅ Step 1: Find middle of LinkedList
    public ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;      
            fast = fast.next.next; 
        }
        return slow; // slow = mid
    }

    // ✅ Step 2: ZigZag rearrange
    public void zigZag(ListNode head) {
        if (head == null || head.next == null) return;

        // Split into two halves
        ListNode mid = getMid(head);
        ListNode second = mid.next;
        mid.next = null;

        // Reverse second half
        ListNode prev = null, curr = second;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode left = head, right = prev;

        // Merge in zig-zag fashion
        while (left != null && right != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;

            left.next = right;
            if (leftNext == null) break; // important for odd-length lists
            right.next = leftNext;

            left = leftNext;
            right = rightNext;
        }
    }

    // ✅ Helper: Print LinkedList
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // ✅ Helper: Create list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // ✅ Main method with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: Even length
        ListNode head1 = createList(new int[]{1,2,3,4,5,6});
        System.out.print("Original: ");
        printList(head1);
        sol.zigZag(head1);
        System.out.print("ZigZag:   ");
        printList(head1); // Expected: 1 -> 6 -> 2 -> 5 -> 3 -> 4

        // Test 2: Odd length
        ListNode head2 = createList(new int[]{10,20,30,40,50});
        System.out.print("\nOriginal: ");
        printList(head2);
        sol.zigZag(head2);
        System.out.print("ZigZag:   ");
        printList(head2); // Expected: 10 -> 50 -> 20 -> 40 -> 30

        // Test 3: Small list
        ListNode head3 = createList(new int[]{1,2});
        System.out.print("\nOriginal: ");
        printList(head3);
        sol.zigZag(head3);
        System.out.print("ZigZag:   ");
        printList(head3); // Expected: 1 -> 2

        // Test 4: Single node
        ListNode head4 = createList(new int[]{7});
        System.out.print("\nOriginal: ");
        printList(head4);
        sol.zigZag(head4);
        System.out.print("ZigZag:   ");
        printList(head4); // Expected: 7
    }
}
