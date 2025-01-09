
# Spiral Matrix Print 🌀

Imagine walking through a maze, following the outer edges and slowly moving towards the center. This is the concept behind **spiral printing** a matrix, where we start from the outer boundary and work our way inwards. Let's dive into the steps to solve this interesting problem!

---

## Problem Overview

Given a 2D matrix, we want to print its elements in a **spiral order**. Starting from the top-left corner, we move:
- **Right** along the first row.
- **Down** along the last column.
- **Left** along the last row.
- **Up** along the first column.

After completing each “lap,” we move inward by narrowing the boundaries, repeating the process until we’ve printed every element.

### Example Matrix

Let's consider this 3x4 matrix:

```plaintext
1   2   3   4
5   6   7   8
9  10  11  12
```

**Spiral Order Output**: `1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7`

---

## Approach to Solve the Problem

To print the matrix in a spiral order, we:
1. **Define Boundaries**:
   - `startRow` and `endRow` represent the current outer row boundaries.
   - `startCol` and `endCol` represent the current outer column boundaries.

2. **Move in Four Directions**:
   - Traverse **Right** across the `startRow`.
   - Traverse **Down** along the `endCol`.
   - Traverse **Left** across the `endRow` (if any rows remain).
   - Traverse **Up** along the `startCol` (if any columns remain).

3. **Narrow the Boundaries**:
   - After each direction, update the boundaries to move inwards for the next iteration.

4. **Repeat** until all elements are printed!

---

## Code Solution

Here’s the Java code to implement the spiral print:

```java
public class SpiralMatrix {
    public static void spiral(int matrix[][]) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Traverse from left to right across the top row
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            // Traverse from top to bottom on the rightmost column
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            // Traverse from right to left on the bottom row (if there’s more than one row left)
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) break;
                System.out.print(matrix[endRow][j] + " ");
            }
            // Traverse from bottom to top on the leftmost column (if there’s more than one column left)
            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol == endCol) break;
                System.out.print(matrix[i][startCol] + " ");
            }

            // Move the boundaries inward
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // Display the matrix
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // Move to the next line after each row
        }

        // Print the matrix in spiral order
        spiral(matrix);
    }
}
```

---

## Quick Walkthrough

Using our 3x4 matrix as an example, here’s how each step unfolds:

1. **First Layer**:
   - Right across the top row: `1, 2, 3, 4`
   - Down the right column: `8, 12`
   - Left across the bottom row: `11, 10, 9`
   - Up the left column: `5`

2. **Second Layer**:
   - Right across the second row: `6, 7`

> **Final Spiral Order**: `1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7`

---

## Why Use This Approach?

This solution is efficient, **O(n)**, as we visit each element exactly once, making it suitable for matrices of all sizes. Plus, it’s a clear approach for printing elements layer by layer without revisiting any of them.

---

## Practical Applications

Spiral printing is handy in:
- **Data visualization**: Displaying data patterns layer-by-layer.
- **Graphics and image processing**: Spiral scanning is useful for some rendering techniques.
- **Pathfinding in grids**: Spiraling can help explore areas systematically in maze-solving.

---

Enjoy printing in spiral style! 🌀