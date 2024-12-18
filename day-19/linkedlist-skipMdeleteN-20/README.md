# Skip M Delete N in a Linked List

This project demonstrates how to skip M nodes and delete N nodes in a **Singly Linked List**. By the end of this explanation, you will understand:

- How to traverse and manipulate nodes in a Linked List.
- Visualize how the code works step-by-step using a dry run.
- The complexity of the algorithm and how it performs in different scenarios.

Let's break this down step by step with an example, diagrams, and pseudocode.

---

## Problem Statement
We are given a Linked List and two integers `M` and `N`. The goal is:

1. **Skip M nodes** in the list.
2. **Delete the next N nodes**.
3. Repeat the process until the end of the Linked List.

---

## Example Input and Output

### Input:
- Linked List: `10 --> 9 --> 8 --> 7 --> 6 --> 5 --> 4 --> 3 --> 2 --> 1 --> null`
- `M = 2` (Nodes to skip)
- `N = 3` (Nodes to delete)

### Output:
- Updated Linked List: `10 --> 9 --> 5 --> 4 --> null`

---

## Approach
The approach involves iterating through the Linked List and performing the following steps:

1. Traverse M nodes to skip them.
2. Traverse the next N nodes to delete them.
3. Reconnect the skipped nodes to the rest of the list.
4. Repeat until the end of the list.

This involves careful pointer manipulation to ensure the integrity of the Linked List.

---

## Algorithm (Pseudocode)

1. Initialize `current` as the head of the list.
2. While `current` is not null:
   - **Skip M nodes:**
     - Traverse M nodes or until `current` is null.
   - If `current` is null, exit the loop.
   - **Delete N nodes:**
     - Start from `current.next` and traverse N nodes, setting `temp` to the node after N nodes.
   - Reconnect `current.next` to `temp`.
   - Move `current` to `temp`.
3. End.

---

## Code Walkthrough
Here is the method:

```java
public void skipMdeleteN(Node head, int m, int n) {
    Node current = head; // Start from the head of the list
    Node temp;           // Temporary reference to nodes being deleted
    int count;

    // Traverse the LinkedList
    while (current != null) {
        // Skip M nodes
        for (count = 1; count < m && current != null; count++) {
            current = current.next;
        }

        // If we've reached the end, exit the loop
        if (current == null) {
            return;
        }

        // Start deleting N nodes
        temp = current.next;
        for (count = 1; count <= n && temp != null; count++) {
            temp = temp.next;
        }

        // Connect the current node to the remaining list
        current.next = temp;

        // Move current to the next part of the list
        current = temp;
    }
}
```

---

## Visualization with Dry Run

Let’s break the process into steps with an example Linked List:

### Input:
- **Initial Linked List**: `10 --> 9 --> 8 --> 7 --> 6 --> 5 --> 4 --> 3 --> 2 --> 1 --> null`
- **M = 2**, **N = 3**

### Step-by-Step Execution:
#### 1. Start with the head:
- **Current Node**: `10`
- **Action**: Skip the first M=2 nodes (`10` and `9`).

#### After skipping:
- Current points to: `9`
- Diagram:
  ```
  [10] --> [9] --> [8] --> [7] --> [6] --> [5] --> [4] --> [3] --> [2] --> [1] --> null
          ^ Current
  ```

#### 2. Delete the next N=3 nodes:
- Nodes to delete: `8`, `7`, `6`
- Diagram:
  ```
  [10] --> [9] --> [5] --> [4] --> [3] --> [2] --> [1] --> null
          ^ Current
  ```

#### 3. Repeat the process:
- Skip M=2 nodes (`5` and `4`).
- Delete N=3 nodes (`3`, `2`, `1`).
- Diagram after final update:
  ```
  [10] --> [9] --> [5] --> [4] --> null
  ```

### Final Output:
The updated Linked List is:
```text
10 --> 9 --> 5 --> 4 --> null
```

---

## Complexity Analysis
### Time Complexity:
- **Traversing the list**:
  - Skipping M nodes: O(M) for each cycle.
  - Deleting N nodes: O(N) for each cycle.
  - Total cycles: proportional to the size of the list.
- **Overall**: O(L) where L is the length of the list.

### Space Complexity:
- **Space Used**: O(1) (No extra space is used except variables).

---

## Key Points for Beginners
1. **Pointer Movement**:
   - Use `current` to traverse the Linked List.
   - Use a temporary pointer (`temp`) to handle nodes being deleted.

2. **Edge Cases**:
   - Empty list: If `head` is null, nothing happens.
   - Small lists: If the list has fewer nodes than M+N, ensure no out-of-bound errors.

3. **Connections**:
   - After deleting N nodes, ensure the previous node points to the next remaining node.

---

## Diagram Explanation

Let’s use a diagram to show the movement of pointers for M=2, N=3:

### Initial State:
```text
Head --> 10 --> 9 --> 8 --> 7 --> 6 --> 5 --> 4 --> 3 --> 2 --> 1 --> null
         ^
     Current
```

### After Skipping M=2 Nodes:
```text
Head --> 10 --> 9 --> 8 --> 7 --> 6 --> 5 --> 4 --> 3 --> 2 --> 1 --> null
                ^
            Current
```

### After Deleting N=3 Nodes:
```text
Head --> 10 --> 9 ---------> 5 --> 4 --> 3 --> 2 --> 1 --> null
                ^
            Current
```

### After Skipping Next M=2 Nodes:
```text
Head --> 10 --> 9 ---------> 5 --> 4 ---------> null
                                  ^
                              Current
```

---

## How to Test the Code
1. Create a Linked List.
2. Use the `addLast()` method to add nodes to the list.
3. Call `skipMdeleteN()` with the desired values for M and N.
4. Use the `print()` method to verify the output.

Example:
```java
LinkedList ll = new LinkedList();
ll.addLast(10);
ll.addLast(9);
ll.addLast(8);
ll.addLast(7);
ll.addLast(6);
ll.addLast(5);
ll.addLast(4);
ll.addLast(3);
ll.addLast(2);
ll.addLast(1);

int m = 2, n = 3;
ll.skipMdeleteN(head, m, n);
ll.print(); // Output: 10 --> 9 --> 5 --> 4 --> null
```

