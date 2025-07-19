import java.util.HashMap;
import java.util.Map;

public class Brute {
    // Method to find elements that appear more than n/3 times
    public static int[] majorityElement(int arr[]) {
        int n = arr.length; // Length of the array
        int idx = 0; // Index for storing majority elements
        int f = n / 3; // Frequency threshold for majority element
        Map<Integer, Integer> freq = new HashMap<>(); // HashMap to store frequency count
        int ans[] = new int[2]; // Array to store result (since at most 2 elements can be > n/3)

        // Count occurrences of each element
        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

            // If an element's frequency exceeds n/3, store it in the answer
            if (freq.get(arr[i]) == f + 1) {
                ans[idx++] = arr[i];
            }
        }

        return ans; // Return the majority elements
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 3, 3, 3, 2}; // Sample input array
        int res[] = majorityElement(arr); // Find majority elements

        // Print the result
        for (int elem : res) {
            System.out.println(elem);
        }
    }
}
