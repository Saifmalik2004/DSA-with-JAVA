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
     * Deletes a node in a singly linked list.
     * Important: You are given access to the node to be deleted, 
     * NOT the head of the list.
     * 
     * Idea: Copy the value of the next node into the current node,
     * then unlink the next node.
     */
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return; // last node ko delete nahi kar sakte
        }
        node.val = node.next.val;
        node.next = node.next.next;
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

        // Create LinkedList: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.println("Original List:");
        printList(head);

        // Suppose we want to delete node with value 5
        sol.deleteNode(head.next); // passing node '5'

        System.out.println("List after deleting node 5:");
        printList(head);
    }
}
