public class Solution {

    // Function to count occurrences of target in a sorted array
    public static int count(int nums[], int n, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans1 = -1;

        // First Binary Search: Find the first occurrence of target
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Mid calculation to avoid integer overflow

            if (nums[mid] < target) {
                // Target is on the right half
                low = mid + 1;
            } else {
                // Target could be at mid or to the left
                if (nums[mid] == target) {
                    ans1 = mid; // Update first occurrence index
                }
                high = mid - 1;
            }
        }
           
        if(ans1<0) return 0;
 
        // Reset pointers for second binary search
        low = 0;
        high = nums.length - 1;
        int ans2 = -1;

        // Second Binary Search: Find the last occurrence of target
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Mid calculation to avoid integer overflow

            if (nums[mid] > target) {
                // Target is on the left half
                high = mid - 1;
            } else {
                // Target could be at mid or to the right
                if (nums[mid] == target) {
                    ans2 = mid; // Update last occurrence index
                }
                low = mid + 1;
            }
        }

        // If no occurrence found, return 0
        // Otherwise return total count = lastIndex - firstIndex + 1
        return (ans2 - ans1) == 0 ? 0 : (ans2 - ans1 + 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 4, 4, 4};

        // Testing with target = 1
        System.out.println(count(arr, arr.length,4));  // Expected Output: 2
        
    }

}