import java.util.ArrayList;

public class Brute {

    // Method to rotate the array by 'd' positions
    public static void roatedByD(int arr[], int d) {
        int n = arr.length; // Get the size of the array
        d = d % n;          // Handle cases where d is greater than the array size
        
        // Step 1: Create a temporary list to store the first 'd' elements
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            temp.add(arr[i]); // Add the first 'd' elements to the temporary list
        }

        // Step 2: Shift the remaining elements of the array to the left
        int start = 0;       // Index to place shifted elements in the array
        for (int j = d; j < n; j++) {
            arr[start++] = arr[j]; // Overwrite elements in the array with shifted values
        }

        // Step 3: Copy the temporary list back to the end of the array
        for (int j = n - d; j < n; j++) {
            arr[j] = temp.get(j - (n - d)); // Get the corresponding value from the temp list
        }
    }

    public static void main(String[] args) {
        // Input array
        int arr[] = {1, 2, 3, 4, 5, 6};

        // Rotate the array by 2 positions
        roatedByD(arr, 2);

        // Output the rotated array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // Print each element followed by a space
        }
    }
}
