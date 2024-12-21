
# Circular Linked List: Reverse Operation

## Introduction

The **Reverse** operation in a Circular Linked List rearranges the nodes so that the traversal order becomes reversed. This is done by altering the `next` pointers of the nodes while maintaining the circular structure of the list.

---

## Code Implementation

Here is the implementation of the `reverse` method:

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

    // Reverse Circular Linked List
    public void reverse() {
        if (head == null || head.next == head) {
            // List is empty or contains only one node
            return;
        }

        Node prev = null;       // Previous node (initially null)
        Node current = head;    // Current node (starts at head)
        Node next = null;       // Temporary next node storage
        Node oldHead = head;    // Store the original head for later use

        // Traverse and reverse pointers
        do {
            next = current.next;  // Save the next node
            current.next = prev;  // Reverse the pointer
            prev = current;       // Move prev forward
            current = next;       // Move current forward
        } while (current != head); // Stop when we return to the head

        // Adjust head and tail
        tail = oldHead;      // Old head becomes the new tail
        tail.next = prev;    // Tail's next points to the new head
        head = prev;         // New head is the last node in original order
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

        System.out.println("Original List:");
        cll.printLL(); // 20 -> 10 -> 30 -> 40 -> (head)

        cll.reverse();

        System.out.println("Reversed List:");
        cll.printLL(); // 40 -> 30 -> 10 -> 20 -> (head)
    }
}
```

---

## How It Works

1. **Base Case**:  
   - If the list is empty (`head == null`) or contains only one node (`head.next == head`), no changes are needed.

2. **Reverse Pointers**:  
   - Traverse the list using three pointers (`prev`, `current`, `next`):  
     - `prev` tracks the previous node.  
     - `current` tracks the current node.  
     - `next` temporarily stores the next node.  
   - Update the `next` pointer of each node to point to its predecessor.

3. **Adjust Head and Tail**:  
   - Update the `head` to the last node in the original order.  
   - Update the `tail` to the original `head`.  
   - Ensure the circular structure is maintained by pointing the `tail.next` to the new `head`.

---

## Example Output

### Input Code:
```java
CircularLL cll = new CircularLL();

cll.addFirst(10);
cll.addFirst(20);
cll.addLast(30);
cll.addLast(40);

System.out.println("Original List:");
cll.printLL(); // 20 -> 10 -> 30 -> 40 -> (head)

cll.reverse();

System.out.println("Reversed List:");
cll.printLL(); // 40 -> 30 -> 10 -> 20 -> (head)
```

### Output:
```
Original List:
20 -> 10 -> 30 -> 40 -> (head)
Reversed List:
40 -> 30 -> 10 -> 20 -> (head)
```

---

## Use Cases

- **Undoing operations**: Reversing a list can be useful for undoing certain operations.  
- **Reversing traversal**: When order of access needs to be reversed, this operation is handy.  
- **Data structure manipulations**: Commonly used in algorithms requiring reverse traversal or transformations.

