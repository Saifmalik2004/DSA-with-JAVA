import java.util.HashSet;
import java.util.Set;

public class Optimize {
    public static int maxConsecutive(int[] a) {
        int n = a.length;
        if (n == 0) {
            return 0; // Handle empty array case
        }

        int maxLen = 1; // Tracks the maximum sequence length
        Set<Integer> set = new HashSet<>(); // Stores unique elements for quick lookup

        // Add all elements to the set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Traverse the set and find sequences starting with elements that have no predecessor
        for (int item : set) {
            if (!set.contains(item - 1)) { // Start a new sequence only if there's no predecessor
                int count = 1;
                int x = item;

                // Find the length of the sequence
                while (set.contains(x + 1)) {
                    x = x + 1;
                    count++;
                }

                maxLen = Math.max(maxLen, count); // Update maximum sequence length
            }
        }

        System.out.println(maxLen); // Print the result
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = {102, 4, 100, 1, 101, 3, 2, 1};
        maxConsecutive(arr);
    }
}
