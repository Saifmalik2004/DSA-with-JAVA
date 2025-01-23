public class Optimize {
    // Method to find the maximum consecutive ones in the array
    public static void maxOnes(int arr[]) {
        int count = 0; // To count consecutive ones
        int max = Integer.MIN_VALUE; // To store the maximum count of consecutive ones

        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is 1
            if (arr[i] == 1) {
                count++; // Increment the count of consecutive ones
                max = Math.max(count, max); // Update the max if the current count is greater
            } else {
                count = 0; // Reset the count if the current element is not 1
            }
        }

        // Print the maximum number of consecutive ones found
        System.out.println(max);
    }

    public static void main(String[] args) {
        // Define an array containing 0s and 1s
        int arr[] = {0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1};

        // Call the method to find the maximum consecutive ones in the array
        maxOnes(arr);
    }
}
