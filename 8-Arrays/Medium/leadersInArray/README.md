# 🚀 Leaders in an Array - A Fun Exploration!  

## 🔍 Problem Description  
Imagine you're standing at the top of a hill, and you can only see the peaks taller than everything in front of them. 🏔️ Similarly, in an array, a **leader** is an element that is **greater than all the elements to its right**. Our goal is to identify and print all such leaders in a given array.  

### Why is this important? 🤔  
Finding leaders in an array is a fundamental problem that builds intuition for array traversal and helps in solving similar problems in competitive programming. It's also useful in **data analysis** where trends or peaks are crucial! 📊  

---  

## 💡 Approach  
We will explore **two approaches** to solve this problem:  
1. **Brute Force Approach** (O(n²) Complexity) 😓  
2. **Optimized Approach** using **Reverse Traversal** (O(n) Complexity) 🚀  

---  

## 📝 Pseudo Code  

### **Brute Force Approach:**  
```plaintext
1. Iterate through each element in the array.
2. For each element, compare it with all elements to its right.
3. If no element to the right is greater, it's a leader.
4. Print all leaders found.
```

### **Optimized Approach:**  
```plaintext
1. Start from the last element (rightmost) and assume it's a leader.
2. Keep track of the maximum seen so far.
3. Traverse the array from right to left:
   - If the current element is greater than the max, it's a leader.
   - Update the max value accordingly.
4. Print all leaders found.
```

---  

## 🛠️ Step-by-Step Explanation of the Code  

### **Brute Force Approach (O(n²))**  
```java
import java.util.ArrayList;

// Class to find leaders in an array using a brute-force approach.
public class LeadersInArray {

    // Method to find and print leaders in the given array.
    public static void leader(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> leader = new ArrayList<>();

        // Iterate through the array to check each element.
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            boolean flag = true;

            // Compare with all elements to the right.
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > curr) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                leader.add(arr[i]);
            }
        }

        // Print leaders
        for (Integer elem : leader) {
            System.out.print(elem + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 22, 12, 3, 0, 6};
        leader(arr);
    }
}
```

### **Optimized Approach (O(n))**  
```java
import java.util.ArrayList;

// Class to find leaders in an array using an optimized approach.
public class Optimize {

    public static void leader(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> leader = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        // Traverse from right to left.
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                leader.add(arr[i]);
            }
            max = Math.max(arr[i], max);
        }

        // Print leaders
        for (Integer elem : leader) {
            System.out.print(elem + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 22, 12, 3, 0, 6};
        leader(arr);
    }
}
```

---  

## 📊 Example Walkthrough  

### Input:  
```plaintext
arr[] = {10, 22, 12, 3, 0, 6}
```

### **Step-by-step for Brute Force Approach:**  
- **Check 10** → Right elements {22, 12, 3, 0, 6} → ❌ Not a leader
- **Check 22** → Right elements {12, 3, 0, 6} → ✅ Leader
- **Check 12** → Right elements {3, 0, 6} → ❌ Not a leader
- **Check 3** → Right elements {0, 6} → ❌ Not a leader
- **Check 0** → Right elements {6} → ❌ Not a leader
- **Check 6** → No right elements → ✅ Leader  

### **Output:**  
```plaintext
22 6
```

---  

## 📌 Complexity Analysis  
| Approach        | Time Complexity | Space Complexity |
|----------------|----------------|------------------|
| Brute Force    | O(n²)          | O(1)             |
| Optimized      | O(n)           | O(1)             |

### **Why is the optimized approach better?** 🚀  
- The brute force approach **compares every element with all elements to its right**, leading to O(n²) complexity. 🐌
- The optimized approach **only traverses the array once from right to left**, reducing time complexity to O(n). 🚀

---  

## 🎯 Key Takeaways  
- **Leaders in an array** are elements that are greater than all elements to their right. 🏆
- **Brute Force Method** (O(n²)) checks each element with all elements to the right. 😵
- **Optimized Method** (O(n)) uses reverse traversal and tracking the max value. 🚀
- **Time complexity matters!** Always look for ways to optimize solutions. 🔥

### ✨ Great job! You've just tackled an important array problem with two different approaches. Keep coding and optimizing! 🚀😄

