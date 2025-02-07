

# **📜Set Matrix Rows and Columns to Zero**

---

### **Problem Description** 🤔

You are given a matrix. If an element in the matrix is 0, you need to set its entire row and column to zero. The challenge is to solve this problem efficiently in terms of both time and space complexity.

**Example**:
```
Input Matrix:
{1, 2, 3, 4}
{5, 0, 6, 7}
{8, 9, 10, 11}
{12, 13, 14, 0}

Output Matrix:
{1, 0, 3, 4}
{0, 0, 0, 0}
{8, 0, 10, 11}
{0, 0, 0, 0}
```

---

### **Approach 1: Brute Force** 💡

#### **Description**:
In the brute force approach, we traverse the entire matrix. For each zero found, we iterate through the respective row and column and mark the elements as zero. This results in multiple passes over the matrix and has a higher time complexity.
---
Here's how it works:
1. **Step 1**: Traverse the matrix to find 0's.
2. **Step 2**: When you find a 0, mark the corresponding row and column to be "zeroed".
3. **Step 3**: Replace those marks (or placeholders) with actual 0’s.

### **3. Pseudo Code** 📝  
Let's break this down into simple steps. Here’s the pseudo-code:

```
For each element in the matrix:
    If element is 0:
        Set its row and column to a temporary marker (e.g., -1)

For each element in the matrix:
    If the element is marked (i.e., -1):
        Set it to 0

```

### **4. Step-by-Step Explanation of the Code** 🛠️  
Now, let's take a closer look at how the code works:

1. **`setZero` Function**:
    - This function is called with the matrix, its number of rows (n), and columns (m).
    - It loops through the matrix to find 0's and calls the `set` function to mark their respective rows and columns.
  
2. **`set` Function**:
    - The `set` function is responsible for marking the entire row and column of any 0 element.
    - When it finds a 0 at position (i, j), it marks all elements in row `i` and column `j` as -1 (a temporary marker).
    
3. **Final Replacement**:
    - After marking all affected rows and columns, the code replaces all -1 markers with actual 0’s to get the desired result.

### **5. Example Walkthrough** 🌟  
Let's go step-by-step through a sample input:

Matrix:
```
{1, 1, 1, 1}  
{1, 0, 0, 1}  
{1, 1, 0, 1}  
{1, 1, 1, 1}
```

- **Step 1**: Find the first 0 at position (1, 1) and mark its row and column.
  - The matrix becomes:
  ```
  {1, -1, -1, 1}  
  {-1, 0, 0, -1}  
  {1, 1, -1, 1}  
  {1, 1, 1, 1}
  ```
  
- **Step 2**: Find the second 0 at position (1, 2) and mark its row and column.
  - The matrix becomes:
  ```
  {1, -1, -1, 1}  
  {-1, 0, 0, -1}  
  {-1, 1, -1, 1}  
  {1, 1, -1, 1}
  ```

- **Step 3**: Replace all the markers (-1) with 0’s, resulting in the final matrix:
  ```
  {1, 0, 0, 1}  
  {0, 0, 0, 0}  
  {0, 0, 0, 1}  
  {1, 0, 0, 1}
  ```

### **6. How This Will Work** 💬  
This solution is useful in many scenarios, such as:
- **Matrix Manipulation**: When you're dealing with grids and need to clear rows and columns.
- **Game Development**: Similar concepts are applied when resetting areas of a game board based on specific conditions (e.g., obstacles, zones).
- **Data Processing**: Handling incomplete or corrupted data by resetting certain rows/columns.

Users can adapt this approach in various domains, like setting specific grid elements to neutral states based on certain criteria.

### **7. Full Code with Comments** 🖥️✨

