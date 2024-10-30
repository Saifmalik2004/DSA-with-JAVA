public class SelectionSort {

    // Function to perform Selection Sort on an array
    public static void selectionSort(int[] arr) {

        // Outer loop to iterate through the unsorted part of the array
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i; // Assume the minimum element is at index 'i'

            // Inner loop to find the actual minimum element in the remaining unsorted part
            for (int j = i + 1; j < arr.length; j++) {
                // Update min if a smaller element is found
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            // Swap the found minimum element with the element at index 'i'
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 7, 10, 6, 1, 2, 9, 11, 3, 8}; // Sample array

        selectionSort(arr); // Sort the array

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
