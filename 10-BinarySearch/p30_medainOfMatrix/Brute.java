import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brute {
    public static int median(int[][] arr) {
        List<Integer> list = new ArrayList<>();

        // Matrix flatten into 1D list
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                list.add(arr[i][j]);
            }
        }

        Collections.sort(list);

        // Since n and m are always odd, total elements are odd
        return list.get(list.size() / 2);
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        System.out.println("Median (Brute): " + median(matrix));
    }
}
