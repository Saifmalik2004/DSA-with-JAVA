# Search in a Sorted Matrix II

This document provides a comprehensive explanation of the "Search a 2D Matrix II" problem, a popular Data Structures and Algorithms (DSA) challenge. The matrix is sorted such that each row is sorted in ascending order, and each column is sorted in ascending order. We will explore two approaches to search for a target value in this matrix: a brute-force method using binary search on each row and an optimized approach starting from the top-right corner. The explanations include intuition, pseudocode, Java code, complexity analysis, and a comparison of the approaches, designed to be accessible for beginners while providing insights for advanced readers.

## Problem Statement

Given an `m x n` integer matrix where:
- Each row is sorted in non-decreasing order (ascending).
- Each column is sorted in non-decreasing order (ascending).
- All elements are integers.

Write a function to determine if a target value `k` exists in the matrix. Return `true` if the target is found, `false` otherwise.

### Example

**Input:**
```
matrix = [
  [1,  4,  7,  11, 15],
  [2,  5,  8,  12, 19],
  [3,  6,  9,  16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
k = 5
```
**Output:** `true` (because 5 is present at position [1][1])

**Input:**
```
matrix = [
  [1,  4,  7,  11, 15],
  [2,  5,  8,  12, 19],
  [3,  6,  9,  16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
k = 20
```
**Output:** `false` (because 20 is not present in the matrix)

### Constraints
- `1 <= m, n <= 300`
- `-10^9 <= matrix[i][j], k <= 10^9`

## Approach 1: Binary Search on Each Row (Brute Force)

### Intuition
Since each row is sorted in ascending order, we can perform a binary search on each row to check if the target value `k` exists. For each row, we first verify if the target is within the row’s range (i.e., between the first and last elements). If it is, we apply binary search to that row; otherwise, we skip to the next row. This approach leverages the sorted property of the rows but does not utilize the sorted columns, making it less efficient than the optimized approach.

### Pseudocode
```
function bruteSearch(matrix, k):
    m = number of rows
    n = number of columns
    for i from 0 to m-1:
        if matrix[i][0] <= k <= matrix[i][n-1]:
            perform binary search on row i for k
            if k is found:
                return true
    return false

function binarySearch(row, k, low, high):
    while low <= high:
        mid = low + (high - low) / 2
        if row[mid] equals k:
            return true
        else if row[mid] < k:
            low = mid + 1
        else:
            high = mid - 1
    return false
```

### Code
```java
public class Brute {
    public static boolean search(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int low = 0;
            int high = n - 1;

            if (matrix[i][low] <= k && k <= matrix[i][high]) {
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (matrix[i][mid] == k) {
                        return true;
                    } else if (matrix[i][mid] < k) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("Brute Search 4: " + search(matrix, 4));
    }
}
```

### Complexity Analysis
- **Time Complexity**: O(m * log n), where `m` is the number of rows and `n` is the number of columns. We perform a binary search (O(log n)) on each of the `m` rows.
- **Space Complexity**: O(1), as we use only a constant amount of extra space.

### Why It Works
This approach works because each row is sorted, allowing efficient binary search within each row. By checking the row’s range, we avoid unnecessary searches in rows that cannot contain the target. However, it does not leverage the sorted columns, limiting its efficiency.

### Limitations
- Iterates through all rows, which can be slow if `m` is large.
- Ignores the sorted property of columns, missing an opportunity for optimization.

## Approach 2: Search from Top-Right Corner (Optimized)

### Intuition
The matrix’s property that both rows and columns are sorted allows us to use a more efficient approach. We start from the top-right corner (position `[0][n-1]`). At this point:
- If the current element equals the target, we return `true`.
- If the current element is greater than the target, we move left (to a smaller value in the same row).
- If the current element is less than the target, we move down (to a larger value in the same column).

This approach eliminates portions of the matrix in each step, as:
- Moving left excludes the current column (all values in that column are greater than the target).
- Moving down excludes the current row (all values in that row are less than the target).

By continuing this process, we either find the target or exhaust the search space.

