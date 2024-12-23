# Push Bottom Function in a Stack

## Introduction
Stacks are an essential data structure in computer science, often referred to as "Last In, First Out" (LIFO). This means the last element added to the stack is the first one to be removed. While pushing elements onto the top of a stack is straightforward, inserting an element at the bottom requires a special approach since stacks do not natively support direct insertion at arbitrary positions.

In this guide, we'll dive into how the `pushBottom` function works, which allows us to push an element to the bottom of a stack without disrupting its order. This includes understanding the approach, the algorithm, pseudocode, and a complexity analysis.

---

## Problem Statement
Write a function that takes a stack and an integer value as input and pushes the integer value to the bottom of the stack. The order of the other elements in the stack should remain unchanged.

---

## Approach
The `pushBottom` function uses **recursion** to achieve its goal. Here's the step-by-step breakdown:

1. **Base Case:**
   - If the stack is empty, push the element directly onto it. This marks the bottom of the stack.

2. **Recursive Case:**
   - If the stack is not empty, pop the top element and recursively call `pushBottom` for the remaining stack.
   - Once the recursive call inserts the element at the bottom, push the previously popped element back onto the stack. This ensures the original order of the stack remains intact.

---

## Algorithm (Pseudocode)

```
Function pushBottom(Stack s, Integer data):
    If s.isEmpty():
        s.push(data)
        Return
    
    // Step 1: Remove the top element
    top = s.pop()

    // Step 2: Recursively call pushBottom for the remaining stack
    pushBottom(s, data)

    // Step 3: Push the top element back
    s.push(top)

End Function
```

---

## Java Implementation
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

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushBottom(s, 0);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
```

---

## Dry Run Example
Consider a stack `s` with elements `[3, 2, 1]` (top to bottom) and we want to push `0` to the bottom:

### Step-by-Step Execution:
1. **Initial Call:**
   - Stack: `[3, 2, 1]`
   - Element to push: `0`
   - Pop `3` and recursively call `pushBottom` on `[2, 1]`.

2. **Second Call:**
   - Stack: `[2, 1]`
   - Element to push: `0`
   - Pop `2` and recursively call `pushBottom` on `[1]`.

3. **Third Call:**
   - Stack: `[1]`
   - Element to push: `0`
   - Pop `1` and recursively call `pushBottom` on `[]` (empty stack).

4. **Base Case:**
   - Stack: `[]` (empty)
   - Push `0` directly onto the stack.

5. **Backtracking:**
   - Push `1` back onto `[0]` to get `[1, 0]`.
   - Push `2` back onto `[1, 0]` to get `[2, 1, 0]`.
   - Push `3` back onto `[2, 1, 0]` to get `[3, 2, 1, 0]`.

Resulting Stack: `[3, 2, 1, 0]`

---

## Complexity Analysis

### Time Complexity:
- Each recursive call processes one element of the stack.
- In the worst case, all elements are popped and pushed back, leading to `O(n)` operations.
- Hence, the time complexity is **O(n)**, where `n` is the number of elements in the stack.

### Space Complexity:
- The recursion stack uses additional space proportional to the number of elements in the stack.
- Hence, the space complexity is **O(n)**.

---

## Key Takeaways
- The `pushBottom` function cleverly uses recursion to insert an element at the bottom of a stack.
- By popping and re-pushing elements, the function ensures the stack's order remains unchanged.
- This approach highlights the power of recursion for problems involving data structures like stacks.

Happy coding! 🚀

