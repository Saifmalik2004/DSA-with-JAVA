Of course! Here’s a well-structured, professional-grade `README.md` covering the **Restore IP Addresses** problem, following a complete and educational style suitable for interviews or study.

---

# Restore IP Addresses

## Problem Statement

Given a string `s` containing only digits, return all possible valid IP addresses that can be formed by inserting three dots `.` into the string. You cannot reorder or remove any digits from `s`. A valid IP address consists of exactly four integers (each between 0 and 255) separated by dots, and cannot have leading zeros (except for zero itself).

**Example:**

```
Input: s = "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
```

---

## Constraints

* Length of `s` is between 1 and 20.
* All characters in `s` are digits (0–9).
* The IP address must use all characters of `s` exactly once.

---

## Intuition

Think of an IP address as **4 segments** separated by dots:

```
segment1.segment2.segment3.segment4
```

Each segment:

* must be between 0 and 255
* cannot have leading zeros if the segment has more than one digit (e.g. “01” is invalid)

So our task is to **partition the string** into 4 parts that satisfy these rules.

Since each segment can have **1 to 3 digits**, we can backtrack by trying all possible splits recursively:

* take 1 digit
* take 2 digits
* take 3 digits

and continue until we have 4 segments. If we used up all characters in `s` exactly, then it is a valid IP address.

This is a classic **backtracking** problem with pruning.

---

## Visual Example

For the input string:

```
"25525511135"
```

Possible segmentations:

```
255 . 255 . 11 . 135
255 . 255 . 111 . 35
```

are valid because:

* each segment is in 0–255
* no leading zeros
* exactly 4 segments

---

## Approach 1: Backtracking

We can use a recursive function that:

1. Tracks the current index in the string
2. Tracks how many parts of the IP address we have chosen so far
3. Builds up the current working IP address
4. Once we have 4 parts, check if all characters have been used — if so, add to the answer.

**Pruning conditions:**

* If you already picked 4 segments but still have characters left → invalid, return
* If you run out of characters before getting 4 segments → invalid, return
* If a segment is out of range or has leading zeros → skip

---

## Pseudocode

```plaintext
function backtrack(s, idx, parts, curr):
    if parts == 4 and idx == len(s):
        add curr to result (after removing trailing dot)
        return
    if parts > 4 or idx >= len(s):
        return
    
    for len in 1..3:
        if idx + len > len(s): break
        segment = s[idx : idx + len]
        if segment is valid:
            backtrack(s, idx+len, parts+1, curr + segment + ".")
```

**Segment Validity Check:**

* length > 1 and starts with '0' → invalid
* numeric value > 255 → invalid

---

## Code (Java)

```java
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, "", res);
        return res;
    }

    private void backtrack(String s, int idx, int parts, String curr, List<String> res) {
        if (parts == 4 && idx == s.length()) {
            res.add(curr.substring(0, curr.length() - 1)); // remove last dot
            return;
        }

        if (parts > 4 || idx >= s.length()) return;

        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            String segment = s.substring(idx, idx + len);
            if (isValid(segment)) {
                backtrack(s, idx + len, parts + 1, curr + segment + ".", res);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}
```

---

## Time Complexity

* There are **at most 3 choices** for each of 4 segments → **O(3^4) = O(81)**
* Each path takes **O(n)** to copy substrings and add to results
* So total is approximately **O(81 \* n) = O(n)** since 81 is constant

Hence, the solution is very efficient and acceptable for `s` of length up to 20.

---

## Space Complexity

* The recursion depth is at most 4
* Result list will store at most a few dozen addresses
* Overall space: **O(1) auxiliary stack**, plus **O(k)** for result storage

---

## Why This Approach Works

✅ systematically tries all possible segmentations
✅ backtracking **prunes** impossible partial paths early
✅ valid segments checked strictly (no leading zeros, ≤255)
✅ uses recursion in a clean, readable way

---

## Why Other Approaches Fail

