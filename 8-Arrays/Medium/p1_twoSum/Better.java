import java.util.HashMap;
import java.util.Map;

/**
 * Optimized approach using HashMap to find two numbers that sum up to k.
 * Time Complexity: O(N), Space Complexity: O(N)
 */
public class Better {
    public static int[] twoSum(int arr[], int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int[] ans = {-1, -1};

        for (int i = 0; i < arr.length; i++) {
            int rem = k - arr[i];
            if (sumMap.containsKey(rem)) {
                return new int[]{sumMap.get(rem), i};
            }
            sumMap.put(arr[i], i);
        }
        return ans; // Return {-1, -1} if no pair is found
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 0, 9};
        int k = 9;
        int[] result = twoSum(arr, k);
        System.out.println(result[0] + " " + result[1]);
    }
}