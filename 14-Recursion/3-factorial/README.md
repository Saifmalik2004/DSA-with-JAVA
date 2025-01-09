
# 📘 `Factorial` - Calculating Factorial Using Recursion

Welcome to the `Factorial` program! This Java program demonstrates how to calculate the factorial of a number using recursion. Let's explore how each recursive step builds up to get the final result! 🚀

## 📝 Program Overview

The main purpose of this program is to calculate the factorial of a number `n` using a recursive function `factorial(int n)`. In each recursive call:
1. We multiply `n` by the factorial of `(n - 1)`.
2. This continues until we reach the base case where `n` is `1`.

### Code Explanation

Here's the code for reference:
```java
public class Factorial {

    // Method to calculate the factorial of a given number n
    public static int factorial(int n) {
        if (n == 1) {             // Base Case: If n is 1, return 1
            return 1;
        }
        return n * factorial(n - 1); // Recursive case
    }

    public static void main(String[] args) {
        int result = factorial(5);     // Calculate factorial of 5
        System.out.println("Factorial of 5 is: " + result);
    }
}
```

---

## 🔍 Step-by-Step Dry Run and Call Stack Visualization

Let's break down each recursive call and the calculations performed to find the factorial of `5`.

### Initial Call in `main`
- **`factorial(5)`** is called in `main`, starting the recursive calculation.

### Recursive Steps

1. **`factorial(5)`**
   - Since `n` is not `1`, we go to the recursive case.
   - **Calculate**: `5 * factorial(4)` → Calls `factorial(4)` and waits for the result.

2. **`factorial(4)`**
   - Since `n` is not `1`, we go to the recursive case.
   - **Calculate**: `4 * factorial(3)` → Calls `factorial(3)` and waits for the result.

3. **`factorial(3)`**
   - Since `n` is not `1`, we go to the recursive case.
   - **Calculate**: `3 * factorial(2)` → Calls `factorial(2)` and waits for the result.

4. **`factorial(2)`**
   - Since `n` is not `1`, we go to the recursive case.
   - **Calculate**: `2 * factorial(1)` → Calls `factorial(1)` and waits for the result.

5. **`factorial(1)`**
   - **Base Case Reached**: `n == 1`, so we return `1` (since `1! = 1`).

### Unwinding the Call Stack and Calculating Results

Now that we’ve reached the base case, each call will return and complete its calculation:

1. **Returning to `factorial(2)`**
   - **Calculate**: `2 * 1 = 2` (result of `factorial(1)` is `1`).
   - **Return**: `2`

2. **Returning to `factorial(3)`**
   - **Calculate**: `3 * 2 = 6` (result of `factorial(2)` is `2`).
   - **Return**: `6`

3. **Returning to `factorial(4)`**
   - **Calculate**: `4 * 6 = 24` (result of `factorial(3)` is `6`).
   - **Return**: `24`

4. **Returning to `factorial(5)`**
   - **Calculate**: `5 * 24 = 120` (result of `factorial(4)` is `24`).
   - **Return**: `120`

The final result `120` is returned to the `main` method, which then prints:

```
Factorial of 5 is: 120
```

### Visualizing the Call Stack

Here's a snapshot of the call stack at different stages:

```
factorial(5)
factorial(4)
factorial(3)
factorial(2)
factorial(1) -> Base case reached, start returning
```

As each level returns, the calculations are completed in sequence, leading to the final factorial result.

## 🧩 Complexity Analysis

- **Time Complexity:** `O(n)` - We make a call for each integer from `n` down to `1`.
- **Space Complexity:** `O(n)` - Due to the recursion stack storing each function call.

## 🌟 Key Points

- 🛑 **Base Case:** Stops recursion when `n == 1`, preventing infinite calls.
- 🔄 **Recursive Calculation:** Each step multiplies `n` by the result of `factorial(n - 1)`, building up to the final result.
- 📈 **Efficiency:** This approach is simple and effective but has a recursive stack cost.

Now you know how this program works, from recursion to the call stack. Great job exploring recursion! 🎉