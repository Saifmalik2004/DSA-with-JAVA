
# 🔢 Find the K-th Element in Two Sorted Arrays

## 📘 Problem Statement

You are given two sorted arrays `a[]` and `b[]` and an integer `k`. Your task is to find the **k-th smallest element** in the merged sorted version of the two arrays.

📌 **Note:**

* `k` is **0-based** in the code, meaning `k = 0` is the smallest element.
* Both arrays are sorted in non-decreasing order.

---

## ✨ Example

```java
Input:
a = [1, 4, 5]
b = [2, 3, 6]
k = 4

Merged array = [1, 2, 3, 4, 5, 6]
Output: 5
```

---

## 🧠 Intuition

The goal is to **simulate merging two sorted arrays** and track the `k-th` smallest element without necessarily building the full merged array.

There are 3 known strategies:

| Approach    | Time Complexity   | Space Complexity | Strategy        |
| ----------- | ----------------- | ---------------- | --------------- |
| Brute Force | O(n + m)          | O(n + m)         | Merge and index |
| Better      | O(k)              | O(1)             | Merge till kth  |
| Optimal     | O(log(min(n, m))) | O(1)             | Binary Search   |

Let’s explore all three.

---

## 🔍 Approach 1: Brute Force – Full Merge

### 🔧 Idea

* Merge both arrays into a new array.
* Return the element at index `k`.

### 📜 Pseudocode

```
Initialize pointers i, j = 0
Initialize new array of size a.length + b.length

While i < a.length and j < b.length:
    compare a[i] and b[j]
    insert the smaller into merged array

Copy remaining elements from a and b

Return merged[k]
```

### ✅ Java Code

```java
public class Brute {
    public static int kth(int[] a, int[] b, int k) {
        int n1 = a.length;
        int n2 = b.length;
        int[] merge = new int[n1 + n2];
        int i = 0, j = 0, idx = 0;

        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                merge[idx++] = a[i++];
            } else {
                merge[idx++] = b[j++];
            }
        }

        while (i < n1) merge[idx++] = a[i++];
        while (j < n2) merge[idx++] = b[j++];

        return merge[k]; // 0-based index
    }
}
```

### ⏱️ Complexity

* **Time:** `O(n + m)`
* **Space:** `O(n + m)`

### 🚫 Drawbacks

* Extra space used for merged array
* Unnecessary work done even if we only need up to the k-th element

---

## 🔍 Approach 2: Better – Two Pointer (No Extra Space)

### 🔧 Idea

* Simulate the merge process like Merge Sort
* Stop once the `k-th` element is found (no need to store full merge)

### 📜 Pseudocode

```
Initialize pointers i = 0, j = 0, count = 0

While i < a.length and j < b.length:
    If a[i] < b[j], check if count == k, return a[i]
    Else, check if count == k, return b[j]
    Increment count

Check remaining elements from a or b
```

### ✅ Java Code

```java
public class Better {
    public static int kth(int[] a, int[] b, int k) {
        int i = 0, j = 0, count = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (count == k) return a[i];
                i++;
            } else {
                if (count == k) return b[j];
                j++;
            }
            count++;
        }

        while (i < a.length) {
            if (count == k) return a[i];
            i++; count++;
        }

        while (j < b.length) {
            if (count == k) return b[j];
            j++; count++;
        }

        return -1;
    }
}
```

### ⏱️ Complexity

* **Time:** `O(k)`
* **Space:** `O(1)`

### ✅ Benefits

* No extra space used
* Efficient if `k` is small

---

## 🔍 Approach 3: Optimal – Binary Search

### 🔧 Intuition

Use **binary search on the smaller array** to partition both arrays such that:

```
max(leftA, leftB) <= min(rightA, rightB)
```

If this condition holds, `max(leftA, leftB)` is the k-th element.

We are trying to find the correct partition.

### 📜 Pseudocode

```
Binary search on smaller array

low = max(0, k - len(b))
high = min(k, len(a))

while low <= high:
    mid1 = (low + high) / 2
    mid2 = k - mid1

    l1 = a[mid1 - 1] or -∞ if mid1 == 0
    r1 = a[mid1] or ∞ if mid1 == n1

    l2 = b[mid2 - 1] or -∞ if mid2 == 0
    r2 = b[mid2] or ∞ if mid2 == n2

    if l1 <= r2 and l2 <= r1:
        return max(l1, l2)
    else if l1 > r2:
        high = mid1 - 1
    else:
        low = mid1 + 1
```

### ✅ Java Code

```java
public class Optimize {
    public static int findKthElement(int[] a, int[] b, int k) {
        int n1 = a.length, n2 = b.length;

        if (n1 > n2) return findKthElement(b, a, k);

        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;

            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }
}
```

### ⏱️ Complexity

* **Time:** `O(log(min(n, m)))`
* **Space:** `O(1)`

### ✅ Benefits

* Extremely efficient for large arrays
* No additional space required

---

## 🎯 When to Use What?

| Scenario              | Best Approach           |
| --------------------- | ----------------------- |
| Small arrays          | Brute or Better         |
| k is very small       | Better                  |
| Large arrays, large k | Optimal (Binary Search) |

---

## 📦 Sample Usage

```java
int[] a = {1, 4, 5};
int[] b = {2, 3, 6};
int k = 4; // 0-based → 5th element

System.out.println(Brute.kth(a, b, k));      // Output: 5
System.out.println(Better.kth(a, b, k));     // Output: 5
System.out.println(Optimize.findKthElement(a, b, k)); // Output: 5
```

---

## 🧠 Final Thoughts

This problem is a perfect case to show how different levels of optimization improve both time and space efficiency. The **binary search solution** is particularly powerful and lays the groundwork for problems like **Median of Two Sorted Arrays**.

