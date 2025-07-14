# 🚀 Leaders in an Array – Fully Explained

## 🔍 What is a Leader?

In an array, an element is called a **leader** if it is **greater than all the elements to its right**.

### 🎯 Example:

```java
Input:  [10, 22, 12, 3, 0, 6]
Output: [22, 6]
```

Why?

* `22` is greater than `12, 3, 0, 6`
* `6` has no elements after it, so it’s always a leader

---

## 🧠 Real-Life Analogy

Imagine you're standing on a hilltop and looking towards the **right**. You can only "see" people who are **shorter than you**. So, **you’re a leader** if **no one to your right blocks your view**.

---

## 🚦 Problem Statement

> Given an array of integers, print all the leaders in the array.

---

## 🚧 Approach 1: Brute Force (Naive)

### 🔍 Idea:

* For each element, check **every element to its right**
* If it's **greater than all of them**, it's a leader

### 📝 Step-by-Step Pseudocode:

```plaintext
for i from 0 to n-1:
    isLeader = true
    for j from i+1 to n-1:
        if arr[j] > arr[i]:
            isLeader = false
            break
    if isLeader:
        print arr[i]
```

### 💻 Java Code:

```java
public class BruteForceLeaders {
    public static void findLeaders(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        findLeaders(arr);
    }
}
```

### ⏱️ Time Complexity:

* **O(n²)** (Nested loop)

---

## ⚡ Approach 2: Optimized (Right to Left Traversal)

### 🔍 Idea:

* Always start from the **last element** (it’s always a leader)
* Keep track of the **maximum element** from the right
* If current element is **greater than max so far**, it’s a leader

### 📝 Step-by-Step Pseudocode:

```plaintext
max = -∞
for i from n-1 to 0:
    if arr[i] > max:
        print arr[i]
        max = arr[i]
```

### 💻 Java Code:

```java
public class OptimizedLeaders {
    public static void findLeaders(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> leaders = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                leaders.add(arr[i]);
                max = arr[i];
            }
        }

        // Since we traversed from right to left, reverse the list
        Collections.reverse(leaders);

        for (int val : leaders) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        findLeaders(arr);
    }
}
```

### ⏱️ Time Complexity:

* **O(n)** (Single loop)
* **O(1)** extra space (or O(n) if storing result list)

---

## 🧪 Dry Run Example (Input: `[10, 22, 12, 3, 0, 6]`)

### For Brute Force:

* `10` → not leader (22 is bigger)
* `22` → ✅ leader
* `12` → not leader
* `3` → not leader
* `0` → not leader
* `6` → ✅ leader

Output: `22 6`

### For Optimized:

* Start from `6` → ✅ leader
* `0` → ❌
* `3` → ❌
* `12` → ❌
* `22` → ✅
* `10` → ❌

Output (reversed): `22 6`

---

## 🔍 Use-Cases & Applications

* 🔁 **Stock Market**: Find peak prices
* ⛳ **Gaming**: Find high scores that weren’t beaten after
* 📊 **Analytics**: Detect key trend points in a dataset

---

## 📊 Time & Space Complexity Comparison

| Approach    | Time Complexity | Space Complexity |
| ----------- | --------------- | ---------------- |
| Brute Force | O(n²)           | O(1)             |
| Optimized   | O(n)            | O(1) or O(n)     |

---

## 🧠 Key Takeaways

✅ A **leader** is greater than all elements to its right
✅ **Right-to-left traversal** makes this problem efficient
✅ Learn how to choose between brute force and optimal approach

---

> 💡 Tip: Practice reversing logic in-place and working from end of array — it helps in many array-based interview problems!

---
