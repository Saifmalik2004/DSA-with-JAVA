
# 🔒 Number of Laser Beams in a Bank

## 📝 Problem Statement

You are given a 2D matrix in the form of an array of binary strings `bank`, where:

* Each string represents a **row** in the security bank.
* Each `'1'` represents a **security device**.
* Each `'0'` represents an **empty spot**.

A **laser beam** is formed between **two rows** if:

1. Both rows contain **at least one device**.
2. The number of beams between them =
   `(#devices in row1 × #devices in row2)`.
3. Beams are only formed between **consecutive rows that both contain devices** (rows with 0 devices are ignored/skipped).

We need to return the **total number of beams** in the bank.

---

## 🔍 Example

### Example 1

```
Input:
bank = ["011001", "000000", "010100", "001000"]

Row 0 → "011001" → devices = 3  
Row 1 → "000000" → devices = 0 (skip)  
Row 2 → "010100" → devices = 2  
Row 3 → "001000" → devices = 1  

Beams:
Row0 (3 devices) → Row2 (2 devices) = 3×2 = 6  
Row2 (2 devices) → Row3 (1 device) = 2×1 = 2  

Total = 8
```

---

## 🧠 Intuition

* Every row has a number of devices (count of `'1'`).
* Only **consecutive non-empty rows** contribute to beams.
* Beams between two valid rows = `prevRowDevices × currentRowDevices`.

So the problem reduces to:

1. Count devices in each row.
2. Skip empty rows.
3. Multiply with previous non-empty row’s devices.
4. Accumulate the result.

---

## ✨ Approaches

### **1. Brute Force (O(m × n × m))**

* For every row with devices, check every next row.
* Skip empty rows.
* Multiply device counts and add beams.

❌ Too slow (quadratic checking).

---

### **2. Optimized Approach (O(m × n))** ✅

Instead of checking all pairs:

* Keep track of the **previous row with devices** (`prev`).
* For each row:

  * Count devices.
  * If devices > 0:

    * Add `prev × count` to result.
    * Update `prev = count`.

This ensures only **consecutive non-empty rows** are used.

---

## 📑 Pseudocode

```
prev = 0
res = 0
for each row in bank:
    count = number of '1's in row
    res += prev * count
    if count != 0:
        prev = count
return res
```

---

## 💻 Java Code

```java
class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;   // devices in previous non-empty row
        int res = 0;

        for (int i = 0; i < bank.length; i++) {
            String s = bank[i];
            int count = 0;

            // count devices in current row
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }
            }

            // add beams between prev and current row
            res += (prev * count);

            // update prev only if row has devices
            if (count != 0) {
                prev = count;
            }
        }
        return res;
    }
}
```

---

## 🧑‍💻 Dry Run

`s = ["011001","000000","010100","001000"]`

* Row0: count=3 → res += 0×3=0 → prev=3
* Row1: count=0 → res unchanged → prev stays 3
* Row2: count=2 → res += 3×2=6 → prev=2
* Row3: count=1 → res += 2×1=2 → prev=1

Final `res = 8`.

---

## 📊 Complexity Analysis

* **Time Complexity:** O(m × n)

  * m = number of rows, n = length of each row.
  * We scan each row once and count devices.
* **Space Complexity:** O(1)

  * Only a few variables for tracking.

---

## ✅ Key Takeaways

* Instead of comparing every pair of rows, just keep track of the **last non-empty row**.
* This makes the solution linear with respect to matrix size.
* Clean and efficient for large inputs.

---
