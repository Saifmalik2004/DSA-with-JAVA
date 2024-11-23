public class MergeSort {

   
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        mergeSort(arr, 0, arr.length - 1); 
        print(arr); 
    }

   
    public static void mergeSort(int arr[], int start, int end) {
        // Base case: if the segment has one or zero elements, it's already sorted
        if (start >= end) {
            return;
        }

        // Calculating the middle index
        int middle = start + (end - start) / 2;

        // Recursive calls to sort the left and right halves
        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);

        // Merging the sorted halves
        merge(arr, start, end, middle);
    }

    // Merge function to combine two sorted halves
    public static void merge(int[] arr, int start, int end, int middle) {
        int temp[] = new int[end - start + 1]; // Temporary array to store merged result

        int i = start;        // Pointer for the left half
        int j = middle + 1;   // Pointer for the right half
        int k = 0;            // Pointer for the temporary array

        // Compare elements from both halves and place the smaller one into temp
        while (i <= middle && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left half, if any
        while (i <= middle) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the right half, if any
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy the merged array back into the original array
        for (i = start, k = 0; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // Utility function to print the array
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.err.println();
    }
}
