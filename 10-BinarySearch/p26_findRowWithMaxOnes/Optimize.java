import java.util.ArrayList;
import java.util.Arrays;

public class Optimize {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1)));

        System.out.println("The row with the maximum number of 1's is: " +
                           rowWithMax1s(matrix));
    }

    public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        int m = matrix.size();

        for (int i = 0; i < m; i++) {
            int count = 0;
            int low = 0;
            int n = matrix.get(i).size();
            int high = n - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix.get(i).get(mid) >= 1) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            count = n - low;
            if (count > max) {
                idx = i;
                max = count;
            }
        }

        return idx;
    }
}
