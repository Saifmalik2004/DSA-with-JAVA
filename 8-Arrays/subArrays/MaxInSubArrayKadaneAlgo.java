public class MaxInSubArrayKadaneAlgo {

    // This method implements Kadane's Algorithm to find the maximum sum of a contiguous subarray
    public static void KadaneAlgo(int arr[]) {
    
        int currSum = 0; // Variable to store the sum of the current subarray
        int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer value
        
        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i]; // Add the current element to the current subarray sum

            // Update maxSum if currSum is greater than the current maxSum
            maxSum = Math.max(currSum, maxSum);

            // If currSum becomes negative, reset it to 0 to start a new subarray
            if (currSum < 0) {
                currSum = 0;
            }
        }

        // Print the maximum sum found
        System.out.print(maxSum);
    }

    // Main method to run the program
    public static void main(String[] args) {
        int arr[] = {-3, -4, -5, -4, -1, -7, -8}; // Example array with negative values
        KadaneAlgo(arr); // Call Kadane's algorithm to find the maximum subarray sum
    }
}
