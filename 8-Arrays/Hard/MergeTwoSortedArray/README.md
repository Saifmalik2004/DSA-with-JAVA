# 🚀 Merging Two Sorted Arrays Without Extra Space

## 📌 Problem Statement
Given two sorted arrays `a[]` and `b[]` of sizes `n` and `m` respectively, merge them in such a way that the final merged elements are sorted and stored back in `a[]` and `b[]` without using extra space.

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

### **Time Complexity:** O((N+M) log(N+M)) (Sorting step)
### **Space Complexity:** O(N+M) (Temporary array)

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
1. Compare elements from the end of `a[]` and the beginning of `b[]`.
2. Swap if necessary.
3. Sort both arrays.

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
            right--; left++;
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
```
---
## 🚀 Optimized Approach 2 (Gap Method - No Sorting Needed!)
### **Explanation**
1. Use the **Shell Sort** gap method.
2. Compare elements at a gap distance and swap if necessary.
3. Reduce gap size and repeat until `gap = 1`.

### **Pseudocode**
```plaintext
1. Initialize gap as (N+M)/2.
2. Compare and swap elements at 'gap' distance.
3. Reduce the gap size.
4. Repeat until gap becomes 1.
```

### **Time Complexity:** O((N+M) log(N+M))
### **Space Complexity:** O(1)

### **Code Implementation**
```java
public class Optimize2 {
    public static void merge(long a[], long b[]) {
        int n = a.length, m = b.length;
        int gap = (n + m) / 2 + (n + m) % 2;
        
        while (gap > 0) {
            int left = 0, right = left + gap;
            
            while (right < n + m) {
                if (left < n && right < n && a[left] > a[right]) {
                    swap(a, left, right);
                } else if (left < n && right >= n && a[left] > b[right - n]) {
                    swap(a, b, left, right - n);
                } else if (left >= n && right >= n && b[left - n] > b[right - n]) {
                    swap(b, left - n, right - n);
                }
                left++; right++;
            }
            
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }
    
    private static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void swap(long[] a, long[] b, int i, int j) {
        long temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
}
```
---
## 📊 Complexity Comparison Table
| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Brute Force | O((N+M) log(N+M)) | O(N+M) |
| Two Pointers | O(N log N + M log M) | O(1) |
| Gap Method | O((N+M) log(N+M)) | O(1) |

---
## 🌍 Real-World Applications
- **Sorting & merging databases efficiently.**
- **Efficient memory management in operating systems.**
- **Data merging in large-scale applications like Google Search.**

---
## 🎯 Key Takeaways
✅ **Brute force is simple but inefficient.**
✅ **Two-pointer technique improves space efficiency.**
✅ **Gap method is the best for in-place merging.**
✅ **Understanding sorting techniques is crucial for optimization.**

---
## 🎉 Conclusion
Merging two sorted arrays efficiently is a fundamental problem in programming. By understanding multiple approaches, we enhance our problem-solving skills and optimize real-world applications! 🚀

