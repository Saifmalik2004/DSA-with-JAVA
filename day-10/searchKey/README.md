
# Searching in a Sorted Matrix 🔍

Ever played hide and seek with numbers in a grid? Welcome to the challenge of searching in a sorted matrix! Here, we’re going to track down a specific number in a two-dimensional array that's sorted in a particular way. This problem is a great introduction to searching efficiently within structured data. Let’s dive in!

---

## 📌 Problem Statement

Imagine you have a matrix (a grid of numbers) where each row and column is sorted in ascending order. For example:

```plaintext
1  4  7 11
2  5  8 12
3  6  9 16
10 13 14 17
```

Given a **key** (a target number), our task is to determine if this number is present in the matrix, and if so, find its position (row and column index).

---

## 🔑 Why is This Problem Interesting?

Since both rows and columns are sorted, the matrix gives us a structured way to search for our target number. This structure allows us to take a unique approach, more efficient than a typical search, which reduces the number of elements we need to check. Instead of examining every element, we’ll **leverage the sorted order** to guide our search.

---

## 💡 Approach to Solve the Problem

1. **Start from the top-right corner** of the matrix.
2. At each step:
   - If the current element matches the target, we're done!
   - If the current element is **greater than the target**, move **left** (decrease the column index).
   - If the current element is **less than the target**, move **down** (increase the row index).
3. Continue this process until you either find the target or exhaust the matrix boundaries.

This approach works because of the sorted order in each row and column, allowing us to confidently eliminate certain rows or columns as we move through the matrix.

### Why Start at the Top-Right Corner?

- From this position:
  - All elements to the left are smaller.
  - All elements below are larger.
- This structure guides our search direction, helping us zero in on the target quickly.

---

## 🧑‍💻 Code Solution

Here’s how you can implement the search in Java:

```java
public class MatrixSearch {
    public static boolean searchInMatrix(int[][] matrix, int key) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found at " + row + "," + col);
                return true;
            }
            if (matrix[row][col] > key) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }

        System.out.println("Not found in the matrix");
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };

        int key = 9; // Try changing this to test other cases
        searchInMatrix(matrix, key);
    }
}
```

---

## 🏃‍♂️ Quick Dry Run

Let’s look for the number **9** in the example matrix:

1. Start at the **top-right** corner (element `11` at `[0][3]`).
2. `11` is greater than `9`, so move **left** to `7` at `[0][2]`.
3. `7` is less than `9`, so move **down** to `8` at `[1][2]`.
4. `8` is less than `9`, so move **down** again to `9` at `[2][2]`.
5. Bingo! We found `9` at position `[2][2]`.

> This approach saves time by only checking specific elements rather than scanning the entire matrix.

---

## ⚡ Why is This Efficient?

Instead of a brute-force search through every element (which would take *O(n²)* time for an `n x n` matrix), this approach works in **O(n)** time for an `n x n` matrix, making it much faster for large matrices.

---

## 🔥 Where is This Useful?

- **Data tables** where rows and columns are sorted, like spreadsheets with organized data.
- **2D spatial problems** where movement can be optimized by skipping unnecessary checks.
- **Efficient search** in structured datasets, like in databases or inventory systems.

Enjoy exploring this efficient search strategy and keep practicing to master matrix manipulations! 🎉