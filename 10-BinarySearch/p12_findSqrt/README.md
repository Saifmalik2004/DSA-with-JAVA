
# 📌 Problem: Find the Floor of Square Root (Using Binary Search)

---

## 💡 Problem Statement

Given a **non-negative integer `x`**, your task is to compute and return the **floor of its square root**.  
The floor value means:  
If `√x` is a decimal, return the largest integer `<= √x`.

---

## 🔥 Example:

| Input    | Output | Explanation               |
|----------|--------|---------------------------|
| `x = 16` | `4`    | √16 = 4, exact match.      |
| `x = 27` | `5`    | √27 ≈ 5.19 → floor = 5.     |
| `x = 100`| `10`   | √100 = 10, perfect square. |
| `x = 2`  | `1`    | √2 ≈ 1.41 → floor = 1.      |

---

## 🧠 Intuition

A square root of a number always lies between `1` and `x/2` (for any `x >= 4`).  
Why check every number one by one?  
**Binary Search** can minimize the number of guesses by half at every step — just like when you look for a name in a dictionary!

---

## 🚀 Approach: Step-By-Step

1. **Initialize Search Boundaries:**
   - `low = 1`
   - `high = x / 2` (because square root of `x` can't be more than `x/2` if `x >= 4`).

2. **Binary Search Loop:**
   - While `low` is less than or equal to `high`:
     - Calculate `mid` safely: `mid = low + (high - low) / 2`.
     - If `mid * mid <= x`:  
       Move `low` to `mid + 1` (look for a larger candidate).
     - Else:  
       Move `high` to `mid - 1` (current mid is too big).

3. **Result:**
   - After the loop, `high` will contain the floor value of the square root.

---

## 💻 Pseudocode

```
function sqRoot(x):
    low = 1
    high = x / 2

    while low <= high:
        mid = low + (high - low) / 2
        
        if mid * mid <= x:
            low = mid + 1
        else:
            high = mid - 1

    return high
```

---

## 💡 Code Explanation Walkthrough

- **Initial Boundaries:**  
  Start from `1` to `x/2` instead of `1` to `x`.  
  (Optimization: square root can't be more than `x/2`.)

- **Why Binary Search?**  
  Because the sequence of `mid*mid` compared to `x` is monotonic:
  - If `mid*mid < x`, go right.
  - If `mid*mid > x`, go left.
  - Loop exits when the closest floor is found.

- **Why Return `high`?**  
  `high` will hold the last possible value where `mid * mid <= x` was true, making it the correct floor square root.

---

## ⏱️ Time Complexity Analysis

| Case         | Complexity      |
|--------------|-----------------|
| Best Case    | `O(1)`          |
| Average Case | `O(log₂ N)`     |
| Worst Case   | `O(log₂ N)`     |

---

## 💾 Space Complexity Analysis

| Resource     | Complexity      |
|--------------|-----------------|
| Extra Space  | `O(1)`          |

---

## 🌟 Key Features

- ✅ Uses **Binary Search** for optimal speed.
- ✅ Handles large numbers without overflow.
- ✅ Works even if the input is not a perfect square.
- ✅ Clean, easy-to-understand logic.

---

## 💡 Pro Tips

- If the input is **0 or 1**, directly return the input — its square root is the same.
- Always calculate `mid` like:  
  ```java
  mid = low + (high - low) / 2;
  ```
  to avoid integer overflow.

- This logic is useful in many real-world problems, like:
  - Calculating efficient limits,
  - Optimization bounds,
  - Physics simulations (collision detection).

---

## ✅ Conclusion

This problem is a great example of how **Binary Search** can convert a linear search problem into a log-time optimized solution.  
The logic is simple but powerful — always divide & conquer rather than brute-force! 

---
