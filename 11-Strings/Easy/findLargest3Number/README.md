# README.md: Largest Good Integer

## Problem Description

The "Largest Good Integer" problem requires finding the largest 3-digit substring in a given string `num` (consisting of digits from 0 to 9) where all three digits are the same. A "good integer" is a substring of exactly three consecutive identical digits (e.g., "000", "111", ..., "999"). If no such substring exists, return an empty string. The result should be returned as a string.

### Problem Statement
- **Input**: A string `num` containing only digits (0-9).
- **Output**: The largest 3-digit substring where all digits are the same, or an empty string if no such substring exists.
- **Constraints**:
  - `3 <= num.length <= 1000`
  - `num` consists of digits from `0` to `9`.

### Example
1. **Input**: `num = "6777133339"`
   - **Output**: `"333"`
   - **Explanation**: The good integers are `"777"`, `"333"`, and `"999"`. The largest is `"333"` (lexicographically, based on digit value).
2. **Input**: `num = "2300019"`
   - **Output**: `"000"`
   - **Explanation**: The only good integer is `"000"`.
3. **Input**: `num = "42352338"`
   - **Output**: `""`
   - **Explanation**: No three consecutive digits are the same, so return an empty string.

## Intuition

To solve this problem, we need to identify all substrings of length 3 where the digits are identical and return the lexicographically largest one. Since the string contains only digits, a good integer is of the form `ddd` (e.g., "000", "111", ..., "999"), and we want the one with the highest digit value (e.g., "999" > "888" > ... > "000").

### Key Insights
- A good integer requires three consecutive identical digits.
- We can check each substring of length 3 by iterating through the string and verifying if the characters at indices `i`, `i+1`, and `i+2` are the same.
- Since we want the largest good integer, we compare each valid substring lexicographically and keep the maximum.
- If no good integer exists, we return an empty string.
- Lexicographical comparison of digit strings corresponds to numerical comparison (e.g., "9" > "8"), so we can use string comparison directly.

## Approach 1: Sliding Window with String Comparison

This approach uses a sliding window of size 3 to check for valid good integers and tracks the lexicographically largest one.

### Step-by-Step Approach
1. **Initialize Result**:
   - Create an empty string `ans` to store the largest good integer found.
2. **Iterate Over Substrings**:
   - Loop through the string from index `0` to `num.length() - 2` to ensure we can check three consecutive characters.
   - For each index `i`, check if `num[i] == num[i+1] == num[i+2]`.
3. **Extract and Compare**:
   - If the three characters are equal, extract the substring `num[i:i+3]`.
   - Compare it lexicographically with `ans`. If it’s larger, update `ans`.
4. **Return Result**:
   - After the loop, return `ans`. If no good integer was found, `ans` remains `""`.

### Pseudocode
```plaintext
function largestGoodInteger(num):
    ans = ""
    for i from 0 to num.length - 3:
        if num[i] == num[i+1] and num[i] == num[i+2]:
            triplet = substring(num, i, i+3)
            if triplet > ans:
                ans = triplet
    return ans
```

### Solution Code
```java
class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        
        for (int i = 0; i < num.length() - 2; i++) {
            // Check if 3 consecutive chars are same
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String triplet = num.substring(i, i + 3);
                // Compare lexicographically for max
                if (triplet.compareTo(ans) > 0) {
                    ans = triplet;
                }
            }
        }
        
        return ans;
    }
}
```

### Explanation of the Code
- **Variable `ans`**: Stores the largest good integer found, initially empty.
- **Loop**: Iterates from `i = 0` to `num.length() - 3` to access `i`, `i+1`, `i+2`.
- **Condition**: Checks if characters at `i`, `i+1`, and `i+2` are equal.
- **Substring Extraction**: Uses `num.substring(i, i+3)` to get the 3-digit substring.
- **Comparison**: Uses `compareTo` to check if the current triplet is lexicographically larger than `ans`.
- **Return**: Returns `ans`, which is `""` if no good integer is found.

### Time and Space Complexity
- **Time Complexity**: `O(n)`, where `n` is the length of `num`.
  - We iterate through `n-2` positions.
  - Each substring extraction (`substring`) and comparison (`compareTo`) is `O(1)` for fixed-length (3-character) strings.
- **Space Complexity**: `O(1)`, as we only store a fixed-size string `ans` (at most 3 characters) and temporary substrings of constant length.

### Why This Approach Works
- It checks every possible 3-digit substring for the good integer property (identical digits).
- Lexicographical comparison ensures we keep the largest valid substring (e.g., "999" > "888").
- The empty string is returned naturally if no valid substring is found.
- The approach is simple and directly follows the problem requirements.

## Approach 2: Single-Pass with Digit Tracking (Optimized)

Instead of extracting and comparing strings, we can track the largest digit that forms a good integer, reducing string operations.

### Step-by-Step Approach
1. **Initialize Max Digit**:
   - Use a variable `maxDigit` to store the largest digit forming a good integer (initially `-1` or invalid).
