
# 🔁 LeetCode 1657: Determine if Two Strings Are Close

## 🧩 Problem Statement

Given two strings `word1` and `word2`, return `true` *if you can transform* `word1` *into* `word2` using the following **operations** any number of times:

1. You can **swap any two existing characters** (e.g., "abc" → "acb").
2. You can **transform every occurrence** of one existing character into another existing character, and do the same with the other character (e.g., "aacabb" → "bbcbaa", all 'a' ↔ 'b').

> ✨ **Note:** You can use the above operations as many times as needed.

---

## 🔡 Input / Output Format

### 🔹 Input:
- Two strings `word1` and `word2`, consisting of lowercase English letters only.
- `1 <= word1.length, word2.length <= 10^5`

### 🔹 Output:
- Boolean value: `true` if the strings are *close*, else `false`.

---

## 🔍 Examples

### ✅ Example 1:
```java
Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can swap letters freely. "abc" → "bca"
````

---

### ❌ Example 2:

```java
Input: word1 = "a", word2 = "aa"
Output: false
Explanation: Lengths are different, can't make one into another.
```

---

### ✅ Example 3:

```java
Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation:
- Swap operations: "cabbba" → "abbabc"
- Transform all 'a' ↔ 'c': "abbabc" → "cbbaca" → frequencies match → return true.
```

---

### ❌ Example 4:

```java
Input: word1 = "uau", word2 = "ssx"
Output: false
Explanation:
- Different character sets → 'a', 'u' vs 's', 'x' → return false
```

---

## 🧠 Intuition

When two strings are truly *"close"*, we can:

* Swap any characters freely → order doesn't matter.
* Transform characters completely → only the **frequency** of characters matters, not which specific character.

So we must check:

1. Do both strings contain the **same characters**?
2. Do they have **the same frequency pattern** (not necessarily matching letters, but the same counts)?

---

## 🛠️ Approach

### ✅ Step-by-step Plan:

1. If lengths differ → Return `false`.
2. Count character frequencies in both strings using arrays of size 26.
3. Check if both strings use the same set of characters.
4. Sort both frequency arrays and compare.

---

## 📄 Pseudocode

```
function closeStrings(word1, word2):
    if word1.length != word2.length:
        return false

    freq1 = array of 26 zeros
    freq2 = array of 26 zeros

    for char in word1:
        freq1[char - 'a']++

    for char in word2:
        freq2[char - 'a']++

    for i = 0 to 25:
        if freq1[i] == 0 and freq2[i] != 0 or vice versa:
            return false

    sort freq1
    sort freq2

    return freq1 == freq2
```

---

## ✅ Java Code

```java
import java.util.Arrays;

public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        // Check if both strings contain the same set of characters
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Sort and compare frequencies
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
}
```

---

## ⏱️ Time and Space Complexity

### Time Complexity:

* Counting characters: `O(n)`
* Sorting frequency arrays: `O(26 log 26)` → treated as `O(1)`
* Comparing: `O(26)` → `O(1)`

✅ **Total Time:** `O(n)`

### Space Complexity:

* Two frequency arrays of fixed size → `O(1)` space

---

## 🧠 Why This Works

* You can reorder characters (swap) → so character positions don’t matter.
* You can replace all of one character with another if both characters exist → so only the **frequency distribution** matters, not which exact character has which frequency.

---

## 🧪 Additional Test Cases

| word1    | word2    | Output | Reason                             |
| -------- | -------- | ------ | ---------------------------------- |
| "abc"    | "bca"    | true   | Same characters, same frequencies  |
| "a"      | "aa"     | false  | Different lengths                  |
| "aabbcc" | "ccbbaa" | true   | Same chars, \[2,2,2] freq          |
| "abcd"   | "dcba"   | true   | All characters same, just shuffled |
| "aabb"   | "aabc"   | false  | Character set not same ('c' extra) |

---

## 🔚 Conclusion

This problem is a solid exercise in:

* Frequency analysis
* Set comparison
* Understanding character transformation rules

It’s important to separate **order-based logic** from **frequency-based logic**, especially when allowed operations let you swap or transform freely.

---

```
