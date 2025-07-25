# 📝 Problem: Single Element in a Sorted Array

## 📌 Problem Statement
You are given a **sorted array** consisting of `2N + 1` integers where **every element appears exactly twice**, except for **one unique element** that appears only once.

Find and return the single non-duplicate element.

👉 The solution must run in **O(log n)** time complexity.

## 🔍 Example

### Example 1:
**Input:**
```plaintext
nums = [1, 1, 2, 2, 3, 3, 4, 8, 8]
```
**Output:**
```plaintext
4
```
**Explanation:** The element `4` appears only once.

### Example 2:
**Input:**
```plaintext
nums = [3, 3, 7, 7, 10, 11, 11]
```
**Output:**
```plaintext
10
```

---
## 💡 Intuition
Since the array is **sorted**, pairs of elements appear side by side. However, one element **breaks this pattern** by appearing only once.

- **Observing the index patterns:**
  - Before the unique element: elements appear in pairs (`even index` matches `odd index`)
  - After the unique element: the pattern **shifts** (`odd index` matches `even index`)

- We can use **Binary Search (O(log n))** instead of **Linear Search (O(n))** to efficiently locate the single element.

---
## 🏗 Approach: Binary Search

### **Step 1: Handle Edge Cases**
- If there's only **one element**, return it.
- If the **first element** is unique, return `nums[0]`.
- If the **last element** is unique, return `nums[n-1]`.

### **Step 2: Binary Search**
1. **Initialize pointers:**
   - `low = 1` (start from index `1` to prevent out-of-bounds access)
   - `high = n-2` (end at `n-2` to avoid unnecessary checks)

2. **Mid Calculation:**
   - Compute `mid = low + (high - low) / 2`

3. **Check if `nums[mid]` is the unique element:**
   - If `nums[mid]` is different from both `nums[mid-1]` and `nums[mid+1]`, return `nums[mid]`.

4. **Adjust Search Space:**
   - If `mid` follows the **normal pair pattern**, move `low = mid + 1`.
   - Otherwise, move `high = mid - 1`.

5. **Continue until the element is found.**

---
## 🔢 Algorithm (Pseudocode)
```plaintext
function singleNonDuplicate(nums):
    n = length of nums
    if n == 1:
        return nums[0]
    if nums[0] != nums[1]:
        return nums[0]
    if nums[n-1] != nums[n-2]:
        return nums[n-1]

    low = 1, high = n - 2
    while low <= high:
        mid = low + (high - low) / 2
        if nums[mid] != nums[mid-1] and nums[mid] != nums[mid+1]:
            return nums[mid]
        if (mid is even and nums[mid] == nums[mid+1]) or (mid is odd and nums[mid] == nums[mid-1]):
            low = mid + 1
        else:
            high = mid - 1
    return -1  # Should never reach here
```

---
## 🖥 Code Walkthrough
```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = n - 2;

        // Edge cases
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // If mid is the unique element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            
            // Determine which half to search next
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;  // Should never be reached
    }
}
```

---
## ⏳ Complexity Analysis
- **Time Complexity:** `O(log n)`
  - We reduce the search space by half in each step using binary search.
- **Space Complexity:** `O(1)`
  - Only a few extra variables are used, so constant space is required.

---
## 🌟 Key Features
✅ **Binary Search Optimization:** Reduces time complexity from `O(n)` to `O(log n)`
✅ **Handles Edge Cases:** Works for single-element arrays and unique element at start/end
✅ **No Extra Space Used:** Works in-place without modifying the input array

---
## 🔥 Pro Tips
- **Why start `low` from `1` instead of `0`?**
  - Prevents unnecessary checks for the first element (already handled as an edge case)
- **Why end `high` at `n-2` instead of `n-1`?**
  - The last element is already checked in edge cases, so we don't need to go beyond `n-2`.
- **How to debug binary search issues?**
  - Always verify the **`mid` index calculations** and the conditions for moving `low` or `high`.

---
## 🏁 Conclusion
We efficiently find the single non-duplicate element in a sorted array using **Binary Search** in `O(log n)` time. This approach is **optimal** compared to a brute force solution (`O(n)`). Understanding how the **index pattern shifts** before and after the unique element helps in applying **binary search** effectively! 🚀