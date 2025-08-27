
# 📌 Reverse Words in a String III (LeetCode 557)

## 📝 Problem Statement
Given a string `s`, reverse the order of characters in each word within a sentence while still preserving whitespace and the initial word order.

---

## 🔍 Examples

### Example 1
```

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

```

### Example 2
```

Input: s = "God Ding"
Output: "doG gniD"

```

---

## 💡 Intuition
We are asked to **reverse each word individually** without changing the word order in the sentence.  

- A word is separated by spaces.  
- We must preserve the spaces exactly as they appear.  
- Each word can be reversed independently.  

👉 So the solution boils down to:  
**Split sentence → Reverse each word → Reconstruct sentence.**

---

## 🛠️ Approaches

### ✅ Approach 1: Manual Reversal (Two Pointers) — `Better.java`
This approach avoids extra splitting and reverses each word manually.

#### Steps:
1. Use two pointers (`i` and `j`) to find each word.  
2. Extract the word (`s.substring(i, j)`).  
3. Convert to char array and reverse using a helper function.  
4. Append reversed word to the result, maintaining spaces.  

#### Pseudocode
```

function reverseWords(s):
res = ""
i, j = 0

```
while i < n:
    move j until space or end
    word = substring(i, j)
    reverse(word)
    append word to result
    if j < n: add space
    i = j + 1
return res
```

````

#### Java Implementation
```java
public class Better {
    public static String reverseWords(String s) {
        int i = 0, j = 0, n = s.length();
        StringBuilder res = new StringBuilder();

        while (i < n) {
            // Move j to end of word
            while (j < n && s.charAt(j) != ' ') j++;

            // Reverse the word manually
            char[] ar = s.substring(i, j).toCharArray();
            reverse(0, ar.length - 1, ar);
            res.append(new String(ar));

            // Add space if needed
            if (j < n) {
                res.append(" ");
                j++;
            }

            i = j;
        }

        return res.toString();
    }

    public static void reverse(int left, int right, char[] arr) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        // Expected: "s'teL ekat edoCteeL tsetnoc"
    }
}
````

#### Complexity

* **Time Complexity**: `O(n)` (each character visited once).
* **Space Complexity**: `O(n)` (result + char array).
* Efficient but slightly more code.

---

### ✅ Approach 2: Using `split` + `reverse` — `Optimize.java`

This approach uses **Java built-in methods** for simplicity.

#### Steps:

1. Split sentence by spaces → get words array.
2. For each word, reverse using `StringBuilder.reverse()`.
3. Append reversed word back with spaces.
4. Remove trailing space at the end.

#### Java Implementation

```java
public class Optimize {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            result.append(reversedWord).append(" ");
        }
        result.deleteCharAt(result.length() - 1);  // Remove trailing space
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        // Expected: "s'teL ekat edoCteeL tsetnoc"
    }
}
```

#### Complexity

* **Time Complexity**: `O(n)` (split + reverse each word).
* **Space Complexity**: `O(n)` (extra array for split + result).
* Cleaner, more concise, but extra space for `split`.

---

## 📊 Complexity Comparison

| Approach                    | Time Complexity | Space Complexity | Pros                                 | Cons                       |
| --------------------------- | --------------- | ---------------- | ------------------------------------ | -------------------------- |
| Manual Two-Pointer Reversal | O(n)            | O(n)             | Efficient, no heavy string splitting | More verbose               |
| Split + Built-in Reverse    | O(n)            | O(n)             | Concise, easy to write               | Uses extra space for array |

---

## 🎯 Key Takeaways

* Both approaches run in **O(n) time**.
* The **two-pointer approach** is more manual but avoids unnecessary splitting.
* The **split + reverse approach** is short and elegant, great for interviews if simplicity is valued.
* This problem improves skills in **string parsing** and **in-place reversal**.

🚀 Recommended: Use the **split approach** in coding rounds for clarity. Use the **manual approach** when optimizing space or practicing string manipulation.

