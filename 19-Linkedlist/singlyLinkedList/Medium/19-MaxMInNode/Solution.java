// Definition for singly-linked list node
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
     * Function to find minimum and maximum distance between critical points in a LinkedList.
     * Critical point = a node which is either:
     * - Local maxima (greater than both neighbors)
     * - Local minima (smaller than both neighbors)
     */
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;

        int first = -1, last = -1;
        int idx = 1; // index of mid
        int[] ans = {-1, -1};
        int minDistance = Integer.MAX_VALUE;

        // Traverse until right reaches end
        while (right != null) {
            int pre = left.val;
            int curr = mid.val;
            int next = right.val;

            // Check if mid is a critical point
            if ((curr > pre && curr > next) || (curr < pre && curr < next)) {
                if (first == -1) first = idx; // first critical point index
                if (last != -1) {
                    minDistance = Math.min(minDistance, idx - last);
                }
                last = idx; // update last critical point
            }

            // Move sliding window
            left = mid;
            mid = right;
            right = right.next;
            idx++;
        }

        // If only one critical point found → return [-1, -1]
        if (last == first) return ans;

        ans[0] = minDistance;
        ans[1] = last - first; // max distance
        return ans;
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

    // Main method to test locally
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: Example with multiple critical points
        int[] arr1 = {1, 3, 2, 2, 3, 2, 2, 2, 7};
        ListNode head1 = createList(arr1);
        printList(head1);
        int[] ans1 = sol.nodesBetweenCriticalPoints(head1);
        System.out.println("Output: [" + ans1[0] + ", " + ans1[1] + "]"); // Expected: [3, 3]

        // Test case 2: No critical points
        int[] arr2 = {2, 2, 2, 2};
        ListNode head2 = createList(arr2);
        printList(head2);
        int[] ans2 = sol.nodesBetweenCriticalPoints(head2);
        System.out.println("Output: [" + ans2[0] + ", " + ans2[1] + "]"); // Expected: [-1, -1]

        // Test case 3: Only one critical point
        int[] arr3 = {1, 2, 3, 2};
        ListNode head3 = createList(arr3);
        printList(head3);
        int[] ans3 = sol.nodesBetweenCriticalPoints(head3);
        System.out.println("Output: [" + ans3[0] + ", " + ans3[1] + "]"); // Expected: [-1, -1]

        // Test case 4: Two critical points far apart
        int[] arr4 = {5, 1, 5, 1, 5};
        ListNode head4 = createList(arr4);
        printList(head4);
        int[] ans4 = sol.nodesBetweenCriticalPoints(head4);
        System.out.println("Output: [" + ans4[0] + ", " + ans4[1] + "]"); // Expected: [2, 2]
    }
}
