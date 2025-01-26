// Brute Force Approach: Nested Loops to Check All Subarrays
public class Brute {
    /**
     * Finds the length of the longest subarray with a sum equal to k using a brute force approach.
     *
     * @param arr  Input array of integers.
     * @param sumk Target sum.
     */
    public static void maxSubArrayWithSumK(int arr[], int sumk) {
        int sum = 0; // Variable to store the sum of the current subarray
        int maxLength = Integer.MIN_VALUE; // Stores the maximum length of the subarray

        // Iterate over all possible subarrays
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = 0; // Reset the sum for each subarray

                // Calculate the sum of the current subarray
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                // Check if the sum equals the target and update max length
                if (sum == sumk) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        System.out.println(maxLength); // Output the maximum length of the subarray
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3, 1, 2, 1, 1, 1}; // Input array
        int k = 3; // Target sum
        maxSubArrayWithSumK(arr, k); // Call the method
    }
}
