# Sudoku Solver 

This comprehensive README explains the **Sudoku problem**, starting from understanding the rules of the game to implementing an efficient algorithm to solve it. We'll walk through each part step-by-step for clarity, including an example with a breakdown, and conclude with time and space complexity analysis.

---

## What is Sudoku?

**Sudoku** is a logic-based number puzzle game played on a 9x9 grid divided into 9 smaller 3x3 subgrids (boxes). The goal is to fill the grid with numbers from **1 to 9** such that:
1. Each **row** contains the digits 1-9, with no repetition.
2. Each **column** contains the digits 1-9, with no repetition.
3. Each **3x3 subgrid** contains the digits 1-9, with no repetition.

### Rules of Sudoku:
- Some numbers are pre-filled as clues.
- You must deduce the remaining numbers using logic.
- Only valid placements according to the rules are allowed.

Example:

| 5 | 3 |   |   | 7 |   |   |   |   |
|---|---|---|---|---|---|---|---|---|
| 6 |   |   | 1 | 9 | 5 |   |   |   |
|   | 9 | 8 |   |   |   |   | 6 |   |
| 8 |   |   |   | 6 |   |   |   | 3 |
| 4 |   |   | 8 |   | 3 |   |   | 1 |
| 7 |   |   |   | 2 |   |   |   | 6 |
|   | 6 |   |   |   |   | 2 | 8 |   |
|   |   |   | 4 | 1 | 9 |   |   | 5 |
|   |   |   |   | 8 |   |   | 7 | 9 |

The task is to fill the empty cells (`0` in the code) so the rules are satisfied.

---

## Approach to Solve Sudoku

To solve Sudoku programmatically, we use **backtracking**, a trial-and-error approach. Here's the step-by-step approach:

### Steps:
1. **Find the First Empty Cell**:
   - Traverse the grid row-by-row and column-by-column to find the first empty cell (`0`).
   
2. **Check Valid Numbers**:
   - For the current empty cell, try placing numbers **1 to 9**.
   - Check if the placement is valid:
     - It doesn't violate the **row** rule.
     - It doesn't violate the **column** rule.
     - It doesn't violate the **3x3 subgrid** rule.

3. **Recursive Backtracking**:
   - If a valid number is found, place it and proceed to solve the rest of the grid recursively.
   - If placing a number leads to a dead end, backtrack by resetting the cell to `0` and trying the next number.

4. **Terminate**:
   - If the entire grid is solved, return `true`.
   - If no number works for any cell, return `false`.

---

## Algorithm

### isSafe Function:
Checks if placing a number at `(row, col)` is valid:
1. Verify the **row** and **column** for duplicate numbers.
2. Verify the **3x3 subgrid** for duplicate numbers.

### sudokuSolver Function:
1. Base Case:
   - If all rows are completed (`row == 9`), the puzzle is solved. Return `true`.
2. Recursive Case:
   - If the current cell is not empty, skip to the next cell.
   - Try placing numbers 1-9. If a valid placement is found, recurse for the next cell. If recursion fails, backtrack by resetting the cell.
   - Return `true` if the grid is solvable; otherwise, return `false`.

---

## Code

```java
public class SudokuSolver {
    // Check if placing a digit is safe
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit || sudoku[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int sr = (row / 3) * 3; // starting row of subgrid
        int sc = (col / 3) * 3; // starting column of subgrid
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    // Solve the Sudoku using backtracking
    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        if (row == 9) { // Base case: if all rows are processed
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) { // Move to the next row
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) { // Skip filled cells
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit; // Place the digit
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0; // Backtrack
            }
        }

        return false; // No solution
    }

    // Print the Sudoku grid
    public static void printSudoku(int[][] sudoku) {
        for (int[] row : sudoku) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
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

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution Exists:");
            printSudoku(sudoku);
        } else {
            System.out.println("No Solution Exists.");
        }
    }
}
```

---

## Example Breakdown

Input Grid:
```
5 3 0 | 0 7 0 | 0 0 0
6 0 0 | 1 9 5 | 0 0 0
0 9 8 | 0 0 0 | 0 6 0
---------------------
8 0 0 | 0 6 0 | 0 0 3
4 0 0 | 8 0 3 | 0 0 1
7 0 0 | 0 2 0 | 0 0 6
---------------------
0 6 0 | 0 0 0 | 2 8 0
0 0 0 | 4 1 9 | 0 0 5
0 0 0 | 0 8 0 | 0 7 9
```

Steps:
1. Start at `(0, 2)` (empty cell).
2. Try digits `1-9`, validate using `isSafe`.
3. Place valid digits and recurse.
4. Backtrack if dead end and try the next digit.

Output Grid:
```
5 3 4 | 6 7 8 | 9 1 2
6 7 2 | 1 9 5 | 3 4 8
1 9 8 | 3 4 2 | 5 6 7
---------------------
8 5 9 | 7 6 1 | 4 2 3
4 2 6 | 8 5 3 | 7 9 1
7 1 3 | 9 2 4 | 8 5 6
---------------------


9 6 1 | 5 3 7 | 2 8 4
2 8 7 | 4 1 9 | 6 3 5
3 4 5 | 2 8 6 | 1 7 9
```

---

## Time and Space Complexity

### Time Complexity:
- Worst Case: **O(9^(n*n))**, where `n` is the grid size (9 for standard Sudoku).  
  Each empty cell can have up to 9 possible values.

### Space Complexity:
- **O(n*n)**: For the recursive call stack and storage of the grid.

--- 

Enjoy solving Sudoku puzzles! 😊