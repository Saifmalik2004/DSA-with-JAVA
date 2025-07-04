public class Solution {

    // Function to rotate the array by 1 position
    public static void roated(int arr[]) {
        // Get the length of the array
        int n = arr.length;

        // Store the first element to be moved to the end
        int temp = arr[0];

        // Start from the second element (index 1)
        int i = 1;
        
        // Loop through the array starting from index 1
        while (i < n) {
            // Shift each element one position to the left
            arr[i - 1] = arr[i];
            i++; // Move to the next element
        }

        // Place the first element (stored in 'temp') at the last position
        arr[n - 1] = temp;
    }

    // Main method to test the rotation
    public static void main(String[] args) {
        // Define an array to rotate
        int arr[] = {1, 2, 3, 4, 5};
        
        // Call the rotate function
        roated(arr);

        // Print the rotated array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // Output: 2 3 4 5 1
        }
    }
}
