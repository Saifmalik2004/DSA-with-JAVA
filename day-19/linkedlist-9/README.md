# ✨ contain Method in LinkedList

## 🛠️ Introduction
The `contain` method is a utility in a linked list that allows you to 🔍 search for the presence of a specific value (key) and return its 📍 index. If the value does not exist in the list, the method returns `❌ -1`. This feature is essential for quickly determining the location of a specific value in the linked list.

This README will explain the method step-by-step, analyze its 🕒 time complexity, and discuss its 🌍 real-world applications.

---

## 📝 Step-by-Step Explanation

### 🔖 Method Signature
```java
public int contain(int key)
```

### 1. **🧮 Initialize Variables**
Start by defining a pointer (`prev`) to traverse the list and an integer variable (`i`) to track the 🔢 index of the current node.

```java
Node prev = head;  // Start at the head of the list
int i = 0;         // Index of the current node
```
- `prev` is initialized to the `head` node to begin traversal.
- `i` keeps track of the position of each node during traversal.

### 2. **🚶 Traverse the LinkedList**
Iterate through the linked list using a `while` loop until the end of the list is reached (`prev != null`).

```java
while (prev != null) {
    if (prev.data == key) {
        return i;  // Return the index if the key is found
    }
    prev = prev.next;  // Move to the next node
    i++;               // Increment the index
}
```
- Compare the `data` of the current node (`prev.data`) with the target value (`key`).
- If a match is found, return the index `i`. ✅
- Otherwise, move `prev` to the next node and increment `i`. 🔄

### 3. **❌ Return -1 if Key is Not Found**
If the loop completes without finding the key, return `-1` to indicate the key is not present in the list.

```java
return -1;
```

---

## 📊 Time Complexity Analysis

| ⚙️ Operation          | 🕒 Complexity |
|--------------------|------------|
| Initialization     | O(1)       |
| Traversal          | O(n)       |
| Key Comparison     | O(1)       |
| **Overall**        | O(n)       |

### 📖 Explanation:
- The method traverses the linked list node by node, resulting in a worst-case complexity of **O(n)**, where `n` is the number of nodes.
- Key comparisons and updates to variables are constant-time operations, **O(1)**. ⏱️

---

## 🌐 Real-World Applications

1. **📦 Inventory Systems:**
   - Used to locate specific items in a list of inventory records.

2. **🎵 Search in Playlists:**
   - In a music app, this method can find the position of a specific song in a linked list representing a playlist.

3. **📝 Dynamic Forms:**
   - In form builders, it helps locate specific input fields dynamically stored as nodes in a linked list.

4. **🎮 Gaming:**
   - In linked list implementations for turn-based games, this method can check the position of a specific player or entity.

---

## 🧪 Example Usage

### 🔢 Input:
Linked list: `5 -> 10 -> 15 -> 20 -> null`  
Search key: `15`

### 🔍 Execution:
1. Start traversal at the head node (value `5`).
2. Compare each node's data with the key (`15`).
3. Return the index (`2`) when a match is found.

### ✅ Output:
The key `15` is found at index: `2`.

### 🛠️ Edge Case:
If the key is not present, return `❌ -1`.

### 🎨 Visualization:
#### Before Search:
```
head -> 5 -> 10 -> 15 -> 20 -> null
         ^
        prev (at index 0)
```
#### During Search:
```
head -> 5 -> 10 -> 15 -> 20 -> null
                  ^
                 prev (at index 2, key found)
```

---

## 🏁 Summary
The `contain` method is a simple yet powerful utility for 🔎 searching values in a linked list. Its linear time complexity makes it efficient for small to medium-sized lists. This method is widely applicable in real-world scenarios where dynamic data structures are needed for fast and efficient searching. 💡

