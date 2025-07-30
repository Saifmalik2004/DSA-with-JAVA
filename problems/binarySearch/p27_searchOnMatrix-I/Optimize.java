
public class Optimize {

    public static boolean search(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == k) {
                return true;
            } else if (matrix[i][j] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("Optimized Search 4: " + search(matrix, 4));
    }
}
