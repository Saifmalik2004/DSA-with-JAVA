
## ✅ Problem Statement

**Count the number of occurrences of a given target in a sorted array.**

### 🔹 Input:

* A sorted array of integers `arr[]`
* An integer `target` to search

### 🔹 Output:

* Total number of times `target` appears in the array.

---

## 🧠 Intuition

Since the array is **sorted**, we can use **Binary Search** to quickly find the:

1. **First occurrence** of the target
2. **Last occurrence** of the target

Once we have both indices:

```
Count = (Last Index - First Index + 1)
```

---

## 🔍 Approach – Step by Step

### ✅ Step 1: Find First Occurrence of Target

Use binary search:

* If `arr[mid] < target`, move to the right half
* If `arr[mid] >= target`, move to the left half
* If `arr[mid] == target`, store index and continue searching on the left (to find first occurrence)

### ✅ Step 2: If first occurrence is not found

* Return `0` immediately because target doesn't exist

### ✅ Step 3: Find Last Occurrence of Target

Use binary search again:

* If `arr[mid] > target`, move to the left half
* If `arr[mid] <= target`, move to the right half
* If `arr[mid] == target`, store index and continue searching on the right (to find last occurrence)

### ✅ Step 4: Calculate and return count

If target found:

```java
count = lastIndex - firstIndex + 1
```

---

## 📄 Pseudo Code

```
function countOccurrences(array, target):
    firstIndex = binarySearchFirst(array, target)
    if firstIndex == -1:
        return 0

    lastIndex = binarySearchLast(array, target)
    return lastIndex - firstIndex + 1
```

---

## 💻 Full Java Code

```java
public class Solution {

    public static int count(int nums[], int n, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans1 = -1;

        // First Occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (nums[mid] == target) {
                    ans1 = mid;
                }
                high = mid - 1;
            }
        }

        if (ans1 < 0) return 0;

        // Last Occurrence
        low = 0;
        high = nums.length - 1;
        int ans2 = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (nums[mid] == target) {
                    ans2 = mid;
                }
                low = mid + 1;
            }
        }

        return (ans2 - ans1) == 0 ? 0 : (ans2 - ans1 + 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 4, 4, 4};

        System.out.println(count(arr, arr.length, 4));  // Output: 3
    }
}
```

---

## ⏱️ Time & Space Complexity

### 🕒 Time Complexity:

* **O(log n)** for first occurrence
* **O(log n)** for last occurrence
  ➡️ **Total: O(log n)**

### 📦 Space Complexity:

* **O(1)** (No extra space used)

---

## 📌 Test Cases

| Input array        | Target | Output |
| ------------------ | ------ | ------ |
| \[1,1,2,2,3,4,4,4] | 4      | 3      |
| \[1,1,2,2,3,4,4,4] | 2      | 2      |
| \[1,1,2,2,3,4,4,4] | 5      | 0      |
| \[1,1,1,1,1]       | 1      | 5      |
| \[]                | 1      | 0      |

---

## ✅ Summary

* Efficient approach using binary search
* Only works on **sorted arrays**
* You get first and last index using binary search
* Final count = `last - first + 1`
