# Grid Way Problem - README

This README explains the **Grid Way Problem** in an easy-to-understand way, starting from the problem description to the approach, algorithm, example walkthrough, and complexity analysis.

---

## Problem Description: The Grid Way Problem

The **Grid Way Problem** involves finding the number of possible ways to travel from the **top-left** corner of a grid to the **bottom-right** corner. You can only move **right** or **down** at any point in time. The goal is to compute how many unique paths exist to go from the top-left to the bottom-right of the grid, given a certain number of rows and columns.

### Grid Example:

Consider a 3x3 grid:

```
(0, 0) --> (0, 1) --> (0, 2)
  |           |          |
(1, 0) --> (1, 1) --> (1, 2)
  |           |          |
(2, 0) --> (2, 1) --> (2, 2)
```

You can only move **right** or **down** at each step. So, if you're starting at the top-left corner `(0, 0)`, you can only move towards the right or down, and your goal is to reach the bottom-right corner `(m-1, n-1)` of the grid.

---

## Approach to Solve the Grid Way Problem

The problem can be approached using **dynamic programming**. We will use a 2D grid (or table) to store the number of ways to reach each cell. We start by defining the base cases and then fill the grid iteratively.

### Steps:
1. **Define the State**:
   - Let `dp[i][j]` represent the number of ways to reach the cell `(i, j)`.

2. **Base Case**:
   - The starting point `(0, 0)` has only one way to be reached: you start there, so `dp[0][0] = 1`.

3. **Recurrence Relation**:
   - To reach a cell `(i, j)`, you can either:
     - Come from the left: `dp[i][j-1]` if `j > 0`.
     - Come from above: `dp[i-1][j]` if `i > 0`.
   - Therefore, the formula becomes:  
     `dp[i][j] = dp[i-1][j] + dp[i][j-1]`.

4. **Boundary Conditions**:
   - If you're in the first row (`i = 0`), you can only come from the left, so `dp[0][j] = 1` for all `j`.
   - Similarly, if you're in the first column (`j = 0`), you can only come from above, so `dp[i][0] = 1` for all `i`.

5. **Final Answer**:
   - The value in `dp[m-1][n-1]` (the bottom-right corner) will give us the total number of unique paths.

---

## Algorithm

### Dynamic Programming Approach:

1. Initialize a 2D array `dp` of size `m x n`.
2. Set `dp[0][0] = 1` (there’s only one way to be at the start).
3. Fill the first row and first column as base cases.
4. For each cell `(i, j)`, calculate the number of ways to reach it using the recurrence relation:  
   `dp[i][j] = dp[i-1][j] + dp[i][j-1]`.
5. The result will be stored in `dp[m-1][n-1]`.

---

## Code

```java
public class GridWaySolver {

    public static int uniquePaths(int m, int n) {
        // Create a 2D DP array
        int[][] dp = new int[m][n];

        // Base case: Fill the first row and first column with 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the DP array using the recurrence relation
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        // The bottom-right corner will hold the final result
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println("Number of unique paths: " + uniquePaths(m, n));
    }
}
```

---

## Example Walkthrough

### Example 1:

Consider a 3x3 grid:

```
(0, 0) --> (0, 1) --> (0, 2)
  |           |          |
(1, 0) --> (1, 1) --> (1, 2)
  |           |          |
(2, 0) --> (2, 1) --> (2, 2)
```

We will calculate the number of ways to reach the bottom-right corner `(2, 2)` from the top-left corner `(0, 0)`.

1. Initialize a `dp` array of size 3x3, filled with 0:
   ```
   0 0 0
   0 0 0
   0 0 0
   ```

2. Set the base cases for the first row and first column:
   ```
   1 1 1
   1 0 0
   1 0 0
   ```

3. Now, using the recurrence relation, fill the rest of the `dp` array:
   ```
   1 1 1
   1 2 3
   1 3 6
   ```

4. The value at `dp[2][2]` is `6`, so there are **6 unique paths** from `(0, 0)` to `(2, 2)`.

---

## Time and Space Complexity

### Time Complexity:
- **O(m * n)**: We traverse the entire `m x n` grid once to fill the `dp` array.

### Space Complexity:
- **O(m * n)**: We use a 2D `dp` array to store the number of ways to reach each cell.

### Optimized Space Complexity:
- **O(n)**: We can reduce the space complexity to O(n) by storing only the current row and the previous row, as each row only depends on the current and previous rows.

---

Enjoy solving the Grid Way problem! 😊