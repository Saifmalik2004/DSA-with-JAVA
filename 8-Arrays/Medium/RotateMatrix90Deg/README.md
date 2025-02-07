# **Rotate a Matrix 90 Degrees Clockwise**

## **Problem Description**  
You are given an `N x M` matrix. Your task is to rotate the matrix **90 degrees clockwise** and return the transformed matrix.

💡 **Real-Life Analogy**:  
Imagine holding a piece of paper 📄 with numbers written in a grid. If you rotate it **90 degrees clockwise**, the numbers shift accordingly. Our goal is to achieve this programmatically!

---

## **Example Input and Output**  

### **Example 1**  
**Input**:  
```
Matrix =
1  2  3  4  
5  6  7  8  
9 10 11 12  
13 14 15 16  
```

**Output**:  
```
Rotated Matrix =
13  9  5  1  
14 10  6  2  
15 11  7  3  
16 12  8  4  
```

---

## **Approach**  
We will use **extra space** to store the rotated matrix.

1. Create a **new matrix** of the same dimensions.
2. Iterate through the original matrix.
3. Place each element in its **new rotated position**.
4. Return the rotated matrix.

---

## **Pseudo Code**  
```plaintext
Function rotate90Deg(matrix, n, m):
    Create a new matrix 'rotated' of size n x m
    For i from 0 to n-1:
        For j from 0 to m-1:
            rotated[j][n - 1 - i] = matrix[i][j]
    Return rotated
```

---

## **Step-by-Step Explanation of the Code**  

### **1. Create a New Matrix**
```java
int rotated[][] = new int[n][m];
```
This matrix will store the rotated version of the original matrix.

### **2. Iterate Through the Original Matrix**
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
```
We traverse every element in the matrix.

### **3. Place Elements in Their New Positions**
```java
rotated[j][n - 1 - i] = matrix[i][j];
```
- The **row index (`i`)** becomes the **column index (`j`)**.
- The **column index (`j`)** is transformed into **(n - 1 - i)**, rotating it **90 degrees**.

### **4. Return the Rotated Matrix**
```java
return rotated;
```
This gives us the transformed matrix!

---

## **Code Implementation**  
```java
public class Brute {
    // Function to rotate a matrix 90 degrees clockwise using extra space.
    public static int[][] rotate90Deg(int matrix[][], int n, int m) {
        int rotated[][] = new int[n][m];

        // Rotating elements to their new positions.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotated; // Returning the rotated matrix.
    }

    public static void main(String[] args) {
        // Input matrix
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int n = 4;
        int m = 4;

        // Calling the function to rotate the matrix
        int ans[][] = rotate90Deg(matrix, n, m);

        // Printing the rotated matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

---

## **Dry Run**
### **Input Matrix:**
```
1  2  3  4  
5  6  7  8  
9 10 11 12  
13 14 15 16  
```

### **Transformation Process:**
| Original Position `(i, j)` | New Position `(j, n-1-i)` | Value |
|---------------------------|-------------------------|-------|
| (0,0) → (0,3)  | 1 |
| (0,1) → (1,3)  | 2 |
| (0,2) → (2,3)  | 3 |
| (0,3) → (3,3)  | 4 |
| (1,0) → (0,2)  | 5 |
| (1,1) → (1,2)  | 6 |
| (1,2) → (2,2)  | 7 |
| (1,3) → (3,2)  | 8 |
| (2,0) → (0,1)  | 9 |
| (2,1) → (1,1)  | 10 |
| (2,2) → (2,1)  | 11 |
| (2,3) → (3,1)  | 12 |
| (3,0) → (0,0)  | 13 |
| (3,1) → (1,0)  | 14 |
| (3,2) → (2,0)  | 15 |
| (3,3) → (3,0)  | 16 |

### **Output Matrix:**
```
13  9  5  1  
14 10  6  2  
15 11  7  3  
16 12  8  4  
```

---

## **Time and Space Complexity**  
- **Time Complexity**: **O(N × M)** since we traverse all elements once.  
- **Space Complexity**: **O(N × M)** due to the extra space used for the rotated matrix.

---

## **Key Takeaways**  
✅ **Understanding Matrix Transformations** 🔄  
✅ **Index Manipulation** 🧩  
✅ **Working with Nested Loops** 🔁  
 
## **Optimized Approach**  
We will rotate the matrix **in-place** using the following steps:

1. **Transpose the matrix**: Convert rows into columns by swapping `matrix[i][j]` with `matrix[j][i]`.
2. **Reverse each row**: Swap elements symmetrically to shift them to their correct positions.

---

## **Pseudo Code**  
```plaintext
Function rotate90Deg(matrix):
    // Step 1: Transpose the matrix
    For i from 0 to N-1:
        For j from i+1 to N-1:
            Swap matrix[i][j] with matrix[j][i]

    // Step 2: Reverse each row
    For i from 0 to N-1:
        Reverse matrix[i]
```

---

## **Step-by-Step Explanation of the Code**  

### **1. Transpose the Matrix**
```java
for (int i = 0; i < n - 1; i++) {
    for (int j = i + 1; j < n; j++) {
        swap(matrix, i, j, j, i);
    }
}
```
This swaps elements across the main diagonal, converting rows into columns.

### **2. Reverse Each Row**
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n / 2; j++) {
        swap(matrix, i, j, i, n - 1 - j);
    }
}
```
Each row is reversed to complete the **90-degree rotation**.

---

## **Code Implementation**  
```java
public class Optimize {
    // Function to rotate the matrix 90 degrees clockwise in-place.
    public static void rotate90Deg(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

    // Helper function to swap elements in the matrix
    public static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public static void main(String[] args) {
        // Input matrix
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        // Rotating the matrix in place
        rotate90Deg(matrix);

        // Printing the rotated matrix
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

## **Dry Run**
### **Input Matrix:**
```
1  2  3  4  
5  6  7  8  
9 10 11 12  
13 14 15 16  
```

### **After Transpose:**
```
1  5  9 13  
2  6 10 14  
3  7 11 15  
4  8 12 16  
```

### **After Row Reversal:**
```
13  9  5  1  
14 10  6  2  
15 11  7  3  
16 12  8  4  
```

---

## **Time and Space Complexity**  
- **Time Complexity**: **O(N²)** since we traverse each element twice (transpose + row reversal).  
- **Space Complexity**: **O(1)** since we modify the matrix in-place without extra space.

---

## **Key Takeaways**  
✅ **In-place Matrix Rotation** 🔄  
✅ **Efficient Algorithm (No Extra Space Used)** 🚀  
✅ **Understanding Index Transformations** 🧠  

🎉 Congratulations! You have successfully implemented an optimized matrix rotation. Keep practicing and happy coding! 🚀🔥




