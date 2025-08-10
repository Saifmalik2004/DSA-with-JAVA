# Remove Adjacent Opposite Case Characters

## 📌 Problem Statement

You are given a string `s` containing both **uppercase** and **lowercase** letters.

Your task is to repeatedly remove **two adjacent characters** if:

* They are the **same letter**, and
* One is **uppercase** and the other is **lowercase**.

This removal process should continue until **no more such pairs** exist.
Return the **final string** after all possible removals.

---

### 📝 Example

#### Example 1:

**Input:**

```
s = "leEeetcode"
```

**Process:**

1. `"leEeetcode"` → Remove `'eE'` → `"leetcode"`
2. No more adjacent pairs with opposite cases.

**Output:**

```
"leetcode"
```

---

#### Example 2:

**Input:**

```
s = "abBAcC"
```

**Process:**

1. `"abBAcC"` → Remove `'bB'` → `"aAcC"`
2. Remove `'aA'` → `"cC"`
3. Remove `'cC'` → `""`

**Output:**

```
""
```

---

## 🎯 Intuition

The problem is about **removing pairs** of characters that cancel each other out (same letter but opposite cases).

The key observation is:

* The ASCII value difference between `'a'` and `'A'` is **32**.
* So, if `Math.abs(s.charAt(i) - s.charAt(i-1)) == 32`, they are the same letter in different cases.

Instead of repeatedly scanning the string from the start (which would be inefficient), we can use a **stack-like approach**:

* Traverse the string from left to right.
* Use a `StringBuilder` as a stack.
* Push the current character if it doesn’t cancel with the top of the stack.
* If it does cancel, pop (remove) the last character.

This ensures **O(n)** time complexity because each character is processed at most twice.

---

## 🧠 Approach

### Step-by-Step:

1. Initialize a `StringBuilder` (`res`) to store processed characters (works as a stack).
2. Add the **first character** to `res`.
3. Loop through each next character in the string:

   * If `res` is **not empty** and the last character in `res` differs from the current character by exactly **32** in ASCII value:

     * Remove the last character (cancel out the pair).
   * Otherwise:

     * Append the current character to `res`.
4. At the end, return `res.toString()`.

---

## 🧾 Pseudocode

```
function check(s):
    create StringBuilder res
    append first character of s to res
    
    for i from 1 to length of s - 1:
        if res is not empty AND abs(s[i] - lastCharIn(res)) == 32:
            remove last character from res
        else:
            append s[i] to res

    return res as string
```

---

## 💻 Java Implementation

```java
public class Solution {

    public static String check(String s) {
        StringBuilder res = new StringBuilder();
        res.append(s.substring(0, 1));

        for (int i = 1; i < s.length(); i++) {
            if (res.length() > 0
                    && Math.abs(s.charAt(i) - res.charAt(res.length() - 1)) == 32) {
                // Cancel out the last character
                res.deleteCharAt(res.length() - 1);
            } else {
                // Add current character
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(check(s)); // Output: "leetcode"
    }
}
```

---

## ⏳ Complexity Analysis

| Complexity | Value | Reason                                                       |
| ---------- | ----- | ------------------------------------------------------------ |
| **Time**   | O(n)  | Each character is processed at most twice (push + pop).      |
| **Space**  | O(n)  | In the worst case, the `StringBuilder` holds all characters. |

---

## ✅ Why This Works

* Using a **stack-like approach** ensures we only process characters once.
* The ASCII difference of **32** is a quick and efficient way to check opposite cases.
* `StringBuilder` is chosen because:

  * It's mutable.
  * Append and delete at the end are **O(1)** operations.

---

## 📌 Edge Cases

1. **Empty string** → returns `""`
2. **No cancellable pairs** → returns original string.
3. **All characters cancel out** → returns `""`
4. **Mixed letters where cancellations create new pairs** → handled automatically by stack approach.

---

## 🔍 Dry Run Example

For `s = "leEeetcode"`:

| Step | Current Char | Stack Before | Action | Stack After  |
| ---- | ------------ | ------------ | ------ | ------------ |
| 1    | `l`          | `""`         | Push   | `"l"`        |
| 2    | `e`          | `"l"`        | Push   | `"le"`       |
| 3    | `E`          | `"le"`       | Cancel | `"l"`        |
| 4    | `e`          | `"l"`        | Push   | `"le"`       |
| 5    | `t`          | `"le"`       | Push   | `"let"`      |
| 6    | `c`          | `"let"`      | Push   | `"letc"`     |
| 7    | `o`          | `"letc"`     | Push   | `"letco"`    |
| 8    | `d`          | `"letco"`    | Push   | `"letcod"`   |
| 9    | `e`          | `"letcod"`   | Push   | `"leetcode"` |

Result: `"leetcode"`


