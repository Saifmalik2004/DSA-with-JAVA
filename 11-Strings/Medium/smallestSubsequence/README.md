# README.md: Smallest Subsequence of Distinct Characters

## Problem Description

The "Smallest Subsequence of Distinct Characters" problem (LeetCode #1081, also equivalent to "Remove Duplicate Letters" LeetCode #316) requires returning the smallest lexicographically subsequence of a given string `s` that contains all distinct characters of `s` exactly once. The result must maintain the relative order of characters as they appear in the original string.

### Problem Statement
- **Input**: A string `s` containing lowercase English letters.
- **Output**: The smallest lexicographically subsequence of `s` that includes all unique characters exactly once.
- **Constraints**:
  - `1 <= s.length <= 1000`
  - `s` consists of lowercase English letters.

### Example
1. **Input**: `s = "bcabc"`
   - **Output**: `"abc"`
   - **Explanation**: The subsequence `"abc"` contains all unique characters (`a`, `b`, `c`) in lexicographical order.
2. **Input**: `s = "cbacdcbc"`
   - **Output**: `"acdb"`
   - **Explanation**: The subsequence `"acdb"` contains all unique characters (`a`, `b`, `c`, `d`) in the smallest lexicographical order while maintaining their relative order in `s`.
3. **Input**: `s = "leetcode"`
   - **Output**: `"letcod"`
   - **Explanation**: All unique characters (`l`, `e`, `t`, `c`, `o`, `d`) are included in lexicographical order.

## Intuition

The goal is to construct the smallest lexicographically subsequence that includes all distinct characters exactly once. Since the result is a subsequence, we must preserve the relative order of characters as they appear in `s`. A greedy approach using a stack (or `StringBuilder` in this case) can help build the result by:
- Including each unique character exactly once.
- Ensuring the result is lexicographically minimal by preferring smaller characters earlier.
- Removing characters from the result if a smaller character is found later, provided the removed character appears again in `s`.

### Key Insights
- Use a stack-like structure to build the result, adding characters in a way that maintains lexicographical order.
- Track the last occurrence of each character to decide if a character can be safely removed (i.e., it appears later).
- Use a boolean array to track which characters are already included to avoid duplicates.
- When a new character is smaller than the last character in the result and the last character appears later, remove the last character to achieve a smaller lexicographical order.

## Approach: Monotonic Stack with Greedy Removal

This approach uses a `StringBuilder` as a stack to build the result, ensuring the smallest lexicographical subsequence by greedily removing characters when possible.

### Step-by-Step Approach
1. **Track Last Occurrences**:
   - Create an array `lastIndex` to store the last index of each character in `s`.
   - Iterate through `s` to populate `lastIndex` for each lowercase letter (a-z).
2. **Build the Result**:
   - Use a `StringBuilder` to construct the subsequence.
   - Use a boolean array `isTaken` to track which characters are already included.
   - Iterate through each character `ch` in `s`:
     - If `ch` is already in the result, skip it.
     - While the `StringBuilder` is not empty, the current character `ch` is smaller than the last character in the result, and the last character appears later in `s`, remove the last character from the result and mark it as not taken.
     - Append `ch` to the result and mark it as taken.
3. **Return the Result**:
   - Convert the `StringBuilder` to a string and return it.

### Pseudocode
```plaintext
function smallestSubsequence(s):
    lastIndex = array of size 26, initialized to 0
    isTaken = array of size 26, initialized to false
    result = new StringBuilder
    
    // Step 1: Store last index of each character
    for i from 0 to s.length - 1:
        lastIndex[s[i] - 'a'] = i
    
    // Step 2: Build the subsequence
    for i from 0 to s.length - 1:
        ch = s[i]
        if isTaken[ch - 'a']:
            continue
        while result is not empty and ch < last character in result and lastIndex[last character - 'a'] > i:
            remove last character from result
            mark last character as not taken
        append ch to result
        mark ch as taken
    
    return result as string
```

### Solution Code
```java
class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        boolean[] isTaken = new boolean[26];
        int n = s.length();
        StringBuilder result = new StringBuilder();

        // Step 1: Store last index of each character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        // Step 2: Traverse the string
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (isTaken[ch - 'a']) continue;

            // Remove larger characters which will appear later again
            while (
                result.length() > 0 &&
                ch < result.charAt(result.length() - 1) &&
                lastIndex[result.charAt(result.length() - 1) - 'a'] > i
            ) {
                char removed = result.charAt(result.length() - 1);
                isTaken[removed - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            result.append(ch);
            isTaken[ch - 'a'] = true;
        }

        return result.toString();
    }
}
```

### Explanation of the Code
- **Arrays**:
  - `lastIndex[26]`: Stores the last index where each character (a-z) appears in `s`.
  - `isTaken[26]`: Tracks whether a character is already included in the result.
- **StringBuilder**: Acts as a stack to build the subsequence, allowing efficient appending and removal.
- **First Loop**: Populates `lastIndex` by updating the index of each character as it’s encountered.
- **Second Loop**:
  - Skips characters already in the result (`isTaken[ch - 'a']`).
  - Removes the last character from `result` if it’s larger than the current character and appears later in `s`.
  - Appends the current character and marks it as taken.
- **Return**: Converts `result` to a string.

### Time and Space Complexity
- **Time Complexity**: `O(n)`, where `n` is the length of `s`.
  - First loop: `O(n)` to populate `lastIndex`.
  - Second loop: `O(n)` to traverse `s`. Each character is processed once, and removals from `StringBuilder` are amortized `O(1)` (total removals are bounded by the number of additions).
- **Space Complexity**: `O(1)` (excluding output).
  - `lastIndex` and `isTaken` are fixed-size arrays (26 elements for lowercase letters).
  - `StringBuilder` stores at most 26 characters (since only unique lowercase letters are included), which is constant.

### Why This Approach Works
- The monotonic stack ensures the result is lexicographically minimal by removing larger characters when a smaller character can replace them without losing any required characters.
- `lastIndex` ensures we only remove a character if it appears later, preserving the requirement to include all unique characters.
- `isTaken` prevents duplicates, ensuring each character appears exactly once.
- The approach maintains the relative order of characters as they appear in `s`.

## Alternative Approach: Recursive (Less Efficient)

A recursive approach can build the result by finding the smallest character that can start the subsequence and recursively solving for the rest of the string. However, this is less efficient and more complex.

### Step-by-Step Approach
1. Find the smallest character in `s` that appears after the last used position and has all remaining unique characters after it.
2. Include this character in the result and recursively process the substring after its first occurrence.
3. Base case: If no characters remain, return an empty string.

### Why Not Used
- **Time Complexity**: `O(n^2)` in the worst case due to repeated string scanning.
- **Space Complexity**: `O(n)` for recursion stack and string operations.
- **Complexity**: Harder to implement and less efficient than the stack-based approach.

## Edge Cases
- **Single Character**: `s = "a"` → Return `"a"`.
- **All Same Character**: `s = "aaaa"` → Return `"a"`.
- **All Unique Characters**: `s = "abc"` → Return `"abc"`.
- **Repeated Characters**: `s = "cbacdcbc"` → Return `"acdb"`.
- **Long String with Few Unique Characters**: `s = "leetcode"` → Return `"letcod"`.

## Visual Explanation
For `s = "cbacdcbc"`:
- **Step 1**: `lastIndex = [c:7, b:6, a:2, d:4, ...]`.
- **Step 2**:
  - `i=0, ch='c'`: Append `c`, `result="c"`, `isTaken[c]=true`.
  - `i=1, ch='b'`: `b < c` and `lastIndex[c]=7 > 1`, remove `c`, append `b`, `result="b"`, `isTaken[c]=false`, `isTaken[b]=true`.
  - `i=2, ch='a'`: `a < b` and `lastIndex[b]=6 > 2`, remove `b`, append `a`, `result="a"`, `isTaken[b]=false`, `isTaken[a]=true`.
  - `i=3, ch='c'`: Append `c`, `result="ac"`, `isTaken[c]=true`.
  - `i=4, ch='d'`: Append `d`, `result="acd"`, `isTaken[d]=true`.
  - `i=5, ch='c'`: Skip (already taken).
  - `i=6, ch='b'`: Append `b`, `result="acdb"`, `isTaken[b]=true`.
  - `i=7, ch='c'`: Skip (already taken).
- **Return**: `"acdb"`.

## Why Other Approaches Might Fail
- **Greedy Without Stack**: Taking the smallest character first without checking later occurrences fails to ensure all characters are included.
- **Sorting Characters**: Sorting ignores the relative order requirement.
- **Including All Occurrences**: Keeping all instances of a character violates the "exactly once" rule.

## Conclusion
The provided **monotonic stack approach** is optimal with `O(n)` time and `O(1)` space (excluding output). It’s efficient, handles all edge cases, and produces the smallest lexicographical subsequence with all unique characters. The use of `lastIndex` and `isTaken` ensures correctness, while the `StringBuilder` provides efficient string manipulation. For further exploration, try implementing the recursive approach or testing with strings containing many repeated characters to understand the stack’s behavior.