// Optimized Approach (Using Sum Formula)
public class Optimize {

    /**
     * Finds the missing number by calculating the expected sum and subtracting the actual sum.
     *
     * @param a Input array of numbers.
     * @param N Total number of elements expected (including the missing number).
     * @return  The missing number, or -1 if no number is missing.
     */
    public static int missing(int a[], int N) {
        int expectedSum = N * (N + 1) / 2; // Sum of first N natural numbers
        int actualSum = 0;

        // Calculate the actual sum of the array
        for (int i = 0; i < a.length; i++) {
            actualSum += a[i];
        }

        // Return the difference between expected and actual sums
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int arr[] = {3, 0, 1}; // Input array
        int n = 4; // Total number of elements expected
        System.out.println(missing(arr, n)); // Output the missing number
    }
}
