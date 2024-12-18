# Doubly Linked List in Java

A **Doubly Linked List** is a type of linked list where each node has pointers to both its previous and next nodes. This makes it more flexible compared to a singly linked list, as it allows traversal in both directions (forward and backward). 

In this guide, we will explain:
- What a Doubly Linked List is.
- How to initialize it in Java.
- A simple diagram to visualize its structure.

---

## What is a Doubly Linked List? 

A Doubly Linked List consists of nodes where each node contains:
1. **Data**: The value stored in the node.
2. **Pointer to Previous Node (`prev`)**: Points to the previous node in the list.
3. **Pointer to Next Node (`next`)**: Points to the next node in the list.

This two-way connection allows for:
- Efficient insertion and deletion at both ends of the list.
- Easy traversal in both forward and backward directions.

---

## Doubly Linked List Structure
### Visual Representation:

Here’s how a Doubly Linked List looks:

```
null <-- [prev | data | next] <--> [prev | data | next] <--> [prev | data | next] --> null
```

- `null`: Represents the start (`head.prev`) and end (`tail.next`) of the list.
- Each node connects to its previous and next neighbors.

---

## How to Initialize a Doubly Linked List in Java

To create a basic Doubly Linked List, we define a `Node` class and manage it using `head` and `tail` pointers. 

Here’s the Java implementation:

### Code Example:
```java
public class DoublyLL {
    // Node class representing each node in the list
    public static class Node {
        Node prev; // Pointer to the previous node
        int data;  // Data stored in the node
        Node next; // Pointer to the next node

        // Constructor to initialize a node with data
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and Tail pointers for the Doubly Linked List
    public static Node head; // Points to the first node
    public static Node tail; // Points to the last node

    // To track the size of the list
    public static int size;

    public static void main(String[] args) {
        System.out.println("Basic Linked List implementation");
    }
}
```

---

### Explanation:

1. **Node Class**:
   - Contains three fields: `prev`, `data`, and `next`.
   - The `data` field stores the value of the node, while `prev` and `next` maintain the links to adjacent nodes.

2. **Head and Tail**:
   - `head` points to the first node of the list.
   - `tail` points to the last node of the list.

3. **Size**:
   - Tracks the total number of nodes in the list.

---

## Diagram
Here’s a visual representation of a Doubly Linked List:

### Example:
Let’s say we have a list with three nodes containing data `10`, `20`, and `30`:

```text
null <-- [null | 10 | *] <--> [* | 20 | *] <--> [* | 30 | null] --> null
```

### Emoji Visualization:
```text
🟢null ← [ 10 ] ↔ [ 20 ] ↔ [ 30 ] → 🔴null
```
- **🟢 null**: Represents the start of the list.
- **[data]**: Represents a node with data (e.g., `10`, `20`, `30`).
- **↔**: Represents the two-way link between nodes.
- **🔴 null**: Represents the end of the list.

---

## Key Points to Remember

1. **Bidirectional Traversal**:
   - Use `next` to traverse forward.
   - Use `prev` to traverse backward.

2. **Initialization**:
   - Start with an empty list (`head = null`, `tail = null`).

3. **Flexibility**:
   - Doubly Linked Lists are more flexible than singly linked lists but require additional memory for the `prev` pointer.

---

Now that we understand the basics and initialization, in the next step, we’ll explore how to add nodes to the list.

