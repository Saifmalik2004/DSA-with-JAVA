# Decoded String at Index — Problem Explanation (LeetCode 880)

This README explains the problem **"Decoded String at Index"** (LeetCode 880) in depth. It covers the problem statement, intuition, multiple approaches (with detailed step-by-step reasoning), pseudocode, working Java implementations (both naive and optimal), complexity analysis, common pitfalls, and additional exercises.

---

# Problem Statement

You are given an encoded string `s`. The encoding rule is: `k[encoded_string]` — but in this simplified version (LeetCode 880) the encoding is given as a sequence of letters and digits where a digit `d` means "repeat everything decoded so far `d` times".

More precisely:

* The encoded string `s` is formed by lowercase letters and digits `2`..`9`.
* When a digit `d` appears, it means take the current decoded string and repeat it `d` times (concatenate it `d` times). This expands the decoded string.

You are given an integer `k`. Return the `k`-th letter (1-indexed) in the decoded string without actually building the whole decoded string (because it may become extremely large).

---

# Examples

**Example 1**

```
Input: s = "leet2code3", k = 10
Output: "o"
Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode". The 10th character is 'o'.
```

**Example 2**

```
Input: s = "ha22", k = 5
Output: "h"
Explanation: Decoded string: "hahahaha". 5th character is 'h'.
```

**Example 3**

```
Input: s = "a2345678999999999999999", k = 1
Output: "a"
Explanation: Decoded string is huge; still the first char is 'a'.
```

---

# Constraints & Notes

* `1 <= s.length <= 100` (encoded string length is small), but the decoded string length can be extremely large (sometimes exceeding $10^9$ or more) due to repetition.
* `s` contains only lowercase letters and digits `2` through `9`.
* `k` is a 1-based index (k starts from 1).
* Building the full decoded string will usually cause memory/time issues; we must avoid actual expansion.

---

# Intuition

The key is to **track the length** of the decoded string as we scan the encoded string (without actually constructing it). After we know the final decoded length, we can work *backwards* to figure out which original character corresponds to the `k`-th position.

Why backwards? Because digits repeat the prefix. If we know the final length `L` and we see a digit `d` that expanded a previous prefix of length `preLen` into `preLen * d`, the `k`-th character in the expanded string maps to a position inside the prefix. Using modular arithmetic we can map `k` back into the prefix. Doing this from right-to-left lets us peel off layers of repetition until we land on a letter.

This avoids building the decoded string and runs in linear time in the length of the encoded string.

---

# Approaches

We'll cover two approaches:

1. **Brute-force (explicit decoding)** — easy to implement but fails for large expansions (OOM / TLE).
2. **Optimized reverse-tracking** — the correct, efficient approach that runs in O(n) time and O(1) extra space.

## Approach 1 — Brute-force (explicitly build the decoded string)

**Idea**: Iterate over `s`. For letters, append to a `StringBuilder`. For digit `d`, take the current decoded string and append it `d-1` more times.

**Why it fails**: The decoded string can grow exponentially with repeated digits. Even for small `s` the expanded string can be huge (billions of chars) and will not fit in memory — you will get OutOfMemoryError or Time Limit Exceeded.

**Complexity**:

* Time: Potentially `O(decoded_length)` which can be enormous.
* Space: `O(decoded_length)` which can be enormous.

**Illustration**:

```
Input: "a2b2c2..." -> "aa" -> "aabbaa..." -> grows fast
```

**Brute-force Java (for demonstration only, DO NOT USE in production/contest)**

```java
// Demonstration: will fail for large inputs
public class BruteForceDecoder {
    public String decodeFully(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(ch);
            } else { // digit
                int times = ch - '0';
                String current = sb.toString();
                for (int t = 1; t < times; t++) {
                    sb.append(current);
                }
            }
            // Danger: sb length may explode
        }
        return sb.toString();
    }
}
```

This is useful to **understand** the decoding but not to solve the problem under constraints.

---

## Approach 2 — Reverse-tracking (Optimal)

