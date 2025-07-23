# 🔥 Counting Inversions in an Array 🚀

## 📝 Problem Description
Given an array of integers, an **inversion** occurs when **a pair (i, j) exists such that** `arr[i] > arr[j]` **and** `i < j`. Your task is to count the total number of such inversions in the array.

📌 **Example:**

```plaintext
Input:  [12, 5, 2, 1, 3, 6, 7]
Output: 10
Explanation: There are 10 pairs where arr[i] > arr[j] for i < j.
```

---

## 💡 Brute Force Approach: O(N²)

### 🔹 Explanation
A naive way to solve this problem is by using **two nested loops**:
1. Compare every element `arr[i]` with every element `arr[j]` where `j > i`.
2. If `arr[i] > arr[j]`, increment the count.

### 📝 Pseudocode
```plaintext
count = 0
for i from 0 to N-1:
    for j from i+1 to N:
        if arr[i] > arr[j]:
            count += 1
return count
```

### 🔍 Dry Run
**Input:** `[12, 5, 2, 1, 3, 6, 7]`

| i | j | arr[i] | arr[j] | arr[i] > arr[j] | Count |
|---|---|--------|--------|----------------|-------|
| 0 | 1 | 12     | 5      | ✅             | 1     |
| 0 | 2 | 12     | 2      | ✅             | 2     |
| 0 | 3 | 12     | 1      | ✅             | 3     |
| 0 | 4 | 12     | 3      | ✅             | 4     |
| 0 | 5 | 12     | 6      | ✅             | 5     |
| 0 | 6 | 12     | 7      | ✅             | 6     |
| 1 | 2 | 5      | 2      | ✅             | 7     |
| 1 | 3 | 5      | 1      | ✅             | 8     |
| 1 | 4 | 5      | 3      | ✅             | 9     |
| 2 | 3 | 2      | 1      | ✅             | 10    |

Final Count = **10**

### ✅ Brute Force Code
```java
public class Brute {
    public static void pairArray(int num[]) {
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int arr[] = {12, 5, 2, 1, 3, 6, 7};
        pairArray(arr);
    }
}
```

### ⏳ Complexity Analysis
- **Time Complexity:** `O(N²)`, as we are using two nested loops.
- **Space Complexity:** `O(1)`, as we use only a counter variable.

---

## ⚡ Optimized Approach (Using Merge Sort) - O(N log N)

### 🔹 Explanation
To optimize, we use **Merge Sort** while counting inversions efficiently:
- **Divide**: Split the array into two halves recursively.
- **Conquer**: Count inversions in each half.
- **Merge**: Count cross-inversions when merging.

### 📝 Pseudocode
```plaintext
function mergeSort(arr, start, end):
    if start >= end:
        return 0
    mid = (start + end) / 2
    leftCount = mergeSort(arr, start, mid)
    rightCount = mergeSort(arr, mid+1, end)
    mergeCount = merge(arr, start, mid, end)
    return leftCount + rightCount + mergeCount

function merge(arr, start, mid, end):
    // Merge two sorted halves and count inversions
```

### 🔍 Dry Run
**Input:** `[12, 5, 2, 1, 3, 6, 7]`

1. **Divide**:
   - Left: `[12, 5, 2]`
   - Right: `[1, 3, 6, 7]`
2. **Sort and Count**:
   - Left sorted: `[2, 5, 12]` → `3 inversions`
   - Right sorted: `[1, 3, 6, 7]` → `0 inversions`
3. **Merge Count**:
   - `[1, 2, 3, 5, 6, 7, 12]` → `7 inversions`

Total inversions = `10`

### ✅ Optimized Code (Merge Sort)
```java
public class Optimize {
    public static int mergeSort(int arr[], int start, int end) {
        int count = 0;
        if (start >= end) return count;
        int middle = start + (end - start) / 2;
        count += mergeSort(arr, start, middle);
        count += mergeSort(arr, middle + 1, end);
        count += merge(arr, start, end, middle);
        return count;
    }
    public static int merge(int[] arr, int start, int end, int middle) {
        int temp[] = new int[end - start + 1];
        int i = start, j = middle + 1, k = 0, count = 0;
        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                count += (middle - i + 1);
                temp[k++] = arr[j++];
            }
        }
        while (i <= middle) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, start, temp.length);
        return count;
    }
    public static int countInversion(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        int arr[] = {12, 5, 2, 1, 3, 6, 7};
        System.out.println(countInversion(arr));
    }
}
```

### ⏳ Complexity Analysis
- **Time Complexity:** `O(N log N)`, due to merge sort.
- **Space Complexity:** `O(N)`, for the temporary array.

---

## 📊 Comparison Table
| Approach    | Time Complexity | Space Complexity |
|------------|---------------|----------------|
| Brute Force | O(N²)         | O(1)           |
| Merge Sort  | O(N log N)    | O(N)           |

---

## 🌍 Real-World Applications
- **Measuring disorder in an array** for ranking systems.
- **Sorting techniques in databases**.
- **Inversions in genome sequencing**.

---

## 🎯 Key Takeaways & Conclusion
- Brute force is inefficient (`O(N²)`).
- Merge Sort optimizes the problem to `O(N log N)`.
- Understanding **divide & conquer** is crucial for such problems.

🚀 **Happy Coding!** 😊

