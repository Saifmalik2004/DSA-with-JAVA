# **N-Queens Problem**

## **Introduction**
The **N-Queens Problem** is a classic combinatorial problem in computer science and mathematics. The goal is to place `N` queens on an `N x N` chessboard so that no two queens threaten each other. A queen can attack another queen if they are in the same **row**, **column**, or **diagonal**.

This problem is both an exercise in recursion and backtracking, often used to teach and practice these concepts.

---

## **Problem Statement**
Place `N` queens on an `N x N` chessboard such that:
1. No two queens are in the same **row**.
2. No two queens are in the same **column**.
3. No two queens are on the same **diagonal**.

For example:
- For `N = 4`, one valid solution looks like this:
```
. Q . .
. . . Q
Q . . .
. . Q .
```

Here, `Q` represents a queen, and `.` represents an empty space.

---

## **Why is This Problem Interesting?**
- It teaches **backtracking**, which is a trial-and-error approach to solving recursive problems.
- It demonstrates how to systematically explore possibilities and backtrack when a solution isn’t feasible.
- The N-Queens problem can have multiple solutions, making it a good example of exploring combinatorial spaces.

---

## **Approach**

### **Backtracking**
This problem is solved using **backtracking**:
1. **Place** a queen in a row.
2. Check if it is **safe** to place the queen in that column.
3. If **safe**, proceed to the next row.
4. If no valid placement is found in a row, **backtrack** by removing the last placed queen and trying the next column.

---

### **Step-by-Step Walkthrough**
Let’s solve the N-Queens problem for `N = 4`:

#### 1. Start with an empty board:
```
. . . .
. . . .
. . . .
. . . .
```

#### 2. Place the first queen:
Place the queen in the first row and first column.
```
Q . . .
. . . .
. . . .
. . . .
```

#### 3. Place the second queen:
Move to the next row. The queen can’t go in the same column, so we try another column:
```
Q . . .
. . Q .
. . . .
. . . .
```

#### 4. Place the third queen:
Move to the third row. Try all columns:
- The first column is unsafe (same column as the first queen).
- The second column is unsafe (diagonal to the second queen).
- Place in the third column:
```
Q . . .
. . Q .
. . . Q
. . . .
```

#### 5. Place the fourth queen:
Move to the fourth row. None of the columns are safe:
- Backtrack: Remove the last placed queen and try another column.

#### 6. Continue Backtracking:
Repeat this process until all queens are placed safely or all possibilities are exhausted.

---

### **Algorithm**
1. **Recursive Function (`nQueens`)**:
   - Place a queen in a row.
   - Recur for the next row.
   - Backtrack if no valid placement exists.

2. **Safety Check (`isSafe`)**:
   - Check the **column**.
   - Check the **left diagonal**.
   - Check the **right diagonal**.

---

### **Pseudocode**
```text
function solveNQueens(board, row):
    if row == N:
        printSolution(board)
        return

    for col = 0 to N-1:
        if isSafe(board, row, col):
            placeQueen(board, row, col)
            solveNQueens(board, row + 1)
            removeQueen(board, row, col)
```

---

## **Code Implementation**
Here’s the Java implementation of the above approach:

```java
public class NQueens {
    static int count; // Count of solutions

    public static void nQueens(char board[][], int row) {
        if (row == board.length) { // Base case: all queens placed
            ++count;
            System.out.println("------------ Solution " + count + " ------------");
            printBoard(board);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) { // Check safety
                board[row][col] = 'Q'; // Place queen
                nQueens(board, row + 1); // Recur for next row
                board[row][col] = 'x'; // Backtrack
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // Check vertically
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void printBoard(char board[][]) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x'; // Initialize empty board
            }
        }
        nQueens(board, 0);
    }
}
```

---

## **Diagram**
Below is a simple visualization for `N = 4`:

### Step-by-Step
1. Initial placement:
```
Q . . .
. . . .
. . . .
. . . .
```

2. Second queen:
```
Q . . .
. . Q .
. . . .
. . . .
```

3. Backtrack when stuck and try a new position.

---

## **Time Complexity**
- The function explores all possible positions for queens.
- For each queen, there are `N` possible positions, so the time complexity is approximately:
  \[
  O(N!)
  \]

## **Space Complexity**
- The space complexity is:
  \[
  O(N^2)
  \]
  for the chessboard, plus the stack space for recursion.

---

## **Applications**
1. **Game Theory**: Solving problems like Sudoku or chessboard puzzles.
2. **Algorithmic Thinking**: Practicing recursion and backtracking.
3. **Artificial Intelligence**: Constraint satisfaction problems.

---

## **Conclusion**
The N-Queens problem is a foundational problem that enhances your understanding of recursion, backtracking, and optimization. It’s a challenging yet rewarding exercise, as solving it gives insight into solving complex combinatorial problems.

Feel free to experiment with the code for different board sizes (`N` values) and explore the number of solutions!