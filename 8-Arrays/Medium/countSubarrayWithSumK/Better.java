import java.util.HashMap;
import java.util.Map;

/**
 * Optimized approach using HashMap to find the number of subarrays with sum equal to k.
 * Time Complexity: O(n)
 */
public class Better {
    public static void maxSubArrayWithSumK(int[] nums, int k) {
        int sum = 0;
        int count = 0;

        // HashMap to store prefix sums and their frequencies
        Map<Integer, Integer> preMap = new HashMap<>();
        preMap.put(0, 1);

        for (int num : nums) {
            sum += num;
            int remove = sum - k;
            count += preMap.getOrDefault(remove, 0);
            preMap.put(sum, preMap.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 0, 0, 1, 1}; // Input array
        int k = 4; // Target sum
        maxSubArrayWithSumK(arr, k); // Call the method
    }
}
