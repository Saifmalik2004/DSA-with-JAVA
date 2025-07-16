
## 🌀 Spiral Matrix Traversal in Java

### 📌 Problem Statement

Given a 2D matrix of `n x m` elements, return all elements of the matrix in **spiral order**, starting from the top-left corner and moving clockwise.

---

### 💡 Intuition and Approach

When we look at the matrix and imagine the spiral pattern, we notice that:

* First, we go **left to right** on the top row
* Then, **top to bottom** on the last column
* Then, **right to left** on the bottom row
* Finally, **bottom to top** on the first column

This process is repeated inwards until all elements are visited.

To implement this pattern, we can use **4 pointers**:

* `top` → starting row
* `bottom` → ending row
* `left` → starting column
* `right` → ending column

We move in the spiral by adjusting these pointers as we move around the matrix.

---

### 🧠 Steps to Approach

1. Initialize `top = 0`, `bottom = rows - 1`, `left = 0`, `right = cols - 1`
2. Run a loop until `top <= bottom` and `left <= right`
3. In each loop:

   * Traverse from left to right on the `top` row
   * Traverse from top to bottom on the `right` column
   * If rows remain, traverse right to left on the `bottom` row
   * If columns remain, traverse bottom to top on the `left` column
4. Update the boundaries accordingly (`top++`, `bottom--`, `left++`, `right--`)

---

### 📄 Full Java Code

```java
import java.util.ArrayList;
import java.util.List;

public class Clean {

    // Function to return the matrix elements in spiral order
    public static List<Integer> spiral(int[][] matrix) {
        int n = matrix.length;         // number of rows
        int m = matrix[0].length;      // number of columns

        int top = 0;
        int left = 0;
        int bot = n - 1;
        int right = m - 1;

        List<Integer> ans = new ArrayList<>();

        // Loop until all boundaries meet
        while (left <= right && top <= bot) {

            // Step 1: Traverse top row (left to right)
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++; // move top boundary down

            // Step 2: Traverse right column (top to bottom)
            for (int i = top; i <= bot; i++) {
                ans.add(matrix[i][right]);
            }
            right--; // move right boundary left

            // Step 3: Traverse bottom row (right to left), if rows remain
            if (top <= bot) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bot][i]);
                }
                bot--; // move bottom boundary up
            }

            // Step 4: Traverse left column (bottom to top), if columns remain
            if (left <= right) {
                for (int i = bot; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++; // move left boundary right
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        List<Integer> result = spiral(matrix);

        // Output the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
```

---

### 🧾 Sample Output

```
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
```

---

### 🔍 Dry Run Example

For matrix:

```
1   2   3   4
5   6   7   8
9  10  11  12
13 14  15  16
```

Spiral order would be:

* Top row → `1 2 3 4`
* Right column → `8 12 16`
* Bottom row → `15 14 13`
* Left column → `9 5`
* Inner Top row → `6 7`
* Inner Right → `11`
* Inner Bottom → `10`

Final Result:
`[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]`

---

### ✅ Time and Space Complexity

* **Time Complexity:** `O(n * m)` — Every element is visited once
* **Space Complexity:** `O(n * m)` — Output list stores all elements
