// Optimized Approach - O(N) Complexity
// Uses HashMap to find the number of subarrays with XOR sum equal to k

import java.util.HashMap;
import java.util.Map;

public class Better {
    public static void maxSubArrayWithSumK(int[] nums, int k) {
        int Xor = 0;
        int count = 0;

        // HashMap to store prefix XOR sums and their frequencies
        Map<Integer, Integer> preMap = new HashMap<>();
        preMap.put(0, 1); // Base case: XOR sum of 0 occurs once

        for (int num : nums) {
            Xor ^= num; // Compute cumulative XOR
            int remove = Xor ^ k; // Required prefix XOR to get sum k
            count += preMap.getOrDefault(remove, 0); // Count occurrences
            preMap.put(Xor, preMap.getOrDefault(Xor, 0) + 1); // Store XOR sum frequency
        }

        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 0, 0, 1, 1}; // Input array
        int k = 4; // Target sum
        maxSubArrayWithSumK(arr, k); // Call the method
    }
}