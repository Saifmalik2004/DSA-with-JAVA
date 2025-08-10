
# Count Homogenous Substrings

## Problem Statement

Given a string `s`, return **the number of homogenous substrings** of `s`.

A **homogenous substring** is a substring where all characters are the same.

Since the answer can be **very large**, return the result **modulo** `10^9 + 7`.

---

## Example 1
**Input:**
```

s = "abbcccaa"

```
**Output:**
```

13

```
**Explanation:**
- `"a"` → 1 substring  
- `"bb"` → `"b"`, `"b"`, `"bb"` → 3 substrings  
- `"ccc"` → `"c"`, `"c"`, `"c"`, `"cc"`, `"cc"`, `"ccc"` → 6 substrings  
- `"aa"` → `"a"`, `"a"`, `"aa"` → 3 substrings  
Total = `1 + 3 + 6 + 3 = 13`.

---

## Example 2
**Input:**
```

s = "zzzzz"

```
**Output:**
```

15

```
**Explanation:**  
String length = 5, all characters same →  
Number of homogenous substrings = `5 * (5 + 1) / 2 = 15`.

---

## Constraints
- `1 <= s.length <= 10^5`
- `s` consists of lowercase English letters only.

---

## Intuition

The naive way would be:
1. Generate **all substrings** of `s`.
2. Check if all characters in each substring are the same.
3. Count them.

But this approach is **too slow** (`O(n^3)` in worst case) because:
- Total substrings = `O(n^2)`
- Checking each substring for homogeneity = `O(n)`

We need something faster.

---

## Key Observation
Homogenous substrings come from **runs of identical characters**.

Example:  
`"aaabb"` → runs are:
- `"aaa"` (length = 3) → contributes `3 * (3 + 1) / 2 = 6`
- `"bb"` (length = 2) → contributes `2 * (2 + 1) / 2 = 3`

**Formula:**  
If a run has length `k`, number of homogenous substrings from it =  
```

k \* (k + 1) / 2

```
This formula comes from the sum of first `k` natural numbers.

---

## Approach 1 — Counting Consecutive Characters (Optimal)

### Steps
1. Initialize:
   - `len` = 1 (current run length)
   - `result` = 1 (first character itself is one substring)
2. Loop through string from index `1` to `n-1`:
   - If current char == previous char → increment `len`
   - Else → reset `len = 1`
   - Add `len` to `result` (because each new character extends some homogenous substrings).
3. Take modulo `1_000_000_007` after each addition.

---

### Dry Run
`s = "abbcccaa"`

| i  | char | prev | len | result (mod) | Explanation                              |
|----|------|------|-----|--------------|------------------------------------------|
| 0  | a    | —    | 1   | 1            | First char                               |
| 1  | b    | a    | 1   | 2            | New run                                  |
| 2  | b    | b    | 2   | 4            | Extends run                              |
| 3  | c    | b    | 1   | 5            | New run                                  |
| 4  | c    | c    | 2   | 7            | Extends run                              |
| 5  | c    | c    | 3   | 10           | Extends run                              |
| 6  | a    | c    | 1   | 11           | New run                                  |
| 7  | a    | a    | 2   | 13           | Extends run                              |

Result = **13** ✅

---

### Pseudocode
```

MOD = 1\_000\_000\_007
result = 1
len = 1

for i from 1 to s.length - 1:
if s\[i] == s\[i - 1]:
len += 1
else:
len = 1
result = (result + len) % MOD

return result

````

---

### Java Implementation
```java
public class Solution {
    public static int countHomogenous(String s) {
        final int MOD = 1_000_000_007;

        int result = 1;
        int len = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                len = 1;
            }
            result = (result + len) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "abbcccaa";
        System.out.println("Input: " + s1);
        System.out.println("Homogeneous substrings count: " + countHomogenous(s1));

        String s2 = "zzzzz";
        System.out.println("Input: " + s2);
        System.out.println("Homogeneous substrings count: " + countHomogenous(s2));

        String s3 = "abc";
        System.out.println("Input: " + s3);
        System.out.println("Homogeneous substrings count: " + countHomogenous(s3));
    }
}
````

---

## Complexity Analysis

* **Time Complexity:** `O(n)` — single pass through the string.
* **Space Complexity:** `O(1)` — only counters used.

---

## Why Modulo is Important Here

Without modulo, the result can exceed integer limits when:

* `s.length` is large (up to `10^5`)
* All characters are same (max substrings ≈ `n*(n+1)/2`)

Example: `"a" * 100000` → `100000 * 100001 / 2 = 5,000,050,000` (overflows `int`).

Modulo ensures numbers stay small and prevent overflow.

---


## Conclusion

* Main trick: Count consecutive same characters and use modulo.
* Avoid generating all substrings — too slow.
* This is a common pattern in problems involving "count special substrings".


