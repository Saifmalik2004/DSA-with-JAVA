

# Day 11: Bit Manipulation 🔧💻

Welcome to **Day 11** of learning Java! Today, we'll dive into the fascinating world of **Bit Manipulation**. Bit manipulation is a powerful tool used to perform operations at the bit level, allowing us to work directly with binary data. It can be particularly useful for tasks that involve memory optimization, encryption, or even image processing. 🌟

---

## Table of Contents 📑

1. [Introduction to Bit Manipulation](#introduction-to-bit-manipulation)
2. [Binary Number System](#binary-number-system)
3. [Learning Binary Numbers](#learning-binary-numbers)
4. [Bitwise Operators](#bitwise-operators)
   - [Binary AND (`&`)](#binary-and-)
   - [Binary OR (`|`)](#binary-or-)
   - [Binary XOR (`^`)](#binary-xor-)
   - [One's Complement (`~`)](#ones-complement-)
   - [Binary Left Shift (`<<`)](#binary-left-shift-)
   - [Binary Right Shift (`>>`)](#binary-right-shift-)
5. [Further Bit Manipulation Operations](#further-bit-manipulation-operations)

---

## 1. Introduction to Bit Manipulation 🧠💡

Bit manipulation involves changing the individual bits of a binary number. Java provides several **bitwise operators** that make it possible to manipulate these bits efficiently. Working at the bit level can improve performance in some cases and is commonly used in competitive programming, low-level hardware interactions, and various data-processing tasks. 🚀

## 2. Binary Number System 🔢

Before we dive into bit manipulation, let’s quickly review the **binary number system**. In the binary system, each digit is a `0` or `1` and represents a power of `2`. The rightmost digit represents \(2^0\), the next \(2^1\), and so on.

For example:
- The binary number `1010` represents \(1 \times 2^3 + 0 \times 2^2 + 1 \times 2^1 + 0 \times 2^0 = 8 + 0 + 2 + 0 = 10\).

---

## 3. Learning Binary Numbers 🧮

To get comfortable with bit manipulation, it’s helpful to memorize binary representations for numbers from 1 to 10. Check out the table below:

| Decimal | Binary |
|---------|--------|
| 1       | 1      |
| 2       | 10     |
| 3       | 11     |
| 4       | 100    |
| 5       | 101    |
| 6       | 110    |
| 7       | 111    |
| 8       | 1000   |
| 9       | 1001   |
| 10      | 1010   |

Take a few minutes to learn these representations; they’ll make working with bitwise operators much easier! 💡

---

## 4. Bitwise Operators 🔨

Java provides a set of bitwise operators to manipulate binary data directly. Let’s explore each one with an explanation and example. 💻

### Binary AND (`&`) 🤝

**Explanation:**  
The `&` (AND) operator compares each bit of two numbers. It returns `1` only if both corresponding bits are `1`; otherwise, it returns `0`.

**Example:**  
```java
int a = 5;  // Binary: 0101
int b = 3;  // Binary: 0011
int result = a & b; // Result: 0001 (decimal 1)
System.out.println("5 & 3 = " + result);
```

### Binary OR (`|`) 🌐

**Explanation:**  
The `|` (OR) operator compares each bit of two numbers. It returns `1` if at least one of the corresponding bits is `1`.

**Example:**  
```java
int a = 5;  // Binary: 0101
int b = 3;  // Binary: 0011
int result = a | b; // Result: 0111 (decimal 7)
System.out.println("5 | 3 = " + result);
```

### Binary XOR (`^`) 💥

**Explanation:**  
The `^` (XOR) operator returns `1` only if the corresponding bits are different; if they are the same, it returns `0`.

**Example:**  
```java
int a = 5;  // Binary: 0101
int b = 3;  // Binary: 0011
int result = a ^ b; // Result: 0110 (decimal 6)
System.out.println("5 ^ 3 = " + result);
```

### One's Complement (`~`) 🔄

**Explanation:**  
The `~` (NOT) operator flips all bits in the binary representation of the number. In other words, it converts `1`s to `0`s and `0`s to `1`s.

**Example:**  
```java
int a = 5;  // Binary: 0101
int result = ~a; // Result: 1010 (decimal -6 in two's complement form)
System.out.println("~5 = " + result);
```

### Binary Left Shift (`<<`) ⬅️

**Explanation:**  
The `<<` operator shifts all bits to the left by a specified number of positions, filling the rightmost bits with zeros. Shifting left by one position is equivalent to multiplying by 2.

**Example:**  
```java
int a = 5;   // Binary: 0101
int result = a << 1; // Result: 1010 (decimal 10)
System.out.println("5 << 1 = " + result);
```

### Binary Right Shift (`>>`) ➡️

**Explanation:**  
The `>>` operator shifts all bits to the right by a specified number of positions. The leftmost bits are filled based on the sign bit (0 for positive, 1 for negative).

**Example:**  
```java
int a = 5;   // Binary: 0101
int result = a >> 1; // Result: 0010 (decimal 2)
System.out.println("5 >> 1 = " + result);
```

---

## 5. Further Bit Manipulation Operations 🔍

We’ll also cover some essential bit manipulation techniques in this module. These tasks, often used in interviews, are each in individual directories for focused practice. They include:

- **Get the `i`-th Bit** 🧩
- **Set the `i`-th Bit** 🛠️
- **Clear the `i`-th Bit** 🧹
- **Update the `i`-th Bit** 🔄
- **Clear Last `i` Bits** ❌

Each of these operations has a separate explanation and example in its respective directory. 📁

---

By the end of this section, you’ll have a solid foundation in bit manipulation techniques, which will be useful in optimizing code and tackling a range of practical and interview-related problems. 🎯

Happy coding! 🎉🖥️