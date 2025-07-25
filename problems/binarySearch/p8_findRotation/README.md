

# **Finding the Rotation Count in a Rotated Sorted Array**

## 📘 **Problem Statement**

Given a **sorted** array that has been **rotated** some number of times, find the **index of the smallest element**, which directly gives the **rotation count**.

---

## ✅ **Example Input & Output**

### 🔹 Example 1:

**Input:**

```plaintext
arr = [7, 8, 9, 1, 2, 3, 4, 5, 6]
```

**Output:**

```plaintext
3
```

**Explanation:**
The smallest element is `1` at index `3`, so the array has been rotated `3` times.

---

### 🔹 Example 2:

**Input:**

```plaintext
arr = [4, 5, 6, 7, 0, 1, 2, 3]
```

**Output:**

```plaintext
4
```

**Explanation:**
The smallest element is `0` at index `4`, so the array has been rotated `4` times.

---

## 🚀 **Optimized Approach (Binary Search)**

### ✅ Why Binary Search?

* The array is **sorted and rotated**, so we can use **binary search** instead of linear scan.
* Time Complexity: **O(log N)**
* Space Complexity: **O(1)**

---

## 🔍 **Key Idea**

The **minimum element** in a rotated sorted array is the only element that is **smaller than both its neighbors**.
We use this property along with binary search to find its index.

---

## 🧠 **Algorithm Steps**

1. **Initialize Pointers:**

   * `low = 0`
   * `high = arr.length - 1`

2. **While `low <= high`:**

   * If `arr[low] <= arr[high]`: The array is already sorted — return `low`.
   * Find `mid`, `next`, and `prev` using modulo to wrap around.
   * If `arr[mid] <= arr[next] && arr[mid] <= arr[prev]`: We found the **pivot**, return `mid`.
   * If **left half** is sorted → move right: `low = mid + 1`
   * Else → move left: `high = mid - 1`

---

## 💻 **Java Code**

```java
public class Optimize {

    public static int findRotation(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Case: already sorted
            if (arr[low] <= arr[high]) {
                return low;
            }

            int mid = low + (high - low) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid - 1 + arr.length) % arr.length;

            // Check if mid is the smallest
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0; // fallback (not expected if input is valid rotated sorted array)
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        System.out.println(findRotation(arr));  // Output: 3
    }
}
```

---

## 🔄 **Dry Run of Example**

**Input:**

```java
arr = [7, 8, 9, 1, 2, 3, 4, 5, 6]
```

| Iteration | low | mid | high | arr\[mid] | Action Taken       |
| --------- | --- | --- | ---- | --------- | ------------------ |
| 1         | 0   | 4   | 8    | 2         | Go Left (high = 3) |
| 2         | 0   | 1   | 3    | 8         | Go Right (low = 2) |
| 3         | 2   | 2   | 3    | 9         | Go Right (low = 3) |
| 4         | 3   | 3   | 3    | 1         | ✅ Found Minimum    |

**Output:** `3`

---

## 📈 **Time and Space Complexity**

| Case         | Time Complexity | Space Complexity |
| ------------ | --------------- | ---------------- |
| Best Case    | O(1)            | O(1)             |
| Average Case | O(log N)        | O(1)             |
| Worst Case   | O(log N)        | O(1)             |

---

## 🧩 **Edge Case Tips**

* Always use modulo `%` to wrap around for `next` and `prev`.
* If the array is **already sorted**, return `0`.
* This approach assumes **no duplicate elements**.

---

## ✅ **Conclusion**

This solution is a classic binary search optimization that efficiently finds the rotation count (pivot index) in a rotated sorted array in `O(log N)` time.
It avoids unnecessary scans and uses mathematical tricks to ensure safe index access — perfect for large-scale inputs! 💪⚡

---
