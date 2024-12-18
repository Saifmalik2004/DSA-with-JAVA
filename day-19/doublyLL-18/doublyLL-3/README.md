# Explanation of the `addLast` Method

The **`addLast`** method is used to add a new node at the end of a **Doubly Linked List**.

---

## Code:
```java
public void addLast(int data) {
    Node newNode = new Node(data); // Step 1: Create a new node with the given data
    size++; // Step 2: Increment the size of the list
    if (head == null) { // Step 3: Check if the list is empty
        head = tail = newNode; // If empty, make the new node both head and tail
        return; // End the method here
    }
    newNode.prev = tail; // Step 4: Link the new node to the current tail
    tail.next = newNode; // Step 5: Link the current tail to the new node
    tail = newNode; // Step 6: Update the tail pointer to the new node
}
```

---

## Steps Explained:
1. **Create a New Node**:
   - A new node is created with the provided data. Its `prev` and `next` pointers are set to `null` by default.

2. **Increment the Size**:
   - The size of the linked list is incremented to reflect the addition of the new node.

3. **Check if the List is Empty**:
   - If `head == null`, it means the list is empty. In this case:
     - The new node becomes both the `head` and `tail`.

4. **Link the New Node to the Current Tail**:
   - The `prev` pointer of the new node is set to the current `tail`.

5. **Update the Current Tail's `next` Pointer**:
   - The `next` pointer of the current `tail` is set to the new node, establishing the link from the current tail to the new node.

6. **Update the Tail**:
   - The `tail` pointer is updated to the new node, making it the new last node of the list.

---

## Visual Example:

### Case 1: Adding a Node to an Empty List
**Input: `addLast(10)`**
- Create a new node with `data = 10`.
- Since the list is empty (`head == null`), the new node becomes both `head` and `tail`.

**Visualization:**
```text
null <-- [null | 10 | null] --> null
```

---

### Case 2: Adding a Node to an Existing List
**Input: `addLast(20)`**
- Create a new node with `data = 20`.
- Link the `prev` pointer of the new node to the current `tail` (`10`).
- Update the `next` pointer of the current `tail` to point to the new node.
- Update `tail` to the new node.

**Visualization Before Adding:**
```text
null <-- [null | 10 | null] --> null
```

**Visualization After Adding:**
```text
null <-- [null | 10 | *] <--> [* | 20 | null] --> null
```

**Input: `addLast(30)`**
- Add another node with `data = 30` following the same steps.

**Visualization:**
```text
null <-- [null | 10 | *] <--> [* | 20 | *] <--> [* | 30 | null] --> null
```

---

## Dry Run of the Code

### Input:
```java
DoublyLL ll = new DoublyLL();
ll.addLast(10);
ll.addLast(20);
ll.addLast(30);
```

---

### Dry Run:

1. **`addLast(10)`**:
   - Create a new node with `data = 10`.
   - Since the list is empty, set `head = tail = newNode`.

   **List**:
   ```text
   null <-- [null | 10 | null] --> null
   ```

2. **`addLast(20)`**:
   - Create a new node with `data = 20`.
   - Set `newNode.prev = tail` (i.e., `20.prev = 10`).
   - Update `tail.next = newNode` (i.e., `10.next = 20`).
   - Set `tail = newNode` (i.e., `tail = 20`).

   **List**:
   ```text
   null <-- [null | 10 | *] <--> [* | 20 | null] --> null
   ```

3. **`addLast(30)`**:
   - Create a new node with `data = 30`.
   - Set `newNode.prev = tail` (i.e., `30.prev = 20`).
   - Update `tail.next = newNode` (i.e., `20.next = 30`).
   - Set `tail = newNode` (i.e., `tail = 30`).

   **List**:
   ```text
   null <-- [null | 10 | *] <--> [* | 20 | *] <--> [* | 30 | null] --> null
   ```

---

## Key Points:

1. **When to Use `addLast`**:
   - Use this method to efficiently add elements to the end of the list.

2. **Complexity**:
   - **Time Complexity**: `O(1)` for each addition since we directly update the `tail`.
   - **Space Complexity**: `O(1)` (no additional space apart from the new node).

3. **Why Update Both Pointers**:
   - `prev` ensures backward traversal remains intact.
   - `next` ensures forward traversal remains intact.
