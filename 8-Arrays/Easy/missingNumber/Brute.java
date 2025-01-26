// Brute Force Approach
public class Brute {

    /**
     * Finds the missing number by checking each number from 1 to n in the array.
     *
     * @param arr Input array of numbers.
     * @param n   Total number of elements expected (including the missing number).
     * @return    The missing number, or -1 if no number is missing.
     */
    public static int missing(int arr[], int n) {
        for (int i = 1; i <= n; i++) {
            int flag = 0;
            // Check if 'i' exists in the array
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    flag = 1; // Mark as found
                    break;
                }
            }
            // If 'i' is not found, return it as the missing number
            if (flag == 0) {
                return i;
            }
        }
        return -1; // Return -1 if no number is missing
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4}; // Input array
        int n = 5; // Total number of elements expected
        System.out.println(missing(arr, n)); // Output the missing number
    }
}
