
# 🔄 Reverse a String (In-place)

## 📌 Problem Statement
Given a character array `s`, reverse the array **in-place** (without using extra space for another array).

You must modify the input array directly and **not return anything**.

---

## 🔍 Example

### Example 1:
**Input**  
```

s = \['h','e','l','l','o']

```
**Output**  
```

\['o','l','l','e','h']

```

---

### Example 2:
**Input**  
```

s = \['H','a','n','n','a','h']

```
**Output**  
```

\['h','a','n','n','a','H']

````

---

## 💡 Intuition
Reversing a string is essentially **swapping the first character with the last**,  
the second with the second-last, and so on, until we reach the middle.

We can use **two pointers**:
- `i` starts at the beginning (`0`)
- `j` starts at the end (`s.length - 1`)

Swap `s[i]` and `s[j]`, move `i` forward and `j` backward, repeat until `i >= j`.

---

## 🛠 Pseudocode
```plaintext
function reverseString(s):
    i ← 0
    j ← length(s) - 1
    while i < j:
        swap s[i] and s[j]
        i ← i + 1
        j ← j - 1
````

---

## 🧮 Complexity Analysis

* **Time Complexity:** O(n)
  We process each element at most once.
* **Space Complexity:** O(1)
  Only a few variables are used for swapping, no extra data structures.

---

## 📄 Java Implementation

```java
public class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        // Example input
        char[] arr = {'h', 'e', 'l', 'l', 'o'};

        System.out.println("Before reverse: " + String.valueOf(arr));
        obj.reverseString(arr);
        System.out.println("After reverse: " + String.valueOf(arr));
    }
}
```

---

## 📌 Why This Works

* Two-pointer swapping avoids creating extra copies of the string.
* In-place reversal makes it memory efficient.
* Works for **any size** array, including edge cases:

  * Empty array `[]`
  * Single-character array `['a']`

---

## 🔄 Possible Variations

1. Reverse only a **substring** within a larger array.
2. Reverse a string **by words** rather than characters.
3. Reverse using **recursion** instead of iteration.

---

## 🎯 Conclusion

This is one of the simplest yet fundamental problems in programming.
Mastering in-place reversal is crucial as it’s a building block for many algorithms in arrays, strings, and linked lists.

```
