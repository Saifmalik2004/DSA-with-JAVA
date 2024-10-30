public class CountingSort {
    
    // Method to perform counting sort on the array
    public static void countingSort(int[] arr) {
        int largest = Integer.MIN_VALUE;  // Variable to store the largest element in the array

        // Loop to find the largest element in the array
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);  // Update 'largest' if the current element is greater
        }

        // Create a count array to store the frequency of each number up to 'largest'
        int[] count = new int[largest + 1];
        
        // Populate the count array by incrementing the count of each element in 'arr'
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;  // Increase the count of each element's value as index
        }

        int j = 0;  // Variable to track position in the original array

        // Refill the original array in sorted order
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {    // Repeat for each occurrence of the value
                arr[j] = i;           // Place 'i' in the array at index 'j'
                j++;                  // Move to the next index in 'arr'
                count[i]--;           // Decrease the count after placing the value
            }
        }
    }

    // Main method to test the countingSort function
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};  // Define an unsorted array of integers

        countingSort(arr);  // Call the counting sort function on 'arr'
     
        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");  // Output each element followed by a space
        }
        System.out.println();  // Print a new line after the sorted array
    }
}
