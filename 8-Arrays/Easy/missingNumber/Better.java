// Better Approach (Using Hashing)
public class Better {

    /**
     * Finds the missing number by using a hash array to track the presence of each number.
     *
     * @param arr Input array of numbers.
     * @param n   Total number of elements expected (including the missing number).
     * @return    The missing number, or -1 if no number is missing.
     */
    public static int missing(int arr[], int n) {
        int hash[] = new int[n + 1]; // Hash array of size n + 1

        // Populate the hash array
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        // Check which number is missing
        for (int j = 1; j < hash.length; j++) {
            if (hash[j] == 0) {
                return j; // Return the missing number
            }
        }
        return -1; // Return -1 if no number is missing
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5}; // Input array
        int n = 5; // Total number of elements expected
        System.out.println(missing(arr, n)); // Output the missing number
    }
}
