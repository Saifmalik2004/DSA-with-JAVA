
# Diagonal Sum of a Matrix 🧮

Welcome to the Diagonal Sum problem! Ever wondered how you can work with data in two dimensions? A matrix is just a grid, and calculating its diagonal sum is a handy skill for understanding data in rows and columns. Let’s dive into this interesting challenge and learn how to unlock the power of diagonals!

---

## 📌 Problem Statement

Imagine a square matrix (a grid with an equal number of rows and columns) filled with numbers. The goal is to **find the sum of the numbers along its main diagonal** (from the top-left to the bottom-right) and its **secondary diagonal** (from the top-right to the bottom-left).

### Why Diagonals?

The diagonals of a matrix are unique and important – they often represent patterns or specific calculations in applications like image processing, grid-based games, and more. Summing the diagonals lets us quickly evaluate or check certain properties of the matrix.

### Example Matrix

Consider this matrix:
```plaintext
1 2 3
4 5 6
7 8 9
```

1. **Main Diagonal** (Top-left to bottom-right): `1, 5, 9`
2. **Secondary Diagonal** (Top-right to bottom-left): `3, 5, 7`

> **Diagonal Sum Calculation**: `1 + 5 + 9 + 3 + 5 + 7 = 30`

Notice that `5` appears in both diagonals, so we don’t want to double-count it!

---

## 🧠 Approach to Solve the Problem

1. **Loop through each row** of the matrix.
2. For each row:
   - Add the element from the main diagonal (where row and column indices are the same).
   - Add the element from the secondary diagonal (where the row index is paired with the opposite column).
3. **Avoid Double-Counting**: If the matrix has an odd size (like 3x3, 5x5, etc.), the center element belongs to both diagonals, so make sure to add it only once.

---

## 💻 Code Solution

Here's how you can implement this in Java:

```java
public class DiagonalSum {
    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length; // Number of rows/columns in the square matrix

        for (int i = 0; i < n; i++) {
            // Add main diagonal element
            sum += matrix[i][i];

            // Add secondary diagonal element
            if (i != n - 1 - i) { // Avoid double-counting the center element in odd-length matrices
                sum += matrix[i][n - 1 - i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("The diagonal sum is: " + diagonalSum(matrix));
    }
}
```

---

## 🚀 Quick Dry Run

Let’s walk through the calculation for our example matrix:

1. **Main Diagonal Elements**: `1, 5, 9`
   - Sum so far: `1 + 5 + 9 = 15`
2. **Secondary Diagonal Elements**: `3, 5, 7`
   - Since `5` is already counted in the main diagonal, we only add `3` and `7`.
   - Final sum: `15 + 3 + 7 = 25`

> 🎉 **Diagonal Sum = 25**

---

## 💡 When to Use Diagonal Sums?

Diagonal sums appear often in:
- **Grid-based games** like Sudoku or tic-tac-toe, where diagonals often determine winning moves.
- **Data visualization** where certain patterns emerge along the diagonals.
- **Mathematical problems** involving square grids, which often have unique properties along their diagonals.

---

Enjoy working with matrices and stay tuned for more fun challenges! 🎉