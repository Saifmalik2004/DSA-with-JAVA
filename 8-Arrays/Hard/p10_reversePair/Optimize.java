public class Optimize {

    // Main function to count reverse pairs in the array
    public static int reversePair(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    // Recursive merge sort function that returns reverse pair count
    public static int mergeSort(int arr[], int low, int high) {
        int count = 0;

        // Base condition
        if (low < high) {
            int mid = low + (high - low) / 2;

            // Sort and count for left half
            count += mergeSort(arr, low, mid);

            // Sort and count for right half
            count += mergeSort(arr, mid + 1, high);

            // Count reverse pairs across both halves
            count += countPair(arr, low, mid, high);

            // Merge the two sorted halves
            merge(arr, low, mid, high);
        }

        return count;
    }

    // Function to count reverse pairs between two sorted halves
    public static int countPair(int arr[], int low, int mid, int high) {
        int count = 0;
        int i = low;
        int j = mid + 1;

        while (i <= mid) {
            // Move pointer j until arr[i] <= 2 * arr[j] fails
            while (j <= high && (long) arr[i] > 2L * arr[j]) {
                j++;
            }

            // All elements from mid+1 to j-1 will satisfy condition for current i
            count += (j - (mid + 1));
            i++;
        }

        return count;
    }

    // Standard merge function for merge sort
    public static void merge(int arr[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;

        int temp[] = new int[high - low + 1]; // Temporary array to store merged result

        // Merge both halves into temp[]
        while (i <= mid && j <= high) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }

        // Copy any remaining elements from left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy any remaining elements from right half
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // Copy merged elements back to original array
        for (i = 0, k = low; i < temp.length; i++) {
            arr[k++] = temp[i];
        }
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {2, 4, 3, 5, 1};

        // Output the count of reverse pairs
        System.out.println(reversePair(arr)); // Expected output: 3
    }
}
