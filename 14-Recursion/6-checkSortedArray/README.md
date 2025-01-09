

# CheckSortedArray 🚦

This Java program uses recursion to check if an array is sorted in ascending order. It does this by comparing each element to the next, moving through the array one step at a time, until it reaches the end (or finds an unsorted pair).

## 📋 How It Works

### Key Components of the Code

- **Base Case**: The base case stops recursion once we reach the last element in the array. If we get this far without finding any out-of-order elements, the array is confirmed to be sorted.
  
- **Recursive Case**: If the current element is greater than the next element, the function immediately returns `false` since the array is not sorted. If not, the function calls itself with the next index, continuing to check the array until it reaches the base case.

### Code Walkthrough

```java
public static boolean checkSortedArray(int[] num, int i) {
    // Base case: if we reach the last element, the array is sorted
    if (i == num.length - 1) {
        return true;
    }

    // If the current element is greater than the next one, the array is not sorted
    if (num[i] > num[i + 1]) {
        return false;
    }

    // Recursive call to check the rest of the array
    return checkSortedArray(num, i + 1);
}
```

### Main Function

```java
public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    boolean isSorted = checkSortedArray(array, 0);
    System.out.println("Is the array sorted? " + isSorted);
}
```

- **`array`**: We define an array to test if it is sorted. In this example, `{1, 2, 3, 4, 5}` is in ascending order, so the output will be `true`.

## 🛠️ Dry Run

Let’s see how the program works step-by-step with `array = {1, 2, 3, 4, 5}`:

1. **First Call**: `checkSortedArray(array, 0)`
   - Checks `array[0] (1) <= array[1] (2)` → true
   - Calls `checkSortedArray(array, 1)`

2. **Second Call**: `checkSortedArray(array, 1)`
   - Checks `array[1] (2) <= array[2] (3)` → true
   - Calls `checkSortedArray(array, 2)`

3. **Third Call**: `checkSortedArray(array, 2)`
   - Checks `array[2] (3) <= array[3] (4)` → true
   - Calls `checkSortedArray(array, 3)`

4. **Fourth Call**: `checkSortedArray(array, 3)`
   - Checks `array[3] (4) <= array[4] (5)` → true
   - Calls `checkSortedArray(array, 4)`

5. **Fifth Call**: `checkSortedArray(array, 4)`
   - Reached the last element, so it returns `true` (base case).

The recursion completes, returning `true`, which indicates that the array is sorted.

## 🧩 Complexity Analysis

- **Time Complexity**: `O(n)` where `n` is the number of elements in the array, because each element is checked once.
- **Space Complexity**: `O(n)` due to the recursive call stack, with one call for each element.

## 🎯 Key Points

- Recursion is used to simplify the logic for checking each element.
- **Base Case**: Reaches the last element, meaning the array is sorted.
- **Efficiency**: This approach works for any size array, but for very large arrays, an iterative solution may be preferred to avoid a large call stack.

Happy learning about recursion and sorted array checks! 🌟