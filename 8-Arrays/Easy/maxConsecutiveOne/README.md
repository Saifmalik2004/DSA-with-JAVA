
# 🚀 **Maximum Consecutive 1's in an Array** 🌟

## 1️⃣ **Problem Description**: ✨

Imagine you're trying to track a player's win streak in a game where each win is represented by a **1** and each loss by a **0**. The goal is to determine the **longest streak of consecutive wins** (the longest sequence of **1's**) in the array.

### Example:

Let's say the input array is:
```plaintext
[0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1]
```

The longest sequence of **1's** is **4**, and that’s the output you want. You need to figure out how to track these consecutive wins in the array efficiently. Let’s dive into how we can solve this!

---

## 2️⃣ **Approach**: 💡

To solve this problem, we can go through the array **once** while keeping track of the current streak of **1's**. 

We need:
- A **count** that tracks the current streak of consecutive **1's**.
- A **max** that records the highest streak encountered.

### The Strategy:
- As we go through the array, each time we encounter a **1**, we increment the streak count.
- If we encounter a **0**, we reset the streak count to zero because the streak has been broken.
- At every step, we compare the streak with the current maximum and update it if the current streak is larger.

This method is efficient because we traverse the array just **once**, ensuring the solution runs in linear time, **O(n)**.

---

## 3️⃣ **Pseudo Code**: 📝

Here’s a simplified version of the algorithm:

```
Initialize count to 0 and max to a very small number (like -1)
For each element in the array:
    If the element is 1:
        Increment count
        If count > max:
            Update max
    Else:
        Reset count to 0
Return max
```

---

## 4️⃣ **Step-by-Step Explanation of the Code**: 🛠️

Let’s break down the code step by step to understand how it works:

### Code:

```java
public class Optimize {
    // Method to find the maximum consecutive ones in the array
    public static void maxOnes(int arr[]) {
        int count = 0; // To count consecutive ones
        int max = Integer.MIN_VALUE; // To store the maximum count of consecutive ones

        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // If the current element is 1
            if (arr[i] == 1) {
                count++; // Increment the count of consecutive ones
                max = Math.max(count, max); // Update max if current count is greater
            } else {
                count = 0; // Reset the count if the current element is not 1
            }
        }

        // Print the maximum number of consecutive ones found
        System.out.println(max);
    }

    public static void main(String[] args) {
        // Define an array containing 0s and 1s
        int arr[] = {0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1};

        // Call the method to find the maximum consecutive ones in the array
        maxOnes(arr);
    }
}
```

### Explanation:
- **`count`**: Tracks how many consecutive **1's** we’ve encountered.
- **`max`**: Stores the largest streak of consecutive **1's** found during the iteration.
- **The loop**:
  - If the current element is **1**, we increment `count` and compare it to `max`.
  - If it’s a **0**, we reset `count` to **0** because the streak is broken.
- Finally, `max` holds the longest streak, which is printed.

---

## 5️⃣ **Example Walkthrough**: 📊

Let’s walk through an example input to see how this works.

### Input:
```plaintext
arr = [0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1]
```

1. **Initialization**:
   - `count = 0`
   - `max = Integer.MIN_VALUE`

2. **Iteration**:
   - `arr[0] = 0`: No streak → Reset `count` to 0.
   - `arr[1] = 1`: Streak continues → `count = 1`, `max = 1`.
   - `arr[2] = 0`: Streak breaks → Reset `count` to 0.
   - `arr[3] = 1`: Streak continues → `count = 1`, `max = 1`.
   - `arr[4] = 1`: Streak continues → `count = 2`, `max = 2`.
   - `arr[5] = 1`: Streak continues → `count = 3`, `max = 3`.
   - `arr[6] = 0`: Streak breaks → Reset `count` to 0.
   - `arr[7] = 1`: Streak continues → `count = 1`, `max = 3`.
   - `arr[8] = 1`: Streak continues → `count = 2`, `max = 3`.
   - `arr[9] = 1`: Streak continues → `count = 3`, `max = 3`.
   - `arr[10] = 1`: Streak continues → `count = 4`, `max = 4`.

3. **Final Result**:
   - The longest streak of **1's** is **4**.

### Output:
```plaintext
4
```

---

## 6️⃣ **How This Will Work**: 🖥️💬

This code works by looping through the array from left to right. It keeps track of the current streak of consecutive **1's** and updates the maximum streak whenever a longer streak is found. If a **0** is encountered, it resets the streak count, since the sequence of **1's** has ended.

The key idea here is that we only traverse the array **once** — making this solution highly efficient. This simple approach ensures the code runs quickly even for larger arrays.

---

## 7️⃣ **Full Code with Comments**: 🖥️💬

```java
public class Optimize {
    // Method to find the maximum consecutive ones in the array
    public static void maxOnes(int arr[]) {
        int count = 0; // To count consecutive ones
        int max = Integer.MIN_VALUE; // To store the maximum count of consecutive ones

        // Loop through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // If the current element is 1
            if (arr[i] == 1) {
                count++; // Increment the count of consecutive ones
                max = Math.max(count, max); // Update max if current count is greater
            } else {
                count = 0; // Reset the count if the current element is not 1
            }
        }

        // Print the maximum number of consecutive ones found
        System.out.println(max);
    }

    public static void main(String[] args) {
        // Define an array containing 0s and 1s
        int arr[] = {0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1};

        // Call the method to find the maximum consecutive ones in the array
        maxOnes(arr);
    }
}
```

---

## 8️⃣ **Complexity Analysis**: 🔍

- **Time Complexity**: **O(n)** where **n** is the length of the input array. We are only going through the array once.
- **Space Complexity**: **O(1)** because we are using a constant amount of space (only a few variables to track the streak and max count).

This is an optimal solution with both time and space efficiency! ⏱️📦

---

## 9️⃣ **Key Takeaways**: 🚀

- **Efficient Problem Solving**: You learned how to solve the problem of finding the longest streak of **1's** in an array with just one pass through the array!
- **Time and Space Efficiency**: We reduced the time complexity to **O(n)** and kept the space complexity **O(1)**, making it an efficient solution.
- **Continuous Learning**: By breaking down complex problems into smaller steps, you can tackle more challenging problems ahead. Keep up the great work — you’re one step closer to mastering coding! 🌟

---

Thanks for following along! Keep practicing and continue improving your skills! 😄🎉