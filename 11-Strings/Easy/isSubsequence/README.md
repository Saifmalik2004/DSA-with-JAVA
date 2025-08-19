
# 📌 Is Subsequence (LeetCode 392)

## 📝 Problem Statement
Given two strings **s** and **t**, return **true** if `s` is a subsequence of `t`, or **false** otherwise.

👉 A **subsequence** of a string is a new string formed by deleting some (can be none) of the characters from the original string without disturbing the relative positions of the remaining characters.  
- Example: `"abc"` is a subsequence of `"ahbgdc"` because we can delete `'h'`, `'g'`, and `'d'`.  
- Example: `"axc"` is **not** a subsequence of `"ahbgdc"` because `'x'` does not appear in `t`.

---

## 🔍 Examples

### Example 1
```

Input: s = "abc", t = "ahbgdc"
Output: true
Explanation: "abc" can be formed from "ahbgdc" by deleting 'h', 'g', and 'd'.

```

### Example 2
```

Input: s = "axc", t = "ahbgdc"
Output: false
Explanation: 'x' does not appear in "ahbgdc".

```

### Example 3
```

Input: s = "", t = "ahbgdc"
Output: true
Explanation: The empty string is always a subsequence of any string.

```

---

## 💡 Intuition
The problem is asking us to check if all characters of `s` appear in `t` **in the same order**, though not necessarily contiguously.

This immediately suggests a **two-pointer technique**:
- Use one pointer `i` to track the position in `s`.
- Use another pointer `j` to track the position in `t`.
- Traverse `t`. Every time characters match (`s[i] == t[j]`), move `i` forward.
- If at the end, `i` has reached the length of `s`, it means all characters of `s` were found in `t` in order.

---

## 🛠️ Approaches

### ✅ Approach 1: Two Pointers (Greedy)
This is the most intuitive and efficient approach.

#### Pseudocode
```

function isSubsequence(s, t):
i = 0, j = 0
while i < len(s) and j < len(t):
if s\[i] == t\[j]:
i++
j++
return i == len(s)

````

#### Java Implementation
```java
public class Solution {

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length();

        while (i < n && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        // Test case 1
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Output 1: " + isSubsequence(s1, t1)); // true

        // Test case 2
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Output 2: " + isSubsequence(s2, t2)); // false

        // Test case 3
        String s3 = "";
        String t3 = "ahbgdc";
        System.out.println("Output 3: " + isSubsequence(s3, t3)); // true
    }
}
````

#### Complexity Analysis

* **Time Complexity**: `O(|t|)` because we traverse through string `t` once.
* **Space Complexity**: `O(1)` since we only use two pointers.

---

### ✅ Approach 2: Dynamic Programming (Subsequence Check via LCS)

Another way is to check if `s` is a subsequence of `t` using the **Longest Common Subsequence (LCS)** approach.

* If `LCS(s, t) == length(s)`, then `s` is a subsequence of `t`.

#### Pseudocode

```
function isSubsequence(s, t):
    m = len(s), n = len(t)
    dp = 2D array (m+1, n+1)

    for i in 0..m:
        for j in 0..n:
            if s[i-1] == t[j-1]:
                dp[i][j] = 1 + dp[i-1][j-1]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])

    return dp[m][n] == m
```

#### Java Implementation

```java
public static boolean isSubsequenceDP(String s, String t) {
    int m = s.length(), n = t.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[m][n] == m;
}
```

#### Complexity Analysis

* **Time Complexity**: `O(|s| * |t|)` because we fill a 2D DP table.
* **Space Complexity**: `O(|s| * |t|)` (can be optimized to `O(min(|s|, |t|))`).

⚠️ This approach is **overkill** for this problem, but useful for learning.

---

### ✅ Approach 3: Preprocessing + Binary Search (Efficient for Multiple Queries)

If we are given **multiple `s` strings** and a single large `t`, we can preprocess `t`:

1. Store the indices of each character in `t` in a HashMap.
2. For each character in `s`, use **binary search** to find the next valid index.

#### Complexity

* **Preprocessing Time**: `O(|t|)`
* **Query Time**: `O(|s| log |t|)`
* **Best for multiple queries.**

---

## 🎯 Key Takeaways

* The **two-pointer approach** is the best solution: `O(|t|)` time, `O(1)` space.
* The **DP solution** teaches us about subsequence via LCS but is not optimal.
* The **binary search approach** is useful when we have multiple queries on the same string `t`.

---

## 📊 Complexity Comparison

| Approach                      | Time Complexity | Space Complexity | Best Use Case |      |              |    |   |    |   |   |                        |
| ----------------------------- | --------------- | ---------------- | ------------- | ---- | ------------ | -- | - | -- | - | - | ---------------------- |
| Two Pointers (Greedy)         | O(              | t                | )             | O(1) | Single query |    |   |    |   |   |                        |
| Dynamic Programming (LCS)     | O(              | s                | ×             | t    | )            | O( | s | ×  | t | ) | Learning/understanding |
| Preprocessing + Binary Search | O(              | t                | +             | s    | log          | t  | ) | O( | t | ) | Multiple queries       |

---

## ✅ Final Thoughts

* Start with **two pointers** for simplicity.
* Understand **DP (LCS)** for deeper learning.
* Use **preprocessing + binary search** for advanced scenarios with multiple queries.

This problem is a great example of how **different approaches** can solve the same problem with varying efficiency. 🚀
