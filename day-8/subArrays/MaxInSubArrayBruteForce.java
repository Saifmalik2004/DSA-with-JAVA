public class MaxInSubArrayBruteForce {

    // This method prints all possible subarrays and calculates the minimum and maximum sum of subarrays
    public static void printSubArray(int num[]) {
        int total = 0; // Total count of subarrays
        int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer value

        // Outer loop to define the start of the subarray
        for (int i = 0; i < num.length; i++) {
            int start = i; // The start index of the subarray

            // Inner loop to define the end of the subarray
            for (int j = i; j < num.length; j++) {
                int end = j; // The end index of the subarray
                int sum = 0; // Initialize sum of the current subarray to 0

                // Loop to print the subarray and calculate its sum
                for (int k = start; k <= end; k++) {
                    System.out.print(num[k] + " "); // Print each element of the subarray
                    sum = sum + num[k]; // Add the current element to the sum
                }

            
                // Check if the current subarray sum is larger than maxSum
                if (sum > maxSum) {
                    maxSum = sum; // Update maxSum if the current subarray sum is larger
                }

                total++; // Increment the total number of subarrays
                System.out.print(" Sum: " + sum); // Print the sum of the current subarray
                System.out.println(); // Move to the next line after printing the subarray and sum
            }

            // Print a blank line after processing each starting index to separate subarrays visually
            System.out.println();
        }

        // Print the total number of subarrays
        System.out.println("Total number of subarrays: " + total);

        // Print the maximum sum of all subarrays
        System.out.println("Maximum sum of subarrays: " + maxSum);
    }

    // Main method to run the program
    public static void main(String[] args) {
        int num[] = {2,4,6,8,10}; // Example array of numbers
        printSubArray(num); // Call the printSubArray method with the example array
    }
}
