import java.util.*;

public class RatMaze {

    // Recursive function to solve the maze
    public static void solve(int i, int j, int[][] maze, int n, ArrayList<String> paths, String path, int[][] visited, int[] di, int[] dj) {
        // Base case: If the destination is reached
        if (i == n - 1 && j == n - 1) {
            paths.add(path);
            return;
        }

        String directions = "DLRU"; // Direction labels: Down, Left, Right, Up
        for (int index = 0; index < 4; index++) {
            int nextI = i + di[index];
            int nextJ = j + dj[index];

            // Check if the move is valid
            if (nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < n && visited[nextI][nextJ] == 0 && maze[nextI][nextJ] == 1) {
                visited[i][j] = 1; // Mark the current cell as visited
                solve(nextI, nextJ, maze, n, paths, path + directions.charAt(index), visited, di, dj);
                visited[i][j] = 0; // Backtrack and unmark the current cell
            }
        }
    }

    // Function to find all possible paths in the maze
    public static ArrayList<String> findPaths(int[][] maze, int n) {
        ArrayList<String> paths = new ArrayList<>();
        int[][] visited = new int[n][n];

        int[] di = {+1, 0, 0, -1}; // Row movements: Down, Left, Right, Up
        int[] dj = {0, -1, +1, 0}; // Column movements: Down, Left, Right, Up
        
        if (maze[0][0] == 1 && maze[n-1][n-1] == 1) { // Start solving only if both start and end cells are open
            solve(0, 0, maze, n, paths, "", visited, di, dj);
        }

        return paths;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        int n = 4;
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        ArrayList<String> result = findPaths(maze, n);

        if (!result.isEmpty()) {
            for (String path : result) {
                System.out.print(path + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1); // No path found
        }
    }
}
