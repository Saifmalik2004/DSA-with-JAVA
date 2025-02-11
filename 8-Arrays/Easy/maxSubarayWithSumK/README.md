
# **📌 Longest Subarray with Sum K** 🎯

## **Problem Description**
Given an array of integers and a target sum **K**, find the **length** of the **longest contiguous subarray** whose sum equals **K**.

---

## **Example Input & Output** 📊

### **Example 1:**
**Input:**
```plaintext
arr = [1, 2, 3, 4, 3, 1, 2, 1, 1, 1]
k = 3
```
**Output:**
```plaintext
2
```
**Explanation:** The subarrays `[1,2]`, `[3]`, `[3]`, `[1,2]`, `[1,1,1]` all have sum `3`, and the longest is of length `2`.

---

## **Approach 1: Brute Force (Nested Loops) 🐢**
### **🔹 Explanation:**
- Check **all possible subarrays**.
- For each subarray, calculate the **sum** and compare it with `K`.
- If the sum matches, update the **maximum length**.

### **🔹 Pseudocode:**
```plaintext
for i from 0 to n-1:
    for j from i to n-1:
        sum = 0
        for k from i to j:
            sum += arr[k]
        if sum == k:
            max_length = max(max_length, j - i + 1)
return max_length
```

### **🔹 Dry Run:**
For `arr = [1, 2, 3, 1]` and `k = 3`:

| i | j | Subarray | Sum | maxLength |
|---|---|---------|----|------------|
| 0 | 0 | [1]    | 1  | 0          |
| 0 | 1 | [1,2]  | 3  | **2**       |
| 1 | 1 | [2]    | 2  | 2          |
| 2 | 2 | [3]    | 3  | **2**       |
| ... | ... | ... | ... | ... |

### **🔹 Brute Force Code (Java):**
```java
public class Brute {
    public static void maxSubArrayWithSumK(int arr[], int sumk) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == sumk) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        System.out.println(maxLength);
    }
}
```

### **🔹 Time Complexity:** `O(N³)` ❌ (Inefficient for large inputs)
### **🔹 Space Complexity:** `O(1)`

---

## **Approach 2: Optimized using HashMap (Prefix Sum) 🚀**
### **🔹 Explanation:**
- Use a **HashMap** to store **prefix sums** and their first occurrence index.
- Check if `sum - K` exists in the map.
- If yes, update **max length**.

### **🔹 Pseudocode:**
```plaintext
Initialize sum = 0 and hashmap preMap
for i from 0 to n-1:
    sum += arr[i]
    if sum == k:
        update maxLength
    if (sum - k) exists in preMap:
        update maxLength
    Store sum in preMap if not present
return maxLength
```

### **🔹 Optimized Code (Java):**
```java
import java.util.HashMap;
public class Better {
    public static void maxSubArrayWithSumK(int arr[], int k) {
        long sum = 0;
        int maxLength = 0;
        HashMap<Long, Integer> preMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLength = i + 1;
            }
            if (preMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - preMap.get(sum - k));
            }
            preMap.putIfAbsent(sum, i);
        }
        System.out.println(maxLength);
    }
}
```

### **🔹 Time Complexity:** `O(N)` ✅
### **🔹 Space Complexity:** `O(N)` (for HashMap)

---

## **Approach 3: Sliding Window (Optimized for Positive Numbers) 🔥**
### **🔹 Explanation:**
- Use **two pointers (left, right)** to maintain a sliding window.
- Expand `right` until sum `>= K`, then move `left` to reduce sum.
- Track the **maximum length**.

### **🔹 Pseudocode:**
```plaintext
left = 0, sum = 0
for right from 0 to n-1:
    sum += arr[right]
    while sum > k:
        sum -= arr[left]
        left++
    if sum == k:
        update maxLength
return maxLength
```

### **🔹 Optimized Code (Java):**
```java
public class Optimize {
    public static void maxSubArrayWithSumK(int arr[], int k) {
        int left = 0, sum = 0, maxLen = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        System.out.println(maxLen);
    }
}
```

### **🔹 Time Complexity:** `O(N)` ✅
### **🔹 Space Complexity:** `O(1)` ✅ (Most efficient)

---

## **Comparison Table 📊**
| Approach       | Time Complexity | Space Complexity |
|---------------|---------------|----------------|
| Brute Force   | O(N³)         | O(1)          |
| HashMap       | O(N)          | O(N)          |
| Sliding Window | O(N)          | O(1)          |

---

## **Real-World Applications 🌍**
✔️ **Finance:** Detecting longest streaks of a target profit/loss.
✔️ **Gaming:** Finding longest streaks of specific events (e.g., highest kills in a game).
✔️ **Data Analysis:** Identifying trends in sales over time.

---

## **Key Takeaways & Conclusion 🎯**
✅ **Brute Force is too slow** 🚫
✅ **Using a HashMap improves efficiency** 💡
✅ **Sliding Window is the best when array has positive numbers** 🚀
✅ **Different techniques suit different constraints!**

🔥 **Mastering these techniques helps in solving similar problems in interviews and real-world applications!** 🚀

