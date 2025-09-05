class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {

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
     // LinkedList nodes
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);

    // Create linked list 1 -> 2 -> 3 -> 4 -> 5
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    // Make cycle: 5 -> 3
    n5.next = n3;

    Solution sol = new Solution();
    System.out.println("Cycle length: " + sol.countCycle(n1));
    }
}
