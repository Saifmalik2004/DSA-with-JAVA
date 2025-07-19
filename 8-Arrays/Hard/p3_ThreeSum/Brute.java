import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Brute force approach - O(N^3) complexity
// This method checks every possible triplet in the array
// and stores only unique triplets in a HashSet.
public class Brute {
    public static List<List<Integer>> triplet(int arr[]) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        // Using three nested loops to generate all possible triplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null); // Sorting to maintain order for uniqueness
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set); // Convert set to list before returning
    }

    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> result = triplet(arr);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}