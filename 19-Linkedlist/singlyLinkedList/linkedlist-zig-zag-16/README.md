# **Zig-Zag Linked List Problem**

## **Problem Statement**
You are given a singly linked list, and your task is to reorder the list in a **zig-zag fashion**. In other words, the nodes of the list should alternate between nodes from the first half and nodes from the reversed second half of the original list.

For example:
- **Input**: `1 → 2 → 3 → 4 → 5`
- **Output**: `1 → 5 → 2 → 4 → 3`

Let’s break this problem into simple steps and understand the approach step by step.

---

## **Understanding the Problem** 🤔
Imagine splitting the linked list into two halves:
1. The **first half** stays as it is.
2. The **second half** is reversed.
3. Then, we merge the two halves in a way that alternates nodes from both halves.

### **Steps in Simple Terms**:
1. Find the **middle node** of the linked list.
2. Split the list into two halves.
3. **Reverse the second half** of the linked list.
4. **Merge the two halves** such that the nodes alternate between the two halves.

---

## **Algorithm ⚙️**

### 1. **Find the Middle of the Linked List**:
Use two pointers:
- “**Slow** pointer” moves one step at a time.
- “**Fast** pointer” moves two steps at a time.
When the fast pointer reaches the end, the slow pointer will be at the middle.

### 2. **Split and Reverse the Second Half**:
- Split the list at the middle.
- Reverse the second half using three pointers (**prev**, **curr**, and **next**).

### 3. **Merge the Two Halves**:
- Alternate nodes between the first half and the reversed second half.
- Use temporary pointers to keep track of the next nodes while merging.

---

## **Step-by-Step Explanation**

### **1. Find the Middle Node**
We use the `getMid()` method to find the middle node:
```java
private Node getMid(Node head) {
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
        slow = slow.next;        // Move slow pointer one step
        fast = fast.next.next;   // Move fast pointer two steps
    }

    return slow; // The slow pointer will point to the middle
}
```

**How it works:**
- Input: `1 → 2 → 3 → 4 → 5`
- After traversing:
  - Slow: `3`
  - Fast: `null`
- Middle node is `3`. The list is split into:
  - Left part: `1 → 2 → 3`
  - Right part: `4 → 5`

---

### **2. Reverse the Second Half**
Reverse the second half of the list using three pointers (**prev**, **curr**, and **next**):
```java
Node prev = null;
Node curr = mid.next; // Start from the middle's next
Node next;

mid.next = null; // Disconnect the two halves

while (curr != null) {
    next = curr.next; // Save the next node temporarily
    curr.next = prev; // Reverse the current node's link
    prev = curr;      // Move prev to the current node
    curr = next;      // Move to the next node in the original list
}
```

**How it works:**
- Input: `4 → 5`
- After reversing:
  - `5 → 4`

---

### **3. Merge the Two Halves**
Alternate nodes from the two halves to create a zig-zag pattern:
```java
Node leftHead = head;   // Head of the first half
Node rightHead = prev;  // Head of the reversed second half
Node leftNext, rightNext;

while (leftHead != null && rightHead != null) {
    leftNext = leftHead.next;      // Save next node in left half
    rightNext = rightHead.next;    // Save next node in right half

    leftHead.next = rightHead;     // Point left node to right node
    rightHead.next = leftNext;     // Point right node to next left node

    leftHead = leftNext;           // Move to the next node in left half
    rightHead = rightNext;         // Move to the next node in right half
}
```

**How it works:**
- Merge `1 → 2 → 3` and `5 → 4`:
  - Start with `1` and `5`: `1 → 5`
  - Add `2` and `4`: `1 → 5 → 2 → 4`
  - Add `3`: `1 → 5 → 2 → 4 → 3`

---

## **Complete Code**
```java
private Node getMid(Node head) {
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}

private void zigZag() {
    Node mid = getMid(head);       // Find the middle node
    Node curr = mid.next;
    mid.next = null;               // Split the list into two halves

    Node prev = null;
    Node next;

    // Reverse the second half of the list
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    Node leftHead = head;   // Head of the first half
    Node rightHead = prev;  // Head of the reversed second half
    Node leftNext, rightNext;

    // Merge the two halves in zig-zag order
    while (leftHead != null && rightHead != null) {
        leftNext = leftHead.next;
        rightNext = rightHead.next;

        leftHead.next = rightHead;
        rightHead.next = leftNext;

        leftHead = leftNext;
        rightHead = rightNext;
    }
}
```

---

## **Time Complexity**
1. Finding the middle: **O(N)**
2. Reversing the second half: **O(N)**
3. Merging the halves: **O(N)**

**Overall Complexity**: **O(N)**

---

## **Example Execution** ✨
### Input:
```
1 → 2 → 3 → 4 → 5
```
### Step-by-Step:
1. Find the middle: `3`.
   - Split into:
     - Left: `1 → 2 → 3`
     - Right: `4 → 5`

2. Reverse the second half:
   - Reversed right part: `5 → 4`

3. Merge the two halves:
   - Start with `1` and `5`: `1 → 5`
   - Add `2` and `4`: `1 → 5 → 2 → 4`
   - Add `3`: `1 → 5 → 2 → 4 → 3`

### Output:
```
1 → 5 → 2 → 4 → 3
```

---

## **Key Takeaways**
1. **Splitting** and **reversing** are common operations in linked list problems.
2. Always handle pointers carefully to avoid breaking links.
3. The zig-zag pattern combines logic for reversing and merging.

