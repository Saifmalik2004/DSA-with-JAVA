# Split Array Largest Sum

## Problem Statement
Given an array `nums` of `n` integers and an integer `k`, you need to split the array into `k` non-empty subarrays such that the largest sum among these subarrays is minimized. Your task is to return this minimized largest sum.

### Example
#### Input:
```plaintext
nums = [7, 2, 5, 10, 8]
k = 2
```
#### Output:
```plaintext
18
```
#### Explanation:
We split the array into two parts: `[7, 2, 5]` and `[10, 8]`. The sum of the first part is `7 + 2 + 5 = 14`, and the sum of the second part is `10 + 8 = 18`. The maximum sum among these parts is `18`, which is the minimized largest sum.

---
## Intuition
We need to partition the array into `k` subarrays such that the **maximum sum of any subarray is minimized**. To achieve this, we can use **Binary Search** on the possible values of the largest sum.

### **Key Observations:**
1. The minimum possible sum is the **largest element in the array** (since each number must be in at least one subarray).
2. The maximum possible sum is the **sum of all elements** (when there is only one subarray).
3. We need to search between these two values using **Binary Search** to find the optimal partition.

---
## Approach
### Step-by-step Breakdown:
1. **Define Search Space:**
   - `low` = maximum element of `nums` (smallest valid partition sum)
   - `high` = sum of all elements in `nums` (worst-case partition sum)
2. **Apply Binary Search:**
   - Compute `mid = (low + high) / 2`.
   - Check if it is possible to split the array into `k` subarrays where the sum of each subarray does not exceed `mid`.
   - If possible, try a smaller `mid` (move `high` left) to minimize the largest sum.
   - If not possible, increase `mid` (move `low` right) to allow a larger partition sum.
3. **Valid Split Function:**
   - Traverse the array while maintaining a sum.
   - If the sum exceeds `mid`, start a new subarray and increase the partition count.
   - If partitions exceed `k`, return `false`.
4. **Binary Search until `low` and `high` converge:**
   - The minimum possible largest sum is stored in `low` at the end of binary search.

---
## Algorithm (Pseudocode)
```plaintext
FUNCTION split(nums, n, k):
    IF n < k:
        RETURN -1
    
    low = max(nums)
    high = sum(nums)
    ans = high
    
    WHILE low <= high:
        mid = (low + high) / 2
        
        IF isValid(nums, mid, k):
            ans = mid
            high = mid - 1
        ELSE:
            low = mid + 1
    
    RETURN ans

FUNCTION isValid(nums, mid, k):
    split_count = 1
    sum = 0
    
    FOR num IN nums:
        IF sum + num <= mid:
            sum += num
        ELSE:
            sum = num
            split_count++
            
            IF split_count > k:
                RETURN false
    
    RETURN true
```

---
## Code Walkthrough
```java
public class Optimize {
    public static int split(int[] nums, int n, int k) {
        if (n < k) return -1;

        int low = Integer.MIN_VALUE, high = 0;
        for (int elem : nums) {
            high += elem;
            low = Math.max(elem, low);
        }
    
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isValid(int[] nums, int mid, int k) {
        int split = 1, sum = 0;
        for (int num : nums) {
            if (sum + num <= mid) {
                sum += num;
            } else {
                sum = num;
                split++;
                if (split > k) return false;
            }
        }
        return split <= k;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        System.out.println(split(arr, arr.length, 2));
    }
}
```

---
## Time Complexity Analysis
- **Binary Search on Range:** `O(log(sum of array - max element))`
- **Validation Function (`isValid`) Complexity:** `O(n)`
- **Overall Complexity:** `O(n log(sum - max_element))`

### Space Complexity
- **O(1)** since we only use a few integer variables.

---
## Key Features of This Solution
✅ Uses **Binary Search** to optimize the solution.
✅ Ensures **minimum largest sum** in `k` partitions.
✅ **Efficient:** Runs in `O(n log(sum - max))` time.
✅ **Simple & Clean Code**.

---
## Tips for Understanding
- Think of **each subarray sum as a "threshold"** we are trying to minimize.
- Understand **why Binary Search works**: We are searching for the smallest valid `max sum`.
- **Test on small cases manually** to get an intuition.
- Try **edge cases** like `k = n` (each element is its own subarray) and `k = 1` (one big subarray).

---
## Conclusion
This problem is a great example of how **Binary Search on Answers** helps optimize complex partitioning problems. By leveraging **a validation function (`isValid`)**, we efficiently find the **minimum possible largest sum** while maintaining `k` partitions. Happy coding! 🚀

