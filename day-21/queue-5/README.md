

# Queue Implementation Using Stacks

## Concept:
A **Queue** operates on a FIFO principle, where elements are added at the rear and removed from the front. A **Stack**, on the other hand, operates on a LIFO principle, where elements are added and removed from the top.

To implement a queue using stacks, the solution involves two stacks (`s1` and `s2`) to mimic the behavior of a queue:
1. Elements are added to `s1` in reverse order using `s2`.
2. The front of the queue is always the top of `s1`.

---

## Code Breakdown

### Class and Field Definitions
```java
static class Queue {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();
}
```
- `Queue` class contains two static stacks (`s1` and `s2`).
- **`s1`**: Main stack that acts as the queue.
- **`s2`**: Temporary stack used for reversing the order of elements.

---

### **isEmpty()** Method
```java
public static boolean isEmpty() {
    return s1.isEmpty();
}
```
- This method checks if the queue is empty by checking whether `s1` has no elements.
- **Returns**: `true` if the queue is empty, `false` otherwise.

---

### **add(int data)** Method
```java
public static void add(int data) {
    while (!s1.isEmpty()) {
        s2.push(s1.pop());
    }
    s1.push(data);
    while (!s2.isEmpty()) {
        s1.push(s2.pop());
    }
}
```
This method adds an element to the queue. Here's how it works:
1. **Transfer Elements to `s2`**:
   - All elements in `s1` are popped and pushed into `s2` to reverse their order.
2. **Push New Element**:
   - The new element is pushed to `s1`.
3. **Restore Order to `s1`**:
   - All elements from `s2` are popped and pushed back to `s1`.

### Example Flow:
Let’s add `0`, `1`, and `2` to the queue step by step:

1. **Add `0`**:
   - `s1` = `[0]`, `s2` = `[]`.

2. **Add `1`**:
   - Transfer `s1` to `s2`: `s2` = `[0]`, `s1` = `[]`.
   - Push `1` to `s1`: `s1` = `[1]`.
   - Restore from `s2`: `s1` = `[1, 0]`.

3. **Add `2`**:
   - Transfer `s1` to `s2`: `s2` = `[0, 1]`, `s1` = `[]`.
   - Push `2` to `s1`: `s1` = `[2]`.
   - Restore from `s2`: `s1` = `[2, 1, 0]`.

---

### **remove()** Method
```java
public static int remove() {
    if (isEmpty()) {
        System.out.println("queue is empty");
        return -1;
    }
    return s1.pop();
}
```
- Removes and returns the front element of the queue.
- Since the front element of the queue is at the top of `s1`, `s1.pop()` effectively dequeues the element.

---

### **peek()** Method
```java
public static int peek() {
    if (isEmpty()) {
        System.out.println("queue is empty");
        return -1;
    }
    return s1.peek();
}
```
- Returns the front element of the queue without removing it.
- Like `remove()`, this method uses `s1.peek()` to access the top of `s1`.

---

### Main Method Execution
```java
public static void main(String[] args) {
    Queue queue = new Queue();

    queue.add(0);
    queue.add(1);
    queue.add(2);

    while (!queue.isEmpty()) {
        System.out.println(queue.peek());
        queue.remove();
    }
}
```

#### Step-by-Step Execution:
1. **Add Elements**:
   - `0`, `1`, and `2` are added to the queue in order.
   - Final state of `s1`: `[2, 1, 0]`.

2. **Process Elements**:
   - The `while` loop runs until the queue is empty:
     - **Iteration 1**: `queue.peek()` returns `0`, `queue.remove()` removes `0`.
     - **Iteration 2**: `queue.peek()` returns `1`, `queue.remove()` removes `1`.
     - **Iteration 3**: `queue.peek()` returns `2`, `queue.remove()` removes `2`.

#### Output:
```
0
1
2
```

---

## Advantages of This Approach:
1. **FIFO Behavior**: Proper queue behavior is maintained using two stacks.
2. **Reusability**: Demonstrates how stacks can be used creatively to implement other data structures.

---

## Time Complexity:
- **Add Operation**: \(O(n)\) due to transferring all elements between stacks.
- **Remove Operation**: \(O(1)\) since it directly pops from `s1`.
- **Peek Operation**: \(O(1)\) since it directly accesses the top of `s1`.

---

This implementation is useful for understanding how data structures can be adapted using existing tools like stacks.