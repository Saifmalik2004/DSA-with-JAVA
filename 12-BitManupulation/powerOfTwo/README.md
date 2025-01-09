

# Power of Two – A Simple Bitwise Trick

In today's lesson, we are going to learn a cool and efficient trick to check whether a number is a **power of two**. Understanding this will give you a solid grasp of how bitwise operations can make your programs faster and more efficient.

---

## Table of Contents

1. [Introduction](#introduction)
2. [How the Code Works](#how-the-code-works)
3. [Example Walkthrough](#example-walkthrough)
4. [Common Mistakes](#common-mistakes)
5. [Practice Challenge](#practice-challenge)

---

### 1. Introduction

A **power of two** is any number that can be expressed as 2 raised to an integer power. For example, `1, 2, 4, 8, 16, 32, 64, ...` are all powers of two. 

**Key observation**: A number that is a power of two has exactly one `1` bit in its binary representation. For example:

- `2` in binary is `10`
- `4` in binary is `100`
- `8` in binary is `1000`

This property makes it easy to check if a number is a power of two using a simple bitwise trick.

---

### 2. How the Code Works

The method `power(int n)` uses a very clever bitwise operation to check if `n` is a power of two. Here's how it works:

1. **Subtraction of 1**: When we subtract `1` from a power of two, all the bits after the most significant `1` bit become `1`, and the most significant `1` bit becomes `0`. For example:
    - `n = 4` (binary `100`) → `n-1 = 3` (binary `011`)
    - `n = 8` (binary `1000`) → `n-1 = 7` (binary `0111`)

2. **Bitwise AND**: By doing a bitwise AND between `n` and `n-1`, we check if the result is `0`. For powers of two, the result will always be `0`, because there are no common `1` bits between `n` and `n-1`.

    - For `n = 4` (binary `100`), `n & (n - 1)` gives `100 & 011 = 000` → Result: `0`
    - For `n = 8` (binary `1000`), `n & (n - 1)` gives `1000 & 0111 = 0000` → Result: `0`

If the result is `0`, then `n` is a power of two.

---

### 3. Example Walkthrough

Let's go through an example step by step.

**Example 1: Check if 32 is a power of two**
- Binary of `32`: `100000`
- `n - 1`: `31` → Binary `11111`
- `32 & 31`: `100000 & 11111` → `0`

Since the result is `0`, we know that `32` is a power of two.

---

### 4. Common Mistakes

- **Negative numbers**: This method works only for positive integers. If you pass a negative number, it will not work as expected.
- **Zero**: The number `0` is not a power of two, so you should avoid checking `0` with this method.

---

### 5. Practice Challenge

Now that you understand how to check for a power of two, try experimenting with different numbers:
- Test numbers like `1`, `2`, `4`, `7`, `15`, `16`, etc.
- What happens when you pass a non-power-of-two number? Why do you think that happens?

### Conclusion

This simple bitwise operation will make your program run efficiently when you need to check if a number is a power of two. With bitwise tricks like this, you can perform operations much faster compared to traditional methods. Happy coding!