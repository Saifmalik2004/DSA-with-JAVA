# 🏛️ Integer to Roman Conversion

## 📘 Problem Statement

Convert an integer into its **Roman numeral** representation.

Roman numerals follow specific patterns, e.g.:

| Symbol | Value |
| ------ | ----- |
| M      | 1000  |
| CM     | 900   |
| D      | 500   |
| CD     | 400   |
| C      | 100   |
| XC     | 90    |
| L      | 50    |
| XL     | 40    |
| X      | 10    |
| IX     | 9     |
| V      | 5     |
| IV     | 4     |
| I      | 1     |

---

## 💡 Intuition

The Roman numeral system is **greedy**:
We subtract the largest possible Roman value from the integer and append its symbol repeatedly until the number is reduced to 0.

---

## 🛠️ Approach

1. Create two arrays:

   * `map[]` → for Roman numeral values in descending order
   * `roman[]` → for corresponding Roman symbols

2. Use a loop to:

   * Find how many times each Roman numeral fits into the number
   * Append the symbol that many times
   * Reduce the number (`digit %= map[i]`)

3. Continue until the full number is converted.

---

## ✅ Example

```java
calculate(8)
```

**Steps:**

* 8 >= 5 → append "V", remainder = 3
* 3 >= 1 → append "I" 3 times

**Result:** `"VIII"`

---

## 📈 Time & Space Complexity

* **Time Complexity:**
  $O(1)$ — Roman numerals have at most 13 symbols, so loop is constant.

* **Space Complexity:**
  $O(1)$ — StringBuilder grows linearly with number of symbols, max constant for given range.

---

## 🧾 Code

```java
public class Solution {
    
    public static String calculate(int digit) {
        int map[] =    {1000, 900, 500, 400, 100, 90,  50, 40, 10, 9, 5, 4, 1};
        String roman[] = {"M", "CM", "D", "CD", "C", "XC","L","XL","X","IX","V","IV","I"};

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            int times = digit / map[i];
            while (times-- > 0) {
                ans.append(roman[i]);
            }
            digit %= map[i];
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(calculate(8)); // Output: VIII
    }   
}
```

---

## 🧠 Notes

* This logic supports integers from 1 to 3999 (as per Roman numeral conventions).
* It uses a **greedy algorithm** — always subtract the biggest possible value.

---
