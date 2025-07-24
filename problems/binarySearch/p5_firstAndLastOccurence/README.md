

# 🎯 Problem: First and Last Occurrence in a Sorted Array

---

## 🧠 Problem Statement:

Given a **sorted array** of integers and a `target` element, find the **first and last position** of the target.

If the target is not found in the array, return `[-1, -1]`.

---

## 💡 Example:

| Input Array | Target | Output |
|-------------|--------|--------|
| `[1,1,1,2,2,3,4,4,4]` | `1` | `[0, 2]` |
| `[1,1,1,2,2,3,4,4,4]` | `4` | `[6, 8]` |
| `[1,1,1,2,2,3,4,4,4]` | `5` | `[-1, -1]` |

---

## 💭 Intuition:

Because the array is sorted, **Binary Search** is the perfect fit!  
But normal binary search stops on the first found element. Hume first aur last position dhoondhni hai.  

So, we’ll slightly **modify binary search**:
- One for **First Occurrence** (left-most).
- One for **Last Occurrence** (right-most).

---

## 🪓 Approach: Step-by-Step Breakdown

1. Initialize two variables `low = 0` and `high = n-1`.
2. Perform **two separate binary searches**:
   - One to find the **first occurrence**.
   - Another to find the **last occurrence**.
3. For first occurrence:
   - If `arr[mid]` matches target, store index in `ans[0]` but continue searching **left**.
4. For last occurrence:
   - If `arr[mid]` matches target, store index in `ans[1]` but continue searching **right**.
5. If not found, default answer `[-1, -1]` will remain.

---

## 🔥 Algorithm (Pseudo Code)

```
function searchFirstAndLast(arr, target):
    ans = [-1, -1]
    
    // Find First Occurrence
    low = 0
    high = arr.length - 1
    while low <= high:
        mid = low + (high - low) // 2
        if arr[mid] < target:
            low = mid + 1
        else:
            if arr[mid] == target:
                ans[0] = mid
            high = mid - 1

    // Find Last Occurrence
    low = 0
    high = arr.length - 1
    while low <= high:
        mid = low + (high - low) // 2
        if arr[mid] > target:
            high = mid - 1
        else:
            if arr[mid] == target:
                ans[1] = mid
            low = mid + 1

    return ans
```

---

## 💻 Code Walkthrough (Java)

```java
public static int[] searchFirstAndLast(int arr[], int x) {

    int n = arr.length;
    int ans[] = {-1, -1};

    int low = 0, high = n - 1;

    // Find first occurrence
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] < x) {
            low = mid + 1;
        } else {
            if (arr[mid] == x) ans[0] = mid;
            high = mid - 1;
        }
    }

    low = 0;
    high = n - 1;

    // Find last occurrence
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] > x) {
            high = mid - 1;
        } else {
            if (arr[mid] == x) ans[1] = mid;
            low = mid + 1;
        }
    }

    return ans;
}
```

---

## ⏲️ Time Complexity:

| Operation | Complexity |
|-----------|------------|
| First Occurrence | `O(log N)` |
| Last Occurrence  | `O(log N)` |
| **Total**        | `O(log N)` |

---

## 💾 Space Complexity:

| Usage        | Complexity |
|--------------|------------|
| Variables (`low, high, mid, ans[]`) | `O(1)` (Constant Space) |

---

## ⭐ Key Features:

- Uses **Modified Binary Search** to get accurate first and last indices.
- Runs in `O(log N)` time — highly efficient for large sorted arrays.
- Clean logic, easy to debug.
- Zero extra memory — constant space.

---

## 💡 Some Tips:

- Use `low + (high - low) / 2` instead of `(low + high) / 2` to avoid **Integer Overflow**.
- Always test edge cases:
   - Empty array.
   - Target not present.
   - Target appears once.
   - Target appears multiple times at start or end.

---

## 🏁 Conclusion:

This problem teaches:
- Smart use of **binary search**.
- Importance of modifying search conditions to handle real-world patterns (like duplicates).
- Clean code + efficient time & space complexity is always the best combo!

---

