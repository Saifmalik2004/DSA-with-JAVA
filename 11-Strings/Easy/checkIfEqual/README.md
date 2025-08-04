
# 📘 Problem: **Check If Two String Arrays are Equivalent**

Given two string arrays `word1` and `word2`, the task is to determine whether the two arrays represent the same string when their elements are concatenated in order.

---

## 🧠 Intuition

At first glance, the problem looks simple: just join the arrays and compare the resulting strings. But what if we want to **avoid extra space** or large string allocations? That's where the **optimized character-by-character comparison** comes into play.

This README explains both approaches clearly.

---

## 💡 Problem Statement

Given two string arrays:

```java
String[] word1 = {"ab", "c"};
String[] word2 = {"a", "bc"};
```

They represent the same string `"abc"`. Your task is to return `true` if they are equivalent when concatenated, otherwise `false`.

---

## ✍️ Examples

### Example 1

```
Input:
word1 = ["ab", "c"]
word2 = ["a", "bc"]

Output:
true

Explanation:
"ab" + "c" = "abc"
"a" + "bc" = "abc"
```

### Example 2

```
Input:
word1 = ["aab", "k"]
word2 = ["a", "ab", "k"]

Output:
true
```

---

## ✅ Approach 1: Brute Force (StringBuilder Concatenation)

### 👇 Intuition

Join all strings in both arrays and directly compare them.

### 🧾 Pseudocode

```
1. Create empty string builders for both arrays.
2. Append all elements of arr1 to sb1.
3. Append all elements of arr2 to sb2.
4. Compare sb1 and sb2 using contentEquals.
```

### ✅ Java Code

```java
public static boolean check1(String[] arr1, String[] arr2) {
    StringBuilder st1 = new StringBuilder();
    for (String s : arr1) {
        st1.append(s);
    }

    StringBuilder st2 = new StringBuilder();
    for (String s : arr2) {
        st2.append(s);
    }

    return st1.toString().contentEquals(st2.toString());
}
```

### 🕰️ Time Complexity

* **O(N + M)** where `N` is the total length of strings in `arr1`, and `M` is the total length in `arr2`.

### 🧠 Space Complexity

* **O(N + M)** extra space used for concatenated strings.

### ⚠️ Drawbacks

* Uses additional memory for the entire concatenated string.
* Not memory-efficient for very large strings.

---

## ⚡ Approach 2: Optimized Pointer Traversal (Character-by-Character)

### 👇 Intuition

Instead of creating new strings, we can **compare characters one by one** using pointers. Treat the string arrays like streams and consume one character at a time from both arrays.

### 🧾 Pseudocode

```
1. Initialize two pointers word1 and word2 for the two arrays.
2. For each word, initialize character index pointers i and j.
3. While both arrays are not completely traversed:
    a. If current characters match:
        i. Move character pointers (i and j).
        ii. If at end of word, move to next word and reset index.
    b. Else return false.
4. After loop, return true.
```

### ✅ Java Code

```java
public static boolean check(String[] arr1, String[] arr2) {
    int word1 = 0, word2 = 0;
    int i = 0, j = 0;

    while (word1 < arr1.length && word2 < arr2.length) {
        if (arr1[word1].charAt(i) != arr2[word2].charAt(j)) {
            return false;
        }

        i++;
        if (i == arr1[word1].length()) {
            i = 0;
            word1++;
        }

        j++;
        if (j == arr2[word2].length()) {
            j = 0;
            word2++;
        }
    }

    return word1 == arr1.length && word2 == arr2.length;
}
```

### 🕰️ Time Complexity

* **O(N + M)** — Total characters compared.

### 🧠 Space Complexity

* **O(1)** — No extra space used apart from pointers.

### ✅ Benefits

* Memory-efficient.
* Fast, since it exits early on mismatch.

---

## 🧪 Sample Test Case

```java
public static void main(String[] args) {
    String[] a = {"aab", "k"};
    String[] b = {"a", "ab", "k"};

    System.out.println(check1(a, b)); // true
    System.out.println(check(a, b));  // true
}
```

---

## 🧾 Conclusion

| Approach          | Time Complexity | Space Complexity | Best For                           |
| ----------------- | --------------- | ---------------- | ---------------------------------- |
| Brute Force       | O(N + M)        | O(N + M)         | Small inputs or quick prototyping  |
| Pointer Traversal | O(N + M)        | O(1)             | Large inputs and memory efficiency |

---

## 🚀 Bonus

If asked in an interview:

* Start with brute-force for clarity.
* Then move to optimized solution with pointers.
* Explain tradeoffs clearly (space vs simplicity).

---

## 📚 Similar Problems

* [LeetCode #1662](https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/)
* Compare Streams in Java
* String concatenation vs streaming comparison

---
