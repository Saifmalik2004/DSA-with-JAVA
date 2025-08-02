
# 📦 String Compression – LeetCode 443

## 🧠 Problem Statement

Given an array of characters `chars`, compress it **in-place**.

The compression rules are:

* Replace sequences of the same character with the character followed by the number of times it appears.
* If the character appears only once, just keep the character without a number.
* Return the new length of the array after compression.
* Do **not** allocate extra space — modify the `chars` array **in-place**.

### 🧾 Example

```txt
Input:  ['a','a','b','b','c','c','c']
Output: ['a','2','b','2','c','3'], length = 6
```

---

## 💡 Intuition

Instead of building a new string, we directly overwrite the input array.
We track:

* Current character (`cur`)
* How many times it’s repeated (`count`)
* Where to write the compressed output (`idx`)

---

## 🛠️ Approach

1. Initialize:

   * `cur = chars[0]` → current character
   * `count = 1` → to count repetitions
   * `idx = 0` → write index

2. Loop from the second character to the end:

   * If `chars[i] == cur`, increment `count`.
   * If different:

     * Write `cur` at `chars[idx]`.
     * If `count > 1`, convert it to string and write each digit to the array.
     * Reset `cur` and `count`.

3. After the loop, handle the last group similarly.

4. Return `idx`, which is the new length.

---

## 📈 Time & Space Complexity

* **Time Complexity:**
  $O(n)$ — each character is processed once.

* **Space Complexity:**
  $O(1)$ — in-place modification, no extra space used (ignoring `Integer.toString(count)`).

---

## ✅ Code

```java
class Solution {
    public int compress(char[] chars) {
        int count = 1;
        char cur = chars[0];
        int idx = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != cur) {
                chars[idx++] = cur;
                if (count > 1) {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[idx++] = c;
                    }
                }
                count = 1;
                cur = chars[i];
            } else {
                count++;
            }
        }

        // Handle the last group
        chars[idx++] = cur;
        if (count > 1) {
            for (char c : Integer.toString(count).toCharArray()) {
                chars[idx++] = c;
            }
        }

        return idx;
    }
}
```

---

## 🔍 Notes

* Do not use extra arrays or strings to hold the full result.
* This is a classic **two-pointer** technique: one pointer reads, the other writes.

---