```java
public class Brute {
    // Brute force approach to set rows and columns to zero
    public static void setZero(int met[][], int n, int m) {
        // Traverse the matrix to find 0's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (met[i][j] == 0) {
                    set(met, n, m, i, j);  // Call to set rows and columns to -1
                }
            }
        }
        
        // Replace all -1 markers with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (met[i][j] == -1) {
                    met[i][j] = 0;
                }
            }
        }
    }
    
    private static void set(int met[][], int n, int m, int i, int j) {
        // Mark the entire row to -1
        for (int row = 0; row < n; row++) {
            if (met[row][j] == 1) {
                met[row][j] = -1;
            }
        }
        
        // Mark the entire column to -1
        for (int col = 0; col < m; col++) {
            if (met[i][col] == 1) {
                met[i][col] = -1;
            }
        }
    }
    
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1}
        };
        
        setZero(matrix, 4, 4);  // Call to setZero function

        // Print the modified matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

### **9. Complexity Analysis** ⏱️📦

- **Time Complexity**: O(n * m), where n is the number of rows and m is the number of columns. We’re traversing the entire matrix twice.
- **Space Complexity**: O(1), since we are modifying the matrix in-place without requiring additional space.



### **Approach 2: Better Approach** 💡

#### **Description**:  
In this optimized approach, we use two helper arrays:
1. **`row[]`**: Keeps track of rows that need to be set to zero.
2. **`col[]`**: Keeps track of columns that need to be set to zero.

We traverse the matrix twice:
1. The first traversal identifies all the rows and columns that contain 0.
2. The second traversal sets the rows and columns to 0 based on the information stored in the `row[]` and `col[]` arrays.

This approach helps reduce the need for marking matrix elements with temporary markers, making it cleaner and more efficient than the brute-force approach.

---

### **3. Pseudo Code** 📝  

```
1. Create two arrays: row[] and col[].
2. Traverse the matrix:
   - If an element is 0, mark the corresponding row and column in row[] and col[].
3. Traverse the matrix again:
   - If the element's row or column is marked, set it to 0.
```

---

### **4. Step-by-Step Explanation of the Code** 🛠️  

#### **`setZero` Function**:
- **Step 1**: We initialize two arrays, `row[]` and `col[]`, to track which rows and columns need to be zeroed.
- **Step 2**: We loop through the matrix. Whenever we encounter a 0, we mark the respective row and column in the `row[]` and `col[]` arrays.
- **Step 3**: We loop through the matrix once more, and if the current element belongs to a marked row or column, we set it to 0.

#### **Main Function**:
- We initialize a sample matrix and call the `setZero` function.
- After modifying the matrix, we print the updated version.

---

### **5. Example Walkthrough** 🌟  
Let’s walk through an example input:

Matrix:
```
{1, 1, 1, 1}  
{1, 0, 0, 1}  
{1, 1, 0, 1}  
{1, 1, 1, 1}
```

- **Step 1**: Traverse the matrix and mark the rows and columns that contain a 0:
    - `row[]` will be: `{0, 1, 1, 0}`  
    - `col[]` will be: `{0, 1, 1, 0}`

- **Step 2**: Set the elements in the marked rows and columns to 0:
    - The matrix becomes:
    ```
    {1, 0, 0, 1}  
    {0, 0, 0, 0}  
    {0, 0, 0, 1}  
    {1, 0, 0, 1}
    ```

---


### **7. Full Code with Comments** 🖥️✨

```java
public class Better {
    // Function to set rows and columns to zero if any element is zero
    public static void setZero(int met[][], int n, int m) {
        int row[] = new int[n];  // Array to track rows to be zeroed
        int col[] = new int[m];  // Array to track columns to be zeroed
        
        // Mark rows and columns that need to be set to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (met[i][j] == 0) {
                    row[i] = 1;  // Mark the row
                    col[j] = 1;  // Mark the column
                }
            }
        }
        
        // Set the respective rows and columns to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    met[i][j] = 0;  // Set the cell to zero
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // Sample matrix with 0's
        int matrix[][] = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1}
        };
        
        // Call function to set rows and columns to zero
        setZero(matrix, 4, 4);

        // Print the modified matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

---

### **9. Complexity Analysis** ⏱️📦  
- **Time Complexity**: O(n * m), where n is the number of rows and m is the number of columns. We traverse the matrix twice.
- **Space Complexity**: O(n + m), as we are using two additional arrays to store row and column markers.

---


### **Approach 3: Optimized Approach** 💡

#### **Description**:
To solve this problem with optimized space, we'll:
1. **Use the first row and the first column as markers**: If any element in the matrix is 0, we mark the corresponding first row and first column elements as 0.
2. **Track the first column separately**: Since the first column is also used for marking, we'll need an extra variable to track whether it should be set to zero at the end.

**Steps**:
1. **Marking Phase**: Traverse the matrix and mark the first row and first column whenever a 0 is found in the matrix.
2. **Setting Zeros Phase**: Use the marked first row and column to set the corresponding elements to zero.
3. **Handle Special Case**: The first row and the first column need to be handled separately because they are used for marking.

---

### **3. Pseudo Code** 📝  
Here’s the simplified pseudocode to explain the logic:
```
1. Initialize a variable `col0` to 1, which will track if the first column needs to be zeroed.
2. Traverse the matrix:
   - If a matrix element is 0, mark the first row and first column at that position.
3. Use the first row and first column to set other matrix elements to 0.
4. Handle the first row and first column separately:
   - If `matrix[0][0]` is 0, set all elements in the first row to 0.
   - If `col0` is 0, set all elements in the first column to 0.
```

