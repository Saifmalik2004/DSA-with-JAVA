public class DNFAlgo {
    /**
     * Sorts an array containing only 0s, 1s, and 2s using the Dutch National Flag Algorithm.
     * This approach uses three pointers (low, mid, high) for in-place sorting.
     */
    public static void sort012(int arr[]) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                // Swap arr[mid] and arr[high]
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 2, 2, 0, 0, 1, 1, 0, 1, 2, 0, 0};
        sort012(arr);

        // Print sorted array
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }
}
