# README.md: Implement strStr()

## Problem Description

The "Implement strStr()" problem (LeetCode #28) requires finding the index of the first occurrence of a substring (`needle`) in a given string (`haystack`). If the `needle` is not found in the `haystack`, return `-1`. This is essentially an implementation of the string searching function `strstr` in C or `indexOf` in Java.

### Problem Statement
- **Input**:
  - `haystack`: A string of lowercase English letters.
  - `needle`: A string of lowercase English letters to search for in `haystack`.
- **Output**: The index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not found.
- **Constraints**:
  - `0 <= haystack.length, needle.length <= 5 * 10^4`
  - `haystack` and `needle` consist only of lowercase English letters.
  - If `needle` is an empty string, return `0`.

### Example
1. **Input**: `haystack = "hello"`, `needle = "ll"`
   - **Output**: `2`
   - **Explanation**: `"ll"` is found at index 2 in `"hello"`.
2. **Input**: `haystack = "aaaaa"`, `needle = "bba"`
   - **Output**: `-1`
   - **Explanation**: `"bba"` is not found in `"aaaaa"`.
3. **Input**: `haystack = ""`, `needle = ""`
   - **Output**: `0`
   - **Explanation**: An empty `needle` is considered to be found at index 0.
4. **Input**: `haystack = "aaa"`, `needle = "aaaa"`
   - **Output**: `-1`
   - **Explanation**: The `needle` is longer than the `haystack`, so it cannot be found.

## Intuition

The problem involves searching for a substring (`needle`) within a larger string (`haystack`). A straightforward approach is to check each possible starting position in `haystack` to see if the substring starting at that position matches `needle`. However, we can optimize this by leveraging string properties or advanced algorithms like Knuth-Morris-Pratt (KMP) or Boyer-Moore for better performance on large inputs.

### Key Insights
- If `needle` is empty, return `0` as per the problem's convention.
- If `needle` is longer than `haystack`, it cannot be found, so return `-1`.
- We can use a sliding window of size `needle.length()` to check substrings of `haystack`.
- For each starting index `i`, compare the substring `haystack[i:i+needle.length()]` with `needle`.
- To optimize, we can avoid substring creation by comparing characters directly or use advanced string-matching algorithms.

## Approach 1: Brute Force with Substring Comparison

This approach checks every possible substring of `haystack` with the length of `needle` to find a match.

### Step-by-Step Approach
1. **Handle Edge Cases**:
   - If `needle` is empty, return `0`.
   - If `needle` is longer than `haystack`, return `-1`.
2. **Iterate Over Possible Starting Indices**:
   - Loop from `i = 0` to `haystack.length() - needle.length()` to ensure enough characters remain for a match.
   - For each index `i`, extract the substring `haystack[i:i+needle.length()]` and compare it with `needle`.
3. **Check for Match**:
   - If the substring equals `needle`, return the starting index `i`.
4. **Return Default**:
   - If no match is found, return `-1`.

### Pseudocode
```plaintext
function strStr(haystack, needle):
    if needle is empty:
        return 0
    if needle.length > haystack.length:
        return -1
    for i from 0 to haystack.length - needle.length:
        if haystack.substring(i, i + needle.length) equals needle:
            return i
    return -1
```

### Solution Code
```java
class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < (haystack.length() - (needle.length() - 1)); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
```

### Explanation of the Code
- **Loop Condition**: `i < haystack.length() - (needle.length() - 1)` simplifies to `i <= haystack.length() - needle.length()`, ensuring enough characters remain for a match.
- **Substring Check**: `haystack.substring(i, i + needle.length())` extracts a substring of length `needle.length()` and compares it with `needle` using `equals`.
- **Return**: Returns the first index `i` where a match is found, or `-1` if no match exists.
- **Edge Cases**: The code implicitly handles the empty `needle` case (returns `0` since the loop runs 0 times) but misses explicit checks for `needle.length() > haystack.length()`.

### Time and Space Complexity
- **Time Complexity**: `O(n * m)`, where `n` is the length of `haystack` and `m` is the length of `needle`.
  - We iterate `n - m + 1` times.
  - Each `substring` and `equals` operation takes `O(m)` time in the worst case.
- **Space Complexity**: `O(m)` for the substring created in each iteration (temporary string in Java).

### Why This Approach Works
- It exhaustively checks every possible starting position for a match.
- The substring comparison ensures an exact match with `needle`.
- It handles most cases but is inefficient for large strings due to repeated substring creation and comparison.

### Limitations
- **Performance**: Creating and comparing substrings is slow for large inputs.
- **Edge Case Handling**: The code doesn’t explicitly check for `needle.length() > haystack.length()`, which could lead to issues if not handled by the loop condition.

## Approach 2: Brute Force with Character-by-Character Comparison

This approach avoids substring creation by comparing characters directly, improving performance slightly.

### Step-by-Step Approach
1. **Handle Edge Cases**:
   - If `needle` is empty, return `0`.
   - If `needle.length() > haystack.length()`, return `-1`.
2. **Iterate Over Starting Indices**:
   - Loop from `i = 0` to `haystack.length() - needle.length()`.
3. **Check Characters**:
   - For each index `i`, compare characters of `haystack` starting at `i` with `needle`.
   - If all characters match, return `i`.
   - If any character mismatches, break and try the next `i`.
4. **Return Default**:
   - If no match is found, return `-1`.

### Pseudocode
```plaintext
function strStr(haystack, needle):
    if needle is empty:
        return 0
    if needle.length > haystack.length:
        return -1
    for i from 0 to haystack.length - needle.length:
        j = 0
        while j < needle.length and haystack[i+j] == needle[j]:
            j++
        if j == needle.length:
            return i
    return -1
```

### Solution Code
```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
```

### Explanation of the Code
- **Edge Cases**: Explicitly checks for empty `needle` and `needle.length() > haystack.length()`.
- **Outer Loop**: Iterates over valid starting indices.
- **Inner Loop**: Compares characters of `haystack` and `needle` one-by-one.
- **Match Check**: If `j` reaches `needle.length()`, all characters matched, so return `i`.
- **Return**: Returns `-1` if no match is found.

### Time and Space Complexity
- **Time Complexity**: `O(n * m)` in the worst case, as we may compare up to `m` characters for each of the `n - m + 1` starting positions.
- **Space Complexity**: `O(1)`, as no extra space is used beyond a few variables.

### Why This Approach Works
- It avoids substring creation, reducing overhead.
- Character-by-character comparison ensures correctness.
- Explicit edge case handling makes it robust.

### Advantages Over Approach 1
- No substring creation, reducing memory usage.
- Potentially faster due to direct character comparisons.

## Approach 3: Knuth-Morris-Pratt (KMP) Algorithm

For large strings, the KMP algorithm optimizes string matching by preprocessing `needle` to avoid redundant comparisons.

### Step-by-Step Approach
1. **Build LPS Array**:
   - Compute the Longest Prefix Suffix (LPS) array for `needle`, which indicates the length of the longest proper prefix that is also a suffix for each prefix of `needle`.
2. **Search Using KMP**:
   - Use two pointers: `i` for `haystack` and `j` for `needle`.
   - Compare characters at `i` and `j`. If they match, increment both.
   - If they mismatch, use the LPS array to skip redundant comparisons in `needle`.
   - If `j` reaches `needle.length()`, a match is found at `i - j`.
3. **Handle Edge Cases**:
   - Return `0` for empty `needle`.
   - Return `-1` if `needle` is longer than `haystack` or no match is found.

### Pseudocode
```plaintext
function strStr(haystack, needle):
    if needle is empty:
        return 0
    if needle.length > haystack.length:
        return -1
    
    lps = computeLPS(needle)
    i = 0, j = 0
    while i < haystack.length:
        if haystack[i] == needle[j]:
            i++, j++
        if j == needle.length:
            return i - j
        if i < haystack.length and haystack[i] != needle[j]:
            if j > 0:
                j = lps[j-1]
            else:
                i++
    return -1

function computeLPS(needle):
    lps = array of size needle.length, initialized to 0
    len = 0, i = 1
    while i < needle.length:
        if needle[i] == needle[len]:
            len++, lps[i] = len, i++
        else if len > 0:
            len = lps[len-1]
        else:
            lps[i] = 0, i++
    return lps
```

### Solution Code
```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        
        int[] lps = computeLPS(needle);
        int i = 0, j = 0;
        
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == needle.length()) {
                return i - j;
            }
            if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
    
    private int[] computeLPS(String needle) {
        int[] lps = new int[needle.length()];
        int len = 0, i = 1;
        
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }
}
```

### Explanation of the Code
- **LPS Array**: `computeLPS` builds the array to track prefix-suffix overlaps in `needle`.
- **Search Loop**: Compares characters and uses `lps` to skip redundant checks on mismatch.
- **Edge Cases**: Handles empty `needle` and length mismatch explicitly.
- **Return**: Returns the first match index or `-1`.

### Time and Space Complexity
- **Time Complexity**: `O(n + m)`, where `n` is `haystack.length()` and `m` is `needle.length()`.
  - LPS computation: `O(m)`.
  - Search: `O(n)`, as each character is processed at most twice.
- **Space Complexity**: `O(m)` for the `lps` array.

### Why This Approach Works
- KMP avoids backtracking in `needle` by using the `lps` array to skip redundant comparisons.
- It’s optimal for large strings where brute force would be too slow.
- It correctly handles all edge cases.

## Comparison of Approaches
| Aspect                | Approach 1 (Substring) | Approach 2 (Char-by-Char) | Approach 3 (KMP) |
|-----------------------|-----------------------|---------------------------|------------------|
| **Time Complexity**   | `O(n * m)`            | `O(n * m)`                | `O(n + m)`       |
| **Space Complexity**  | `O(m)`                | `O(1)`                    | `O(m)`           |
| **Readability**       | Simple                | Moderate                  | Complex          |
| **Performance**       | Slowest               | Faster than 1             | Fastest          |
| **Edge Case Handling**| Implicit              | Explicit                  | Explicit         |

- **Approach 1**: Simple but inefficient due to substring operations.
- **Approach 2**: More efficient than Approach 1, suitable for small inputs.
- **Approach 3**: Optimal for large inputs, but more complex to implement.

## Edge Cases
- **Empty Needle**: `needle = ""` → Return `0`.
- **Empty Haystack**: `haystack = ""`, `needle = "a"` → Return `-1`.
- **Needle Longer than Haystack**: `haystack = "a"`, `needle = "aa"` → Return `-1`.
- **No Match**: `haystack = "aaaaa"`, `needle = "bba"` → Return `-1`.
- **Multiple Matches**: `haystack = "mississippi"`, `needle = "iss"` → Return first occurrence (4).
- **Single Character**: `haystack = "a"`, `needle = "a"` → Return `0`.

## Visual Explanation
For `haystack = "hello"`, `needle = "ll"`:
- **Approach 1**:
  - Check `he` → No match.
  - Check `el` → No match.
  - Check `ll` → Match, return `2`.
  - Check `lo` → No match.
- **Approach 2**:
  - At `i=0`: `h != l`, skip.
  - At `i=1`: `e != l`, skip.
  - At `i=2`: `l == l`, `l == l`, match, return `2`.
- **Approach 3 (KMP)**:
  - LPS for `"ll"`: `[0, 1]`.
  - Compare: `h` (mismatch, `i=1`), `e` (mismatch, `i=2`), `l == l` (`j=1`), `l == l` (`j=2`, match), return `2`.

## Why Other Approaches Might Fail
- **Direct String Comparison**: Comparing without handling length checks fails for edge cases.
- **Incorrect Loop Bounds**: Looping beyond valid indices causes index errors.
- **Ignoring Empty Needle**: Failing to return `0` for empty `needle` violates the problem spec.
- **Substring Without Optimization**: Excessive substring creation is inefficient.

## Conclusion
- **Approach 1 (Substring)**: Suitable for quick prototyping but inefficient for large inputs.
- **Approach 2 (Char-by-Char)**: Better for small inputs, simple, and avoids substring overhead.
- **Approach 3 (KMP)**: Best for large inputs due to `O(n + m)` complexity, but requires understanding of the LPS array.

The provided code (Approach 1) is correct but can be improved by adding explicit edge case checks and using character-by-character comparison (Approach 2) or KMP (Approach 3) for better performance. For most practical purposes, Approach 2 strikes a balance between simplicity and efficiency, while KMP is ideal for large-scale applications.