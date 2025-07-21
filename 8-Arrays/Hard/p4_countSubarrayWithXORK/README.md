# 🚀 Count Subarrays with Given XOR Sum

## 📌 Problem Description
Given an array of integers and a target integer `k`, our goal is to find the number of subarrays whose XOR sum equals `k`.

XOR (exclusive OR) is a bitwise operation where:
- `a ⊕ a = 0`
- `a ⊕ 0 = a`
- `a ⊕ b ⊕ c = a ⊕ (b ⊕ c)` (Associative property)

We will explore multiple approaches to solve this problem efficiently.

---

## 🔢 Example Input & Output
### Example 1:
**Input:**  
```plaintext
nums = [1, 2, 3, 1, 0, 0, 1, 1]
k = 4
```
**Output:**  
```plaintext
Count of subarrays with sum 4: 4
```

### Example 2:
**Input:**  
```plaintext
nums = [2, 4, 6, 8, 10, 1, 1, -1, 2]
k = 2
```
**Output:**  
```plaintext
Count of subarrays with sum 2: 3
```

---

## 🛠 Brute Force Approach (O(N²))
### 🔍 Explanation
We iterate through all possible subarrays and compute their XOR sum manually. If the XOR sum matches `k`, we increase the count.

### 📜 Pseudocode
```plaintext
Initialize count = 0
For i = 0 to n-1:
    Initialize sum = 0
    For j = i to n-1:
        sum = sum XOR nums[j]
        If sum == k:
            Increment count
Return count
```

### 🖥 Code Implementation
```java
public class Brute {
    public static void countSubarray(int[] a, int b) {
        int n = a.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum ^= a[j];
                if (sum == b) {
                    count++;
                }
            }
        }
        System.out.println("Count of subarrays with sum " + b + ": " + count);
    }
    
    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8, 10, 1, 1, -1, 2};
        int k = 2;
        countSubarray(num, k);
    }
}
```

### ⏳ Complexity Analysis
- **Time Complexity:** O(N²) (Nested loop iterates through all subarrays)
- **Space Complexity:** O(1) (No extra data structures used)

---

## ⚡ Better Approach (O(N)) - Using HashMap
### 🔍 Explanation
We use a prefix XOR and a HashMap to store frequency of XOR values. By checking the required XOR (`Xor ^ k`), we can efficiently count valid subarrays.

### 📜 Pseudocode
```plaintext
Initialize Xor = 0 and count = 0
Create a HashMap preMap
Insert (0, 1) into preMap
For each num in nums:
    Xor = Xor XOR num
    required = Xor XOR k
    If required exists in preMap:
        Increment count by preMap[required]
    Update preMap with Xor
Return count
```

### 🖥 Code Implementation
```java
import java.util.HashMap;
import java.util.Map;

public class Better {
    public static void maxSubArrayWithSumK(int[] nums, int k) {
        int Xor = 0;
        int count = 0;
        
        Map<Integer, Integer> preMap = new HashMap<>();
        preMap.put(0, 1);
        
        for (int num : nums) {
            Xor ^= num;
            int remove = Xor ^ k;
            count += preMap.getOrDefault(remove, 0);
            preMap.put(Xor, preMap.getOrDefault(Xor, 0) + 1);
        }
        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 0, 0, 1, 1};
        int k = 4;
        maxSubArrayWithSumK(arr, k);
    }
}
```

### ⏳ Complexity Analysis
- **Time Complexity:** O(N) (Single pass through the array)
- **Space Complexity:** O(N) (HashMap stores prefix XOR sums)

---

## 📊 Complexity Comparison
| Approach         | Time Complexity | Space Complexity |
|-----------------|---------------|-----------------|
| Brute Force     | O(N²)          | O(1)            |
| Optimized (HashMap) | O(N)         | O(N)            |

---

## 🌍 Real-World Applications
- **Network Security:** XOR operations are heavily used in cryptographic algorithms.
- **Data Encoding:** XOR is used in error detection and correction techniques.
- **Competitive Programming:** Fast XOR-based calculations are common in bit manipulation problems.
- **Computer Graphics:** XOR operations help in fast screen updates.

---

## 🎯 Key Takeaways & Conclusion
- **Brute force** method iterates over all subarrays, leading to O(N²) complexity.
- **Optimized approach** leverages HashMap to achieve O(N) complexity.
- **XOR properties** play a crucial role in reducing time complexity.
- **HashMap technique** helps efficiently track required prefix XOR values.
- **Real-world applications** make XOR-based problems valuable to learn.

This problem is a great example of how bitwise operations can drastically improve efficiency! 🚀 Keep practicing and mastering these concepts! 🔥

