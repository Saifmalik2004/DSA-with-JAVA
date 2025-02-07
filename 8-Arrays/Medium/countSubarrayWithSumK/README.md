

## 🚀 **Finding Subarrays with a Given Sum (Brute Force & Optimized Approach)**  

### 📝 **Problem Description**  
Imagine you're on a treasure hunt 🏴‍☠️, looking for secret stashes of gold! Each map location has a number, and you want to find paths (subarrays) where the sum of numbers matches a special key **🔑 (k)**.  

Your mission: Count the number of such paths!  

---

## 💡 **Approach**  

We explore two ways to solve this problem:  

1️⃣ **Brute Force (O(n²))** – Check all possible subarrays and count the ones with sum = k.  
2️⃣ **Optimized HashMap Approach (O(n))** – Use a prefix sum + HashMap trick to count valid subarrays efficiently!  

---

## 🏗️ **Brute Force Approach**  

### 🔹 **Logic:**  
- Try all possible subarrays using two loops.  
- Compute the sum for each and check if it matches `k`.  

### 🔹 **Pseudo Code:**  
```plaintext
Initialize count = 0
For each starting index i:
    Initialize sum = 0
    For each ending index j:
        sum += arr[j]
        If sum == k:
            count++
Return count
```

---

## 🖥️ **Brute Force Code Implementation**  
```java
/**
 * Brute force approach to count subarrays with sum equal to k.
 * Time Complexity: O(n^2)
 */
public class Brute {
    public static void countSubarray(int arr[], int k) {
        int n = arr.length;
        int count = 0;

        // Iterate through all subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }

    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8, 10, 1, 1, -1, 2};
        int k = 2;
        countSubarray(num, k);
    }
}
```

---

## ⏳ **Time Complexity Analysis (Brute Force)**  
- **O(n²)** because we check all possible subarrays.  
- **Space Complexity:** O(1) since no extra data structures are used.  

---

## ⚡ **Optimized Approach (Using HashMap)**  

### 🔹 **Logic:**  
- Use **prefix sums** and a **HashMap** to track the number of times each sum occurs.  
- If `sum - k` exists in the map, it means there's a subarray that sums to `k`.  

### 🔹 **Pseudo Code:**  
```plaintext
Initialize sum = 0 and count = 0
Create a HashMap preMap with initial value (0 -> 1)
For each element num in array:
    sum += num
    If (sum - k) exists in preMap, add its count to count
    Add/update sum in preMap
Return count
```

---

## 🖥️ **Optimized Code Implementation (O(n))**  
```java
import java.util.HashMap;
import java.util.Map;

/**
 * Optimized approach using HashMap to find the number of subarrays with sum equal to k.
 * Time Complexity: O(n)
 */
public class Better {
    public static void maxSubArrayWithSumK(int[] nums, int k) {
        int sum = 0;
        int count = 0;

        // HashMap to store prefix sums and their frequencies
        Map<Integer, Integer> preMap = new HashMap<>();
        preMap.put(0, 1);

        for (int num : nums) {
            sum += num;
            int remove = sum - k;
            count += preMap.getOrDefault(remove, 0);
            preMap.put(sum, preMap.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 0, 0, 1, 1}; // Input array
        int k = 4; // Target sum
        maxSubArrayWithSumK(arr, k); // Call the method
    }
}
```

---

## ⏳ **Time Complexity Analysis (Optimized Approach)**  
- **Time Complexity:** **O(n)** (single loop traversal).  
- **Space Complexity:** **O(n)** (stores prefix sums in HashMap).  

---

## 🌟 **Example Walkthrough**  
### **Input:**  
```plaintext
arr = [1, 2, 3, 1, 0, 0, 1, 1], k = 4
```
### **Step-by-Step Execution:**  
| Index | Current Sum | sum - k | Count if Exists | HashMap State |
|--------|------------|---------|-----------------|---------------|
| 0      | 1          | -3      | 0               | {0:1, 1:1}    |
| 1      | 3          | -1      | 0               | {0:1, 1:1, 3:1} |
| 2      | 6          | 2       | 0               | {0:1, 1:1, 3:1, 6:1} |
| 3      | 7          | 3       | 1               | {0:1, 1:1, 3:1, 6:1, 7:1} |
| 4      | 7          | 3       | 1               | {0:1, 1:1, 3:1, 6:1, 7:2} |
| 5      | 7          | 3       | 1               | {0:1, 1:1, 3:1, 6:1, 7:3} |
| 6      | 8          | 4       | 1               | {0:1, 1:1, 3:1, 6:1, 7:3, 8:1} |
| 7      | 9          | 5       | 0               | {0:1, 1:1, 3:1, 6:1, 7:3, 8:1, 9:1} |

🔹 **Final Count:** **4 subarrays** sum up to `k=4`! 🎯  

---

## 🔄 **Alternate Approach (Two Pointers for Positive Numbers)**  
- Works only for positive numbers (not for negative/mixed arrays).  
- Uses a sliding window technique to maintain a running sum.  

---

## 🎯 **Key Takeaways**  
✅ Brute force is simple but slow (O(n²)).  
✅ HashMap-based prefix sum approach is super-efficient (O(n)).  
✅ Understanding prefix sum helps in many problems like **"Longest subarray with sum k"**.  

---

## 🚀 **Final Words**  
🥳 You’ve cracked another challenging problem—fantastic job! 🎉  
Keep practicing, and soon you'll master **array-based pattern problems** like a pro!  

💡 _Happy Coding!_ 💻✨