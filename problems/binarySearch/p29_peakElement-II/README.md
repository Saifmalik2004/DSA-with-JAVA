# 📈 Matrix Peak Element

## 🧩 Problem Statement

Given a 2D matrix where **each row is unsorted** but the matrix has **distinct elements**, find any **peak element**.

A **peak element** is defined as an element that is **strictly greater than its left and right neighbors in the same row** (top and bottom neighbors are not considered in this version).

Return the position `(row, col)` of **any** one peak element.

> 🔍 **Constraints**:

* The matrix has at least one row and one column.
* No two adjacent elements are equal.
* The matrix can have multiple peaks — you need to return **any one**.

---

## 📌 Example

### Input:

```java
matrix = {
  {10, 20, 15},
  {21, 30, 14},
  {7,  16, 32}
}
```

### Output:

```
Peak Element Found At: Row = 1, Column = 1
```

### Explanation:

`matrix[1][1] = 30` is greater than its left (`21`) and right (`14`), so it's a **valid peak**.

---

## 🧠 Intuition

In a 1D array, we can find a peak using binary search. We apply the **same logic in 2D** by doing **binary search on columns**.

At each column, we:

* Find the row index of the **maximum element** in that column.
* Compare that element with its immediate left and right.
* Move left or right based on which neighbor is greater (greedy choice).

---

## ✅ Approach 1: Brute Force

### 🔹 Logic:

* Iterate over each element.
* For each element, check if it's greater than its left and right neighbors.

### 💡 Pseudocode:

```
for each row in matrix:
    for each column in row:
        if current > left and current > right:
            return (row, col)
```

### 🧾 Code:

```java
public static int[] bruteForcePeak(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            int left = (j > 0) ? matrix[i][j - 1] : Integer.MIN_VALUE;
            int right = (j < cols - 1) ? matrix[i][j + 1] : Integer.MIN_VALUE;

            if (matrix[i][j] > left && matrix[i][j] > right) {
                return new int[]{i, j};
            }
        }
    }

    return new int[]{};
}
```

### ⏱️ Time Complexity:

* `O(n * m)` — Every element is checked.

### 🧠 Space Complexity:

* `O(1)` — Constant space used.

---

## 🚀 Approach 2: Binary Search on Columns (Optimized)

### 🔹 Core Idea:

* Apply binary search on the **columns** (not rows).
* At each mid column:

  * Find the row with the **maximum element** in that column.
  * Compare with its **left** and **right** neighbors.
  * Move search to side where neighbor is greater.

### 🔁 Steps:

1. Set `low = 0`, `high = cols - 1`
2. While `low <= high`:

   * Find `mid = (low + high) / 2`
   * Find `maxRow = row index of max element in mid column`
   * If matrix\[maxRow]\[mid] > both neighbors → return position
   * Else move to the larger neighbor side

### 📋 Pseudocode:

```
function find(matrix):
    low = 0
    high = number of columns - 1

    while low <= high:
        mid = (low + high) / 2
        maxRow = row index with max element in mid column

        left = matrix[maxRow][mid - 1] if mid > 0
        right = matrix[maxRow][mid + 1] if mid < cols - 1

        if matrix[maxRow][mid] > left and > right:
            return (maxRow, mid)

        if matrix[maxRow][mid] > left:
            low = mid + 1
        else:
            high = mid - 1
```

---

### 🧾 Java Code:

```java
public class Optimize {

    public static int[] find(int[][] matrix) {
        int cols = matrix[0].length;
        int low = 0;
        int high = cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = findMaxElem(matrix, mid);
            int left = mid - 1 >= 0 ? matrix[row][mid - 1] : -1;
            int right = mid + 1 < cols ? matrix[row][mid + 1] : -1;

            if (matrix[row][mid] > left && matrix[row][mid] > right) {
                return new int[] { row, mid };
            } else if (matrix[row][mid] > left) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[] {};
    }

    public static int findMaxElem(int[][] matrix, int col) {
        int max = Integer.MIN_VALUE;
        int maxRow = 0;

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] > max) {
                max = matrix[row][col];
                maxRow = row;
            }
        }

        return maxRow;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {10, 20, 15},
            {21, 30, 14},
            {7, 16, 32}
        };

        int[] peak = find(matrix);
        System.out.println("Peak Element Found At: Row = " + peak[0] + ", Column = " + peak[1]);
    }
}
```

---

### ⏱️ Time Complexity:

* `O(log m * n)`
  (Binary search on columns → log m, and max element scan → O(n))

### 🧠 Space Complexity:

* `O(1)` — No extra space used.

---

## 📊 Comparison of Approaches

| Approach             | Time Complexity | Space Complexity | Notes                      |
| -------------------- | --------------- | ---------------- | -------------------------- |
| Brute Force          | O(n \* m)       | O(1)             | Simple but slow            |
| Column Binary Search | O(n \* log m)   | O(1)             | Optimal for large matrices |

---

## 📝 Notes

* If you want to consider **up/down neighbors** also (true 2D peak), the logic will change slightly.
* This version is commonly asked in interviews like:

  * Google
  * Facebook
  * Amazon

---

## 🔚 Conclusion

This problem demonstrates how a 1D peak-finding strategy can be extended to 2D with clever use of binary search on a **dimension (column)** instead of all elements.

Use the brute force for learning and fallback, but **optimized binary search** is ideal for large data.

---
