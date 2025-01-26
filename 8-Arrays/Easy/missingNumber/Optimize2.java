// Optimized Approach (Using XOR)
public class Optimize2 {

    /**
     * Finds the missing number using XOR to track differences.
     *
     * @param arr  Input array of numbers.
     * @param n    Total number of elements expected (including the missing number).
     * @param size Size of the input array.
     * @return     The missing number.
     */
    public static int missing(int arr[], int n, int size) {
        int xor1 = 0, xor2 = 0;

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }

        // XOR all numbers in the array
        for (int i = 0; i < size; i++) {
            xor2 ^= arr[i];
        }

        // XOR the two results to find the missing number
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int arr[] = {3, 0, 1}; // Input array
        int n = 4; // Total number of elements expected
        System.out.println(missing(arr, n, arr.length)); // Output the missing number
    }
}
