// Brute Force Approach - O(N^2) Complexity
// Iterates through all subarrays and computes XOR sum manually

public class Brute {
    public static void countSubarray(int[] a, int b) {
        int n = a.length;
        int count = 0;

        // Iterate through all subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum ^= a[j]; // Compute XOR sum of subarray
                if (sum == b) {
                    count++; // Increment count if XOR sum matches target
                }
            }
        }

        System.out.println("Count of subarrays with sum " + b + ": " + count);
    }

    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8, 10, 1, 1, -1, 2}; // Input array
        int k = 2; // Target XOR sum
        countSubarray(num, k); // Call the method
    }
}