# README.md: Backspace String Compare

## Problem Description

The "Backspace String Compare" problem (available on platforms like LeetCode) requires determining if two strings, after processing backspace characters (`#`), are equal. A backspace character `#` deletes the character before it (if one exists). The goal is to compare the final strings after applying all backspace operations.

### Problem Statement
- **Input**: Two strings `s` and `t`, each containing lowercase letters and `#` characters.
- **Output**: A boolean indicating whether the processed strings are equal.
- **Constraints**:
  - `1 <= s.length, t.length <= 200`
  - `s` and `t` only contain lowercase letters and `'#'` characters.

### Example
1. **Input**: `s = "ab#c"`, `t = "ad#c"`
   - **Output**: `true`
   - **Explanation**: After processing, `s` becomes `"ac"` (delete `b`), and `t` becomes `"ac"` (delete `d`). The strings are equal.
2. **Input**: `s = "ab##"`, `t = "c#d#"`
   - **Output**: `true`
   - **Explanation**: Both `s` and `t` become `""` (empty strings) after processing all backspaces.
3. **Input**: `s = "a#c"`, `t = "b"`
   - **Output**: `false`
   - **Explanation**: `s` becomes `"c"`, `t` remains `"b"`. They are not equal.

## Intuition

The problem involves processing strings where `#` acts as a backspace, removing the previous character. We need to compare the final strings after all backspaces are applied. There are two intuitive ways to approach this:
1. **Build the Final String**: Process each string by simulating backspace operations and compare the resulting strings.
2. **Two-Pointer Approach**: Compare characters from the end of both strings, skipping characters that would be deleted by backspaces, without building new strings.

Both approaches are valid, but they differ in efficiency and complexity. The first approach is straightforward but uses extra space, while the second is more space-efficient.

## Approach 1: Build String with StringBuilder (Brute Force)

This approach processes each string by constructing the final string after applying backspaces, then compares the results.

### Step-by-Step Approach
1. **Process Each String**:
   - Iterate through each character in the string.
   - If the character is not `#`, append it to a `StringBuilder`.
   - If the character is `#` and the `StringBuilder` is not empty, delete the last character.
2. **Compare Results**:
   - Convert both `StringBuilder` objects to strings and check if they are equal.

### Pseudocode
```plaintext
function backspaceCompare(s, t):
    return buildString(s) == buildString(t)

function buildString(s):
    result = new StringBuilder
    for each character ch in s:
        if ch is not '#':
            append ch to result
        else if result is not empty:
            delete last character from result
    return result as string
```

### Solution Code
```java
public class Brute {
    public static boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int m = t.length();
        return buildString(s, n).equals(buildString(t, m));
    }

    private static String buildString(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != '#') {
                res.append(ch);
            } else if (!res.isEmpty()) {
                res.deleteCharAt(res.length() - 1);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "c#d#")); // true
        System.out.println(backspaceCompare("a#c", "b"));     // false
    }
}
```

### Explanation of the Code
- **Function `backspaceCompare`**: Calls `buildString` for both inputs and compares the results using `equals`.
- **Function `buildString`**: Uses a `StringBuilder` to build the final string by appending non-`#` characters and deleting the last character for each `#` if possible.
- **Main Method**: Tests the function with provided examples.

### Time and Space Complexity
- **Time Complexity**: `O(n + m)`, where `n` and `m` are the lengths of strings `s` and `t`. We process each character once, and `StringBuilder` operations (`append`, `deleteCharAt`) are `O(1)` amortized.
- **Space Complexity**: `O(n + m)`, as we store the processed strings in `StringBuilder` objects, which could be as large as the input strings in the worst case (no backspaces).

### Why This Approach Works
- It directly simulates the backspace operation by building the final string, ensuring all `#` characters are processed correctly.
- Comparing the final strings is straightforward and handles all edge cases.

## Approach 2: Two-Pointer (Optimized)

This approach avoids building new strings by processing both strings from the end using two pointers, skipping characters that would be deleted by backspaces.

### Step-by-Step Approach
1. **Initialize Pointers**:
   - Use pointers `i` and `j` starting from the end of strings `s` and `t`, respectively.
   - Use counters `skips` and `skipt` to track backspaces for each string.
2. **Process Strings Backward**:
   - For each string, while the pointer is valid:
     - If the current character is `#`, increment the skip counter and move the pointer left.
     - If the skip counter is positive, decrement it and move the pointer left (skip the character).
     - If the skip counter is zero and the character is not `#`, break (we’ve found a valid character).
3. **Compare Characters**:
   - After processing, compare the characters at `i` and `j`. Use a null character (`\0`) if a pointer goes out of bounds.
   - If characters differ, return `false`.
   - Move both pointers left and repeat.
4. **Return Result**:
   - If both pointers reach the start (or beyond), return `true`.

### Pseudocode
```plaintext
function backspaceCompare(s, t):
    i = s.length - 1
    j = t.length - 1
    skips = 0, skipt = 0

    while i >= 0 or j >= 0:
        while i >= 0:
            if s[i] is '#':
                skips++, i--
            else if skips > 0:
                skips--, i--
            else:
                break
        while j >= 0:
            if t[j] is '#':
                skipt++, j--
            else if skipt > 0:
                skipt--, j--
            else:
                break
        first = i < 0 ? '\0' : s[i]
        second = j < 0 ? '\0' : t[j]
        if first != second:
            return false
        i--, j--
    return true
```

