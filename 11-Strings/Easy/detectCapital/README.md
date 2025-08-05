# 📘 Problem: Detect Capital

**Leetcode Problem ID:** 520
**Difficulty:** Easy
**Topic:** String, Character Validation
**Tags:** String, Implementation, Capitalization

---

## 🧩 Problem Statement

We define the usage of capitals in a word to be correct when one of the following cases holds:

1. All letters in this word are capitals, like `"USA"`.
2. All letters in this word are not capitals, like `"leetcode"`.
3. Only the first letter in this word is capital, like `"Google"`.

**Given a string `word`, return `true` if the usage of capitals in it is right. Otherwise, return `false`.**

---

## ✅ Examples

| Input        | Output | Explanation                           |
| ------------ | ------ | ------------------------------------- |
| `"USA"`      | true   | All letters are uppercase.            |
| `"leetcode"` | true   | All letters are lowercase.            |
| `"Google"`   | true   | Only the first letter is uppercase.   |
| `"FlaG"`     | false  | Random capitalization is not allowed. |
| `"g"`        | true   | Single lowercase character.           |
| `"G"`        | true   | Single uppercase character.           |

---

## 🧠 Intuition

We want to validate capitalization rules based on the **number** and **position** of uppercase letters.

* If **all characters** are uppercase → ✅ valid
* If **no characters** are uppercase → ✅ valid
* If **only the first character** is uppercase → ✅ valid
* Any other combination → ❌ invalid

This means we must **count the uppercase letters** and check their positions.

---

## 📌 Approach

### ✔️ Approach: Count Uppercase Letters

#### 🔍 Steps:

1. Traverse the word character by character.
2. Count how many characters are uppercase using ASCII value (A-Z → `<= 90`).
3. Also, check if the first character is uppercase.
4. Validate based on the 3 conditions.

#### ✍️ Pseudocode:

```
function detectCapitalUse(word):
    count = 0
    isFirstCapital = false

    for i = 0 to word.length:
        if char at i is uppercase:
            count++
            if i == 0:
                isFirstCapital = true

    if count == word.length: return true  // all caps
    if count == 0: return true            // all lowercase
    if count == 1 and isFirstCapital: return true  // only first capital
    return false
```

---

## 💻 Java Code

```java
class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        boolean isFirst = false;

        for (int i = 0; i < word.length(); i++) {
            if ((int) word.charAt(i) <= 90) { // ASCII for 'Z' = 90
                count++;
                if (i == 0) {
                    isFirst = true;
                }
            }
        }

        // Valid if: all caps, no caps, or first letter only
        if (count == 1 && isFirst) return true;
        else return (count == word.length() || count == 0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] testWords = {
            "USA", "leetcode", "Google", "FlaG", "g", "G"
        };

        for (String word : testWords) {
            boolean result = sol.detectCapitalUse(word);
            System.out.println("Input: " + word + " => Output: " + result);
        }
    }
}
```

---

## 🕰️ Time & Space Complexity

| Complexity | Value                                              |
| ---------- | -------------------------------------------------- |
| **Time**   | O(n)  — Iterate through each character in the word |
| **Space**  | O(1)  — Only a few variables used (constant space) |

---

## 🧪 Edge Cases

| Input  | Output | Reason                           |
| ------ | ------ | -------------------------------- |
| `""`   | true   | Empty string is trivially valid  |
| `"A"`  | true   | Single uppercase letter is valid |
| `"a"`  | true   | Single lowercase letter is valid |
| `"Aa"` | true   | First capital, rest lowercase    |
| `"aA"` | false  | Invalid capital use              |

---

## 📚 Alternate Approach (Regex Based)

For completeness, here's a one-liner solution using regex:

```java
public boolean detectCapitalUse(String word) {
    return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
}
```

This uses pattern matching for:

* `[A-Z]+` → All uppercase
* `[a-z]+` → All lowercase
* `[A-Z][a-z]+` → First capital, rest lowercase

### ✅ Pros:

* Very clean and short

### ❌ Cons:

* Slower in runtime than manual approach due to regex engine overhead

---

## 🧠 Final Thoughts

* This problem is a great practice for **character analysis**, **ASCII values**, and **string traversal**.
* Helps build intuition on **valid string patterns** and conditions.

---
