

#  Advanced Bit Manipulation - Updating the ith Bit in Java

Welcome to the next level of bit manipulation! Today, we're learning how to **update a specific bit** in a number. This operation combines both setting and clearing, letting us precisely control whether a bit should be a `0` or a `1`. Let's see how it's done!

---

## Table of Contents

1. [Introduction to Updating Bits](#introduction-to-updating-bits)
2. [Why Update a Specific Bit?](#why-update-a-specific-bit)
3. [How It Works](#how-it-works)
4. [Code Walkthrough](#code-walkthrough)
5. [Try It Yourself!](#try-it-yourself)

---

### 1. Introduction to Updating Bits

Updating a bit means setting a specific bit to a desired value, either `0` or `1`. Unlike setting or clearing alone, updating allows you to **choose the value for any specific bit**, giving you even more control over binary data.

---

### 2. Why Update a Specific Bit?

Updating specific bits is commonly used for:
- **Configuring specific flags** or settings in control systems.
- **Switching values dynamically** based on user or system inputs.
- Efficiently managing **binary states** in low-level programming.

---

### 3. How It Works

To update a specific bit, follow these steps:

1. **Clear the ith bit**: Use a bitmask to set the target bit to `0` without changing other bits.
2. **Set the ith bit to the desired value**: Shift the value `v` (0 or 1) to the ith position and apply OR to update the bit.

### 4. Code Walkthrough

Here's how our code implements these steps:

```java
public static int updateIthBit(int n, int i, int v) {
    n = clearIthBit(n, i);       // Step 1: Clear the ith bit
    int bitMask = v << i;        // Step 2: Create a bitmask with the value 'v' shifted to the ith position
    return n | bitMask;          // Step 3: Use OR to set the ith bit to 'v'
}
```

1. **Clear the Bit**: We start by calling `clearIthBit(n, i)`, which sets the ith bit of `n` to `0`.
2. **Create a New Bitmask**: We shift `v` (0 or 1) to the ith position, creating a bitmask with `v` at the desired bit location.
3. **Set the Bit to `v`**: Finally, we use the OR operation to apply the value at the ith bit.

### Example

For example:
- **Input**: We use `10` (binary `1010`) and want to update the `2nd` bit to `1`.
- **Output**: The bit changes from `0` to `1`, so `1010` becomes `1110`, or `14` in decimal.

### 5. Try It Yourself!

Experiment with different values for `n`, `i`, and `v` to see how this method lets you control specific bits. This practice will deepen your understanding of how bits work, which is useful in fields like low-level programming, systems development, and game programming. Enjoy exploring! 🎉