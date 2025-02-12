public class Better {
    // Function to find duplicate and missing elements in the array
    public static int[] find(int arr[], int n) {

        // Create a hash array to count the frequency of each element
        int hash[] = new int[n + 1];
        int dup = -1;

        // Iterate through the array to count occurrences of each element
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;  // Increase the count for the element
            if (hash[arr[i]] == 2) {  // If count becomes 2, it means this is the duplicate element
                dup = arr[i];
            }
        }

        // Variable to store the missing number
        int miss = -1;

        // Find the number that has 0 occurrences (missing number)
        for (int j = 1; j < hash.length; j++) {
            if (hash[j] == 0) {
                miss = j;  // Missing number is found
                break;
            }
        }

        // Return the duplicate and missing numbers
        return new int[]{dup, miss};
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
