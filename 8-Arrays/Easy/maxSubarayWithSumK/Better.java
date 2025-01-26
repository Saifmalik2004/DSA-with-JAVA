import java.util.HashMap;
import java.util.Map;

// Optimized Approach: Using HashMap for Prefix Sum
public class Better {
    /**
     * Finds the length of the longest subarray with a sum equal to k using HashMap.
     *
     * @param arr Input array of integers.
     * @param k   Target sum.
     */
    public static void maxSubArrayWithSumK(int arr[], int k) {
        long sum = 0; // Variable to store the cumulative sum
        int maxLength = 0; // Stores the maximum length of the subarray

        Map<Long, Integer> preMap = new HashMap<>(); // Map to store prefix sums and their indices

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update the cumulative sum

            // Case 1: If the cumulative sum equals k, the subarray starts from the beginning
            if (sum == k) {
                maxLength = i + 1; // Update max length
            }

            // Case 2: Check if (sum - k) exists in the prefix map
            long remainder = sum - k;
            if (preMap.containsKey(remainder)) {
                // Calculate the length of the current subarray
                int length = i - preMap.get(remainder);
                maxLength = Math.max(maxLength, length); // Update max length
            }

            // Store the cumulative sum in the map if not already present
            if (!preMap.containsKey(sum)) {
                preMap.put(sum, i);
            }
        }
        System.out.println(maxLength); // Output the maximum length of the subarray
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 0, 0, 1, 1}; // Input array
        int k = 4; // Target sum
        maxSubArrayWithSumK(arr, k); // Call the method
    }
}
