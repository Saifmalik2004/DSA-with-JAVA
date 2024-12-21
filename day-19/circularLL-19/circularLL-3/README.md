### README for `removeFirst` Operation

---

# Circular Linked List: Remove First Operation

## Introduction

The **Remove First** operation allows us to delete the first node from the Circular Linked List. This operation updates the `head` pointer and maintains the circular structure of the list.

---

## Code Implementation

Here is the implementation for the `removeFirst` method:

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

    // Remove First Operation
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head == tail) {
            // Only one node in the list
            head = null;
            tail = null;
        } else {
            head = head.next; // Move the head to the next node
            tail.next = head; // Update the tail's next pointer to the new head
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

        cll.removeFirst();
        cll.printLL();
    }
}
```

---

## How It Works

1. **Check if the list is empty**:  
   - If `head` is `null`, the list is empty, and no removal can be performed.

2. **Check if the list has only one node**:  
   - If `head` equals `tail`, set both `head` and `tail` to `null`.

3. **If the list has more than one node**:  
   - Move the `head` pointer to the next node.  
   - Update the `tail`’s `next` pointer to point to the new `head`.

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

cll.removeFirst();
cll.printLL();
```

### List State After Execution:

1. **Initial List**:
   ```
   20 -> 10 -> 30 -> 40 -> (head)
   ```

2. **After `removeFirst()`**:
   ```
   10 -> 30 -> 40 -> (head)
   ```


---

# Circular Linked List: Remove Last Operation

## Introduction

The **Remove Last** operation allows us to delete the last node from the Circular Linked List. This operation involves updating the `tail` pointer and ensuring the circular nature of the list is preserved.

---

## Code Implementation

Here is the implementation for the `removeLast` method:

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

    // Remove Last Operation
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (head == tail) {
            // Only one node in the list
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next; // Traverse to the second last node
            }
            current.next = head; // Update second-last node's next to point to head
            tail = current;     // Update the tail pointer
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

        cll.removeLast();
        cll.printLL();
    }
}
```

---

## How It Works

1. **Check if the list is empty**:  
   - If `head` is `null`, the list is empty, and no removal can be performed.

2. **Check if the list has only one node**:  
   - If `head` equals `tail`, set both `head` and `tail` to `null`.

3. **If the list has more than one node**:  
   - Traverse to the second last node (the node before `tail`).  
   - Update the `next` pointer of the second last node to point to `head`.  
   - Update the `tail` pointer to the second last node.

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

cll.removeLast();
cll.printLL();
```

### List State After Execution:

1. **Initial List**:
   ```
   20 -> 10 -> 30 -> 40 -> (head)
   ```

2. **After `removeLast()`**:
   ```
   20 -> 10 -> 30 -> (head)
   ```

