# 🔍 Search in Rotated Sorted Array  

## 📝 Problem Statement  
You are given a **sorted array** that has been **rotated** at an unknown pivot. Your task is to find a given target element **efficiently**. If the target exists, return its index; otherwise, return `-1`.

---

## ✅ Example  

### **Input:**  
```java
arr = [7, 8, 9, 1, 2, 3, 4, 5, 6]
target = 7
```

### **Output:**  
```
0
```

### **Explanation:**  
- The original sorted array might have been `[1, 2, 3, 4, 5, 6, 7, 8, 9]`.
- It was rotated at pivot `3`, resulting in `[7, 8, 9, 1, , 3, 4, 5, 6]`.
- The target `7` is found at index `0`.

---
### Intuition Behind the Algorithm

1. **Binary Search Basics**:
   - Normally, binary search works by comparing the target element with the middle element of the array. If the target is smaller, we move to the left half; if it's larger, we move to the right half.
   
2. **Modified Approach for Rotated Array**:
   - In a rotated sorted array, the array is divided into two sorted parts:
     - The first part is sorted from the smallest element to the pivot.
     - The second part is sorted from the pivot to the largest element.
     
   Based on the relative position of the `low`, `mid`, and `high` indices, we can determine which half of the array is sorted and then decide whether to search in the left or right half.

3. **How the Algorithm Works**:

   - **Find the Sorted Half**: At each step of the binary search, we check if the left part (`arr[low]` to `arr[mid]`) is sorted:
     - If it is sorted (`arr[low] <= arr[mid]`), check if the target lies within this sorted range. If so, narrow the search to the left half; otherwise, move to the right half.
     - If the left part is not sorted, it means the right part (`arr[mid]` to `arr[high]`) must be sorted, and you adjust the search accordingly.
   
4. **Why This Works**:
   - The key observation is that one of the halves will always be sorted, and the target must be within that sorted half. By narrowing the search space based on this observation, the algorithm maintains the `O(log n)` time complexity.

## 🛠 Approach (Step-by-Step)  
1. **Binary Search with Conditions:** Since the array is rotated, we can't use normal binary search. Instead, we divide the array into two parts and determine which part is sorted.
2. **Check Midpoint:** Find the middle element and compare it with the target.
3. **Identify Sorted Half:**
   - If `arr[low]` to `arr[mid]` is sorted, check if the target lies in this range.
   - Otherwise, the right half is sorted; check there.
4. **Adjust Search Range:** Move `low` or `high` accordingly and continue searching until found or `low > high`.

---

## 🔢 Algorithm (Pseudo Code)  
```plaintext
1. Initialize low = 0, high = length - 1
2. While low <= high:
   a. Find mid = (low + high) / 2
   b. If arr[mid] == target, return mid
   c. If left half is sorted (arr[low] <= arr[mid]):
      - If target lies in this range, move high = mid - 1
      - Else move low = mid + 1
   d. Else (right half is sorted):
      - If target lies in this range, move low = mid + 1
      - Else move high = mid - 1
3. If not found, return -1
```



### Step-by-Step Execution:
1. **Initial State**:
   - `arr = [7, 8, 9, 1, 2, 3, 4, 5, 6]`, target = `7`.
   - Initially, `low = 0`, `high = 8`, and `mid = 4`.

2. **First Iteration**:
   - We check if the left part is sorted: `arr[low] <= arr[mid]` (i.e., `7 <= 9`), which is true. The left part `[7, 8, 9]` is sorted.
   - Since `arr[low] <= target <= arr[mid]` (i.e., `7 <= 7 <= 9`), we know the target is in the left half. So, we update `high = mid - 1`, which makes `high = 3`.

3. **Second Iteration**:
   - Now, `low = 0`, `high = 3`, and `mid = 1`.
   - We check if the left part is sorted: `arr[low] <= arr[mid]` (i.e., `7 <= 8`), which is true. The left part `[7, 8]` is sorted.
   - Since `arr[low] <= target <= arr[mid]` (i.e., `7 <= 7 <= 8`), we know the target is in the left half. So, we update `high = mid - 1`, which makes `high = 0`.

4. **Third Iteration**:
   - Now, `low = 0`, `high = 0`, and `mid = 0`.
   - We check if `arr[mid] == target` (i.e., `arr[0] == 7`), which is true. So, we return `mid = 0`.



## 💻 Code Explanation & Walkthrough  
```java
public class Optimize {
    public static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid; // Found target

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        System.out.println(search(arr, 7));
    }
}
```

---

## ⏳ Complexity Analysis  
- **Time Complexity:** `O(log N)` (Binary Search)  
- **Space Complexity:** `O(1)` (No extra space used)  

---

## ⭐ Key Features  
- Uses **binary search**, making it highly efficient.
- Handles cases where the array is rotated at any pivot.
- Works in **logarithmic time**, even for large arrays.

---

## 🎯 Pro Tips  
✅ Always check if the left or right half is sorted first.  
✅ Use `low + (high - low) / 2` instead of `(low + high) / 2` to prevent overflow.  
✅ Remember: If `arr[low] <= arr[mid]`, the left part is sorted; otherwise, the right part is sorted.

---

## 📌 Conclusion  
- This problem is a **modified binary search** question.
- Understanding **how to detect the sorted half** is the key to solving it efficiently.
- The approach is efficient and runs in `O(log N)`, making it ideal f2or large datasets.

🚀 **Mastering this concept will help in many competitive programming problems!**



## ⚠️ Handling Duplicates in Rotated Sorted Array

The given solution works perfectly when **all elements are unique**.  
But if the array contains **duplicate values**, the logic:

```java
if (arr[low] <= arr[mid]) { 
    // Left half is sorted
}
```
might not work as expected — because duplicates can make both `arr[low]` and `arr[mid]` equal, and this condition won’t clearly confirm which half is sorted.

---

### 💡 Example:  
```java
arr = [2, 2, 2, 3, 4, 2]
target = 3
```

**At some point:**

- `arr[low] == arr[mid] == arr[high]` could all be `2`.
- Now you can't decide if the left or right half is sorted, as both sides might start and end with the same value.

---

### 🧠 Solution: Modified Approach for Duplicates

When duplicates are present, you can handle this situation by adding an extra condition:

> If `arr[low] == arr[mid] == arr[high]` — it's impossible to determine which half is sorted, so **increment `low` and decrement `high`** by 1 and retry.

---

### 💻 Updated Code Snippet for Duplicates

```java
public static int searchWithDuplicates(int[] arr, int target) {
    int low = 0, high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) return mid;

        // When duplicates confuse the sorted side detection
        if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
            low++;
            high--;
        }
        // Left half is sorted
        else if (arr[low] <= arr[mid]) {
            if (arr[low] <= target && target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // Right half is sorted
        else {
            if (arr[mid] < target && target <= arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
    return -1;
}
```

---

### ⚙️ Why This Works:

- The extra check for `arr[low] == arr[mid] == arr[high]` helps bypass the ambiguity caused by duplicates.
- `low++` and `high--` shrink the search window and allow the algorithm to eventually return the correct answer or `-1` safely.
- Time Complexity can degrade to `O(N)` in the worst case (if all elements are the same), but for random duplicates, it's still very efficient.

---

### 💡 Conclusion:

- For **unique elements** — the original `O(log N)` approach is perfect.
- For **duplicate elements** — the adjusted check allows the algorithm to safely handle tricky cases but may sometimes degrade to `O(N)`.

---

✅ **Tip:**  
If the problem mentions duplicates — always add this extra check.  
If not — the pure `O(log N)` version is better.

---
