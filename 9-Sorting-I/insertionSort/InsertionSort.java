public class InsertionSort {

    // Function to perform Insertion Sort on an array
    public static void insertionSort(int[] arr) {

        // Loop through each element starting from the second element
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];    // Current element to be inserted in the sorted part
            int prev = i - 1;     // Previous index to compare with

            // Shift elements of the sorted part that are greater than curr
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev]; // Move element one position to the right
                prev--;                    // Move to the next previous element
            }

            // Place the current element at its correct position in sorted part
            arr[prev + 1] = curr;
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 7, 1}; // Sample array for testing

        insertionSort(arr); // Sort the array

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
