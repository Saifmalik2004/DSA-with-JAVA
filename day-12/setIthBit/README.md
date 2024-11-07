

# Mastering the Art of Setting the ith Bit in Java

Today, we’re exploring another essential bit manipulation trick: **setting a specific bit in a number**. Think of it as flipping a switch — this operation allows us to turn any bit “on” (to `1`) without changing other bits. Let’s dive in and see how it works!

---

## Table of Contents

1. [Introduction to Setting Bits](#introduction-to-setting-bits)
2. [Why Set a Specific Bit?](#why-set-a-specific-bit)
3. [How It Works](#how-it-works)
4. [Code Walkthrough](#code-walkthrough)
5. [Run the Code & Experiment](#run-the-code--experiment)

---

### 1. Introduction to Setting Bits

In binary, every bit in a number represents a “power of 2” position. By setting a specific bit to `1`, we can make sure that specific “power of 2” is included in our number. **Setting a bit** essentially means forcing a bit to `1`, no matter what value it originally had.

---

### 2. Why Set a Specific Bit?

Setting bits is used frequently in:
- **Flags and status checks** where each bit represents an on/off state.
- **Feature toggles** and **permissions**.
- Efficient **data storage** and **compression**.

---

### 3. How It Works

To set a specific bit:
1. **Create a bitmask**: Use a left shift `1 << i` to move `1` to the ith position.
2. **Apply the OR operator** `|`: Using OR with the bitmask will set the ith bit of the number to `1` while leaving other bits unchanged.

### 4. Code Walkthrough

Let’s walk through the code step-by-step:

```java
public static int setIthBit(int n, int i) {
    int bitmask = 1 << i;  // Step 1: Shift 1 to the ith position to create a bitmask
```

1. **Create a Bitmask**: We create a bitmask by moving `1` to the desired bit position. For example, if `i = 2`, `bitmask` becomes `100` in binary (or `4` in decimal).

```java
    return n | bitmask;
```

2. **Apply Bitwise OR**: The OR operation `n | bitmask` will set the ith bit to `1` without affecting other bits.
   - If the bit is already `1`, it stays `1`.
   - If the bit is `0`, it becomes `1`.

### Example

In our example:
- **Input**: We start with `10`, which is `1010` in binary. We want to set the `2nd` bit (counting from the right, 0-indexed).
- **Output**: The 2nd bit changes from `0` to `1`, so `1010` becomes `1110`, or `14` in decimal. Thus, `setIthBit(10, 2)` returns `14`.

### 5. Run the Code & Experiment

Try the code with different values of `n` and `i` to see how the bit changes. Experiment with different numbers to observe how powerful and efficient bit manipulation can be. Play around and have fun with binary magic! 🎉