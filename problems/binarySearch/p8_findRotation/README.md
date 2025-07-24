# **Finding the Rotation Count in a Rotated Sorted Array**

## **Problem Statement**
Given a sorted array that has been **rotated** some number of times, we need to **find the index of the smallest element** (which represents the number of times the array has been rotated).

### **Example Input & Output**
#### **Example 1:**
**Input:**
```plaintext
arr = [7, 8, 9, 1, 2, 3, 4, 5, 6]
```
**Output:**
```plaintext
3
```
**Explanation:** The smallest element is `1`, found at index `3`. This means the array has been rotated `3` times.

#### **Example 2:**
**Input:**
```plaintext
arr = [4, 5, 6, 7, 0, 1, 2, 3]
```
**Output:**
```plaintext
4
```
**Explanation:** The smallest element is `0`, found at index `4`, meaning the array has been rotated `4` times.

---
## **Approach: Binary Search Optimization**
Since the array is a **sorted rotated array**, a **linear search (O(N))** would work, but a more efficient solution is to use **Binary Search (O(log N))**.

### **Step-by-Step Approach**
1. **Initialize**:
   - `low = 0`, `high = arr.length - 1`
   - `min = Integer.MAX_VALUE` (to track the minimum value)
   - `rotationNum = 0` (to track index of min element)

2. **Binary Search Logic**:
   - Find the `mid` index: `mid = low + (high - low) / 2`
   - If `arr[low] <= arr[high]`: The array is already sorted, so `arr[low]` is the minimum.
   - If `arr[low] <= arr[mid]`: Left half is sorted. Move to the **right half** (`low = mid + 1`)
   - Else: Right half is sorted. Move to the **left half** (`high = mid - 1`)

3. **Update Rotation Count**:
   - If `arr[mid]` is smaller than `min`, update `min = arr[mid]` and `rotationNum = mid`

4. **Return** `rotationNum` (index of smallest element)

---
## **Algorithm in Pseudocode**
```plaintext
FUNCTION findRotation(arr):
    low = 0
    high = length(arr) - 1
    min = MAX_INT
    rotationNum = 0
    
    WHILE low <= high:
        mid = low + (high - low) / 2
        
        IF arr[low] <= arr[high]:
            IF arr[low] < min:
                min = arr[low]
                rotationNum = low
            BREAK
        
        IF arr[low] <= arr[mid]:
            IF arr[low] < min:
                min = arr[low]
                rotationNum = low
            low = mid + 1
        ELSE:
            high = mid - 1
            IF arr[mid] < min:
                min = arr[mid]
                rotationNum = mid
    
    RETURN rotationNum
```
---
## **Code Explanation (Java Implementation)**
```java
public class Optimize {
    public static int findRotation(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int rotationNum = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[high]) {
                if(arr[low] < min){
                    min = arr[low];
                    rotationNum = low;
                }
                break;
            }

            if (arr[low] <= arr[mid]) {
                if(arr[low] < min){
                    min = arr[low];
                    rotationNum = low;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
                if(arr[mid] < min){
                    min = arr[mid];
                    rotationNum = mid;
                }
            }
        }
        return rotationNum;
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        System.out.println(findRotation(arr));
    }
}
```

---
## **Walkthrough of Execution**
### **Example: `arr = [7, 8, 9, 1, 2, 3, 4, 5, 6]`**
| Step | `low` | `high` | `mid` | `arr[mid]` | Condition | `rotationNum` |
|------|------|------|------|------|------------|--------------|
| 1 | 0 | 8 | 4 | 2 | Go Left | `4` |
| 2 | 0 | 3 | 1 | 8 | Go Right | `4` |
| 3 | 2 | 3 | 2 | 9 | Go Right | `4` |
| 4 | 3 | 3 | 3 | 1 | Found Min | `3` |

Final Output: **3** (Rotation Count)

---
## **Time & Space Complexity Analysis**
| Case | Time Complexity | Space Complexity |
|------|---------------|-----------------|
| Best Case | **O(1)** (Already sorted) | **O(1)** |
| Average Case | **O(log N)** (Binary Search) | **O(1)** |
| Worst Case | **O(log N)** | **O(1)** |

---
## **Key Features of this Approach**
✅ Uses **Binary Search** for efficiency 🔍
✅ **Optimized to O(log N) time complexity** ⏳
✅ **Constant space complexity (O(1))** 📦
✅ Works for **large arrays efficiently** 🚀

---
## **Tips for Implementation**
- If the array is **already sorted**, return `0` immediately.
- Be careful with the **mid-point calculation** to avoid integer overflow.
- Always **update `min` carefully** while searching.

---
## **Conclusion**
This algorithm efficiently finds the **number of times a sorted array has been rotated** using **binary search in O(log N) time**. Instead of scanning the entire array (O(N)), we take advantage of the **sorted property** to minimize comparisons, making it a highly optimized solution. 🚀🔥

