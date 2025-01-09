

# 📘 `PrintDecNum` - Print Numbers in Decreasing Order

Welcome to the `PrintDecNum` program! This Java program demonstrates a simple way to print numbers from `n` down to `1` using recursion. Let's dive in and break down how it works. 🚀

## 📝 Program Overview

In this program, we use a recursive function `numberPrintDec(int n)` to print numbers in decreasing order starting from `n`. The function:
1. Prints the current number `n`.
2. Calls itself with `n-1` to move closer to the base case (i.e., `n == 1`).

### Code Explanation

Here's the code for reference:
```java
public class PrintDecNum {
    
    public static void numberPrintDec(int n) {
        if(n == 1) {          // Base Case: If n reaches 1, stop recursion
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");  // Print current value with a space
        numberPrintDec(n - 1);      // Recursive call with (n-1)
    }
    
    public static void main(String[] args) {
        numberPrintDec(10);    // Starting with n = 10
    }
}
```

---

## 🔍 Dry Run and Call Stack Visualization

Let's break down each step of the code and visualize the call stack during execution.

### Initial Call
- **`numberPrintDec(10)`**
  - Prints `10` and calls `numberPrintDec(9)`.

### Recursive Steps
- **`numberPrintDec(9)`**
  - Prints `9` and calls `numberPrintDec(8)`.
- **`numberPrintDec(8)`**
  - Prints `8` and calls `numberPrintDec(7)`.
  
This continues until the base case is reached at `numberPrintDec(1)`.

### Final Steps and Call Stack

Here's how the call stack would look at each level, visualizing how each function call waits for the previous one to finish:

```
numberPrintDec(10) -> 10 ...
numberPrintDec(9) -> 9 ...
numberPrintDec(8) -> 8 ...
...
numberPrintDec(1) -> 1
```

Once `numberPrintDec(1)` prints `1`, the recursion ends, and each level of the stack is resolved back to the main function.

## 🧩 Time Complexity

- **Time Complexity:** `O(n)` - We make a call for each integer from `n` down to `1`.
- **Space Complexity:** `O(n)` - Due to the recursion stack storing each function call.

## 🌟 Key Points

- 🛑 **Base Case:** Stops recursion when `n` equals `1`, avoiding infinite calls.
- 🔄 **Recursive Call:** Each call prints the current number and then moves to `n-1`.
- 📈 **Efficiency:** This approach is simple, with linear time complexity, but consumes stack space.



Now you understand how this program works and what makes recursion such a powerful tool! 🔥