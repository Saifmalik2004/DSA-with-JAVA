# 🎯 Two Sum Problem - Find Pair That Sums to Target

## 📌 Problem Description
Given an array of integers and a target sum `k`, find **two numbers** in the array that add up to `k`. You must return the indices of these two numbers.

### 💡 Constraints:
- There is **exactly one solution** for each input.
- You **cannot** use the same element twice.
- The solution must be **optimized** for large inputs.

---

## 🔢 Example Input & Output

### ✅ Example 1:
**Input:**
```java
arr = [1, 4, 5, 0]
k = 9
```
**Output:**
```java
1 2
```

### ✅ Example 2:
**Input:**
```java
arr = [1, 4, 0, 9]
k = 9
```
**Output:**
```java
2 3
```

---

## 🏆 Approach 1: Brute Force (O(N^2))
### 🔹 Explanation
- Iterate over all pairs using **two nested loops**.
- If `arr[i] + arr[j] == k`, return their indices.

### 📝 Pseudocode:
```plaintext
for i = 0 to n-1:
    for j = i+1 to n-1:
        if arr[i] + arr[j] == k:
            return i, j
```

### 🔍 Dry Run
| i | j | arr[i] | arr[j] | Sum | Match? |
|---|---|--------|--------|-----|--------|
| 0 | 1 | 1      | 4      | 5   | ❌     |
| 0 | 2 | 1      | 5      | 6   | ❌     |
| 1 | 2 | 4      | 5      | 9   | ✅     |

### 📌 Complexity Analysis
- **Time Complexity:** `O(N^2)` (Two loops)
- **Space Complexity:** `O(1)` (No extra space used)

### 💻 Code Implementation
```java
public class Brute {
    public static void twoSum(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 0};
        int k = 9;
        twoSum(arr, k);
    }
}
```
---

## 🚀 Approach 2: HashMap (O(N))
### 🔹 Explanation
- Use a **HashMap** to store visited elements.
- For each element, check if `k - arr[i]` exists in the HashMap.
- If found, return their indices.

### 📝 Pseudocode:
```plaintext
Initialize empty HashMap
for i = 0 to n-1:
    rem = k - arr[i]
    if rem exists in HashMap:
        return index of rem, i
    Insert arr[i] with index i into HashMap
```

### 🔍 Dry Run
| i | arr[i] | k - arr[i] | Exists in Map? | Map Content   |
|---|--------|-----------|----------------|--------------|
| 0 | 1      | 8         | ❌              | {1:0}        |
| 1 | 4      | 5         | ❌              | {1:0, 4:1}   |
| 2 | 0      | 9         | ❌              | {1:0, 4:1, 0:2} |
| 3 | 9      | 0         | ✅ (Index 2)    | {1:0, 4:1, 0:2, 9:3} |

### 📌 Complexity Analysis
- **Time Complexity:** `O(N)` (Single loop + HashMap lookup)
- **Space Complexity:** `O(N)` (For HashMap storage)

### 💻 Code Implementation
```java
import java.util.HashMap;
import java.util.Map;

public class Better {
    public static int[] twoSum(int arr[], int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = k - arr[i];
            if (sumMap.containsKey(rem)) {
                return new int[]{sumMap.get(rem), i};
            }
            sumMap.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 0, 9};
        int k = 9;
        int[] result = twoSum(arr, k);
        System.out.println(result[0] + " " + result[1]);
    }
}
```
---

## 🔥 Approach 3: Two-Pointer (O(N log N))
### 🔹 Explanation
- **Sort** the array.
- Use **two pointers**: one at start, one at end.
- Move pointers based on sum comparison.

### 📝 Pseudocode:
```plaintext
Sort array
left = 0, right = n-1
while left < right:
    sum = arr[left] + arr[right]
    if sum == k:
        return "Yes"
    else if sum > k:
        right--
    else:
        left++
```

### 🔍 Dry Run
Sorted Array: `[0, 1, 4, 9]`
| Left | Right | arr[left] | arr[right] | Sum | Action |
|------|-------|----------|------------|-----|--------|
| 0    | 3     | 0        | 9          | 9   | ✅ Found |

### 📌 Complexity Analysis
- **Time Complexity:** `O(N log N)` (Sorting takes `O(N log N)`, two-pointer takes `O(N)`)
- **Space Complexity:** `O(1)`

### 💻 Code Implementation
```java
import java.util.Arrays;
public class Optimize {
    public static String twoSum(int[] arr, int target, int n) {
        Arrays.sort(arr);
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return "Yes";
            else if (sum > target) right--;
            else left++;
        }
        return "No";
    }
    public static void main(String[] args) {
        int arr[] = {1, 4, 0, 9};
        int k = 9;
        System.out.println(twoSum(arr, k, arr.length));
    }
}
```

---

## 📊 Complexity Comparison Table
| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Brute Force | O(N^2) | O(1) |
| HashMap | O(N) | O(N) |
| Two Pointers | O(N log N) | O(1) |

---

## 🌍 Real-World Applications
- **Finance:** Detecting fraudulent transactions.
- **E-commerce:** Suggesting product bundles.
- **AI & ML:** Feature engineering in datasets.

---

## 🎯 Key Takeaways
- Brute force is simple but inefficient.
- HashMap approach is best for unordered arrays.
- Two-pointer works well if sorting is allowed.

