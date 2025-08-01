
# 📌 Problem — Find **Lower Bound** and **Upper Bound** in a Sorted Array

---

## 💡 Problem Statement

Given a **sorted array of integers** and a **target value**, write two functions:

- `lowerBound(arr, target)` — returns the index of the **first element greater than or equal to** the target.  
- `upperBound(arr, target)` — returns the index of the **first element strictly greater than** the target.

If no such element exists, return the size of the array (`arr.length`).

---

## 💡 Example

| Input Array           | Target | Lower Bound (Index) | Upper Bound (Index) |
|------------------------|--------|----------------------|----------------------|
| `[3, 5, 5, 5, 5, 5]`   | `4`    | `1` (element: `5`)    | `1` (element: `5`)    |
| `[3, 5, 5, 5, 5, 5]`   | `5`    | `1` (element: `5`)    | `6` (out of bounds)   |
| `[3, 5, 5, 5, 5, 5]`   | `6`    | `6`                   | `6`                   |
| `[3, 5, 5, 5, 5, 5]`   | `3`    | `0` (element: `3`)    | `1` (element: `5`)    |

---

## 🧠 Intuition

Binary Search is a great fit when dealing with sorted arrays!

- The **Lower Bound** seeks the first index where the number is **greater than or equal to the target**.
- The **Upper Bound** seeks the first index where the number is **strictly greater than the target**.

By adjusting the `low` and `high` pointers smartly inside a `while` loop, you can find both positions efficiently.

---

## 🔍 Approach — Step by Step

### 💡 Lower Bound Logic:

1. Start with `low = 0` and `high = arr.length - 1`.
2. Initialize `ans = arr.length` (safe value if the target is larger than all elements).
3. While `low <= high`:
   - Compute `mid = low + (high - low) / 2`.
   - If `arr[mid] >= target`:  
     → mark `ans = mid` (potential answer) and shift `high = mid - 1` (look left).
   - Else:  
     → shift `low = mid + 1` (look right).

---

### 💡 Upper Bound Logic:

1. Start with `low = 0` and `high = arr.length - 1`.
2. Initialize `ans = arr.length`.
3. While `low <= high`:
   - Compute `mid = low + (high - low) / 2`.
   - If `arr[mid] > target`:  
     → mark `ans = mid` and shift `high = mid - 1`.
   - Else:  
     → shift `low = mid + 1`.

---

## 🧾 Algorithm — Pseudocode

```text
function lowerBound(arr, target):
    low = 0, high = arr.length - 1
    ans = arr.length
    while low <= high:
        mid = low + (high - low) / 2
        if arr[mid] >= target:
            ans = mid
            high = mid - 1
        else:
            low = mid + 1
    return ans

function upperBound(arr, target):
    low = 0, high = arr.length - 1
    ans = arr.length
    while low <= high:
        mid = low + (high - low) / 2
        if arr[mid] > target:
            ans = mid
            high = mid - 1
        else:
            low = mid + 1
    return ans
```

---

## 🖼️ Code Walkthrough

- Both methods use **Binary Search**.
- `lowerBound`: when `arr[mid] >= target`, save `mid` and continue searching left.
- `upperBound`: when `arr[mid] > target`, save `mid` and continue searching left.
- Final `ans` holds the correct index or `arr.length` if the target isn't matched.

---

## ⏰ Time Complexity

| Scenario          | Complexity |
|-------------------|------------|
| All cases         | `O(log n)` |

---

## 💾 Space Complexity

| Scenario          | Complexity |
|-------------------|------------|
| All cases         | `O(1)`     |

---

## 🌟 Key Features

- Fast binary search approach.
- Handles repeated elements gracefully.
- Returns the **index** rather than the element.
- Easy to extend for insertion or range queries.

---

## 💡 Pro Tips

- If `lowerBound == arr.length` → target should be inserted at the end.
- `upperBound - lowerBound` gives the **frequency count** of the target in the array.
- Both are extremely useful in range-based problems and competitive programming.

---

## 🏁 Conclusion

Lower Bound and Upper Bound are **fundamental binary search variations** every developer must master. They help you handle **search, counting, and range queries** with ease in sorted arrays.

---

## 💻 Full Java Code

```java
public class Brute {

    public static int lowBound(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = mid;         // Potential lower bound
                high = mid - 1;    // Search left half
            } else {
                low = mid + 1;     // Search right half
            }
        }
        return ans;
    }

    public static int upBound(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ans = mid;         // Potential upper bound
                high = mid - 1;    // Search left half
            } else {
                low = mid + 1;     // Search right half
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 5, 5, 5, 5};
        System.out.println("Lower Bound of 4: " + lowBound(arr, 4));
        System.out.println("Upper Bound of 4: " + upBound(arr, 4));
    }
}
```

