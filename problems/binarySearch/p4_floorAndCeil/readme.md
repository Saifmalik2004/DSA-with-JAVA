

# 🧠 Problem — Find **Floor** and **Ceil** of a Number in a Sorted Array

---

## 📋 Problem Statement

Given a **sorted array of integers** and a **target value**, your task is to find:

- 🧾 **Floor:** Largest element in the array **less than or equal** to the target.
- 🧾 **Ceil:** Smallest element in the array **greater than or equal** to the target.

If the **Ceil** or **Floor** does not exist, return `-1`.

---

## 💡 Example

| Array            | Target | Floor | Ceil |
|------------------|--------|-------|------|
| `[1, 3, 4, 5]`   | `2`    | `1`   | `3`  |
| `[1, 3, 4, 5]`   | `3`    | `3`   | `3`  |
| `[1, 3, 4, 5]`   | `6`    | `5`   | `-1` |
| `[1, 3, 4, 5]`   | `0`    | `-1`  | `1`  |

---

## 💭 Intuition

If the array is sorted, you can avoid a brute-force `O(n)` loop by applying **Binary Search**.

- For `Ceil`: You search for the **smallest value ≥ target**.
- For `Floor`: You search for the **largest value ≤ target**.

Both can be solved with the same logic pattern: adjust `low` and `high` pointers smartly during search.

---

## 🔍 Approach (Step-by-Step)

### 🎯 `Ceil`

1. Initialize `low = 0`, `high = arr.length - 1`, and `ans = -1` (default if no ceil exists).
2. Loop until `low <= high`:
   - Calculate `mid = low + (high - low) / 2`.
   - If `arr[mid] >= target`:
     - Store `arr[mid]` as a potential `ans`.
     - Move `high = mid - 1` to check for a smaller valid number.
   - If `arr[mid] < target`:
     - Move `low = mid + 1` to search higher numbers.
3. Return `ans`.

---

### 🎯 `Floor`

1. Initialize `low = 0`, `high = arr.length - 1`, and `ans = -1`.
2. Loop until `low <= high`:
   - Calculate `mid = low + (high - low) / 2`.
   - If `arr[mid] <= target`:
     - Store `arr[mid]` as a potential `ans`.
     - Move `low = mid + 1` to search for a larger valid number.
   - If `arr[mid] > target`:
     - Move `high = mid - 1` to search for a smaller number.
3. Return `ans`.

---

## ⚙️ Algorithm (Pseudo Code)

```text
function ceil(arr, target):
    low = 0, high = length(arr) - 1
    ans = -1
    while low <= high:
        mid = low + (high - low) / 2
        if arr[mid] >= target:
            ans = arr[mid]
            high = mid - 1
        else:
            low = mid + 1
    return ans

function floor(arr, target):
    low = 0, high = length(arr) - 1
    ans = -1
    while low <= high:
        mid = low + (high - low) / 2
        if arr[mid] <= target:
            ans = arr[mid]
            low = mid + 1
        else:
            high = mid - 1
    return ans
```

---

## 💻 Code Walkthrough

```java
if(arr[mid] >= target) {
    ans = arr[mid];     // Candidate for ceil
    high = mid - 1;     // Try to find even smaller valid number
} else {
    low = mid + 1;      // Move to right half
}
```

```java
if(arr[mid] <= target) {
    ans = arr[mid];     // Candidate for floor
    low = mid + 1;      // Try to find even larger valid number
} else {
    high = mid - 1;     // Move to left half
}
```

## 💡 Full Java Code

```java
public class Solution {

    public static int ceil(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];  // Potential ceil found
                high = mid - 1;  // Look for smaller valid number
            } else {
                low = mid + 1;   // Move to higher values
            }
        }
        return ans;
    }

    public static int floor(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target) {
                ans = arr[mid];  // Potential floor found
                low = mid + 1;   // Look for larger valid number
            } else {
                high = mid - 1;  // Move to lower values
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5};

        System.out.println("Floor of 2: " + floor(arr, 2));
        System.out.println("Ceil of 2: " + ceil(arr, 2));
    }
}
```


---

## ⏰ Time Complexity Analysis

| Scenario       | Complexity |
|----------------|------------|
| All Cases      | `O(log n)` — Binary Search halves the search space each time. |

---

## 💾 Space Complexity Analysis

| Scenario       | Complexity |
|----------------|------------|
| All Cases      | `O(1)` — Constant space, no extra arrays. |

---

## 🌟 Key Features

- Uses **Binary Search** for both Floor & Ceil.
- Constant space & fast `log n` time.
- Handles sorted arrays efficiently.
- Simple conditions to switch between `Floor` and `Ceil`.

---

## 🧙‍♂️ Pro Tips

- `Ceil` → Think: "Find the smallest number that is ≥ target."
- `Floor` → Think: "Find the largest number that is ≤ target."
- Works only on **sorted arrays** — if not sorted, sort first.
- Always handle edge cases (`target` smaller than all or larger than all).

---

## ✅ Conclusion

This problem is a classic interview question that tests your grasp of **binary search variations**. Learning how to tweak `low`, `high`, and `ans` helps you solve many real-world search problems in `O(log n)`.

---
