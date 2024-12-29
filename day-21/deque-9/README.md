
# Understanding Deque in Java (JCF)

`Deque` (short for "double-ended queue") is a part of the **Java Collections Framework (JCF)** and provides functionality to add, remove, and access elements from both ends (front and rear) of the collection. It is defined in the `java.util` package and is implemented by classes such as `LinkedList` and `ArrayDeque`.

The following code demonstrates the use of a `Deque` with `LinkedList` as its implementation.

---

## Code Example

```java
import java.util.Deque;
import java.util.LinkedList;

public class DequeJCF {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(0); // Adds 0 at the front of the deque
        deque.addLast(1);  // Adds 1 at the rear of the deque
        deque.addLast(2);  // Adds 2 at the rear of the deque

        System.out.println(deque); // Prints: [0, 1, 2]

        deque.removeFirst(); // Removes the first element (0)
        deque.removeLast();  // Removes the last element (2)
        System.out.println(deque); // Prints: [1]

        deque.addLast(2); // Adds 2 at the rear
        deque.addLast(3); // Adds 3 at the rear

        System.out.println(deque); // Prints: [1, 2, 3]

        System.out.println("Get first: " + deque.getFirst()); // Gets the first element (1)
        System.out.println("Get last: " + deque.getLast());   // Gets the last element (3)
    }
}
```

---

## Explanation of `Deque` Methods

1. **`addFirst(E e)`**  
   - Adds an element `e` to the front of the deque.  
   - Example:  
     ```java
     deque.addFirst(0);
     ```
     After this operation, the deque becomes `[0]` (if it was initially empty).

2. **`addLast(E e)`**  
   - Adds an element `e` to the rear of the deque.  
   - Example:  
     ```java
     deque.addLast(1);
     deque.addLast(2);
     ```
     After these operations, the deque becomes `[0, 1, 2]`.

3. **`removeFirst()`**  
   - Removes and returns the first element of the deque.  
   - Example:  
     ```java
     deque.removeFirst();
     ```
     If the deque is `[0, 1, 2]`, after this operation, it becomes `[1, 2]`.

4. **`removeLast()`**  
   - Removes and returns the last element of the deque.  
   - Example:  
     ```java
     deque.removeLast();
     ```
     If the deque is `[1, 2]`, after this operation, it becomes `[1]`.

5. **`getFirst()`**  
   - Retrieves, but does not remove, the first element of the deque.  
   - Example:  
     ```java
     System.out.println(deque.getFirst());
     ```
     If the deque is `[1, 2, 3]`, this returns `1`.

6. **`getLast()`**  
   - Retrieves, but does not remove, the last element of the deque.  
   - Example:  
     ```java
     System.out.println(deque.getLast());
     ```
     If the deque is `[1, 2, 3]`, this returns `3`.

---

## Key Features of `Deque`

1. **Double-Ended Operations**:  
   Elements can be added or removed from both ends, unlike a regular queue, which is strictly FIFO (First-In-First-Out).

2. **Flexibility**:  
   - Can be used as a **queue** (FIFO) or **stack** (LIFO).
   - Example for stack behavior: Use `addFirst()` and `removeFirst()`.

3. **Implementation Options**:  
   - Common implementations include `LinkedList` and `ArrayDeque`.  
   - `LinkedList` is better suited for frequent insertions and deletions.  
   - `ArrayDeque` is more efficient for accessing elements due to its array-based structure.

---

## Output of the Provided Code

```plaintext
[0, 1, 2]
[1]
[1, 2, 3]
Get first: 1
Get last: 3
```

---

## When to Use `Deque`

- **Deque as a Queue**: Use `addLast()` and `removeFirst()` for standard queue operations.
- **Deque as a Stack**: Use `addFirst()` and `removeFirst()` for LIFO operations.
- **Efficient Operations**: If your use case requires frequent addition or removal from both ends, `Deque` is ideal.

