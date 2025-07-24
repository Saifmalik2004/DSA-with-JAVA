public class Optimize {

    public static int findRotation(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE; 
        int rotationNum = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Entire range is already sorted
            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    min = arr[low];
                    rotationNum = low;
                }
                break;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    rotationNum = low;
                }
                low = mid + 1; // Search right
            } 
            // Right half is sorted or pivot is in left half
            else {
                if (arr[mid] < min) {   // Check first before moving high
                    min = arr[mid];
                    rotationNum = mid;
                }
                high = mid - 1;
            }
        }

        return rotationNum;
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6};

        System.out.println(findRotation(arr));  // Output: 3 (index of element 1)
    }
}
