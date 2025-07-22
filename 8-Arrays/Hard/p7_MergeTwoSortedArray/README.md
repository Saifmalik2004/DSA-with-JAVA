
# 🚀 Merging Two Sorted Arrays Without Extra Space

## 📌 Problem Statement

Given two sorted arrays `a[]` and `b[]` of sizes `n` and `m` respectively, merge them in such a way that the final merged elements are sorted and stored back in `a[]` and `b[]` **without using extra space**.

---

## 🔹 Example

### **Input:**

```plaintext
A = [1, 3, 5, 7]
B = [0, 2, 6, 8, 9]
```

### **Output:**

```plaintext
A = [0, 1, 2, 3]
B = [5, 6, 7, 8, 9]
```

---

## 🛠️ Brute Force Approach

### **Explanation**

1. Merge both arrays into a temporary array.
2. Sort the temporary array.
3. Copy back the elements into `a[]` and `b[]`.

### **Pseudocode**

```plaintext
1. Concatenate arrays A and B into a temporary array.
2. Sort the temporary array.
3. Copy first N elements to A.
4. Copy last M elements to B.
```

### **Time Complexity:** O((N+M) log(N+M))

### **Space Complexity:** O(N+M)

### **Code Implementation (Brute Force)**

```java
public class Brute {
    public static void merge(long a[], long b[]) {
        int n = a.length, m = b.length;
        long[] temp = new long[n + m];
        
        System.arraycopy(a, 0, temp, 0, n);
        System.arraycopy(b, 0, temp, n, m);
        
        Arrays.sort(temp);
        
        System.arraycopy(temp, 0, a, 0, n);
        System.arraycopy(temp, n, b, 0, m);
    }
}
```

---

## ⚡ Optimized Approach 1 (Using Two Pointers)

### **Explanation**

1. Compare the largest element of `a[]` with the smallest of `b[]`.
2. If `a[i] > b[j]`, swap them.
3. After all swaps, sort both arrays individually.

### **Pseudocode**

```plaintext
1. Set two pointers, one at the end of A and one at the start of B.
2. Swap elements if A[i] > B[j].
3. Sort both arrays.
```

### **Time Complexity:** O(N log N + M log M)

### **Space Complexity:** O(1)

### **Code Implementation**

```java
public class Optimize1 {
    public static void merge(long a[], long b[]) {
        int n = a.length, m = b.length, right = n - 1, left = 0;
        
        while (right >= 0 && left < m) {
            if (a[right] > b[left]) {
                long temp = a[right];
                a[right] = b[left];
                b[left] = temp;
            }
            right--;
            left++;
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
```

---

## 🚀 Optimized Approach 2 (Gap Method – Your Code)

### **Explanation**

This approach is based on the **Shell Sort gap method**. Instead of merging and then sorting, we:

1. Use a dynamic gap between elements.
2. Compare and swap elements at the current gap distance.
3. Gradually reduce the gap until it becomes 1, ensuring elements get sorted in place across both arrays.

### **Pseudocode**

```plaintext
1. Initialize gap as (N + M + 1) / 2.
2. Compare elements at 'left' and 'right' indices separated by the gap.
3. Swap if elements are out of order.
4. Reduce the gap and repeat until gap = 1.
```

### **Time Complexity:** O((N + M) log(N + M))

### **Space Complexity:** O(1)

### **Your Code Implementation**

```java
import java.util.Arrays;

public class Optimize2 {

    // Merge two sorted arrays using Gap method
    public static void merj(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int len = n + m;

        // Initial gap calculation
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                if (left < n && right >= n) {
                    // Left in 'a', Right in 'b'
                    swap(a, b, left, right - n);
                } else if (left >= n) {
                    // Both in 'b'
                    swap(b, b, left - n, right - n);
                } else {
                    // Both in 'a'
                    swap(a, a, left, right);
                }

                left++;
                right++;
            }

            // Reduce the gap
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    // Swap if element in a is greater than in b
    public static void swap(int[] a, int[] b, int i, int j) {
        if (a[i] > b[j]) {
            int temp = a[i];
            a[i] = b[j];
            b[j] = temp;
        }
    }

    // Sample test
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {0, 2, 6, 8, 9};

        merj(a, b);

        System.out.println("Merged arrays:");
        System.out.println("A: " + Arrays.toString(a));
        System.out.println("B: " + Arrays.toString(b));
    }
}
```

---

## 📊 Complexity Comparison Table

| Approach             | Time Complexity       | Space Complexity |
| -------------------- | --------------------- | ---------------- |
| Brute Force          | O((N + M) log(N + M)) | O(N + M)         |
| Two Pointers         | O(N log N + M log M)  | O(1)             |
| Gap Method (✔️ Best) | O((N + M) log(N + M)) | O(1)             |

---

## 🌍 Real-World Applications

* Efficient in-place merging of sorted chunks in external sorting.
* Database merge operations where space is constrained.
* System-level file merge without duplicating memory.

---

## 🎯 Key Takeaways

✅ Brute force is easy but not optimal.
✅ Two-pointer avoids extra space but still uses sorting.
✅ **Gap Method is the most efficient in-place solution.**
✅ Ideal for interviews and constrained systems.

---

## 🎉 Conclusion

Mastering in-place array merging prepares you for more complex problems and optimizations in real-world systems. The **Gap Method** is a smart and clean way to solve it without extra memory!

