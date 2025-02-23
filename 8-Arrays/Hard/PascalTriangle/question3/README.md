

# 📌 **Pascal’s Triangle - Generating the Full Triangle**  

## 🔍 **Problem Statement**  
Given an integer **n**, generate the first `n` rows of **Pascal’s Triangle**.  

📌 **Pascal’s Triangle** is a triangular array where:  
- The first and last element of each row is **1**.  
- Each element is the sum of the two elements directly above it.  
- The value at any position `(r, c)` is given by the **binomial coefficient formula**:  

\[
C(n, k) = \frac{n!}{k! \times (n-k)!}
\]

Where:  
- `n` is the row index (1-based).  
- Each row is generated using the previous row’s values.

---

## 📥 **Example Input & Output**  
#### ✅ Example 1:
**Input:**  
```java
int n = 5;
List<List<Integer>> ans = pascalTriangle(n);
```
**Output:**  
```
1  
1 1  
1 2 1  
1 3 3 1  
1 4 6 4 1  
```

🔹 **Explanation:**  
The first **5 rows** of Pascal’s Triangle are generated step by step.

---

## 🏆 **Approach: Using Previous Row Values**
Instead of computing factorials, we use the property:

\[
C(n, k) = \frac{C(n, k-1) \times (n-k+1)}{k}
\]

This allows us to compute each row **iteratively** using the previous row’s values.

---

## 💡 **Code Implementation (With Comments)**
```java
import java.util.ArrayList;
import java.util.List;

public class Optimize {
    
    // Method to compute a row using previous row's values
    static List<Integer> printRow(int n) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // First element is always 1

        // Compute remaining elements using previous value
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i); // Multiply by decreasing n values
            ans = ans / i;        // Divide by increasing i values
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    // Method to generate entire Pascal's Triangle
    static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // Compute and store all rows
        for (int row = 1; row <= n; row++) {
            ans.add(printRow(row));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5; // Number of rows
        List<List<Integer>> ans = pascalTriangle(n);

        // Print the triangle
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
```

---

## 🕵️ **Dry Run (Step-by-Step Execution)**  
For **n = 5**, the computation goes like this:

| Row | Computation | Output |
|------|-------------|---------|
| 1 | `1` | `1` |
| 2 | `1, (1*1)/1 = 1` | `1 1` |
| 3 | `1, (1*2)/1 = 2, (2*1)/2 = 1` | `1 2 1` |
| 4 | `1, (1*3)/1 = 3, (3*2)/2 = 3, (3*1)/3 = 1` | `1 3 3 1` |
| 5 | `1, (1*4)/1 = 4, (4*3)/2 = 6, (6*2)/3 = 4, (4*1)/4 = 1` | `1 4 6 4 1` |

✅ **Final Output:**
```
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
```

---

## ⏳ **Time & Space Complexity Analysis**  

| Approach | Time Complexity | Space Complexity |
|----------|---------------|----------------|
| **Generating Pascal’s Triangle** | O(n²) | O(n²) |

🔹 **Why is this efficient?**  
- We compute only the required values for each row.  
- Avoids redundant factorial calculations.  
- Uses **O(n²) space** to store the triangle.

---

## 📊 **Comparison Table**  
| Method | Approach | Complexity |
|--------|---------|------------|
| **Brute Force** | Compute using factorial formula | **O(n³)** |
| **Optimized** | Compute iteratively using previous row | **O(n²)** |

---

## 🌍 **Real-World Applications**
1. **Binomial Theorem** - Pascal’s Triangle is used in polynomial expansions.  
2. **Combinatorics & Probability** - Helps in counting problems.  
3. **Computer Graphics** - Used in **Bezier curves**.  
4. **Data Structures** - Used in **dynamic programming** problems.  

---

## 🎯 **Key Takeaways**
✔ Pascal’s Triangle follows the **binomial coefficient pattern**.  
✔ We use the **previous row values** to compute the next row efficiently.  
✔ **Time complexity:** O(n²), **Space complexity:** O(n²).  
✔ Useful in **mathematics, probability, and computer science**! 🚀  

---

## 📌 **Conclusion**
This approach provides an **efficient way to generate Pascal’s Triangle** while avoiding factorial computations. It is **fast, memory-efficient, and practical** for large values of `n`. 🔥  

---
