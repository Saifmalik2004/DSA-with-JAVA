
# **Queue Implementation in Java**

This directory contains an implementation of a **Queue** data structure using an array in Java. This explanation covers the concept of a queue, its methods, and the program's functionality.

---

## **What is a Queue?**
A **Queue** is a linear data structure that follows the **First In, First Out (FIFO)** principle.  
- **FIFO:** The element that is added first will be removed first.  
- **Analogy:** A queue is like a line at a ticket counter, where the person who arrives first is served first.

---

## **Class and Methods Overview**

### **1. Queue Class**
The `Queue` class is the main implementation of the queue. It uses an array to store elements.  

#### **Attributes:**
- **`arr[]`**: An integer array to hold the queue elements.
- **`size`**: Maximum size of the queue.
- **`rear`**: Points to the last element in the queue (initially `-1`).

---

### **2. Methods in the Queue Class**

#### **a. `isEmpty()`**  
- **Purpose:** Checks whether the queue is empty.  
- **Returns:**  
  - `true`: If the queue is empty.  
  - `false`: Otherwise.  
- **Implementation:**
  ```java
  public static boolean isEmpty(){
      return rear == -1;
  }
  ```

---

#### **b. `peek()`**  
- **Purpose:** Retrieves the front element of the queue without removing it.  
- **Returns:**  
  - Front element if the queue is not empty.  
  - `-1` with a message if the queue is empty.  
- **Implementation:**
  ```java
  public static int peek(){
      if(isEmpty()){
          System.out.println("queue is Empty");
          return -1;
      }
      return arr[0];
  }
  ```

---

#### **c. `add(int data)`**  
- **Purpose:** Adds a new element to the rear of the queue.  
- **Parameters:**  
  - `data`: The integer to be added.  
- **Behavior:**  
  - If the queue is full (`rear == size - 1`), it prints "queue is full."  
  - Otherwise, increments `rear` and inserts the element at the `rear` index.  
- **Implementation:**
  ```java
  public static void add(int data){
      if(rear == size-1){
          System.out.println("queue is full");
          return;
      }
      rear = rear + 1;
      arr[rear] = data;
  }
  ```

---

#### **d. `deque()`**  
- **Purpose:** Removes the front element from the queue.  
- **Returns:**  
  - Front element if the queue is not empty.  
  - `-1` with a message if the queue is empty.  
- **Behavior:**  
  - Shifts all elements in the array one position to the left after removing the front element.  
  - Decrements the `rear` index.  
- **Implementation:**
  ```java
  public static int deque(){
      if(isEmpty()){
          System.out.println("queue is Empty");
          return -1;
      }
      int front = arr[0];
      for (int i = 0; i < rear; i++) {
          arr[i] = arr[i+1];
      }
      rear = rear - 1;
      return front;
  }
  ```

---

### **3. Main Method**
The `main()` method demonstrates how to use the `Queue` class.  

#### **Steps in `main`:**
1. **Create a Queue:** Initialize a queue with a size of 5.  
   ```java
   Queue queue = new Queue(5);
   ```

2. **Add Elements:** Add elements `0`, `1`, and `2` to the queue.  
   ```java
   queue.add(0);
   queue.add(1);
   queue.add(2);
   ```

3. **Process Queue:**  
   - Use a `while` loop to print the front element and remove it until the queue is empty.  
   ```java
   while (!queue.isEmpty()) {
       System.out.println(queue.peek());
       queue.deque();
   }
   ```

---

## **Code Walkthrough**

### **Input**
The program adds three integers to the queue:  
`0, 1, 2`.

### **Output**
The program prints and removes each element from the queue in FIFO order:  
```
0
1
2
```

---

## **Complexity Analysis**

| Operation       | Time Complexity   | Explanation                                           |
|------------------|-------------------|-------------------------------------------------------|
| **`add()`**      | O(1)              | Adding an element to the `rear` is a constant-time operation. |
| **`deque()`**    | O(n)              | Shifting all elements after removing the front takes linear time. |
| **`peek()`**     | O(1)              | Accessing the first element is a constant-time operation. |
| **`isEmpty()`**  | O(1)              | A simple comparison takes constant time.              |

---

## **Visual Representation**

### Example Queue Operations:

**Step 1: Add Elements**  
- Initially: `[]`  
- Add `0`: `[0]`  
- Add `1`: `[0, 1]`  
- Add `2`: `[0, 1, 2]`

**Step 2: Remove Elements**  
- Remove `0`: `[1, 2]`  
- Remove `1`: `[2]`  
- Remove `2`: `[]`  

---

### **Future Enhancements**
This implementation can be further optimized by:  
1. Using a **circular queue** to avoid shifting elements on `deque()`.  
2. Implementing the queue using a **linked list** to eliminate fixed size constraints.

