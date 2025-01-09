# Explanation of `addFirst` and `printDLL` Methods

Let’s break down the **`addFirst`** and **`printDLL`** methods step by step for better understanding:

---

## 1. **`addFirst` Method**
This method adds a new node at the beginning of the **Doubly Linked List**.

### Code:
```java
public void addFirst(int data) {
    Node newNode = new Node(data); // Step 1: Create a new node with the given data
    size++; // Step 2: Increment the size of the list
    if (head == null) { // Step 3: Check if the list is empty
        head = tail = newNode; // If empty, make the new node both head and tail
        return; // End the method here
    }
    newNode.next = head; // Step 4: Link the new node to the current head
    head.prev = newNode; // Step 5: Link the current head's previous pointer to the new node
    head = newNode; // Step 6: Update the head pointer to the new node
}
```

---

### Steps Explained:
1. **Create a New Node**:
   - A new node is created with the given data, and its `prev` and `next` pointers are set to `null` by default.

2. **Check if the List is Empty**:
   - If `head` is `null`, it means the list is empty. In this case:
     - The new node becomes both the `head` and `tail` of the list.

3. **Update Pointers**:
   - If the list already has nodes:
     - The `next` pointer of the new node points to the current `head`.
     - The `prev` pointer of the current `head` points to the new node.
     - Finally, the `head` is updated to the new node.

---

### Visual Example:
#### Adding `10` to an empty list:
```text
Before: 🟢null
After:  [null | 10 | null] → 🔴null
```

#### Adding `20` to the list:
```text
Before: [null | 10 | null]
After:  [null | 20 | *] ↔ [* | 10 | null] → 🔴null
```

---

## 2. **`printDLL` Method**
This method prints the elements of the Doubly Linked List from the `head` to `tail`.

### Code:
```java
public void printDLL() {
    if (head == null) { // Step 1: Check if the list is empty
        System.err.println("Linked list is empty"); // Print an error if the list is empty
        return; // End the method here
    }

    Node temp = head; // Step 2: Start from the head node
    while (temp != null) { // Step 3: Traverse the list until the end
        System.out.print(temp.data + "<--->"); // Print the current node's data
        temp = temp.next; // Move to the next node
    }
    System.out.println("null"); // Print null to indicate the end of the list
}
```

---

### Steps Explained:
1. **Check if the List is Empty**:
   - If `head` is `null`, the list is empty, and it prints a message: `"Linked list is empty"`.

2. **Traverse the List**:
   - Start with the `head` node.
   - Use a temporary variable `temp` to traverse through the list until the end (`temp != null`).

3. **Print Nodes**:
   - Print the `data` of each node followed by the arrow `<--->` to indicate the links between nodes.
   - At the end, print `null` to signify the end of the list.

---

### Visual Example:
#### For the list: `[20] ↔ [10] → null`
Output:
```text
20<--->10<--->null
```

---

### How These Methods Work Together:
1. Use **`addFirst`** to insert nodes at the start of the list.
2. Use **`printDLL`** to display the contents of the list.

---

## Dry Run of the Code:
### Input:
```java
DoublyLL ll = new DoublyLL();
ll.addFirst(10);
ll.addFirst(20);
ll.printDLL();
```

### Dry Run:
1. **`addFirst(10)`**:
   - A new node with data `10` is created.
   - Since the list is empty, `head` and `tail` both point to this new node.

   ```text
   List: [null | 10 | null]
   ```

2. **`addFirst(20)`**:
   - A new node with data `20` is created.
   - The new node's `next` points to the current head (`10`).
   - The `prev` of the node `10` points to the new node.
   - Update `head` to point to the new node.

   ```text
   List: [null | 20 | *] ↔ [* | 10 | null]
   ```

3. **`printDLL()`**:
   - Start with `head` (`20`) and print each node's data:
   ```text
   20<--->10<--->null
   ```

