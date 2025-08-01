# 🧮 Median in a Row-wise Sorted Matrix

## 🧩 Problem Statement

You are given a **row-wise sorted matrix** of odd dimensions (odd rows × odd columns). Your task is to find the **median** of all the elements in the matrix.

> 📌 **Important Constraint**:

* The number of rows `n` and columns `m` is always **odd**, so the total number of elements `(n × m)` will also be **odd**.
* Since the number of elements is odd, the **median** is the middle element when all elements are sorted.

---

## 🧠 Understanding the Median

Given an unsorted list of `N` odd numbers, the **median** is:

```
median = list[N / 2]
```

(after sorting the list)

---

## 💡 Example

### Input:

```java
matrix = {
    {1, 4, 7},
    {2, 5, 8},
    {3, 6, 9}
}
```

### Flattened and Sorted:

```
[1, 2, 3, 4, 5, 6, 7, 8, 9]
```

### Output:

```
Median = 5
```

---

## ✅ Approach 1: Brute Force

### 🔹 Intuition:

* Flatten the matrix into a single list.
* Sort the list.
* Return the middle element.

---

### 📋 Pseudocode:

```
create empty list
for each row in matrix:
    for each element in row:
        add element to list
sort the list
return element at index list.size() / 2
```

---

### 💻 Java Code:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brute {
    public static int median(int[][] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                list.add(arr[i][j]);
            }
        }

        Collections.sort(list);

        return list.get(list.size() / 2);
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        System.out.println("Median (Brute): " + median(matrix));
    }
}
```

---

### ⏱️ Time & Space Complexity:

| Metric | Value                                 |
| ------ | ------------------------------------- |
| Time   | `O(n * m log(n * m))` (for sorting)   |
| Space  | `O(n * m)` (for storing all elements) |

---

## 🚀 Approach 2: Binary Search on Value Range (Optimized)

### 🔹 Intuition:

Since each row is sorted, instead of flattening and sorting, we can perform **binary search** on the **value range** of the matrix.

---

### 🧠 Key Idea:

1. Set search range from the **smallest element** to the **largest element** in the matrix.
2. For a middle value `mid`, count how many elements are **less than or equal to** `mid`.
3. If that count is less than or equal to `(n * m) / 2`, move `low = mid + 1`; else, `high = mid - 1`.
4. The **first value** where `count > (n * m) / 2` is the **median**.

---

### 📋 Pseudocode:

```
low = minimum in matrix
high = maximum in matrix

while low <= high:
    mid = (low + high) / 2
    count = count of elements <= mid in matrix
    if count <= (n * m) / 2:
        low = mid + 1
    else:
        high = mid - 1

return low
```

---

### 💻 Java Code:

```java
public class Better {
    public static int median(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Determine search range
        for (int i = 0; i < n; i++) {
            low = Math.min(low, arr[i][0]);
            high = Math.max(high, arr[i][m - 1]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int less = countLessThanEqual(arr, mid);

            if (less <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static int countLessThanEqual(int[][] arr, int x) {
        int count = 0;
        for (int[] row : arr) {
            count += upperBound(row, x);
        }
        return count;
    }

    public static int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        System.out.println("Median (Better): " + median(matrix));
    }
}
```

---

### ⏱️ Time & Space Complexity:

| Metric | Value                        |
| ------ | ---------------------------- |
| Time   | `O(log(range) * n * log(m))` |
| Space  | `O(1)` (no extra space)      |

Where `range = maxVal - minVal` in the matrix.

---

## 📊 Comparison Table

| Approach      | Time Complexity             | Space Complexity | Suitable For                   |
| ------------- | --------------------------- | ---------------- | ------------------------------ |
| Brute Force   | O(n \* m log(n \* m))       | O(n \* m)        | Small matrices                 |
| Binary Search | O(log(range) \* n \* log m) | O(1)             | Large row-wise sorted matrices |

---

## 🎯 Conclusion

* Use **Brute Force** for quick implementations or small input sizes.
* Use the **Optimized Binary Search on Value Range** approach when dealing with large row-wise sorted matrices.
* The key optimization leverages the fact that **each row is sorted**, allowing binary search within rows.

---
