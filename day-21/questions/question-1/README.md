

# 🌀 Reverse First K Elements of a Queue

Reversing the first `k` elements of a queue while maintaining the order of the rest might seem tricky, but with the right approach, it's a breeze! Let’s break it down step by step. 🛠️

---

## 💡 Problem Statement

You’re given:
- A **queue** of integers.
- An integer `k`.

**Goal:** Reverse the first `k` elements of the queue while leaving the rest of the elements in the same order. 📜

For example:
- **Input Queue:** [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]  
- **k:** 5  
- **Output Queue:** [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]  

---

## 🧠 Approach

We’ll use a **deque** (double-ended queue) to help reverse the first `k` elements. Here's the strategy:

1. **Remove the first `k` elements** from the original queue and push them into the deque (front-to-back).
2. **Add these elements back** to the deque in reverse order (back-to-front).
3. **Preserve the remaining elements** in their original order.
4. **Reconstruct the queue** from the deque.

---

## 🔢 Algorithm

1. Initialize a deque to store the first `k` elements temporarily.
2. Loop through the first `k` elements:
   - Remove each element from the queue.
   - Push it to the **front** of the deque.
3. Loop through the remaining elements in the queue:
   - Add them to the **back** of the deque.
4. Clear the original queue and refill it with the elements from the deque.

---

## 📝 Pseudocode

```text
Function reverseKElements(queue, k):
    Initialize deque
    For i = 1 to k:
        deque.addFront(queue.remove())
    While queue is not empty:
        deque.addBack(queue.remove())
    While deque is not empty:
        queue.add(deque.removeFront())
```

---

## 📄 Code Example

Here’s the Java implementation of the algorithm:

```java
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeSol {

    public static void reverseKElements(Queue<Integer> original, int k) {
        Deque<Integer> deque = new LinkedList<>();
        
        // Step 1: Add first k elements in reverse order to the deque
        for (int i = 0; i < k; i++) {
            deque.addFirst(original.remove());
        }

        // Step 2: Add remaining elements to the deque (preserve order)
        while (!original.isEmpty()) {
            deque.addLast(original.remove());
        }

        // Step 3: Refill the original queue from the deque
        while (!deque.isEmpty()) {
            original.add(deque.removeFirst());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        // Reverse the first 5 elements
        reverseKElements(queue, 5);

        // Print the modified queue
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}
```

---

## ⚙️ Code Explanation

1. **Initialize Deque:**  
   - `Deque<Integer> deque = new LinkedList<>();`  
   - Used to temporarily store elements in reverse order.

2. **Reverse First `k` Elements:**  
   - `deque.addFirst(original.remove());`  
   - Adds the first `k` elements from the queue to the front of the deque, reversing their order.

3. **Preserve Remaining Elements:**  
   - `deque.addLast(original.remove());`  
   - Adds the remaining elements to the back of the deque, keeping them in order.

4. **Rebuild Queue:**  
   - `original.add(deque.removeFirst());`  
   - Reconstructs the queue using elements from the deque.

---

## 🔍 Complexity Analysis

1. **Time Complexity:**  
   - Removing and adding elements to the deque and queue involves **O(1)** operations for each element.  
   - **Total Time Complexity:** **O(n)**, where `n` is the total number of elements in the queue.

2. **Space Complexity:**  
   - The deque temporarily stores up to `n` elements, making the **Space Complexity:** **O(n)**.

---

## ✅ Conclusion

- This method efficiently reverses the first `k` elements of a queue using a deque.  
- It's **simple**, **efficient**, and leverages the versatility of Java's `Deque` class.  

---

## 🌟 Output Example

For the input:
```plaintext
Queue: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
k = 5
```

The output will be:
```plaintext
[50, 40, 30, 20, 10, 60, 70, 80, 90, 100]
```

---

Happy coding! 🎉