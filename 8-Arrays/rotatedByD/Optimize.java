public class Optimize {

    // Method to reverse a portion of the array
    public static void reverse(int arr[], int first, int last) {
        // Swap elements from the start and end indices until they meet in the middle
        while (first <= last) {
            int temp = arr[first];   // Temporarily store the element at the start index
            arr[first] = arr[last]; // Replace the start element with the end element
            arr[last] = temp;       // Place the stored element in the end position
            first++;                // Move the start index forward
            last--;                 // Move the end index backward
        }
    }

    // Method to rotate the array by k positions
    public static void rotatedByk(int arr[], int k) {
        int n = arr.length;    // Get the size of the array
        k = k % n;             // Handle cases where k is greater than the array size

        // Step 1: Reverse the first k elements
        reverse(arr, 0, k - 1);

        // Step 2: Reverse the remaining elements from k to the end
        reverse(arr, k, n - 1);

        // Step 3: Reverse the entire array to complete the rotation
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        // Input array
        int arr[] = {1, 2}; 
        
        // Number of positions to rotate
        rotatedByk(arr, 2); 

        // Output the rotated array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]); // Print each element of the array
        }
    }
}
