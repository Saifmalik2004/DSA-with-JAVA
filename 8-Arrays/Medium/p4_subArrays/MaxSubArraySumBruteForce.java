 
 public class MaxSubArraySumBruteForce {

    // This method calculates and prints all possible subarrays, their sums, and the maximum subarray sum (using brute-force)
    public static void printSubArray(int num[]) {
        int total = 0; 
        int maxSum = Integer.MIN_VALUE;
        int curSum; 

        // Outer loop to set the starting index of each subarray
        for (int i = 0; i < num.length; i++) {
            int start = i; 
            
            // Inner loop to set the ending index of each subarray
            for (int j = i; j < num.length; j++) {
                int end = j; // The end index of the subarray
                curSum = 0; // Initialize current subarray sum to 0 for each new subarray

                // Loop to print each element of the subarray and calculate its sum
                for (int k = start; k <= end; k++) {
                    System.out.print(num[k] + " "); // Print each element of the subarray
                    curSum += num[k]; // Add the current element to the subarray sum
                }

                // Check if the current subarray sum is greater than maxSum
                if (curSum > maxSum) {
                    maxSum = curSum; // Update maxSum if the current subarray sum is greater
                }

                total++; // Increment the count of total subarrays processed
                System.out.print(" Sum: " + curSum); // Print the sum of the current subarray
                System.out.println(); // Move to a new line after printing each subarray and its sum
            }

            // Print a blank line after processing each starting index to separate subarrays visually
            System.out.println();
        }

        // Print the total number of subarrays generated
        System.out.println("Total number of subarrays: " + total);

        // Print the maximum sum of all possible subarrays
        System.out.println("Maximum sum of subarrays: " + maxSum);
    }

    // Main method to run the program
    public static void main(String[] args) {
        int num[] = {2, 4, 6, -8, 10}; // Example array of numbers
        printSubArray(num); // Call the printSubArray method with the example array
    }
}