**Key idea**: We do two passes.

1. **Forward pass**: compute the total length `size` of the decoded string *without constructing it*.

   * For a letter, `size += 1`.
   * For a digit `d`, `size *= d`.
     Use a `long` to store `size` because it can exceed `int`.

2. **Backward pass**: iterate the encoded string from right to left, and keep reducing `k` relative to `size`.

   For each character `ch` at position `i` (from right to left):

   * Set `k = k % size`. (This maps `k` into the range of `[0, size-1]` corresponding to indices in the current `size`-length string.)
   * If `k == 0` and `ch` is a **letter**, then `ch` is the answer.
   * If `ch` is a digit `d`, then the expanded size was `size / d` before repetition, so set `size = size / d`.
   * If `ch` is a letter and `k != 0`, then the letter corresponds to some position; decrement `size` by 1 and continue.

**Why does this work?**

* Suppose after processing up to index `i` in the forward pass, the decoded length is `size_i` (the current total). When we encounter a digit `d`, the final size becomes `size_i * d`. Any position `k` in the final string that lies in this repeated block can be mapped back to the prefix using `k % size_i` (if `k % size_i == 0` then it maps to the last char of the prefix). Working backwards we remove the effect of the repetition layer-by-layer.

**Pseudocode**:

```
size = 0
for ch in s:
    if ch is letter:
        size += 1
    else: // digit
        size *= (ch - '0')

for i from s.length-1 down to 0:
    ch = s[i]
    k = k % size
    if k == 0 and ch is letter:
        return ch
    if ch is digit:
        size = size / (ch - '0')
    else:
        size -= 1

return "" // (should never happen with valid input)
```

**Important Implementation Details**:

* Use `long` for `size` because repeated multiplication can exceed `int`.
* `k` is 1-based, and using `k % size` produces a value in `[0, size-1]`. The value `0` represents the last character of the (current) prefix.
* The backward loop will always produce an answer because the string contains letters and `k` is valid.

**Complexity**:

* Time: `O(n)` where `n = s.length()` (we do two passes over `s`).
* Space: `O(1)` extra space (just counters and indices).

**Correctness sketch**:

* Forward pass correctly computes the final decoded length.
* Backward pass maintains the invariant that `k` points to the correct position in the currently-considered prefix. When we see a digit we shrink the problem (undo repetition). When we see a letter and `k == 0`, that letter is the desired char.

---

# Worked Example (step-by-step)

Let's dry-run `s = "leet2code3"`, `k = 10`.

1. Forward pass to compute `size`:

* l -> size = 1
* e -> size = 2
* e -> size = 3
* t -> size = 4
* 2 -> size = 8 (4 \* 2)
* c -> size = 9
* o -> size = 10
* d -> size = 11
* e -> size = 12
* 3 -> size = 36 (12 \* 3)

Final size = 36

2. Backward pass:

Start with `k = 10`, `size = 36`.

* i points to '3' (digit): k = 10 % 36 = 10 -> size = 36 / 3 = 12
* i points to 'e': k = 10 % 12 = 10 -> k != 0 and it's a letter -> size = 11
* i points to 'd': k = 10 % 11 = 10 -> size = 10
* i points to 'o': k = 10 % 10 = 0 -> since k == 0 and 'o' is letter -> return "o"

Answer: "o"

The backward mapping shows index 10 mapped to the 10th char inside the 12-length prefix before final `3` expansion, which eventually maps to 'o'.

---

# Java Implementations

## Optimal (Recommended) — Reverse-tracking

```java
public class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        // 1. Compute the size of the fully decoded string
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                size *= (ch - '0');
            } else {
                size += 1;
            }
        }

        // 2. Walk the string backwards to find the k-th character
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            k %= size; // map k to current size

            if (k == 0 && Character.isLetter(ch)) {
                return Character.toString(ch);
            }

            if (Character.isDigit(ch)) {
                size /= (ch - '0');
            } else {
                size -= 1;
            }
        }

        return ""; // should not reach here for valid inputs
    }

    // Optional: quick main for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.decodeAtIndex("leet2code3", 10)); // o
        System.out.println(sol.decodeAtIndex("ha22", 5)); // h
        System.out.println(sol.decodeAtIndex("a2345678999999999999999", 1)); // a
    }
}
```

