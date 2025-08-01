
# 📘 Nth Root of a Number — Binary Search Approach

---

## 💡 Problem

**Given:** Two positive integers `n` and `m`.  
**Task:** Find an integer `x` such that:

```
x^n = m
```

If such an integer exists, return `x`. If it does not exist, return `-1`.

---

## 💡 Problem Statement

You are given two integers `n` (root) and `m` (target number). Your goal is to determine if there is an integer `x` such that raising `x` to the power `n` gives exactly `m`. If no such `x` exists, return `-1`.

---

## 🧠 Example

| Input (`n`, `m`)  | Output | Reason                     |
|-------------------|--------|-----------------------------|
| `n = 9, m = 1953125` | `5`    | `5^9 = 1953125`            |
| `n = 3, m = 27`      | `3`    | `3^3 = 27`                 |
| `n = 2, m = 16`      | `4`    | `4^2 = 16`                 |
| `n = 3, m = 28`      | `-1`   | No integer root satisfies `x^3 = 28` |

---

## 💡 Intuition

When solving `x^n = m`, brute-force is too slow for large values, especially when `m` can be huge.

The key insight is that `x` will always lie between `1` and `m`. Since this is a sorted range, **Binary Search** is the perfect fit.

For every middle candidate `mid`, compute:

- If `mid^n == m`: You found the exact root.
- If `mid^n < m`: The answer must be on the right side.
- If `mid^n > m`: The answer must be on the left side.

This eliminates half of the search space in each step, providing excellent performance.

---

## ⚡️ Approach

1. **Binary Search** to find the correct `x`.
2. Use a **helper function** to compute `mid^n` efficiently while avoiding integer overflow.
3. Adjust search space (`low` and `high`) based on comparison.
4. If `x` is found, return it. Otherwise, return `-1`.

---

## 💡 Pseudocode

```
function checkNthPower(n, mid, m):
    result = 1
    base = mid

    while n > 0:
        if result > m:
            return 2
        if n is odd:
            result = result * base
            if result > m:
                return 2
            n = n - 1
        else:
            base = base * base
            if base > m:
                return 2
            n = n / 2

    if result == m:
        return 1
    else:
        return 0


function findNthRoot(n, m):
    low = 1
    high = m

    while low <= high:
        mid = low + (high - low) / 2
        status = checkNthPower(n, mid, m)

        if status == 1:
            return mid
        else if status == 0:
            low = mid + 1
        else:
            high = mid - 1

    return -1
```


---

### 💡 JAVA Full code:

```java
public class Optimize {

    public static void main(String[] args) {
        System.out.println(nr(9, 1953125)); // Output: 5 (Because 5^9 = 1953125)
    }

    // Helper function to check if mid^n == m
    public static int checkNthPower(int n, int mid, int m) {
        long result = 1;
        long base = mid;

        while (n > 0) {
            if (result > m) return 2;  // Early break: result is too big!

            if (n % 2 == 1) {
                result *= base;
                if (result > m) return 2;  // Check again after multiplication
                n--;
            } else {
                base *= base;
                if (base > m) return 2;  // Avoid overflow
                n /= 2;
            }
        }

        if (result == m) return 1;  // Exact match
        else return 0;             // Less than m
    }

    // Binary search to find the nth root of m
    public static int nr(int n, int m) {

        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int status = checkNthPower(n, mid, m);

            switch (status) {
                case 1 -> {
                    return mid;  // Found the exact root
                }
                case 0 -> {
                    low = mid + 1;  // Go right
                }
                case 2 -> {
                    high = mid - 1; // Go left
                }
            }
        }

        return -1;  // No integer root found
    }
}
```

---


## 💡 Code Walkthrough

- `checkNthPower()` function computes `mid^n` safely and efficiently.
- If the result exceeds `m`, it stops early for performance.
- The `nr()` function applies classic binary search:
   - If `mid^n == m`, return `mid`.
   - If too small, move right (`low = mid + 1`).
   - If too big, move left (`high = mid - 1`).

---

## ⏱️ Time Complexity

| Case               | Complexity               |
|---------------------|---------------------------|
| Binary Search Loop  | `O(log m)`                |
| Exponentiation Check | `O(log n)` (using fast power logic) |

**Total Complexity:** `O(log m * log n)`

---

## 💾 Space Complexity

| Resource           | Complexity |
|--------------------|------------|
| Auxiliary Space    | `O(1)`     |

---

## ✨ Key Features

- Combines **Binary Search** and **Optimized Exponentiation**.
- Overflow-safe checks.
- Early termination for better performance.
- Handles very large numbers efficiently.

---

## 💡 Tips

- Whenever the problem involves "find a number that satisfies a condition in a sorted range" — Binary Search is usually the best tool.
- Be careful with multiplication; always consider overflow in real-world implementations.
- Helper functions make code cleaner and easier to maintain.

---

## ✅ Conclusion

This is a great example of applying binary search outside the usual sorted array problems. The combination of search space reduction and fast exponentiation makes this problem both efficient and elegant.

Mastering this pattern will help you solve a wide variety of numerical computation and search problems!

