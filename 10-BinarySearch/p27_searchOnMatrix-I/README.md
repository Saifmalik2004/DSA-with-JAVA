# Search in a Sorted Matrix

This document explains the problem of searching for a target value in a sorted matrix, a common Data Structures and Algorithms (DSA) problem. The matrix is sorted in a way that each row is sorted in ascending order, and the first element of each row is greater than the last element of the previous row. We'll explore multiple approaches to solve this problem, starting from a brute-force method to an optimized solution, with detailed explanations, pseudocode, Java code, and complexity analysis.

## Problem Statement

Given an `m x n` matrix where:
- Each row is sorted in ascending order.
- The first element of each row is greater than the last element of the previous row.
- All elements are integers.

Write a function to determine if a target value `k` exists in the matrix. Return `true` if the target is found, `false` otherwise.

### Example

**Input:**
```
matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
k = 5
```
**Output:** `true` (because 5 is present in the matrix)

**Input:**
```
matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
k = 10
```
**Output:** `false` (because 10 is not present in the matrix)

### Constraints
- `1 <= m, n <= 100`
- `-10^4 <= matrix[i][j], k <= 10^4`

## Approach 1: Brute Force (Linear Search)

### Intuition
The simplest way to search for a target value is to check every element in the matrix. Since the matrix is `m x n`, we can iterate through each cell using nested loops and compare each element with the target value `k`. If we find a match, we return `true`. If we complete the iteration without finding the target, we return `false`.

This approach doesn't leverage the sorted property of the matrix, making it inefficient but straightforward.

### Pseudocode
```
function bruteSearch(matrix, k):
    m = number of rows
    n = number of columns
    for i from 0 to m-1:
        for j from 0 to n-1:
            if matrix[i][j] equals k:
                return true
    return false
```

### Code
```java
public class Brute {
    public static boolean search(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == k) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
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
- **Time Complexity**: O(m * n), where `m` is the number of rows and `n` is the number of columns. We check every element in the matrix.
- **Space Complexity**: O(1), as we only use a constant amount of extra space.

### Why It Works
This approach works because it exhaustively checks every element, ensuring that if the target exists, it will be found. However, it ignores the sorted property of the matrix, making it inefficient for large matrices.

### Limitations
- Does not utilize the sorted nature of the matrix.
- Inefficient for large matrices due to linear scanning of all elements.

## Approach 2: Binary Search on Each Row

### Intuition
Since each row is sorted in ascending order, we can perform a binary search on each row to find the target value `k`. For each row, we check if the target is within the row's range (i.e., between the first and last elements). If it is, we apply binary search to that row. If not, we skip the row. This approach leverages the sorted property of the rows to reduce the search time per row from O(n) to O(log n).

### Pseudocode
```
function betterSearch(matrix, k):
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
public class Better {
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
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("Better Search 4: " + search(matrix, 4));
    }
}
```

### Complexity Analysis
- **Time Complexity**: O(m * log n), where `m` is the number of rows and `n` is the number of columns. We perform a binary search (O(log n)) on each of the `m` rows.
- **Space Complexity**: O(1), as we only use a constant amount of extra space.

### Why It Works
This approach works because it takes advantage of the sorted rows. By checking if the target is within a row's range, we avoid unnecessary binary searches. The binary search ensures that we efficiently search each row.

### Limitations
- Still requires iterating through all rows, which can be inefficient if `m` is large.
- Does not fully exploit the fact that the entire matrix is sorted (i.e., the first element of each row is greater than the last element of the previous row).

## Approach 3: Binary Search on Entire Matrix

### Intuition
Since the matrix is sorted such that each row is sorted and the first element of each row is greater than the last element of the previous row, we can treat the matrix as a flattened sorted array of size `m * n`. By mapping a single index (from 0 to `m * n - 1`) to a matrix position `(i, j)` using integer division and modulo operations, we can perform a single binary search on the entire matrix.

For a given index `mid`:
- Row index `i = mid / n`
- Column index `j = mid % n`

This approach fully leverages the sorted property of the matrix, making it the most efficient.

### Pseudocode
```
function optimizedSearch(matrix, k):
    m = number of rows
    n = number of columns
    low = 0
    high = m * n - 1
    while low <= high:
        mid = low + (high - low) / 2
        i = mid / n
        j = mid % n
        if matrix[i][j] equals k:
            return true
        else if matrix[i][j] < k:
            low = mid + 1
        else:
            high = mid - 1
    return false
```

### Code
```java
public class Optimize {
    public static boolean search(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == k) {
                return true;
            } else if (matrix[i][j] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
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
- **Time Complexity**: O(log (m * n)), where `m` is the number of rows and `n` is the number of columns. We perform a single binary search on the entire matrix.
- **Space Complexity**: O(1), as we only use a constant amount of extra space.

### Why It Works
This approach works because the matrix can be viewed as a sorted array due to its properties (each row is sorted, and the first element of each row is greater than the last element of the previous row). By mapping indices to matrix positions, we can apply binary search to efficiently find the target.

### Advantages
- Fully leverages the sorted nature of the matrix.
- Most efficient in terms of time complexity.
- Simple and elegant solution.

## Comparison of Approaches

| Approach            | Time Complexity | Space Complexity | Pros                              | Cons                                    |
|---------------------|-----------------|------------------|-----------------------------------|-----------------------------------------|
| Brute Force         | O(m * n)        | O(1)             | Simple to implement               | Inefficient, ignores sorted property   |
| Binary Search Rows  | O(m * log n)    | O(1)             | Leverages row sorting            | Still iterates over all rows           |
| Optimized Binary Search | O(log (m * n)) | O(1)           | Most efficient, uses full sorting | Slightly more complex index mapping    |

## Visual Explanation

To understand the optimized approach, consider the matrix as a flattened array:

```
Matrix:
[1, 2, 3]
[4, 5, 6]
[7, 8, 9]

Flattened (logical) array:
[1, 2, 3, 4, 5, 6, 7, 8, 9]

For index mid = 4:
- i = mid / n = 4 / 3 = 1
- j = mid % n = 4 % 3 = 1
- Matrix position: matrix[1][1] = 5
```

This mapping allows us to perform binary search on the flattened array while accessing the matrix elements directly.

## When to Use Each Approach
- **Brute Force**: Use for very small matrices or when simplicity is preferred over efficiency.
- **Binary Search on Rows**: Use when the number of rows is small, or you want a balance between simplicity and efficiency.
- **Optimized Binary Search**: Use for large matrices where efficiency is critical, and the sorted property can be fully exploited.

## Edge Cases
- Empty matrix: Return `false` (handled by checking matrix length).
- Single element matrix: All approaches work correctly.
- Target not in matrix: All approaches return `false`.
- Target at boundaries (first or last element): All approaches handle this correctly.
- Matrix with one row or one column: All approaches work, with the optimized approach being most efficient.

## Conclusion
The search in a sorted matrix problem demonstrates the power of leveraging data structure properties to optimize algorithms. The brute-force approach is simple but inefficient, while the binary search on rows improves efficiency by utilizing row sorting. The optimized binary search, treating the matrix as a flattened sorted array, provides the best time complexity of O(log (m * n)). For most practical applications, the optimized approach is recommended due to its efficiency and elegance.