
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// Better approach - O(N^2) complexity
// Uses a HashSet to find pairs that sum to a negative of the current element
class Better {
    public static List<List<Integer>> triplet(int arr[]) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(arr[i] + arr[j]);

                // If third value is already present in hashSet, we found a triplet
                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null); // Sort to maintain unique order
                    set.add(temp);
                }
                hashSet.add(arr[j]); // Add current element to hashSet
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> result = triplet(arr);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}