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
     * Split a linked list into k parts
     * Parts should be as equal as possible, with earlier parts bigger if needed
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Count length
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: Find base size and remainder
        int partSize = length < k ? 1 : length / k;
        int extra = length < k ? 0 : length % k;

        // Step 3: Split into parts
        ListNode[] result = new ListNode[k];
        temp = head;
        for (int idx = 0; idx < k; idx++) {
            if (temp == null) {
                result[idx] = null;
                continue;
            }

            result[idx] = temp; // head of this part
            int currentSize = partSize + (extra > 0 ? 1 : 0);

            // move to end of this part
            for (int i = 1; i < currentSize; i++) {
                temp = temp.next;
            }

            // cut connection
            ListNode next = temp.next;
            temp.next = null;
            temp = next;

            if (extra > 0) extra--;
        }

        return result;
    }

    // Helper to print array of linked lists
    public static void printParts(ListNode[] parts) {
        for (int i = 0; i < parts.length; i++) {
            System.out.print("Part " + (i + 1) + ": ");
            ListNode node = parts[i];
            while (node != null) {
                System.out.print(node.val);
                if (node.next != null) System.out.print(" -> ");
                node = node.next;
            }
            System.out.println();
        }
    }

    // Main method to test locally
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 10; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        int k = 3;
        ListNode[] parts = sol.splitListToParts(head, k);

        // Print result
        printParts(parts);
    }
}
