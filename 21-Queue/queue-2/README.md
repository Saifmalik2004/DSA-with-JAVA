

# **Circular Queue Implementation in Java**

This directory contains an implementation of a **Circular Queue** data structure using an array in Java. This explanation will help you understand the concept, the purpose of a circular queue, and how each method works step by step.

---

## **What is a Circular Queue?**

A **Circular Queue** is a variation of a standard queue where the last position connects back to the first position, forming a circle.  
- **Key Advantage:** It efficiently utilizes the array space by reusing empty slots at the beginning of the array after elements are dequeued.

### **Key Features**
1. Operates on the **First In, First Out (FIFO)** principle.
2. Overcomes the limitations of a standard queue by reusing space when the `rear` reaches the end of the array.

---

## **Class and Methods Overview**

### **1. Queue Class**

#### **Attributes:**
- **`arr[]`**: Integer array for storing the queue elements.
- **`size`**: Maximum size of the queue.
- **`rear`**: Points to the last element in the queue.
- **`front`**: Points to the first element in the queue.

#### **Why Circular?**
In a circular queue:
- **Next Position Calculation:** `(currentIndex + 1) % size`
- This calculation wraps the index around the array when it reaches the end.

---

### **2. Methods in the Queue Class**

#### **a. `isEmpty()`**  
- **Purpose:** Checks if the queue is empty.  
- **Returns:**  
  - `true`: If both `front` and `rear` are `-1`.  
  - `false`: Otherwise.  
- **Implementation:**
  ```java
  public static boolean isEmpty(){
      return rear == -1 && front == -1;
  }
  ```

---

#### **b. `isFull()`**  
- **Purpose:** Checks if the queue is full.  
- **Returns:**  
  - `true`: If the next position of `rear` equals `front`.  
  - `false`: Otherwise.  
- **Implementation:**
  ```java
  public static boolean isFull(){
      return (rear+1) % size == front;
  }
  ```

---

#### **c. `peek()`**  
- **Purpose:** Retrieves the front element of the queue without removing it.  
- **Returns:**  
  - The front element if the queue is not empty.  
  - `-1` with a message if the queue is empty.  
- **Implementation:**
  ```java
  public static int peek(){
      if(isEmpty()){
          System.out.println("queue is Empty");
          return -1;
      }
      return arr[front];
  }
  ```

---

#### **d. `add(int data)`**  
- **Purpose:** Adds a new element to the rear of the queue.  
- **Parameters:**  
  - `data`: The integer to be added.  
- **Behavior:**  
  - Checks if the queue is full. If full, prints "queue is full."
  - If empty, initializes `front` to `0`.
  - Increments `rear` using the circular calculation `(rear + 1) % size`.
  - Stores the new element at the `rear` index.  
- **Implementation:**
  ```java
  public static void add(int data){
      if(isFull()){
          System.out.println("queue is full");
          return;
      }
      if(front == -1){
          front = 0;
      }
      rear = (rear + 1) % size;
      arr[rear] = data;
  }
  ```

---

#### **e. `deque()`**  
- **Purpose:** Removes the front element from the queue.  
- **Returns:**  
  - The front element if the queue is not empty.  
  - `-1` with a message if the queue is empty.  
- **Behavior:**  
  - If the queue has only one element (`front == rear`), resets both `front` and `rear` to `-1` (indicating an empty queue).
  - Otherwise, increments `front` using the circular calculation `(front + 1) % size`.  
- **Implementation:**
  ```java
  public static int deque(){
      if(isEmpty()){
          System.out.println("queue is Empty");
          return -1;
      }
      int result = arr[front];
      if(rear == front){
          rear = front = -1;
      } else {
          front = (front + 1) % size;
      }
      return result;
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

2. **Add Elements:** Add integers `0`, `1`, and `2` to the queue.  
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

## **Visual Representation**

### Example Circular Queue Operations:

1. **Add Elements:**
   - Initially: `[ , , , , ]` (Empty Queue)
   - Add `0`: `[0, , , , ]`
   - Add `1`: `[0, 1, , , ]`
   - Add `2`: `[0, 1, 2, , ]`

2. **Remove Elements:**
   - Remove `0`: `[ , 1, 2, , ]`
   - Remove `1`: `[ , , 2, , ]`
   - Remove `2`: `[ , , , , ]` (Queue is now empty)

---

## **Complexity Analysis**

| Operation       | Time Complexity   | Explanation                                           |
|------------------|-------------------|-------------------------------------------------------|
| **`add()`**      | O(1)              | Adding an element to the `rear` is a constant-time operation. |
| **`deque()`**    | O(1)              | Incrementing `front` in a circular manner takes constant time. |
| **`peek()`**     | O(1)              | Accessing the front element is a constant-time operation. |
| **`isEmpty()`**  | O(1)              | A simple comparison takes constant time.              |
| **`isFull()`**   | O(1)              | A simple modular arithmetic comparison takes constant time. |

---

## **Advantages of Circular Queue**
1. Efficiently utilizes the array space.
2. Avoids shifting elements on dequeue operation.
3. Maintains FIFO order.
