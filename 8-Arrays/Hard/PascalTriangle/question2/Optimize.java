import java.util.ArrayList;
import java.util.List;

public class Optimize {
    // Method to compute a row using previous row's values
    static List<Integer> printRow(int n) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // First element is always 1

        // Compute remaining elements using the previous value
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    // Method to generate entire Pascal's Triangle
    static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // Compute and store all rows
        for (int row = 1; row <= n; row++) {
            ans.add(printRow(row));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5; // Number of rows
        List<List<Integer>> ans = pascalTriangle(n);

        // Print the triangle
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
