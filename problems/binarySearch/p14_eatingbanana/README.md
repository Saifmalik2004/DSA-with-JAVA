# 🍌 Koko Eating Bananas

## 📌 Problem Statement
Koko loves to eat bananas. There are `n` piles of bananas, where the `i`-th pile has `piles[i]` bananas. The guards allow Koko to eat at most **one pile per hour**.

Koko can eat bananas at some speed `k` (bananas per hour). If she chooses to eat `k` bananas from a pile, but the pile has fewer than `k` bananas, she will finish the pile in one hour.

Return the **minimum** integer value of `k` such that Koko can eat all the bananas within `h` hours.

---

## 🔹 Example
### **Input:**
```text
piles = [3, 6, 7, 11]
h = 8
```
### **Output:**
```text
4
```

### **Explanation:**
- If Koko eats at speed `4`, the required hours to finish all piles:
  - `3 / 4` → **1 hour**
  - `6 / 4` → **2 hours**
  - `7 / 4` → **2 hours**
  - `11 / 4` → **3 hours**
  - **Total = 8 hours** (valid solution)
- Any speed lower than `4` would take more than 8 hours.

---
## 🎡 Intuition
If Koko eats too slowly, she won't finish within `h` hours. If she eats too quickly, she might be eating faster than necessary. The optimal way to find the **minimum valid speed** is to check different values of `k` efficiently. Instead of checking every possible speed from `1` to `max(piles)`, we can use **binary search** to **narrow down** the correct answer much faster.

---
## 🛠️ Approach (Binary Search)
We use **binary search** to efficiently find the minimum possible speed `k`:

### **Step-by-Step Breakdown**
1. **Find the range of `k`**
   - The minimum speed must be at least `1` (eating 1 banana per hour).
   - The maximum speed can be the largest pile size (worst case: eating an entire pile per hour).
   
2. **Binary Search on `k` (Speed):**
   - Set `low = 1`, `high = max(piles)`.
   - Find the middle speed `mid = (low + high) / 2`.
   - Check if Koko can finish eating within `h` hours using `mid` as the speed.
   - If **possible**, try a smaller speed (`high = mid - 1`).
   - If **not possible**, increase speed (`low = mid + 1`).
   
3. **Final Result:**
   - The lowest valid speed (`low`) is the answer.

---

## 📝 Algorithm (Pseudocode)
```plaintext
1. Find max value in piles (maxBananas)
2. Set low = 1, high = maxBananas
3. While low <= high:
     a. mid = (low + high) / 2
     b. Compute total hours needed at speed `mid`
     c. If totalHours <= h:
           high = mid - 1 (try lower speed)
        Else:
           low = mid + 1 (increase speed)
4. Return low (minimum valid speed)
```

---

## 💻 Code Walkthrough
### **Implementation in Java**
```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        int low = 1, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (computeTime(piles, h, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean computeTime(int[] arr, int h, int num) {
        long total = 0;
        for (int pile : arr) {
            total += (pile + num - 1) / num; // Efficient ceil division
            if (total > h) return false;
        }
        return total <= h;
    }
}
```

### **Code Explanation**
1. **Finding max pile** → Determines the upper limit for speed.
2. **Binary search for speed `k`** → Reduces search space efficiently.
3. **computeTime function**:
   - Uses `(pile + num - 1) / num` to calculate the required hours.
   - Uses early exit if `total > h` to optimize performance.

---

## ⏳ Time & Space Complexity Analysis
| Operation       | Complexity |
|----------------|------------|
| Finding max    | `O(n)` |
| Binary search  | `O(log M)` (M = max pile value) |
| Compute hours  | `O(n log M)` |
| **Overall**    | **`O(n log M)`** |

✅ **Space Complexity:** `O(1)` (constant extra space)

---

## ⭐ Key Features
- **Binary Search Optimization**: Instead of checking all speeds, we efficiently find the answer in `log` time.
- **Mathematical Trick**: Uses `(pile + num - 1) / num` to avoid floating-point division.
- **Early Exit Optimization**: Stops checking further when hours exceed `h`.

---

## 🔥 Pro Tips
- If `h == piles.length`, the answer is `max(piles)`, since Koko eats one pile per hour.
- If `h >= sum(piles)`, then the minimum speed is `1`.
- The **minimum speed is always between `1` and `max(piles)`**, so binary search works effectively.

---

## 🎯 Conclusion
This problem is efficiently solved using **binary search on speed** instead of brute force. By optimizing the search space and using integer division tricks, we achieve a time complexity of `O(n log M)`, making it feasible for large inputs.

---

**🚀 Happy Coding!** 👩‍💻👨‍💻

