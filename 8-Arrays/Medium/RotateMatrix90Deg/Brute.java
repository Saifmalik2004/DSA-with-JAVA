public class Brute {
    // Function to rotate a matrix 90 degrees clockwise using extra space.
    public static int[][] rotate90Deg(int met[][], int n, int m) {
        int rotated[][] = new int[n][m];

        // Iterating through the matrix and placing elements in their new rotated positions.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                rotated[j][n - 1 - i] = met[i][j]; // Rotating element positions.
            }
        }

        return rotated; // Returning the rotated matrix.
    }

    public static void main(String[] args) {
        // Input matrix
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int n = 4;
        int m = 4;

        // Calling the function to rotate the matrix
        int ans[][] = rotate90Deg(matrix, n, m);

        // Printing the rotated matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
