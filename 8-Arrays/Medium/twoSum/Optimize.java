
import java.util.Arrays;

/**
 * Optimized approach using sorting and two-pointer technique.
 * Time Complexity: O(N log N) due to sorting, Space Complexity: O(1)
 */
public class Optimize {
    public static String twoSum(int[] book, int target, int n) {
        Arrays.sort(book); // Sort the array
        int left = 0, right = n - 1;

        while (left < right) {
            int sum = book[left] + book[right];
            if (sum == target) {
                return "Yes"; // Pair found
            } else if (sum > target) {
                right--; // Decrease the sum by moving right pointer left
            } else {
                left++; // Increase the sum by moving left pointer right
            }
        }
        return "No"; // No valid pair found
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 0, 9};
        int k = 9;
        System.out.println(twoSum(arr, k, arr.length));
    }
}