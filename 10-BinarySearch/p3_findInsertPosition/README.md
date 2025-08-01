
# 🧠 Problem — Search Insert Position

---

## 📋 Problem Statement

Given a **sorted array of integers** and a **target value**, find the index if the target is found in the array.  
If not, return the index where it **would be inserted** in order.

---

## 💡 Example

| Input | Output | Explanation |
|-------|--------|-------------|
| `arr = [1, 2, 3], target = 2` | `1` | `2` is found at index `1` |
| `arr = [1, 3, 5, 6], target = 2` | `1` | `2` would fit at index `1` to stay sorted |
| `arr = [1, 3, 5, 6], target = 7` | `4` | `7` is bigger than all elements, so insert at the end |

---

## 💭 Intuition

Since the array is already sorted, the best way to search is not by checking each element one by one (**O(n)**), but using **Binary Search**.  
Binary Search can eliminate half of the remaining elements at each step — so it will be much faster.

---

## 🔍 Approach (Step-by-Step)

1. **Initialize Pointers**  
   - `low = 0` (start of array)  
   - `high = arr.length - 1` (end of array)  
   - `ans = arr.length` (default: if target is larger than all values)

2. **Perform Binary Search**  
   - Find the `mid` index.
   - If `arr[mid] == target`:  
        → Return `mid` (target found).
   - If `arr[mid] > target`:  
        → Update `ans = mid` (possible insertion point).  
        → Move `high = mid - 1` (search left half).
   - If `arr[mid] < target`:  
        → Move `low = mid + 1` (search right half).

3. **Return `ans`**  
   - If the loop finishes, `ans` contains the correct insert position.

---

## ⚙️ Algorithm (Pseudo Code)

```
function findInsertPos(arr, target):
    low = 0
    high = length of arr - 1
    ans = length of arr

    while low <= high:
        mid = low + (high - low) / 2
        
        if arr[mid] == target:
            return mid
        else if arr[mid] > target:
            ans = mid
            high = mid - 1
        else:
            low = mid + 1

    return ans
```

---

## 💻 Code Explanation Walkthrough

```java
int low = 0;
int high = arr.length - 1;
int ans = arr.length;

while (low <= high) {
    int mid = low + (high - low) / 2;  // Midpoint to avoid integer overflow

    if (arr[mid] == target) {
        return mid;  // Exact match found
    }
    else if (arr[mid] > target) {
        ans = mid;      // Potential insert position
        high = mid - 1; // Search the left side
    }
    else {
        low = mid + 1;  // Search the right side
    }
}

return ans;  // Final insert position
```

---

## ⏰ Time Complexity Analysis

| Case         | Complexity |
|--------------|------------|
| Best Case    | `O(1)` — target found at mid in first step. |
| Average Case | `O(log n)` — binary search halves the array each step. |
| Worst Case   | `O(log n)` — target not present, search exhausts all options. |

---

## 💾 Space Complexity Analysis

| Case         | Complexity |
|--------------|------------|
| All cases    | `O(1)` — only a few extra variables are used (constant space). |

---

## 🌟 Key Features

- 🔥 Uses efficient **Binary Search** instead of linear search.
- 💡 Smart fallback with `ans` to record insert positions even if the target isn’t found.
- ⚡️ Constant space & logarithmic time complexity.
- 🧠 Classic example of using **search space reduction** technique.

---

## 🧙‍♂️ Pro Tips

- For any sorted array questions, think **binary search** first!
- Don’t forget to handle the edge cases:
  - When `target` is smaller than all elements.
  - When `target` is larger than all elements.
- Use `low + (high - low) / 2` instead of `(low + high) / 2` to avoid integer overflow.

---

## ✅ Conclusion

This problem is a great example of applying **binary search logic** for both searching and determining the insertion position. It shows how a single smart loop can handle multiple outcomes, including returning the exact index or suggesting where the element should go if not found!

