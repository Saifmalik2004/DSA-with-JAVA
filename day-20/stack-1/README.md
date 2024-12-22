

# 🌟 Stack Implementation Using ArrayList 💡

Welcome! In this chapter, we’ll learn how to implement a **Stack** using Java’s `ArrayList`. 🚀 By the end, you’ll understand its key operations—`push`, `pop`, and `peek`—and how the implementation works step-by-step.

---

## 🛠️ Code Implementation

```java
import java.util.ArrayList;

public class StackArraylist {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // Check if the stack is empty
        public boolean isEmpty() {
            return list.isEmpty();
        }

        // Push an element onto the stack
        public void push(int data) {
            list.add(data);
        }

        // Pop the top element from the stack
        public int pop() {
            if (isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            int top = list.get(list.size() - 1); // Get the top element
            list.remove(list.size() - 1); // Remove it from the stack
            return top;
        }

        // Peek at the top element without removing it
        public int peek() {
            if (isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            return list.get(list.size() - 1); // Return the top element
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1); // Push 1 onto the stack
        stack.push(2); // Push 2 onto the stack
        stack.push(3); // Push 3 onto the stack

        // Print and pop elements from the stack
        while (!stack.isEmpty()) {
            System.out.println(stack.peek()); // Peek the top element
            stack.pop(); // Pop the top element
        }
    }
}
```

---

## 🔍 Explanation

### 1️⃣ **isEmpty()**
- Checks if the stack has any elements.
- Returns `true` if the stack is empty; otherwise, `false`.

### 2️⃣ **push(int data)**
- Adds an element (`data`) to the top of the stack.
- Internally, uses `ArrayList`’s `add()` method.

### 3️⃣ **pop()**
- Removes and returns the top element of the stack.
- Uses `ArrayList`’s `get()` and `remove()` methods to access and remove the last element.

### 4️⃣ **peek()**
- Returns the top element of the stack without removing it.
- Similar to `pop()` but doesn’t modify the stack.

---

## ✅ Advantages
1. **Dynamic Resizing:** No need to predefine the stack size.  
2. **Built-in Functions:** Simplifies implementation using `ArrayList` methods.  
3. **Ease of Use:** Ideal for applications where stack size changes frequently.

---

## ❌ Disadvantages
1. **Overhead for Shifting Elements:** If `remove()` or `add()` operations happen at other positions (not applicable here as we always use the end).  
2. **Memory Usage:** Uses additional memory for the underlying `ArrayList` structure.

---

## 📊 Complexity Analysis

| **Operation** | **Time Complexity** | **Explanation** |
|---------------|----------------------|------------------|
| `push`        | O(1)                 | Adding at the end of the `ArrayList` is constant time. |
| `pop`         | O(1)                 | Removing the last element is efficient. |
| `peek`        | O(1)                 | Accessing the last element is constant time. |
| `isEmpty`     | O(1)                 | Checking if the list is empty is constant time. |

---

## 📚 What’s Next?
In the next chapter, we’ll explore how to implement a **Stack** using a Linked List. This approach will help you understand the differences between these implementations and when to use each. Stay tuned! 🌟

