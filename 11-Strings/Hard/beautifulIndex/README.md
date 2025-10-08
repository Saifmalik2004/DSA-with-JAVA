
# README.md: Beautiful Indices Problem

## Problem Description

Given a string `s` and two patterns `a` and `b`, find all indices `i` in `s` where:

* Pattern `a` starts at index `i`.
* There exists an index `j` where pattern `b` starts, and the absolute difference `|i - j|` is at most `k`.

These indices are called **"beautiful indices."** Return them in a sorted list.

---

### Key Details

* **Input**:

  * `s`: The main string to search in.
  * `a`: The first pattern to find in `s`.
  * `b`: The second pattern to find in `s`.
  * `k`: A non-negative integer for the maximum allowed distance between indices.
* **Output**:
  A list of indices `i` where `a` starts, and there’s at least one index `j` where `b` starts such that `|i - j| <= k`.
* **Constraints**:

  * `1 <= s.length <= 10^5`
  * `1 <= a.length, b.length <= 10`
  * `0 <= k <= 10^5`
  * All strings contain only lowercase English letters.

---

### Examples

#### Example 1

**Input:**
`s = "isawsquirrelnearmysquirrelhouseohmy"`, `a = "my"`, `b = "squirrel"`, `k = 15`
**Output:** `[16, 33]`
**Explanation:**

* `"my"` appears at indices `16` and `33`.
* `"squirrel"` appears at indices `4` and `21`.
* For `i = 16`, `|16 - 21| = 5 <= 15`.
* For `i = 33`, `|33 - 21| = 12 <= 15`.

#### Example 2

**Input:**
`s = "abcd"`, `a = "a"`, `b = "b"`, `k = 4`
**Output:** `[0]`
**Explanation:**
`"a"` starts at `0`, `"b"` starts at `1`, and `|0 - 1| = 1 <= 4`.

---

## Intuition

To find beautiful indices:

1. Find all starting indices of pattern `a` in `s`.
2. Find all starting indices of pattern `b` in `s`.
3. For each index `i` where `a` starts, check if there exists an index `j` where `b` starts such that `|i - j| <= k`.

Since naive string searching would be too slow for large strings, we use the **KMP (Knuth–Morris–Pratt) algorithm** to efficiently find all pattern occurrences.
Then we use a **two-pointer approach** to find indices satisfying the distance condition.

---

## Approach: KMP + Two-Pointer Search

The solution uses KMP to locate all occurrences of `a` and `b` in `s`, and a two-pointer method to check distance efficiently.

### Steps:

1. **Convert Strings to Character Arrays** for faster processing.
2. **Find Indices Using KMP**:

   * Use `kmp` to find all starting indices of `a` → `indicesA`.
   * Use `kmp` to find all starting indices of `b` → `indicesB`.
3. **Check Distance Using Two Pointers**:

   * For each index `i` in `indicesA`, move through `indicesB` to find a `j` such that `|i - j| <= k`.
   * If found, add `i` to the result list.
4. **Return the Result List**.

---

## Java Code

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
            int right = j;
            while (!found && right < indicesB.size() && indicesB.get(right) <= aIndex + k) {
                if (Math.abs(indicesB.get(right) - aIndex) <= k) {
                    res.add(aIndex);
                    found = true;
                }
                right++;
            }
        }

        return res;
    }

    private List<Integer> kmp(char[] s, char[] pattern) {
        int[] lps = computeLps(pattern);
        List<Integer> res = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < s.length; i++) {
            while (j > 0 && s[i] != pattern[j]) {
                j = lps[j - 1];
            }
            if (s[i] == pattern[j]) {
                j++;
            }
            if (j == pattern.length) {
                res.add(i - j + 1);
                j = lps[j - 1];
            }
        }
        return res;
    }

    private int[] computeLps(char[] pattern) {
        int[] lps = new int[pattern.length];
        int len = 0;
        int i = 1;

        while (i < pattern.length) {
            if (pattern[i] == pattern[len]) {
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

---

## Why It Works

* **KMP Algorithm:** Finds all occurrences of `a` and `b` in `O(n + m)` time.
* **Two-Pointer Search:** Avoids redundant comparisons by efficiently tracking the nearest `b` indices for each `a`.
* **Efficiency:** Both steps combined ensure near-linear performance even for large strings.

---

## Complexity Analysis

| Type      | Complexity       |          |   |          |           |
| --------- | ---------------- | -------- | - | -------- | --------- |
| **Time**  | `O(n + m1 + m2 + | indicesA | + | indicesB | )`≈`O(n)` |
| **Space** | `O(m1 + m2 + n)` |          |   |          |           |

Where:

* `m1 = a.length`, `m2 = b.length`, `n = s.length`.

---

## Example Walkthrough

**Input:**
`s = "isawsquirrelnearmysquirrelhouseohmy"`, `a = "my"`, `b = "squirrel"`, `k = 15`

* KMP finds `"my"` at `[16, 33]`.
* KMP finds `"squirrel"` at `[4, 21]`.

Checking each `a` index:

* For `i = 16`: closest `b = 21`, `|16 - 21| = 5 <= 15`.
* For `i = 33`: closest `b = 21`, `|33 - 21| = 12 <= 15`.

✅ Output: `[16, 33]`

---

## Edge Cases

| Case                           | Description                                   | Expected Behavior  |
| ------------------------------ | --------------------------------------------- | ------------------ |
| Empty `indicesA` or `indicesB` | Pattern not found                             | Return `[]`        |
| `k = 0`                        | Only indices where `a` and `b` start together | Works fine         |
| Large `s`                      | Up to `10^5` characters                       | Efficient with KMP |
| Small patterns                 | Length 1–10                                   | Handles correctly  |
| No overlap                     | Patterns far apart                            | Returns empty list |

---

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
