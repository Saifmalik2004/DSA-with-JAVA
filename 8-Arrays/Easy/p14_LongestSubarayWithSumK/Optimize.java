// Optimized Sliding Window Approach
public class Optimize {

    /**
     * Finds the length of the longest subarray with a sum equal to k using the sliding window technique.
     *
     * @param arr Input array of integers.
     * @param k   Target sum.
     */
    public static void maxSubArrayWithSumK(int arr[], int k) {
        int right = 0, left = 0; // Pointers for the sliding window
        int sum = arr[0]; // Initialize the sum with the first element
        int maxLen = 0; // Variable to store the maximum length of the subarray
        int n = arr.length; // Length of the input array

        // Iterate through the array using the sliding window technique
        while (right < n) {
            // If the current sum is greater than k, move the left pointer to reduce the sum
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            // If the current sum equals k, update the maximum length
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move the right pointer to expand the window
            right++;

            // Add the next element to the sum if the right pointer is still within bounds
            if (right < n) {
                sum += arr[right];
            }
        }

        // Output the maximum length of the subarray
        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, -1, 0, 0, 4}; // Input array
        int k = 4; // Target sum
        maxSubArrayWithSumK(arr, k); // Call the method
    }
}
