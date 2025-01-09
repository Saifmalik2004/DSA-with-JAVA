

# Tiling Problem (Recursive Solution)

## Problem Statement

The **Tiling Problem** asks how many different ways we can cover a wall of length `n` using **2x1 tiles**. These tiles are rectangular, measuring 2 units in length and 1 unit in height. The challenge is to calculate how many distinct ways we can tile the entire wall.

### Example
- For a wall of length `n = 1`, there is only **1 way** to cover the wall (with one vertical tile).
- For a wall of length `n = 2`, there are **2 ways** to cover the wall:
  1. Place two tiles horizontally side by side.
  2. Place two tiles vertically one above the other.

---

## Approach

This problem can be solved using **recursion**. The idea is simple:

1. If the wall length is `n = 0` or `n = 1`, there’s only one way to tile the wall (just use one vertical tile or do nothing).
2. If the wall length is greater than `1`, we have two options:
   - Place a vertical tile (taking up 1 unit of length), and recursively tile the remaining wall of length `n-1`.
   - Place two horizontal tiles side by side (taking up 2 units of length), and recursively tile the remaining wall of length `n-2`.

This recursive approach leads to a solution where we calculate the number of ways to tile smaller subproblems, which is then combined to form the solution for the larger problem.

---

## Code Implementation

```java
public class Tiling {

    // Recursive function to calculate the number of ways to tile the wall
    public static int tiling(int n) {
        if (n == 1 || n == 0) {
            return 1;  // Base case: only one way to cover a 1-unit or 0-unit long wall
        }
        // Recursively calculate the number of ways to tile by subtracting 1 and 2 from the wall length
        return tiling(n - 1) + tiling(n - 2);
    }

    public static void main(String[] args) {
        // Test case: Calculate the number of ways to tile a wall of length 4
        System.out.println(tiling(4));  // Output: 5
    }
}
```

---

## Dry Run Example

Let’s dry run the code with `n = 4` to see how the recursion works.

### Dry Run for `n = 4`:
1. `tiling(4)` calls `tiling(3)` and `tiling(2)`
2. `tiling(3)` calls `tiling(2)` and `tiling(1)`
3. `tiling(2)` calls `tiling(1)` and `tiling(0)`
   - `tiling(1)` returns `1` (base case)
   - `tiling(0)` returns `1` (base case)
   - So, `tiling(2)` returns `2` (1 from `tiling(1)` and 1 from `tiling(0)`)
4. `tiling(1)` returns `1` (base case)
   - So, `tiling(3)` returns `3` (2 from `tiling(2)` and 1 from `tiling(1)`)
5. `tiling(2)` is already computed as `2`
   - So, `tiling(4)` returns `5` (3 from `tiling(3)` and 2 from `tiling(2)`)

### Final Result:
- The number of ways to tile a wall of length 4 is `5`.

---

## Time Complexity

- The time complexity of this solution is **O(2^n)**. This is because, for each call to `tiling(n)`, we make two recursive calls to `tiling(n-1)` and `tiling(n-2)`, resulting in an exponential growth in function calls.

---

## Space Complexity

- The space complexity is **O(n)**, as the recursion depth depends on the value of `n`. Each recursive call adds a new frame to the call stack, and the maximum recursion depth will be `n`.

---

## Future Optimization

- This solution can be optimized using **Dynamic Programming (DP)**, which will help avoid recalculating the same subproblems repeatedly.
- By storing the results of already solved subproblems in an array (known as **memoization**), we can reduce the time complexity to **O(n)**.

---

## Key Takeaways

- The Tiling problem is an excellent example of a **recursive problem**.
- It demonstrates how a problem can be broken down into smaller subproblems, which can be solved recursively.
- While the solution works for small values of `n`, it can be inefficient for larger values due to its exponential time complexity.
- **Dynamic Programming** is a great optimization technique for such problems, which will be explored in future lessons.

--- 

Happy Learning! 😊