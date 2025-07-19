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

   

    public static void main(String[] args) {
        int n = 5; // row
        List<Integer> ans = printRow(n);

        // Print the triangle
        for (Integer it : ans) {
           
            System.out.print(it+" ");
        }
    }
}
