

# 🌟 Stack Implementation Using Linked List 💡

Welcome! In this chapter, we’ll learn how to implement a **Stack** using a **Linked List**. 🚀 This implementation uses dynamic memory allocation, allowing us to build the stack without worrying about resizing. By the end, you’ll understand how `push`, `pop`, and `peek` operations work step-by-step and their differences from the `ArrayList` implementation.

---

## 🛠️ Code Implementation

```java
public class StackLinkedList {
    static class Node {
        int data;
        Node next;

        // Constructor to initialize a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        // Check if the stack is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Push an element onto the stack
        public void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode; // If the stack is empty, the new node becomes the head
                return;
            }
            newNode.next = head; // Point the new node to the current head
            head = newNode; // Update the head to the new node
        }

        // Pop the top element from the stack
        public int pop() {
            if (isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            int val = head.data; // Get the top element
            head = head.next; // Update the head to the next node
            return val;
        }

        // Peek at the top element without removing it
        public int peek() {
            if (isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            return head.data; // Return the top element
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
- Returns `true` if the `head` is `null`.

### 2️⃣ **push(int data)**
- Creates a new `Node` with the given `data`.
- If the stack is empty, the new node becomes the `head`.
- Otherwise, the new node points to the current `head`, and the `head` is updated to the new node.

### 3️⃣ **pop()**
- Removes and returns the top element (the `head`).
- If the stack is empty, returns `-1`.
- Updates the `head` to the next node.

### 4️⃣ **peek()**
- Returns the data of the `head` without removing it.
- If the stack is empty, returns `-1`.

---

## ✅ Advantages of Using Linked List for Stack

1. **Dynamic Size:** No need to predefine or resize the stack.
2. **Efficient Memory Usage:** Only the required memory is allocated.
3. **No Shifting Overhead:** Adding and removing elements happens at the `head`, making it faster for operations.

---

## ❌ Disadvantages of Using Linked List for Stack

1. **Higher Memory Overhead:** Each element requires extra memory for the `next` pointer.
2. **Less Cache-Friendly:** Linked List nodes are scattered in memory, which can make access slower compared to contiguous `ArrayList`.

---

## ⚖️ Differences Between `ArrayList` and `Linked List` Implementations

| **Aspect**            | **ArrayList Implementation**                                | **Linked List Implementation**                         |
|------------------------|------------------------------------------------------------|-------------------------------------------------------|
| **Memory Usage**       | Efficient for simple data storage, as no extra pointers.   | Requires additional memory for `next` pointers.       |
| **Dynamic Resizing**   | Resizing may incur overhead.                               | Automatically resizes; no overhead.                   |
| **Cache Performance**  | Cache-friendly due to contiguous memory allocation.        | Less cache-friendly due to scattered memory.          |
| **Operations**         | Push and pop are constant time (O(1)) at the end.          | Push and pop are constant time (O(1)) at the head.    |

---

## 📊 Complexity Analysis

| **Operation** | **Time Complexity** | **Explanation**                    |
|---------------|----------------------|------------------------------------|
| `push`        | O(1)                 | Insert a new node at the `head`.  |
| `pop`         | O(1)                 | Remove the `head` node.           |
| `peek`        | O(1)                 | Access the `head` node.           |
| `isEmpty`     | O(1)                 | Simply check if `head` is `null`. |

---


In this chapter, we explored the **Linked List** implementation of a stack and compared it to the **ArrayList** implementation. Both methods are useful in different scenarios, and understanding these will make you a pro at working with stacks! 🎉