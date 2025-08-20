
# 📘 Beautiful Substrings

## 📝 Problem Statement

We are given a string `s` consisting of lowercase English letters and an integer `k`.
A substring of `s` is called **beautiful** if:

1. The number of vowels and consonants in the substring are **equal**.
2. The product `(vowels × consonants)` is divisible by `k`.

We need to return the total number of **beautiful substrings** in `s`.

---

## 🔍 Example

### Example 1

```
Input:
s = "aabb"
k = 2

Output:
1
```

### Explanation

All substrings of `"aabb"`:

* `"a"` → vowels=1, consonants=0 ❌
* `"aa"` → vowels=2, consonants=0 ❌
* `"aab"` → vowels=2, consonants=1 ❌
* `"aabb"` → vowels=2, consonants=2 ✅ and (2×2=4 divisible by 2) ✅

Only `"aabb"` is beautiful → Answer = 1.

---

## 🧠 Intuition

We need to check **all substrings** of the given string.
For each substring, we check:

* If vowels == consonants.
* If `(vowels × consonants) % k == 0`.

At first, the simplest solution is brute force. But with a small trick, we can make it much faster.

---

## ✨ Approaches

### **1. Brute Force (O(n³))**

* Generate all substrings of `s`.
* For each substring:

  * Count vowels and consonants by looping through characters.
  * If conditions match, increase result.

#### Pseudocode

```
res = 0
for start = 0 to n-1:
    for end = start to n-1:
        vowels = 0
        consonants = 0
        for k = start to end:
            if char is vowel -> vowels++
            else -> consonants++
        if vowels == consonants and (vowels*consonants) % k == 0:
            res++
return res
```

#### Time Complexity

* **O(n³)** → three nested loops (substring + counting).
* **O(1)** extra space.
* Works only for **small strings**.

---

### **2. Improved Brute Force (O(n²))**

Instead of recalculating vowels/consonants for every substring from scratch,
👉 we can **carry forward counts** as we expand the substring.

* Fix a starting index `j`.
* Expand substring by moving `i = j...n-1`.
* Keep track of vowel/consonant counts in running variables.
* Check conditions while expanding.

This avoids the third inner loop and reduces time.

---

#### Java Code

```java
class Solution {
    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int res = 0;

        for (int j = 0; j < n; ++j) {
            int consonants = 0, vowels = 0;
            for (int i = j; i < n; ++i) {
                if (isVowel(s.charAt(i))) vowels++;
                else consonants++;

                if (consonants == vowels && (consonants * vowels) % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
```

---

#### Dry Run Example

`s = "abca", k = 2`

* Start at `j=0`:

  * `"a"` → vowels=1, consonants=0 ❌
  * `"ab"` → vowels=1, consonants=1 ✅ but (1×1=1 not divisible by 2) ❌
  * `"abc"` → vowels=1, consonants=2 ❌
  * `"abca"` → vowels=2, consonants=2 ✅ and (2×2=4 divisible by 2) ✅

So far, res=1. Continue with other substrings similarly.

---

#### Complexity

* **Time:** O(n²)
* **Space:** O(1)
* Much faster than O(n³) and works for larger input sizes.

---

## 📊 Complexity Summary

| Approach             | Time Complexity | Space Complexity | Feasibility |
| -------------------- | --------------- | ---------------- | ----------- |
| Brute Force          | O(n³)           | O(1)             | Too slow    |
| Improved Brute Force | O(n²)           | O(1)             | ✅ Practical |

---

## ✅ Key Takeaways

* Start with brute force to understand the problem.
* Optimize by avoiding repeated work (re-counting vowels/consonants).
* Final working solution is **O(n²)**.

---

## 📌 Final Java Solution

```java
class Solution {
    public boolean isVowel(char c) {
        return (c =='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }

    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int res = 0;

        for (int j = 0; j < n; ++j) {
            int consonants = 0, vowels = 0;
            for (int i = j; i < n; ++i) {
                if (isVowel(s.charAt(i))) vowels++;
                else consonants++;

                if (consonants == vowels && (consonants * vowels) % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
```
