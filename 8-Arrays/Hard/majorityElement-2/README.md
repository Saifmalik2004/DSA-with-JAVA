# **🛠️ Majority Element (> n/3) Finder** 🎯

## **Problem Description**
Given an array of integers, find all elements that appear **more than** `⌊ n/3 ⌋` times.

📌 **Constraints:**
- The array length is `n`.
- The output should contain at most **two** elements.

### **Example Input & Output**
#### 🔹 Example 1:
**Input:** `arr = [3, 3, 4, 2, 4, 4, 2, 4, 4]`  
**Output:** `[4]`

#### 🔹 Example 2:
**Input:** `arr = [1, 1, 1, 3, 3, 3, 2]`  
**Output:** `[1, 3]`

---

## **🔎 Brute Force Approach**
### **Idea:**
1. Use a **hashmap** to count occurrences of each number.
2. Iterate through the hashmap and select numbers appearing more than `n/3` times.

### **Pseudocode:**
```plaintext
function majorityElementBruteForce(arr):
    freq = {}  // HashMap to store frequency
    for num in arr:
        freq[num] = freq.get(num, 0) + 1
    
    result = []
    for key, value in freq.items():
        if value > n/3:
            result.append(key)
    
    return result
```

### **Dry Run** (For `arr = [1, 1, 1, 3, 3, 3, 2]`)
| Element | Frequency |
|---------|-----------|
| 1       | 3         |
| 3       | 3         |
| 2       | 1         |
✅ Since `1` and `3` appear **more than** `⌊7/3⌋ = 2` times, they are returned.

### **Code Implementation:**
```java
import java.util.HashMap;
import java.util.Map;

public class Brute {
    public static int[] majorityElement(int arr[]) {
        int n = arr.length;
        int f = n / 3;
        Map<Integer, Integer> freq = new HashMap<>();
        int ans[] = new int[2];
        int idx = 0;

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) == f + 1) {
                ans[idx++] = num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 3, 3, 3, 2};
        int res[] = majorityElement(arr);
        for (int elem : res) {
            System.out.println(elem);
        }
    }
}
```
### **Complexity Analysis:**
- **Time Complexity:** `O(n)` for traversing the array + `O(n)` for storing values → **O(n)**.
- **Space Complexity:** `O(n)` for the HashMap.

---

## **⚡ Optimized Approach (Boyer-Moore Voting Algorithm)** 🚀
### **Idea:**
- Since at most **2** elements can appear more than `n/3` times, we use **two candidate variables** and a **two-pass method** to find them efficiently.

### **Pseudocode:**
```plaintext
function majorityElementOptimized(nums):
    candidate1, candidate2 = None, None
    count1, count2 = 0, 0
    
    for num in nums:
        if num == candidate1:
            count1 += 1
        elif num == candidate2:
            count2 += 1
        elif count1 == 0:
            candidate1, count1 = num, 1
        elif count2 == 0:
            candidate2, count2 = num, 1
        else:
            count1 -= 1
            count2 -= 1

    # Verify candidates
    count1, count2 = 0, 0
    for num in nums:
        if num == candidate1:
            count1 += 1
        elif num == candidate2:
            count2 += 1
    
    result = []
    if count1 > n/3:
        result.append(candidate1)
    if count2 > n/3:
        result.append(candidate2)
    return result
```

### **Dry Run Example**
#### Input: `arr = [11, 33, 33, 11, 33, 11]`
1️⃣ **First pass to find candidates:**
   - Candidate1: `11` (appears 3 times)
   - Candidate2: `33` (appears 3 times)
2️⃣ **Second pass to verify counts:**
   - `11` appears `3` times → ✅ Included
   - `33` appears `3` times → ✅ Included
✅ **Output:** `[11, 33]`

### **Code Implementation:**
```java
import java.util.ArrayList;
import java.util.List;

public class Optimize {
    public static List<Integer> majorityElement(int[] nums) {
        int elem1 = Integer.MIN_VALUE, count1 = 0;
        int elem2 = Integer.MIN_VALUE, count2 = 0;
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (count1 == 0 && num != elem2) {
                count1 = 1;
                elem1 = num;
            } else if (count2 == 0 && num != elem1) {
                count2 = 1;
                elem2 = num;
            } else if (elem1 == num) count1++;
            else if (elem2 == num) count2++;
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (num == elem1) count1++;
            if (num == elem2) count2++;
        }

        int f = nums.length / 3;
        if (count1 > f) ans.add(elem1);
        if (count2 > f) ans.add(elem2);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        System.out.println(majorityElement(arr));
    }
}
```

### **Complexity Analysis:**
- **Time Complexity:** `O(n)`, since we traverse the array twice.
- **Space Complexity:** `O(1)`, since we use only a few extra variables.

---

## **📊 Complexity Comparison**
| Approach        | Time Complexity | Space Complexity |
|----------------|----------------|------------------|
| Brute Force    | `O(n)`         | `O(n)`           |
| Optimized (BMV) | `O(n)`         | `O(1)`           |

---

## **🌍 Real-World Applications**
- **Data Analysis:** Finding most frequent products in shopping carts.
- **Fraud Detection:** Identifying frequently used fraudulent transactions.
- **Elections:** Counting votes exceeding a certain threshold.

---

## **🎯 Key Takeaways**
✅ **HashMap-based approach** is simple but uses extra space.  
✅ **Boyer-Moore Voting Algorithm** is the most optimized, using `O(1)` space.  
✅ Always verify counts in the **second pass** when using the optimized approach!

🚀 **Keep practicing, and happy coding!** 😊

