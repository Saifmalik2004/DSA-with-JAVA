

# 🚀 **Split Array Into K Subarrays to Minimize Maximum Sum**  

Welcome to the solution for the **Split Array Into K Subarrays to Minimize Maximum Sum** problem! This README will walk you through the problem, code, and solution with a fun and engaging approach. Let’s dive in! 🌊  

---

## 1️⃣ **Problem Description**  

You are given an array of integers and a number `k`. The goal is to divide the array into `k` subarrays such that the largest sum among these subarrays is minimized.  

### **Scenario**  
Imagine you’re a baker 🍰 splitting batches of cookies 🍪 into `k` trays for baking. You want the tray with the most cookies to have as few as possible so all trays bake evenly. The challenge is: how should you distribute the cookies to achieve this goal?  

---

## 2️⃣ **Step-by-Step Explanation of the Code**  

Let’s break the code into smaller chunks and explain each part deeply:  

---

### **1. The Goal**  

We aim to find a way to split the array into `k` subarrays such that the **largest sum of elements in any subarray is minimized**. To solve this, we use a **backtracking approach** that explores all possible partitions of the array.  

---

### **2. The `solve` Function (Recursive Backtracking)**  

This is the heart of the solution. Let’s analyze it step by step.  

#### **Base Case: When `k == 1`**  
```java
if (k == 1) {
    maxSum = Math.max(sum, maxSum); // Update maxSum for the current partition
    sum = 0; // Reset sum for the remaining elements
    for (int i = index; i < n; i++) { // Calculate the sum of the remaining elements
        sum += a[i];
    }
    maxSum = Math.max(sum, maxSum); // Compare the remaining sum with the current maxSum
    ans = Math.min(maxSum, ans); // Update the global minimum maximum sum
    return; // End recursion
}
```

- **Explanation**:  
  - If `k == 1`, we are down to one partition.  
  - Calculate the sum of all remaining elements from the current index to the end of the array.  
  - Compare this sum with the maximum sum of the previous partitions and update `ans` to hold the minimum value.  

---

#### **Recursive Case: Iterating Through the Array**  
```java
sum = 0; // Reset the sum for the current partition
for (int i = index; i < n; i++) {
    sum += a[i]; // Add the current element to the sum
    maxSum = Math.max(sum, maxSum); // Update maxSum for this partition
    solve(a, n, k - 1, i + 1, sum, maxSum); // Recursive call for the next partition
}
```

- **Explanation**:  
  - Start from the current `index` and iteratively add elements to the current partition.  
  - After each addition, calculate the `maxSum` for this partition and recursively try the remaining elements with `k-1` subarrays left.  
  - This ensures we explore all possible partitions.  

---

### **3. The `splitSubarray` Function (Driver Function)**  

This function initializes the recursive process:  

```java
public static int splitSubarray(int a[], int n, int k) {
    int maxSum = 0; // Variable to track the maximum sum of any subarray
    int sum = 0;    // Initial sum for the partitions
    int index = 0;  // Start index for the first partition

    solve(a, n, k, index, sum, maxSum); // Start the recursive process

    return ans; // Return the minimum maximum sum found
}
```

- **Explanation**:  
  - Sets up the initial values for `maxSum`, `sum`, and `index`.  
  - Calls the recursive function `solve` to explore all possible partitions.  
  - Returns the final result (`ans`) containing the minimum maximum sum.  

---

### **4. The `main` Method**  

The entry point for the program:  

```java
public static void main(String[] args) {
    int a[] = {1, 1, 2}; // Input array
    int n = 3; // Size of the array
    int k = 2; // Number of subarrays

    System.out.println(splitSubarray(a, n, k)); // Output the result
}
```

- **Explanation**:  
  - Defines the input array and its size, along with the number of partitions (`k`).  
  - Calls the `splitSubarray` function and prints the result to the console.  

---

### **Deep Dive into an Example**  

Let’s walk through the execution for `a[] = {1, 1, 2}` and `k = 2`:  

#### **Initial Call**  
- **State:**  
  - `index = 0`, `sum = 0`, `maxSum = 0`, `k = 2`.  

#### **Iteration 1 (i = 0)**  
- Add `a[0] = 1` to the first partition: `sum = 1`.  
- Recursive call with `k = 1`, `index = 1`.  

#### **Recursive Call (k = 1, index = 1)**  
- Base case: Sum of the remaining elements (`a[1] + a[2] = 1 + 2 = 3`).  
- Update `ans = min(10000000, 3) = 3`.  

#### **Backtrack and Continue Iteration (i = 1)**  
- Add `a[1] = 1` to the first partition: `sum = 2`.  
- Recursive call with `k = 1`, `index = 2`.  

#### **Recursive Call (k = 1, index = 2)**  
- Base case: Sum of the remaining elements (`a[2] = 2`).  
- Update `ans = min(3, 2) = 2`.  

---

## 3️⃣ **Example Walkthrough**  

For the input:  
```java
a[] = {1, 1, 2}, k = 2
```

- The two possible partitions are:  
  1. `[1]` and `[1, 2]` → Maximum sum = 3  
  2. `[1, 1]` and `[2]` → Maximum sum = 2  

The minimum maximum sum is `2`. 🎉  

---

## 4️⃣ **Approach**  

We use **backtracking** to explore all possible partitions. At each step:  
1. Add elements to the current partition.  
2. Check the maximum sum for this partition.  
3. Recursively explore the remaining partitions.  
4. Update the global minimum (`ans`).  

---

## 5️⃣ **Pseudo Code**  

Here’s a simplified version of the solution:  

```plaintext
Function solve(array, n, k, index, sum, maxSum):
    If k == 1:
        Compute remaining sum
        Update maxSum
        Update global minimum ans
        Return

    For i from index to n:
        Add array[i] to current sum
        Update maxSum
        Recursively call solve with k-1 subarrays

Function splitSubarray(array, n, k):
    Initialize maxSum, sum, and index
    Call solve
    Return ans
```

---

## 6️⃣ **Full Code with Comments**  

```java
public class Greedy {
    static int ans = 10000000; // Global variable to track the minimum maximum sum

    public static void solve(int a[], int n, int k, int index, int sum, int maxSum) {
        if (k == 1) {
            maxSum = Math.max(sum, maxSum);
            sum = 0;
            for (int i = index; i < n; i++) {
                sum += a[i];
            }
            maxSum = Math.max(sum, maxSum);
            ans = Math.min(maxSum, ans);
            return;
        }

        sum = 0;
        for (int i = index; i < n; i++) {
            sum += a[i];
            maxSum = Math.max(sum, maxSum);
            solve(a, n, k - 1, i + 1, sum, maxSum);
        }
    }

    public static int splitSubarray(int a[], int n, int k) {
        solve(a, n, k, 0, 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {1, 1, 2};
        int n = 3;
        int k = 2;

        System.out.println(splitSubarray(a, n, k)); // Output the result
    }
}
```

---

## 7️⃣ **Complexity Analysis**  

### **Time Complexity**  
- Backtracking explores all possible partitions: **O(n^k)** (exponential).  

### **Space Complexity**  
- Recursion depth: **O(k)** (for `k` subarrays).  

---

## 8️⃣ **Key Takeaways**  

- **Backtracking** helps explore all possibilities.  
- The key is to keep track of the **maximum sum** and minimize it globally.  
- Recursive

 thinking can break complex problems into manageable pieces!  

---

Enjoy coding and happy learning! 🚀  