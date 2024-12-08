public class SudokuSolver {

    // Function to check if placing a digit in the given cell is valid
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // Check the column for the same digit
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false; // Digit already exists in the column
            }
        }

        // Check the row for the same digit
        for (int j = 0; j < 9; j++) {
            if (sudoku[row][j] == digit) {
                return false; // Digit already exists in the row
            }
        }

        // Check the 3x3 subgrid for the same digit
        int sr = (row / 3) * 3; // Starting row of the subgrid
        int sc = (col / 3) * 3; // Starting column of the subgrid

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false; // Digit already exists in the subgrid
                }
            }
        }

        return true; // Safe to place the digit
    }

    // Recursive function to solve the Sudoku puzzle
    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // Base case: If we reach the 9th row, the puzzle is solved
        if (row == 9) {
            return true;
        }

        // Calculate the next cell to move to
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) { // If we reach the end of a row, move to the next row
            nextRow = row + 1;
            nextCol = 0;
        }

        // If the current cell is already filled, skip it
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // Try placing digits 1 to 9 in the current cell
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) { // Check if it's safe to place the digit
                sudoku[row][col] = digit; // Place the digit

                // Recursively attempt to solve the rest of the puzzle
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true; // Solution found
                }

                // Backtrack: Remove the digit and try the next one
                sudoku[row][col] = 0;
            }
        }

        // No solution found for this configuration
        return false;
    }

    // Function to print the Sudoku grid
    public static void printSudoku(int sudoku[][]) {
        for (int[] row : sudoku) { // Iterate through each row
            for (int num : row) { // Iterate through each number in the row
                System.out.print(num + " "); // Print the number
            }
            System.out.println(); // Move to the next line
        }
    }

    public static void main(String[] args) {
        // Example Sudoku puzzle (0 represents an empty cell)
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // Solve the Sudoku puzzle and print the result
        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists:");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution does not exist");
        }
    }
}
