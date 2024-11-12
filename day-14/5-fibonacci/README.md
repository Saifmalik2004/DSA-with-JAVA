Here’s a detailed breakdown of the `Fibonacci` program, covering the logic, recursive flow, dry run, call stack visualization, complexity analysis, and key points.

---

# 📘 `Fibonacci` - Calculating Fibonacci Numbers with Recursion

This Java program calculates the nth Fibonacci number using a recursive function. Fibonacci numbers are a sequence of numbers where each number is the sum of the two preceding ones. The sequence begins with `0` and `1`, and then each subsequent number is the sum of the previous two. 

The sequence looks like this:
```
0, 1, 1, 2, 3, 5, 8, 13, 21, ...
```

### Example:
- The 5th Fibonacci number is `5`, which is the sum of the 3rd (`2`) and 4th (`3`) numbers in the sequence.

## 📝 Code Explanation

Here’s the code for reference:

```java
public class Fibonacci {

    // Method to calculate the nth Fibonacci number
    public static int fibonacci(int n) {
        // Handle invalid input
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci sequence is not defined for negative numbers");
        }

        // Base cases: return n if it is 0 or 1
        if (n == 1 || n == 0) {
            return n;
        }

        // Recursive case: sum of the previous two Fibonacci numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        // Calculate the 5th Fibonacci number and print the result
        int result = fibonacci(5);
        System.out.println("5th Fibonacci number is: " + result);
    }
}
```

### How the Code Works
1. **Input Validation**: If `n` is negative, the program throws an exception, as Fibonacci numbers are only defined for non-negative integers.
2. **Base Cases**: If `n` is `0` or `1`, the method returns `n`. This prevents further recursion, as `fibonacci(0)` returns `0` and `fibonacci(1)` returns `1`.
3. **Recursive Case**: For any other `n`, the method recursively calculates `fibonacci(n - 1) + fibonacci(n - 2)`, summing the two previous Fibonacci values to reach the result.

---

## 🔍 Step-by-Step Dry Run and Call Stack Visualization

### Initial Call in `main`
- **`fibonacci(5)`** is called in `main`, beginning the recursive process.

### Recursive Steps

The function calls will continue until the base cases are reached. Let’s go through each recursive call and show how it leads to the final result:

1. **`fibonacci(5)`**
   - **Calculate**: `fibonacci(4) + fibonacci(3)`
   - Calls `fibonacci(4)` and waits for its result.

2. **`fibonacci(4)`**
   - **Calculate**: `fibonacci(3) + fibonacci(2)`
   - Calls `fibonacci(3)` and waits for its result.

3. **`fibonacci(3)`**
   - **Calculate**: `fibonacci(2) + fibonacci(1)`
   - Calls `fibonacci(2)` and waits for its result.

4. **`fibonacci(2)`**
   - **Calculate**: `fibonacci(1) + fibonacci(0)`
   - Calls `fibonacci(1)`.

5. **`fibonacci(1)`** → Base Case
   - Returns `1`.

6. **Returning to `fibonacci(2)`**
   - Calls `fibonacci(0)`.

7. **`fibonacci(0)`** → Base Case
   - Returns `0`.
   - **Calculate**: `fibonacci(2)` = `1 + 0 = 1`
   - **Return**: `1`

8. **Returning to `fibonacci(3)`**
   - Now `fibonacci(2)` is known (`1`).
   - Calls `fibonacci(1)` again.

9. **`fibonacci(1)`** → Base Case
   - Returns `1`.
   - **Calculate**: `fibonacci(3)` = `1 + 1 = 2`
   - **Return**: `2`

10. **Returning to `fibonacci(4)`**
    - Now `fibonacci(3)` is known (`2`).
    - Calls `fibonacci(2)` again.

11. **`fibonacci(2)`** (already calculated as `1`).
    - **Calculate**: `fibonacci(4)` = `2 + 1 = 3`
    - **Return**: `3`

12. **Returning to `fibonacci(5)`**
    - Now `fibonacci(4)` is known (`3`).
    - Calls `fibonacci(3)` again.

13. **`fibonacci(3)`** (already calculated as `2`).
    - **Calculate**: `fibonacci(5)` = `3 + 2 = 5`
    - **Return**: `5`

So, the 5th Fibonacci number is `5`, which is printed by `main`.

### Visualizing the Call Stack

```
fibonacci(5)
 ├── fibonacci(4)
 │    ├── fibonacci(3)
 │    │    ├── fibonacci(2)
 │    │    │    ├── fibonacci(1) -> 1 (returns)
 │    │    │    ├── fibonacci(0) -> 0 (returns)
 │    │    └── fibonacci(1) -> 1 (returns)
 │    └── fibonacci(2)
 └── fibonacci(3)
```

Each call depends on previous Fibonacci values and builds up until the base case returns, allowing each level to compute its result.

## 🧩 Complexity Analysis

This recursive Fibonacci solution has significant complexity due to repeated calculations:

- **Time Complexity:** `O(2^n)` - The function recalculates Fibonacci values for the same input multiple times, resulting in exponential growth in calls.
- **Space Complexity:** `O(n)` - The depth of the recursion stack reaches up to `n`, which requires memory for each recursive call.

For large values of `n`, this method can be inefficient. **Dynamic programming** or **memoization** are alternative techniques that can reduce the complexity to `O(n)` by storing previously calculated values.

---



## 🌟 Key Points

- 🛑 **Base Case**: Stops recursion when `n` is `0` or `1`, returning known values.
- 🔄 **Recursive Calculation**: Adds the result of `fibonacci(n - 1)` and `fibonacci(n - 2)` to calculate each Fibonacci number.
- ⚠️ **Efficiency Warning**: This approach recalculates values, making it inefficient for large inputs.

### 👨‍💻 Note on Optimization

Right now, we're focused on building the **core logic** for calculating Fibonacci numbers. As you may have noticed, this recursive solution can get a bit slow for larger numbers due to repeated calculations. In the future, we'll explore ways to make it faster using something called **Dynamic Programming (DP)**.

**What is DP?**  
Dynamic Programming is a technique where we store results of previous calculations to avoid redundant work, making our program run much faster. But for now, no need to worry about this—our main goal is understanding recursion and logic building. 😄

So just focus on understanding the recursion for now, and don’t worry about the optimization part yet. We'll dive into that when you're ready!