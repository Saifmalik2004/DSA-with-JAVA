

# 📘 `PrintIncNum` - Print Numbers in Increasing Order

Welcome to the `PrintIncNum` program! This Java program uses recursion to print numbers from `1` up to `n` in increasing order. Let's dive into how it works! 🌟

## 📝 Program Overview

The main purpose of this program is to print numbers from `1` to `n` using a recursive function `numberPrintInc(int n)`. In each recursive call:
1. We call the function with `n - 1` to reach the base case.
2. After the base case is met and recursion begins to "unwind," the program prints the numbers in increasing order.

### Code Explanation

Here's the code for reference:
```java
public class PrintIncNum {

    public static void numberPrintInc(int n) {
        if (n == 1) {            // Base Case: If n reaches 1, stop recursion
            System.out.print(n + " ");
            return;
        }
        numberPrintInc(n - 1);    // Recursive call with (n-1)
        System.out.print(n + " "); // Print after returning from recursion
    }

    public static void main(String[] args) {
        numberPrintInc(10);       // Starting with n = 10
    }
}
```

---

## 🔍 Dry Run and Call Stack Visualization

Let's break down each step of the code and visualize the call stack during execution.

### Initial Call
- **`numberPrintInc(10)`**
  - Calls `numberPrintInc(9)` before printing.

### Recursive Steps
This pattern continues until we reach the base case:

1. **`numberPrintInc(9)`** 
   - Calls `numberPrintInc(8)`.
2. **`numberPrintInc(8)`**
   - Calls `numberPrintInc(7)`.
   
   ...

9. **`numberPrintInc(2)`**
   - Calls `numberPrintInc(1)`.

10. **`numberPrintInc(1)`**
    - This is the base case, so it prints `1` and returns.

### Call Stack Unwinding
After reaching the base case, the stack begins to unwind, and each call prints its value as it returns:

- **Returning to `numberPrintInc(2)`** → Prints `2`.
- **Returning to `numberPrintInc(3)`** → Prints `3`.
  
This continues until we return to `numberPrintInc(10)`, where `10` is printed last. The full output will be:

```
1 2 3 4 5 6 7 8 9 10
```

### Visualizing the Call Stack

Here’s a snapshot of the call stack at different stages:

```
numberPrintInc(10)
numberPrintInc(9)
numberPrintInc(8)
...
numberPrintInc(1) -> Base case reached, start returning
```

As each level returns, it prints its value, creating an increasing sequence from `1` to `10`.

## 🧩 Complexity Analysis

- **Time Complexity:** `O(n)` - We make a call for each integer from `1` to `n`.
- **Space Complexity:** `O(n)` - Due to the recursion stack storing each function call.

## 🌟 Key Points

- 🛑 **Base Case:** Stops recursion when `n == 1`, marking the end of recursive calls.
- 🔄 **Recursive Call First:** Calls with `n - 1` first to reach the base case, ensuring numbers print in increasing order.
- 📈 **Efficiency:** Simple and effective, but stack usage increases with `n`.

Now, you understand how this program works step-by-step. Enjoy learning recursion! 🔥