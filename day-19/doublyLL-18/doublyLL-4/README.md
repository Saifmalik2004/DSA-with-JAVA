# Removing the First Node from a Doubly Linked List

In this explanation, we will walk through the process of removing the first node from a **Doubly Linked List (DLL)**. The method `removeFirst` accomplishes this by updating the relevant pointers and reducing the list size. We'll explain the approach, visualize it through a diagram, analyze its complexity, and provide additional insights for clarity.

---

## **Approach**
The process involves the following steps:

1. **Check if the list is empty:**
   - If the `head` is `null`, it means the list is empty. In this case, we simply print a message and return a sentinel value (e.g., `-1`).

2. **Update the size of the list:**
   - Decrement the size of the list to reflect the removal of a node.

3. **Store the value of the head node:**
   - Save the data in the current head node (as it is about to be removed).

4. **Handle the case where the list contains only one node:**
   - If `head.next` is `null`, this means there is only one node in the list. Update both `head` and `tail` to `null`.

5. **Update the head pointer:**
   - Move the `head` pointer to the next node.
   - Set the `prev` pointer of the new head to `null` (to remove the reference to the previous head node).

6. **Return the value of the removed node:**
   - Finally, return the value of the removed node to the caller.

---

## **Code**
Here is the implementation of the `removeFirst` method:

```java
public int removeFirst() {
    if (head == null) {
        System.out.println("Nothing to delete in the list");
        return -1; // Return a sentinel value
    }

    size--;
    int val = head.data;
    if (head.next == null) {
        head = tail = null;
        return val;
    }

    head = head.next;
    head.prev = null;
    return val;
}
```

---

## **Visualization**
Let’s take an example to visualize the removal of the first node.

### Initial State:
Suppose the doubly linked list contains the following nodes:

```
HEAD -> [10] <-> [20] <-> [30] <- TAIL
```
- `head` points to the first node with data `10`.
- `tail` points to the last node with data `30`.

### Step-by-Step Execution:
1. **Check if the list is empty:**
   - `head != null`, so we proceed.

2. **Update the size:**
   - Reduce the size of the list by 1.

3. **Store the value of the head node:**
   - Save `head.data`, which is `10`.

4. **Check if there is only one node:**
   - `head.next != null`, so there is more than one node.

5. **Update the head pointer:**
   - Move `head` to `head.next` (node with data `20`).
   - Set `head.prev = null`.

6. **Final State:**

```
HEAD -> [20] <-> [30] <- TAIL
```
- The node with data `10` is removed.

### Diagram:

#### Before Removal:
```
NULL <- [10] <-> [20] <-> [30] -> NULL
^head            ^tail
```

#### After Removal:
```
NULL <- [20] <-> [30] -> NULL
^head     ^tail
```

---

## **Complexity Analysis**

1. **Time Complexity:**
   - Removing the first node involves updating pointers and a constant number of operations. Hence, the time complexity is:
     **O(1)**.

2. **Space Complexity:**
   - No additional data structures are used; we only modify existing pointers. Hence, the space complexity is:
     **O(1)**.

---

## **Additional Notes**

- **Edge Cases:**
  - If the list is empty (`head == null`), the method handles it gracefully by printing a message and returning `-1`.
  - If there is only one node, both `head` and `tail` are updated to `null`.

- **Why set `head.prev = null`?**
  - To ensure the new head does not retain any reference to the removed node, which helps prevent memory leaks.

- **Advantages of a DLL over a Singly Linked List in this operation:**
  - In a DLL, removing the first node is straightforward as the `prev` pointer of the new head can be directly set to `null`. In a singly linked list, additional traversal or checks might be needed for some operations.

---

## **Conclusion**
The `removeFirst` method efficiently removes the first node of a doubly linked list with a time complexity of **O(1)**. By updating the relevant pointers and handling edge cases, it ensures the integrity of the list structure. Visualizing pointer updates and understanding edge cases will help solidify your understanding of this operation.

