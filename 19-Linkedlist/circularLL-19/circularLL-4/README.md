
# Circular Linked List: Search Operation

## Introduction

The **Search** operation allows us to find whether a specific value exists in the Circular Linked List. It involves traversing the list and checking each node's value. The circular nature of the list ensures that we stop once we return to the starting point.

---

## Code Implementation

Here is the implementation for the `search` method:

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

    // Search Operation
    public boolean search(int key) {
        if (head == null) {
            return false; // List is empty
        }
        Node current = head;
        do {
            if (current.data == key) {
                return true; // Key found
            }
            current = current.next;
        } while (current != head); // Stop when we return to the head
        return false; // Key not found
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
        cll.printLL(); // 20 -> 10 -> 30 -> (head)

        System.out.println("Search 10: " + cll.search(10)); // true
        System.out.println("Search 50: " + cll.search(50)); // false
    }
}
```

---

## How It Works

1. **Check if the list is empty**:  
   - If `head` is `null`, the list is empty, and the method returns `false`.

2. **Traverse the list**:  
   - Start from the `head` node.  
   - Compare the `data` of each node with the key to be searched.  

3. **Circular Traversal**:  
   - Use a `do-while` loop to ensure that the traversal completes one full cycle of the circular list.  
   - Stop the traversal when the current node returns to `head`.

4. **Return the result**:  
   - Return `true` if the key is found.  
   - Return `false` if the traversal completes without finding the key.

---

## Example Output

### Input Code:
```java
CircularLL cll = new CircularLL();

cll.addFirst(10);
cll.addFirst(20);
cll.addLast(30);
cll.printLL(); // 20 -> 10 -> 30 -> (head)

System.out.println("Search 10: " + cll.search(10)); // true
System.out.println("Search 50: " + cll.search(50)); // false
```

### Output:
```
20 -> 10 -> 30 -> (head)
Search 10: true
Search 50: false
```

---

## Use Cases

- **Finding a specific element**: Useful when you need to determine if an element exists in the circular linked list.  
- **Conditional operations**: Before performing any operation on a node, you can check if it exists.

---
