# README: Finding Indices of a Key in an Array Using Recursion

## 🧠 Problem Explanation

Imagine you have a list of numbers, and you need to find where a particular number appears in that list. In this problem, we're going to solve that using **recursion**, which is like solving a puzzle by breaking it down into smaller pieces. Instead of looking at the entire array all at once, we'll check each element one by one, starting from the first element, and move forward.

### 🎯 Goal:
We want to print all the **indices** where a given `key` (a number) appears in an array.

---

## 🚀 How the Code Works

The program is built around a recursive function `printindices` that takes an array, a key to search for, and the current index as input. The goal is to check whether the key exists at the current index. If it does, we print the index. Then, we keep calling the function for the next index, moving through the entire array. 

### 🚨 Key Concepts:
- **Recursion**: A function that calls itself to solve a problem in smaller chunks.
- **Base Case**: The point at which recursion stops — here it's when we've checked all elements in the array.

---

## 🔍 Dry Run of the Code

Let's walk through the code step-by-step with an example to see how recursion helps us find the indices where `2` appears in the array.

### Example Input:
```java
int[] arr = {1, 2, 3, 5, 2, 7, 2, 9, 8, 2};
int key = 2;
printindices(arr, key, 0);
```

### Step-by-Step Execution:

We start with the first element and check each one, calling the function again and again until we reach the end of the array.

1. **Call 1: `printindices(arr, 2, 0)`**  
   - `arr[0] = 1`, which is not equal to `2`.
   - Move to the next index.
   - Recursive call: `printindices(arr, 2, 1)`.

2. **Call 2: `printindices(arr, 2, 1)`**  
   - `arr[1] = 2`, which **is equal** to `2`.  
   - Print index `1`.  
   - Move to the next index.
   - Recursive call: `printindices(arr, 2, 2)`.

3. **Call 3: `printindices(arr, 2, 2)`**  
   - `arr[2] = 3`, which is not equal to `2`.
   - Move to the next index.
   - Recursive call: `printindices(arr, 2, 3)`.

4. **Call 4: `printindices(arr, 2, 3)`**  
   - `arr[3] = 5`, which is not equal to `2`.
   - Move to the next index.
   - Recursive call: `printindices(arr, 2, 4)`.

5. **Call 5: `printindices(arr, 2, 4)`**  
   - `arr[4] = 2`, which **is equal** to `2`.  
   - Print index `4`.  
   - Move to the next index.
   - Recursive call: `printindices(arr, 2, 5)`.

6. **Call 6: `printindices(arr, 2, 5)`**  
   - `arr[5] = 7`, which is not equal to `2`.
   - Move to the next index.
   - Recursive call: `printindices(arr, 2, 6)`.

7. **Call 7: `printindices(arr, 2, 6)`**  
   - `arr[6] = 2`, which **is equal** to `2`.  
   - Print index `6`.  
   - Move to the next index.
   - Recursive call: `printindices(arr, 2, 7)`.

8. **Call 8: `printindices(arr, 2, 7)`**  
   - `arr[7] = 9`, which is not equal to `2`.
   - Move to the next index.
   - Recursive call: `printindices(arr, 2, 8)`.

9. **Call 9: `printindices(arr, 2, 8)`**  
   - `arr[8] = 8`, which is not equal to `2`.
   - Move to the next index.
   - Recursive call: `printindices(arr, 2, 9)`.

10. **Call 10: `printindices(arr, 2, 9)`**  
    - `arr[9] = 2`, which **is equal** to `2`.  
    - Print index `9`.  
    - We've reached the end of the array. The recursion stops.

### Final Output:
```
1
4
6
9
```

---

## 🔄 Recursion Breakdown

1. **Initial Call**: We start at index `0`, checking if `arr[0] == key`. If not, we call the function again for the next index.
2. **Match Found**: If `arr[idx] == key`, we print that index.
3. **Recur**: Each time we move to the next index, making a recursive call until we've checked all the elements.

### Call Stack Visualization:
Each recursive call adds a new frame to the call stack, and once we reach the base case (end of the array), we return back through the call stack.

```
Call 1: printindices(arr, 2, 0) -> Recursively call printindices(arr, 2, 1)
Call 2: printindices(arr, 2, 1) -> Found match, print 1 -> Recursively call printindices(arr, 2, 2)
Call 3: printindices(arr, 2, 2) -> Recursively call printindices(arr, 2, 3)
...
Call 10: printindices(arr, 2, 9) -> Found match, print 9 -> End of recursion
```

---

## 📝 Code Walkthrough

```java
public class PrintIndices {
    // Recursive function to find indices of a key in an array
    public static void printindices(int[] arr ,int key,int idx) {
        // Base case: If we've checked all elements, stop recursion
        if(idx == arr.length) {
            return;
        }

        // If the current element matches the key, print the index
        if(arr[idx] == key) {
            System.out.println(idx);
        }

        // Recursively call the function for the next index
        printindices(arr, key, idx + 1);
    }

    public static void main(String[] args) {
        // Example array and key
        int[] arr = {1, 2, 3, 5, 2, 7, 2, 9, 8, 2};
        printindices(arr, 2, 0); // Find indices of 2 in the array
    }
}
```

---

## 🔑 Key Takeaways

- **Recursion** is a powerful technique where a function calls itself to solve smaller problems.
- The **base case** (`idx == arr.length`) prevents the recursion from continuing indefinitely.
- This approach is very clean and easy to understand when searching through an array or list.

---

## 🏁 Conclusion

This problem showcases the power of recursion in solving simple array problems. By breaking the problem down into smaller parts, each function call works on a smaller index of the array until we’ve checked every element.

Now you have a clear understanding of how recursion can help you **find all occurrences of a key** in an array, and how the recursion stack helps in going through each element systematically! 😎 Happy coding!