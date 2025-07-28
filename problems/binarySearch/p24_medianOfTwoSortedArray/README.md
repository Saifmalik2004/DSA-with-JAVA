# Find the Median of Two Sorted Arrays

## Problem Statement

Given two sorted arrays `a[]` and `b[]` of sizes `n1` and `n2` respectively, find the median of the combined sorted array formed by merging both arrays.

## What is Median?

- If total length (`n1 + n2`) is **odd**, median is the **middle element**.
- If total length is **even**, median is the **average of the two middle elements**.

## Example

```plaintext
a = [1, 4, 7, 10, 12]
b = [2, 3, 6, 15]

Merged array = [1, 2, 3, 4, 6, 7, 10, 12, 15]
Length is 9 (odd)
Median = middle element = 7
```

# Approaches to Solve the Problem

## 1️⃣ Brute Force Approach

### Intuition

- Fully merge the two sorted arrays into one new sorted array.
- Find the median by direct indexing.

### Steps

1. Initialize two pointers (`i` and `j`) at the start of both arrays.
2. Merge them by picking the smaller element from either array.
3. Once merged fully, determine the median from the merged array.

### Pseudocode

```
function medianBrute(a, b):
  merge a and b into arr3
  if total length odd:
    return arr3[middle]
  else:
    return average of two middle elements
```

### Code

```java
import java.util.ArrayList;
import java.util.List;

public class Brute {
    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        List arr3 = new ArrayList<>();
        int i = 0, j = 0;

        while (i  max(maxLeftA, maxLeftB)
If even length   -> average of max(maxLeftA, maxLeftB) and min(minRightA, minRightB)
```

- Otherwise:
  - If `maxLeftA > minRightB`, move partition in `a` left (decrease `i`).
  - Else, move partition right (increase `i`).

### Why binary search?

- Because `a` is sorted, we can quickly guess the correct `i` using binary search.
- For each `i`, `j` is derived from half size.
- This reduces complexity to **O(log(min(n1,n2)))** instead of linear.

### Pseudocode

```
function medianOptimized(a, b):
  if size(a) > size(b): swap a and b

  n1 = length(a), n2 = length(b)
  total = n1 + n2
  half = (total + 1) / 2

  low = 0, high = n1

  while low  r2:
      high = i - 1
    else:
      low = i + 1
```

### Example Walkthrough

Arrays:

```
a = [1, 4, 5]
b = [2, 3, 6]

total = 6 (even)
half = (6 + 1) / 2 = 3
```

- Start binary search on `a` between `0` and `3`

**Iter 1:**

- `i = 1`, `j = 3 - 1 = 2`
- `l1 = a = 1`
- `r1 = a = 4`
- `l2 = b = 3`
- `r2 = b = 6`

Check conditions:

- `l1  n2) return median(b, a);

        int total = n1 + n2;
        int half = (total + 1) / 2;

        int low = 0, high = n1;

        while (low  r2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        return 0.0; // Should never hit here for valid input
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5};
        int[] b = {2, 3, 6};
        System.out.println(median(a, b));  // Output: 3.5
    }
}
```

# Complexity Summary

| Approach              | Time Complexity       | Space Complexity  | Notes                               |
|-----------------------|----------------------|-------------------|-----------------------------------|
| Brute Force           | O(n1 + n2)           | O(n1 + n2)        | Simple, uses extra space           |
| Better Merge Simulation| O(n1 + n2)           | O(1)              | More space efficient               |
| Optimized Binary Search| O(log(min(n1, n2)))  | O(1)              | Fastest, best for large input     |

# Final Notes

- All arrays **must be sorted** for these approaches.
- The optimized approach is highly efficient but has more complex logic.
- Useful for coding interviews as it tests understanding of binary search and partitioning.
- For small inputs or one-off problems, brute force or better merge works fine.
- Practice with multiple test cases to understand edge scenarios (empty arrays, unequal lengths, duplicates).

# Happy Coding! ✨
