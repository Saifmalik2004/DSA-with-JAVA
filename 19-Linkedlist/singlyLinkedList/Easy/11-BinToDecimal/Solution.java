class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
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

        // Test Case 1: Binary 101 (list: 1 -> 0 -> 1) = 5
        ListNode t1 = new ListNode(1);
        t1.next = new ListNode(0);
        t1.next.next = new ListNode(1);

        System.out.print("Binary List: ");
        printList(t1);
        System.out.println("Decimal Value: " + sol.getDecimalValue(t1));
        System.out.println();

        // Test Case 2: Binary 0 (list: 0) = 0
        ListNode t2 = new ListNode(0);
        System.out.print("Binary List: ");
        printList(t2);
        System.out.println("Decimal Value: " + sol.getDecimalValue(t2));
        System.out.println();

        // Test Case 3: Binary 1 (list: 1) = 1
        ListNode t3 = new ListNode(1);
        System.out.print("Binary List: ");
        printList(t3);
        System.out.println("Decimal Value: " + sol.getDecimalValue(t3));
        System.out.println();

        // Test Case 4: Binary 111 (list: 1 -> 1 -> 1) = 7
        ListNode t4 = new ListNode(1);
        t4.next = new ListNode(1);
        t4.next.next = new ListNode(1);

        System.out.print("Binary List: ");
        printList(t4);
        System.out.println("Decimal Value: " + sol.getDecimalValue(t4));
        System.out.println();

        // Test Case 5: Binary 1001 (list: 1 -> 0 -> 0 -> 1) = 9
        ListNode t5 = new ListNode(1);
        t5.next = new ListNode(0);
        t5.next.next = new ListNode(0);
        t5.next.next.next = new ListNode(1);

        System.out.print("Binary List: ");
        printList(t5);
        System.out.println("Decimal Value: " + sol.getDecimalValue(t5));
    }
}
