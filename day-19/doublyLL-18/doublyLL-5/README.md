

# `removeLast` Method - Explanation

## Approach

The `removeLast` method removes the last element (node) from a doubly linked list. This operation handles various scenarios, including an empty list, a list with a single element, and a list with multiple elements.

### Steps:
1. **Check if the list is empty**: If `tail` is `null`, it means the list is empty. In this case, a message is printed, and a sentinel value `-1` is returned, indicating no element was deleted.

2. **Decrease the size**: After removing an element, the size of the list is decremented to reflect the change.

3. **Handle the case when there’s only one node**: If `tail.prev` is `null`, it means the list has only one element. Both the `head` and `tail` must be set to `null`, effectively emptying the list.

4. **Update pointers for multi-node lists**: If there are multiple elements in the list, we move the `tail` pointer to the previous node and set its `next` pointer to `null`, ensuring the last node is removed.

5. **Return the removed value**: Finally, the value of the removed node is returned.

---

## Code

```java
public int removeLast() {
    if (tail == null) {
        System.out.println("Nothing to delete in the list");
        return -1; // Return a sentinel value
    }

    size--;
    int val = tail.data;
    if (tail.prev == null) {
        head = tail = null;
        return val;
    }

    tail = tail.prev;
    tail.next = null;
    return val;
}
```

---

## Step-by-Step Explanation

1. **Check if the list is empty (`tail == null`)**:
   - If the list is empty, the `tail` is `null`, indicating there’s nothing to remove. The method prints a message saying "Nothing to delete in the list" and returns `-1` to signify no removal occurred.

2. **Decrease the size**:
   - The `size` of the list is decremented by 1 to reflect the removal of the last node.

3. **Handle the case of a single node (`tail.prev == null`)**:
   - If the `tail.prev` is `null`, it indicates that there is only one node in the list. Both `head` and `tail` are set to `null`, making the list empty.

4. **Update the `tail` for multi-node lists**:
   - If there are more than one node in the list, we update the `tail` pointer to point to the previous node (`tail = tail.prev`).
   - The `next` pointer of the new `tail` is set to `null` to ensure the integrity of the doubly linked list (the new last node’s `next` should point to `null`).

5. **Return the value of the deleted node**:
   - The value of the node that was removed is stored in `val`, and this value is returned.

---

## Dry Run Example

### Initial List:
- `head -> [10] <-> [20] <-> [30] <- tail`

### Remove Last Node (`removeLast()`):

- **Step 1**: The `tail` points to `[30]`.
- **Step 2**: The size is decremented (`size = 2`).
- **Step 3**: The value of the node to be deleted is `30` (stored in `val`).
- **Step 4**: The `tail` pointer is updated to point to `[20]`, and its `next` pointer is set to `null`.
- **Step 5**: Return the value `30` (the removed node).

### Final List:
- `head -> [10] <-> [20] <- tail`

---

## Time Complexity

- **Best Case (O(1))**: Removing the last node is a constant-time operation because it only involves updating the `tail` pointer and possibly the `next` pointer of the new `tail`.
- **Worst Case (O(1))**: The time complexity is O(1) in all cases, as no iteration over the list is needed.

---

## Key Points

- **Edge Case Handling**: The method correctly handles cases where the list is empty or contains only one node.
- **Pointer Updates**: The method maintains the integrity of the doubly linked list by updating the `tail` pointer and setting the new `tail`'s `next` to `null`.
- **Efficiency**: The method runs in constant time, O(1), regardless of the list's size, ensuring efficient removal of the last element.