public class Better {
    public static boolean search(int[][] matrix,int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int low = 0;
            int high = n - 1;

            if (matrix[i][low] < k && matrix[i][high] < k) {
                continue;
            }

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[i][mid] == k) {
                    return true;
                } else if (matrix[i][mid] < k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
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

        System.out.println("Brute Search 4: " + search(matrix, 4));
    }
}
