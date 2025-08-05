
# ✅ Pangram Checker

## 🧾 Problem Statement

A **pangram** is a sentence that contains **every letter of the English alphabet** at least once.

### ✍️ You are given:

* A string `sentence` consisting of **only lowercase English letters**.

### ❓ Task:

Write a function to determine **if the sentence is a pangram**.

---

## 📥 Input

* A single string: `sentence` (1 ≤ length ≤ 1000)

### Example 1:

```
Input:  "thequickbrownfoxjumpsoverthelazydog"
Output: true
```

### Example 2:

```
Input: "abcdefghijklmnopqrstuvwxyy"
Output: false
```

---

## ✅ Constraints

* Only lowercase English letters are present.
* No special characters or uppercase letters.
* The string may contain duplicates.

---

## 🔍 Intuition

To be a **pangram**, the sentence must contain **all 26 lowercase English letters** at least once.

So, the idea is to:

* Check if each letter from `'a'` to `'z'` is present in the sentence.

---

## 🧠 Approach: Brute Force with `contains()`

### Steps:

1. If the sentence is shorter than 26 characters, it **cannot** be a pangram → return false.
2. Loop through characters `'a'` to `'z'`.
3. For each character, check if it is present in the sentence using `String.contains()`.
4. If **any letter is missing**, return false.
5. If all 26 letters are found, return true.

---

## 🧾 Pseudocode

```
function isPangram(sentence):
    if length of sentence < 26:
        return false

    for c in 'a' to 'z':
        if c not in sentence:
            return false

    return true
```

---

## 🧪 Java Code

```java
class Solution {

    public static boolean panagram(String sentence) {
        char c = 'a';
        
        // Early exit: Not enough letters
        if (sentence.length() < 26) return false;

        // Check for each letter from a to z
        for (int i = 0; i < 26; i++) {
            if (!sentence.contains(String.valueOf(c++))) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(panagram("abcdefghijklmnopqrstuvwxyy")); // false
        System.out.println(panagram("thequickbrownfoxjumpsoverthelazydog")); // true
    }
}
```

---

## ⏱️ Time & Space Complexity

| Metric | Complexity                                    |
| ------ | --------------------------------------------- |
| Time   | O(26 × n) → O(n) (since `contains()` is O(n)) |
| Space  | O(1) (no extra data structures used)          |

🧠 You could optimize time to O(n) using a `Set` — we’ll discuss below.

---

## 💡 Alternate Optimized Approach: Using `HashSet`

Instead of calling `contains()` repeatedly, you can:

1. Loop through the sentence once.
2. Store all unique letters in a `Set`.
3. If set size = 26 → it's a pangram.

### Code:

```java
public static boolean panagram(String sentence) {
    if (sentence.length() < 26) return false;

    Set<Character> set = new HashSet<>();
    for (char c : sentence.toCharArray()) {
        set.add(c);
    }

    return set.size() == 26;
}
```

### Time: O(n), Space: O(1)

---

## 🧠 Summary

| Approach           | Time | Space | Notes                              |
| ------------------ | ---- | ----- | ---------------------------------- |
| `contains()` check | O(n) | O(1)  | Simple but slower on large `n`     |
| `HashSet`          | O(n) | O(1)  | More optimal, avoids repeat search |

---

## 🧪 Test Cases

| Input                                 | Output |
| ------------------------------------- | ------ |
| "thequickbrownfoxjumpsoverthelazydog" | true   |
| "abcdefghijklmnopqrstuvwxy"           | false  |
| "abcdefghijklmnopqrstuvwxyz"          | true   |
| "aaaaabbbbbcccccdddddeeeee"           | false  |
| ""                                    | false  |

---

## 🙋 Interviewer Tips

* Always check for edge case: length < 26
* Mention both approaches: `contains()` vs `Set`
* Make sure to mention **space-time tradeoff**

---
