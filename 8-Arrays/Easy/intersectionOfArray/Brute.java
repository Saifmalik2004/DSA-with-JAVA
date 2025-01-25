import java.util.ArrayList;
import java.util.Arrays;

public class Brute {
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[m]; // Boolean array to track visited elements in arr2

        // Iterate through both arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Check if the current elements match and the element in arr2 is not visited
                if (arr1.get(i).equals(arr2.get(j)) && !vis[j]) {
                    ans.add(arr1.get(i)); // Add to the intersection result
                    vis[j] = true;        // Mark as visited
                    break;                // Move to the next element in arr1
                } else if (arr2.get(j) > arr1.get(i)) {
                    break; // Since arr2 is sorted, we can break early
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 2, 3, 5));

        ArrayList<Integer> result = findArrayIntersection(arr1, arr1.size(), arr2, arr2.size());
        System.out.println("Intersection: " + result);
    }
}
