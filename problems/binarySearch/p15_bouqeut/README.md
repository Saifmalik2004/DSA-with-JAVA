# 🌸 Minimum Days to Make M Bouquets

## 🧾 Problem Statement

You're given an array `bloomDay[]` of length `n`, where `bloomDay[i]` represents the **day on which the `i-th` flower blooms**. You are also given two integers:

* `m` = number of bouquets you need
* `k` = number of **adjacent flowers** needed for **one bouquet**

Your task is to determine the **minimum number of days** required to make `m` bouquets, **using only flowers that have bloomed on or before that day**.

> ⚠️ Important: A flower can only be used once, and flowers must be adjacent to be part of the same bouquet.

---

## 📥 Input

```bash
int[] bloomDay = {1, 2, 1, 2, 7, 2, 2, 3, 1}
int m = 2         # Bouquets needed
int k = 3         # Flowers per bouquet
```

---

## 📤 Output

```
Minimum number of days required = 3
```

---

## ❓ Example Walkthrough

### Explanation for Input:

```bash
bloomDay = [1, 2, 1, 2, 7, 2, 2, 3, 1]
m = 2
k = 3
```

* We need 2 bouquets, each made of 3 **adjacent** bloomed flowers.
* Try Day = 3:

  * Blooms by day 3 → \[1, 2, 1, 2, X, 2, 2, 3, 1] = ✔️(bloomed), ❌(not bloomed if > 3)
  * We can group: \[1,2,1], and \[2,2,3] → ✅ 2 bouquets possible
* So, 3 is the **minimum day** when 2 bouquets of size 3 can be made.

---

## 💡 Intuition and Approach

This is a **Binary Search on Answer** problem.

### Step-by-step Thought Process:

1. **Observation**: If we can make `m` bouquets by day `d`, then we can also make them for any day `> d`.
2. Therefore, the solution space is **monotonic** — perfect for binary search.
3. Define a helper `possible(day)` which checks if we can form `m` bouquets using only flowers that have bloomed by `day`.
4. Binary search on `day` from `min(bloomDay)` to `max(bloomDay)` and try to find the minimum possible `day` such that `possible(day)` is `true`.

---

## 🔢 Pseudocode

```text
function minDayBloom(arr, m, k):
    if m * k > len(arr): return -1

    low = min(arr)
    high = max(arr)

    while low <= high:
        mid = (low + high) / 2
        if possible(arr, mid, m, k):
            high = mid - 1
        else:
            low = mid + 1

    return low
```

```text
function possible(arr, day, m, k):
    count = 0
    bouquets = 0

    for each flower in arr:
        if flower <= day:
            count += 1
            if count == k:
                bouquets += 1
                count = 0
        else:
            count = 0

    return bouquets >= m
```

---

## ✅ Code Explanation (Java)

```java
public static int minDayBloom(int[] arr, int m, int k) {
    // Edge case: not enough flowers even if all bloom
    if ((long) m * k > arr.length) return -1;

    // Find the min and max bloom days
    int min = arr[0], max = arr[0];
    for (int num : arr) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }

    int low = min, high = max;
    while (low <= high) {
        int mid = low + (high - low) / 2;

        // Can we make required bouquets by day = mid?
        if (possible(arr, mid, m, k)) {
            high = mid - 1;  // Try smaller day
        } else {
            low = mid + 1;   // Increase the day
        }
    }
    return low;
}
```

### Helper Function:

```java
public static boolean possible(int[] days, int day, int m, int flower) {
    int count = 0, bouquets = 0;

    for (int bloom : days) {
        if (bloom <= day) {
            count++;
            if (count == flower) {
                bouquets++;
                count = 0;
                if (bouquets == m) return true;
            }
        } else {
            count = 0; // Reset if flower hasn't bloomed
        }
    }

    return bouquets >= m;
}
```

---

## ⏱️ Time & Space Complexity

### ⌛ Time Complexity:

* Binary search: `O(log(max - min))`
* Each check (`possible()`): `O(n)`

**Total:**
`O(n * log(max bloom - min bloom))`

### 🗂️ Space Complexity:

* `O(1)` extra space — no extra arrays used.

---

## 📌 Key Takeaways

* Use **binary search on the answer** when the result space is monotonic.
* Use helper function to validate feasibility for a given mid-point.
* This problem is similar to **"Minimum Speed to Eat Bananas"** or **"Capacity to Ship Packages"** — classic Binary Search patterns.

---
