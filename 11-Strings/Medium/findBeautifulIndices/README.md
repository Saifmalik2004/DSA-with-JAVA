
# 🌸 Beautiful Indices in a String

## 📝 Problem Statement

You are given:

* A string `s`
* Two substrings `a` and `b`
* An integer `k`

We say that an index `i` in `s` is **beautiful** if:

1. Substring `a` starts at index `i` in `s`.
2. There exists some index `j` where substring `b` starts, such that:

$$
|i - j| \leq k
$$

👉 Return all beautiful indices in **ascending order**.

---

## 🔍 Example

### Example 1

```
s = "abcdeabcxyabc"
a = "abc"
b = "xy"
k = 2
```

* `a` occurs at indices: `[0, 5, 10]`
* `b` occurs at index: `[8]`

Check each `a`:

* At `i=0` → nearest `b=8`, but |0-8|=8 > k → ❌ not beautiful
* At `i=5` → nearest `b=8`, |5-8|=3 > k → ❌ not beautiful
* At `i=10` → nearest `b=8`, |10-8|=2 ≤ k → ✅ beautiful

✅ Answer = `[10]`

---

## 🧠 Intuition

1. First, we need to **find all occurrences of `a` and `b` in `s`**.

   * Naive searching for every index would be **O(n·m)** and too slow for large inputs.
   * Instead, we use the **KMP (Knuth–Morris–Pratt) algorithm** which finds all occurrences of a substring in **O(n + m)**.

2. Once we have all indices where `a` occurs (`iIdx`) and where `b` occurs (`jIdx`), the problem reduces to:

   * For each `i ∈ iIdx`, check if there exists a `j ∈ jIdx` such that `|i - j| ≤ k`.

3. To check efficiently:

   * Notice `jIdx` is sorted (because KMP finds matches in left-to-right order).
   * We can use **binary search (lower bound)** to find the smallest index in `jIdx` that is ≥ `i - k`.
   * Then check if that candidate `j` is ≤ `i + k`.

This avoids scanning all of `jIdx` for each `i`.

---

## ✨ Approach (Step by Step)

1. **Build LPS array** for `a` (used in KMP).
2. **Run KMP** on `s` with `a` → get list of starting indices of `a`.
3. **Run KMP** on `s` with `b` → get list of starting indices of `b`.
4. For each index `i` in `a`’s indices:

   * Compute search window `[i-k, i+k]`.
   * Use **binary search** to find the smallest `j ≥ i-k`.
   * If such `j` exists and `j ≤ i+k`, mark `i` as a beautiful index.
5. Collect all such `i` and return them.

---

## 📑 Pseudocode

```
function beautifulIndices(s, a, b, k):
    iIdx = KMP(a, s)   // indices of a
    jIdx = KMP(b, s)   // indices of b
    
    res = []
    for each i in iIdx:
        leftLim  = i - k
        rightLim = i + k
        lowerIdx = lowerBound(jIdx, leftLim)  // binary search
        
        if lowerIdx < len(jIdx) and jIdx[lowerIdx] <= rightLim:
            res.add(i)
    return res
```

---

## 💻 Java Solution

```java
import java.util.*;

class Solution {
    // Compute LPS (Longest Prefix Suffix) for KMP
    public void computeLPS(String pat, int[] lps) {
        int m = pat.length();
        int len = 0;
        lps[0] = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // KMP to find all occurrences of 'pat' in 'text'
    public List<Integer> KMP(String pat, String text) {
        int n = text.length();
        int m = pat.length();
        List<Integer> res = new ArrayList<>();
        int[] lps = new int[m];

        computeLPS(pat, lps);

        int i = 0, j = 0;
        while (i < n) {
            if (pat.charAt(j) == text.charAt(i)) {
                i++; j++;
                if (j == m) {
                    res.add(i - j);  // match found
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return res;
    }

    // Binary search (lower bound)
    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1, result = list.size();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // Main function
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n = s.length();
        List<Integer> iIdx = KMP(a, s);
        List<Integer> jIdx = KMP(b, s);

        List<Integer> res = new ArrayList<>();
        for (int i : iIdx) {
            int leftLim = Math.max(0, i - k);
            int rightLim = Math.min(n - 1, i + k);

            int lowerIdx = lowerBound(jIdx, leftLim);
            if (lowerIdx < jIdx.size() && jIdx.get(lowerIdx) <= rightLim) {
                res.add(i);
            }
        }
        return res;
    }
}
```

---

## 🧑‍💻 Dry Run

Input:

```
s = "abcdeabcxyabc"
a = "abc"
b = "xy"
k = 2
```

* `iIdx = [0, 5, 10]`
* `jIdx = [8]`

Check each `i`:

* i=0 → left=0, right=2 → nearest b=8 (too far) ❌
* i=5 → left=3, right=7 → nearest b=8 (too far) ❌
* i=10 → left=8, right=12 → nearest b=8 (valid) ✅

✅ Output = `[10]`

---

## 📊 Complexity Analysis

* **KMP for a:** O(n + m₁)

* **KMP for b:** O(n + m₂)

* **Binary search per `i`:** O(log |jIdx|)

* Total:

  $$
  O(n + m₁ + m₂ + |iIdx| \cdot \log |jIdx|)
  $$

* **Space Complexity:**

  * LPS array: O(m)
  * Indices lists: O(|iIdx| + |jIdx|)

---

## ✅ Key Takeaways

* Use **KMP** for efficient substring search (O(n + m)).
* Use **binary search** to quickly find nearby indices instead of scanning all.
* Combination makes the solution efficient even for large inputs.

---
