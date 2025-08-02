
# 🔢 Count and Say – LeetCode 38

## 🧠 Problem Statement

The **Count and Say** sequence is a series of strings where each term is constructed by reading the previous term and counting consecutive digits.

* `1` is read as `"one 1"` → `"11"`
* `11` is read as `"two 1s"` → `"21"`
* `21` is read as `"one 2, one 1"` → `"1211"`
* And so on...

Given an integer `n`, return the `n`th term of the count-and-say sequence.

---

## 💡 Intuition

Each term is **generated based on the previous term** by:

1. Counting how many times a digit repeats consecutively.
2. Describing that count followed by the digit.

We can solve this **recursively**:

* Base case: if `n == 1`, return `"1"`.
* Otherwise, get `say(n-1)` and process it to build the current term.

---

## 🛠️ Approach

1. **Base Case**: If `n == 1`, return `"1"`.
2. Get the `(n-1)`th term recursively.
3. Traverse the string:

   * Count consecutive characters.
   * Append the count and the character to a `StringBuilder`.
4. Return the final string.

---

## ✅ Example

```java
say(5)
```

Sequence:

* `1`
* `11`  → one 1
* `21`  → two 1s
* `1211` → one 2, one 1
* `111221` → one 1, one 2, two 1s

Output: `"111221"`

---

## 📈 Time & Space Complexity

* **Time Complexity:**
  $O(2^n)$ in worst case due to string growth and recursion.
  Practical limit is typically `n ≤ 30`.

* **Space Complexity:**
  $O(n \cdot m)$ where `m` is the length of the generated string at each level.

---

## 🧾 Code

```java
public class Solution {
    public static String say(int n) {
        if (n == 1) return "1";

        String prev = say(n - 1);
        StringBuilder ans = new StringBuilder();
        
        int i = 0;
        while (i < prev.length()) {
            int count = 1;
            while (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
                i++;
            }
            ans.append(count).append(prev.charAt(i));
            i++;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(say(5)); // Output: 111221
    }
}
```

---

## 🔍 Notes

* Recursive approach is intuitive but can be optimized using iteration to avoid stack overhead.
* Ideal for understanding **string parsing and generation based on patterns**.

---
