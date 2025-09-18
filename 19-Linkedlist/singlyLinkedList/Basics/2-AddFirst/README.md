# Adding a Node at the Beginning of a LinkedList

Welcome to the next step in mastering LinkedLists! In this section, we’re diving into **how to add a node at the beginning of a LinkedList** with an exciting feature: the `addFirst` method.

Imagine you're building a to-do list. You want the most important task to appear at the top immediately. This is what the `addFirst` method achieves for a LinkedList—it places new data right at the start.

---

## **Why Use `addFirst`?**
Adding a node at the beginning is an efficient operation that:
1. **Keeps the latest data easily accessible** (think of adding urgent tasks to a to-do list).
2. **Maintains constant time complexity**: Adding a node at the beginning doesn’t require traversing the list.

---

## **How Does It Work?**

The `addFirst` method does the following:
1. **Creates a New Node**: Initializes a new node with the given data.
2. **Links It to the Current Head**: Points the new node to the current `head` of the LinkedList.
3. **Updates the Head**: Sets the new node as the new `head` of the list.
4. **Handles Empty Lists**: If the list is empty, the new node becomes both the `head` and the `tail`.

---

## **Code Walkthrough**

Here’s how we add a node at the beginning:

```java
public void addFirst(int data) {
    Node newNode = new Node(data); // Step 1: Create a new node with the given data
    size++; // Increment the size of the LinkedList
    if (head == null) {
        // Step 2: If the list is empty, head and tail both point to the new node
        head = tail = newNode;
        return;
    }
    newNode.next = head; // Step 3: Link the new node to the current head
    head = newNode; // Step 4: Set the new node as the head
}
```

---

## **Step-by-Step Visualization**

### Starting Point:
**Before adding any nodes**  
```
[Empty LinkedList]
Head -> null
Tail -> null
```

### Adding the First Node:
1. Call `addFirst(10)`  
```
Head -> [10 | null]
Tail -> [10 | null]
```
- The first node is added, and both `head` and `tail` point to it.

### Adding Another Node:
2. Call `addFirst(20)`  
```
Head -> [20 | Next] -> [10 | null]
Tail -> [10 | null]
```
- The new node (`20`) becomes the `head`, and its `next` points to the previous head (`10`).

---




## **Real-World Applications**

- **Task Management**: Adding urgent tasks to the top of a to-do list.
- **Undo Operations**: Storing the most recent action at the beginning for quick undo functionality.
- **Browser History**: Storing the latest visited pages at the top.

---

## **Conclusion**

The `addFirst` method is a powerful tool for LinkedLists, enabling you to easily manage data at the beginning of the list. It’s efficient, simple, and widely used in many real-world scenarios. Now go ahead and try it out—make your LinkedList dynamic and engaging! 🚀