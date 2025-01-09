public class GridWays {
    // Recursive function to calculate the number of ways to reach the bottom-right corner
    public static int gridWays(int i, int j, int n, int m) {
        // Base case: If we reach the bottom-right cell, there is one valid way
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        // Base case: If we go out of bounds (beyond the grid), there are no valid ways
        else if (i == n || j == m) {
            return 0;
        }

        // Recursive case 1: Move down to the next row
        int w1 = gridWays(i + 1, j, n, m);

        // Recursive case 2: Move right to the next column
        int w2 = gridWays(i, j + 1, n, m);

        // Total ways to reach the bottom-right is the sum of both recursive results
        return w1 + w2;
    }

    public static void main(String[] args) {
        int n = 3; // Number of rows in the grid
        int m = 3; // Number of columns in the grid

        // Print the total number of ways to traverse the grid from top-left to bottom-right
        System.out.println("Total ways is " + gridWays(0, 0, n, m));
    }
}
