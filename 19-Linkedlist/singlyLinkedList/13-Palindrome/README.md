# ✨ Find Middle and Palindrome Check in LinkedList

## 🛠️ Introduction
In this document, we will explain two critical methods for LinkedList operations:
1. **Finding the middle node** of a LinkedList.
2. **Checking if a LinkedList is a palindrome**.

Each method is explained in detail, with examples, a mathematical breakdown, and step-by-step execution.

---

## 🔗 Method 1: Finding the Middle Node

### Method Code:
```java
// Method to find the middle node of the LinkedList
public Node findMid(Node head) {
    // Initialize two pointers: fast and slow
    Node fast = head;
    Node slow = head;

    // Traverse the list with fast and slow pointers
    // Fast pointer moves two steps at a time, slow pointer moves one step
    while (fast != null && fast.next != null) {
        slow = slow.next;        // Move slow pointer one step
        fast = fast.next.next;   // Move fast pointer two steps
    }

    // When the fast pointer reaches the end, the slow pointer will be at the middle
    return slow;
}
```

### 📚 Detailed Explanation

1. **Two Pointer Technique:**
   - A **slow pointer** moves one step at a time.
   - A **fast pointer** moves two steps at a time.

2. **Mathematical Intuition:**
   - The slow pointer covers half the distance of the fast pointer.
   - If the LinkedList has an odd number of nodes, the slow pointer will stop at the exact middle.
   - If the LinkedList has an even number of nodes, the slow pointer will stop at the first node of the second half.

### 🧪 Example:

#### Input:
LinkedList: `1 -> 2 -> 3 -> 4 -> 5 -> null`

#### Execution:
- Initial State:
  - `slow = 1`, `fast = 1`
- Step 1:
  - `slow = 2`, `fast = 3`
- Step 2:
  - `slow = 3`, `fast = 5`

At this point, `fast` reaches the end, and `slow` is at the middle node.

#### Output:
Middle Node: `3`

---

## 🔗 Method 2: Checking if the LinkedList is a Palindrome

### Method Code:
```java
// Method to check if the LinkedList is a palindrome or not
public boolean checkPalindrome() {
    // If the list is empty or has only one element, it's a palindrome
    if (head == null || head.next == null) {
        return true;
    }

    // Step 1: Find the middle node
    Node prev = null;
    Node curr = findMid(head); // Middle node becomes the start of the second half
    Node next;

    // Step 2: Reverse the second half of the list starting from the middle node
    while (curr != null) {
        next = curr.next;      // Save the next node
        curr.next = prev;      // Reverse the current node's next pointer
        prev = curr;           // Move prev to the current node
        curr = next;           // Move to the next node
    }

    // Step 3: Compare the first and second halves of the list
    Node left = head;  // Pointer to the start of the list (first half)
    Node right = prev; // Pointer to the start of the reversed second half

    // Traverse both halves and compare the nodes
    while (right != null) {  // Only need to check the second half (right side)
        if (left.data != right.data) {  // If data doesn't match, it's not a palindrome
            return false;
        }
        left = left.next;   // Move to the next node in the first half
        right = right.next; // Move to the next node in the second half
    }

    // If all nodes matched, the list is a palindrome
    return true;
}
```

### 📚 Detailed Explanation

#### Step 1: Find the Middle Node
We reuse the `findMid` method explained above to identify the middle of the LinkedList. This divides the list into two halves.

#### Step 2: Reverse the Second Half
- Starting from the middle node, we reverse the second half of the LinkedList.
- This ensures that the nodes from the middle to the end are in reverse order, enabling comparison with the first half.

#### Step 3: Compare Both Halves
- Use two pointers:
  - One starts at the head of the LinkedList.
  - The other starts at the head of the reversed second half.
- Compare the data in both halves node by node.

If all nodes match, the LinkedList is a palindrome.

### 🧪 Example:

#### Input:
LinkedList: `1 -> 2 -> 3 -> 2 -> 1 -> null`

#### Execution:
1. **Find Middle Node:**
   - Middle Node: `3`

2. **Reverse Second Half:**
   - Original: `3 -> 2 -> 1`
   - Reversed: `1 -> 2 -> 3`

3. **Compare Both Halves:**
   - Compare `1 -> 2 -> 3` with `1 -> 2 -> 3`.
   - All nodes match.

#### Output:
`true` (The LinkedList is a palindrome)

---

## 📊 Time Complexity Analysis

| Operation                   | Time Complexity |
|-----------------------------|-----------------|
| Finding the middle node     | O(n)            |
| Reversing the second half   | O(n/2)          |
| Comparing both halves       | O(n/2)          |
| **Overall**                 | O(n)            |

### Space Complexity
- The space complexity is **O(1)** because the operations are performed in place without using additional memory.

---

## 🌐 Real-World Applications

1. **Palindrome Detection:**
   - Used in text and data processing to check for palindromic sequences.

2. **Data Integrity:**
   - Ensures that data structures like LinkedLists maintain symmetry, aiding in error checking and validation.

3. **Algorithmic Problems:**
   - Frequently asked in coding interviews and competitive programming contests.

---

## 🏁 Summary
The `findMid` and `checkPalindrome` methods are efficient algorithms for LinkedList operations. Understanding these techniques enhances problem-solving skills and prepares you for real-world applications and coding interviews. 🚀

