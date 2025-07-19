# 🚀 **Three Sum Problem - Find Unique Triplets Summing to Zero**

## 📌 **Problem Description**
Given an integer array `arr`, find all unique triplets `[arr[i], arr[j], arr[k]]` such that:
- `i != j != k`
- `arr[i] + arr[j] + arr[k] == 0`
- Each triplet should be unique (no duplicates in the output).

## 🔍 **Example Input & Output**

### Example 1:
**Input:**
```java
arr = {-1, 0, 1, 2, -1, 4}
```
**Output:**
```java
[[-1, -1, 2], [-1, 0, 1]]
```

### Example 2:
**Input:**
```java
arr = {0, 1, 1}
```
**Output:**
```java
[]
```

---

# 🥇 **Approaches to Solve the Problem**

## 1️⃣ **Brute Force Approach (O(N³))**
### 🔹 **Explanation:**
- Check every possible triplet `(i, j, k)`.
- If `arr[i] + arr[j] + arr[k] == 0`, store the triplet.
- Use a HashSet to avoid duplicates.

### 📝 **Pseudocode:**
```java
for i = 0 to n-1:
    for j = i+1 to n-1:
        for k = j+1 to n-1:
            if arr[i] + arr[j] + arr[k] == 0:
                Sort and store triplet in HashSet
```

### 🛠 **Brute Force Implementation:**
```java
import java.util.*;

import java.util.*;

public class Brute {
    public static List<List<Integer>> triplet(int arr[]) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        // Iterate through all possible triplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Check if the sum of the triplet is zero
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        // Create a list to store the triplet
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        // Sort the triplet to maintain order and avoid duplicates
                        Collections.sort(temp);
                        // Add to the set to ensure uniqueness
                        set.add(temp);
                    }
                }
            }
        }
        // Convert set to list before returning
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> result = triplet(arr);
        System.out.println(result);
    }
}

```
### 📊 **Time Complexity:** O(N³)
### 📊 **Space Complexity:** O(N) (for storing results in HashSet)

---

## 2️⃣ **Better Approach (O(N²)) - Using HashSet**
### 🔹 **Explanation:**
- Fix one element, use a HashSet to find the remaining two elements.
- Avoid duplicate triplets using sorting.

### 📝 **Pseudocode:**
```java
for i = 0 to n-1:
    HashSet to store seen elements
    for j = i+1 to n-1:
        third = -(arr[i] + arr[j])
        if third exists in HashSet:
            Store triplet
        Add arr[j] to HashSet
```

### 🛠 **Implementation:**
```java
import java.util.*;

class Better {
    public static List<List<Integer>> triplet(int arr[]) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        // Iterate through the array, fixing one element
        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(arr[i] + arr[j]); // Finding the required third element

                // Check if the third element exists in the HashSet
                if (hashSet.contains(third)) {
                    // Store the triplet in a list
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    // Sort to maintain order and avoid duplicates
                    Collections.sort(temp);
                    set.add(temp);
                }
                // Add the current element to HashSet for future lookups
                hashSet.add(arr[j]);
            }
        }
        // Convert HashSet to List before returning
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> result = triplet(arr);
        System.out.println(result);
    }
}

```
### 📊 **Time Complexity:** O(N²)
### 📊 **Space Complexity:** O(N)

---

## 3️⃣ **Optimized Approach 🚀 (O(N²)) - Two Pointer Method**
### 🔹 **Explanation:**
- Sort the array.
- Fix the first element and use a two-pointer approach to find remaining two elements.
- Skip duplicate elements to maintain uniqueness.

### 📝 **Pseudocode:**
```java
Sort arr[]
for i = 0 to n-1:
    if arr[i] is duplicate, continue
    j = i+1, k = n-1
    while j < k:
        sum = arr[i] + arr[j] + arr[k]
        if sum == 0:
            Store triplet, move j & k, skip duplicates
        else if sum > 0:
            k--
        else:
            j++
```

### 🛠 **Implementation:**
```java
import java.util.*;

class Optimize {
    public static List<List<Integer>> triplet(int[] arr) {
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        // Sorting the array to apply two-pointer technique
        Arrays.sort(arr);

        // Iterate through the array, fixing one element
        for (int i = 0; i < n; i++) {
            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1, k = n - 1;

            // Apply two-pointer approach
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                // If sum is greater than zero, move right pointer leftward
                if (sum > 0) {
                    k--;
                } 
                // If sum is less than zero, move left pointer rightward
                else if (sum < 0) {
                    j++;
                } 
                // If sum is zero, store the triplet and move both pointers
                else {
                    res.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    // Skip duplicate values to maintain uniqueness
                    while (j < k && arr[j] == arr[j - 1]) j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> result = triplet(arr);
        System.out.println(result);
    }
}

```
### 📊 **Time Complexity:** O(N²)
### 📊 **Space Complexity:** O(1)

---

## 📊 **Comparison Table:**
| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Brute Force | O(N³) | O(N) |
| Better (HashSet) | O(N²) | O(N) |
| Optimized (Two Pointers) | O(N²) | O(1) |

---

## 🌍 **Real-World Applications**
- Financial analytics for identifying fraud patterns.
- Chemical reactions where sum of elements needs to match a target.
- AI and data mining for anomaly detection.

---

## 🎯 **Key Takeaways & Conclusion**
✅ The brute force method is simple but inefficient.
✅ The HashSet method improves performance but still requires extra space.
✅ The two-pointer approach is the best, achieving O(N²) time complexity with minimal space usage.
✅ Sorting is a powerful tool in optimizing search problems.

🚀 Keep practicing to master problem-solving skills! Happy coding! 😊

