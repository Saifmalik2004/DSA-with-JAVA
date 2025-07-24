
public class Solution {

    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // To avoid overflow

            if (arr[mid] == target) {
                return mid;  // Target found at index mid
            }

            // Check if left half is sorted
            if (arr[low] <= arr[mid]) {
                // If target lies within the sorted left half
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Else right half must be sorted
            else {
                // If target lies within the sorted right half
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;  // Target not found
    }
    
// 1. Har iteration me dekho — left sorted hai ya right.
// 2. Target usme fit hota hai to us half me jao.
// 3. Nahi to opposite half me jao.

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;

        int index = search(arr, target);
        System.out.println("Target found at index: " + index);  // Output: 4
    }
}
