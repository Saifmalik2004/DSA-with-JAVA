# 🛠 Finding the Minimum Element in a Rotated Sorted Array

## 📌 Problem Statement
Given a **sorted array** that has been **rotated at some pivot**, find the **minimum element** in the array.

- The array is originally sorted in **ascending order**, but due to rotation, a part of it has been shifted to the front.
- You need to find the **smallest element** efficiently.

### 🔹 Example
#### **Input:**
```java
int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
```
#### **Output:**
```java
1
```

## 💡 Approach
We will use **Binary Search** to find the minimum element efficiently.

### **🔎 Step-by-step Explanation**
1. **Initialize variables:**
   - `low = 0`, `high = nums.length - 1`
   - `Min = Integer.MAX_VALUE` (to store the minimum value)

2. **Binary Search Logic:**
   - Find the **mid index**: `mid = low + (high - low) / 2`
   - Check if the **subarray is already sorted** (`nums[low] <= nums[high]`)
     - If true, the **leftmost element is the minimum**, update `Min` and **exit loop**.
   - If **left half is sorted (`nums[low] <= nums[mid]`)**:
     - Update `Min = min(Min, nums[low])`
     - Move to **right half** (`low = mid + 1`)
   - Otherwise, the **right half is sorted**, so:
     - Update `Min = min(Min, nums[mid])`
     - Move to **left half** (`high = mid - 1`)

3. **Return `Min`** as the minimum element.

## 📝 Algorithm (Pseudocode)
```plaintext
function searchMin(nums):
    Initialize low = 0, high = length of nums - 1
    Initialize Min = Infinity
    while low <= high:
        mid = low + (high - low) / 2
        if nums[low] <= nums[high]:
            Min = min(Min, nums[low])
            break
        if nums[low] <= nums[mid]:
            Min = min(Min, nums[low])
            low = mid + 1
        else:
            high = mid - 1
            Min = min(Min, nums[mid])
    return Min
```

## 💻 Code Walkthrough
```java
public class Optimize {
    public static int searchMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int Min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[low] <= nums[high]) {
                Min = Math.min(Min, nums[low]);
                break;
            }
            if (nums[low] <= nums[mid]) {
                Min = Math.min(Min, nums[low]);
                low = mid + 1;
            } else {
                high = mid - 1;
                Min = Math.min(Min, nums[mid]);
            }
        }
        return Min;
    }
    public static void main(String[] args) {
        int arr[] = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        System.out.println(searchMin(arr));
    }
}
```

## ⏳ Complexity Analysis
- **Time Complexity:** 🕒 **O(log N)** (Binary search reduces search space by half)
- **Space Complexity:** 💾 **O(1)** (No extra space used)

## 🔑 Key Features
✅ **Uses Binary Search** for efficiency.  
✅ **Handles rotated sorted arrays**.  
✅ **Works in logarithmic time complexity O(log N)**.  

## 📝 Tips
- If array is **already sorted** (no rotation), the first element is the minimum.
- If mid element is **smaller than both neighbors**, it is the minimum.
- This approach works **only for distinct elements**.

## 🎯 Conclusion
This method efficiently finds the **minimum element** in a **rotated sorted array** using **Binary Search**, reducing the time complexity from **O(N) to O(log N)**. 🚀

