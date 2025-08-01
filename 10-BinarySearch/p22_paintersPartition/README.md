# Painter's Partition Problem

## Problem Statement
You are given an array `arr[]` of size `n`, where each element represents the time required to paint a board. There are `m` painters available, and each painter can only paint contiguous boards. The goal is to find the minimum time required to paint all the boards.

## Example
### Input:
```plaintext
arr = [1, 2, 3, 4]
m = 2
```

### Output:
```plaintext
5
```

### Explanation:
- One way to partition the boards:
  - Painter 1 paints `[1, 2, 3]` (total time = 1+2+3 = 6)
  - Painter 2 paints `[4]` (total time = 4)
- Another way:
  - Painter 1 paints `[1, 2]` (total time = 3)
  - Painter 2 paints `[3, 4]` (total time = 7)
- The optimal partition minimizes the maximum time, which is `5`.

---

## Intuition
- If we assign fewer boards to a painter, the maximum time decreases, but more painters are required.
- If we assign more boards to a painter, the maximum time increases, but fewer painters are needed.
- We must find the optimal partition that minimizes the maximum painting time.

---

## Approach (Binary Search)
1. **Define the search space:**
   - The minimum possible time = the time taken for the largest board.
   - The maximum possible time = sum of all board times.
2. **Binary Search on the minimum time:**
   - Find a mid-point `mid` and check if it's a valid maximum painting time.
   - If it's valid, try reducing the maximum time by moving left (`high = mid - 1`).
   - Otherwise, increase it (`low = mid + 1`).

---

## Algorithm (Pseudo Code)
```plaintext
function partition(arr, n, m):
    low = max(arr)  // Minimum possible time
    high = sum(arr) // Maximum possible time
    
    while low <= high:
        mid = (low + high) / 2
        if isValid(arr, mid, m):
            high = mid - 1
        else:
            low = mid + 1
    
    return low

function isValid(arr, maxTime, m):
    painters = 1
    workspace = 0
    
    for num in arr:
        if workspace + num > maxTime:
            painters++
            workspace = num
            if painters > m:
                return False
        else:
            workspace += num
    
    return True
```

---

## Code Explanation (Java)
```java
import java.util.ArrayList;
import java.util.Arrays;

public class Optimize {
    public static int partition(ArrayList<Integer> arr, int n, int m) {
        int low = 0, high = 0;
        
        for (int elem : arr) {
            low = Math.max(low, elem);
            high += elem;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isValid(arr, mid, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean isValid(ArrayList<Integer> arr, int maxAl, int m) {
        int painters = 1, workspace = 0;

        for (int num : arr) {
            if (workspace + num > maxAl) {
                painters++;
                workspace = num;
                if (painters > m) return false;
            } else {
                workspace += num;
            }
        }
        return painters <= m;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(partition(arr, arr.size(), 2));
    }
}
```

---

## Walkthrough
1. We initialize `low` as the maximum element and `high` as the sum of all elements.
2. We apply **binary search** between `low` and `high`.
3. `mid` is checked using `isValid()`, which determines if we can split the array into `m` painters with `mid` as the max time.
4. If valid, we try a smaller `mid` (`high = mid - 1`). Otherwise, we increase `low`.
5. The process continues until `low` gives us the minimum possible max time.

---

## Time Complexity Analysis
- **Binary Search:** `O(log(sum(arr) - max(arr)))`
- **Validation Function:** `O(n)`
- **Overall Complexity:** `O(n log(sum(arr) - max(arr)))`

## Space Complexity Analysis
- **Space Complexity:** `O(1)`, as we use only a few extra variables.

---

## Key Features
✅ Uses **Binary Search** for optimization.  
✅ Efficient solution with `O(n log n)` complexity.  
✅ Can be adapted to other **partitioning problems** like "Book Allocation."  

---

## Tips 💡
- Always initialize `low = max(arr)` and `high = sum(arr)` for partition problems.
- Binary search is useful when dealing with **min/max constraints**.
- Carefully implement the `isValid` function as it determines correctness.

---

## Conclusion
This problem is a classic example of **Binary Search on Answer**. It efficiently finds the **minimum maximum time** required to complete the painting task while distributing work among `m` painters. The same approach can be used in various **partitioning problems**, making it a useful technique to master. 🚀