* **Greedy algorithms** cannot work here because you might need to revisit earlier choices to get valid segments.
  For example, if you greedily take “255” first, you might miss smaller segments later that yield a better result.
* **Dynamic Programming** is overkill because there are no overlapping subproblems, just one exploration tree of choices.

Hence, **backtracking** is the most natural and correct strategy.

---

## Interviewer Tips

* Always talk about **constraints** (0–255, no leading zeros)
* Use an example to demonstrate pruning
* Mention **backtracking with segment validation** as your first thought
* Write clean, readable code with meaningful variable names

---

## References

* LeetCode 93: Restore IP Addresses
* Backtracking template
* Network addressing standards (RFC 791 for IPv4)

---


## 🌳 Tree Visual: Dry Run for `"25525511135"`

Let’s build a tree where each level represents one **segment** (1st, 2nd, 3rd, 4th).
We’ll try different lengths (1 to 3) from the current index `idx`.

We'll abbreviate each node as:

```
(segment) [idx -> new idx]
```

We'll build up the current path with segments separated by `.`

---

### Step-by-step Dry Run:

### 🔹 Start:

```
idx = 0, parts = 0, curr = ""
```

We explore segments of 1 to 3 characters from index 0.

---

### Level 1 (Segment 1)

We try:

* `"2"`  → valid ✅
* `"25"` → valid ✅
* `"255"` → valid ✅

So we now have 3 branches:

```
"2."      [0 → 1]
"25."     [0 → 2]
"255."    [0 → 3]
```

---

Let’s explore `"255."` (valid IP start)

---

### Level 2 (Segment 2)

From index 3:

Try:

* `"2"` → valid
* `"25"` → valid
* `"255"` → valid

Branches from `"255."`:

```
"255.2."     [3 → 4]
"255.25."    [3 → 5]
"255.255."   [3 → 6]
```

Let's go with `"255.255."` (most promising)

---

### Level 3 (Segment 3)

From index 6:

Try:

* `"1"` → valid
* `"11"` → valid
* `"111"` → valid

So:

```
"255.255.1."     [6 → 7]
"255.255.11."    [6 → 8]
"255.255.111."   [6 → 9]
```

Let’s try `"255.255.11."`

---

### Level 4 (Segment 4)

From index 8:

Try:

* `"1"` → valid
* `"13"` → valid
* `"135"` → valid

Try `"135"` → goes till end (index 11 = length of input)

✅ Valid address:

```
"255.255.11.135"
```

---

Let’s also follow the path:

* `"255.255.111.35"` → from:

  * segment1: `"255"`
  * segment2: `"255"`
  * segment3: `"111"`
  * segment4: `"35"`

Also valid!

---

### 🌳 Tree Summary Diagram

```plaintext
                          [ ]
              /           |           \
         [2.]          [25.]        [255.]
                      / | \           / | \
                ...         ...   [255.2.] [255.25.] [255.255.]
                                               /     |      \
                                      [255.255.1.] [255.255.11.] [255.255.111.]
                                                 \           \           \
                                        [..1.135]  ✅      [..111.35] ✅
```

✅ Final valid IPs found:

* `255.255.11.135`
* `255.255.111.35`

---

## ✅ Quick Summary of Dry Run

| Step | Segment Path   | Status          |
| ---- | -------------- | --------------- |
| 1    | 255            | valid           |
| 2    | 255.255        | valid           |
| 3    | 255.255.11     | valid           |
| 4    | 255.255.11.135 | ✅ valid IP      |
| 3'   | 255.255.111    | valid           |
| 4'   | 255.255.111.35 | ✅ valid IP      |
| …    | others         | invalid/skipped |

---

## ✅ Key Learnings

* Each level of the recursion tree adds one segment.
* Each node tries 1 to 3 characters (if within range).
* Pruning is key:

  * if segment is invalid
  * if more than 4 segments
  * if not enough characters left

---
