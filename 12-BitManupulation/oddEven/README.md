

#  Odd or Even - A Bitwise Adventure! 🚀

Welcome to an exciting day of learning Java! Today, we’re exploring **bit manipulation** to solve a classic problem: **How can we tell if a number is odd or even?** While there are many ways to approach this, the bitwise method is one of the fastest and most memory-efficient solutions.

---

## Table of Contents

1. [Introduction to the Odd/Even Problem](#introduction-to-the-odd-even-problem)
2. [The Power of Bit Manipulation](#the-power-of-bit-manipulation)
3. [Understanding the Code](#understanding-the-code)
4. [Why Bit Manipulation is Efficient](#why-bit-manipulation-is-efficient)
5. [Practice: Try It Out](#practice-try-it-out)

---

### 1. Introduction to the Odd/Even Problem

Determining if a number is odd or even is one of the most common tasks in programming. Normally, we might use the **modulus operator** (`%`) to check if a number has a remainder when divided by 2:
- If the remainder is `0`, the number is **even**.
- If the remainder is `1`, the number is **odd**.

But today, we’re trying a new approach using **bit manipulation**. This approach is faster and avoids additional operations like division, making it useful in cases where performance is critical!

---

### 2. The Power of Bit Manipulation

In binary, each number has bits that represent powers of 2. For instance:
- **Even numbers** always have a `0` as their least significant bit (rightmost bit).
- **Odd numbers** always have a `1` as their least significant bit.

Using a bitwise operator, we can look at this rightmost bit and decide if the number is odd or even.

### 3. Understanding the Code

Let’s break down the code line by line.

```java
public static void oddEven(int num) {
    int bitmask = 1;  // Step 1: Define a bitmask with the least significant bit as 1 (binary 0001)
```

1. **Define the Bitmask**: We use `1` as a bitmask because it has only the least significant bit (LSB) set to `1` in binary (`0001`). This bitmask helps us isolate the LSB of `num` to check if it’s `0` or `1`.

```java
    if ((num & bitmask) == 0) {
```

2. **Bitwise AND Operation**: Using the `&` (AND) operator with `num` and `bitmask`, we look at the LSB:
   - If the LSB of `num` is `0`, the result of `num & bitmask` will be `0` (even).
   - If the LSB of `num` is `1`, the result of `num & bitmask` will be `1` (odd).

```java
        System.out.println("even number");
    } else {
        System.out.println("Odd number");
    }
```

3. **Check the Result**: Based on the result of `num & bitmask`, we print **"even number"** if it’s `0` and **"Odd number"** if it’s `1`.

### 4. Why Bit Manipulation is Efficient

Using bitwise operators is highly efficient because they operate directly on the binary representation of numbers:
- **No division or modulus operations are needed** to check for odd/even.
- **Directly checks** the least significant bit, which is the key for even/odd determination in binary.
- **Fast and lightweight** – ideal for performance-critical applications.

### 5. Practice: Try It Out!

Copy the code above and run it with different numbers to see if they’re correctly identified as odd or even. Try numbers like `10`, `15`, `4`, and `7`.

---

By the end of today, you should understand:
- How to use bitwise AND to check for odd/even.
- Why this method is both efficient and elegant.

Keep experimenting, and you’ll soon see how bit manipulation can open up new, optimized ways to solve everyday problems! 🚀