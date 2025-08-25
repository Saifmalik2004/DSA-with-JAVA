# ✨ deleteNthFromLast Method in LinkedList

## 🛠️ Introduction
The `deleteNthFromLast` method in a LinkedList is designed to remove the `n`th node from the end of the list. This operation is particularly useful in scenarios where elements need to be dynamically removed from the tail end without directly iterating from the head multiple times.

This README will break down the method step-by-step, provide pseudocode, analyze its 🕒 time complexity, and discuss its 🌍 real-world applications.

---

## 📝 Step-by-Step Explanation

### 🔖 Method Signature
```java
public void deleteNthFromLast(int n)
```

### 1. **🧮 Calculate the Size of the LinkedList**
Start by traversing the entire LinkedList to calculate its size (`sz`).

```java
int sz = 0;  // Variable to store the size of the list
Node temp = head;

while (temp != null) {
    temp = temp.next;  // Move to the next node
    sz++;
}
```
- `sz` represents the total number of nodes in the list.
- The traversal stops when `temp` reaches `null` (end of the list).

### 2. **📍 Handle Edge Case for Head Node**
If the node to be deleted is the head node (`n == sz`), update the head to point to the next node.

```java
if (n == sz) {
    head = head.next;  // Move the head to the next node
    return;
}
```
- This ensures the first node is removed properly when `n` equals the total size.

### 3. **🚶 Traverse to (sz - n)th Node**
Locate the node just before the node to be removed.

```java
int i = 1;
Node prev = head;

while (i < sz - n) {
    prev = prev.next;  // Move to the next node
    i++;
}
```
- `sz - n` identifies the position of the node just before the target node.
- Traverse from the head until you reach this position.

### 4. **✂️ Remove the nth Node from the End**
Update the `next` pointer of the `(sz - n)th` node to bypass the node to be deleted.

```java
prev.next = prev.next.next;  // Skip the target node
size--;                      // Decrement the size of the list
```
- The link to the target node is removed, effectively deleting it from the list.
- Decrement the `size` property of the list.

---

## 📜 Pseudocode

```plaintext
Function deleteNthFromLast(n):
    Initialize size as 0
    Set temp to head
    While temp is not null:
        Increment size
        Move temp to temp.next

    If n equals size:
        Update head to head.next
        Return

    Initialize prev as head
    For i from 1 to size - n - 1:
        Move prev to prev.next

    Update prev.next to prev.next.next
    Decrement size
```

---

## 📊 Time Complexity Analysis

| ⚙️ Operation            | 🕒 Complexity |
|-----------------------|--------------|
| Calculate size       | O(n)         |
| Traverse to (sz - n) | O(n)         |
| Update pointers      | O(1)         |
| **Overall**          | O(n)         |

### 📖 Explanation:
- Calculating the size of the LinkedList requires a full traversal, which is **O(n)**.
- Finding the `(sz - n)`th node is another traversal, also **O(n)**.
- The actual removal of the node is a constant-time operation, **O(1)**.

---

## 🌐 Real-World Applications

1. **🛒 Dynamic Inventory Management:**
   - Removing an item from the end of a linked list representing stock updates.

2. **📄 Document Editing:**
   - Deleting the last `n`th revision or history entry in a version control system.

3. **🎮 Gaming Systems:**
   - Dynamically removing the `n`th last action in a game log or player action history.

4. **📝 Task Management Applications:**
   - Removing the `n`th last task from a list of pending tasks.

---

## 🧪 Example Usage

### 🔢 Input:
Linked list: `1 -> 2 -> 3 -> 4 -> 5 -> null`  
`n = 2`

### 🔍 Execution:
1. Calculate size: `sz = 5`
2. Target node position: `sz - n = 3`
3. Traverse to the 3rd node (`3`).
4. Update the link: `3 -> 5` (skip `4`).

### ✅ Output:
Linked list after deletion: `1 -> 2 -> 3 -> 5 -> null`

### 🎨 Visualization:
#### Before Deletion:
```
head -> 1 -> 2 -> 3 -> 4 -> 5 -> null
                    ^
                  Target node
```
#### After Deletion:
```
head -> 1 -> 2 -> 3 -> 5 -> null
```

---

## 🏁 Summary
The `deleteNthFromLast` method is a versatile and efficient utility for removing elements from the end of a linked list. By leveraging a two-pass traversal, it ensures precise and reliable deletion while maintaining simplicity in its implementation. This method has widespread use in real-world scenarios requiring dynamic updates to data structures. 🚀

