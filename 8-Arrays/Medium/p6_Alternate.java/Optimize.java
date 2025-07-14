public class Optimize {
    // Optimized method to rearrange array into alternating positive and negative numbers
    public static int[] alternate(int[] nums) {
        int pos = 0; // Pointer for positive indices
        int neg = 1; // Pointer for negative indices
        int n = nums.length;
        int ans[] = new int[n]; // Resultant array to hold rearranged elements

        // Rearrange numbers into alternate positive and negative positions
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2; // Move to the next positive index
            } else {
                ans[neg] = nums[i];
                neg += 2; // Move to the next negative index
            }
        }
        return ans; // Return the rearranged array
    }

    public static void main(String[] args) {
        int arr[] = {1, -2, -3, -1, 8, 4};
        int ans[] = alternate(arr); // Call the alternate method
        for (int elem : ans) {      // Print the rearranged array
            System.out.print(elem + " ");
        }
    }
}
