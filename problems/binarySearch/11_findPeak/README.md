# Find Peak Element

## Problem Statement
Given an integer array `arr`, find a **peak element** and return its **index**. A peak element is an element that is strictly greater than its **neighbors**.

- If `arr[i] > arr[i-1]` and `arr[i] > arr[i+1]`, then `arr[i]` is a **peak element**.
- The array may contain multiple peaks; return **any peak index**.
- Assume that `arr[-1] = arr[n] = -∞` (i.e., the boundaries are treated as negative infinity).

## Example
### Example 1:
**Input:** `arr = [1,2,3,1]`

**Output:** `2`

**Explanation:** `arr[2] = 3` is a peak element because `3 > 2` and `3 > 1`.

### Example 2:
**Input:** `arr = [1,2,1,3,5,6,4]`

**Output:** `5`

**Explanation:** `arr[5] = 6` is a peak element because `6 > 5` and `6 > 4`.

## Intuition
To find a peak element, we need to check if an element is greater than its **neighbors**. The **naïve approach** is to linearly scan the array, but we can do better using **binary search** because:
- If `arr[mid]` is greater than its **left** neighbor, the peak must be on the **right**.
- If `arr[mid]` is greater than its **right** neighbor, the peak must be on the **left**.
- If `arr[mid]` is greater than both neighbors, it is the peak!

Thus, we can efficiently **narrow down** the search space using binary search.

## Approach
We use **Binary Search**:
1. **Edge Cases:**
   - If there's only one element, return `0`.
   - If the first element is a peak, return `0`.
   - If the last element is a peak, return `n-1`.
2. **Binary Search Logic:**
   - Use `low = 1` and `high = n-2` (ignoring first and last, as we already checked them).
   - Find `mid = (low + high) / 2`.
   - If `arr[mid]` is a peak (greater than both neighbors), return `mid`.
   - If `arr[mid] > arr[mid-1]`, move `low` to `mid + 1`.
   - Else, move `high` to `mid - 1`.

### Pseudo Code
```plaintext
function findPeakElement(arr):
    n = length(arr)
    if n == 1 return 0
    if arr[0] > arr[1] return 0
    if arr[n-1] > arr[n-2] return n-1

    low = 1, high = n-2
    while low <= high:
        mid = (low + high) / 2
        if arr[mid] > arr[mid-1] and arr[mid] > arr[mid+1]:
            return mid
        if arr[mid] > arr[mid-1]:
            low = mid + 1
        else:
            high = mid - 1
    return -1
```

## Dry Run
### Example: `arr = [1,2,3,1]`
1. `low = 1`, `high = 2`, `mid = (1+2)/2 = 1`
   - `arr[1] = 2`, not a peak (since `arr[2] > arr[1]`).
   - Move `low = mid + 1 = 2`.
2. `low = 2`, `high = 2`, `mid = 2`
   - `arr[2] = 3`, peak found (`arr[2] > arr[1]` and `arr[2] > arr[3]`).
   - Return `2`.

## Full Code
```java
class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        
        // Base case: If array has only one element, it's the peak
        if (n == 1) return 0;
        
        // Check if first element is a peak
        if (arr[0] > arr[1]) return 0;
        
        // Check if last element is a peak
        if (arr[n - 1] > arr[n - 2]) return n - 1;
        
        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Check if mid is a peak
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            
            // If left neighbor is smaller, move right
            if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            } 
            // Otherwise, move left
            else {
                high = mid - 1;
            }
        }
        
        return -1; // This should never be reached
    }
}
```

## Time and Space Complexity Analysis
- **Time Complexity:** `O(log n)` (Binary search reduces the problem size by half in each step)
- **Space Complexity:** `O(1)` (Only a few extra variables are used)

## Key Features
✔ **Efficient:** Uses **binary search** instead of linear scan.  
✔ **Guaranteed Peak:** A peak element always exists.  
✔ **Handles Edge Cases:** Works for small and large arrays.  
✔ **Optimized:** No extra space used.

## Tips
- If an array is **strictly increasing**, the last element is always a peak.
- If an array is **strictly decreasing**, the first element is a peak.
- Binary search works because a peak is always **guaranteed to exist**.
- The peak is **not necessarily unique**, any peak index is a valid answer.

## Conclusion
The **Find Peak Element** problem is a great example of using **binary search** effectively. Instead of scanning linearly (`O(n)`), we narrow down the search space (`O(log n)`). This technique can be applied to other **search problems** where we can divide the problem into **halves**.

