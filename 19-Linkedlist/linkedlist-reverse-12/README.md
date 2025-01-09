# ✨ Recursive Search (`RecSearch`) in LinkedList

## 🛠️ Introduction
The `RecSearch` method allows us to search for a specific value in a LinkedList using recursion. By leveraging recursion, this method simplifies the logic and eliminates the need for explicit iteration through the list. This README will explain the method, provide pseudocode, analyze its 🕒 time complexity, and discuss its 🌍 real-world applications.

---

## 📝 Step-by-Step Explanation

### 🔖 Method Signature
```java
// Public method to search for the key in the LinkedList starting from the head
public int RecSearch(int key) {
    return helper(head, key);  // Call the helper method with the head node and the key
}
```

### 1. **💡 Base Case**
The recursion stops when the current node (`head`) is `null`, which means the key is not found in the LinkedList.

```java
if (head == null) {
    return -1;  // Key not found
}
```

### 2. **🔍 Check Current Node**
If the current node's `data` matches the key, return `0`, indicating that the key is found at this position.

```java
if (head.data == key) {
    return 0;  // Key found at the current node
}
```

### 3. **🔄 Recursive Case**
Call the `helper` method recursively on the `next` node of the current node.

```java
int idx = helper(head.next, key);
```
- If the recursive call returns `-1`, the key is not found in the rest of the list.
- Otherwise, add `1` to the returned index to account for the current node.

```java
if (idx == -1) {
    return -1;  // Key not found
}
return idx + 1;  // Increment index for the current node
```

### 4. **🛠 Helper Method**
The `helper` method is the core of the recursive logic and works with the following parameters:
- `Node head`: The current node being checked.
- `int key`: The value being searched for.

```java
// Helper method to recursively search for the key in the LinkedList
public int helper(Node head, int key) {
    // Logic as explained in the steps above
}
```

---

## 📜 Pseudocode

```plaintext
Function helper(head, key):
    If head is null:
        Return -1  // Base case: Key not found

    If head.data equals key:
        Return 0  // Base case: Key found

    idx = helper(head.next, key)  // Recursive call

    If idx equals -1:
        Return -1  // Key not found in the rest of the list

    Return idx + 1  // Increment index for the current node

Function RecSearch(key):
    Return helper(head, key)  // Call helper with the head node
```

---

## 📊 Time Complexity Analysis

| ⚙️ Operation             | 🕒 Complexity |
|------------------------|--------------|
| Traverse the list     | O(n)         |
| Recursive calls       | O(n)         |
| **Overall**           | O(n)         |

### 📖 Explanation:
- Each recursive call processes one node in the LinkedList, resulting in **O(n)** time complexity for traversing the entire list.
- There is no additional space used for iteration, making it space-efficient in terms of logic but with a recursive call stack overhead.

---

## 🌐 Real-World Applications

1. **🔍 Data Lookup:**
   - Searching for a specific element in dynamic data structures like LinkedLists.

2. **📂 File Systems:**
   - Recursively traversing directory structures to find a specific file or folder.

3. **🧠 Recursive Learning:**
   - Illustrates recursion concepts, often used in educational examples for recursive problem-solving.

---

## 🧪 Example Usage

### 🔢 Input:
LinkedList: `10 -> 20 -> 30 -> 40 -> 50 -> null`  
Key: `30`

### 🔍 Execution:
1. Start from the head node (`10`).
2. Traverse to the next node recursively until the key (`30`) is found.
3. Calculate the index based on the recursive calls.

### ✅ Output:
Index: `2`

### 🎨 Visualization:
#### Recursive Calls:
```
helper(10, 30) -> helper(20, 30) -> helper(30, 30)
```
#### Backtracking Results:
```
helper(30, 30) returns 0
helper(20, 30) returns 1
helper(10, 30) returns 2
```

---

## 🏁 Summary
The `RecSearch` method demonstrates the elegance of recursion in searching for a specific value in a LinkedList. By breaking down the problem into smaller subproblems, it provides a clear and concise solution that is both easy to understand and implement. 🚀

