import java.util.HashMap;

public class Optimize {

    // Function to find the maximum length of subarray with sum 0
    public static int find(int arr[], int n) {
        // HashMap to store the sum at each index
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;  // Variable to track the maximum length of subarray
        int sum = 0;   // Variable to track the prefix sum

        // Loop through the array
        for (int i = 0; i < n; i++) {
            sum += arr[i];  // Add current element to the sum

            // If the sum is 0, it means the subarray from the start to the current index has a sum 0
            if (sum == 0) {
                maxi = i + 1;  // Update maxi to current index + 1
            } else {
                // If the sum has been encountered before, it means there is a subarray between previous index and current index with sum 0
                if (mpp.get(sum) != null) {
                    maxi = Math.max(maxi, i - mpp.get(sum));  // Calculate length of subarray and update maxi
                } else {
                    // Otherwise, store the index of the first occurrence of the sum
                    mpp.put(sum, i);
                }
            }
        }
        return maxi;  // Return the maximum length of subarray with sum 0
    }

    public static void main(String[] args) {
        // Sample input array
        int a[] = {1, -1, 0, 0, 2, 3, -3, 0, 1};

        // Output the result
        System.out.println(find(a, a.length));  // Calling the function with the array and its length
    }
}
