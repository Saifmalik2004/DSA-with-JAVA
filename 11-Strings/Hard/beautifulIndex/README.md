# README.md: Beautiful Indices Problem

## Problem Description

Given a string `s` and two patterns `a` and `b`, find all indices `i` in `s` where:

* Pattern `a` starts at index `i`.
* There exists an index `j` where pattern `b` starts, and the absolute difference `|i - j|` is at most `k`.

These indices are called **"beautiful indices."** Return them in a sorted list.

---

### Key Details

* **Input:**

  * `s`: The main string to search in.
  * `a`: The first pattern to find in `s`.
  * `b`: The second pattern to find in `s`.
  * `k`: A non-negative integer for the maximum allowed distance between indices.
* **Output:**
  A list of indices `i` where `a` starts, and there’s at least one index `j` where `b` starts such that `|i - j| <= k`.
* **Constraints:**

  * `1 <= s.length <= 10^5`
  * `1 <= a.length, b.length <= 10`
  * `0 <= k <= 10^5`
  * All strings contain only lowercase English letters.

---

### Examples

#### Example 1

**Input:**

```text
s = "isawsquirrelnearmysquirrelhouseohmy"
a = "my"
b = "squirrel"
k = 15
```

**Output:** `[16, 33]`
**Explanation:**

* `"my"` appears at indices `[16, 33]`.
* `"squirrel"` appears at indices `[4, 21]`.
* For `i = 16`: closest `b = 21`, `|16 - 21| = 5 <= 15`.
* For `i = 33`: closest `b = 21`, `|33 - 21| = 12 <= 15`.

#### Example 2

**Input:**

```text
s = "abcd"
a = "a"
b = "b"
k = 4
```

**Output:** `[0]`
**Explanation:**

* `"a"` starts at `0`, `"b"` starts at `1`, and `|0 - 1| = 1 <= 4`.

---

## Intuition

1. Find all starting indices of `a` in `s`.
2. Find all starting indices of `b` in `s`.
3. For each index `i` of `a`, check if there exists a `b` index `j` such that `|i - j| <= k`.

We use **KMP (Knuth–Morris–Pratt)** to efficiently find all occurrences of patterns and a **two-pointer approach** to check distances efficiently.

---

## Approach: KMP + Two-Pointer Search

1. Use `kmpSearch` to find all starting indices of `a` → `indicesA`.
2. Use `kmpSearch` to find all starting indices of `b` → `indicesB`.
3. For each `i` in `indicesA`:

   * Move through `indicesB` with a pointer to find a `j` where `|i - j| <= k`.
   * If found, add `i` to the result list.
4. Return the sorted result list.

---

## Java Code (Optimized KMP)

```java
import java.util.*;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> indicesA = kmpSearch(s, a);
        List<Integer> indicesB = kmpSearch(s, b);
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
                if (indicesB.get(right) - aIndex <= k) {
                    res.add(aIndex);
                    found = true;
                }
                right++;
            }
        }

        return res;
    }

    // Clean & optimized KMP search
    private List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length(), m = pattern.length();
        int[] lps = buildLps(pattern);
        int i = 0, j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
            }

            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }

        return result;
    }

    // Build LPS array
    private int[] buildLps(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0, i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
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

---

## Why It Works

* **KMP Algorithm:** Finds all occurrences in `O(n + m)` time.
* **Two-Pointer Search:** Efficiently checks distances without redundant comparisons.
* **Efficient:** Works for large `s` (up to `10^5`) and small patterns.

---

## Complexity

| Type  | Complexity       |          |   |          |           |
| ----- | ---------------- | -------- | - | -------- | --------- |
| Time  | `O(n + m1 + m2 + | indicesA | + | indicesB | ) ≈ O(n)` |
| Space | `O(m1 + m2 + n)` |          |   |          |           |

Where `m1 = a.length`, `m2 = b.length`, `n = s.length`.

---

## Edge Cases

* Empty `indicesA` or `indicesB` → return `[]`.
* `k = 0` → only indices where `a` and `b` start together.
* Large `s` → handled efficiently with KMP.
* Small patterns → length 1–10 works fine.
* No overlap → returns empty list.

---
