public class Optimize {

    public static int findRotation(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // If array is already sorted
            if (arr[low] <= arr[high]) {
                return low;
            }

            int mid = low + (high - low) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid - 1 + arr.length) % arr.length;

            // Check if mid is the smallest (pivot point)
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                low = mid + 1;
            }
            // Right half is sorted
            else {
                high = mid - 1;
            }
        }

        return 0; // fallback, should never happen if array is rotated sorted
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        System.out.println(findRotation(arr));  // Output: 3
    }
}
