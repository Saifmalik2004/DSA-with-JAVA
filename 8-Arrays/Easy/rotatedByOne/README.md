# 🔄 **Array Rotation Problem - A Step-by-Step Guide!** 🎉

Welcome to the **Array Rotation** problem! This guide will take you through the solution with a touch of fun, using emojis to make learning more engaging. So let's dive in! 🚀

---

## 1️⃣ **Problem Description** ✨

Imagine you're at a party with a group of friends, and you all form a circle. Everyone is passing a ball around the circle to the next person, and you're in charge of shifting the ball one person to the left. The only difference here is, you're doing this virtually on an array of numbers!

### The task:
You have an array of integers and need to **rotate the array to the left by one position**. The first element of the array should move to the last position, and all other elements should shift one position to the left.

For example:

Given the array:  
`[1, 2, 3, 4, 5]`

After rotating by one position to the left, the result should be:  
`[2, 3, 4, 5, 1]`

---

## 2️⃣ **Step-by-Step Explanation of the Code** 🛠️

Let's break down the code to see how we solve the array rotation problem:

### Code:

```java
public class Solution {

    // Function to rotate the array by 1 position
    public static void roated(int arr[]) {
        // Get the length of the array
        int n = arr.length;

        // Store the first element to be moved to the end
        int temp = arr[0];

        // Start from the second element (index 1)
        int i = 1;
        
        // Loop through the array starting from index 1
        while (i < n) {
            // Shift each element one position to the left
            arr[i - 1] = arr[i];
            i++; // Move to the next element
        }

        // Place the first element (stored in 'temp') at the last position
        arr[n - 1] = temp;
    }

    // Main method to test the rotation
    public static void main(String[] args) {
        // Define an array to rotate
        int arr[] = {1, 2, 3, 4, 5};
        
        // Call the rotate function
        roated(arr);

        // Print the rotated array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // Output: 2 3 4 5 1
        }
    }
}
```

### Breakdown:
1. **Store the first element**: We save the first element of the array (`arr[0]`) in a temporary variable `temp`.
2. **Shift all elements to the left**: Using a loop, we shift each element from index 1 onwards one position to the left.
3. **Move the first element to the end**: After the loop, we place the saved first element (`temp`) at the last position (`arr[n-1]`).

---

## 3️⃣ **Example Walkthrough** 🌟

Let’s see how this works with an example. We'll rotate the array `[1, 2, 3, 4, 5]` to the left by one position.

**Step-by-Step Rotation:**

- **Initial Array**: `[1, 2, 3, 4, 5]`
- Store the first element in `temp`:  
  `temp = 1`
  
- **Step 1**: Shift element at index 1 to index 0:  
  `[2, 2, 3, 4, 5]`

- **Step 2**: Shift element at index 2 to index 1:  
  `[2, 3, 3, 4, 5]`

- **Step 3**: Shift element at index 3 to index 2:  
  `[2, 3, 4, 4, 5]`

- **Step 4**: Shift element at index 4 to index 3:  
  `[2, 3, 4, 5, 5]`

- **Step 5**: Place the `temp` value at the last position:  
  `[2, 3, 4, 5, 1]`

- **Final Array**: `[2, 3, 4, 5, 1]`

---

## 4️⃣ **Approach** 💡

The approach used is a simple and efficient one. It works in **O(n)** time complexity because we traverse the entire array once to shift the elements and then place the first element at the end. This ensures that the solution is both fast and straightforward!

---

## 5️⃣ **Pseudo Code** 📝

Here’s a simplified version of the algorithm:

```
1. Store the first element of the array in a temporary variable.
2. Loop through the array from index 1 to the end:
   a. Shift each element one position to the left.
3. Place the stored first element at the last position in the array.
4. Done!
```

---

## 6️⃣ **Full Code with Comments** 🖥️💬

```java
public class Solution {

    // Function to rotate the array by 1 position
    public static void roated(int arr[]) {
        int n = arr.length; // Get the length of the array
        int temp = arr[0];  // Store the first element to be moved to the end

        // Shift each element one position to the left
        int i = 1;
        while (i < n) {
            arr[i - 1] = arr[i]; // Move the current element to the previous position
            i++;  // Move to the next element
        }

        // Place the first element at the last position
        arr[n - 1] = temp;
    }

    // Main method to test the rotation
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5}; // Define the input array
        roated(arr); // Rotate the array

        // Print the rotated array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // Output: 2 3 4 5 1
        }
    }
}
```

---

## 7️⃣ **Complexity Analysis** 🔍

- **Time Complexity**:  
  The time complexity is **O(n)**, where `n` is the length of the array. We loop through the entire array once to shift the elements.

- **Space Complexity**:  
  The space complexity is **O(1)** because we only use a constant amount of extra space (the `temp` variable).

---

## 8️⃣ **Key Takeaways** 🚀

- You’ve just learned how to efficiently rotate an array by one position to the left!
- This solution is fast (O(n) time) and space-efficient (O(1) space).
- With this technique, you can tackle more complex array manipulation problems! 💪

---

🎉 **Great job! You're one step closer to becoming an array manipulation master!** Keep practicing and you'll continue to improve. Happy coding! 😄