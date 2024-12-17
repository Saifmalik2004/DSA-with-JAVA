# Detect and Remove a Cycle in a Linked List

## Problem Statement
In a singly linked list, a cycle exists when a node's `next` pointer points to a previous node in the list. This creates a loop, which can cause issues such as infinite traversal or memory leaks. The goal is to:

1. Detect whether a cycle exists in the linked list.
2. If a cycle is present, remove it.

---

## Code Overview
The implementation is divided into two main functions:

1. **`detectCycle()`**: Checks if there is a cycle in the linked list using the **Floyd's Cycle Detection Algorithm** (also known as the **Tortoise and Hare Algorithm**).
2. **`removeCycle()`**: Removes the cycle if one is detected.

---

## Approach

### 1. Detect Cycle (Floyd’s Cycle Detection Algorithm)
- Use two pointers:
  - **Slow pointer (`slow`)**: Moves one step at a time.
  - **Fast pointer (`fast`)**: Moves two steps at a time.
- If a cycle exists, `slow` and `fast` will eventually meet inside the cycle.
- If no cycle exists, `fast` will reach the end of the list.

### 2. Remove Cycle
- After detecting a cycle, reset the `slow` pointer to the head of the linked list.
- Move both `slow` and `fast` pointers one step at a time until they meet again. This meeting point is the start of the cycle.
- To remove the cycle, set the `next` pointer of the node just before the start of the cycle to `null`.

---

## Step-by-Step Walkthrough

### Detect Cycle
1. Initialize `slow` and `fast` pointers to the head of the linked list.
2. Traverse the linked list:
   - Move `slow` by one step.
   - Move `fast` by two steps.
3. If `slow` and `fast` meet, a cycle is detected, and the function returns `true`.
4. If `fast` or `fast.next` becomes `null`, the linked list has no cycle, and the function returns `false`.

### Remove Cycle
1. After detecting the cycle, set `slow` back to the head of the list.
2. Traverse the list with both `slow` and `fast` pointers moving one step at a time.
3. Track the previous node of `fast` using a variable `prev`.
4. When `slow` and `fast` meet again, the meeting point is the start of the cycle.
5. Set `prev.next = null` to break the cycle.

### Code Implementation
```java
public boolean detectCycle() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            return true;
        }
    }

    return false;
}

public void removeCycle() {
    Node slow = head;
    Node fast = head;
    boolean hasCycle = false;

    // Step 1: Detect cycle
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            hasCycle = true;
            break;
        }
    }

    if (!hasCycle) {
        return;
    }

    // Step 2: Find the start of the cycle
    slow = head;
    Node prev = null;
    while (slow != fast) {
        prev = fast;
        slow = slow.next;
        fast = fast.next;
    }

    // Step 3: Remove the cycle
    prev.next = null;
}

public static void main(String[] args) {
    LinkedList ll = new LinkedList();

    head = new Node(1);
    Node temp = new Node(2);
    head.next = temp;
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = temp; // Creates a cycle

    if (ll.detectCycle()) {
        System.out.println("The LinkedList contains a cycle.");
    } else {
        System.out.println("The LinkedList does not contain a cycle.");
    }

    ll.removeCycle();

    if (ll.detectCycle()) {
        System.out.println("The LinkedList contains a cycle.");
    } else {
        System.out.println("The LinkedList does not contain a cycle.");
    }

    ll.print();
}
```

---

## Complexity Analysis

### Time Complexity
1. **Cycle Detection (`detectCycle`)**:
   - Each pointer traverses the list at most once.
   - Time complexity: **O(n)**, where `n` is the number of nodes in the linked list.

2. **Cycle Removal (`removeCycle`)**:
   - The `slow` and `fast` pointers traverse the cycle at most once.
   - Time complexity: **O(n)**.

**Overall Time Complexity**: **O(n)**.

### Space Complexity
- The algorithm uses constant extra space (only pointers).
- Space complexity: **O(1)**.

---

## Real-World Applications
1. **Networking**: In computer networks, cycles can lead to infinite loops in routing algorithms. Detecting and breaking cycles ensures efficient routing.
2. **Memory Management**: Linked structures like free lists in memory allocators should not have cycles to avoid memory leaks or incorrect allocations.
3. **Dependency Resolution**: Dependency graphs can be represented as linked structures. Detecting cycles helps avoid circular dependencies.
4. **Social Networks**: Detecting cycles can identify relationships or connections that form loops.

---

## Example Execution
### Input:
A linked list with the following structure:
```
1 -> 2 -> 3 -> 4
     ^         |
     |---------|
```

### Output:
Before removing the cycle:
```
The LinkedList contains a cycle.
```
After removing the cycle:
```
The LinkedList does not contain a cycle.
1 -> 2 -> 3 -> 4
```

---

This implementation provides an efficient solution to detect and remove cycles in linked lists, ensuring the list is restored to a linear structure.

