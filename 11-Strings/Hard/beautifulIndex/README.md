# README.md: Beautiful Indices Problem

## Problem Description

Given a string `s` and two patterns `a` and `b`, find all indices `i` in `s` where:
- Pattern `a` starts at index `i`.
- There exists an index `j` where pattern `b` starts, and the absolute difference `|i - j|` is at most `k`.
These indices are called "beautiful indices." Return them in a sorted list.

### Key Details
- **Input**:
  - `s`: The main string to search in.
  - `a`: The first pattern to find in `s`.
  - `b`: The second pattern to find in `s`.
  - `k`: A non-negative integer for the maximum allowed distance between indices.
- **Output**: A list of indices `i` where `a` starts, and there’s at least one index `j` where `b` starts such that `|i - j| <= k`.
- **Constraints**:
  - `1 <= s.length <= 10^5`
  - `1 <= a.length, b.length <= 10`
  - `0 <= k <= 10^5`
  - All strings contain only lowercase English letters.
- **Examples**:
  - Input: `s = "isawsquirrelnearmysquirrelhouseohmy", a = "my", b = "squirrel", k = 15`
    - Output: `[16, 33]`
    - Explanation: `a = "my"` appears at indices `16` and `33`. `b = "squirrel"` appears at indices `4` and `21`. For `i = 16`, `|16 - 21| = 5 <= 15`. For `i = 33`, `|33 - 21| = 12 <= 15`.
  - Input: `s = "abcd", a = "a", b = "b", k = 4`
    - Output: `[0]`
    - Explanation: `a` starts at `0`, `b` starts at `1`, `|0 - 1| = 1 <= 4`.

## Intuition

To find beautiful indices, we need to:
1. Find all starting indices of pattern `a` in `s`.
2. Find all starting indices of pattern `b` in `s`.
3. For each index `i` where `a` starts, check if there’s an index `j` where `b` starts such that `|i - j| <= k`.

Since string searching can be slow for large strings, we use the **KMP (Knuth-Morris-Pratt) algorithm** to efficiently find all occurrences of `a` and `b` in `s`. Then, we iterate through the indices of `a` and check if any index of `b` is within distance `k`.

## Approach: KMP + Two-Pointer Search

The solution uses the KMP algorithm to find all occurrences of patterns `a` and `b` in `s`, then checks for valid pairs of indices within distance `k`.

### Steps:
1. **Convert Strings to Character Arrays**: Convert `s`, `a`, and `b` to character arrays for efficient processing.
2. **Find Indices Using KMP**:
   - Use the `kmp` function to get a list of all starting indices of `a` in `s` (`indicesA`).
   - Use the `kmp` function to get a list of all starting indices of `b` in `s` (`indicesB`).
3. **Find Beautiful Indices**:
   - Iterate through each index `i` in `indicesA`.
   - For each `i`, check the indices in `indicesB` to find a `j` such that `|i - j| <= k`.
   - Use a pointer `j` to track the current index in `indicesB` and avoid redundant checks:
     - Check left side: If `j` is less than `i` and `i - indicesB[j] <= k`, add `i` to the result.
     - Check right side: For indices in `indicesB` starting from `j`, if `indicesB[j] <= i + k` and `|indicesB[j] - i| <= k`, add `i` to the result.
4. **Return Result**: Return the list of beautiful indices.

