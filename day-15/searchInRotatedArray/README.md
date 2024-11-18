# Search in Rotated Sorted Array (Let’s Make It Fun! 🎯)

Imagine you have a treasure map 🗺️, but someone cut it in two and rotated the pieces. Now, you need to find the treasure using clues in the rotated map. This is what searching in a **rotated sorted array** feels like! 🏴‍☠️

---

## **What’s a Rotated Sorted Array?**

Think of a normal sorted array like this:  
`[0, 1, 2, 4, 5, 6, 7]`

Now imagine someone rotated it by picking a pivot point:  
`[4, 5, 6, 7, 0, 1, 2]`

Your job? Find the **index of a target number** (the treasure 🎉), say `0`.

---

## **Plan to Find the Treasure**

We’ll use **binary search**, which divides the map into two parts, but with a twist — we’ll need to figure out which part is useful because the array is rotated. 🌀

### **How Do We Solve It?**
Follow these steps:

1. **Divide the Array:** Find the middle of the map (array).
2. **Check the Target:** Is the treasure here? If yes, celebrate. 🎊 If not, keep searching.
3. **Find the Sorted Part:** One half of the map is always sorted. Use this to decide where to dig next.
4. **Repeat Until Found:** Keep dividing until you find the treasure or confirm it’s missing.

---

### **Example Walkthrough: Find Target `0`**

Let’s say your map (array) is:  
`[4, 5, 6, 7, 0, 1, 2]`  
Your target is `0`. Let’s dig in step by step! 🛠️

---

### **Step 1: Start with the Full Map**
```java
Search(arr, 0, 0, 6);
```

- **Start index (si):** `0`
- **End index (ei):** `6`
- **Middle index (mid):** `3` → `arr[mid] = 7`

---

### **Step 2: Is the Treasure Here?**
- Is `arr[mid] == target (0)`?  
  Nope, so we look deeper. 🔍

---

### **Step 3: Find the Sorted Half**
- Left half: `[4, 5, 6, 7]`
- Right half: `[0, 1, 2]`

Is the **left half sorted**? Yes (`4 < 7`).

Now ask:  
- Is the treasure (target `0`) in `[4, 5, 6, 7]`?  
  Nope, `0` is smaller than `4`.

So, **search the right half**:
```java
Search(arr, 0, 4, 6);
```

---

### **Step 4: Dig Deeper (Right Half)**
- **Start index (si):** `4`
- **End index (ei):** `6`
- **Middle index (mid):** `5` → `arr[mid] = 1`

---

### **Step 5: Is the Treasure Here?**
- Is `arr[mid] == target (0)`?  
  Nope, so we keep going. 🪱

---

### **Step 6: Find the Sorted Half Again**
- Left half: `[0, 1]`
- Right half: `[2]`

Is the **left half sorted**? Yes (`0 < 1`).

Now ask:  
- Is the treasure (target `0`) in `[0, 1]`?  
  Yes, so search the left half:
```java
Search(arr, 0, 4, 4);
```

---

### **Step 7: Base Case**
- **Start index (si):** `4`
- **End index (ei):** `4`
- **Middle index (mid):** `4` → `arr[mid] = 0`

🎉 **Target Found at Index `4`!** 🎉

---

## **The Final Code Plan**

Here’s what the code does, step by step:

1. **Base Case:** If `si > ei`, stop. The treasure is missing.  
2. **Find the Middle:** Calculate the middle index:  
   ```java
   int mid = si + (ei - si) / 2;
   ```
3. **Check the Treasure:** If `arr[mid] == target`, return `mid`.
4. **Sorted Half Logic:**
   - **Left Half is Sorted:**  
     If `arr[si] <= target && target <= arr[mid]`, search the left half:
     ```java
     return Search(arr, target, si, mid - 1);
     ```
     Otherwise, search the right half:
     ```java
     return Search(arr, target, mid + 1, ei);
     ```
   - **Right Half is Sorted:**  
     If `arr[mid] <= target && target <= arr[ei]`, search the right half:
     ```java
     return Search(arr, target, mid + 1, ei);
     ```
     Otherwise, search the left half:
     ```java
     return Search(arr, target, si, mid - 1);
     ```

---

## **Time Complexity**

| **Case**        | **Time Complexity** | **Why?**                                       |
|------------------|---------------------|------------------------------------------------|
| **Best Case**    | `O(1)`             | Treasure found at the first `mid`.            |
| **Average Case** | `O(log n)`         | Each step halves the search space.            |
| **Worst Case**   | `O(log n)`         | Logarithmic search even in rotated arrays.    |

---

## **Treasure Map Takeaways**

- The **rotated sorted array** may look tricky, but binary search makes it easy. 🧭
- Focus on identifying the **sorted half** to decide your next move.
- It’s all about narrowing down the possibilities.

---

Keep practicing, and soon you’ll be the **pirate of rotated arrays!** 🏴‍☠️