
# 🔢 Compare Version Numbers

## 📝 Problem Statement

You are given two version strings `version1` and `version2`.
Each version string is composed of **revisions** separated by dots `"."`.

* Each revision is a non-negative integer (may contain leading zeros).
* Compare `version1` and `version2` **revision by revision**.
* If one version has fewer revisions, treat the missing parts as `0`.

👉 Return:

* `1` if `version1 > version2`
* `-1` if `version1 < version2`
* `0` if they are equal

---

## 🔍 Examples

### Example 1

```
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation:
Both represent the same revision sequence [1,1].
```

### Example 2

```
Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation:
Trailing zeros don’t affect version value.
```

### Example 3

```
Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation:
At first revision, 0 < 1 → version1 < version2.
```

### Example 4

```
Input: version1 = "1.0.1", version2 = "1"
Output: 1
Explanation:
At first revision both equal → at third revision, 1 > 0.
```

---

## 🧠 Intuition

* Versions are sequences of numbers separated by `"."`.
* Comparing them is **not string comparison**, but **numeric comparison per revision**.
* We need to parse integers from both strings revision by revision.
* If revisions differ → return result immediately.
* If one version ends early, treat missing values as `0`.

---

## ✨ Approach (Two-Pointer Parsing)

Instead of splitting into arrays (which costs extra space), we parse both strings **character by character** using two pointers:

1. Start with `i = 0` for `version1` and `j = 0` for `version2`.
2. Extract numbers until `"."` or end.
3. Compare extracted numbers:

   * If `num1 > num2` → return `1`.
   * If `num1 < num2` → return `-1`.
   * Else, move to next revision (`i++, j++` to skip dot).
4. Continue until both strings are exhausted.
5. If no difference found → return `0`.

---

## 📑 Pseudocode

```
i = 0, j = 0
while i < len(version1) or j < len(version2):
    num1, num2 = 0, 0
    while i<n and version1[i] != '.':
        num1 = num1*10 + (version1[i]-'0')
        i++
    while j<m and version2[j] != '.':
        num2 = num2*10 + (version2[j]-'0')
        j++
    if num1 > num2 → return 1
    if num1 < num2 → return -1
    skip '.' by i++ and j++
return 0
```

---

## 💻 Java Code

```java
public class Solution {
    
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n = version1.length(), m = version2.length();
        
        while (i < n || j < m) {
            int num1 = 0;
            int num2 = 0;
            
            // extract revision from version1
            while (i < n && version1.charAt(i) != '.') {
                num1 = (num1 * 10) + (version1.charAt(i) - '0');
                i++;
            }
            
            // extract revision from version2
            while (j < m && version2.charAt(j) != '.') {
                num2 = (num2 * 10) + (version2.charAt(j) - '0');
                j++;
            }
            
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
            
            // skip '.' character
            i++;
            j++;
        }
        
        return 0;
    }
    
    // Example driver code
    public static void main(String[] args) {
        Solution sol = new Solution();

        String v1 = "1.01";
        String v2 = "1.001";
        String v3 = "1.0";
        String v4 = "1.0.1";

        System.out.println(v1 + " vs " + v2 + " → " + sol.compareVersion(v1, v2)); // 0
        System.out.println(v3 + " vs " + v4 + " → " + sol.compareVersion(v3, v4)); // -1
        System.out.println(v4 + " vs " + v3 + " → " + sol.compareVersion(v4, v3)); // 1
    }
}
```

---

## 🧑‍💻 Dry Run

Input: `version1 = "1.0.1"`, `version2 = "1"`

* Step 1: Extract → `num1 = 1`, `num2 = 1` → equal.
* Step 2: Extract → `num1 = 0`, `num2 = 0` (since `version2` ended).
* Step 3: Extract → `num1 = 1`, `num2 = 0` → `1 > 0` → return `1`.

✅ Output: `1`.

---

## 📊 Complexity Analysis

* **Time Complexity:** O(n + m) → each character processed once.
* **Space Complexity:** O(1) → only a few integer variables used.

---

## ✅ Key Takeaways

* Don’t compare as raw strings → `"10"` vs `"2"` must be handled numerically.
* Always treat missing revisions as `0`.
* Two-pointer parsing avoids splitting arrays and keeps it efficient.

---