## Brute-force (Only for learning/demonstration — not usable for large inputs)

```java
public class BruteSolution {
    // Danger: this may cause OutOfMemoryError or TLE for large expansions
    public String decodeAtIndex(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(ch);
            } else {
                int times = ch - '0';
                String cur = sb.toString();
                for (int t = 1; t < times; t++) {
                    sb.append(cur);
                    if (sb.length() > 1_000_000) break; // safety guard for demo
                }
            }
        }
        return sb.length() >= k ? String.valueOf(sb.charAt(k - 1)) : "";
    }
}
```

---

# Time & Space Complexity

**Optimal solution (reverse-tracking)**

* **Time complexity**: `O(n)` where `n = s.length()` (one forward pass + one backward pass)
* **Space complexity**: `O(1)` extra space (we only use counters and indices)

**Brute-force solution**

* **Time complexity**: `O(decoded_length)` (can be astronomically large)
* **Space complexity**: `O(decoded_length)` (not feasible)

---

# Edge Cases & Common Pitfalls

1. **1-based `k`**: The problem uses 1-based indexing. Handle `k` accordingly. The `% size` trick works with 1-based as shown.
2. **Use `long` for `size`**: `int` will overflow for repeated multiplications. Use `long`.
3. **k % size == 0 case**: If `k % size == 0` and the current char is a letter, that letter is the answer (it maps to the last char of the unexpanded prefix).
4. **Sequence of digits**: Digits can appear multiple times; we always divide `size` by the digit when unwinding.
5. **Do not build full decoded string**: This is the single most common mistake — trying to expand the string will fail on larger test cases.

---

# Why the Reverse Approach Is Intuitive (A Short Proof Sketch)

Let `prefix` be the decoded string produced after handling characters up to index `i`. If the next character is digit `d`, the new decoded result is `prefix` repeated `d` times, i.e. `prefix + prefix + ...` (d times). The final positions are arranged in blocks of length `|prefix|`.

Given a target index `k` in this expanded string, it must lie inside one of those `d` blocks. The position within the block is `k mod |prefix|` (with 0 meaning the last position). Thus, `k` in the expanded string maps back to `k % |prefix|` in the prefix. Working from the final full size backwards, we can repeatedly map `k` back until we land on a single letter.

This mapping is why `k %= size` and shrink `size` by undoing the last operation correctly identifies the letter.

---

# Tests & Validation

Use the following variety of tests when validating your solution:

* Simple: `"abc"`, `k=1`, `k=2`, `k=3`.
* Small repeats: `"a2b2"`, various `k` values.
* Large repeat chain: `"a2345678999999999999999"` (ensures you used `long`).
* Mixed letters/digits: `"leet2code3"`.
* Edge behaviour for `k` equal to final length, and `k=1`.

---

# Exercises / Follow-ups

1. Modify the problem so digits may be multi-digit numbers (e.g., `12` means repeat 12 times). How would the algorithm change? (Hint: parsing digits becomes necessary.)
2. Suppose `s` contains uppercase letters and punctuation. Extend the solution to handle Unicode characters. How would `Character.isLetter()` behave with Unicode?
3. Implement a function that returns the substring of the decoded string between indices `L` and `R` without fully decoding. Can you adapt the reverse-tracking idea to return a range?

---

# Conclusion

* Never expand the string explicitly — it will blow up in memory/time.
* The reverse-tracking method is the standard optimal solution: compute the final size, and then walk from the back, using modular arithmetic to map `k` back through layers of repetition.
* Implementation is compact, fast (`O(n)`), and uses constant extra space.

Happy coding! If you want, I can also add a small visual ASCII animation that shows how `k` maps back for a sample input step-by-step.
