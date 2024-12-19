# Swapping Two Nodes in a Singly Linked List

In this explanation, we'll walk through the process of swapping two nodes in a **Singly Linked List** without actually swapping their data. We will explore the approach, visualize how pointers are updated, analyze the algorithm, and run the full program to understand how it works. This guide is tailored to beginners and includes step-by-step instructions.

---

## **Approach**
The goal is to swap two nodes, `x` and `y`, in a singly linked list. To achieve this:

1. **Identify the nodes to be swapped:**
   - Traverse the list to locate nodes containing the values `x` and `y`.
   - Keep track of their previous nodes (`prevX` and `prevY`) and their current nodes (`currX` and `currY`).

2. **Handle special cases:**
   - If either `x` or `y` is not found in the list, no swap is performed.
   - If `x` and `y` are the same, no swap is needed.

3. **Update the previous pointers:**
   - If `x` is not the head, update `prevX.next` to point to `currY`. Otherwise, update the head to `currY`.
   - Similarly, update `prevY.next` to point to `currX`.

4. **Swap the `next` pointers of `currX` and `currY`:**
   - Exchange their `next` pointers to complete the swap.

---

## **Algorithm**
Here’s the step-by-step algorithm:

1. Initialize pointers `prevX = null`, `currX = head`, `prevY = null`, and `currY = head`.
2. Traverse the list to find `x` and `y`:
   - Update `prevX` and `currX` while searching for `x`.
   - Update `prevY` and `currY` while searching for `y`.
3. If either `currX` or `currY` is `null`, return (one or both values not found).
4. If `prevX` is not `null`, update `prevX.next = currY`. Otherwise, update `head = currY`.
5. If `prevY` is not `null`, update `prevY.next = currX`. Otherwise, update `head = currX`.
6. Swap the `next` pointers of `currX` and `currY`.
7. The swap is complete.

---

## **Code Implementation**

```java
public class LinkedList {
    // Node class representing each element in the linked list
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // LinkedList attributes
    public static Node head; // Reference to the head node

    // Method to add a node at the end of the LinkedList
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Method to print the LinkedList
    public void print() {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to swap two nodes in the LinkedList
    public void swapNodes(int x, int y) {
        if (x == y) return; // No need to swap if the values are the same

        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not found, no swap is possible
        if (currX == null || currY == null) return;

        // Update the previous pointers
        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        // Swap the next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    // Main method to test the LinkedList
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Adding elements to the LinkedList
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        System.out.println("Original LinkedList:");
        ll.print();

        // Swap nodes with values 2 and 3
        ll.swapNodes(2, 3);

        System.out.println("LinkedList after swapping nodes 2 and 3:");
        ll.print();
    }
}
```

---

## **Visualization of Pointers**

### Initial State:
```
HEAD -> [1] -> [2] -> [3] -> [4] -> null
```

- `prevX = null`, `currX = [2]` (node containing 2)
- `prevY = [2]`, `currY = [3]` (node containing 3)

### After Updating Pointers:
1. Update `prevX.next` to point to `currY` (if `prevX` is not `null`).
2. Update `prevY.next` to point to `currX` (if `prevY` is not `null`).
3. Swap the `next` pointers of `currX` and `currY`.

### Final State:
```
HEAD -> [1] -> [3] -> [2] -> [4] -> null
```

---

## **Complexity Analysis**

1. **Time Complexity:**
   - Traversing the list to find `x` and `y` takes **O(n)**, where `n` is the number of nodes.
   - Swapping pointers involves a constant number of operations.
   - Overall time complexity: **O(n)**.

2. **Space Complexity:**
   - No additional data structures are used.
   - Overall space complexity: **O(1)**.

---

## **Conclusion**
Swapping two nodes in a singly linked list involves updating pointers without modifying node data. By following the steps outlined above, we can efficiently swap two nodes while maintaining the integrity of the list. This operation is particularly useful when data integrity must be preserved, and only pointer manipulation is allowed.

