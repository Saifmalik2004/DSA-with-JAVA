

# 📌 **Pascal’s Triangle - Finding a Specific Element**  

### 🔍 **Problem Statement**  
Given two integers **r** and **c**, find the element at row `r` and column `c` in **Pascal’s Triangle**.  

📌 **Pascal’s Triangle** is a triangular array where:  
- The first and last element of each row is **1**.  
- Each element is the sum of the two elements directly above it.  
- The value at any position `(r, c)` is given by the **binomial coefficient formula**:  

\[
C(n, k) = \frac{n!}{k! \times (n-k)!}
\]

Where:  
- `n = r - 1` (row index starting from 0)  
- `k = c - 1` (column index starting from 0)  

---

### 📥 **Example Input & Output**  
#### ✅ Example 1:
**Input:**  
```java
int r = 5, c = 3;
System.out.println(pascalTriangle(r, c));
```
**Output:**  
```
6
```

🔹 **Explanation:**  
In Pascal’s Triangle, the **5th row, 3rd column** is **6**:

```
      1
     1 1
    1 2 1
   1 3 3 1
  1 4 6 4 1   <- (5th row)
```
The 3rd element (1-based index) is **6**.

---

### 🏆 **Approach: Using nCr (Binomial Coefficient)**
Instead of generating the entire Pascal’s Triangle, we can directly compute the element at position `(r, c)` using the **nCr formula**:

\[
C(n, k) = \frac{(n-k+1) \times (n-k+2) \times ... \times n}{1 \times 2 \times ... \times k}
\]

This avoids calculating factorials, making the computation **efficient** (O(r)).

---

### 💡 **Code Implementation (With Comments)**
```java
public class Optimize {
    
    // Function to compute nCr using iterative approach
    public static long nCr(int n, int r) {
        long res = 1;
        
        // Compute nCr using the formula: (n! / (r! * (n-r)!))
        for (int i = 0; i < r; i++) {
            res *= (n - i);  // Multiply by decreasing values of n
            res /= (i + 1);  // Divide by increasing values of r
        }
        
        return res;
    }

    // Function to find Pascal's Triangle element at row r, column c
    public static int pascalTriangle(int r, int c) {
        return (int) nCr(r - 1, c - 1);  // Convert to 0-based index
    }

    public static void main(String[] args) {
        int r = 5, c = 3;

        // Expected output: 6
        System.out.println(pascalTriangle(r, c));
    }
}
```

---

### 🕵️ **Dry Run (Step-by-Step Execution)**  
For **r = 5, c = 3**, we compute:

\[
C(4, 2) = \frac{4!}{2!(4-2)!} = \frac{4 \times 3}{2 \times 1} = 6
\]

| Iteration | `res *= (n - i)` | `res /= (i + 1)` | `res`  |
|-----------|----------------|----------------|--------|
| i = 0    | 4              | 1              | 4      |
| i = 1    | 12             | 2              | 6      |

**Final Result:** `6` ✅

---

### ⏳ **Time & Space Complexity Analysis**  

| Approach       | Time Complexity | Space Complexity |
|---------------|---------------|----------------|
| **Brute Force (Generating Pascal’s Triangle)** | O(r²) | O(r²) |
| **Optimized (Using nCr Formula)** | **O(r)** | **O(1)** |

🔹 **Why is this approach optimal?**  
- It avoids storing the entire Pascal’s Triangle (reduces space).  
- Uses an **iterative approach** to calculate nCr efficiently.  

---

### 📊 **Comparison Table**  
| Method | Approach | Complexity |
|--------|---------|------------|
| **Brute Force** | Generate full Pascal’s Triangle and return `triangle[r-1][c-1]` | **O(r²)** |
| **Optimized** | Compute directly using **nCr** formula | **O(r)** |

---

### 🌍 **Real-World Applications**
1. **Combinations & Probability Theory** - Pascal’s Triangle is widely used in probability calculations.  
2. **Binomial Expansion** - Helps compute coefficients in polynomial expansions.  
3. **Graph Theory** - Used in **shortest path algorithms**.  
4. **Computer Graphics** - Used in **Bezier curves** for smooth animations.  

---

### 🎯 **Key Takeaways**
✔ Pascal’s Triangle follows the **binomial coefficient pattern**.  
✔ We can compute `(r, c)` directly using **nCr** instead of generating the entire triangle.  
✔ **Time complexity:** O(r), **Space complexity:** O(1).  
✔ Useful in **mathematics, probability, and computer science**! 🚀  

---

### 📌 **Conclusion**
This approach **efficiently** finds any element in Pascal’s Triangle without storing unnecessary values. It is **fast, memory-efficient, and practical** for large values of `r`. 🔥  

---