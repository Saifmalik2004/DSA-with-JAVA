

# Implementing a Queue Using Deque in Java (JCF)

This code demonstrates how to use the **Deque** (double-ended queue) to implement a **Queue**. A queue is a **First-In-First-Out (FIFO)** data structure where elements are added at the rear and removed from the front.

In this implementation, we use the `Deque` interface with `LinkedList` as the underlying data structure.

---

## Code Example

```java
import java.util.Deque;
import java.util.LinkedList;

public class DequeSol {
    static class Queue {

        // Declare a Deque to store queue elements
        Deque<Integer> deque = new LinkedList<>();

        // Method to check if the queue is empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }

        // Method to add (enqueue) an element to the queue
        public void add(int data) {
            deque.addLast(data); // Add to the rear of the queue
        }

        // Method to remove (dequeue) the front element from the queue
        public int remove() {
            return deque.removeFirst(); // Remove from the front of the queue
        }

        // Method to peek (view) the front element without removing it
        public int peek() {
            return deque.getFirst(); // Get the first element in the queue
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        // Add elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        // Peek at the front element
        System.out.println("Front of queue: " + q.peek());

        // Remove and print elements until the queue is empty
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
```

---

## Explanation of the Methods

1. **`add(int data)`**  
   - Adds an element to the rear of the queue (enqueue operation).  
   - Internally uses `deque.addLast(data)` to add the element to the end of the deque.  
   - Example:  
     ```java
     q.add(5);
     ```
     Queue becomes: `[1, 2, 3, 4, 5]`.

2. **`remove()`**  
   - Removes and returns the front element of the queue (dequeue operation).  
   - Internally uses `deque.removeFirst()` to remove the first element of the deque.  
   - Example:  
     ```java
     int front = q.remove();
     ```
     If the queue was `[1, 2, 3, 4, 5]`, after this operation, it becomes `[2, 3, 4, 5]`.

3. **`peek()`**  
   - Retrieves the front element of the queue without removing it.  
   - Internally uses `deque.getFirst()` to access the first element of the deque.  
   - Example:  
     ```java
     System.out.println(q.peek());
     ```
     If the queue is `[1, 2, 3, 4, 5]`, this returns `1`.

4. **`isEmpty()`**  
   - Checks if the queue is empty.  
   - Internally uses `deque.isEmpty()` to determine if the deque has no elements.  
   - Example:  
     ```java
     if (q.isEmpty()) {
         System.out.println("Queue is empty");
     }
     ```

---

## Output of the Provided Code

```plaintext
Front of queue: 1
1 2 3 4 5 
```

---

## Key Features of Using Deque for Queue

1. **Efficient Operations**:  
   - `addLast()` and `removeFirst()` are used to simulate queue operations (`enqueue` and `dequeue`), and they run in **O(1)** time.

2. **Reusable Data Structure**:  
   - The `Deque` interface can be used for both **stack** and **queue** implementations, making it versatile.

3. **Implementation Details**:  
   - We use `LinkedList` as the underlying implementation, which allows dynamic resizing and efficient insertions/removals.

---

## When to Use This Approach

- **Space Optimization**: If you want to use a single data structure for both stack and queue operations in different parts of your program.
- **Learning Purposes**: To understand how existing Java Collections Framework classes can be repurposed for custom use cases.
- **Custom Queue Behavior**: For applications requiring advanced queue-like behavior while benefiting from `Deque` methods like `addFirst` and `addLast`.
