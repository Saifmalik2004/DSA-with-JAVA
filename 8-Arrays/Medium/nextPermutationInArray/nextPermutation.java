public class nextPermutation {
    // Function to find the next permutation of the given array
    public static void next(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i; // Record the index where the sequence breaks
                break;
            }
        }

        // Step 2: If no such element is found, the array is in descending order
        if (breakPoint == -1) {
            reverse(nums, 0, n - 1); // Reverse the array to get the smallest permutation
            return;
        }

        // Step 3: Find the smallest element greater than nums[breakPoint] on its right
        for (int i = n - 1; i > breakPoint; i--) {
            if (nums[breakPoint] < nums[i]) {
                swap(nums, breakPoint, i); // Swap the two elements
                break;
            }
        }

        // Step 4: Reverse the sequence after the breakPoint
        reverse(nums, breakPoint + 1, n - 1);
    }

    // Helper function to swap two elements in the array
    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Helper function to reverse a section of the array
    public static void reverse(int arr[], int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example array for finding the next permutation
        int arr[] = {2, 1, 5, 4, 3, 0, 0};

        // Call the next permutation function
        next(arr);

        // Print the result
        for (int a : arr) {
            System.out.print(a); // Output the modified array
        }
    }
}
