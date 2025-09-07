class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }
    public ListNode addOne( ListNode head) {
        head=reverse(head);
        ListNode dummy = new ListNode(-1);
        int carry = 1;
        

        while ( head != null ) {
            int a =  head.val;

            int total = a  + carry;
            int digit = total % 10;
            carry = total / 10;
            ListNode newNode= new ListNode(digit);
            ListNode next=dummy.next;
            dummy.next =newNode;
            newNode.next = next;

            head=head.next;

        }
        if(carry!=0){
            ListNode newNode= new ListNode(carry);
            ListNode next=dummy.next;
            dummy.next =newNode;
            newNode.next = next;
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

    // Main method to test locally
    public static void main(String[] args) {
        // First number: 99
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
     

       

        Solution sol = new Solution();
        ListNode result = sol.addOne(l1);

        // Print result (should be 99 as 1 -> 0 -> 0)
        printList(result);
    }
}
