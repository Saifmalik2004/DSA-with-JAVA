# Buddy Strings (LeetCode 859)

## Problem Statement

Given two strings `s` and `goal`, return `true` if you can swap **exactly one pair of characters** in `s` so that the resulting string equals `goal`. Otherwise, return `false`.

* You may swap the characters at two different indices of `s` (i.e., swap `s[i]` and `s[j]`, where `i != j`).
* You can only perform a **single swap** (or none).

### Formal examples

```
Input: s = "ab", goal = "ba"
Output: true
Explanation: Swap s[0] and s[1] -> "ba" equals goal.

Input: s = "ab", goal = "ab"
Output: false
Explanation: No single swap in s will change it to goal. Swapping any two different characters will change the string.

Input: s = "aa", goal = "aa"
Output: true
Explanation: Swapping the two 'a's keeps s the same; because there is at least one repeated character, a swap of two equal letters is allowed and counts as a valid single swap.
```

---

## Constraints & Notes

* `1 <= s.length, goal.length <= 1000`
* `s` and `goal` consist of lowercase letters only (a–z).
* You must perform **at most one** swap; zero swaps count only if `s.equals(goal)` and there exists a duplicate letter in `s` (so swapping the two equal letters is possible and keeps the same string).

---

## Intuition

There are only a few possible scenarios where the answer is `true`:

1. **Exactly two positions differ** between `s` and `goal`, and swapping those two positions in `s` makes it equal to `goal`. Example: `s = "ab"`, `goal = "ba"`.
2. **Strings are already equal** (`s.equals(goal)`), and `s` contains **at least one duplicate character** — because we can swap two equal characters and the string remains the same (a valid single swap). Example: `s = "aa"`, `goal = "aa"`.

Any other situation (zero differences with all characters distinct, or more than two differences) is impossible with exactly one swap.

So we can solve the problem by scanning once and collecting the indices where `s` and `goal` differ.

---

## Approaches

We'll explore two approaches:

1. **Brute-force**: Try all pairs of swaps in `s` and check equality — easy to understand but inefficient.
2. **Linear Scan (Optimal)**: Compare strings once to record the differing indices and apply the conditions above — `O(n)` time.

### Approach 1 — Brute-force (Try all swaps)

**Idea**: For every pair of indices `i < j`, swap `s[i]` and `s[j]` and check if the result equals `goal`.

**Pseudo**:

```
if s.equals(goal):
    return true if s has duplicate letter else false
for i from 0 to n-1:
    for j from i+1 to n-1:
        swap s[i] and s[j]
        if s == goal: return true
        swap back
return false
```

**Complexity**:

* Time: `O(n^2)` swaps, each string equality check is `O(n)` if you create new string, but you can optimize comparison by checking in place; worst-case `O(n^3)` naive, typically `O(n^2)` with in-place checks.
* Space: `O(1)` additional (if you swap in array and swap back).

**Why it fails/when it's bad**:

* `n` can be up to 1000, so `O(n^2)` is still acceptable in many cases, but this approach is unnecessary when a linear scan exists. It's also more cumbersome and error-prone.

### Approach 2 — Linear Scan (Optimal)

**Idea**: Traverse both strings together. Record positions where characters differ.

* If number of differences > 2 → return `false` (one swap cannot fix more than two mismatches).
* If number of differences == 2 → ensure that swapping would fix both: `s[i1] == goal[i2] && s[i2] == goal[i1]`.
* If number of differences == 0 → strings already equal: return `true` only if `s` contains any duplicate character (so we can swap equal chars to satisfy the requirement of "a swap").

**Pseudo**:

```
if s.length != goal.length: return false
if s.equals(goal):
    return true if any character appears more than once in s
diffs = []
for i in 0..n-1:
    if s[i] != goal[i]: diffs.append(i)
if len(diffs) != 2: return false
i1, i2 = diffs[0], diffs[1]
return s[i1] == goal[i2] and s[i2] == goal[i1]
```

**Complexity**:

* Time: `O(n)` — single pass to collect differences (and possibly another pass to check duplicates in the equal case).
* Space: `O(1)` — we only store up to two indices and a small frequency array.

**Why it works**:

* A single swap can change at most two positions. If more than two positions differ, impossible. If exactly two differ, those two must be complementary.
* If none differ but there's a repeated character, swapping two equal characters counts as a valid swap and keeps the string the same.

---

## Worked Examples & Visuals

**Example 1**: `s = "ab", goal = "ba"`

