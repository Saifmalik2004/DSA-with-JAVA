

# Power Calculation (Recursive Approach) ⚡

This program demonstrates two methods of calculating the power of a number `x` raised to `n`: a simple recursive approach and an optimized recursive approach using exponentiation by squaring.

## 📋 How It Works

### Approach 1: Simple Recursion (`pow`)

The `pow` method calculates the power of `x` raised to `n` using the following logic:

1. **Base Case**: If `n == 1`, return `x` as `x^1 = x`.
2. **Recursive Case**: For any `n > 1`, multiply `x` by the result of `pow(x, n-1)` (i.e., recursively calculate `x^(n-1)`).

#### Code:

```java
public static int pow(int x, int n) {
    if(n == 1) {
        return x;
    }
    return x * pow(x, n - 1);
}
```

#### Dry Run: `pow(8, 2)`

Let's walk through the execution of `pow(8, 2)` step by step:

1. **First Call**: `pow(8, 2)`
   - `n != 1`, so it calls `pow(8, 1)`
   
2. **Second Call**: `pow(8, 1)`
   - `n == 1`, return `8`
   
3. **Returning**: `pow(8, 2)` returns `8 * 8 = 64`

Thus, the result of `pow(8, 2)` is `64`.

#### Time Complexity:

- **Time Complexity**: `O(n)` because the function makes `n` recursive calls, one for each decrement of `n`.
- **Space Complexity**: `O(n)` due to the recursive call stack.

---

### Approach 2: Optimized Recursion (`optimizePow`)

The `optimizePow` method improves the power calculation by using **Exponentiation by Squaring**. This method reduces the number of multiplications, improving efficiency.

1. **Base Case**: If `n == 1`, return `x` as `x^1 = x`.
2. **Recursive Case**: If `n > 1`:
   - First, compute `halPower = optimizePow(x, n / 2)`. This computes the power of `x` raised to `n / 2` recursively.
   - If `n` is even, the result is `halPower * halPower`.
   - If `n` is odd, multiply by `x` again: `x * halPower * halPower`.

#### Code:

```java
public static int optimizePow(int x, int n) {
    if(n == 1) {
        return x;
    }
    int halPower = optimizePow(x, n / 2);
    if(n % 2 != 0) {  // Odd power
        return x * halPower * halPower;
    }
    return halPower * halPower;  // Even power
}
```

#### Dry Run: `optimizePow(2, 5)`

Let's walk through the execution of `optimizePow(2, 5)` step by step:

1. **First Call**: `optimizePow(2, 5)`
   - `n != 1`, so it calculates `halPower = optimizePow(2, 2)`
   
2. **Second Call**: `optimizePow(2, 2)`
   - `n != 1`, so it calculates `halPower = optimizePow(2, 1)`
   
3. **Third Call**: `optimizePow(2, 1)`
   - `n == 1`, return `2`
   
4. **Returning**: `optimizePow(2, 2)` returns `2 * 2 = 4`
   
5. **Returning**: `optimizePow(2, 5)` calculates `halPower = 4`
   - Since `n = 5` is odd, return `2 * 4 * 4 = 32`

Thus, the result of `optimizePow(2, 5)` is `32`.

#### Time Complexity:

- **Time Complexity**: `O(log n)` because the method reduces the problem size by half at each step (recursive calls are made with `n / 2`).
- **Space Complexity**: `O(log n)` due to the recursive call stack.

---

## 🧩 Key Differences Between Both Approaches

### 1. **Efficiency**:
   - **Simple Recursion (`pow`)**: 
     - This approach performs `n` recursive calls, resulting in `n` multiplications.
     - **Time Complexity**: `O(n)`
     - **Space Complexity**: `O(n)`
   - **Optimized Recursion (`optimizePow`)**: 
     - This approach reduces the number of recursive calls by halving the value of `n` at each step. Thus, it performs far fewer multiplications.
     - **Time Complexity**: `O(log n)`
     - **Space Complexity**: `O(log n)`

### 2. **Performance**:
   - The **optimized approach** (`optimizePow`) is far more efficient, especially for larger values of `n`, because it reduces the number of operations required to compute the power.

---

## 🎯 Summary

- The **simple recursion** approach (`pow`) is straightforward but inefficient for larger powers due to its linear time complexity.
- The **optimized recursion** approach (`optimizePow`) uses the technique of **exponentiation by squaring**, which improves the time complexity to logarithmic time, making it much more efficient for large powers.

By understanding both approaches, you can choose the appropriate method depending on the size of the exponent `n`.