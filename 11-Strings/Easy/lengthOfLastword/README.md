
# 📌 Length of Last Word (LeetCode 58)

## 📝 Problem Statement
Given a string `s` consisting of words and spaces, return the **length of the last word** in the string.

👉 A **word** is defined as a maximal substring consisting of **non-space characters only**.

---

## 🔍 Examples

### Example 1
```

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World", which has length 5.

```

### Example 2
```

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

```

### Example 3
```

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

```

---

## 💡 Intuition
The problem asks us to **find the length of the last word in a string**, where words are separated by spaces.  

Key observations:
1. The string may have **trailing spaces**, which we should ignore.
2. Once we skip trailing spaces, the last continuous sequence of characters (without spaces) is the **last word**.
3. We just need to count its length.

This can be solved efficiently by traversing the string **backward**.

---

## 🛠️ Approaches

### ✅ Approach 1: Backward Traversal (Greedy)
1. Start from the **end of the string**.
2. **Skip trailing spaces** until we reach a character.
3. Count characters until we hit another space or the beginning of the string.
4. Return the count.

#### Pseudocode
```

function lengthOfLastWord(s):
i = length(s) - 1
count = 0

```
while i >= 0 and s[i] == ' ':
    i--   // skip trailing spaces

while i >= 0 and s[i] != ' ':
    count++
    i--

return count
```

````

#### Java Implementation
```java
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int count = 0;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters until space or start of string
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}
````

#### Complexity Analysis

* **Time Complexity**: `O(n)` (we scan at most the entire string once).
* **Space Complexity**: `O(1)` (only variables `i` and `count` used).

---

### ✅ Approach 2: Using Built-in Functions

We can also:

1. **Trim** the string to remove trailing spaces.
2. **Split** the string into words.
3. Return the length of the last word.

#### Java Implementation

```java
class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length - 1].length();
    }
}
```

#### Complexity Analysis

* **Time Complexity**: `O(n)` (trimming + splitting).
* **Space Complexity**: `O(n)` (extra space for array of words).
* Less efficient than backward traversal but easier to write.

---

## 🎯 Key Takeaways

* The **backward traversal approach** is optimal: `O(n)` time, `O(1)` space.
* The **split + trim approach** is simpler but less memory efficient.
* Always consider edge cases:

  * Trailing spaces: `"Hello World   "` → should return 5.
  * Single word: `"Hello"` → should return 5.
  * Empty string or all spaces → should return 0.

---

## 📊 Complexity Comparison

| Approach                | Time Complexity | Space Complexity | Best Use Case              |
| ----------------------- | --------------- | ---------------- | -------------------------- |
| Backward Traversal      | O(n)            | O(1)             | Optimal & memory-efficient |
| Split + Trim (Built-in) | O(n)            | O(n)             | Quick implementation       |

---

## ✅ Final Thoughts

* Start from the end of the string to **skip spaces efficiently**.
* Count characters until you hit the first space.
* This is a **classic string manipulation problem** that improves your ability to handle edge cases in text processing. 🚀

