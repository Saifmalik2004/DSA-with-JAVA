public class MaxSubArraySumPreFix {

    // This method calculates the maximum sum of all possible subarrays using the prefix sum technique
    public static void printSubArray(int num[]) {
       
        int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer value
        int sum; // Variable to store the sum of the current subarray
        int prefix[] = new int[num.length]; // Array to store prefix sums up to each index
                
        // Initialize the first element of the prefix array
        prefix[0] = num[0];
        
        // Calculate prefix sum array
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + num[i]; // Current prefix is the sum of previous prefix and the current element
        }

        // Outer loop to define the start of the subarray
        for (int i = 0; i < num.length; i++) {
           
            // Inner loop to define the end of the subarray
            for (int j = i; j < num.length; j++) {
                
                // Calculate sum of subarray from index `i` to `j`
                // If `i` is 0, take the prefix sum at `j`; otherwise, subtract prefix at `i-1`
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];

                // Update maxSum if the current subarray sum is larger than the previous maxSum
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        // Print the maximum sum of all subarrays
        System.out.println("Maximum sum of subarrays: " + maxSum);
    }

    // Main method to run the program
    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8, 10}; // Example array of numbers
        printSubArray(num); // Call the printSubArray method with the example array
    }
}
