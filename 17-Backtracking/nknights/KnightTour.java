public class KnightTour {

    // All 8 possible moves for a knight
    static int[] dx = {2,1,-1,-2,-2,-1,1,2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    
    // Function to check if a move is valid
    public static boolean isSafe(int x, int y, int[][] sol, int n) {
        return x >= 0 && x < n && y >= 0 && y < n && sol[x][y] == -1;
    }

    // Function to print the board
    public static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("|");
            for (int j = 0; j < n; j
            ++) {
                System.out.printf(" %2d ", board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    // Function to solve the Knight's Tour problem using Backtracking
    public static boolean solveKnightTour(int n) {
        int[][] sol = new int[n][n];
        
        // Initialize the board with -1 (unvisited)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = -1;
            }
        }

        // Knight starts from the top-left corner
        sol[0][0] = 0;  // First move of knight is marked as 0
        
        // Start solving the knight's tour from position (0, 0)
        if (!solve(0, 0, 1, sol, n)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printBoard(sol, n);
            return true;
        }
    }

    // Function to solve the problem using Backtracking
    public static boolean solve(int x, int y, int moveCount, int[][] board, int n) {
        // Base case: if all squares are visited
        if (moveCount == n * n) {
            return true;
        }
        
        // Try all the next moves
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            // Check if the next move is valid and safe
            if (isSafe(nextX, nextY, board, n)) {
                // Mark the current move
                board[nextX][nextY] = moveCount;
                
                // Recur to make the next move
                if (solve(nextX, nextY, moveCount + 1, board, n)) {
                    return true;
                }
                
                // If no further move works, backtrack
                board[nextX][nextY] = -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 8; // Size of the board (8x8)
        solveKnightTour(n); // Start solving the knight's tour problem
    }
}
