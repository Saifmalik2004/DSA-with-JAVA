
# 📌 Repeated Substring Pattern (LeetCode 459)

## 📝 Problem Statement
Given a string `s`, check if it can be constructed by taking a **substring** of it and appending multiple copies of the substring together.

Return **true** if possible, otherwise return **false**.

---

## 🔍 Examples

### Example 1
```

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" repeated 2 times.

```

### Example 2
```

Input: s = "aba"
Output: false
Explanation: "aba" cannot be formed by repeating any of its proper substrings.

```

### Example 3
```

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" repeated 4 times.

```

---

## 💡 Intuition
We need to check if the string `s` can be expressed as:
```

s = substring × k   (where k > 1)

```
That means:
- Some prefix substring `str` must be repeated multiple times to form the entire string.
- The length of the substring must **divide the length of the string** exactly.

### Key Observations
1. The substring length must be a **divisor of n** (where n = length of `s`).
2. If we pick a valid divisor `i`, the substring `s[0..i-1]` when repeated `(n / i)` times should equal `s`.

---

## 🛠️ Approaches

### ✅ Approach 1: Brute Force with Divisors
1. Loop over possible substring lengths `i` from `n/2` down to `1`.
   - We only go till `n/2` because a substring longer than half cannot repeat.
2. If `n % i != 0`, skip (cannot divide evenly).
3. Otherwise:
   - Build the repeated string using substring `s[0..i-1]`.
   - Compare with original `s`.
   - If equal → return `true`.
4. If no valid substring found → return `false`.

#### Pseudocode
```

function repeatedSubstringPattern(s):
n = length(s)
if n == 1: return false

```
for i = n/2 down to 1:
    if n % i != 0: continue

    substring = s[0..i-1]
    times = n / i
    repeated = substring repeated 'times' times

    if repeated == s:
        return true

return false
```

````

#### Java Implementation
```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n == 1) return false;

        for (int i = n / 2; i >= 1; i--) {
            if (n % i != 0) continue;

            String str = s.substring(0, i);
            int times = n / i;

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < times; j++) {
                result.append(str);
            }

            if (s.equals(result.toString())) return true;
        }
        return false;
    }
}
````

#### Complexity Analysis

* **Time Complexity**: `O(n^2)` (building strings and checking).
* **Space Complexity**: `O(n)` (temporary string building).

---

### ✅ Approach 2: String Trick with Concatenation

Another neat trick:

* If `s` is made of a repeated substring, then `s` will always appear in `(s + s)` but **not at position 0 or n**.

#### Why?

* Example: `s = "abab"`
* `(s + s) = "abababab"`
* Remove first and last char: `"bababa"`, and `"abab"` still exists inside.

#### Java Implementation

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        return doubled.substring(1, doubled.length() - 1).contains(s);
    }
}
```

#### Complexity Analysis

* **Time Complexity**: `O(n)` average for substring search.
* **Space Complexity**: `O(n)` due to concatenation.

---

### ✅ Approach 3: KMP (Knuth-Morris-Pratt Algorithm)

We can also solve this using the **LPS (Longest Prefix Suffix)** array from the KMP algorithm:

1. Compute the LPS array for `s`.
2. Let `len = LPS[n-1]` (length of the longest prefix also being a suffix).
3. If `len > 0` and `n % (n - len) == 0`, then `s` is a repeated substring.

#### Java Implementation

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0, i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int last = lps[n - 1];
        return last > 0 && n % (n - last) == 0;
    }
}
```

#### Complexity Analysis

* **Time Complexity**: `O(n)`
* **Space Complexity**: `O(n)` (LPS array)

---

## 📊 Complexity Comparison

| Approach                        | Time Complexity | Space Complexity | Best Use Case      |
| ------------------------------- | --------------- | ---------------- | ------------------ |
| Brute Force (Divisors + Repeat) | O(n²)           | O(n)             | Easy to implement  |
| Concatenation Trick (`s+s`)     | O(n)            | O(n)             | Simple & elegant   |
| KMP (LPS array)                 | O(n)            | O(n)             | Optimal & powerful |

---

## 🎯 Key Takeaways

* The brute force approach is simple but not optimal (`O(n²)`).
* The string trick with `(s+s)` is **clever and concise**.
* The KMP solution is **most efficient and scalable** for large inputs.
* This problem improves your understanding of **string periodicity** and **pattern matching algorithms**.

🚀 Recommended: Use the **concatenation trick** in interviews unless explicitly asked for an algorithmic approach like **KMP**.

