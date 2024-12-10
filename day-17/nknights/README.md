

# 🐴 Knight's Tour Problem

## 📌 The Problem

The **Knight's Tour Problem** is a classic chess puzzle. The goal is to move a knight on a chessboard in such a way that:
1. It visits every square exactly once.
2. It adheres to the movement rules of a knight in chess (L-shaped moves).

---

## 📖 Problem Statement

Given an **n x n chessboard**, determine if there exists a sequence of moves for the knight such that:
- It starts at a given position (default: top-left corner).
- It visits all squares on the board exactly once.

If a solution exists, output the board with the knight's moves. Otherwise, indicate that no solution exists.

---

## ✨ Example

### Input:
A chessboard of size `n = 8` (8x8 board).

### Output (One Possible Solution):
```
|  0 | 59 | 38 | 33 | 30 | 17 |  8 | 63 |
| 37 | 34 | 31 | 60 |  9 | 62 | 29 | 16 |
| 58 |  1 | 36 | 39 | 32 | 27 | 18 |  7 |
| 35 | 48 | 41 | 26 | 61 | 10 | 15 | 28 |
| 42 | 57 |  2 | 49 | 40 | 23 |  6 | 19 |
| 47 | 50 | 45 | 54 | 25 | 20 | 11 | 14 |
| 56 | 43 | 52 |  3 | 22 | 13 | 24 |  5 |
| 51 | 46 | 55 | 44 | 53 |  4 | 21 | 12 |
```

If no solution exists:
```
Solution does not exist
```

---

## 🛠️ Approach (Step-by-Step)

We solve this problem using **Backtracking**. Backtracking helps explore all potential knight movements and backtrack when no valid move exists. Here's the approach:

1. **Initialize the Board:**  
   Start with an `n x n` board filled with `-1` to represent unvisited squares.

2. **Set Starting Position:**  
   Mark the starting position (top-left corner) as `0` (first move).

3. **Define Knight's Moves:**  
   A knight can move in 8 possible L-shaped directions:
   ```
   (+2, +1), (+2, -1), (-2, +1), (-2, -1),
   (+1, +2), (+1, -2), (-1, +2), (-1, -2)
   ```

4. **Recursive Exploration:**  
   Use a recursive function:
   - Try all 8 moves.
   - Check if the move is **valid** (within bounds and not visited).
   - If valid, mark the square and recurse to the next move.

5. **Backtrack:**  
   If no valid moves are found, backtrack by unmarking the current square and trying other moves.

6. **Solution Check:**  
   If all squares are visited (`moveCount == n*n`), a solution is found.

---

## 📝 Algorithm (Pseudo Code)

```plaintext
1. Initialize the chessboard as a 2D array with all cells = -1.
2. Define the knight's 8 possible moves using two arrays dx[] and dy[].
3. Place the knight at the starting position (0, 0) and mark it as move 0.
4. Define a recursive function `solve(x, y, moveCount)`:
   - If moveCount == n*n, return true (solution found).
   - For each possible move:
       a. Calculate nextX and nextY using dx and dy.
       b. Check if the move is valid (within bounds and not visited).
       c. If valid:
           i. Mark the cell with moveCount.
           ii. Recur to the next move.
           iii. If recursion returns true, return true.
           iv. Else, backtrack (unmark the cell).
5. If no solution exists, return false.
6. If solution exists, print the board.
```

---

## 💻 Code Explanation

### Key Functions:
1. **`isSafe(x, y, sol, n)`**:  
   Checks if the knight's move is valid (within bounds and not visited).

2. **`solve(x, y, moveCount, board, n)`**:  
   Implements backtracking to find the knight's tour:
   - Tries all 8 moves recursively.
   - Backtracks if no move leads to a solution.

3. **`printBoard(board, n)`**:  
   Nicely prints the chessboard with the knight's moves.

4. **`solveKnightTour(n)`**:  
   Initializes the board and starts the recursive process. Prints the result.

---

### Walkthrough of Execution

1. Start at `(0, 0)` with the first move.
2. Try all 8 possible knight moves:
   - Example: Move `(+2, +1)` takes the knight to `(2, 1)`.
3. For each valid move:
   - Mark the cell with the move count.
   - Recur to the next move.
4. If all cells are visited, print the solution.
5. If a move leads to a dead end, backtrack and try another direction.

---

## ⏳ Complexity Analysis

### **Time Complexity:**
In the worst case, the knight has 8 possible moves at each step. Hence, the time complexity is:
\[
O(8^{n^2})
\]  
However, with backtracking, many invalid paths are avoided, reducing the practical runtime.

### **Space Complexity:**
The space complexity is:
\[
O(n^2)
\]  
This is due to the `board` and recursive function call stack.

---

## ✨ Key Features

1. **Backtracking Approach:**  
   Systematically explores all possible moves, ensuring correctness.

2. **Dynamic Movements:**  
   Uses arrays to define knight's 8 possible movements, making the code compact and flexible.

3. **Generalized for Any Board Size:**  
   Works for any `n x n` chessboard.

---

## ❓ Why Use Backtracking?

- **Systematic Exploration:** Tries all possibilities in a structured way.
- **Pruning Invalid Paths:** Avoids exploring paths that don't lead to a solution.
- **Optimal for Constraint-Based Problems:** Ensures all constraints (e.g., visiting all squares once) are met.

---

## 💡 Tips

1. **Understand Knight's Movement:**  
   Familiarize yourself with the L-shaped moves.

2. **Start Small:**  
   Test the code with smaller boards (e.g., 4x4) before larger ones.

3. **Edge Cases:**  
   Ensure the board size and starting positions are valid.

---

## 🏁 Conclusion

The Knight's Tour problem is an excellent example of how **backtracking** can be used to solve complex problems efficiently. It demonstrates systematic exploration, recursion, and optimization through backtracking. By following this approach, you can solve the problem for any board size while understanding the knight's unique movement in chess. Happy coding! 🎉