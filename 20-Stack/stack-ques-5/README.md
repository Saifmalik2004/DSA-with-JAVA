# Next Greater Element Problem Explained 🌟

## Problem Statement ❓
The **Next Greater Element Problem** involves finding the next greater element for each element in an array. The **next greater element** of a number is the first number to its right that is larger than itself. If no such number exists, we assign `-1`.

For example, given the array: 
`[1, 0, 3, 4, 0, 7, 8]`, the output next greater array will be: 
`[3, 3, 4, 7, 7, 8, -1]`. 

### How it works:
- For **1**, the next greater element is `3`.
- For **0** (at index 1), the next greater element is `3`.
- For **8**, there’s no greater element to its right, so it’s `-1`.

This problem is common in competitive programming and helps you understand the utility of **stacks** for efficient array traversal.

---

## Approach 🛠️
We solve the problem using a **stack**. Instead of a brute-force approach, the stack helps efficiently find the next greater elements in a single traversal. 

Steps:
1. Traverse the array from **right to left** (reverse order).
2. Use a stack to keep track of elements for which we need to find the next greater element.
3. For each element:
   - Pop elements from the stack until you find a greater element or the stack becomes empty.
   - If the stack is empty, assign `-1` as the next greater element.
   - Otherwise, the top of the stack is the next greater element.
4. Push the current element’s index onto the stack.

---

## Algorithm (Pseudocode) 📃
```text
Function nextGreater(arr[], nextG[]):
    Initialize stack = empty

    Traverse the array from right to left:
        While stack is not empty AND arr[stack.top()] <= arr[i]:
            Pop from stack

        If stack is empty:
            nextG[i] = -1
        Else:
            nextG[i] = arr[stack.top()]

        Push i to stack
```

---

## Java Implementation 💻
```java
import java.util.Stack;

public class StackJFC {

    public static void nextGreater(int arr[], int nextG[]) {
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextG[i] = -1;
            } else {
                nextG[i] = arr[s.peek()];
            }

            s.push(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 3, 4, 0, 7, 8};
        int nextG[] = new int[arr.length];
        nextGreater(arr, nextG);

        for (int i = 0; i < nextG.length; i++) {
            System.out.print(nextG[i] + " ");
        }
        System.out.println();
    }
}
```

---

## Dry Run Example 🔍
Let’s take the array `[1, 0, 3, 4, 0, 7, 8]` and compute the next greater elements step-by-step:

### Step-by-Step Calculation:
- **Index 6 (8):** No greater element exists, so `-1`.
- **Index 5 (7):** Next greater is `8`.
- **Index 4 (0):** Next greater is `7`.
- **Index 3 (4):** Next greater is `7`.
- **Index 2 (3):** Next greater is `4`.
- **Index 1 (0):** Next greater is `3`.
- **Index 0 (1):** Next greater is `3`.

Final Next Greater Array: `[3, 3, 4, 7, 7, 8, -1]`

---

## Complexity Analysis 📊

### Time Complexity:
- Each element is pushed and popped from the stack at most once.
- Total time complexity = **O(n)**.

### Space Complexity:
- The stack requires **O(n)** space in the worst case.

---

## Key Takeaways 🎉
- The Next Greater Element Problem highlights the power of stacks for solving array problems efficiently.
- Traversing from right to left and using a stack ensures optimal performance.
- This approach avoids redundant comparisons, making it both elegant and scalable.

Happy coding! ✨

