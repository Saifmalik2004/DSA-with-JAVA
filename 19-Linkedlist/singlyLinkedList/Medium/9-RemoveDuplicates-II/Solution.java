class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Solution {
   
     public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy= new ListNode(-1);
        ListNode prev=dummy;


        ListNode current=head;

        while(current!=null){
            ListNode temp=current.next;
            boolean dup=false;
            while(temp!=null && temp.val==current.val){
                dup=true;
                temp=temp.next;
            }
            if(!dup){
                prev.next=current;
                prev=prev.next;

            }
            current=temp;
        }
        prev.next = null;
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
       
    }
}