2. **Iterate Over Substrings**:
   - Loop from `i = 0` to `num.length() - 2`.
   - Check if `num[i] == num[i+1] == num[i+2]`.
3. **Update Max Digit**:
   - If the digits are equal, compare the current digit `num[i]` with `maxDigit`.
   - Update `maxDigit` if `num[i]` is larger.
4. **Construct Result**:
   - If `maxDigit` is valid (not `-1`), return a string of three repeated `maxDigit` (e.g., "999" for `maxDigit = '9'`).
   - Otherwise, return `""`.

### Pseudocode
```plaintext
function largestGoodInteger(num):
    maxDigit = -1
    for i from 0 to num.length - 3:
        if num[i] == num[i+1] and num[i] == num[i+2]:
            if num[i] > maxDigit:
                maxDigit = num[i]
    if maxDigit == -1:
        return ""
    return maxDigit + maxDigit + maxDigit
```

### Solution Code
```java
class Solution {
    public String largestGoodInteger(String num) {
        char maxDigit = '\0'; // Null character as invalid default
        
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                if (num.charAt(i) > maxDigit) {
                    maxDigit = num.charAt(i);
                }
            }
        }
        
        return maxDigit == '\0' ? "" : "" + maxDigit + maxDigit + maxDigit;
    }
}
```

### Explanation of the Code
- **Variable `maxDigit`**: Stores the largest digit forming a good integer, initialized to `\0` (invalid).
- **Loop**: Checks each position for three identical digits.
- **Update**: If a valid triplet is found, updates `maxDigit` if the current digit is larger.
- **Result**: If `maxDigit` is valid, constructs a 3-character string; otherwise, returns `""`.

### Time and Space Complexity
- **Time Complexity**: `O(n)`, same as Approach 1, as we still iterate through `n-2` positions and perform constant-time checks.
- **Space Complexity**: `O(1)`, as we only store a single character (`maxDigit`) and return a fixed-size string (3 characters or empty).

### Why This Approach Works
- It avoids string operations (`substring`, `compareTo`) by comparing single digits.
- Since digits are 0-9, the largest digit corresponds to the largest good integer (e.g., "999" for digit `9`).
- The final string construction is simple and efficient.

## Comparison of Approaches
| Aspect                | Approach 1 (String Comparison) | Approach 2 (Digit Tracking) |
|-----------------------|-------------------------------|-----------------------------|
| **Time Complexity**   | `O(n)`                       | `O(n)`                     |
| **Space Complexity**  | `O(1)`                       | `O(1)`                     |
| **Readability**       | More intuitive               | Slightly less intuitive     |
| **Performance**       | Slower due to string ops     | Faster, fewer operations    |

- **Approach 1**: Easier to understand and directly uses string comparison, but involves substring extraction and lexicographical comparison.
- **Approach 2**: More efficient by avoiding string operations, focusing on digit comparison, and constructing the result only once.

## Edge Cases
- **No Good Integer**: `num = "123456"` → Return `""`.
- **Single Good Integer**: `num = "111"` → Return `"111"`.
- **Multiple Good Integers**: `num = "6777133339"` → Return `"333"`.
- **Minimum Length**: `num = "000"` → Return `"000"`.
- **All Same Digit**: `num = "99999"` → Return `"999"`.
- **Leading/Trailing Non-Good**: `num = "123000456"` → Return `"000"`.

## Visual Explanation
For `num = "6777133339"`:
- **Approach 1**:
  - Check `677` → Not equal.
  - Check `777` → Equal, `ans = "777"`.
  - Check `771` → Not equal.
  - Check `713` → Not equal.
  - Check `133` → Not equal.
  - Check `333` → Equal, `"333" > "777"`, update `ans = "333"`.
  - Check `339` → Not equal.
  - Return `"333"`.
- **Approach 2**:
  - Check `677` → Skip.
  - Check `777` → `maxDigit = '7'`.
  - Check `771`, `713`, `133` → Skip.
  - Check `333` → `'3' > '7'`, `maxDigit = '3'`.
  - Check `339` → Skip.
  - Return `"333"`.

## Why Other Approaches Might Fail
- **Checking Non-Consecutive Digits**: The problem requires consecutive digits, so checking non-adjacent digits fails.
- **Sorting or Hashing**: Sorting the string or using a hash map is unnecessary and ignores the consecutive requirement.
- **Fixed Window Without Comparison**: Assuming the first valid triplet is the largest fails (e.g., `"111333"` returns `"111"` incorrectly).

## Conclusion
Both approaches are correct and efficient with `O(n)` time and `O(1)` space. **Approach 2 (Digit Tracking)** is recommended for its performance edge due to fewer string operations, making it suitable for larger inputs. **Approach 1 (String Comparison)** is more intuitive for beginners and easier to implement quickly. Both handle all edge cases, and the provided test cases (e.g., `"6777133339"`, `"2300019"`, `"42352338"`) confirm correctness.

For further exploration, try implementing a version that counts occurrences of each digit triplet to verify frequency or test with edge cases like a string of all identical digits.