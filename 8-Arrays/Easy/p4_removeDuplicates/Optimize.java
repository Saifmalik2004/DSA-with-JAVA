public class Optimize {
    // Method to remove duplicates from the array
    public static int removeDuplicates(int[] arr, int n) {
        int j = 0;  // Pointer to track unique elements
        
        // Start from the second element and compare with the previous one
        for (int i = 1; i < n; i++) {
            // If current element is not equal to the previous unique element
            if (arr[i] != arr[j]) {
                j++;  // Move the pointer to the next unique element position
                arr[j] = arr[i];  // Place the current element in the unique position
            }
        }

        // Return the count of unique elements (j+1 because j is an index)
        return j + 1;
    }

    public static void main(String[] args) {
        // Sample array
        int[] arr = {1, 1, 2, 2, 3, 3, 4};
        int n = arr.length;
        
        // Calling the method and getting the result
        int newLength = removeDuplicates(arr, n);
        
        // Print the modified array (unique elements only)
        System.out.println("Number of unique elements: " + newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.print(arr[i] + " ");  // Print each unique element
        }
    }
}
