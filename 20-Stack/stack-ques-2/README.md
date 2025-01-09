# Reverse String Using a Stack

## Introduction 🚀
Reversing a string is a classic problem in computer science. While there are many ways to reverse a string, one interesting and engaging approach involves using a **stack**. Stacks operate on the "Last In, First Out" (LIFO) principle, making them ideal for reversing sequences. This guide explains how the provided Java program uses a stack to reverse a string step-by-step.

---

## Problem Statement ❓
Given a string `str`, write a function `reverseString` that uses a stack to reverse the order of characters in the string. The function should return the reversed string as output.

---

## Approach 🛠️
The `reverseString` function works in two main phases:

1. **Push Phase:**
   - Iterate over each character of the input string and push it onto the stack.
   - By the end of this phase, the stack will contain all characters of the string, with the last character at the top.

2. **Pop Phase:**
   - Pop each character from the stack and append it to a result string.
   - Since the stack operates in LIFO order, popping characters from the stack gives us the reversed string.

---

## Algorithm (Pseudocode) 📜

```
Function reverseString(String str):
    Initialize an empty stack `s`

    // Step 1: Push all characters onto the stack
    For each character in str:
        s.push(character)

    Initialize an empty result string

    // Step 2: Pop characters from the stack and append to result
    While stack is not empty:
        result += s.pop()

    Return result
```

---

## Java Implementation 💻
```java
import java.util.Stack;

public class StackJFC {

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int i = 0;

        // Step 1: Push all characters onto the stack
        while (i < str.length()) {
            s.push(str.charAt(i));
            i++;
        }

        StringBuilder result = new StringBuilder();

        // Step 2: Pop characters from the stack and append to result
        while (!s.isEmpty()) {
            result.append(s.peek());
            s.pop();
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "saifmalik";
        System.out.println(reverseString(str));
    }
}
```

---

## Dry Run Example 📝
Let's reverse the string `"saifmalik"` using this program:

### Initial Input:
`str = "saifmalik"`

### Step 1: Push Characters onto the Stack
| Iteration | Character | Stack           |
|-----------|-----------|-----------------|
| 1         | `s`       | [s]             |
| 2         | `a`       | [s, a]          |
| 3         | `i`       | [s, a, i]       |
| 4         | `f`       | [s, a, i, f]    |
| 5         | `m`       | [s, a, i, f, m] |
| 6         | `a`       | [s, a, i, f, m, a] |
| 7         | `l`       | [s, a, i, f, m, a, l] |
| 8         | `i`       | [s, a, i, f, m, a, l, i] |
| 9         | `k`       | [s, a, i, f, m, a, l, i, k] |

### Step 2: Pop Characters from the Stack
| Iteration | Stack               | Result String |
|-----------|---------------------|---------------|
| 1         | [s, a, i, f, m, a, l, i] | `k`           |
| 2         | [s, a, i, f, m, a, l]    | `ki`          |
| 3         | [s, a, i, f, m, a]       | `kil`         |
| 4         | [s, a, i, f, m]          | `kila`        |
| 5         | [s, a, i, f]             | `kilam`       |
| 6         | [s, a, i]                | `kilamf`      |
| 7         | [s, a]                   | `kilamfi`     |
| 8         | [s]                      | `kilamfia`    |
| 9         | []                       | `kilamfias`   |

### Final Output:
`"kilamfias"`

---

## Complexity Analysis 📊

### Time Complexity:
1. **Push Phase:**
   - Iterating through the string takes **O(n)** time, where `n` is the length of the string.
2. **Pop Phase:**
   - Popping all characters from the stack also takes **O(n)** time.

**Total Time Complexity:**
- **O(n)**

### Space Complexity:
- The stack stores all characters of the string, which takes **O(n)** space.

**Total Space Complexity:**
- **O(n)**

---

## Key Takeaways 🎉
- Stacks provide a straightforward and intuitive way to reverse sequences like strings.
- This program demonstrates how to efficiently use stacks for practical problems.
- You’ve not only learned about reversing strings but also how stacks operate in a real-world scenario.

Happy coding! 🌟

