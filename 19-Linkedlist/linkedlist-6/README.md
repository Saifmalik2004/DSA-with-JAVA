# **Remove the Last Node from a LinkedList**

In this guide, we’ll explore how to **remove the last node** of a LinkedList using the `removeLast` method. We'll break it down step-by-step, handle edge cases, and analyze the time complexity. Let’s dive in! 🚀

---

## **What Does `removeLast` Do?**

The `removeLast` method removes the **last node** from the LinkedList while handling three key scenarios:
1. **The LinkedList is empty** 🫥
2. **The LinkedList has only one node** 🧱
3. **The LinkedList has multiple nodes** 🔗

After removing the last node, it returns its value.

---

## **Code Implementation**

Here’s the full implementation:

```java
public int removeLast() {
    // Case 1: If the LinkedList is empty
    if (size == 0) {
        System.out.println("Linked list is empty");
        return 0;
    }

    // Case 2: If there is only one node
    else if (size == 1) {
        int val = head.data;
        head = tail = null;
        size--;
        return val;
    }

    // Case 3: When there are multiple nodes
    Node temp = head;

    // Find the second-last node
    while (temp.next.next != null) {
        temp = temp.next;
    }

    // Save the last node's data
    int val = temp.next.data;

    // Remove the last node
    temp.next = null;

    // Update tail to point to the second-last node
    tail = temp;

    // Decrease the size of the list
    size--;

    return val;
}
```

---

## **Step-by-Step Explanation**

### **Case 1: Empty LinkedList**
- If the `size` is `0`, it means the LinkedList is empty.  
- The method prints `Linked list is empty` and returns `0` to indicate there is no node to remove.  

```java
if (size == 0) {
    System.out.println("Linked list is empty");
    return 0;
}
```

### **Case 2: Only One Node**
- If the `size` is `1`, it means there is only one node in the list.
- The method:
  1. Saves the value of the node.
  2. Sets both `head` and `tail` to `null`, making the list empty.
  3. Decreases the size of the LinkedList.
  4. Returns the value of the removed node.

```java
else if (size == 1) {
    int val = head.data;
    head = tail = null;
    size--;
    return val;
}
```

### **Case 3: Multiple Nodes**
- If there are more than one node, the method:
  1. **Finds the second-last node**: It traverses the list using a `temp` variable until `temp.next.next == null`.
  2. **Saves the last node’s value**: This is stored in `temp.next.data`.
  3. **Removes the last node**: By setting `temp.next` to `null`.
  4. **Updates the `tail`**: Points it to the second-last node.
  5. **Decreases the size**: Finally, reduces the size of the list.

```java
Node temp = head;
while (temp.next.next != null) {
    temp = temp.next;
}

int val = temp.next.data;
temp.next = null;
tail = temp;
size--;
return val;
```

---

## **Example Walkthrough**

### **Initial LinkedList**
```
10 --> 20 --> 30 --> null
```
- **`head` points to 10**  
- **`tail` points to 30**  

### **Calling `removeLast()`**
1. The last node (`30`) is removed.
2. `tail` is updated to point to `20`.
3. The size of the LinkedList decreases.

### **Updated LinkedList**
```
10 --> 20 --> null
```

---

## **Edge Cases**

1. **Empty List**  
   - Input: `null`  
   - Output: Prints "Linked list is empty" and returns `0`.  

2. **Single Node**  
   - Input: `10 --> null`  
   - Output: Returns `10` and makes the list empty (`head = tail = null`).  

3. **Multiple Nodes**  
   - Input: `10 --> 20 --> 30 --> null`  
   - Output: Removes `30`, updates `tail` to `20`, and decreases the size.

---

## **Complexity Analysis** 📊

1. **Time Complexity**:  
   - Traversing the list to find the second-last node takes **O(n)** in the worst case, where `n` is the number of nodes in the LinkedList.  

2. **Space Complexity**:  
   - The method uses only a single temporary variable (`temp`), so the space complexity is **O(1)**.

---

## **Testing the Method**

Try out this snippet to test `removeLast`:

