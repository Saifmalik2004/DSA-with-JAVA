public class Optimize {

    // Method to find the single (non-repeating) element in the array
    public static int getSingleElement(int[] arr) {
        int xor = 0; // Initialize XOR accumulator
        
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i]; // XOR current element with the accumulator
        }
        
        // Return the single (non-repeating) element
        return xor;
    }

    public static void main(String[] args) {
        // Input array where all elements appear twice except one
        int arr[] = {1, 1, 2, 2, 3, 4, 4, 5, 5};

        // Call the method and print the single (non-repeating) element
        System.out.println(getSingleElement(arr));
    }
}
