

# LinkedList Implementation in Java

A **LinkedList** is a linear data structure where elements (nodes) are connected using pointers. Each node consists of two parts:
1. **Data**: The value stored in the node.
2. **Next**: A reference (pointer) to the next node in the sequence.

## **How to Create a LinkedList**

The process of creating a LinkedList involves two main steps:

### 1. **Define the Node Class**
The `Node` class represents a single element in the LinkedList. Each `Node` has:
- `data`: An integer value stored in the node.
- `next`: A reference to the next node in the list.

Here’s the code for the `Node` class:
```java
public static class Node {
    int data;  // Value stored in the node
    Node next; // Pointer to the next node

    public Node(int data) {
        this.data = data;  // Initialize the node with a value
        this.next = null;  // Set next to null as default
    }
}
```

### 2. **Set Up the LinkedList Class**
The `LinkedList` class keeps track of the list's state using:
- `head`: A reference to the first node in the list.
- `tail`: A reference to the last node in the list.
- `size`: The total number of nodes.

Here’s the basic structure:
```java
public class LinkedList {
    public static int size;    // Tracks the number of nodes in the list
    public static Node head;   // Reference to the first node
    public static Node tail;   // Reference to the last node

    public static void main(String[] args) {
        System.out.println("Basic LinkedList implementation");
    }
}
```

---

## **Visual Representation**

Below is an illustration of how nodes are connected to form a LinkedList:

![LinkedList Visualization](https://upload.wikimedia.org/wikipedia/commons/6/6d/Singly-linked-list.svg)

### Explanation of the Image:
1. **Head**: Points to the first node.
2. **Next Pointer**: Each node points to the next node using its `next` property.
3. **Tail**: The last node’s `next` pointer is `null`, indicating the end of the list.

For example, a LinkedList with three nodes:
```
Head -> [10 | Next] -> [20 | Next] -> [30 | Null]
```

---

This setup provides the foundation for creating and traversing a LinkedList. The next steps involve adding data and manipulating the structure, but the above demonstrates how the basic structure is initialized.