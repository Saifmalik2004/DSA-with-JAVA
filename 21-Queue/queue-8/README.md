
# **🔄 Reverse a Queue Using a Stack**

## **📜 The Problem**
Given a queue, reverse its elements using a stack. The task is to modify the original queue such that the elements appear in reverse order.

---

## **❓ Problem Statement**

You are given a queue containing integers. Your goal is to reverse the order of the elements in the queue by utilizing a stack.

### **Example**

**Input:**  
`1 2 3 4 5 6 7 8 9 10`

**Output:**  
`10 9 8 7 6 5 4 3 2 1`

---

## **🛠️ Approach**

The **stack-based approach** is a simple and efficient method to reverse the queue.

### **Step-by-Step Explanation**

1. **Transfer Elements to Stack**  
   - Use a stack to store the elements from the queue.  
   - Remove each element from the queue and push it onto the stack.

2. **Transfer Back to Queue**  
   - Pop each element from the stack and insert it back into the queue.

3. **Result**  
   - The queue is now reversed, as the stack reverses the order of the elements.

---

## **🧩 Algorithm (Pseudocode)**

```plaintext
1. Function interLeave(Queue original):
    a. Initialize an empty stack: Stack s.
    b. While the queue is not empty:
        - Remove an element from the front of the queue and push it onto the stack.
    c. While the stack is not empty:
        - Pop an element from the stack and add it back to the queue.
2. End of function.
```

---

## **📄 Code Explanation (Walkthrough)**

### Code:
```java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSol {
    public static void reverse(Queue<Integer> original) {
        // Step 1: Initialize a stack
        Stack<Integer> s = new Stack<>();

        // Step 2: Transfer all elements from the queue to the stack
        while (!original.isEmpty()) {
            s.add(original.remove());
        }

        // Step 3: Transfer all elements back to the queue from the stack
        while (!s.isEmpty()) {
            original.add(s.pop());
        }
    }

    public static void main(String[] args) {
        // Step 4: Create a queue and add elements
        Queue<Integer> original = new LinkedList<>();
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        original.add(5);
        original.add(6);
        original.add(7);
        original.add(8);
        original.add(9);
        original.add(10);

        // Step 5: Reverse the queue using the reverse function
        reverse(original);

        // Step 6: Print the reversed queue
        while (!original.isEmpty()) {
            System.out.print(original.remove() + " ");
        }
        System.out.println();
    }
}
```

---

### **Walkthrough**

1. **Input the Queue**  
   The queue is initialized with integers from `1` to `10`.

2. **Transfer to Stack**  
   - The queue starts as: `1 2 3 4 5 6 7 8 9 10`.  
   - Each element is removed from the queue and pushed onto the stack.  
   - After this step, the stack contains: `10 9 8 7 6 5 4 3 2 1`.

3. **Transfer Back to Queue**  
   - Each element is popped from the stack and added back to the queue.  
   - The stack is **Last In First Out (LIFO)**, so the queue now contains: `10 9 8 7 6 5 4 3 2 1`.

4. **Output the Reversed Queue**  
   - The reversed queue is printed as: `10 9 8 7 6 5 4 3 2 1`.

---

## **⏳ Time Complexity**

1. **Transfer to Stack:**  
   - Removing elements from the queue and pushing them onto the stack takes **O(n)**.  

2. **Transfer Back to Queue:**  
   - Popping elements from the stack and adding them back to the queue takes **O(n)**.

**Overall Time Complexity:**  
**O(n)** (Linear Time)

---

## **💾 Space Complexity**

- An additional stack is used to store all the elements from the queue.  
**Space Complexity:** **O(n)** (Linear Space)

---

## **✨ Key Features**

- **Simple Logic:** The use of a stack makes reversing straightforward.  
- **Efficient:** Operates in linear time.  
- **Practical Usage:** Demonstrates the interplay of stack and queue data structures.

---

🚀 **Now you know how to reverse a queue using a stack!**