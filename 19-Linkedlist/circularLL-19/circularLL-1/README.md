

# Circular Linked List: Add First Operation

## Introduction

In this section, we focus on the **Add First** operation for a Circular Linked List. This operation allows us to insert a new node at the beginning of the list, making it the new head.

---

## Code Implementation

Here is the implementation for the `addFirst` method:

```java
public class CircularLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // Add First Operation
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // List is empty, point new node to itself
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            // Insert at the beginning
            newNode.next = head;
            head = newNode;
            tail.next = head; // Update tail's next to point to the new head
        }
    }

    public static void main(String[] args) {
        CircularLL cll = new CircularLL();

        cll.addFirst(10);
        cll.addFirst(20);
    }
}
```

---

## How It Works

1. **Check for an empty list**:  
   - If the list is empty, the new node becomes both the `head` and the `tail`.  
   - The `next` pointer of the new node points to itself, completing the circular structure.

2. **If the list is not empty**:  
   - The new node’s `next` pointer is updated to point to the current `head`.  
   - The new node becomes the new `head`.  
   - The `tail`’s `next` pointer is updated to point to the new `head`, maintaining the circular structure.

---

## Example Output

### Input Code:
```java
CircularLL cll = new CircularLL();

cll.addFirst(10);
cll.addFirst(20);
```

### List State After Execution:
```
20 -> 10 -> (head)
```

---
