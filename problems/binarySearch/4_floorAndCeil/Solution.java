public class Solution {

    public static int ceil(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];  // Potential ceil found
                high = mid - 1;  // Look for smaller valid number
            } else {
                low = mid + 1;   // Move to higher values
            }
        }
        return ans;
    }

    public static int floor(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target) {
                ans = arr[mid];  // Potential floor found
                low = mid + 1;   // Look for larger valid number
            } else {
                high = mid - 1;  // Move to lower values
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5};

        System.out.println("Floor of 2: " + floor(arr, 2));
        System.out.println("Ceil of 2: " + ceil(arr, 2));
    }
}
