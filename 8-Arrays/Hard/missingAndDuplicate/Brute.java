public class Brute {
    // Function to find duplicate and missing elements in the array
    public static int[] find(int arr[], int n) {
        int miss = -1;
        int dupli = -1;

        // Loop through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            int count = 0;

            // Loop through the array and count occurrences of i
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }

            // If the count is 2, then 'i' is the duplicate number
            if (count == 2) {
                dupli = i;
            }

            // If the count is 0, then 'i' is the missing number
            if (count == 0) {
                miss = i;
            }

            // If both duplicate and missing numbers are found, break early
            else if (miss != -1 && dupli != -1) {
                break;
            }
        }

        // Return the missing and duplicate numbers
        return new int[]{miss, dupli};
    }

    // Main method to test the find function
    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 1, 6, 1};

        // Print the duplicate and missing numbers
        for (int elem : find(arr, 6)) {
            System.out.println(elem);
        }
    }
}
