# 🚀 Next Permutation - Master Lexicographic Ordering from Scratch

## 📌 Problem Description

Given an array of integers representing a **permutation**, your task is to find its **next lexicographical permutation**.

If **no next permutation exists** (i.e., the array is sorted in descending order — the highest possible arrangement), return the **lowest possible permutation** (sorted in ascending order).

---

## 🤔 What is a Permutation?

A **permutation** is just a rearrangement of elements in a particular order.

For example:

```
Original: [1, 2, 3]
Permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
```

The **lexicographical order** is like the dictionary order — smaller numbers come first.

So for `[1,2,3]`, the **next permutation** is `[1,3,2]`.

---

## 🔍 Example

### ✅ Input:

```
nums = [2, 1, 5, 4, 3, 0, 0]
```

### 🎯 Output:

```
[2, 3, 0, 0, 1, 4, 5]
```

---

## 💡 Why Is This Problem Important?

This question tests:

* Understanding of permutations
* Greedy logic for optimal steps
* Ability to manipulate arrays in-place
* Commonly asked in **FAANG** interviews!

---

## 🐌 Brute Force Approach

### 🧠 Idea:

1. Generate all possible permutations.
2. Sort them.
3. Find the input permutation and return the next one.

### ⛔ Why It’s Not Good?

* ❗ Generates **N! permutations** (e.g., for 7 elements: 5040 total!)
* ❗ Extremely **slow and memory-heavy**

### ⏱ Complexity:

* **Time:** O(N!)
* **Space:** O(N!)

---

## ⚡ Optimized Approach (Best Method) — Step-by-Step Explanation

We use a **smart greedy technique** to jump directly to the next permutation.

### 🧠 Core Idea:

Imagine digits in a number (or array elements) — we want to:

1. **Find the first pair of elements** (from right to left) where the left one is **smaller** than the right.
2. **Swap it** with the **smallest number greater than it** to the right.
3. **Reverse** the remaining part (after the swapped index) to get the smallest possible next permutation.

---

### ✅ Steps with Example:

Let’s say:

```
nums = [2, 1, 5, 4, 3, 0, 0]
```

#### Step 1: Find the break point 🔍

Scan from right to left, find the **first number that is smaller than the one after it**.

```
Here: 1 < 5 ⇒ index = 1 (break point)
```

#### Step 2: Find next greater element 🔁

Find the **smallest number greater than 1** from the right side.

```
Found: 3 at index 4
```

#### Step 3: Swap them 🔄

Swap 1 and 3:

```
[2, 3, 5, 4, 1, 0, 0]
```

#### Step 4: Reverse the right part 🔃

Reverse elements to the right of swapped index:

```
[2, 3, 0, 0, 1, 4, 5]
```

**Boom! 🎉 That’s the next permutation.**

---

## 💻 Java Implementation

```java
import java.util.Arrays;

public class NextPermutation {
    public static void next(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;

        // Step 1: Find the first index from the right where nums[i] < nums[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        // Step 2: If no breakpoint, reverse whole array (it's the last permutation)
        if (breakPoint == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find next greater element to the right of breakPoint
        for (int i = n - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                swap(nums, breakPoint, i);
                break;
            }
        }

        // Step 4: Reverse the elements after breakPoint
        reverse(nums, breakPoint + 1, n - 1);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        next(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

---

## 📈 Complexity Analysis

| Metric    | Value           |
| --------- | --------------- |
| **Time**  | O(N)            |
| **Space** | O(1) (In-place) |

---

## 📚 Real-Life Applications

* 🔄 **Schedule generation**: Find next possible task arrangement.
* 🧠 **AI/ML Search Space**: Lexicographic arrangements in decision trees.
* 📖 **Dictionary/Autocomplete**: Finding next word in sorted order.

---

## 🎯 Key Takeaways

✅ Understand what a **permutation** is.

✅ Brute force is not practical due to factorial growth.

✅ A **smart greedy approach** helps us avoid generating all permutations.

✅ Lexicographic order problems test both **logic** and **array manipulation** skills.

---

### 🧠 Practice Tip:

Try dry-running this on paper with small arrays like `[1, 3, 2]` or `[3, 2, 1]` to **really grasp** the algorithm.

Happy Coding! 🚀
