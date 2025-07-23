
# 🔁 Reverse Pair Count

## 📌 Problem Statement

You are given an array `arr[]` of `n` integers. Your task is to count the number of **reverse pairs** in the array.

### ✅ A Reverse Pair is defined as:

A pair of indices `(i, j)` such that:

```

i < j and arr\[i] > 2 \* arr\[j]

```

---

## 📥 Input

- An integer array `arr[]` with `n` elements

## 📤 Output

- Return the **count** of reverse pairs in the array

---

## 🧪 Example

### Input:
```

arr = \[2, 4, 3, 5, 1]

```

### Output:
```

3

````

### 🔍 Dry Run:
Valid reverse pairs are:
- (1, 4) → 4 > 2×1
- (2, 4) → 3 > 2×1
- (3, 4) → 5 > 2×1

So the output is `3`.

---

## 🧠 Intuition

This problem is similar to the **inversion count** problem, but with a different condition.

- **Brute force** approach will use two loops: O(n²)
- **Efficient solution** modifies Merge Sort:
  - While merging two sorted halves, count the number of reverse pairs before merging.

---

## 🛠️ Approach 1: Brute Force

### 🔹 Idea:
Check all pairs `(i, j)` where `i < j`, and see if `arr[i] > 2 * arr[j]`.

### ⏱️ Time Complexity: `O(n²)`

### ✅ Code:

```java
public class BruteForce {
    public static int reversePair(int[] arr) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((long) arr[i] > 2L * arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 1};
        System.out.println(reversePair(arr)); // Output: 3
    }
}
````

---

## 🛠️ Approach 2: Optimized using Merge Sort

### 🔹 Idea:

Use **divide and conquer**:

* Recursively split the array into halves
* Before merging, count reverse pairs using two pointers
* Then merge sorted halves

### ⏱️ Time Complexity: `O(n log n)`

### 📦 Space Complexity: `O(n)` (temporary array during merge)

---

### ✅ Code:

```java
public class Brute {

    public static int reversePair(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += countPair(arr, low, mid, high);
            merge(arr, low, mid, high);
        }
        return count;
    }

    public static int countPair(int arr[], int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        return count;
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;
        int[] temp = new int[high - low + 1];

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        for (i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 3, 5, 1};
        System.out.println(reversePair(arr)); // Output: 3
    }
}
```

---

## 📚 Summary

| Approach         | Time Complexity | Space Complexity | Suitable For     |
| ---------------- | --------------- | ---------------- | ---------------- |
| Brute Force      | O(n²)           | O(1)             | Small input size |
| Merge Sort Based | O(n log n)      | O(n)             | Large input size |

---

## ✅ Tips for Interviews

* Mention that this is a **modified inversion count**
* Always convert to `long` to avoid overflow in `arr[i] > 2 * arr[j]`
* Explain that merge sort ensures elements are compared in sorted halves

---
