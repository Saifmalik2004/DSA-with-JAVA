# 🌟 Stack Implementation Using Java Collection Framework (JCF) 💡

In this chapter, we’ll explore how to implement a **Stack** using the **Java Collection Framework's** `Stack` class. 🚀 This built-in class simplifies working with stacks by providing pre-optimized implementations for all stack operations. If there's no explicit requirement to implement a stack from scratch, this approach is the best choice!

---

## 🛠️ Code Implementation

```java
import java.util.Stack;

public class StackJFC {
    public static void main(String[] args) {
        // Create a Stack instance
        Stack<Integer> s = new Stack<>();

        // Push elements onto the stack
        s.push(1);
        s.push(2);
        s.push(3);

        // Print and pop elements from the stack
        while (!s.isEmpty()) {
            System.out.println(s.peek()); // Peek the top element
            s.pop(); // Pop the top element
        }
    }
}
```

---

## 🔍 Explanation

### 1️⃣ **What is the Java `Stack` class?**
The `Stack` class in Java is part of the **Java Collection Framework (JCF)** and is a subclass of `Vector`. It provides built-in methods to perform standard stack operations such as `push`, `pop`, and `peek`. Using this class saves time and effort, as we don’t need to build a stack from scratch.

---

### 2️⃣ **Key Operations**

- **`push(E item)`**  
  Adds an element (`item`) to the top of the stack.  

- **`pop()`**  
  Removes and returns the top element of the stack.  

- **`peek()`**  
  Returns the top element of the stack without removing it.  

- **`isEmpty()`**  
  Checks whether the stack is empty.  

---

## ✅ Advantages of Using the Java `Stack` Class

1. **Pre-Optimized Implementation:**  
   Built-in stack operations are already optimized for performance, eliminating the need to handle low-level details.

2. **Time-Saving:**  
   Developers can focus on solving the problem rather than implementing and maintaining a stack.

3. **Seamless Integration:**  
   Part of the JCF, so it integrates well with other Java data structures and utilities.

4. **Ease of Use:**  
   Provides intuitive methods like `push`, `pop`, `peek`, and `isEmpty`, making it beginner-friendly.

---

## ⚖️ Complexity Analysis

| **Operation** | **Time Complexity** | **Explanation**                    |
|---------------|----------------------|------------------------------------|
| `push`        | O(1)                 | Appends the element to the stack. |
| `pop`         | O(1)                 | Removes the top element.          |
| `peek`        | O(1)                 | Accesses the top element.         |
| `isEmpty`     | O(1)                 | Checks if the stack is empty.     |

---

## 🔗 When to Use JCF's `Stack`?

- If the problem statement doesn’t specify **building a stack from scratch**, use the JCF’s `Stack` class for efficiency and simplicity.
- Suitable for competitive programming or real-world applications where you need a reliable and optimized stack implementation.

---

## 📚 What’s Next?

Now that we’ve seen how to use Java’s built-in `Stack` class, you can focus more on solving problems involving stacks rather than spending time implementing them. From managing undo-redo functionality to evaluating expressions, the `Stack` class is your go-to tool! 🎉