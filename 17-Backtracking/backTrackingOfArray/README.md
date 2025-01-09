### **Backtracking with Arrays in Java**

Welcome to **Backtracking with Arrays**! This program demonstrates the use of recursion and backtracking to fill and modify an array dynamically.

---

### **What is Backtracking?**

Backtracking is a powerful technique that allows you to:
1. Build a solution incrementally.
2. Revert changes (backtrack) to explore alternate possibilities.

In this program:
- The array is filled with sequential values.
- During backtracking, the array values are modified, leading to a unique final state.

---

### **What Does This Program Do?**

1. Initializes an empty array.
2. Recursively fills the array with sequential values (`1, 2, 3, ...`).
3. Prints the fully filled array.
4. During backtracking:
   - Modifies each element of the array by subtracting 2 (`arr[i] = arr[i] - 2`).
   - Prints the final modified state of the array.

---

### **Code Walkthrough**

#### **1. Backtracking Logic**
The core logic is in the `backtrack` function:
```java
public static void backtrack(int arr[], int i, int val) {
    if (i == arr.length) { // Base case: When all elements are filled
        printArr(arr); // Print the array's current state
        return;
    }

    arr[i] = val; // Fill the current index with the given value
    backtrack(arr, i + 1, val + 1); // Move to the next index recursively
    arr[i] = arr[i] - 2; // Backtrack by modifying the current value
}
```

- **Base Case**: The recursion stops when the array is fully filled (`i == arr.length`).
- **Backtracking Step**: On returning, modifies the array by subtracting 2 from the value at the current index.

---

#### **2. Printing the Array**
The `printArr` method displays the current state of the array:
```java
public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " "); // Print each element
    }
    System.out.println(); // New line after printing the array
}
```

---

#### **3. Main Method**
The `main` method initializes and starts the program:
```java
public static void main(String[] args) {
    int arr[] = new int[5]; // Create an array of size 5
    backtrack(arr, 0, 1); // Start backtracking from index 0 with initial value 1
    printArr(arr); // Print the final state of the array after backtracking
}
```

- An empty array of size 5 is created.
- Backtracking begins with an initial value of `1`.
- The final modified array is printed after backtracking.

---

### **Example Output**

Here’s the output for an array of size 5:

```
1 2 3 4 5 
-1 0 1 2 3
```

#### **Explanation of Output**
1. **First Line (`1 2 3 4 5`)**: 
   - The array is filled sequentially and printed once all elements are filled.
   
2. **Second Line (`-1 0 1 2 3`)**: 
   - During backtracking, each element is modified by subtracting 2 (`arr[i] = arr[i] - 2`), resulting in this final state.

---

### **Time Complexity Analysis**

#### **1. Recursive Calls**
- The recursion proceeds in a depth-first manner:
  - Each element of the array is visited once during the recursive filling phase.
  - Backtracking occurs for each element on the return journey.

#### **2. Printing the Array**
- The array is printed twice: 
  - Once after being fully filled.
  - Once after the backtracking is complete.

#### **Overall Complexity**
1. **Time Complexity**:
   - Let `n` be the size of the array.
   - Filling the array and backtracking both involve visiting all elements → `O(n)`.
   - Printing the array takes `O(n)` for each print.
   - Total time complexity: **O(n)** + **O(n)** = **O(n)**.

2. **Space Complexity**:
   - The space used for recursion depends on the depth of the recursion tree.
   - Maximum recursion depth = size of the array (`n`).
   - Space for the recursion stack: **O(n)**.
   - Space for the array: **O(n)**.
   - Total space complexity: **O(n)**.

---

### **Key Concepts Demonstrated**

1. **Recursion**:
   - The function calls itself to fill the array step by step.
2. **Base Case**:
   - Stops recursion when the array is fully filled.
3. **Backtracking**:
   - Modifies the array on the return journey of recursion.
4. **Complexity Analysis**:
   - Demonstrates how recursion impacts time and space complexity.

---

### **Try It Yourself**

- **Change the array size**: Increase or decrease the size of the array to see how the program handles different inputs.
- **Modify the backtracking step**: Experiment with different operations in the backtracking phase (e.g., multiply, divide, or add values).
- **Enhance functionality**: Extend this backtracking logic to solve more complex problems like permutations, puzzles, or pathfinding.

---

### **Conclusion**

This program illustrates how backtracking can be used to dynamically explore and modify solutions. While the output here is simple, the concepts can be extended to solve much more complex problems in computer science.

Happy coding! 🚀