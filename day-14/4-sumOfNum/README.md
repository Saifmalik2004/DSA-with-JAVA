

# 📘 `SumOfNum` - Calculate Sum of Numbers Using Recursion

Welcome to the `SumOfNum` program! This Java program demonstrates how to calculate the sum of numbers from `1` up to `n` using recursion. Let's explore how each recursive call helps us reach the final result! 🌟

## 📝 Program Overview

The main purpose of this program is to calculate the sum of numbers from `1` to `n` using a recursive function `sumOfNum(int n)`. In each recursive call:
1. We add `n` to the sum of numbers from `1` to `(n - 1)`.
2. This process continues until we reach the base case where `n` is `1`.

### Code Explanation

Here's the code for reference:
```java
public class SumOfNum {

    // Method to calculate the sum of numbers from 1 to n
    public static int sumOfNum(int n) {
        if (n == 1) {              // Base Case: If n is 1, return 1
            return 1;
        }
        return n + sumOfNum(n - 1); // Recursive case
    }

    public static void main(String[] args) {
        int result = sumOfNum(5);       // Calculate sum from 1 to 5
        System.out.println("Sum of numbers from 1 to 5 is: " + result);
    }
}
```

---

## 🔍 Step-by-Step Dry Run and Call Stack Visualization

Let’s break down each recursive call and the calculations performed to find the sum of numbers from `1` to `5`.

### Initial Call in `main`
- **`sumOfNum(5)`** is called in `main`, starting the recursive calculation.

### Recursive Steps

1. **`sumOfNum(5)`**
   - Since `n` is not `1`, we proceed with the recursive case.
   - **Calculate**: `5 + sumOfNum(4)` → Calls `sumOfNum(4)` and waits for the result.

2. **`sumOfNum(4)`**
   - Since `n` is not `1`, we proceed with the recursive case.
   - **Calculate**: `4 + sumOfNum(3)` → Calls `sumOfNum(3)` and waits for the result.

3. **`sumOfNum(3)`**
   - Since `n` is not `1`, we proceed with the recursive case.
   - **Calculate**: `3 + sumOfNum(2)` → Calls `sumOfNum(2)` and waits for the result.

4. **`sumOfNum(2)`**
   - Since `n` is not `1`, we proceed with the recursive case.
   - **Calculate**: `2 + sumOfNum(1)` → Calls `sumOfNum(1)` and waits for the result.

5. **`sumOfNum(1)`**
   - **Base Case Reached**: `n == 1`, so we return `1` (since the sum of numbers from `1` to `1` is `1`).

### Unwinding the Call Stack and Calculating Results

After reaching the base case, each call will return and complete its calculation:

1. **Returning to `sumOfNum(2)`**
   - **Calculate**: `2 + 1 = 3` (result of `sumOfNum(1)` is `1`).
   - **Return**: `3`

2. **Returning to `sumOfNum(3)`**
   - **Calculate**: `3 + 3 = 6` (result of `sumOfNum(2)` is `3`).
   - **Return**: `6`

3. **Returning to `sumOfNum(4)`**
   - **Calculate**: `4 + 6 = 10` (result of `sumOfNum(3)` is `6`).
   - **Return**: `10`

4. **Returning to `sumOfNum(5)`**
   - **Calculate**: `5 + 10 = 15` (result of `sumOfNum(4)` is `10`).
   - **Return**: `15`

The final result `15` is returned to the `main` method, which then prints:

```
Sum of numbers from 1 to 5 is: 15
```

### Visualizing the Call Stack

Here’s a snapshot of the call stack at different stages:

```
sumOfNum(5)
sumOfNum(4)
sumOfNum(3)
sumOfNum(2)
sumOfNum(1) -> Base case reached, start returning
```

As each level returns, the calculations are completed in sequence, leading to the final sum result.

## 🧩 Complexity Analysis

- **Time Complexity:** `O(n)` - We make a call for each integer from `n` down to `1`.
- **Space Complexity:** `O(n)` - Due to the recursion stack storing each function call.

## 🌟 Key Points

- 🛑 **Base Case:** Stops recursion when `n == 1`, preventing infinite calls.
- 🔄 **Recursive Calculation:** Each step adds `n` to the result of `sumOfNum(n - 1)`, building up to the final result.
- 📈 **Efficiency:** This approach is simple and effective, but has a recursive stack cost.

Now you have a complete understanding of how the recursive `SumOfNum` program works. Great job exploring recursion! 🎉