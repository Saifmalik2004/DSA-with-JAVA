# Monotonic List Check Problem

## Problem Statement

Given a list of integers, the task is to determine if the list is **monotonic**. A list is considered monotonic if it is either:
- **Non-decreasing**: Each element is greater than or equal to the previous element.
- **Non-increasing**: Each element is less than or equal to the previous element.

### Example

**Input 1:**

```
List: [1, 2, 3, 4, 5]
```

**Output 1:**

```
true
```

Explanation: The list is non-decreasing.

**Input 2:**

```
List: [5, 4, 3, 2, 1]
```

**Output 2:**

```
true
```

Explanation: The list is non-increasing.

**Input 3:**

```
List: [1, 9, 2, 3]
```

**Output 3:**

```
false
```

Explanation: The list is neither non-decreasing nor non-increasing, so it's not monotonic.

## Approach

To check if the list is monotonic, we can track two conditions:
1. **Non-decreasing**: As we iterate through the list, we check if each element is greater than or equal to the previous element.
2. **Non-increasing**: Similarly, we check if each element is less than or equal to the previous element.

If either of these conditions holds true for the entire list, the list is monotonic. We can use two flags (`inc` and `dec`) to track the state of the list as we traverse it:
- If we find an element that violates the non-decreasing condition, we set the `inc` flag to `false`.
- If we find an element that violates the non-increasing condition, we set the `dec` flag to `false`.

At the end of the iteration, if either flag is still true, the list is monotonic.

## Algorithm (Pseudo Code)

```
1. Initialize two flags: inc = true (for non-decreasing) and dec = true (for non-increasing).
2. Iterate through the list from index 0 to list.size() - 1:
   a. If list[i] <= list[i + 1], set dec = false (not non-increasing).
   b. If list[i] >= list[i + 1], set inc = false (not non-decreasing).
3. Return true if either inc or dec is true.
4. If both are false, return false.
```

## Code Explanation

```java
import java.util.ArrayList;

public class Monotonic {

    // Method to check if a list is monotonic (either entirely non-increasing or non-decreasing)
    public static boolean montonic(ArrayList<Integer> list) {
        boolean inc = true; // Flag to track if the list is non-decreasing
        boolean dec = true; // Flag to track if the list is non-increasing

        // Iterate through the list to compare adjacent elements
        for (int i = 0; i < list.size() - 1; i++) {
            // If the current element is less than or equal to the next, it's not strictly decreasing
            if (list.get(i) <= list.get(i + 1)) {
                dec = false;
            } 
            // If the current element is greater than or equal to the next, it's not strictly increasing
            else if (list.get(i) >= list.get(i + 1)) {
                inc = false;
            }
        }

        // Return true if the list is either non-decreasing or non-increasing
        return inc || dec;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // Initialize the input list

        // Add elements to the list
        list.add(1);
        list.add(9);
        list.add(2);
        list.add(3);

        // Call the montonic method and print the result
        System.err.println(montonic(list)); // Output whether the list is monotonic
    }
}
```

### Walkthrough:

1. **Flags for Monotonicity:**
   - We initialize two boolean flags, `inc` and `dec`, both set to `true`. These flags track if the list is non-decreasing or non-increasing, respectively.

2. **Iteration Through the List:**
   - We iterate through the list, comparing each element with the next.
   - If an element is less than or equal to the next, it violates the non-increasing condition, so we set `dec` to `false`.
   - If an element is greater than or equal to the next, it violates the non-decreasing condition, so we set `inc` to `false`.

3. **Check the Flags:**
   - At the end of the iteration, if either `inc` or `dec` remains `true`, we return `true` because the list is monotonic.
   - If both flags are `false`, we return `false` because the list is neither strictly increasing nor decreasing.

## Time Complexity

- **Time Complexity:** O(n), where n is the number of elements in the list. We iterate through the list only once to check the monotonicity.
  
- **Space Complexity:** O(1), since we only use a constant amount of space for the flags (`inc` and `dec`).

## Key Features

- Efficient check for monotonicity with a linear time complexity.
- Only two boolean flags are used, making it space-efficient.
- Works for both non-decreasing and non-increasing lists.

## Tips

- The list must be processed sequentially for an efficient solution.
- This method works for both strictly increasing and strictly decreasing sequences as well as sequences that are constant.

## Conclusion

This approach offers an efficient way to check if a list is monotonic by using two flags to track non-decreasing and non-increasing conditions. With linear time complexity, this method is optimal for large datasets, providing a fast solution with minimal space usage.