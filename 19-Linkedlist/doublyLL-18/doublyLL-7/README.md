
## Doubly Linked List - `reverse` Method

### Overview

The `reverse` method is used to **reverse the order of nodes** in a doubly linked list. Imagine you're flipping through a stack of cards, and each card has two sides — one side points to the next card, and the other points to the previous card. Reversing the list is like flipping every card to point in the opposite direction, so the last card becomes the first one.

In a doubly linked list, each node contains pointers to both its **next** and **previous** nodes, which allows us to traverse the list in both directions. This property makes the reversal of the list slightly different from reversing a singly linked list.

### Approach

1. **Initialization**:
   - We initialize three pointers:
     - **`prev`**: This pointer will eventually point to the previous node, but it starts as `null` because there's no node before the head in the original list.
     - **`curr`**: This pointer will traverse through the list, starting from the `head`.
     - **`next`**: This temporary pointer will store the next node as we reverse the `next` pointer of each node.

2. **Reversal Process**:
   - We traverse the list from the beginning to the end, and for each node:
     - **Store the next node** in the `next` pointer so we don't lose track of it.
     - **Reverse the links**:
       - The `next` pointer of the current node (`curr.next`) will now point to the previous node (`prev`).
       - The `prev` pointer of the current node (`curr.prev`) will point to the next node (`next`), reversing the direction of traversal.
     - Move both `prev` and `curr` pointers forward to the next node in the list.

3. **Update Head**:
   - Once the loop finishes, the `prev` pointer will point to the new head of the list, which was originally the tail. We update the `head` pointer to point to `prev`.

### Code

```java
// Method to reverse the LinkedList
public void reverse() {
    // Initialize three pointers:
    // - prev: points to the previous node (starts as null)
    // - curr: points to the current node (starts as the head)
    // - next: stores the next node temporarily while reversing links
    Node prev = null;
    Node curr = head;  // Start with the head
    Node next;
    
    // Traverse the LinkedList, reversing the direction of the links
    while (curr != null) {
        next = curr.next;   // Save the next node temporarily
        curr.next = prev;   // Reverse the current node's link to the previous node
        curr.prev = next;   // Reverse the current node's previous link to the next node
        prev = curr;        // Move prev to the current node
        curr = next;        // Move to the next node in the original list
    }
    
    // Once the loop completes, prev will be pointing to the new head of the reversed list
    head = prev;  // Update head to the new first node (previous tail)
}
```

---

## Dry Run Example

Let's say we have the following doubly linked list:

```
head -> [10] <-> [20] <-> [30] <-> [40] <-> [50] <- tail
```

### Initial Setup:
- **prev = null**
- **curr = head** (points to 10)
- **next = null**

### Iteration 1:
- **`next`** = [20]
- Reverse links:
  - `curr.next` (10) points to `prev` (null).
  - `curr.prev` (10) points to `next` (20).
- Move:
  - **prev = 10**
  - **curr = 20**
  
### Iteration 2:
- **`next`** = [30]
- Reverse links:
  - `curr.next` (20) points to `prev` (10).
  - `curr.prev` (20) points to `next` (30).
- Move:
  - **prev = 20**
  - **curr = 30**

### Iteration 3:
- **`next`** = [40]
- Reverse links:
  - `curr.next` (30) points to `prev` (20).
  - `curr.prev` (30) points to `next` (40).
- Move:
  - **prev = 30**
  - **curr = 40**

### Iteration 4:
- **`next`** = [50]
- Reverse links:
  - `curr.next` (40) points to `prev` (30).
  - `curr.prev` (40) points to `next` (50).
- Move:
  - **prev = 40**
  - **curr = 50**

### Iteration 5:
- **`next` = null**
- Reverse links:
  - `curr.next` (50) points to `prev` (40).
  - `curr.prev` (50) points to `next` (null).
- Move:
  - **prev = 50**
  - **curr = null**

At this point, the `curr` pointer is null, and `prev` is pointing to the new head (`50`). So, we update `head = prev`.

### Final List:

```
head -> [50] <-> [40] <-> [30] <-> [20] <-> [10] <- tail
```

---

## Time Complexity

- **O(n)**: The method performs a single traversal of the list, visiting each node exactly once to reverse its links. Therefore, the time complexity is linear with respect to the number of nodes in the list.

## Key Points

- **Reversal Mechanism**: The method uses three pointers (`prev`, `curr`, and `next`) to reverse the links in the list.
- **Efficiency**: The algorithm is efficient as it only requires one pass through the list (O(n) time complexity).
- **Doubly Linked List**: The ability to manipulate both `next` and `prev` pointers allows for easy reversal without additional data structures or extra space.
- **Edge Cases**: This method handles edge cases like an empty list (`head == null`), as it simply does nothing in such cases.

---

## Conclusion

Reversing a doubly linked list is a straightforward operation, but it can be tricky to implement without careful pointer management. The `reverse` method elegantly handles this by using three pointers to traverse and reverse the links between nodes. With just a single pass through the list, this method ensures the list is reversed efficiently, making it a great way to manipulate doubly linked lists in any project.

