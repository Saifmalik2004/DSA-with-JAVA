
# Reverse String II — Detailed Explanation

## 📌 Problem Statement

You are given a string `s` and an integer `k`.  
You need to reverse the first `k` characters for every `2k` characters counting from the start of the string.  
If there are fewer than `k` characters left, reverse all of them.  
If there are between `k` and `2k` characters left, reverse the first `k` characters and leave the rest as they are.

---

## 🔍 Example

### Example 1:
```

Input: s = "abcdefg", k = 2
Output: "bacdfeg"

```
**Explanation:**  
- Reverse the first 2 characters → `"ba"` + `"cdefg"` → `"bacdefg"`  
- Skip the next 2 characters → `"bacd"` + `"efg"`  
- Reverse the next 2 characters starting at index 4 → `"bacdfe"` + `"g"` → `"bacdfeg"`

---

### Example 2:
```

Input: s = "abcd", k = 4
Output: "dcba"

```
**Explanation:**  
- Less than or equal to `k` characters → reverse all.

---

## 💡 Intuition

The problem has a **fixed interval pattern**:
- Every **2k block**: Reverse the first **k** characters, leave the next **k** characters unchanged.
- This repeats until the string ends.

So instead of thinking about reversing *random segments*, we can just:
1. Convert the string into a `char[]` (so we can modify it in-place).
2. For each chunk of size `2k`:
   - Reverse the first `k` characters in that chunk.
3. Return the modified string.

---

## 🛠 Approaches

### **Approach 1 — Brute Force (Substring Manipulation)**
1. Break the string into chunks of size `2k`.
2. Reverse the first `k` characters in each chunk manually using `StringBuilder.reverse()`.
3. Concatenate the results.

**Why it’s bad:**  
- `String` concatenation repeatedly creates new strings → **O(n²)** time.
- Extra space for building the result string.

---

### **Approach 2 — Optimal In-Place Reversal (Two-Pointer Swap) ✅**
We can use **two pointers** to reverse the first `k` characters in-place for every `2k` interval.

#### Steps:
1. Convert `s` into a `char[]`.
2. Iterate `i` from `0` to `n` in steps of `2k`.
3. For each step:
   - Reverse from `i` to `min(i + k - 1, n - 1)` using two pointers.

---

## 📝 Pseudocode

```

function reverseStr(s, k):
arr = s.toCharArray()
n = length of arr

```
for i = 0 to n-1 step 2*k:
    left = i
    right = min(i + k - 1, n - 1)
    reverse(arr, left, right)

return new String(arr)
```

function reverse(arr, left, right):
while left < right:
swap(arr\[left], arr\[right])
left++
right--

````

---

## 💻 Java Implementation

```java
public class Solution {
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            reverse(arr, left, right);
        }

        return new String(arr);
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String result = reverseStr(s, k);
        System.out.println(result); // Expected: "bacdfeg"
    }
}
````

---

## ⏳ Time Complexity

* **O(n)** — Each character is swapped at most once.

## 💾 Space Complexity

* **O(n)** if considering the char array as extra space.
* **O(1)** auxiliary space (in-place swaps, no extra data structures).

---

## 📚 Why This Works

* The problem has a **fixed repetitive pattern** → perfect for chunk-based iteration.
* By using **in-place swapping**, we avoid costly string concatenations.
* The `Math.min()` ensures we don't reverse beyond the string length, handling edge cases.

---

## 📌 Key Takeaways

* Always convert immutable `String` to `char[]` for in-place edits in Java.
* Problems with "every k characters" often have **repeating patterns** that allow simple iteration.
* Using **two-pointer swapping** is optimal for in-place reversals.

---
