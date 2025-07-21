import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Better {
    public static List<List<Integer>> four(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        int target = 0;

        // Iterate through pairs of elements
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashSet = new HashSet<>();
                
                // Check remaining pairs for sum to complete the triplet
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long four = target - sum;

                    if (hashSet.contains(four)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) four);
                        temp.sort(null); // Sort to ensure unique triplet
                        set.add(temp);
                    }
                    hashSet.add((long) nums[k]);
                }
            }
        }
        
        // Return the unique triplets
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = four(arr);

        // Print each triplet
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
