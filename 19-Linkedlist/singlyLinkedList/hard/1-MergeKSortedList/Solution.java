import java.util.PriorityQueue;

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
     * Merge k sorted linked lists into one sorted linked list.
     * Uses a Min-Heap (PriorityQueue) for efficient merging.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null; // If no lists, return null
        }

        // Dummy node to simplify list building
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        // Min-Heap based on node values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add first node of each list to the heap
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        // Process heap until empty
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();   // Get smallest node
            temp.next = curr;            // Add it to merged list
            temp = temp.next;

            if (curr.next != null) {     // Push next node from same list
                pq.offer(curr.next);
            }
        }

        return dummy.next; // Head of merged list
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
        // Example:
        // list1 = 1 -> 4 -> 5
        // list2 = 1 -> 3 -> 4
        // list3 = 2 -> 6
        // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

        // Create list1
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // Create list2
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // Create list3
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        // Merge lists
        Solution sol = new Solution();
        ListNode[] lists = {l1, l2, l3};
        ListNode mergedHead = sol.mergeKLists(lists);

        // Print result
        System.out.print("Merged List: ");
        printList(mergedHead);
    }
}
