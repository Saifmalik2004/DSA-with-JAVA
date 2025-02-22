
# Power Exponentiation Problem

## Problem Statement

Given two integers, `b` (the base) and `expo` (the exponent), the task is to compute the value of `b` raised to the power `expo` (i.e., `b^expo`), where `expo` can be any non-negative integer. You need to find an optimized way of computing this.

### Example:

**Input:**
```text
base = 10
exponent = 5
```

**Output:**
```text
100000
```

Explanation:  
The base `10` raised to the power `5` equals `10^5 = 100000`.

---

## Intuition

The naive approach would be to multiply the base `b` by itself `expo` times, but this would be very inefficient for large exponents. We can optimize the process using **Exponentiation by Squaring**, which breaks down the exponentiation into smaller steps, making it more efficient. 

This method utilizes the properties of powers, particularly:
- \( b^n = b^{n/2} \times b^{n/2} \) if `n` is even.
- \( b^n = b \times b^{n-1} \) if `n` is odd.

By recursively halving the exponent and squaring the base, we reduce the number of multiplications significantly.

---

## Approach

### Step-by-Step Explanation:

1. **Start with the base `b` and exponent `expo`**.
   - Initialize an `ans` variable to store the result of the exponentiation.
   - Set `ans = 1` (since any number raised to the power of `0` is 1).

2. **Iterate until the exponent (`expo`) is greater than 0**:
   - If the exponent is odd, multiply `ans` by the base.
   - If the exponent is even, square the base and halve the exponent.

3. **Repeat the process**:
   - The base keeps squaring (if the exponent is even), and `expo` keeps halving until it reaches 0.
   - This ensures that we’re reducing the exponent quickly and efficiently.

4. **Return the final result stored in `ans`**.

---

## Pseudo Code

```plaintext
Function powerExpo(b, expo):
    Initialize ans = 1
    Initialize base = b
    
    While expo > 0:
        If expo is odd:
            ans = ans * base
            expo = expo - 1
        Else:
            expo = expo / 2
            base = base * base
    
    Return ans
```

---

## Code Explanation

```java
public class Optimize {
    // Function to calculate power using exponentiation by squaring
    public static int powerExpo(int b, int expo) {
        // Initialize base and answer
        int base = b;
        int ans = 1;

        // Loop until expo becomes 0
        while (expo > 0) {
            // If exponent is odd, multiply the result with the current base
            if (expo % 2 == 1) {
                ans = ans * base;
                expo--; // Decrease the exponent by 1
            } else {
                expo /= 2; // Halve the exponent (divide by 2)
                base *= base; // Square the base for the next iteration
            }
        }

        // Return the final result
        return ans;
    }

    // Main method to test the powerExpo function
    public static void main(String[] args) {
        // Test the powerExpo function with base 10 and exponent 5
        System.out.println(powerExpo(10, 5));  // Output: 100000
    }
}
```

### Walkthrough:

1. **Initialization**:
   - We start by initializing the base (`base = b`) and the answer (`ans = 1`).
   - We then enter a loop that continues until `expo` becomes 0.

2. **Odd Exponent Case**:
   - If the exponent is odd (checked using `expo % 2 == 1`), we multiply `ans` by the current base, and decrement `expo` by 1 to make it even.

3. **Even Exponent Case**:
   - If the exponent is even, we square the base (`base = base * base`) and halve the exponent (`expo = expo / 2`).

4. **Repeat Until Completion**:
   - The loop continues until the exponent becomes 0, at which point `ans` holds the result of `b^expo`.

---

## Time Complexity

- The time complexity of the **Exponentiation by Squaring** method is **O(log expo)**.  
- This is because, in each iteration, we halve the exponent, so the number of operations is proportional to the logarithm of the exponent.

## Space Complexity

- The space complexity is **O(1)**, as we only use a constant amount of space to store the base, exponent, and result, regardless of the size of the input.

---

## Key Features:

- **Efficiency**: This method is much faster than the brute force method. It reduces the number of multiplications from `expo` to `log(expo)`.
- **Iterative Process**: The algorithm works iteratively, so it doesn't require recursion or extra stack space.
- **Handles Large Exponents**: It can efficiently handle large exponents that might be impractical for the naive approach.

---

## Tips:

- **Understanding Exponentiation by Squaring**: This technique works because it leverages the mathematical property of powers where even exponents allow us to square the base and halve the exponent. For odd exponents, we handle them by subtracting 1 and then using the even exponent strategy.
- **Avoiding Overflow**: For large numbers, consider using data types that can handle larger values, such as `long` or `BigInteger` in Java.
- **Applicability**: This technique is widely used in algorithms like fast exponentiation in modular arithmetic, cryptography, and more.

---

## Conclusion

Exponentiation by squaring is a highly efficient algorithm for computing powers, especially useful for large exponents. It reduces the time complexity from a linear approach (`O(expo)`) to a logarithmic one (`O(log expo)`), making it an essential technique for handling problems with large inputs in competitive programming and real-world applications.