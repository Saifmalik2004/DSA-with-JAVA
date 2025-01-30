/**
 * Brute force approach to count subarrays with sum equal to k.
 * Time Complexity: O(n^2)
 */
public class Brute {
    public static void countSubarray(int arr[], int k) {
        int n = arr.length;
        int count = 0;

        // Iterate through all subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }

    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8, 10, 1, 1, -1, 2};
        int k = 2;
        countSubarray(num, k);
    }
}