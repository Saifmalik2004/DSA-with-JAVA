### README for `addLast` Operation

---

# Circular Linked List: Add Last Operation

## Introduction

The **Add Last** operation allows us to insert a new node at the end of the Circular Linked List. This operation ensures that the newly added node becomes the new tail, while maintaining the circular structure.

---

## Code Implementation

Here is the implementation for the `addLast` method:

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

    // Add Last Operation
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // List is empty, new node becomes head and tail
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            // Insert at the end
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Tail points back to head
        }
    }

    // Print Circular Linked List
    public void printLL() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        CircularLL cll = new CircularLL();

        cll.addFirst(10);
        cll.addFirst(20);
        cll.addLast(30);
        cll.addLast(40);
        cll.printLL();
    }
}
```

---

## How It Works

1. **Check for an empty list**:  
   - If the list is empty, the new node becomes both the `head` and the `tail`.  
   - The `next` pointer of the new node points to itself, completing the circular structure.

2. **If the list is not empty**:  
   - The current `tail`’s `next` pointer is updated to point to the new node.  
   - The new node becomes the new `tail`.  
   - The `next` pointer of the new `tail` points to the `head`, maintaining the circular structure.

---

## Example Output

### Input Code:
```java
CircularLL cll = new CircularLL();

cll.addFirst(10);
cll.addFirst(20);
cll.addLast(30);
cll.addLast(40);
cll.printLL();
```

### List State After Execution:
```
20 -> 10 -> 30 -> 40 -> (head)
```

---

### Next Step

If this is complete, let me know, and I’ll create the README for **Remove First**.