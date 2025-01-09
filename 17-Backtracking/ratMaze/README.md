

# 🐭 Rat in a Maze Problem - Code Walkthrough

---

## 🧐 Problem Statement

Imagine there’s a rat at the top-left corner of a maze (0, 0). The rat wants to reach the bottom-right corner (N-1, N-1). However, the maze has walls, and the rat can only move through paths that are open (represented by `1`).

The maze is given as a grid:

- `1` -> Path where the rat can move.
- `0` -> Wall where the rat cannot move.

Your task is to find all possible paths the rat can take to reach the destination. If no path exists, the output should indicate that too.

---
<img src="https://images.javatpoint.com/core/images/rat-in-a-maze-problem-in-java2.png"alt="maze image" width="300">
## 📊 Example

### Input Maze:
```
1  0  0  0  
1  1  0  1  
0  1  0  0  
1  1  1  1  
```

### Valid Path:
The rat can follow the path below:
```
Start -> Down -> Down -> Right -> Right -> Down -> Right -> Finish
```

### Output:
```
Path 1: DDRDRRDR
```

If no path exists, the output will be `No path found`.

---
## 🛠️ Approach

The solution to this problem uses **Backtracking**, a method where we try all possible paths recursively and backtrack if we hit a dead-end.

### Step-by-Step Solution:

1. **Start at the first cell (0, 0):**  
   Check if the starting position is valid (`1`).

2. **Move in possible directions:**  
   At every cell, try moving:
   - Down (`D`)
   - Right (`R`)
   - Up (`U`)
   - Left (`L`)  
   But only if the next cell is valid (`1`) and not already visited.

3. **Check destination:**  
   If you reach the last cell `(N-1, N-1)`, record the path.

4. **Backtrack:**  
   If the current path doesn't lead to the destination, backtrack to explore other options.

---

## 🕹️ Algorithm

1. Create a helper function `solveMaze(row, col, path)` to explore all paths.
2. Use a **visited matrix** to track cells that have already been visited.
3. Try moving in all four directions.
4. When a valid path is found, store it in the result.
5. Backtrack to explore other paths.

---

## 📜 Code Explanation

### 1. **Recursive Backtracking Function (`solve`)**

- **Purpose:**  
  The `solve` function explores all possible paths from the rat's starting point `(0,0)` to the destination `(n-1,n-1)`.

- **Parameters:**  
  - `i, j`: Current position in the maze.
  - `maze`: The input maze grid (2D array).
  - `n`: Size of the maze (n x n).
  - `paths`: A list to store all valid paths.
  - `path`: A string to record the current path taken.
  - `visited`: A 2D array to track visited cells.
  - `di, dj`: Arrays indicating movement in different directions (down, left, right, up).

- **Base Case:**  
  If the rat reaches the destination `(n-1, n-1)`, the current path is added to the `paths` list.

- **Recursive Calls:**  
  The function attempts to move the rat in all four directions:
  - Down (`D`)
  - Left (`L`)
  - Right (`R`)
  - Up (`U`)  
  Only valid moves are considered:
  - Within the grid boundaries.
  - Not visited before.
  - On a valid path (`1` in the maze grid).

- **Backtracking:**  
  If a move doesn’t lead to a solution, the function backtracks by unmarking the current cell (`visited[i][j] = 0`).

---

### 2. **Main Logic Function (`findPaths`)**

- **Purpose:**  
  The `findPaths` function initializes the maze-solving process and returns all valid paths.

- **Steps:**
  1. Creates a list `paths` to store all possible solutions.
  2. Initializes a `visited` matrix to track visited cells during the recursion.
  3. Defines movement arrays `di` and `dj` to simplify direction handling.
  4. Checks if the maze’s start and end cells are open (`1`). If not, no solution is possible.
  5. Calls the recursive `solve` function starting from `(0,0)`.

---

### 3. **Main Method**

- **Purpose:**  
  Sets up the maze and calls the `findPaths` function to get the solutions.

- **Steps:**
  1. Defines the maze as a 2D array.
  2. Calls `findPaths` to find all possible paths from `(0,0)` to `(n-1,n-1)`.
  3. Prints the results:
     - If paths exist, prints all paths.
     - If no paths are found, prints `-1`.

---


## 🕹️ Walkthrough of Execution

Let’s take the example maze:
```
1  0  0  0
1  1  0  1
1  1  0  0
0  1  1  1
```

### Step-by-Step Execution:

1. **Start at `(0,0)`**  
   - Add `D` to the path and move down to `(1,0)`.

2. **At `(1,0)`**  
   - Add `D` to the path and move down to `(2,0)`.

3. **At `(2,0)`**  
   - Add `R` to the path and move right to `(2,1)`.

4. **At `(2,1)`**  
   - Add `D` to the path and move down to `(3,1)`.

5. **At `(3,1)`**  
   - Add `R` to the path and move right to `(3,2)`.

6. **At `(3,2)`**  
   - Add `R` to the path and move right to `(3,3)`.

7. **At `(3,3)`**  
   - Destination reached! Add the path `"DDRDRR"` to the `paths` list.

8. **Backtrack and Explore Other Paths**  
   The program backtracks and explores other possible paths, ensuring all solutions are found.

---

## 🕑 Time Complexity Analysis

### Worst-Case Scenario:
In the worst case, the algorithm may need to explore all cells in the maze, and for each cell, there are four possible directions. Hence:
\[
O(4^{n^2})
\]

### Optimized Time Complexity:
Using the visited matrix to avoid revisiting cells optimizes the complexity:
\[
O(2^{n^2})
\]

---

## 💡 Key Features

1. **Backtracking:** Ensures all possible paths are explored while avoiding revisits.
2. **Flexibility:** The movement logic (`di`, `dj`) makes it easy to modify the directions.
3. **Clean Output:** Displays all valid paths or indicates if no path exists.

---


## 💡 Why Use Backtracking?

- Backtracking allows us to explore all possible solutions while avoiding redundant calculations.
- If a path doesn’t work, we "backtrack" and try another, ensuring we don’t miss any solutions.

---

## 🔍 Tips for Beginners

1. **Visualize the Maze:**  
   Think of it like helping a rat explore all paths to escape a maze.

2. **Think Recursively:**  
   Divide the problem into smaller sub-problems (e.g., "What happens if the rat moves down?").

3. **Focus on Valid Moves:**  
   Always check if the next move is valid (within boundaries, not visited, and open).

---


This code is a great example of using recursion and backtracking to solve problems efficiently! 🎉