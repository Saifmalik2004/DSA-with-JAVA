# 📌 The Problem: Kth Missing Positive Number

## 📝 Problem Statement
Given a **sorted array** of positive integers where some numbers are missing, find the **K-th missing positive number** in the sequence.

## 📥 Example Input & Output

### 🔹 Example 1:
**Input:**  
```plaintext
arr = [1,2,4,5,7]
k = 2
```
**Output:**  
```plaintext
3
```

**Explanation:**
The missing numbers in the sequence are **[3, 6]**. The **2nd missing number** is `3`.

---

## 🤔 Intuition
To solve this problem, we need to find missing numbers in a sorted sequence. 
- If there were **no missing numbers**, the sequence would be `[1, 2, 3, 4, 5, 6, 7, ...]`.
- Given `arr = [1,2,4,5,7]`, we observe missing values `[3,6]`.
- The missing count before each index helps us determine where our `k-th` missing value lies.
- Using **binary search**, we efficiently locate the missing number instead of iterating over all numbers.

---

## 🛠 Approach: Binary Search on Missing Count
We can use **Binary Search** to efficiently find the K-th missing positive number.

### 🔹 Step-by-step Breakdown
1. **Understand how missing numbers are counted:**
   - For `arr[i]`, the total missing count up to index `i` is given by:
     ```
     missingCount = arr[i] - (i + 1)
     ```
   - This tells us how many numbers are missing **before** index `i`.

2. **Use Binary Search to locate the position:**
   - Find the **first position** where the missing count becomes `>= k`.
   - If `missingCount < k`, move **right**.
   - Otherwise, move **left**.
   
3. **Return the missing number:**
   - The `K-th` missing number is determined using the formula:
     ```
     k + high + 1
     ```

---

## 📝 Algorithm (Pseudo Code)
```plaintext
1. Initialize low = 0, high = n - 1
2. While low <= high:
    3. Compute mid = (low + high) / 2
    4. If (arr[mid] - (mid + 1)) < k:
        5. Move right: low = mid + 1
    6. Else:
        7. Move left: high = mid - 1
8. Return k + high + 1
```

---

## 💻 Code Walkthrough
The function `kthMissing(arr, k)` implements Binary Search to determine the **K-th missing positive number**.
- It starts with `low` at `0` and `high` at `n - 1`.
- The missing numbers count is used to adjust `low` and `high`.
- The final missing number is computed using `k + high + 1`.

---

## ✅ Full Code with Comments
```java
public class Optimize {
    // Function to find the K-th missing positive number
    public static int kthMissing(int arr[], int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        // Binary Search to find the first position where missingCount >= k
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Calculate missing count up to mid
            if ((arr[mid] - (mid + 1)) < k) {
                low = mid + 1; // Move right
            } else {
                high = mid - 1; // Move left
            }
        }
        
        return k + high + 1;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 7};
        System.out.println(kthMissing(arr, 2)); // Output: 3
    }
}
```

---

## ⏳ Complexity Analysis
### 🔹 Time Complexity:
- **Binary Search runs in** `O(log n)`
- **Total Complexity:** `O(log n)`

### 🔹 Space Complexity:
- Uses only a few extra variables: `O(1)` (constant space complexity).

---

## 🚀 Key Features
- **Efficient:** Uses **Binary Search** to optimize the search space.
- **Handles Large Inputs:** Works efficiently on large arrays.
- **Optimized for Sorted Input:** Uses properties of sorted arrays to improve search speed.

---

## 📝 Tips & Tricks
1. Understanding `arr[mid] - (mid + 1)` is key to solving this problem efficiently.
2. The missing count formula helps in determining which side to move in binary search.
3. The final formula `k + high + 1` ensures the correct missing number is returned.

---

## 🎯 Conclusion
This problem is a great example of **Binary Search on Answer**, where we optimize within a numerical range. By leveraging the missing count calculation, we efficiently solve it in `O(log n)` time.

Happy Coding! 🚀

