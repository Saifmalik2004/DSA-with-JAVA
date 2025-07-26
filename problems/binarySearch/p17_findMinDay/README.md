# 📌 The Problem: Minimum Shipping Days

## 📝 Problem Statement
Imagine you are an owner of a shipping company, and you need to ship a set of packages within a given number of days. Each package has a weight, and you must transport them in the given order without changing their sequence.

Your task is to determine the minimum capacity of a ship required to ship all packages within the given `days` constraint.

## 📥 Example Input & Output

### 🔹 Example 1:
**Input:**  
```plaintext
arr = [1,2,3,4,5,6,7,8,9,10]
days = 5
```
**Output:**  
```plaintext
15
```

**Explanation:**
A possible way to ship within 5 days is:
- **Day 1:** [1, 2, 3, 4, 5]  (Total weight: 15)
- **Day 2:** [6, 7]           (Total weight: 13)
- **Day 3:** [8]              (Total weight: 8)
- **Day 4:** [9]              (Total weight: 9)
- **Day 5:** [10]             (Total weight: 10)

The minimum capacity required to achieve this schedule is `15`.

---

## 🛠 Approach: Binary Search on Minimum Capacity
We can use **Binary Search** to efficiently find the minimum capacity required for the ship.

### 🔹 Step-by-step Breakdown
1. **Identify the range for binary search:**  
   - The **minimum possible capacity** must be at least the **maximum weight** of any package (otherwise, we won’t be able to transport that package).
   - The **maximum possible capacity** is the sum of all packages (if we ship everything in one day).
   
2. **Use Binary Search to find the optimal capacity:**
   - Check if a **mid** capacity allows us to ship within the given `days`.
   - If possible, try a **lower capacity** (reduce the search range).
   - Otherwise, increase the capacity and continue searching.

3. **Use a helper function** to compute the number of days required for a given capacity.

---

## 📝 Algorithm (Pseudo Code)
```plaintext
1. Initialize low = max(arr) and high = sum(arr)
2. While low <= high:
    3. Compute mid = (low + high) / 2
    4. If computeDays(arr, mid) <= days:
        5. Update high = mid - 1 (Try for a smaller capacity)
    6. Else:
        7. Update low = mid + 1 (Increase capacity)
8. Return low as the minimum required capacity
```

---

## 💻 Code Walkthrough
The function `minShipingDay(arr, days)` implements Binary Search to determine the minimum required ship capacity.
- It starts by setting `low` to the maximum element in `arr` and `high` to the sum of all elements.
- Then, a helper function `computeDays(arr, capacity)` is used to determine the number of days required for a given ship capacity.

---

## ✅ Full Code with Comments
```java
public class Optimize {
    // Function to find minimum required ship capacity
    public static int minShipingDay(int arr[], int days) {
        int low = Integer.MIN_VALUE;
        long high = 0;
        
        // Determine initial search bounds
        for (int elem : arr) {
            low = Math.max(low, elem); // Minimum ship capacity should be at least the max package weight
            high += elem; // Maximum ship capacity could be sum of all packages
        }

        // Binary Search to find optimal ship capacity
        while (low <= high) {
            int mid = low + (int) (high - low) / 2;

            if (computeDays(arr, mid) <= days) {
                high = mid - 1; // Try for a smaller capacity
            } else {
                low = mid + 1; // Increase capacity
            }
        }
        return low;
    }

    // Helper function to compute the number of days required for a given capacity
    public static int computeDays(int arr[], int cap) {
        int days = 1;
        int load = 0;
        
        for (int packageWeight : arr) {
            if (load + packageWeight > cap) {
                days++; // Move to next day
                load = packageWeight;
            } else {
                load += packageWeight;
            }
        }
        return days;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(minShipingDay(arr, 5));
    }
}
```

---

## ⏳ Complexity Analysis
### 🔹 Time Complexity:
- **Binary Search runs in** `O(log(sum(arr) - max(arr)))`
- **Computing Days runs in** `O(n)`
- **Total Complexity:** `O(n log(sum(arr) - max(arr)))`

### 🔹 Space Complexity:
- We use only a few extra variables: `O(1)` (constant space complexity).

---

## 🚀 Key Features
- **Efficient:** Uses **Binary Search** to optimize the search space.
- **Scalable:** Handles large input arrays efficiently.
- **Practical Use Case:** Mimics real-world **logistics and scheduling** problems.

---

## 📝 Tips & Tricks
1. Always initialize `low` as `max(arr)` to ensure the ship can carry the heaviest package.
2. The `computeDays` function is crucial for determining the required days efficiently.
3. Think of the problem as **finding the smallest valid capacity** rather than distributing packages manually.

---

## 🎯 Conclusion
This problem is a great example of **Binary Search on Answer**, where we optimize within a numerical range. By breaking the problem into **capacity search** and **day calculation**, we efficiently solve it in logarithmic time.

Happy Coding! 🚀

