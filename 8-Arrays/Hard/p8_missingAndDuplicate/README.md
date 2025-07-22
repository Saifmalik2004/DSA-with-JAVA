
# 📌 Problem: Find the Duplicate and Missing Number

## 🧩 **Problem Statement**

You are given an array of `n` integers where:

* The array contains numbers from **1 to n**
* One **number is duplicated**
* One **number is missing**

👉 Your task is to **find both numbers** and return them as `[duplicate, missing]`.

---

## 📋 Example:

```plaintext
Input:  arr = [2, 3, 5, 1, 6, 1]
Output: [1, 4]
Explanation:
- Number 1 is repeated (duplicate)
- Number 4 is missing
```

---

# 🚀 Approaches

---

## ✅ **1. Brute Force Using Frequency Map (Better Approach)**

### 🔍 Approach:

* Use a `HashMap` to track the frequency of each number.
* The number with frequency > 1 is the **duplicate**.
* Then calculate the **expected sum** of 1 to n and subtract the current array sum (excluding duplicate) to find the **missing** number.

### 🧠 Steps:

1. Create a HashMap to store frequencies.
2. Traverse the array and find the duplicate.
3. Calculate the actual sum of the array and subtract the duplicate.
4. Use formula sum of 1 to n: `n(n+1)/2`.
5. Missing = Expected sum - (actual sum - duplicate)

### 🧑‍💻 Code:

```java
import java.util.*;

public class Better {
    public static List<Integer> find(int arr[], int n) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int sum = (n * (n + 1)) / 2;
        int arraySum = 0;

        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            arraySum += arr[i];
            if (freq.get(arr[i]) > 1) {
                ans.add(arr[i]); // duplicate found
                break;
            }
        }

        arraySum = arraySum - ans.get(0); // simulate correct sum
        ans.add(sum - arraySum);          // missing = expected - actual

        return ans; // [duplicate, missing]
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 1, 6, 1};
        for (int elem : find(arr, 6)) {
            System.out.println(elem);
        }
    }
}
```

### ⏱ Time Complexity: `O(n)`

### 🧠 Space Complexity: `O(n)` (due to HashMap)

---

## ✅ **2. Optimal Math-Based Approach**

### 🔍 Approach:

We know:

* Sum of first `n` numbers: $S = \frac{n(n+1)}{2}$
* Sum of squares of first `n` numbers: $S_2 = \frac{n(n+1)(2n+1)}{6}$

Let:

* x = duplicate
* y = missing

Then:

* $x - y = \text{actualSum} - \text{expectedSum}$
* $x^2 - y^2 = \text{actualSumSq} - \text{expectedSumSq}$

Use:

* $x + y = \frac{(x^2 - y^2)}{(x - y)}$

From these two equations, solve for x and y.

### 🧠 Steps:

1. Calculate actual sum and actual square sum of the array.
2. Use formulas to find:

   * `x - y = sumDiff`
   * `x + y = squareSumDiff / sumDiff`
3. Solve for x and y.

### 🧑‍💻 Code:

```java
public class Optimize {

    public static int[] find(int a[]) {
        int n = a.length;

        // Expected sum and square sum
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSqSum = (long) n * (n + 1) * (2 * n + 1) / 6;

        // Actual sum and square sum
        long actualSum = 0, actualSqSum = 0;
        for (int val : a) {
            actualSum += val;
            actualSqSum += (long) val * val;
        }

        long sumDiff = actualSum - expectedSum;               // x - y
        long squareSumDiff = actualSqSum - expectedSqSum;     // x^2 - y^2

        long sumPlus = squareSumDiff / sumDiff;               // x + y

        long x = (sumDiff + sumPlus) / 2;
        long y = x - sumDiff;

        return new int[]{(int) x, (int) y};
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 1, 6, 1};
        for (int elem : find(arr)) {
            System.out.println(elem);
        }
    }
}
```

### ⏱ Time Complexity: `O(n)`

### 💾 Space Complexity: `O(1)` ✅

---

## ✅ **3. Optimized Space Using In-Place Marking (Alternative Efficient Method)**

📌 Not in your original request, but worth noting:
Another optimized approach involves using **index marking (negation)** if modifying array is allowed.

---

# 🧾 Summary Comparison

| Approach         | Time Complexity | Space Complexity | Suitable For         |
| ---------------- | --------------- | ---------------- | -------------------- |
| HashMap (Better) | O(n)            | O(n)             | Simple, readable     |
| Math (Optimal)   | O(n)            | O(1)             | Best for interviews  |
| In-place Marking | O(n)            | O(1)             | If array mod allowed |

---

# 🧠 Final Notes

* Always validate input: numbers should be from 1 to n.
* In real-world systems, test with large datasets to ensure no overflows (use `long`).
* Math method is preferred in interviews because of its **constant space** and **clever logic**.

---
