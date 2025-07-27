
# 🎯 Problem: Find Target Indices After Sorting Array

## 📄 Problem Statement

You are given a **0-indexed integer array `nums`** and a **target integer `target`**.

In one operation, you can **sort `nums` in non-decreasing order**.

Return **a list of the indices** where `target` appears in the sorted array.

### 🧠 Example

**Input:**
```

nums = \[1, 2, 5, 2, 3], target = 2

```

**After Sorting:**
```

\[1, 2, 2, 3, 5]

```

**Output:**
```

\[1, 2]

````

---

## ✅ Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
- `1 <= target <= 100`

---

## 🧩 Approach

Instead of sorting the entire array, we use **observation and counting**:

### 🔍 Logic:

1. Count how many numbers are **less than** `target`.  
   - These will come **before** the target after sorting.
   - This gives the **starting index** of target in the sorted array.

2. Count how many numbers are **equal to** `target`.  
   - These will be placed **starting from the index above**, and repeated `count` times.

3. Build a list of indices from `start` to `start + count - 1`.

This avoids sorting the array and gives **O(n)** time complexity.

---

## 🧪 Example Walkthrough

For `nums = [1, 2, 5, 2, 3]` and `target = 2`:

- Elements `< 2`: [1] → `index = 1`
- Elements `== 2`: [2, 2] → `count = 2`
- So, result indices = [1, 2]

---

## 💻 Code

```java
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        int count = 0;
        int index = 0;

        for (int num : nums) {
            if (num < target) {
                index++;
            } else if (num == target) {
                count++;
            }
        }

        if (count == 0) return list;

        for (int i = index; i < index + count; i++) {
            list.add(i);
        }

        return list;
    }
}
````

---

## ⏱️ Time & Space Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(1) (excluding result list)

---

## 📌 Key Concepts

* Observation over brute-force sorting
* Count frequency and positions
* Efficient use of loops

---

