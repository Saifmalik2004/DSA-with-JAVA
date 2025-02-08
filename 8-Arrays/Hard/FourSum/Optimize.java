import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Optimize {
    public static List<List<Integer>> four(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        // Sort the array to simplify finding pairs with two pointers
        Arrays.sort(nums);
        
        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Skip duplicates to avoid repeating the same triplet
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                // Skip duplicates for second pointer
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1; // Left pointer
                int l = n - 1; // Right pointer

                // Two-pointer approach to find the rest of the triplet
                while (k < l) {
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l--; // Move right pointer to reduce sum
                    } else if (sum < target) {
                        k++; // Move left pointer to increase sum
                    } else {
                        // Triplet found, add to result and adjust pointers
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        // Skip duplicates for left and right pointers
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 4, 1, 2, 5, 4};
        List<List<Integer>> result = four(arr, 8);

        // Print each triplet
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
