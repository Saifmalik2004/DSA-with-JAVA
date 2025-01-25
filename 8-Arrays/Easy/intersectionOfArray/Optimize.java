import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Optimize {
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        // Use two-pointer technique to find intersection
        while (i < n && j < m) {
            if (Objects.equals(arr1.get(i), arr2.get(j))) {
                ans.add(arr1.get(i)); // Add common element
                i++;
                j++;
            } else if (arr1.get(i) < arr2.get(j)) {
                i++; // Increment pointer of arr1
            } else {
                j++; // Increment pointer of arr2
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
