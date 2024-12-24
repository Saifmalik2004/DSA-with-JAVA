# Reverse a Stack Using Recursion

## Introduction 🚀
Reversing a stack is a fascinating problem that tests your understanding of recursion and stack operations. In this approach, we reverse the stack **in place** without using any additional data structures. Let’s dive into the logic and implementation step-by-step! 🎯

---

## Problem Statement ❓
Given a stack of integers, write a function `reverseStack` to reverse the elements of the stack **in place** using recursion.

---

## Approach 🛠️
The key idea is to use recursion to remove the top element of the stack, reverse the remaining stack, and then insert the removed element at the bottom of the reversed stack. This process continues recursively until the entire stack is reversed.

The solution involves two main functions:
1. **`pushBottom`**: Inserts an element at the bottom of the stack.
2. **`reverseStack`**: Reverses the stack using recursion.

---

## Algorithm (Pseudocode) 📜

### `pushBottom` Function
```
Function pushBottom(stack, data):
    If stack is empty:
        stack.push(data)
        Return
    top = stack.pop()
    pushBottom(stack, data)
    stack.push(top)
```

### `reverseStack` Function
```
Function reverseStack(stack):
    If stack is empty:
        Return
    top = stack.pop()
    reverseStack(stack)
    pushBottom(stack, top)
```

---

## Java Implementation 💻
```java
import java.util.Stack;

public class StackJFC {
    
    public static void pushBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        reverseStack(s);
        printStack(s);
    }
}
```

---

## Dry Run Example 📝
Let’s reverse a stack `[1, 2, 3]` step-by-step:

### Initial Stack:
`[1, 2, 3]` (Top: 3)

### Step 1: Reverse Stack Recursively
1. Pop `3`, call `reverseStack` on `[1, 2]`.
2. Pop `2`, call `reverseStack` on `[1]`.
3. Pop `1`, call `reverseStack` on `[]` (empty stack).

### Step 2: Push Elements to Bottom
1. Push `1` to the bottom of `[]` → `[1]`.
2. Push `2` to the bottom of `[1]` → `[1, 2]`.
3. Push `3` to the bottom of `[1, 2]` → `[1, 2, 3]` (reversed).

### Final Stack:
`[3, 2, 1]` (Top: 1)

---

## Complexity Analysis 📊

### Time Complexity:
1. **`reverseStack`**:
   - Each call removes one element and makes a recursive call → **O(n)**.
2. **`pushBottom`**:
   - Inserts an element at the bottom, requiring **O(n)** for each of the `n` elements.

**Total Time Complexity:**
- **O(n²)**

### Space Complexity:
- **O(n)**: For the recursive stack calls.

---

## Key Takeaways 🎉
- This problem demonstrates the power of recursion in solving stack-related challenges.
- You don’t need extra data structures to reverse a stack if you use recursion effectively.
- Understanding this problem helps build a solid foundation in recursion and stack operations.

Happy coding! 🌟

