


# **🔀 Interleaving Two Halves of a Queue**

## **📜 The Problem**
Given a queue with an **even number of elements**, rearrange its elements such that the first element comes from the first half of the queue, the second element comes from the second half, and so on.

---

## **❓ Problem Statement**
You are given a queue containing an even number of integers. Your task is to rearrange the elements such that elements from the first half of the queue alternate with elements from the second half.

### **Example**

**Input:**  
`1 2 3 4 5 6 7 8 9 10`

**Output:**  
`1 6 2 7 3 8 4 9 5 10`

---

## **🛠️ Approach**

We use a **queue-based approach** to interleave the two halves of the original queue.

### **Step-by-Step Explanation**

1. **Split the Queue in Two Halves**  
   - Calculate the size of the queue.
   - Remove the first half of the elements from the original queue and store them in a new queue called `firstHalf`.

2. **Interleave the Elements**  
   - While the `firstHalf` queue is not empty:
     - Add one element from `firstHalf` back to the original queue.
     - Add the next element (which belongs to the second half) from the original queue.

3. **Result**  
   - The original queue is now interleaved.

---

## **🧩 Algorithm (Pseudocode)**

```plaintext
1. Function interLeave(Queue original):
    a. Calculate the size of the queue: size = original.size()
    b. Initialize an empty queue: firstHalf
    c. For i = 0 to size / 2:
         - Remove elements from the original queue and add them to firstHalf.

2. While firstHalf is not empty:
    a. Add the front element of firstHalf back to original.
    b. Add the front element of original (from the second half) to the original queue.

3. End of function.
```

---

## **📄 Code Explanation (Walkthrough)**

### Code:
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueSol {
    public static void interLeave(Queue<Integer> original) {
        int size = original.size(); // Step 1: Calculate size of the queue
        Queue<Integer> firstHalf = new LinkedList<>(); // Step 2: Create an empty queue to hold the first half
        
        // Step 3: Move the first half of the original queue into firstHalf
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(original.remove());
        }

        // Step 4: Interleave the elements of firstHalf and second half of original queue
        while (!firstHalf.isEmpty()) {
            original.add(firstHalf.remove()); // Add from firstHalf
            original.add(original.remove()); // Add from second half of original
        }
    }

    public static void main(String[] args) {
        Queue<Integer> original = new LinkedList<>();
        // Add elements to the queue
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        original.add(5);
        original.add(6);
        original.add(7);
        original.add(8);
        original.add(9);
        original.add(10);

        interLeave(original); // Call the interleaving function
        
        // Print the interleaved queue
        while (!original.isEmpty()) {
            System.out.print(original.remove() + " ");
        }
    }
}
```

---

### **Walkthrough**

1. **Input the Queue**  
   The queue is initialized with integers from `1` to `10`.

2. **Split the Queue**  
   The first 5 elements (`1 2 3 4 5`) are moved to the `firstHalf` queue, leaving the second half (`6 7 8 9 10`) in the original queue.

3. **Interleave the Elements**  
   - Take one element from `firstHalf` (e.g., `1`) and add it back to the original queue.
   - Take one element from the original queue's second half (e.g., `6`) and add it back.
   - Repeat this process until `firstHalf` is empty.

4. **Output the Interleaved Queue**  
   The queue now contains: `1 6 2 7 3 8 4 9 5 10`.

---

## **⏳ Time Complexity**

1. **Splitting the Queue:**  
   - Removing `size/2` elements takes **O(size/2)**.  
2. **Interleaving the Queue:**  
   - Adding and removing elements from the queue takes **O(size)**.  

**Overall Time Complexity:**  
**O(size)** (Linear Time)

---

## **💾 Space Complexity**

- An additional queue `firstHalf` is used, which stores half the elements.  
**Space Complexity:** **O(size/2)** (Linear Space)

---

## **✨ Key Features**
- **Simple and Clean Logic:** Only two queues are used.  
- **Efficient:** Operates in linear time.  
- **Scalable:** Works for any queue size as long as it is even.

---

🚀 **Now you're ready to interleave any queue!**