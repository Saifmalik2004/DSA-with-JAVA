# Adding a Node at the End of a LinkedList

Welcome to the next chapter in mastering LinkedLists! This time, we’re focusing on **how to add a node at the end of a LinkedList** using the `addLast` method. While the `addFirst` method lets us add data at the beginning, `addLast` ensures that new data is appended to the tail, or the end, of the LinkedList.

---

## **Why Use `addLast`?**

Adding a node at the end is a common operation in LinkedLists because:
- It allows you to build your list sequentially.
- It's perfect for cases where **order matters**, like a queue or a log where new events are appended to the end.

---

## **How Does It Work?**

The `addLast` method performs these steps:
1. **Creates a New Node**: Initializes a node with the given data.
2. **Handles an Empty List**: If the list is empty (`head == null`), the new node becomes both the `head` and `tail`.
3. **Links to the Tail**: If the list already has nodes, the `next` pointer of the current `tail` is updated to point to the new node.
4. **Updates the Tail**: The new node becomes the `tail` of the LinkedList.

---

## **Code Walkthrough**

Here’s the implementation of the `addLast` method:

```java
// Method to add a node at the end of the LinkedList
public void addLast(int data) {
    Node newNode = new Node(data); // Step 1: Create a new node with the given data
    size++; // Increment the size of the LinkedList
    if (head == null) {
        // Step 2: If the list is empty, the new node is both the head and tail
        head = tail = newNode;
        return;
    }
    tail.next = newNode; // Step 3: Link the current tail to the new node
    tail = newNode; // Step 4: Update the tail to the new node
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
1. Call `addLast(10)`  
```
Head -> [10 | null]
Tail -> [10 | null]
```
- The first node is added, and both `head` and `tail` point to it.

### Adding Another Node:
2. Call `addLast(20)`  
```
Head -> [10 | Next] -> [20 | null]
Tail -> [20 | null]
```
- The new node (`20`) is appended at the end, and the `tail` now points to it.

### Adding More Nodes:
3. Call `addLast(30)` and `addLast(40)` sequentially:  
```
Head -> [10 | Next] -> [20 | Next] -> [30 | Next] -> [40 | null]
Tail -> [40 | null]
```
- Each new node is added to the end, and the `tail` is updated accordingly.

---



## **Real-World Applications**

1. **Queues**: Adding elements to the end of the queue for a First-In-First-Out (FIFO) structure.
2. **Activity Logs**: Appending new events or activities at the end of a log.
3. **Event Scheduling**: Adding events to the end of a timeline.




---

## **Key Differences: `addFirst` vs `addLast`**

| **Method**     | **Description**                        | **Example Usage**       |
|-----------------|----------------------------------------|-------------------------|
| `addFirst`      | Adds a node to the beginning of the list | To prioritize urgent tasks |
| `addLast`       | Adds a node to the end of the list      | To maintain sequential order |

---

## **Conclusion**

The `addLast` method is essential when you need to build or extend your LinkedList sequentially. It’s simple, efficient, and forms the backbone of many real-world applications like queues and logs. Give it a try, and watch your LinkedList grow dynamically from both ends! 🚀