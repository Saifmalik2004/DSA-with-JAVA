

# 📌 **Printing a Specific Row of Pascal’s Triangle**  

## 🔍 **Problem Statement**  
Given an integer `n`, print the **n-th row** of Pascal’s Triangle.  

📌 **Pascal’s Triangle Properties:**  
- The **first element** of every row is `1`.  
- The **last element** of every row is `1`.  
- Each element is computed from the previous row’s values.  
- The `i-th` element of a row can be found using:  

\[
C(n, k) = \frac{C(n, k-1) \times (n-k+1)}{k}
\]

---

## 📥 **Example Input & Output**  
#### ✅ Example 1:
**Input:**  
```java
int n = 5;
List<Integer> ans = printRow(n);
```
**Output:**  
```
1 4 6 4 1
```

🔹 **Explanation:**  
The **5th row** of Pascal’s Triangle is:  
```
1 4 6 4 1
```
Each value is computed from the previous row.

---

## 🏆 **Optimized Approach: Compute Row Using Previous Row**  
Instead of computing factorials, we use:  

\[
C(n, k) = \frac{C(n, k-1) \times (n-k+1)}{k}
\]

This allows **efficient computation** without extra space.

---

## 💡 **Code Implementation (With Comments)**
```java
import java.util.ArrayList;
import java.util.List;

public class Optimize {
    // Method to compute a specific row of Pascal’s Triangle
    static List<Integer> printRow(int n) {
        long ans = 1; // First element is always 1
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // Adding the first element

        // Compute remaining elements using previous values
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i); // Multiply by decreasing (n - i)
            ans = ans / i;        // Divide by increasing i
            ansRow.add((int) ans);
        }
        return ansRow;
    }

    public static void main(String[] args) {
        int n = 5; // Row number
        List<Integer> ans = printRow(n);

        // Print the n-th row
        for (Integer it : ans) {
            System.out.print(it + " ");
        }
    }
}
```

---

## 🕵️ **Dry Run (Step-by-Step Execution)**
For **n = 5**, computation goes like this:

| Step | Computation | Output So Far |
|------|-------------|--------------|
| 1 | `1` | `1` |
| 2 | `(1 * 4) / 1 = 4` | `1 4` |
| 3 | `(4 * 3) / 2 = 6` | `1 4 6` |
| 4 | `(6 * 2) / 3 = 4` | `1 4 6 4` |
| 5 | `(4 * 1) / 4 = 1` | `1 4 6 4 1` |

✅ **Final Output:**
```
1 4 6 4 1
```

---

## ⏳ **Time & Space Complexity Analysis**  

| Approach | Time Complexity | Space Complexity |
|----------|---------------|----------------|
| **Computing Row Iteratively** | O(n) | O(n) |

🔹 **Why is this efficient?**  
- Only **O(n) operations** are performed.  
- Uses **constant extra space** apart from the output list.  

---

## 📊 **Comparison Table**  
| Method | Approach | Complexity |
|--------|---------|------------|
| **Brute Force** | Compute using factorial formula | **O(n²)** |
| **Optimized** | Compute iteratively using previous row | **O(n)** |

---

## 🌍 **Real-World Applications**
1. **Combinatorics & Probability** - Pascal’s Triangle helps in counting problems.  
2. **Mathematical Expansions** - Used in **Binomial Theorem**.  
3. **Computer Science** - Used in **dynamic programming problems**.  

---

## 🎯 **Key Takeaways**
✔ Pascal’s Triangle follows the **binomial coefficient pattern**.  
✔ This approach **efficiently computes a specific row** in **O(n) time**.  
✔ Useful in **combinations, probability, and computing binomial coefficients**! 🚀  

---

## 📌 **Conclusion**
This method provides an **optimal way to compute a specific row of Pascal’s Triangle** while avoiding factorial calculations. It is **fast, memory-efficient, and practical** for large values of `n`. 🔥  

---

🚀