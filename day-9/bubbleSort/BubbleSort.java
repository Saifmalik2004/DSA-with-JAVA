public class BubbleSort {

    // Function to perform Bubble Sort on an array
    public static void BubbleSort(int[] arr) {

        // Outer loop to iterate over the entire array
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false; // Flag to track if a swap was made in the inner loop

            // Inner loop to compare adjacent elements
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // If the current element is greater than the next, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true; // Set swap to true if any elements were swapped
                }
            }

            // If no swaps occurred in the inner loop, the array is sorted; exit early
            if (!swap) return;
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 7, 6, 1, 2, 9, 11, 3}; // Sample array

        BubbleSort(arr); // Sort the array

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
