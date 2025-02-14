
# Search Range Algorithm

## Introduction  
This Java program efficiently finds the **first and last occurrence** of a target element in a sorted array using **binary search**.

---

## Explanation  

### **Approach**  
We use **binary search** twice:  
1. **First Binary Search** → Finds the **first occurrence** of the target.  
2. **Second Binary Search** → Finds the **last occurrence** of the target.  

### **Algorithm**  
1. **Initialize variables**  
   - `low = 0`, `high = nums.length - 1`  
   - `ans1 = -1` (stores first occurrence)  
   - `ans2 = -1` (stores last occurrence)  

2. **Find First Occurrence**  
   - Perform **binary search**.  
   - If `nums[mid] < target`, move `low = mid + 1`.  
   - If `nums[mid] == target`, update `ans1 = mid` and move `high = mid - 1` to search further left.  

3. **Find Last Occurrence**  
   - Reset `low = 0`, `high = nums.length - 1`.  
   - Perform **binary search**.  
   - If `nums[mid] > target`, move `high = mid - 1`.  
   - If `nums[mid] == target`, update `ans2 = mid` and move `low = mid + 1` to search further right.  

4. **Return `[ans1, ans2]`** as the first and last index of `target`.  

---

## Code  

```java
public class Optimize {
    public static int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans1 = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (nums[mid] == target) ans1 = mid;
                high = mid - 1;
            }
        }

        low = 0;
        high = nums.length - 1;
        int ans2 = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (nums[mid] == target) ans2 = mid;
                low = mid + 1;
            }
        }

        return new int[]{ans1, ans2};
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 2, 3, 4, 4, 4};
        for (int elem : searchRange(arr, 4)) {
            System.out.println(elem);
        }
    }
}
```

---

## Example  

### **Input:**  
```java
int arr[] = {1, 1, 1, 2, 2, 3, 4, 4, 4};
int target = 4;
```

### **Output:**  
```
6
8
```

### **Explanation:**  
In the given sorted array, `4` appears at indices **6 to 8**, so the output is `[6, 8]`.

---

## Complexity Analysis  
| Case | Time Complexity |
|------|---------------|
| Best Case | **O(log N)** |
| Worst Case | **O(log N)** |

✅ **Binary search** reduces the search time significantly compared to **O(N)** in a linear search.  

---

## Edge Cases Considered  
- **Target at the beginning or end** → Works for cases like `{4, 4, 4, 5, 6}`  
- **Target appears once** → Handles cases like `{1, 2, 3, 4, 5}`  
- **Target not found** → Returns `[-1, -1]`  

---

## Summary  
This approach efficiently finds the **first and last index** of a target value in a **sorted array** using **binary search in O(log N) time**.
```  

This follows your structure and explains everything clearly. Let me know if you want any modifications! 🚀