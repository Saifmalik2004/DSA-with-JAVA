import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Better {

    /**
     * Function to find the duplicate and missing number in the array.
     * The array contains numbers from 1 to n with one number missing and one duplicated.
     *
     * @param arr The input array
     * @param n The expected number of elements (1 to n)
     * @return A list containing [duplicate, missing]
     */
    public static List<Integer> find(int arr[], int n) {

        // HashMap to store the frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        // Sum of first n natural numbers (expected sum)
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Increase frequency of the current number
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

          
            actualSum += arr[i];

            // If frequency becomes > 1, it's a duplicate
            if (freq.get(arr[i]) > 1) {
                ans.add(arr[i]); 
                break; // No need to check further
            }
        }

        // Step 2: Subtract duplicate from actual sum to simulate correct sum
        actualSum = actualSum - ans.get(0);

        // Step 3: Missing = expected sum - sum of unique elements
        ans.add(expectedSum - actualSum);

        return ans; 
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 1, 6, 1}; // Example input: 1 is duplicate, 4 is missing

        // Output the result
        List<Integer> result = find(arr, 6);
        System.out.println("Duplicate: " + result.get(0));
        System.out.println("Missing: " + result.get(1));
    }
}
