## 🧠 Number of Matching Subsequences

### Problem Link:

> LeetCode: [https://leetcode.com/problems/number-of-matching-subsequences/](https://leetcode.com/problems/number-of-matching-subsequences/)

---

## 🔍 Problem Statement

You are given a string `s` and an array of strings `words`.

A string is a **subsequence** of another string if it can be derived by deleting some (or no) characters without changing the order of the remaining characters.

**Return** the number of `words[i]` that are **subsequences** of `s`.

---

## 🧾 Example

```text
Input:
s = "abcde"
words = ["a", "bb", "acd", "ace"]

Output: 3

Explanation:
- "a" is a subsequence of "abcde".
- "bb" is not a subsequence.
- "acd" is a subsequence.
- "ace" is a subsequence.
```

---

## ✅ Constraints

* `1 <= s.length <= 50000`
* `1 <= words.length <= 5000`
* `1 <= words[i].length <= 50`
* `s` and `words[i]` consist of lowercase English letters only.

---

## 💡 Intuition

The **naive** way is to check for each word whether it's a subsequence of `s` using two pointers.
But this is inefficient for large inputs (`O(N * L)` where L is average length of word).

Instead, we can **preprocess** string `s` and **store indices of each character**. Then, for each word, we perform **binary search** to efficiently find the next valid character index in `s`.

---

## 🧠 Approach: Map + Binary Search

### 🔧 Idea:

1. Preprocess `s`:

   * For each character `c` in `s`, store all its indices in a map:
     `map[c] = list of indices where c occurs in s`

2. For each word:

   * For each character `ch` in word, find the smallest index in `map[ch]` which is **greater than the last used index** (using binary search).

3. If you can find all characters in order → word is a subsequence.

---

## 🔁 Pseudocode

```plaintext
1. Create a HashMap<Character, List<Integer>> for s
2. For each character in s, add its index to map

3. For each word:
    a. Set prev = -1
    b. For each character ch in word:
        - If ch not in map, skip
        - Use binary search to find index > prev in map.get(ch)
        - If not found, break
        - Else, update prev to that index
    c. If all characters found in order, count++

4. Return count
```

---

## 🧪 Dry Run

### s = `"abcde"`, word = `"ace"`

| char | Available Indices in s | Binary Search Target (prev) | Chosen Index |
| ---- | ---------------------- | --------------------------- | ------------ |
| a    | \[0]                   | > -1                        | 0            |
| c    | \[2]                   | > 0                         | 2            |
| e    | \[4]                   | > 2                         | 4            |

✅ All found → subsequence

---

## 🧑‍💻 Java Code

```java
import java.util.*;

public class Solution {

    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int n = s.length();

        // Step 1: Build character index map
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        int result = 0;

        // Step 2: Check each word
        for (String word : words) {
            int prev = -1;
            boolean isSubseq = true;

            for (char ch : word.toCharArray()) {
                if (!map.containsKey(ch)) {
                    isSubseq = false;
                    break;
                }

                int idx = findNextIndex(prev, map.get(ch));
                if (idx == -1) {
                    isSubseq = false;
                    break;
                }

                prev = idx;
            }

            if (isSubseq) {
                result++;
            }
        }

        return result;
    }

    // Step 3: Binary Search
    public int findNextIndex(int prev, List<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) > prev) {
                ans = arr.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};

        int result = sol.numMatchingSubseq(s, words);
        System.out.println("Matching Subsequences Count: " + result); // Output: 3
    }
}
```

---

## 📈 Time & Space Complexity

| Operation                   | Time Complexity                        | Space Complexity |
| --------------------------- | -------------------------------------- | ---------------- |
| Preprocessing `s`           | O(N)                                   | O(N)             |
| For each word (M total)     | O(M \* L \* logK)                      | O(1)             |
| Binary Search per character | O(logK), where K = size of map.get(ch) | -                |

* **N** = length of string `s`
* **M** = number of words
* **L** = average length of word
* **K** = occurrences of character in `s`

### 🔹 Total Time:

`O(N + M * L * logK)`

Efficient enough for:

* N ≤ 50,000
* M ≤ 5,000
* L ≤ 50

---

## 🧠 Tips

* Always preprocess static inputs if you're querying multiple times.
* Binary search can turn linear scans into logarithmic time — use it for optimization.
* `computeIfAbsent()` is super handy for building maps with default values.

---

## ✅ Conclusion

This problem is a great example of:

* Efficient **preprocessing**
* Using **binary search** to save time
* Avoiding brute force with **clever indexing**

It also builds strong intuition on **subsequences**, **hashing**, and **search optimization**.

---

## 📚 Related Topics

* HashMap
* Binary Search
* Two Pointers
* Subsequence Checking
* Greedy Algorithms
