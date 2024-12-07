public class NQueens {
    // Static variable to keep count of the number of solutions
    static int count;

    /**
     * Recursive function to solve the N-Queens problem.
     * 
     * @param board The chessboard represented as a 2D char array.
     * @param row   The current row where we are trying to place a queen.
     */
    public static void nQueens(char board[][], int row) {
        // Base case: if all rows are filled, we found a valid solution
        if (row == board.length) {
            ++count; // Increment solution count
            System.out.println("------------ Board " + count + " --------------");
            printBoard(board); // Print the current solution
            return;
        }

        // Try placing a queen in each column of the current row
        for (int j = 0; j < board.length; j++) {
            // Check if it's safe to place a queen at (row, j)
            if (isSafe(board, row, j)) {
                // Place the queen at (row, j)
                board[row][j] = 'Q';

                // Recur for the next row
                nQueens(board, row + 1);

                // Backtrack: remove the queen from (row, j)
                board[row][j] = 'x';
            }
        }
    }

    /**
     * Function to check if it is safe to place a queen at the given position.
     * 
     * @param board The chessboard.
     * @param row   The row index of the position.
     * @param col   The column index of the position.
     * @return True if it is safe to place the queen, false otherwise.
     */
    public static boolean isSafe(char board[][], int row, int col) {
        // Check vertically upward
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check diagonally left upward
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check diagonally right upward
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // If no threats are found, it's safe to place the queen
        return true;
    }

    /**
     * Function to print the current configuration of the chessboard.
     * 
     * @param board The chessboard.
     */
    public static void printBoard(char board[][]) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " "); // Print each cell
            }
            System.out.println(); // Newline after each row
        }
    }

    public static void main(String[] args) {
        int n = 6; // Size of the chessboard (n x n)

        // Initialize the chessboard with 'x' indicating empty cells
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        // Solve the N-Queens problem starting from the first row
        nQueens(board, 0);
    }
}
