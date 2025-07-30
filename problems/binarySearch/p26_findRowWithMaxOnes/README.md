
# 🧠 Row with Maximum Number of 1's

## 🔍 Problem Statement

Given a binary matrix (a matrix containing only `0s` and `1s`), **find the index of the row that contains the maximum number of 1's**.

If multiple rows have the same number of 1’s, return the one with the **lowest index**.

> **Note:** Rows are not necessarily of equal length.
> You can assume rows are sorted in non-decreasing order (all `0`s before `1`s).

---

## 🧾 Input & Output

### ✅ Input:

A 2D binary matrix like this:

```java
[
 [0, 1, 1],
 [1, 1, 1],
 [0, 0, 0]
]
```

### 🔁 Output:

```
1
```

Because row 1 has 3 ones, which is the maximum.

---

## 📘 Example

### Input:

```
[
 [0, 1, 1],
 [1, 1, 1],
 [0, 0, 0]
]
```

### Output:

```
1
```

---

## 🧠 Intuition

We are looking for the row that has the most 1’s. If rows are sorted (0s followed by 1s), we can take advantage of this:

* **Naive way**: Count 1s in each row.
* **Optimized way**: Use **Binary Search** in each row to find the first `1`. All elements after that will be `1`.

---

## ✨ Approach 1: Brute Force

### 🚶 Logic

* For each row, count how many `1`s are there.
* Keep track of the row with the highest count.

### 📋 Pseudocode

```
max = Integer.MIN
idx = -1
for each row i in matrix:
    count = 0
    for each cell j in row:
        if matrix[i][j] == 1:
            count++
    if count > max:
        max = count
        idx = i
return idx
```

### ✅ Java Code

```java
public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix) {
    int max = Integer.MIN_VALUE;
    int idx = -1;

    for (int i = 0; i < matrix.size(); i++) {
        int count = 0;
        for (int j = 0; j < matrix.get(i).size(); j++) {
            if (matrix.get(i).get(j) == 1) count++;
        }
        if (count > max) {
            max = count;
            idx = i;
        }
    }

    return idx;
}
```

### ⏱ Time Complexity: `O(N * M)`

Where `N` = number of rows, `M` = max number of columns.

### 💾 Space Complexity: `O(1)`

---

## ⚡ Approach 2: Optimized Using Binary Search

### 🧠 Intuition

If each row is sorted (0s then 1s), we can use **Binary Search** to find the **first `1`** in each row.

* Index of the first `1` = starting point of 1s.
* So, `countOf1s = row.size() - index_of_first_1`

### 📋 Pseudocode

```
max = Integer.MIN
idx = -1
for each row i in matrix:
    binary search to find first index of 1
    count = row.length - first_1_index
    if count > max:
        max = count
        idx = i
return idx
```

### ✅ Java Code

```java
public static int rowWithMax1s(ArrayList<ArrayList<Integer>> matrix) {
    int max = Integer.MIN_VALUE;
    int idx = -1;

    for (int i = 0; i < matrix.size(); i++) {
        int low = 0;
        int high = matrix.get(i).size() - 1;
        int firstOneIndex = matrix.get(i).size(); // If no 1 is found

        // Binary Search to find first 1
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix.get(i).get(mid) == 1) {
                firstOneIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int count = matrix.get(i).size() - firstOneIndex;
        if (count > max) {
            max = count;
            idx = i;
        }
    }

    return idx;
}
```

### ⏱ Time Complexity: `O(N * log M)`

Binary search on each row (log M), repeated N times.

### 💾 Space Complexity: `O(1)`

---

## ❗ Caveats / Edge Cases

* Matrix may have rows with **all 0s** → count will be 0.
* If all rows have same number of 1s → return row with **lowest index**.
* Unequal row sizes → make sure your code dynamically checks row size.

---

## 🧪 Test Cases

### ✅ Test Case 1

```
Input: [
 [0, 1, 1],
 [1, 1, 1],
 [0, 0, 0]
]
Output: 1
```

### ✅ Test Case 2

```
Input: [
 [0, 0, 1, 1],
 [0, 1, 1, 1],
 [0, 0, 0, 0]
]
Output: 1
```

### ✅ Test Case 3

```
Input: [
 [0, 0, 0],
 [0, 0, 1],
 [0, 1, 1]
]
Output: 2
```

---

## 🏁 Conclusion

* Brute Force is simple, good for unsorted rows.
* Binary Search takes advantage of sorted rows and significantly reduces time.

