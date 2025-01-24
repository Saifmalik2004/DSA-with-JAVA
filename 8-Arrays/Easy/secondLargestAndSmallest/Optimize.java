public class Optimize {

    // Method to find the second largest and smallest numbers
    public static int[] findSlargestAndSmallest(int arr[]) {
        int largest = Integer.MIN_VALUE;   // Largest initialized to smallest possible value
        int secondLargest = Integer.MIN_VALUE; // Second largest initialized similarly
        int smallest = Integer.MAX_VALUE; // Smallest initialized to largest possible value
        int secondSmallest = Integer.MAX_VALUE; // Second smallest initialized similarly

        // Single loop to find both largest/smallest and second largest/smallest
        for (int num : arr) {
            // Update largest and second largest
            if (num > largest) {
                secondLargest = largest; // Previous largest becomes second largest
                largest = num; // Update largest
            } else if (num > secondLargest && num != largest) {
                secondLargest = num; // Update second largest if conditions met
            }

            // Update smallest and second smallest
            if (num < smallest) {
                secondSmallest = smallest; // Previous smallest becomes second smallest
                smallest = num; // Update smallest
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num; // Update second smallest if conditions met
            }
        }

        return new int[]{secondSmallest, secondLargest}; // Return results
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 2}; // Example input

        // Call the method and store the result
        int[] result = findSlargestAndSmallest(arr);

        // Print the second smallest and second largest
        System.out.println("Second Smallest: " + result[0]);
        System.out.println("Second Largest: " + result[1]);
    }
}