Differences at positions `[0, 1]`. Check `s[0] == goal[1]` (`'a' == 'a'`) and `s[1] == goal[0]` (`'b' == 'b'`) → `true`.

**Example 2**: `s = "aa", goal = "aa"`

No differences (`diffs.size() == 0`). Check duplicates in `s` — `'a'` appears more than once → `true`.

**Example 3**: `s = "abcd", goal = "acbd"`

Diffs at positions `[1,2]`: `s[1]='b'`, `s[2]='c'`, `goal[1]='c'`, `goal[2]='b'` → complements → `true`.

**Example 4**: `s = "abc", goal = "def"`

> More than 2 differences -> `false`.

**Diagram (swap idea)**

```
 s:  a  b  c  d
 g:  a  d  c  b
 diffs at idx 1 and 3
 swap s[1] and s[3] => a d c b == goal
```

---

## Correct and Robust Java Implementations

### 1) Optimal (Linear scan) — Recommended

```java
public class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;

        // Case 1: strings are identical
        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
                if (freq[c - 'a'] > 1) return true; // we can swap two equal chars
            }
            return false; // all chars unique, cannot perform a swap that leaves the string unchanged
        }

        // Case 2: strings differ
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) first = i;
                else if (second == -1) second = i;
                else return false; // more than two differences
            }
        }

        // Must have exactly two differences and they must be cross-equal
        return (second != -1
                && s.charAt(first) == goal.charAt(second)
                && s.charAt(second) == goal.charAt(first));
    }

    // Example quick tests
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.buddyStrings("ab", "ba")); // true
        System.out.println(sol.buddyStrings("ab", "ab")); // false
        System.out.println(sol.buddyStrings("aa", "aa")); // true
        System.out.println(sol.buddyStrings("aaaaaaabc", "aaaaaaacb")); // true
        System.out.println(sol.buddyStrings("abc", "abc")); // false
    }
}
```

### 2) Brute-force (for understanding / small inputs only)

```java
public class BruteForce {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        // If strings already equal, check duplicates
        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                if (++freq[c - 'a'] > 1) return true;
            }
            return false;
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(arr, i, j);
                if (String.valueOf(arr).equals(goal)) return true;
                swap(arr, i, j); // swap back
            }
        }
        return false;
    }

    private void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
```

---

## Common Bugs & Pitfalls (and how to fix them)

1. **Not handling the `s.equals(goal)` case correctly**

   * If both strings are identical, the answer is `true` *only* when `s` contains any duplicate character. Forgetting this rule leads to wrong answers.

2. **Accessing uninitialized indices when there aren't exactly two diffs**

   * In user code (posted above), the loop stores differing indices into `idx[0], idx[1]` but then directly accesses them without verifying that two differences were found. Always confirm `count == 2` before using both indices.

3. **Using while loops with two pointers unnecessarily**

   * The natural approach is a single `for` loop comparing `s.charAt(i)` and `goal.charAt(i)`. Using `i` and `j` in parallel without a careful stopping condition can cause off-by-one or skipped comparisons.

4. **Assuming only letters a-z**

   * The problem statement restricts to lowercase letters; if input domain changes, make frequency arrays more general or use `HashMap`.

5. **Misunderstanding "single swap" when `s.equals(goal)`**

   * Some think `s.equals(goal)` always returns `true`, but the problem requires being able to perform a swap — swapping two equal characters is the only way to keep the string unchanged.

---

## Time & Space Complexity Summary

|                    Approach |                   Time                  |          Space         |
| --------------------------: | :-------------------------------------: | :--------------------: |
| Brute-force (try all swaps) | `O(n^2)` (swap loops) + equality checks | `O(1)` (in-place swap) |
|       Optimal (linear scan) |                  `O(n)`                 |         `O(1)`         |

`n` is the length of the strings.

---

## Additional Exercises / Variations

1. **Allow multiple swaps**: If you are allowed *any* number of swaps, the problem reduces to checking if the multiset of characters in `s` equals that of `goal`.
2. **Minimum number of swaps to transform `s` into `goal`**: Compute the minimum number of swaps of arbitrary positions needed to transform `s` into `goal` (string permutations / graph cycles problem).
3. **General alphabet / Unicode**: Extend the solution to handle general Unicode characters. Use `Map<Character, Integer>` for frequency.

---

## Conclusion

Buddy Strings is a clean puzzle that tests string comparison logic and edge-case handling. The efficient solution is a single pass to collect differing indices and a small frequency check for the special equal-case. The logic is simple, and attention to corner cases yields a compact and correct implementation.

