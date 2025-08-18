# README.md: Delete Columns to Make Sorted

## Problem Description

The "Delete Columns to Make Sorted" problem (LeetCode) requires determining the minimum number of columns to delete from an array of strings to make each column sorted in non-decreasing order (lexicographically). Each string in the array has the same length, and a column is defined as the characters at the same index across all strings.

### Problem Statement
- **Input**: An array of strings `strs`, where each string has length `n` and there are `m` strings.
- **Output**: The minimum number of columns (indices) to delete so that the remaining columns are sorted in non-decreasing order.
- **Constraints**:
  - `1 <= strs.length <= 100` (number of strings, `m`)
  - `1 <= strs[i].length <= 100` (length of each string, `n`)
  - All strings consist of lowercase letters.

### Example
1. **Input**: `strs = ["cba", "daf", "ghi"]`
   - **Output**: `1`
   - **Explanation**: The first column `['c', 'd', 'g']` is sorted, the second column `['b', 'a', 'h']` is not (since 'b' > 'a'), and the third column `['a', 'f', 'i']` is sorted. Only the second column needs deletion.
2. **Input**: `strs = ["a", "b"]`
   - **Output**: `0`
   - **Explanation**: The single column `['a', 'b']` is already sorted.
3. **Input**: `strs = ["zyx", "wvu", "tsr"]`
   - **Output**: `3`
   - **Explanation**: All columns `['z', 'w', 't']`, `['y', 'v', 's']`, `['x', 'u', 'r']` are unsorted, so all must be deleted.

## Intuition

To solve this problem, we need to check each column of the array of strings to determine if it is sorted in non-decreasing order. A column is sorted if the character in each row `j` is less than or equal to the character in row `j+1` for that column. If a column is not sorted, it must be deleted, and we count it.

### Key Insights
- A column is unsorted if there exists any pair of adjacent strings where the character in the earlier string is greater than the character in the next string at the same column index.
- We only need to check adjacent pairs of strings for each column, as the sorted property is transitive (if `strs[j][i] <= strs[j+1][i]` for all `j`, the entire column is sorted).
- The problem reduces to iterating through each column and checking if it violates the sorted condition.

## Approach

We will use a straightforward iterative approach to check each column for the sorted property.

### Step-by-Step Approach
1. **Understand the Input**:
   - `strs` is an array of `m` strings, each of length `n`.
   - We need to examine each column `i` (where `i` ranges from `0` to `n-1`) across all strings.
2. **Check Each Column**:
   - For each column index `i`, iterate through the rows (strings) from `0` to `m-2`.
   - Compare the character at `strs[j][i]` with `strs[j+1][i]`.
   - If `strs[j][i] > strs[j+1][i]`, the column is not sorted, so increment a counter and move to the next column.
3. **Return the Count**:
   - The counter represents the number of columns that need to be deleted.

### Pseudocode
```plaintext
function minDeletionSize(strs):
    count = 0
    for each column i from 0 to strs[0].length - 1:
        for each row j from 0 to strs.length - 2:
            if strs[j][i] > strs[j+1][i]:
                count = count + 1
                break // No need to check further rows for this column
    return count
```

## Solution Code
Below is the complete Java implementation of the solution:

```java
public class Solution {
    public static int minDeletionSize(String[] strs) {
        int count = 0;
        // Iterate through each column
        for (int i = 0; i < strs[0].length(); i++) {
            // Check each pair of adjacent strings
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    count++;
                    break; // Move to next column
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test case 1
        String[] strs1 = {"cba", "daf", "ghi"};
        System.out.println("Output 1: " + minDeletionSize(strs1)); // Expected: 1

        // Test case 2
        String[] strs2 = {"a", "b"};
        System.out.println("Output 2: " + minDeletionSize(strs2)); // Expected: 0

        // Test case 3
        String[] strs3 = {"zyx", "wvu", "tsr"};
        System.out.println("Output 3: " + minDeletionSize(strs3)); // Expected: 3
    }
}
```

## Explanation of the Code
- **Outer Loop (`i`)**: Iterates through each column index (0 to `n-1`, where `n` is the length of each string).
- **Inner Loop (`j`)**: Iterates through pairs of adjacent strings (0 to `m-2`, where `m` is the number of strings).
- **Condition Check**: If `strs[j][i] > strs[j+1][i]`, the column is not sorted. Increment `count` and break the inner loop to avoid unnecessary checks.
- **Main Method**: Includes test cases to verify the solution.

## Time and Space Complexity
- **Time Complexity**: `O(m * n)`, where `m` is the number of strings and `n` is the length of each string.
  - We iterate through each column (`n` iterations).
  - For each column, we may check up to `m-1` pairs of characters.
  - In the worst case, we check every character in every column, but the `break` statement reduces checks for unsorted columns.
- **Space Complexity**: `O(1)`, as we only use a single counter variable and no additional data structures.

## Why This Approach Works
- The approach directly checks the definition of a sorted column: each character must be less than or equal to the character in the next row.
- By checking adjacent pairs, we ensure the entire column is sorted (since if `a <= b` and `b <= c`, then `a <= c`).
- The `break` statement optimizes the inner loop by stopping as soon as an unsorted pair is found, avoiding redundant checks.

## Alternative Approaches
No other fundamentally different approaches are necessary for this problem, as the straightforward column-checking method is optimal in terms of simplicity and efficiency. However, we can consider minor variations:
1. **Precompute Character Arrays**:
   - Convert strings to a 2D character array first to avoid repeated `charAt` calls.
   - **Trade-off**: Increases space complexity to `O(m * n)` but may slightly improve runtime due to faster array access.
   - **Why Not Used**: The performance gain is negligible for small inputs, and `charAt` is efficient enough.
2. **Parallel Processing** (not practical for this problem):
   - For very large inputs, columns could be checked in parallel, but the overhead of thread management outweighs benefits for typical input sizes.

## Edge Cases
- **Single String (`m = 1`)**: No comparisons needed, return `0` (handled since `j < strs.length - 1` skips the loop).
- **Single Column (`n = 1`)**: Check one column; return `0` or `1` based on whether it’s sorted.
- **All Columns Sorted**: Return `0` (e.g., `["a", "b"]`).
- **All Columns Unsorted**: Return `n` (e.g., `["zyx", "wvu", "tsr"]`).
- **Empty Strings**: Not possible due to constraints (`1 <= strs[i].length`).

## Visual Explanation
Consider the input `strs = ["cba", "daf", "ghi"]`:
```
Column 0: ['c', 'd', 'g'] → Sorted (c <= d <= g)
Column 1: ['b', 'a', 'h'] → Unsorted (b > a, stop checking)
Column 2: ['a', 'f', 'i'] → Sorted (a <= f <= i)
```
- Delete column 1 → Output: `1`.

## Why Other Approaches Might Fail
- **Checking Non-Adjacent Pairs**: Unnecessary, as adjacent pair checks suffice due to transitivity.
- **Sorting Strings First**: The problem is about columns, not rows, so sorting strings doesn’t help.
- **Overcomplicating with Data Structures**: Using heaps or other structures adds unnecessary complexity, as a simple scan is sufficient.

## Conclusion
The provided solution is efficient, clear, and handles all cases correctly. It iterates through each column, checks for sorted order, and counts columns that need deletion. The time complexity of `O(m * n)` and space complexity of `O(1)` make it optimal for the given constraints. The code is beginner-friendly with clear logic and includes test cases to verify correctness.

For further exploration, users can try implementing the character array approach or experiment with edge cases to deepen understanding.