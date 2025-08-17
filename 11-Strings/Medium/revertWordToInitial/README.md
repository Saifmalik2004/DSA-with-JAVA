
# 📘 Problem: Minimum Time to Initial State

## 🔹 Problem Statement

We are given a string `word` and an integer `k`.
We want to transform `word` back to its **initial state** (the original string) by performing the following process:

* At each step, we can delete the **first `k` characters** of the current string.
* We want to know: **How many steps are required to return to the initial string?**

---

## 🔹 Example Walkthrough

### Example 1

```
Input: word = "ababa", k = 2
```

Steps:

1. Start = `"ababa"`
   Remove first 2 chars → `"aba"`
   Now check if `"aba"` is still a prefix of `"ababa"`. ✅ Yes.

   So in **1 step**, we already returned to prefix alignment. Answer = 1.

---

### Example 2

```
Input: word = "abcabcabc", k = 3
```

Steps:

1. `"abcabcabc"` → remove first 3 → `"abcabc"`
   Check if `"abcabc"` is prefix of `"abcabcabc"` ✅ Yes.

   Answer = 1.

---

### Example 3

```
Input: word = "abcdef", k = 2
```

Steps:

1. `"abcdef"` → remove first 2 → `"cdef"` (not prefix of `"abcdef"`) ❌
2. `"cdef"` → remove next 2 → `"ef"` (not prefix) ❌
3. Finally → string empty. ✅

Answer = 3.

---

## 🔹 Intuition

The problem boils down to checking **prefix alignment**:

* Every time we remove `k` characters, the new substring must **match the prefix of the original string**.
* If it matches, we are back to a state that can regenerate the original string (like repeating pattern).
* If not, we continue until we eventually delete all characters.

👉 So the **key observation**:
We check if `word[k..n-1] == word[0..n-k-1]`.
If yes → we found answer.
Otherwise → keep removing `k`.

---

## 🔹 Pseudocode

```
function minimumTimeToInitialState(word, k):
    count = 1
    n = length(word)
    i = k
    
    while i < n:
        if word[0 : n-i] == word[i : n]:
            return count
        else:
            i += k
            count += 1
    
    return count
```

---

## 🔹 Java Code Implementation

```java
class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int count = 1;
        int n = word.length();
        int i = k;

        while (i < n) {
            if (checkIfPrefix(word, i)) {
                break;
            } else {
                i += k;
                count++;
            }
        }
        return count;
    }

    public boolean checkIfPrefix(String word, int k) {
        int i = 0;
        int j = k;

        while (j < word.length()) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    // ✅ Main function to test
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.minimumTimeToInitialState("ababa", 2));   // Output: 1
        System.out.println(sol.minimumTimeToInitialState("abcabcabc", 3)); // Output: 1
        System.out.println(sol.minimumTimeToInitialState("abcdef", 2));   // Output: 3
    }
}
```

---

## 🔹 Complexity Analysis

* **Time Complexity**:

  * For each step, we compare substring with prefix → `O(n)` worst case.
  * We may do at most `n/k` steps.
  * Total = **O((n/k) \* n) ≈ O(n²/k)**.

* **Space Complexity**:

  * No extra data structures.
  * **O(1)**.

---

## 🔹 Why This Works

* The key is to notice we only need to check **prefix alignment** after removing multiples of `k`.
* Once alignment is found → string can regenerate.
* Otherwise, we eventually delete everything (worst case).

---

## 🔹 Possible Optimizations (Advanced)

* Instead of checking character-by-character (`O(n)`), we can use **string hashing** or **KMP prefix-function** to compare efficiently.
* That can reduce the time complexity to **O(n)** overall.

But for most constraints, this simple solution works fine.

---
