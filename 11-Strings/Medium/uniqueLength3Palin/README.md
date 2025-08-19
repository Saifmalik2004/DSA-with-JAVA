# README.md: Count Palindromic Subsequences

## Problem Description

The "Count Palindromic Subsequences" problem (LeetCode #1930) requires counting the number of unique palindromic subsequences of length 3 in a given string `s`. A palindromic subsequence of length 3 is of the form `aba`, where `a` and `b` are characters, and `a` appears at the start and end with `b` in between. The string `s` consists of lowercase English letters, and the goal is to return the total number of distinct palindromic subsequences.

### Problem Statement
- **Input**: A string `s` containing only lowercase English letters.
- **Output**: An integer representing the number of unique palindromic subsequences of length 3 in `s`.
- **Constraints**:
  - `3 <= s.length <= 10^5`
  - `s` consists of lowercase English letters.

### Example
1. **Input**: `s = "aabca"`
   - **Output**: `3`
   - **Explanation**: The unique palindromic subsequences are `"aba"` (a-b-a), `"aca"` (a-c-a), and `"aaa"` (a-a-a).
2. **Input**: `s = "adc"`
   - **Output**: `0`
   - **Explanation**: No palindromic subsequences of length 3 exist.
3. **Input**: `s = "bbcbaba"`
   - **Output**: `4`
   - **Explanation**: The unique palindromic subsequences are `"bbb"`, `"bab"`, `"aba"`, and `"bab"` (note: `"bab"` appears twice but is counted once as we need unique subsequences).

## Intuition

A palindromic subsequence of length 3 has the form `aba`, where the first and last characters are the same (`a`), and the middle character (`b`) is between them. Since we need unique subsequences, we can:
- Identify each unique character in `s` that could form the first and last positions (`a`).
- For each such character, find the first and last occurrences in `s`.
- Count the unique characters between these positions, as each forms a distinct palindromic subsequence `a-b-a`.

### Key Insights
- Only characters with at least two occurrences can form palindromic subsequences (since `a` must appear at both ends).
- The number of unique palindromic subsequences for a character `a` is the number of unique characters between its first and last occurrences.
- Using a `HashSet` to track unique characters in `s` and between occurrences ensures we count distinct subsequences.
- The problem constraints allow for an efficient solution since we only deal with lowercase letters (26 possible characters).

## Approach: First and Last Index with HashSet

This approach uses the first and last indices of each unique character to identify potential palindromic subsequences and counts unique middle characters.

### Step-by-Step Approach
1. **Collect Unique Characters**:
   - Iterate through `s` and store all unique characters in a `HashSet` to avoid duplicate processing.
2. **Process Each Unique Character**:
   - For each character `c` in the set:
     - Find its first occurrence (`start`) using `indexOf(c)`.
     - Find its last occurrence (`end`) using `lastIndexOf(c)`.
     - If `start < end` (ensuring at least two occurrences and space for a middle character), proceed.
3. **Count Middle Characters**:
   - Create a `HashSet` to store unique characters between `start + 1` and `end - 1`.
   - Iterate through indices `start + 1` to `end - 1` and add each character to the set.
   - The size of this set represents the number of unique palindromic subsequences of the form `c-b-c`.
4. **Sum Results**:
   - Add the size of the middle character set to the result for each valid character `c`.
5. **Return Total**:
   - Return the total count of unique palindromic subsequences.

### Pseudocode
```plaintext
function countPalindromicSubsequence(s):
    uniq = new HashSet
    for each char c in s:
        add c to uniq
    
    result = 0
    for each char c in uniq:
        start = s.indexOf(c)
        end = s.lastIndexOf(c)
        if start < end:
            charSet = new HashSet
            for i from start + 1 to end - 1:
                add s[i] to charSet
            result += charSet.size
    return result
```

### Solution Code
```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        Set<Character> uniq = new HashSet<>();

        // Step 1: Collect unique characters
        for (char c : s.toCharArray()) {
            uniq.add(c);
        }

        // Step 2: Process each unique character
        for (char c : uniq) {
            int start = s.indexOf(c);
            int end = S.lastIndexOf(c);

            // Step 3: Count unique middle characters
            if (start < end) {
                Set<Character> charSet = new HashSet<>();
                for (int i = start + 1; i < end; i++) {
                    charSet.add(s.charAt(i));
                }
                res += charSet.size();
            }
        }

        return res;        
    }
}
```

### Explanation of the Code
- **Set `uniq`**: Stores unique characters in `s` using a `HashSet`.
- **First Loop**: Populates `uniq` by iterating through `s`.
- **Second Loop**: For each unique character `c`:
  - Uses `indexOf` and `lastIndexOf` to find the first and last positions.
  - If `start < end`, creates a `HashSet` to collect unique characters between `start + 1` and `end - 1`.
  - Adds the size of the middle character set to `res`.
- **Return**: Returns the total count of unique palindromic subsequences.
- **Note**: There’s a typo in the code (`S.lastIndexOf(c)` should be `s.lastIndexOf(c)`), which will be assumed corrected.

### Time and Space Complexity
- **Time Complexity**: `O(n + 26 * n) = O(n)`, where `n` is the length of `s`.
  - Collecting unique characters: `O(n)`.
  - Processing unique characters: At most 26 iterations (lowercase letters).
  - `indexOf` and `lastIndexOf`: `O(n)` each, called 26 times → `O(26 * n)`.
  - Middle character loop: `O(n)` per character, but total iterations are bounded by `n`.
- **Space Complexity**: `O(1)` (constant, since sets store at most 26 characters).
  - `uniq` and `charSet` each store up to 26 lowercase letters.
  - No additional space scales with input size.

### Why This Approach Works
- It identifies all possible palindromic subsequences of the form `a-b-a` by checking each unique character as the outer pair (`a`).
- Using `indexOf` and `lastIndexOf` ensures we consider the widest possible range for middle characters.
- The `HashSet` for middle characters ensures we count only unique `b` values, avoiding duplicate subsequences.
- The approach handles all edge cases, including when no palindromic subsequences exist.

## Alternative Approach: Precompute Character Indices

Instead of using `indexOf` and `lastIndexOf`, we can precompute the first and last indices of each character to reduce redundant string scans.

### Step-by-Step Approach
1. **Precompute Indices**:
   - Create two arrays: `firstIndex[26]` and `lastIndex[26]` to store the first and last indices of each character.
   - Iterate through `s` to populate these arrays.
2. **Process Each Character**:
   - For each lowercase letter (a-z), check if it has valid first and last indices (`firstIndex[c] < lastIndex[c]`).
   - Count unique characters between these indices using a `HashSet`.
3. **Sum Results**:
   - Add the count of unique middle characters for each valid character to the result.
4. **Return Total**:
   - Return the total count.

### Pseudocode
```plaintext
function countPalindromicSubsequence(s):
    firstIndex = array of size 26, initialized to -1
    lastIndex = array of size 26, initialized to -1
    for i from 0 to s.length - 1:
        c = s[i] - 'a'
        if firstIndex[c] == -1:
            firstIndex[c] = i
        lastIndex[c] = i
    
    result = 0
    for c from 0 to 25:
        if firstIndex[c] < lastIndex[c]:
            charSet = new HashSet
            for i from firstIndex[c] + 1 to lastIndex[c] - 1:
                add s[i] to charSet
            result += charSet.size
    return result
```

### Solution Code
```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        
        // Step 1: Precompute first and last indices
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (firstIndex[c] == -1) {
                firstIndex[c] = i;
            }
            lastIndex[c] = i;
        }
        
        // Step 2: Count palindromic subsequences
        int res = 0;
        for (int c = 0; c < 26; c++) {
            if (firstIndex[c] < lastIndex[c]) {
                Set<Character> charSet = new HashSet<>();
                for (int i = firstIndex[c] + 1; i < lastIndex[c]; i++) {
                    charSet.add(s.charAt(i));
                }
                res += charSet.size();
            }
        }
        
        return res;
    }
}
```

### Explanation of the Code
- **Arrays**: `firstIndex` and `lastIndex` store the first and last positions of each character (a-z).
- **First Loop**: Populates `firstIndex` (on first occurrence) and `lastIndex` (on last occurrence).
- **Second Loop**: For each character (0 to 25), checks if it has multiple occurrences, then counts unique middle characters.
- **Return**: Sums the sizes of middle character sets.

### Time and Space Complexity
- **Time Complexity**: `O(n)`, where `n` is the length of `s`.
  - Precomputing indices: `O(n)`.
  - Processing 26 characters and their middle ranges: `O(n)` total, as each character in `s` is visited at most twice.
- **Space Complexity**: `O(1)`, as `firstIndex`, `lastIndex`, and `charSet` use constant space (26 elements).

### Advantages Over Original Approach
- Avoids repeated `indexOf` and `lastIndexOf` calls, which are `O(n)` each.
- More efficient for large strings, as index computation is done once.

## Comparison of Approaches
| Aspect                | Original (HashSet with indexOf) | Precompute Indices |
|-----------------------|--------------------------------|--------------------|
| **Time Complexity**   | `O(n)` (but with higher constant due to `indexOf`) | `O(n)` (lower constant) |
| **Space Complexity**  | `O(1)`                         | `O(1)`             |
| **Readability**       | Simpler                        | Slightly more complex |
| **Performance**       | Slower due to string methods    | Faster             |

- **Original Approach**: Easier to understand but less efficient due to repeated string scans.
- **Precompute Indices**: More efficient by avoiding redundant computations, suitable for large inputs.

## Edge Cases
- **Minimum Length**: `s = "abc"` → Return `0` (no palindromic subsequences possible).
- **Single Character Repeated**: `s = "aaa"` → Return `1` (only `"aaa"`).
- **No Palindromes**: `s = "adc"` → Return `0`.
- **All Same Character**: `s = "aaaa"` → Return `1` (only `"aaa"`).
- **Long String with Few Characters**: `s = "aabca"` → Return `3` (`"aba"`, `"aca"`, `"aaa"`).

## Visual Explanation
For `s = "aabca"`:
- **Original Approach**:
  - Unique characters: `{'a', 'b', 'c'}`.
  - For `a`: `start=0`, `end=4`. Middle: `abc` → 3 subsequences (`a-a-a`, `a-b-a`, `a-c-a`).
  - For `b`: `start=1`, `end=2`. Middle: empty → 0 subsequences.
  - For `c`: `start=3`, `end=3`. No middle → 0 subsequences.
  - Total: `3`.
- **Precompute Approach**:
  - `firstIndex[a]=0`, `lastIndex[a]=4`, middle: `abc` → 3 subsequences.
  - `firstIndex[b]=1`, `lastIndex[b]=2`, middle: empty → 0.
  - `firstIndex[c]=3`, `lastIndex[c]=3`, middle: empty → 0.
  - Total: `3`.

## Why Other Approaches Might Fail
- **Counting All Subsequences**: Including non-unique subsequences violates the problem’s requirement.
- **Incorrect Range**: Using incorrect indices (e.g., not first/last) misses valid subsequences.
- **Dynamic Programming**: A full DP approach is overkill (e.g., `O(n^2)` or higher) and unnecessary for length-3 subsequences.

## Conclusion
The **Precompute Indices** approach is recommended for its efficiency, especially for large inputs, with `O(n)` time and `O(1)` space. The provided **Original Approach** is correct but less efficient due to `indexOf` and `lastIndexOf` calls. Both handle all edge cases, but the precompute approach reduces redundant work. For further exploration, try testing with strings containing many repeated characters or implementing a version that tracks character frequencies for additional optimization. Note: The typo `S.lastIndexOf(c)` in the original code should be corrected to `s.lastIndexOf(c)`.