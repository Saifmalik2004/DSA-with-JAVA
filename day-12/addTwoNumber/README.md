

# 🧠 Bitwise Addition: Adding Two Numbers without `+` in Java 🚀

Welcome to the **AddTwoNumber** project! In this program, we explore how to add two numbers in Java without using the `+` operator. Instead, we use **bitwise operations**! This technique is not only cool but also gives you insight into how addition can be done at the binary level.

## 📜 Table of Contents
- [How It Works](#how-it-works)
- [Code Explanation](#code-explanation)
- [Example Walkthrough](#example-walkthrough)
- [Key Takeaways](#key-takeaways)

---

## 🔍 How It Works

The `AddTwoNumber` program uses **bitwise operations** to achieve addition. Specifically:
- We use the `&` (AND), `^` (XOR), and `<<` (left shift) operators.
- This approach mimics binary addition, where you add bits one at a time, managing carries just like you would on paper.

Let's dive into the magic of bitwise addition!

---

## 🔥 Code Explanation

### `addToNum` Method
The method `addToNum` takes two integers, `a` and `b`, and calculates their sum without using the `+` operator.

#### Step-by-Step Breakdown

1. **Loop Until No Carry Remains**:
   - We loop until there’s no carry (`b == 0`). The carry will be zero once all bits have been added.

2. **Bitwise Operations**:
   - **Find Carry**: `int temp = (a & b) << 1;`
     - `a & b` finds the carry (positions where both `a` and `b` have a `1`).
     - Shifting it left by 1 (`<< 1`) moves the carry to the next bit position where it should be added.
   - **Partial Sum without Carry**: `a = a ^ b;`
     - `a ^ b` gives the sum without carrying (only one `1` in either `a` or `b` results in a `1` in the sum).
   - **Update `b` to Carry**: `b = temp;`
     - Update `b` with the carry value to add in the next iteration.

3. **Return Final Sum**: Once `b` (carry) is zero, `a` holds the complete sum.



## 🔄 Example Walkthrough

Let’s break down an example: adding `2` and `4`.

- **Binary Representation**:
  - `2` in binary: `010`
  - `4` in binary: `100`

#### Iteration 1:
- **Carry Calculation**: `(a & b) << 1`
  - `a & b = 010 & 100 = 000`
  - Left shift: `000 << 1 = 000` (no carry this time).
- **Sum without Carry**: `a = a ^ b`
  - `a ^ b = 010 ^ 100 = 110` (decimal `6`).
- **Update**: `b = carry (000)`

Since `b` is now `0`, the loop exits, and `a` holds the answer: `6`!

---

## ✨ Key Takeaways

1. **Bitwise Operations for Addition**:
   - `&` finds positions with carries.
   - `^` calculates sum without carry.
   - `<< 1` shifts the carry to its correct position.

2. **Efficient Addition**:
   - This method uses bitwise operations, giving us a neat insight into how computers perform low-level arithmetic.

3. **When to Use**:
   - While not common in high-level applications, bitwise addition is an essential concept in embedded systems, cryptography, and binary computations.

Happy coding, and enjoy exploring the power of bitwise operations! 🚀