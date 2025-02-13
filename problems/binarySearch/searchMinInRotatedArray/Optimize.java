public class Optimize {
    // Function to find the minimum element in a rotated sorted array
    public static int searchMIn(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int Min = Integer.MAX_VALUE; // Initialize Min to the maximum possible value

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid index to avoid overflow

            // If the subarray is already sorted, the leftmost element is the minimum
            if (nums[low] <= nums[high]) {
                Min = Math.min(Min, nums[low]);
                break;
            }

            // If the left half is sorted
            if (nums[low] <= nums[mid]) {
                Min = Math.min(Min, nums[low]); // Update Min with the leftmost element
                low = mid + 1; // Move to the right half
            } else { 
                // Right half is sorted, so the minimum might be in the left half
                high = mid - 1;
                Min = Math.min(Min, nums[mid]); // Update Min with mid element
            }
        }

        return Min; // Return the minimum element found
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6};

        // Print the minimum element in the rotated sorted array
        System.out.println(searchMIn(arr));
    }
}
