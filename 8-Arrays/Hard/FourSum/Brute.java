import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Brute {
    public static List<List<Integer>> fourSum(int[] nums) {
        int n = nums.length;
        // HashSet to store unique quadruplets
        Set<List<Integer>> set = new HashSet<>();

        // 4 nested loops to check all possible combinations
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        // Check if sum is zero, if so, add the combination
                        if (sum == 0) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            temp.sort(null); // Sort to avoid duplicate sets
                            set.add(temp);
                        }
                    }
                }
            }
        }
        
        // Convert the set to a list to return
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = fourSum(arr);

        // Print each quadruplet
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
