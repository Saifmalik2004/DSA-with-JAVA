

# Binary String Generator

Welcome to the **Binary String Generator**! 🚀 In this project, we use recursion to generate all possible binary strings of length `n` that don’t have consecutive `1`s. 

Here’s what the project does step-by-step and how the code works. Let's dive in!

---

## Table of Contents
1. [Overview](#overview)
2. [How It Works](#how-it-works)
3. [Understanding the Code](#understanding-the-code)
4. [Code Walkthrough](#code-walkthrough)
5. [Try It Yourself](#try-it-yourself)

---

## Overview

In this code, we’re creating binary strings that follow a rule: **no two `1`s are next to each other**. For example, if we want binary strings of length `3`, the valid outputs would be:

```
000
001
010
100
101
```

Notice how there’s no sequence like `11` in any of these strings? That’s because our function ensures no `1`s are placed consecutively.

---

## How It Works

The main function here is `binaryString`, which uses **recursion** to explore all possible ways of adding `0`s and `1`s to the string, making sure there are no consecutive `1`s. Here’s the process:

1. Start with an empty string.
2. At each step, add either `0` or `1`.
3. Only add `1` if the last added digit was `0` (to avoid consecutive `1`s).

---

## Understanding the Code

### Code Structure

Let’s break down the structure of `binaryString`:

```java
public class BinaryString {
    public static void binaryString(int n, int last, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        binaryString(n - 1, 0, str + "0");
        if (last == 0) {
            binaryString(n - 1, 1, str + "1");
        }
    }

    public static void main(String[] args) {
        binaryString(3, 0, "");
    }
}
```

### Parameters Explained
- `int n`: Represents the remaining length of the string to be generated.
- `int last`: Keeps track of the last character added (`0` or `1`). This helps us decide whether we’re allowed to add a `1`.
- `String str`: The string we’re building up. This starts empty and grows with each recursive call.

### Key Idea of Recursion
When `n` is zero, we’ve built a complete binary string, so we print it and end that path. If `n` is not zero, we:
1. Always add a `0` and call `binaryString` recursively.
2. Only add a `1` if the last digit was `0` (to avoid `11`).

---

## Code Walkthrough

Let’s walk through an example when `n = 3`:

### Step-by-Step Example

1. **Initial Call:** `binaryString(3, 0, "")`
    - Since `n != 0`, we make two recursive calls:
      - `binaryString(2, 0, "0")` – add a `0`
      - `binaryString(2, 1, "1")` – add a `1` (allowed because the last character is `0`)

2. **From `binaryString(2, 0, "0")`**:
    - Two recursive calls:
      - `binaryString(1, 0, "00")` – add a `0`
      - `binaryString(1, 1, "01")` – add a `1` (allowed because the last character is `0`)

3. **From `binaryString(2, 1, "1")`**:
    - Only one recursive call (adding `0`):
      - `binaryString(1, 0, "10")` – add a `0` (we cannot add `1` here)

4. **Final Recursive Calls:** 
    - The above calls continue until we reach `n == 0`, where the full strings are printed. Here’s the sequence of outputs:

    ```
    000
    001
    010
    100
    101
    ```

---

## Try It Yourself

You can change the value of `n` in the main method to see different lengths of binary strings:

```java
public static void main(String[] args) {
    binaryString(4, 0, ""); // Try for length 4
}
```

Experiment with different values to see how the function handles them. 

Happy coding! 🎉