### Java Code:
```java
import java.util.*;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        char[] sChar = s.toCharArray();
        List<Integer> indicesA = kmp(sChar, a.toCharArray());
        List<Integer> indicesB = kmp(sChar, b.toCharArray());
        List<Integer> res = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < indicesA.size(); i++) {
            boolean found = false;
            int aIndex = indicesA.get(i);

            // Check left side
            while (j < indicesB.size() && aIndex > indicesB.get(j)) {
                if (aIndex - indicesB.get(j) <= k) {
                    res.add(aIndex);
                    found = true;
                    break;
                }
                j++;
            }

            // Check right side
            int lowerBound = j;
            while (!found && lowerBound < indicesB.size() && indicesB.get(lowerBound) <= aIndex + k) {
                if (indicesB.get(lowerBound) - aIndex <= k) {
                    res.add(aIndex);
                    found = true;
                }
                lowerBound++;
            }
        }

        return res;
    }

    private List<Integer> kmp(char[] s, char[] pattern) {
        int[] lsp = computeLsp(pattern);
        List<Integer> res = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < s.length; i++) {
            while (j > 0 && s[i] != pattern[j]) {
                j = lsp[j - 1];
            }
            if (s[i] == pattern[j]) {
                j++;
            }
            if (j == pattern.length) {
                res.add(i - j + 1);
                j = lsp[j - 1];
            }
        }
        return res;
    }

    private int[] computeLsp(char[] s) {
        int length = 0;
        int i = 1;
        int[] lsp = new int[s.length];

        while (i < s.length) {
            while (length > 0 && s[i] != s[length]) {
                length = lsp[length - 1];
            }
            if (s[length] == s[i]) {
                ++length;
            }
            lsp[i++] = length;
        }
        return lsp;
    }
}
```

### Why It Works:
- **KMP Algorithm**: Efficiently finds all occurrences of `a` and `b` in `s` in `O(n + m)` time, where `n` is the length of `s` and `m` is the length of the pattern.
- **Two-Pointer Optimization**: By maintaining a pointer `j` for `indicesB`, we avoid checking indices that are too far to the left. We also limit checks to indices where `indicesB[j] <= aIndex + k`, ensuring efficiency.
- **Correctness**: For each index of `a`, we check if there’s an index of `b` within distance `k`, satisfying the problem’s condition.

### Time and Space Complexity:
- **Time Complexity**:
  - KMP for `a`: `O(n + m1)`, where `n = s.length`, `m1 = a.length`.
  - KMP for `b`: `O(n + m2)`, where `m2 = b.length`.
  - Processing indices: `O(|indicesA| + |indicesB|)` in the worst case, as each index in `indicesB` is visited at most once across all iterations of `indicesA`.
  - Total: `O(n + m1 + m2 + |indicesA| + |indicesB|)`. Since `|indicesA|` and `|indicesB|` are at most `n`, this simplifies to `O(n)`.
- **Space Complexity**:
  - `O(m1)` for `lsp` array of `a`, `O(m2)` for `lsp` array of `b`.
  - `O(n)` for `indicesA` and `indicesB` in the worst case.
  - `O(n)` for the result list.
  - Total: `O(n + m1 + m2)`.

## Example Walkthrough
For `s = "isawsquirrelnearmysquirrelhouseohmy"`, `a = "my"`, `b = "squirrel"`, `k = 15`:
- KMP finds `a = "my"` at indices `[16, 33]`.
- KMP finds `b = "squirrel"` at indices `[4, 21]`.
- For `i = 16`:
  - Check `j = 4`: `|16 - 4| = 12 <= 15`, so `16` is a beautiful index.
- For `i = 33`:
  - Check `j = 21`: `|33 - 21| = 12 <= 15`, so `33` is a beautiful index.
- Result: `[16, 33]`.

## Edge Cases
- **Empty `indicesA` or `indicesB`**: If `a` or `b` is not found in `s`, return an empty list (no beautiful indices).
- **k = 0**: Only indices where `i == j` are valid (if `a` and `b` start at the same index).
- **Large `s`**: KMP ensures efficiency for `s.length <= 10^5`.
- **Small patterns**: Works efficiently even if `a` or `b` is a single character.
- **No overlap**: Handled correctly, as KMP finds all occurrences.

## Testing
```java
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "isawsquirrelnearmysquirrelhouseohmy";
        String a = "my";
        String b = "squirrel";
        int k = 15;
        List<Integer> result = sol.beautifulIndices(s, a, b, k);
        System.out.println(result); // Output: [16, 33]
    }
}
```

## Why This Solution is Great
- **Efficient**: Uses KMP for fast pattern matching and a two-pointer approach to minimize index comparisons.
- **Clear**: Well-structured code with separate KMP and index-checking logic.
- **Handles Constraints**: Works for large `s` (up to `10^5`) and small patterns (up to `10`).
- **Reliable**: Correctly handles all edge cases and produces sorted indices as required.