```java
public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.addLast(10);
    ll.addLast(20);
    ll.addLast(30);

    System.out.println("Initial LinkedList:");
    ll.print(); // Output: 10 --> 20 --> 30 --> null

    System.out.println("\nRemoving the last node:");
    System.out.println("Removed: " + ll.removeLast()); // Output: Removed: 30

    System.out.println("\nUpdated LinkedList:");
    ll.print(); // Output: 10 --> 20 --> null
}
```
The `removeLast` method of a LinkedList might seem like a simple concept, but it has numerous **real-world applications**. Let’s explore where such a functionality could be applied:

---

## **1. Undo/Redo Functionality in Text Editors** ✏️  
- **Example**: Apps like Microsoft Word, Notepad++, or Google Docs.  
- **How It Works**:  
  - Changes made by a user are stored in a LinkedList as separate "states."
  - When a user presses "Undo," the last action (node) is removed using a `removeLast` method.
  - If the user wants to "Redo," the removed node can be added back.  

---

## **2. Browser History Management** 🌐  
- **Example**: Google Chrome, Firefox, Safari.  
- **How It Works**:  
  - A user's browsing history is stored in a LinkedList.
  - When the user clicks the "Back" button, the last visited page (last node) is removed from the list.
  - This ensures that only the relevant pages remain in the history.  

---

## **3. Media Playlist Management** 🎵  
- **Example**: Spotify, YouTube playlists.  
- **How It Works**:  
  - Songs or videos are added to a playlist in the form of a LinkedList.
  - When a user removes the last song from the playlist, the `removeLast` method is used.
  - This allows users to dynamically manage and customize their playlists.

---

## **4. Task Management in To-Do Apps** ✅  
- **Example**: Todoist, Microsoft To-Do, Google Keep.  
- **How It Works**:  
  - Tasks are added to a list (LinkedList).
  - When a task is marked as "completed," it may be removed from the end of the list using the `removeLast` method.
  - This helps in dynamically organizing tasks and reducing memory usage for old tasks.

---

## **5. Version Control Systems** 🧑‍💻  
- **Example**: Git, SVN.  
- **How It Works**:  
  - Commits in a repository are stored as nodes in a LinkedList.
  - If a user decides to undo the latest commit (`git reset`), the last commit (node) is removed from the LinkedList using `removeLast`.

---

## **6. Customer Queue Management in Ticketing Systems** 🎟️  
- **Example**: Online ticket booking or support desks.  
- **How It Works**:  
  - Customers in a queue can be represented as nodes in a LinkedList.
  - If the last customer in the queue cancels their booking, the `removeLast` method is called to remove them from the queue.

---

## **7. E-commerce Cart Management** 🛒  
- **Example**: Amazon, Flipkart, Shopify.  
- **How It Works**:  
  - Products added to a cart are stored in a LinkedList.
  - If a user decides to remove the last item they added, the `removeLast` method can handle this operation efficiently.

---

## **8. Game Development – Undo Last Move** 🎮  
- **Example**: Chess, Checkers, Tic-Tac-Toe.  
- **How It Works**:  
  - Each move in a game is stored as a node in a LinkedList.
  - When a player uses an "Undo" option, the last move is removed using `removeLast`.

---

## **9. Call Log Management in Mobile Apps** 📞  
- **Example**: Android and iOS call logs.  
- **How It Works**:  
  - Call logs are stored in chronological order using a LinkedList.
  - The `removeLast` method can be used to delete the oldest log to ensure only the most recent calls are displayed.

---

## **10. Recent File Access in Operating Systems** 💻  
- **Example**: Windows "Recent Files" section, macOS Finder.  
- **How It Works**:  
  - Recently accessed files are stored in a LinkedList.
  - When the list exceeds a certain size, the oldest file (last node) is removed using the `removeLast` method.

---

## **Why Use LinkedList for These Applications?**  

LinkedLists are particularly useful for applications like the above because:  
1. **Dynamic Size**: They grow or shrink as needed, unlike arrays that require resizing.  
2. **Efficient Deletion**: Removing the last element is straightforward when pointers are correctly managed.  
3. **Memory Efficiency**: No pre-allocation is required; nodes are created as needed.

---



## **Summary**

The `removeLast` method provides a robust way to remove the last node of a LinkedList, handling empty, single-node, and multi-node cases seamlessly. By ensuring the integrity of the list and updating pointers correctly, this method is an essential part of LinkedList operations. 🚀