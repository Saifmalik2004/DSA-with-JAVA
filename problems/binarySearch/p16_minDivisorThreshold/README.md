
# ⚙️ Smallest Divisor Given a Threshold

## 🧾 Problem Statement

You are given an array of positive integers `nums` and an integer `threshold`. You need to find the **smallest integer divisor** such that the **sum of all elements after division and rounding up** is **less than or equal to** `threshold`.

Each element `x` in the array is transformed as:

```text
x' = ceil(x / divisor)
```

Your goal is to **minimize** the divisor.

---

## 📥 Input

```bash
int[] nums = {3, 6, 7, 11}
int threshold = 8
```

---

## 📤 Output

```
Smallest divisor = 4
```

---

## ❓ Example Explanation

### Input:

```java
nums = [3, 6, 7, 11]
threshold = 8
```

Try divisor = 4:

* ceil(3/4) = 1
* ceil(6/4) = 2
* ceil(7/4) = 2
* ceil(11/4) = 3

Total = 1 + 2 + 2 + 3 = **8** ✅

This is the smallest divisor that works.

---

## 💡 Intuition and Approach

This is a **Binary Search on Answer** problem.

### Key Observations:

* If you pick a small divisor, the sum increases.
* If you pick a larger divisor, the sum decreases.
* Hence, the answer space is **monotonic** → binary search applicable.

---

## 🔍 Brute Approach

### ✅ Idea:

* Binary search over possible divisors.
* Use a helper method to **compute the transformed sum** using `ceil(x / divisor)`.

### 🧾 Code:

```java
public class Brute {
    public static int minDiv(int[] arr, int limit) {
        int n = arr.length;
        if (n > limit) return -1;

        int max = 0;
        for (int item : arr) {
            max = Math.max(item, max);
        }

        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (computeSum(arr, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int computeSum(int[] arr, int num) {
        long sum = 0;
        for (int elem : arr) {
            sum += Math.ceil((double)(elem) / num);
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        int arr[] = {3, 6, 7, 11};
        System.out.println(minDiv(arr, 8)); // Output: 4
    }
}
```

---

## 🚀 Optimized Approach (Recommended for Interviews)

### ✅ Idea:

* Perform binary search from 1 to a large upper bound (like 1e6).
* Avoid extra method calls — do everything inline.
* Use `ceil(x / divisor)` trick: `(x + divisor - 1) / divisor`

### 🧾 Code:

## 🔢 Pseudocode

```text
function smallestDivisor(nums, threshold):
    left = 1
    right = max_value (e.g. 1e6)

    while left <= right:
        mid = (left + right) / 2
        sum = 0
        for num in nums:
            sum += ceil(num / mid)
        
        if sum <= threshold:
            right = mid - 1
        else:
            left = mid + 1

    return left
```
---
```java
public class Optimize {
    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currSum = 0;

            for (int num : nums) {
                currSum += (num + mid - 1) / mid; // ceil(num / mid)
            }

            if (currSum <= threshold) {
                right = mid - 1; // Try smaller divisor
            } else {
                left = mid + 1;  // Increase divisor
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int arr[] = {3, 6, 7, 11};
        System.out.println(smallestDivisor(arr, 8)); // Output: 4
    }
}
```

---



## 🕒 Time & Space Complexity

| Metric | Brute         | Optimized     |
| ------ | ------------- | ------------- |
| Time   | O(n log(max)) | O(n log(max)) |
| Space  | O(1)          | O(1)          |

> Both are efficient, but the **Optimized** version is shorter and cleaner for **interview use**.

---

## 📌 Key Takeaways

* Use **binary search on answers** when result space is monotonic.
* Use math tricks like `(x + d - 1) / d` to compute `ceil(x / d)` efficiently.
* Keep helper logic inline if you want better performance and cleaner code.

---
