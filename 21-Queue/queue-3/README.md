# Queue Implementation Using Linked List

This README explains the implementation of a **Queue** using a **Linked List** in Java. The program defines a queue using nodes to store data, enabling dynamic memory allocation. It supports basic queue operations such as `add`, `peek`, and `deque`.

---

## **What is a Queue?**
A queue is a linear data structure that follows the **FIFO (First In, First Out)** principle. The first element added to the queue is the first one to be removed.

### **Key Features of a Queue:**
1. **Enqueue (`add`)**: Add an element to the end of the queue.
2. **Dequeue (`deque`)**: Remove an element from the front of the queue.
3. **Peek (`peek`)**: Get the value of the front element without removing it.
4. **IsEmpty (`isEmpty`)**: Check if the queue is empty.

---

## **Advantages of Linked List Implementation**
Unlike array-based queues, a linked list-based queue:
1. Dynamically allocates memory.
2. Eliminates the need to define a fixed size.
3. Grows or shrinks as elements are added or removed.

---

## **Code Walkthrough**

### 1. **Node Class**
The `Node` class is a fundamental building block of the linked list. Each node contains:
- **`data`**: The value stored in the node.
- **`next`**: A reference to the next node in the queue.

```java
public static class Node {
    int data;          // Stores the data
    Node next;         // Points to the next node

    // Constructor to initialize a node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

---

### 2. **Queue Class**
The `Queue` class contains the logic for queue operations. It uses two pointers:
- **`head`**: Points to the front of the queue.
- **`tail`**: Points to the rear of the queue.

---

### 3. **Queue Operations**

#### **a. `isEmpty`**
Checks if the queue is empty. A queue is empty if both `head` and `tail` are `null`.

```java
public static boolean isEmpty() {
    return head == null && tail == null;
}
```

---

#### **b. `peek`**
Returns the value at the front of the queue without removing it. If the queue is empty, it prints a message and returns `-1`.

```java
public static int peek() {
    if (isEmpty()) {
        System.out.println("Queue is Empty");
        return -1;
    }
    return head.data;  // Return the data at the front
}
```

---

#### **c. `add` (Enqueue)**
Adds a new element to the end of the queue.
1. Create a new `Node` with the given data.
2. If the queue is empty, set both `head` and `tail` to the new node.
3. Otherwise, add the new node at the end and update the `tail`.

```java
public static void add(int data) {
    Node newNode = new Node(data); // Create a new node
    if (head == null) {           // If queue is empty
        head = tail = newNode;    // Head and tail point to the new node
        return;
    }
    tail.next = newNode;          // Link the new node to the end
    tail = newNode;               // Update the tail pointer
}
```

---

#### **d. `deque` (Dequeue)**
Removes an element from the front of the queue.
1. If the queue is empty, print a message and return `-1`.
2. Otherwise, store the data of the `head` node.
3. Move `head` to the next node.
4. If the queue becomes empty after the removal, set `head` and `tail` to `null`.

```java
public static int deque() {
    if (isEmpty()) {              // If queue is empty
        System.out.println("Queue is Empty");
        return -1;
    }
    int result = head.data;       // Store the front element's data
    if (head.next == null) {      // If there's only one element
        head = tail = null;       // Reset both head and tail
    } else {
        head = head.next;         // Move head to the next node
    }
    return result;                // Return the dequeued value
}
```

---

### 4. **Main Method**
The main method demonstrates the usage of the queue:
1. Create a queue.
2. Add elements to the queue.
3. Dequeue elements and print them until the queue becomes empty.

```java
public static void main(String[] args) {
    Queue queue = new Queue(); // Create a new queue

    queue.add(0);  // Add elements to the queue
    queue.add(1);
    queue.add(2);

    // Print and remove elements from the queue
    while (!queue.isEmpty()) {
        System.out.println(queue.peek()); // Print the front element
        queue.deque();                   // Remove the front element
    }
}
```

---

## **Visualization**

### **Queue Example**
Let’s enqueue 3 elements: **0, 1, 2**.

1. **Initially (Empty Queue):**
   - `head = null`, `tail = null`.

2. **After `add(0)`**:
   - `head -> [0] -> null`
   - `tail -> [0] -> null`

3. **After `add(1)`**:
   - `head -> [0] -> [1] -> null`
   - `tail -> [1] -> null`

4. **After `add(2)`**:
   - `head -> [0] -> [1] -> [2] -> null`
   - `tail -> [2] -> null`

5. **Dequeue Steps:**
   - **1st `deque`:** Remove `0`. `head -> [1] -> [2] -> null`.
   - **2nd `deque`:** Remove `1`. `head -> [2] -> null`.
   - **3rd `deque`:** Remove `2`. Queue becomes empty.

---

## **Algorithm (Pseudocode)**

### **Enqueue (`add`)**
1. Create a new node.
2. If the queue is empty:
   - Set both `head` and `tail` to the new node.
3. Otherwise:
   - Link the new node to the `tail.next`.
   - Update the `tail` pointer.

### **Dequeue (`deque`)**
1. If the queue is empty:
   - Print "Queue is empty".
   - Return `-1`.
2. Otherwise:
   - Store `head.data` in a variable.
   - Move `head` to `head.next`.
   - If the queue becomes empty:
     - Set both `head` and `tail` to `null`.

---

## **Complexity Analysis**

1. **Enqueue (`add`)**:
   - **Time Complexity:** \(O(1)\) (Constant time to add a new element).
   - **Space Complexity:** \(O(1)\) (Linked list nodes use memory dynamically).

2. **Dequeue (`deque`)**:
   - **Time Complexity:** \(O(1)\) (Constant time to remove an element).
   - **Space Complexity:** \(O(1)\).

3. **Peek (`peek`)**:
   - **Time Complexity:** \(O(1)\).
   - **Space Complexity:** \(O(1)\).

4. **IsEmpty (`isEmpty`)**:
   - **Time Complexity:** \(O(1)\).
   - **Space Complexity:** \(O(1)\).

---

## **Conclusion**
This implementation demonstrates a dynamic and memory-efficient way to implement a queue using a linked list. It avoids the limitations of fixed-size arrays and is well-suited for applications requiring dynamic resizing.