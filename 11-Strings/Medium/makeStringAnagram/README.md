
# 🔤 Minimum Steps to Make Anagram

## 📝 Problem Statement

You are given two strings `s` and `t` of **equal length**.
We want to make `t` an **anagram of `s`**.

👉 An **anagram** of a string is another string that contains the **same characters with the same frequency**, but possibly in a different order.

In one step, you can **replace a character in `t` with any other character**.

Return the **minimum number of steps** required to make `t` an anagram of `s`.

---

## 🔍 Example

### Example 1

```
Input:
s = "bab"
t = "aba"

Output:
1
```

### Explanation

* `s = "bab" → {a:1, b:2}`
* `t = "aba" → {a:2, b:1}`
* To make `t` an anagram of `s`, change one `'a'` in `t` → `'b'`.
* Resulting `t = "bba"` which is an anagram of `"bab"`.
* Minimum steps = 1. ✅

---

## 🧠 Intuition

* Since we only need an anagram, **order does not matter**.
* What matters = **character frequencies**.
* We need to make `t`’s frequency distribution **match `s`’s frequency distribution**.

So:

1. Count frequency of characters in `s`.
2. Subtract frequency of characters in `t`.
3. If any character is extra in `s` (positive difference), that many replacements are needed.

---

## ✨ Approaches

### **1. Brute Force Idea**

* Try replacing characters in `t` one by one until it matches `s`.
* Too slow (comparing sets each time). ❌

---

### **2. Optimized Frequency Approach (O(n))** ✅

* Use an integer array `arr[26]` to track frequency difference between `s` and `t`.
* Loop through both strings:

  * `arr[s[i]-'a']++`
  * `arr[t[i]-'a']--`
* After processing:

  * If `arr[i] > 0`, it means `s` has more of that character.
  * Those excess characters must be added to `ans`.

---

## 📑 Pseudocode

```
if s == t:
    return 0

arr[26] = {0}
for i in range(n):
    arr[s[i]]++
    arr[t[i]]--

ans = 0
for val in arr:
    if val > 0:
        ans += val

return ans
```

---

## 💻 Java Code

```java
class Solution {
    public int minSteps(String s, String t) {
        if (s.equals(t)) return 0;

        int n = s.length(), ans = 0;
        int[] arr = new int[26];

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i : arr) {
            if (i > 0) ans += i;
        }

        return ans;
    }
}
```

---

## 🧑‍💻 Dry Run

`s = "leetcode"`, `t = "practice"`

* Count diff:

  * `s`: l:1, e:3, t:1, c:1, o:1, d:1
  * `t`: p:1, r:1, a:1, c:1, t:1, i:1, c:1, e:1

After subtracting → only positive values matter:

* `l=1, e=2, o=1, d=1` → total = 5

So answer = 5.

---

## 📊 Complexity Analysis

* **Time Complexity:** O(n + 26) → O(n)
* **Space Complexity:** O(26) → O(1) (constant array for letters)

---

## ✅ Key Takeaways

* Order doesn’t matter in anagrams → only **frequency counts** matter.
* Count frequency difference to avoid costly string manipulations.
* Efficient solution runs in **O(n)** with O(1) space.

---