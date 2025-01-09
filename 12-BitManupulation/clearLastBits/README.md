
# Clearing the Last 'i' Bits in Java

Welcome to today's bit manipulation lesson! We're going to learn how to clear (set to `0`) the last `i` bits of any number in binary format. This technique is commonly used to mask or reset certain parts of a binary number.

---

## Table of Contents

1. [Introduction to Clearing Bits](#introduction-to-clearing-bits)
2. [Why Clear the Last Bits?](#why-clear-the-last-bits)
3. [How It Works](#how-it-works)
4. [Code Explanation](#code-explanation)
5. [Example Walkthrough](#example-walkthrough)
6. [Practice It!](#practice-it)

---

### 1. Introduction to Clearing Bits

Clearing bits means setting specific bits in a binary number to `0`. In this method, we're focusing on clearing the last `i` bits, which can help us isolate certain parts of a number or reset its lower values.

---

### 2. Why Clear the Last Bits?

Clearing the last `i` bits of a number is useful for:
- **Masking data** to limit calculations to only higher-order bits.
- **Resetting lower bits** to prepare data for bitwise operations.
- Managing **binary flags** and low-level controls.

---

### 3. How It Works

To clear the last `i` bits:
1. **Create a Mask**: Start with `~0` (all bits set to 1) and shift left by `i` to create a mask with the last `i` bits as `0` and the rest as `1`.
2. **Apply the Mask**: Use the bitwise AND operation to clear the last `i` bits of `n`.

### 4. Code Explanation

Our `clearLastBits` method is simple but powerful:

```java
public static int clearLastBits(int n, int i) {
    return n & ((~0) << i);  // Shift left by 'i' and use AND to clear last 'i' bits of 'n'
}
```

- **Bitmask Generation**: `~0` gives us all `1`s. Shifting it left by `i` turns the last `i` bits into `0`s.
- **Applying the Mask**: The `&` operator zeros out the last `i` bits in `n`, keeping the higher bits intact.

### 5. Example Walkthrough

For example:
- **Input**: `n = 15` (binary `1111`), `i = 2`
- **Output**: Clearing the last 2 bits results in `1100`, which is `12` in decimal.

Here’s a breakdown:
- **Step 1**: `~0` gives us all 1’s: `1111...1111`.
- **Step 2**: Shifting `~0` left by `2` results in `1111...1100`.
- **Step 3**: `15 & 1111...1100` results in `1100` (binary), which is `12` in decimal.

### 6. Practice It!

Test this code with different values of `n` and `i` to see how the last `i` bits are cleared. Practicing this will strengthen your understanding of bitwise operations and how to manipulate specific parts of a binary number. Happy coding! 🎉