# Alternating Positive and Negative Numbers 🚀

## **Problem Description** 📌
Imagine you're arranging guests at a party 🥳, and you want to seat them in an alternating pattern: one extrovert, one introvert, and so on! Similarly, given an array of integers containing both positive and negative numbers, we aim to rearrange the numbers such that they alternate between positive and negative values.

### **Example**:
#### **Input:**
```
arr[] = {1, -2, -3, -1, 4, 3}
```
#### **Output:**
```
{1, -2, 4, -3, 3, -1}
```

---

## **Brute Force Approach** 🛠️
### **Steps:**
1. **Separate positive and negative numbers:** Traverse the array and store positives in one list and negatives in another.
2. **Merge them alternately:** Pick one element from each list and place them back into the original array.
3. **Handle leftovers:** If one list is longer, append the remaining elements at the end.

### **Code Implementation:**
```java
import java.util.ArrayList;

public class BruteForce {
    public static void alternateNumber(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        // Step 1: Separate positive and negative numbers
        for (int num : arr) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }
        
        // Step 2: Merge back into the array
        int i = 0, p = 0, n = 0;
        while (p < pos.size() && n < neg.size()) {
            arr[i++] = pos.get(p++);
            arr[i++] = neg.get(n++);
        }
        
        // Step 3: Append remaining elements
        while (p < pos.size()) arr[i++] = pos.get(p++);
        while (n < neg.size()) arr[i++] = neg.get(n++);
    }
    
    public static void main(String[] args) {
        int arr[] = {1, -2, -3, -1, 4, 3};
        alternateNumber(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

### **Complexity Analysis:**
- **Time Complexity:** `O(n)`, since we traverse the array twice.
- **Space Complexity:** `O(n)`, due to the use of extra lists.

---

## **Optimized Approach (Two Pointers)** 🚀
### **Steps:**
1. **Initialize two pointers:** One for positive numbers (even index) and one for negative numbers (odd index).
2. **Traverse the array:** Place positive numbers at even indices and negative numbers at odd indices.
3. **Return the rearranged array.**

### **Code Implementation:**
```java
public class OptimizedSolution {
    public static int[] alternate(int[] nums) {
        int pos = 0, neg = 1;
        int n = nums.length;
        int[] ans = new int[n];
        
        // Step 1 & 2: Place positive and negative numbers at alternate positions
        for (int num : nums) {
            if (num > 0) {
                ans[pos] = num;
                pos += 2;
            } else {
                ans[neg] = num;
                neg += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, -2, -3, -1, 8, 4};
        int ans[] = alternate(arr);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
```

### **Complexity Analysis:**
- **Time Complexity:** `O(n)`, as we traverse the array once.
- **Space Complexity:** `O(n)`, since we use an auxiliary array.

---

## **Comparison of Approaches** 📊
| Approach | Time Complexity | Space Complexity | Explanation |
|----------|---------------|----------------|-------------|
| **Brute Force** | `O(n)` | `O(n)` | Uses extra lists to separate numbers before merging them back. |
| **Optimized (Two Pointers)** | `O(n)` | `O(n)` | Uses a single pass with two pointers to place numbers alternately. |

---

## **Key Takeaways** 🎯
- The brute force approach is intuitive but requires extra space.
- The optimized approach efficiently rearranges elements in **one pass** using **two pointers**.
- Understanding **pointer manipulation** is crucial for solving such problems efficiently.

---

## **Conclusion** 🎉
By following these approaches, you can easily rearrange an array to alternate between positive and negative numbers. 🚀 Keep coding and exploring new ways to optimize your solutions! 💡

---

_**Happy Coding! 💻🔥**_