### Solution Code
```java
public class Optimize {
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skips = 0, skipt = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skips++;
                    i--;
                } else if (skips > 0) {
                    skips--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipt++;
                    j--;
                } else if (skipt > 0) {
                    skipt--;
                    j--;
                } else {
                    break;
                }
            }

            char first = (i < 0) ? '\0' : s.charAt(i);
            char second = (j < 0) ? '\0' : t.charAt(j);

            if (first != second) return false;

            i--;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "c#d#")); // true
        System.out.println(backspaceCompare("a#c", "b"));     // false
    }
}
```

### Explanation of the Code
- **Pointers and Skip Counters**: `i` and `j` track positions in `s` and `t`, while `skips` and `skipt` count backspaces to skip characters.
- **Backward Processing**: For each string, skip characters based on backspaces until a valid character is found or the string ends.
- **Comparison**: Compare the characters at the current positions (or `\0` if out of bounds). If they differ, return `false`.
- **Main Method**: Tests the function with provided examples. (Note: The `StringBuilder` and `ArrayList` code in the main method seems unrelated to the problem and outputs `-1` for `s.indexOf("l")`, as `"l"` is not in `"saif"`.)

### Time and Space Complexity
- **Time Complexity**: `O(n + m)`, where `n` and `m` are the lengths of `s` and `t`. Each character is visited at most twice (once for `#` or skip, once for comparison).
- **Space Complexity**: `O(1)`, as we only use a few variables (`i`, `j`, `skips`, `skipt`).

### Why This Approach Works
- Processing backward simplifies backspace handling, as we can count and apply skips immediately without modifying the string.
- Comparing characters only when both pointers point to valid (non-skipped) characters ensures correctness.
- The approach handles all edge cases, including empty results and mismatched lengths.

## Comparison of Approaches
| Aspect                | Brute Force (StringBuilder) | Optimized (Two-Pointer) |
|-----------------------|-----------------------------|-------------------------|
| **Time Complexity**   | `O(n + m)`                  | `O(n + m)`              |
| **Space Complexity**  | `O(n + m)`                  | `O(1)`                  |
| **Readability**       | Easier to understand         | Slightly more complex    |
| **Performance**       | Slower due to string building | Faster, no extra space  |

- **Brute Force**: Intuitive and beginner-friendly but uses extra space to store processed strings.
- **Optimized**: More efficient in space and slightly faster in practice due to fewer operations, but requires understanding backward processing.

## Edge Cases
- **Empty Strings After Processing**: `s = "ab##"`, `t = "c#d#"` → Both become `""`, return `true`.
- **Single Character with Backspace**: `s = "a#"`, `t = ""` → Both become `""`, return `true`.
- **Different Lengths**: `s = "a#c"`, `t = "b"` → `s` becomes `"c"`, `t` is `"b"`, return `false`.
- **All Backspaces**: `s = "####"`, `t = "####"` → Both become `""`, return `true`.
- **No Backspaces**: `s = "abc"`, `t = "abc"` → Return `true`.

## Visual Explanation
For `s = "ab#c"`, `t = "ad#c"`:
- **Brute Force**:
  - `s`: Process `a` (append), `b` (append), `#` (delete `b`), `c` (append) → `"ac"`.
  - `t`: Process `a` (append), `d` (append), `#` (delete `d`), `c` (append) → `"ac"`.
  - Compare: `"ac" == "ac"` → `true`.
- **Two-Pointer**:
  - Start: `i = 3`, `j = 3` (`s[3] = 'c'`, `t[3] = 'c'`).
  - Compare: `c == c`, move `i--`, `j--`.
  - `i = 2`, `j = 2`: `s[2] = '#'`, `t[2] = '#'`. Increment skips, move left.
  - `i = 1`, `j = 1`: Skip `b` and `d` due to backspaces.
  - `i = 0`, `j = 0`: `s[0] = 'a'`, `t[0] = 'a'`. Compare: `a == a`.
  - Both pointers reach `-1`, return `true`.

## Why Other Approaches Might Fail
- **Forward Processing Without Stack**: Processing forward without a stack or `StringBuilder` is complex, as backspaces affect future characters.
- **Comparing Without Processing**: Directly comparing strings ignores backspaces, leading to incorrect results.
- **Using Stack**: A stack-based approach (push for non-`#`, pop for `#`) works but is similar to `StringBuilder` and uses `O(n + m)` space, offering no advantage over the brute force approach.

## Conclusion
The **Two-Pointer** approach is recommended for its `O(1)` space complexity and efficiency, making it ideal for production code. The **Brute Force** approach is easier to understand for beginners and still efficient in time (`O(n + m)`), but it uses extra space. Both solutions handle all edge cases correctly, and the provided test cases verify their functionality.

For further exploration, try implementing a stack-based version or testing with extreme cases (e.g., strings with only `#` characters) to deepen understanding. The unrelated code in the `Optimize` class’s main method (`StringBuilder` and `ArrayList`) does not affect the solution but highlights the need to focus on relevant test code.