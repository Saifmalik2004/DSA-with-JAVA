public class DiagonalSum {
    // Method to calculate the sum of diagonals
    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            // Add the primary diagonal element
            sum += matrix[i][i];

            // Add the secondary diagonal element, avoiding double counting the center element
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int sum = diagonalSum(matrix);
        System.out.println("Sum of diagonals: " + sum);
    }
}
