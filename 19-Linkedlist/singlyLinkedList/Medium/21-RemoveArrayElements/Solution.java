import java.util.HashSet;

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
     * Function to remove all nodes from the linked list
     * whose values are present in the nums array.
     */
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Put nums into a HashSet for O(1) lookups
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        // Dummy node to handle head deletions easily
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = dummy;

        // Traverse list and skip nodes whose values are in the set
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next; // Remove node
            } else {
                temp = temp.next;
            }
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

    // Helper function to create LinkedList from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Main method with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] nums1 = {2, 4};
        ListNode head1 = createList(arr1);
        System.out.print("Original: ");
        printList(head1);
        ListNode ans1 = sol.modifiedList(nums1, head1);
        System.out.print("Modified: ");
        printList(ans1); // Expected: 1 -> 3 -> 5

        // Test case 2: Remove head value
        int[] arr2 = {7, 8, 9};
        int[] nums2 = {7};
        ListNode head2 = createList(arr2);
        System.out.print("\nOriginal: ");
        printList(head2);
        ListNode ans2 = sol.modifiedList(nums2, head2);
        System.out.print("Modified: ");
        printList(ans2); // Expected: 8 -> 9

        // Test case 3: Remove all nodes
        int[] arr3 = {1, 1, 1};
        int[] nums3 = {1};
        ListNode head3 = createList(arr3);
        System.out.print("\nOriginal: ");
        printList(head3);
        ListNode ans3 = sol.modifiedList(nums3, head3);
        System.out.print("Modified: ");
        printList(ans3); // Expected: (empty)

        // Test case 4: No removals
        int[] arr4 = {5, 6, 7};
        int[] nums4 = {10, 11};
        ListNode head4 = createList(arr4);
        System.out.print("\nOriginal: ");
        printList(head4);
        ListNode ans4 = sol.modifiedList(nums4, head4);
        System.out.print("Modified: ");
        printList(ans4); // Expected: 5 -> 6 -> 7
    }
}
