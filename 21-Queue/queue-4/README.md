
# Queue Implementation Using Java Collection Framework

This program demonstrates how to create and use a **Queue** in Java using the **Java Collection Framework**. A `Queue` is a First-In-First-Out (FIFO) data structure, where elements are added at the rear and removed from the front.

## Key Features of Queues in Java:
1. **Interface**: The `Queue` is part of the `java.util` package and extends the `Collection` interface.
2. **Common Implementations**:
   - **LinkedList**: A commonly used implementation for a general-purpose queue.
   - **PriorityQueue**: A queue where elements are processed based on priority.

## Explanation of the Code:
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueJCF {
    public static void main(String[] args) {
        // Create a queue using LinkedList
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add(0);
        queue.add(1);
        queue.add(2);

        // Process the queue until it is empty
        while (!queue.isEmpty()) {
            // Peek at the front element
            System.out.println(queue.peek());

            // Remove the front element
            queue.remove();
        }
    }
}
```

### Step-by-Step Breakdown:
1. **Initialization**:
   - A `Queue` is declared using the `Queue<Integer>` interface and instantiated as a `LinkedList`.

2. **Adding Elements**:
   - `queue.add(element)` is used to add elements to the queue. These elements are placed at the rear.

3. **Accessing the Front Element**:
   - `queue.peek()` retrieves the front element without removing it from the queue.

4. **Removing Elements**:
   - `queue.remove()` removes the front element from the queue.

5. **Looping Until Empty**:
   - The `while` loop continues until the queue is empty, with each iteration printing and removing the front element.

## Output:
When you run the program, it outputs the elements in the order they were added:
```
0
1
2
```

## Advantages of Using Java Collection Framework for Queues:
- **Pre-built Methods**: Easily add, peek, or remove elements without manually handling indices.
- **Flexibility**: Can switch implementations (e.g., `LinkedList` to `PriorityQueue`) without changing much code.
- **Type Safety**: Using generics (`Queue<Integer>`) ensures type consistency.

## When to Use Queues:
- Task scheduling
- Order processing
- Breadth-first search in graphs
- Real-world scenarios like printer queues or call center systems

