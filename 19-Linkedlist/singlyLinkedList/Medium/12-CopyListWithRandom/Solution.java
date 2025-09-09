import java.util.HashMap;

// Definition for a Node in the linked list
class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    // Function to copy a linked list with random pointers
    public ListNode copyRandomList(ListNode head) {
        if (head == null) return null;

        HashMap<ListNode, ListNode> map = new HashMap<>();

        // Step 1: Create all nodes (only val, no random/next links yet)
        ListNode temp = head;
        while (temp != null) {
            map.put(temp, new ListNode(temp.val));
            temp = temp.next;
        }

        // Step 2: Assign next and random pointers using map
        temp = head;
        while (temp != null) {
            ListNode copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);       // link next
            copyNode.random = map.get(temp.random);   // link random
            temp = temp.next;
        }

        return map.get(head); // return head of copied list
    }

    // Helper to print list with random pointers
    public static void printList(ListNode head) {
        while (head != null) {
            int randomVal = (head.random != null) ? head.random.val : -1;
            System.out.print("[" + head.val + ", random=" + randomVal + "]");
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: Simple 3 node list
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        // random pointers
        n1.random = n3; // 1 → 3
        n2.random = n1; // 2 → 1
        n3.random = n2; // 3 → 2

        System.out.println("Original List:");
        printList(n1);

        ListNode copied1 = sol.copyRandomList(n1);
        System.out.println("Copied List:");
        printList(copied1);
        System.out.println();

        // Test 2: Single node pointing to itself
        ListNode x = new ListNode(10);
        x.random = x;

        System.out.println("Original List:");
        printList(x);

        ListNode copied2 = sol.copyRandomList(x);
        System.out.println("Copied List:");
        printList(copied2);
        System.out.println();

        // Test 3: Empty list
        ListNode copied3 = sol.copyRandomList(null);
        System.out.println("Copied List from empty: " + copied3);
    }
}