---

### **4. Step-by-Step Explanation of the Code** 🛠️  

#### **`setZero` Function**:
- **Step 1**: We initialize a variable `col0` to track whether the first column should be set to zero.
- **Step 2**: We loop through the matrix and if a 0 is found at position `(i, j)`, we:
  - Mark the first column of that row (`matrix[i][0] = 0`).
  - Mark the first row of that column (`matrix[0][j] = 0`).
  - If the zero is in the first column, we mark `col0 = 0` (since the first column is being used for marking).
  
- **Step 3**: We loop through the rest of the matrix (starting from the second row and column) and set the element to 0 if either the first row or first column is marked as 0.

- **Step 4**: After the matrix is modified, we handle:
  - The first row: If `matrix[0][0] == 0`, set all elements in the first row to 0.
  - The first column: If `col0 == 0`, set all elements in the first column to 0.

#### **Main Function**:
- We initialize a sample matrix and call the `setZero` function.
- Finally, we print the updated matrix.

---

### **5. Example Walkthrough** 🌟  
Let’s walk through an example input:

Matrix:
```
{0, 4, 2, 0}  
{1, 2, 1, 1}  
{1, 1, 5, 1}  
{9, 1, 1, 1}
```

- **Step 1**: Traverse the matrix and mark the first row and column based on the presence of 0:
  - We find 0 at `(0, 0)`, so mark `matrix[0][0] = 0` and `matrix[0][3] = 0`.
  - We find 0 at `(0, 3)`, so mark `matrix[0][3] = 0` (already done).
  - We find 0 at `(1, 0)`, so mark `matrix[1][0] = 0`.

- **Step 2**: After marking, the matrix looks like this:
```
{0, 4, 2, 0}  
{0, 2, 1, 1}  
{1, 1, 5, 1}  
{9, 1, 1, 1}
```

- **Step 3**: Now set the zeros based on the first row and first column:
  - At `(1, 1)`, since `matrix[1][0] == 0` (marking row), set `matrix[1][1] = 0`.
  - Similarly, set all other elements in the matrix where the row or column is marked.

- **Step 4**: After the second phase:
```
{0, 4, 2, 0}  
{0, 0, 0, 0}  
{0, 1, 5, 0}  
{0, 1, 1, 0}
```

- **Step 5**: Handle the first row and first column:
  - Set the first row and first column to zero as needed.
  - The final matrix looks like:
```
{0, 0, 0, 0}  
{0, 0, 0, 0}  
{0, 0, 0, 0}  
{0, 0, 0, 0}
```

---


### **7. Full Code with Comments** 🖥️✨

```java
public class Optimize {
    // Optimized approach using first row and first column as markers
    public static void setZero(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;  // Variable to track if first column needs to be zeroed
        
        // Mark first row and column if a zero is found
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // Mark the first column
                    if (j != 0) {
                        matrix[0][j] = 0;  // Mark the first row
                    } else {
                        col0 = 0;  // Special handling for the first column
                    }
                }
            }
        }
        
        // Set zeros based on markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        // Handle the first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Handle the first column
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        int matrix[][] = {
            {0, 4, 2, 0},
            {1, 2, 1, 1},
            {1, 1, 5, 1},
            {9, 1, 1, 1}
        };
        
        setZero(matrix);

        // Print the modified matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

---

### **9. Complexity Analysis** ⏱️📦  
- **Time Complexity**: O(n * m), as we traverse the matrix twice.
- **Space Complexity**: O(1), as we only use a constant amount of extra space (the `col0` variable).

---


---

### **Time and Space Complexity Comparison** ⏱️📦

#### **Brute Force Approach**:
- **Time Complexity**: O(n * m * (n + m)), since for each zero, we traverse the entire row and column.
- **Space Complexity**: O(1), no extra space is used apart from the input matrix.

#### **Better Approach**:
- **Time Complexity**: O(n * m), as we only traverse the matrix twice—once for marking and once for setting the zeros.
- **Space Complexity**: O(n + m), using extra space for the row and column arrays.

#### **Optimized Approach**:
- **Time Complexity**: O(n * m), as we traverse the matrix only a couple of times.
- **Space Complexity**: O(1), as we only use a constant amount of extra space (`col0`).

---

### **Key Takeaways** 🚀
- The brute force approach works but is inefficient due to multiple passes over the matrix.
- The better approach improves efficiency by using auxiliary arrays, but it still requires additional space.
- The optimized approach is the most efficient in terms of both time and space, making it the best solution for large matrices.

**🎉** **Great job on mastering the matrix problem with optimized solutions! Keep pushing the boundaries!** 😄