### Visual Explanation
Consider the matrix:
```
[1,  4,  7,  11, 15]
[2,  5,  8,  12, 19]
[3,  6,  9,  16, 22]
[10, 13, 14, 17, 24]
[18, 21, 23, 26, 30]
```
Start at `[0][4]` (value 15), searching for `k = 5`:
- 15 > 5, move left to `[0][3]` (value 11).
- 11 > 5, move left to `[0][2]` (value 7).
- 7 > 5, move left to `[0][1]` (value 4).
- 4 < 5, move down to `[1][1]` (value 5).
- 5 == 5, return `true`.

This approach resembles a staircase pattern, moving left or down based on comparisons.

### Pseudocode
```
function optimizedSearch(matrix, k):
    m = number of rows
    n = number of columns
    i = 0
    j = n - 1
    while i < m and j >= 0:
        if matrix[i][j] equals k:
            return true
        else if matrix[i][j] < k:
            i = i + 1
        else:
            j = j - 1
    return false
```

### Code
```java
public class Optimize {
    public static boolean search(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            int point = matrix[i][j];
            if (point == k) {
                return true;
            } else if (point < k) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("Optimized Search 4: " + search(matrix, 4));
    }
}
```

### Complexity Analysis
- **Time Complexity**: O(m + n), where `m` is the number of rows and `n` is the number of columns. In the worst case, we traverse from the top-right corner to the bottom-left corner, making at most `m` downward moves and `n` leftward moves.
- **Space Complexity**: O(1), as we use only a constant amount of extra space.

### Why It Works
This approach works because the sorted properties of both rows and columns allow us to make definitive decisions at each step. Starting from the top-right corner, we can eliminate either a row or a column based on whether the current element is less than or greater than the target. This pruning ensures we efficiently narrow down the search space.

### Advantages
- Fully leverages both row and column sorting.
- More efficient than binary search on rows for large matrices.
- Simple and intuitive once the pattern is understood.

## Comparison of Approaches

| Approach                  | Time Complexity | Space Complexity | Pros                              | Cons                                    |
|---------------------------|-----------------|------------------|-----------------------------------|-----------------------------------------|
| Binary Search on Rows     | O(m * log n)    | O(1)             | Leverages row sorting, simple     | Ignores column sorting, less efficient  |
| Top-Right Corner Search   | O(m + n)        | O(1)             | Efficient, uses both sortings     | Slightly less intuitive initially      |

## When to Use Each Approach
- **Binary Search on Rows**: Use when the number of rows is small, or you prefer a familiar binary search approach. Suitable for scenarios where column sorting is not guaranteed.
- **Top-Right Corner Search**: Use for large matrices where efficiency is critical, and both row and column sorting can be exploited. This is the preferred approach for this problem.

## Edge Cases
- **Empty matrix**: Return `false` (handled by checking matrix length).
- **Single element matrix**: Both approaches work correctly.
- **Target not in matrix**: Both approaches return `false`.
- **Target at boundaries** (e.g., [0][0], [0][n-1], [m-1][0], [m-1][n-1]): Both approaches handle these correctly.
- **Matrix with one row or one column**: Both approaches work, with the optimized approach being more efficient.
- **Duplicate elements**: Both approaches return `true` if the target exists, regardless of duplicates.

## Additional Notes
- The top-right corner approach could also start from the bottom-left corner ([m-1][0]), with similar logic (move right if current < target, up if current > target). The time complexity remains O(m + n).
- A true brute-force approach (checking every element) would take O(m * n) time but is not practical given the sorted properties.
- Binary search on columns instead of rows would also yield O(n * log m) time but is similarly suboptimal compared to the optimized approach.

## Conclusion
The "Search a 2D Matrix II" problem highlights the importance of leveraging all available properties of a data structure. The binary search on rows approach is a straightforward improvement over a linear scan, utilizing row sorting to achieve O(m * log n) time complexity. However, the optimized top-right corner search fully exploits both row and column sorting, achieving a superior O(m + n) time complexity. For most practical scenarios, the optimized approach is recommended due to its efficiency and elegance, making it a valuable technique for similar matrix-based problems.