class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }

        return false;
    }

    public int countCycle(ListNode head){
         ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) break;
        }
        if(fast==null || fast.next==null){
            return 0;
        }
        slow=head;

        while(fast!=slow){
             fast=fast.next;
            slow=slow.next;
        }
        slow=slow.next;
        int i=1;
        while(fast!=slow){
            i++;
            slow=slow.next;
        }
        return i;
    }

    // Helper function to print LinkedList (works only for non-cycle lists)
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

        // Example 1: No cycle
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);

        System.out.println("Has cycle (Example 1)? " + sol.hasCycle(head1)); // false

        // Example 2: Cycle (last node connects to node with val = 2)
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(0);
        head2.next.next.next = new ListNode(-4);
        head2.next.next.next.next = head2.next; // create cycle

        System.out.println("Has cycle (Example 2)? " + sol.hasCycle(head2)); 
        System.out.println(sol.countCycle(head2));// true

        // Example 3: Single node with no cycle
        ListNode head3 = new ListNode(1);
        System.out.println("Has cycle (Example 3)? " + sol.hasCycle(head3)); // false

        // Example 4: Single node with cycle (node points to itself)
        ListNode head4 = new ListNode(1);
        head4.next = head4; // self-cycle
        System.out.println("Has cycle (Example 4)? " + sol.hasCycle(head4)); // true
    }
}
