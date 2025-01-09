

# 📚 Understanding Priority Queue in Java  

## 🧩 What is a Priority Queue?  
A **Priority Queue** is a special type of queue where elements are **processed based on their priority** rather than the order in which they were added.  

### 🔑 Key Features:  
- **Priority-Based Processing:** Elements with the highest or lowest priority are processed first (depending on how the queue is configured).  
- **Internally Uses a Heap:** The Priority Queue in Java is implemented using a **Min-Heap** by default (i.e., the smallest element is at the top).  

---

## 🤔 How is it Different from a Regular Queue?  

| **Feature**              | **Queue**                        | **Priority Queue**                 |
|--------------------------|----------------------------------|-------------------------------------|
| **Order of Processing**  | FIFO (First In, First Out)       | Based on priority (not insertion order). |
| **Implementation**       | LinkedList/Array                | Binary Heap (Min-Heap by default). |
| **Use Case**             | Simple tasks like task scheduling | Use cases requiring prioritized processing, e.g., Dijkstra's algorithm, Huffman coding, etc. |

---

## ✨ Important Methods of Priority Queue  

### 1️⃣ **add()**  
Adds an element to the queue. If the queue has a capacity limit, it throws an exception if it's full.  

#### Code Example:  
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(10);
pq.add(5);
pq.add(20);
System.out.println(pq); // Output: [5, 10, 20] (sorted in ascending order)
```

---

### 2️⃣ **offer()**  
Similar to `add()`, but it returns `false` instead of throwing an exception if the queue is full.  

#### Code Example:  
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(15);
pq.offer(25);
pq.offer(5);
System.out.println(pq); // Output: [5, 25, 15]
```

---

### 3️⃣ **peek()**  
Retrieves, but does not remove, the head (smallest element) of the queue. Returns `null` if the queue is empty.  

#### Code Example:  
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(8);
pq.add(3);
System.out.println(pq.peek()); // Output: 3 (smallest element)
```

---

### 4️⃣ **poll()**  
Retrieves and removes the head (smallest element) of the queue. Returns `null` if the queue is empty.  

#### Code Example:  
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(12);
pq.add(7);
System.out.println(pq.poll()); // Output: 7 (removes the smallest element)
System.out.println(pq);        // Output: [12]
```

---

### 5️⃣ **remove()**  
Removes a specific element from the queue. Throws an exception if the element is not found.  

#### Code Example:  
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(18);
pq.add(9);
pq.remove(18);
System.out.println(pq); // Output: [9]
```

---

### 6️⃣ **isEmpty()**  
Checks if the priority queue is empty.  

#### Code Example:  
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
System.out.println(pq.isEmpty()); // Output: true
```

---

### 7️⃣ **size()**  
Returns the number of elements in the priority queue.  

#### Code Example:  
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(14);
pq.add(6);
System.out.println(pq.size()); // Output: 2
```

---

## 🌟 Complete Example: Using Priority Queue  

Here’s a complete example that demonstrates how to use a Priority Queue in a real-world scenario.  

### Problem: **Find the Top 3 Smallest Numbers from an Array**  

#### Code:  
```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        int[] numbers = {15, 3, 20, 7, 10, 5};

        // Create a Priority Queue (Min-Heap by default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all numbers to the priority queue
        for (int num : numbers) {
            pq.add(num);
        }

        // Retrieve the 3 smallest numbers
        System.out.println("Top 3 Smallest Numbers:");
        for (int i = 0; i < 3; i++) {
            System.out.println(pq.poll()); // Poll retrieves and removes the smallest element
        }
    }
}
```

#### Output:  
```
Top 3 Smallest Numbers:
3
5
7
```

---

## 🧠 Key Takeaways:  
1️⃣ **Priority Queue ensures efficient retrieval of the smallest (or highest priority) element.**  
2️⃣ **Commonly used in greedy algorithms, graph problems, and scheduling tasks.**  
3️⃣ **Always remember:** By default, Java's Priority Queue is a **Min-Heap**. If you need a Max-Heap, you can use a custom comparator.  

---

🚀 **Start experimenting with Priority Queues today! They are an amazing tool for solving complex problems efficiently! 💪🔥**  