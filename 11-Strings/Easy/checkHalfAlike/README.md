
# 🧠 Determine if String Halves Are Alike

## 📝 Problem Statement

You are given a string `s` of **even** length. Split this string into two **halves**:

* The first half: `s[0 ... n/2 - 1]`
* The second half: `s[n/2 ... n - 1]`

Your task is to determine if **both halves contain the same number of vowels**. If yes, return `true`, else return `false`.

> A string is considered **alike** if both halves have the **same number of vowels**.

### ✅ Constraints

* `s.length` is even.
* `1 <= s.length <= 1000`
* `s` consists of **uppercase** and **lowercase** letters.

---

## 📘 Example

### Example 1:

```
Input:  s = "book"
Output: true

Explanation: 
- First half = "bo" → contains 1 vowel ("o")
- Second half = "ok" → contains 1 vowel ("o")
- Both halves have 1 vowel → return true.
```

### Example 2:

```
Input:  s = "textbook"
Output: false

Explanation:
- First half = "text" → 1 vowel ("e")
- Second half = "book" → 2 vowels ("o", "o")
- Not equal → return false.
```

---

## 🧠 Intuition

We want to compare the **number of vowels** in the first half vs the second half of the string.
Since the string is guaranteed to be of even length, we can:

* Count vowels from **start to mid** and from **end to mid**.
* Instead of maintaining **two counters**, we can just maintain **one counter**:

  * Add `+1` for vowels in the first half.
  * Add `-1` for vowels in the second half.

If the counter is **zero at the end**, both halves had the **same number of vowels**.

---

## 🧮 Dry Run with Tree Visualization

Let’s walk through the string: `s = "saif"`

```
Index:     0 1 2 3
String:    s a i f
            ↑ ↑
           i   n - 1 - i

Step 1:
i = 0 → s[0] = 's' → not vowel → count = 0
      → s[3] = 'f' → not vowel → count = 0

Step 2:
i = 1 → s[1] = 'a' → vowel → count = 1
      → s[2] = 'i' → vowel → count = 0

Final count = 0 → return true
```

---

## 🧑‍💻 Java Code

```java
import java.util.Set;

public class Solution {
    public static boolean check(String s){
        // Set of vowels (both lowercase and uppercase)
        Set<Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U');

        int count = 0;
        int n = s.length();

        // Loop only till half
        for (int i = 0; i < n / 2; i++) {
            if (vowels.contains(s.charAt(i))) count++;             // First half
            if (vowels.contains(s.charAt(n - 1 - i))) count--;     // Second half
        }

        return count == 0;
    }

    public static void main(String[] args) {
        String s = "saif";
        System.out.println(check(s));  // Output: true
    }
}
```

---

## 🧑‍🏫 Pseudocode

```
function check(s):
    vowels = set of vowels (both cases)
    count = 0
    n = length of s

    for i from 0 to n/2 - 1:
        if s[i] in vowels:
            count += 1
        if s[n - 1 - i] in vowels:
            count -= 1

    return count == 0
```

---

## ⏱ Time and Space Complexity

### ✅ Time Complexity: `O(n)`

* Where `n` is the length of the string.
* We loop through `n / 2` characters, and each `contains()` check is O(1) for a Set.

### ✅ Space Complexity: `O(1)`

* The vowel set is of constant size (10 vowels).
* No extra space used that grows with input size.

---

## ❓ Why This Approach Works

* The **difference counter** approach is smart because:

  * We don’t need to maintain two counters.
  * Saves space and makes the code elegant.
* The usage of a `Set` allows fast vowel checks in O(1).

---

## ✅ Test Cases

| Input        | Output | Explanation             |
| ------------ | ------ | ----------------------- |
| "book"       | true   | 1 vowel in each half    |
| "textbook"   | false  | 1 vs 2 vowels           |
| "Mango"      | false  | Uneven split            |
| "aeiouAEIOU" | true   | 5 vowels in both halves |
| "SaIf"       | true   | 1 vowel in both halves  |

---

## 🚀 Conclusion

This problem is a great example of how we can **simplify a two-counter problem** into one smart loop by using a **balanced counter approach**.

It's efficient, clean, and works well within the given constraints.

---

