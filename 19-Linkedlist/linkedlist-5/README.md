Here's a detailed and engaging README for the `removeFirst` method:

---

# **Removing the First Node in a LinkedList**

In this section, we'll learn how to **remove the first node** from a LinkedList. The `removeFirst` method is responsible for handling this operation effectively, covering all possible edge cases.

---

## **Understanding the `removeFirst` Method**

The `removeFirst` method does the following:
1. **Checks if the list is empty**: If there are no nodes, it prints an appropriate message and returns `-1`.
2. **Handles the single-node case**: If there is only one node, it removes it and ensures the LinkedList becomes empty.
3. **Removes the first node in a multi-node list**: If there are multiple nodes, it adjusts the `head` pointer to the next node.

---

### **Code Implementation**

Here’s the code for the `removeFirst` method:

```java
// Method to remove the first node of the LinkedList
public int removeFirst() {
    // Step 1: Handle the empty list case
    if (head == null) {
        System.out.println("LinkedList is empty");
        return -1; // Return -1 to indicate there is nothing to remove
    }

    // Step 2: Handle the single-node case
    else if (head == tail) {
        // Save the data of the node to return it
        int val = head.data;
        // Set head and tail to null as the list will be empty after removal
        head = tail = null;
        // Decrease the size of the list
        size--;
        return val;
    }

    // Step 3: Handle the multi-node case
    // Save the data of the node to return it
    int val = head.data;
    // Move the head to the next node
    head = head.next;
    // Decrease the size of the list
    size--;
    return val;
}
```

---

## **How It Works**

1. **Case 1: The List is Empty**
   - If the `head` is `null`, it means there are no nodes in the LinkedList.
   - The method prints a message (`LinkedList is empty`) and returns `-1` to indicate that no removal is possible.

   ```java
   if (head == null) {
       System.out.println("LinkedList is empty");
       return -1;
   }
   ```

---

2. **Case 2: The List Contains Only One Node**
   - If the `head` and `tail` are the same (i.e., pointing to the same node), the list has only one element.
   - The data in the node is saved to be returned, and both `head` and `tail` are set to `null` since the list will now be empty.
   - The size of the LinkedList is decremented.

   ```java
   else if (head == tail) {
       int val = head.data;
       head = tail = null;
       size--;
       return val;
   }
   ```

---

3. **Case 3: The List Contains Multiple Nodes**
   - If there are multiple nodes, the `head` pointer is moved to the next node, effectively removing the first node from the list.
   - The data of the removed node is saved and returned.
   - The size of the LinkedList is decremented.

   ```java
   int val = head.data;
   head = head.next;
   size--;
   return val;
   ```

---

## **Example Workflow**

Let’s see an example:

### **Initial LinkedList**
```
10 --> 20 --> 30 --> null
```

- **`head` points to 10**
- **`tail` points to 30**

### **Calling `removeFirst()`**
1. The `head` (10) is removed.
2. `head` is updated to point to 20.
3. The size of the LinkedList decreases.

### **Updated LinkedList**
```
20 --> 30 --> null
```

---

## **Edge Cases**

1. **Empty List**
   - Input: `null`
   - Output: Prints "LinkedList is empty" and returns `-1`.

2. **Single Node**
   - Input: `10 --> null`
   - Output: Returns `10`, and the list becomes empty (`head = tail = null`).

3. **Multiple Nodes**
   - Input: `10 --> 20 --> 30 --> null`
   - Output: Removes `10` and updates `head` to `20`.

---

## **Try It Out**

Here’s a sample snippet to test the `removeFirst` method:

```java
public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.addLast(10); // Add 10 to the end
    ll.addLast(20); // Add 20 to the end
    ll.addLast(30); // Add 30 to the end

    System.out.println("Initial LinkedList:");
    ll.print(); // Print the list: 10 --> 20 --> 30 --> null

    System.out.println("\nRemoving the first node:");
    System.out.println("Removed: " + ll.removeFirst()); // Output: Removed: 10

    System.out.println("\nUpdated LinkedList:");
    ll.print(); // Print the list: 20 --> 30 --> null
}
```
## **Time Complexity**

- **Best Case (Non-Empty List)**: \( O(1) \), as we only update the `head` pointer.
- **Worst Case (Empty List)**: \( O(1) \), as we simply check the condition.

---

## **Advantages of `removeFirst`**

1. **Efficiency**: Performs the removal in constant time.
2. **Utility**: Common in queue operations (`dequeue`) or when implementing sliding windows.
3. **Simplicity**: Requires minimal changes to the LinkedList structure.


---

## **Conclusion**

The `removeFirst` method ensures a seamless way to remove the first node of a LinkedList while maintaining the integrity of the list in all scenarios. Happy coding! 😊

--- 