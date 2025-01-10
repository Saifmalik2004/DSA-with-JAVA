### **Lecture 16: Time and Space Complexity – Measuring Efficiency in Code**

Welcome to **Lecture 16**, where we’ll dive deep into **time and space complexity**! 🌟 Understanding these concepts is like unlocking a superpower that helps you write efficient code and optimize solutions. It’s especially important when solving large-scale problems or preparing for coding interviews.

By the end of this Lecture, you’ll have a clear understanding of **time complexity**, **space complexity**, and how to compute them using **Big O**, **Big Omega**, and **Big Theta** notations.

---
<img src="https://media.licdn.com/dms/image/C5612AQHWX05Io07U6Q/article-cover_image-shrink_720_1280/0/1649267414579?e=2147483647&v=beta&t=raUKbDzqySqsuv4Q2XvWIz9bxVxPDKfDQ7eTprNxZVM" alt="chart"  >

### **Introduction to Time Complexity**

#### **What is Time Complexity?**
Time complexity measures how the running time of an algorithm increases as the size of the input grows. It gives you an idea of how your program will perform for different input sizes.

#### **Why Do We Compute Time Complexity?**
- **Performance Insights**: It helps you understand how fast (or slow) your algorithm is.  
- **Scalability**: Ensures your solution can handle larger datasets without significant performance issues.  
- **Comparison**: Allows you to compare two algorithms and decide which one is better.  

Imagine you’re writing code to sort a list of names. A fast algorithm will sort a million names in seconds, while a slower one might take hours! Computing time complexity helps you choose the faster approach.

---

### **Big O Notation: Understanding the Worst Case**

#### **What is Big O?**
Big O notation describes the **upper bound** of an algorithm’s time complexity, i.e., the **worst-case scenario**. It gives a guarantee on the maximum time the algorithm will take, regardless of the input.

#### **Common Big O Notations and Their Examples**:
- **O(1)**: Constant time  
  Example: Accessing an element in an array by its index.  
  ```java
  int x = arr[5]; // O(1)
  ```

- **O(log n)**: Logarithmic time  
  Example: Binary search.  
  ```java
  int binarySearch(int[] arr, int key) { // O(log n)
      int low = 0, high = arr.length - 1;
      while (low <= high) {
          int mid = (low + high) / 2;
          if (arr[mid] == key) return mid;
          if (arr[mid] < key) low = mid + 1;
          else high = mid - 1;
      }
      return -1;
  }
  ```

- **O(n)**: Linear time  
  Example: Iterating through an array.  
  ```java
  for (int i = 0; i < n; i++) { // O(n)
      System.out.println(arr[i]);
  }
  ```

- **O(n²)**: Quadratic time  
  Example: Nested loops.  
  ```java
  for (int i = 0; i < n; i++) { // O(n²)
      for (int j = 0; j < n; j++) {
          System.out.println(i + j);
      }
  }
  ```

- **O(2ⁿ)**: Exponential time  
  Example: Solving the Tower of Hanoi problem.

---

### **Big Omega (Ω) and Big Theta (Θ)**

#### **Big Omega (Ω)**: Best Case
- Describes the **minimum time** an algorithm will take (best-case scenario).
- Example: For linear search, the best case is when the target is the first element.  
  Time Complexity: **Ω(1)**.

#### **Big Theta (Θ)**: Tight Bound
- Describes the **exact time** complexity of an algorithm in both the best and worst cases.  
- Example: Sorting an array using Merge Sort has a time complexity of **Θ(n log n)** because it’s the same in all cases.

---

### **How to Compute Time Complexity**

#### **Rules for Time Complexity**:
1. **Ignore Constants**: Focus on how the function grows with input size.  
   Example: \(3n + 5 → O(n)\).
   
2. **Focus on the Largest Term**: Only the most significant term matters.  
   Example: \(n² + 3n + 5 → O(n²)\).
   
3. **Loops**:  
   - A loop running \(n\) times → \(O(n)\).  
   - Nested loops → Multiply complexities (\(O(n²)\) for two nested loops).

4. **Function Calls**: Add complexities of consecutive calls and multiply for nested calls.

#### **Example**:
Let’s analyze the time complexity of this function:
```java
void example(int n) {
    for (int i = 0; i < n; i++) {        // O(n)
        for (int j = 0; j < n; j++) {    // O(n)
            System.out.println(i + j);  // O(1)
        }
    }
}
```
- Outer loop: \(O(n)\).  
- Inner loop: \(O(n)\).  
- Total: \(O(n) × O(n) = O(n²)\).

---

### **Introduction to Space Complexity**

#### **What is Space Complexity?**
Space complexity measures how much **extra memory** (or space) an algorithm needs to run. It includes:
1. **Fixed Space**: Memory required for variables, constants, etc.
2. **Dynamic Space**: Memory required for dynamic allocations like recursion stacks, temporary arrays, etc.

#### **Why is Space Complexity Important?**
In some cases (e.g., embedded systems), memory is limited, so optimizing for space is critical.

---

### **Example of Space Complexity**

Let’s compute space complexity for a recursive function:
```java
int factorial(int n) {
    if (n == 0) return 1; // Base case
    return n * factorial(n - 1); // Recursive call
}
```
- For each recursive call, a new stack frame is created.  
- Maximum depth of recursion = \(n\).  
- Space complexity = \(O(n)\).

---

### **Time and Space Complexity Example**

Let’s combine time and space complexity analysis for Merge Sort:

#### **Merge Sort**:
```java
void mergeSort(int[] arr, int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);  // Recursive call (O(log n))
        mergeSort(arr, mid + 1, right);  // Recursive call (O(log n))
        merge(arr, left, mid, right);  // Merging (O(n))
    }
}
```

**Time Complexity**:  
- Divide step: \(O(\log n)\).  
- Merge step: \(O(n)\).  
- Total: \(O(n \log n)\).

**Space Complexity**:  
- Temporary arrays for merging → \(O(n)\).  
- Stack space for recursion → \(O(\log n)\).  
- Total: \(O(n)\).

---

### **Summary**

- **Time Complexity**: Measures algorithm speed; Big O describes the worst case.  
- **Space Complexity**: Measures memory usage; critical for optimization.  
- Use rules to compute complexities step by step.  
- Understanding time and space complexity helps you write **efficient and scalable code**.

Now, check the **code files** for hands-on practice with complexity analysis! 🚀