
## 🧠 Remove Duplicate Letters — LeetCode 316

---

### 📘 Problem Statement

Given a string `s`, remove duplicate letters so that every letter appears once **and only once**. You must make sure your result is the **smallest in lexicographical order** among all possible results.

---

### 🧠 Intuition

When we want to **remove duplicate letters** and also ensure **lexicographical order**, a **greedy** approach naturally comes to mind.

But we can't just sort the string or remove duplicates randomly — we need to:

1. Include each character **only once**.
2. Ensure the result is the **smallest lexicographically**.
3. Maintain the **relative order** where needed to ensure smallest result.

So, the question becomes:

> "For each character, should I include it now or wait until later?"
> This leads us to a **stack-based greedy** algorithm.

---

### 🔍 Example

#### Input:

`s = "cbacdcbc"`

#### Output:

`"acdb"`

#### Why?

* All characters appear only once.
* `"acdb"` is the smallest lexicographically among all valid combinations like `"acbd"`, `"cabd"`, etc.

---

### 🛠️ Approach

We’ll follow a **stack-based greedy approach** with some additional tracking:

---

#### ✅ Step-by-step Breakdown:

1. **Track the last index** of each character so we know if it will appear again later.
2. Use a `boolean[] isTaken` array to track if a character is already in the result.
3. Use a **stack-like behavior** with `StringBuilder`:

   * If the current character is **smaller** than the last character in the result
   * And if that last character **appears again later**, then **remove** it to make room for a smaller character.
4. Finally, add the current character if it is not already included.

---

### 📄 Pseudocode

```
for each character in s:
    record last occurrence index

for each character in s:
    if already in result: continue

    while result not empty AND
          current char < last char in result AND
          last char will appear later:
        pop last char from result
        mark it as not taken

    append current char to result
    mark it as taken
```

---

### 💻 Java Code

```java
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];        // Last occurrence of each character
        boolean[] isTaken = new boolean[26];  // If character is in current result
        int n = s.length();
        StringBuilder result = new StringBuilder();

        // Step 1: Store last index of each character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        // Step 2: Traverse the string
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (isTaken[ch - 'a']) continue;

            // Remove characters from result if they can appear later
            while (
                result.length() > 0 &&
                ch < result.charAt(result.length() - 1) &&
                lastIndex[result.charAt(result.length() - 1) - 'a'] > i
            ) {
                char removed = result.charAt(result.length() - 1);
                isTaken[removed - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            result.append(ch);
            isTaken[ch - 'a'] = true;
        }

        return result.toString();
    }
}
```

---

### ⏱️ Complexity Analysis

* **Time Complexity:**
  $O(n)$

  * One pass to record last indices.
  * One pass to build the result, with each character being pushed/popped at most once.

* **Space Complexity:**
  $O(1)$

  * Fixed-size arrays of length 26 (for lowercase English letters).
  * Result uses up to 26 characters.

---

### ✅ Why This Works

* We ensure **no duplicates** using the `isTaken` array.
* We ensure **lexicographical order** by popping characters from the result that will appear again and are lexicographically greater than the current character.
* The solution is **greedy**, but it’s safe because we know whether we’ll see a character again using the `lastIndex[]`.

---

### ⚠️ Edge Cases

| Input        | Output   | Explanation                                                |
| ------------ | -------- | ---------------------------------------------------------- |
| `"bcabc"`    | `"abc"`  | Remove duplicates and order lexicographically              |
| `"cbacdcbc"` | `"acdb"` | `'b'` is removed early because it comes again              |
| `"abacb"`    | `"abc"`  | Both `'a'` and `'b'` are removed once to get correct order |

---

### 🧑‍🎓 Who Should Learn This?

* Anyone learning **greedy algorithms**
* Practicing **stack-based** approaches
* Preparing for **FAANG-level** interviews

---

### 📌 Summary

This is a **classic greedy + stack** problem where understanding character positions and order is critical.
By carefully removing and adding characters based on their future availability and current position, we achieve a **unique** and **lexicographically smallest** result.

---
