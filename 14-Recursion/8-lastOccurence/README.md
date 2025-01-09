

# LastOccurrence 🔍

This Java program uses recursion to find the **last occurrence** of a given element (or "key") in an array. If the element is found, it returns the index of its last occurrence; if not, it returns `-1`.

## 📋 How It Works

### Key Components of the Code

- **Base Case**: If we reach the second last element (i.e., `i == arr.length - 1`), we stop recursion and start checking if the key exists.
- **Recursive Case**: The function makes a recursive call to move towards the end of the array, and on the way back, it checks if the current element is the key and if it’s the first occurrence after the recursive search.

### Code Walkthrough

```java
public static int lastOccurenceFinder(int arr[], int key, int i) {
    // Base Case: If we reach the end of the array, return -1 (no occurrence found)
    if (i == arr.length - 1) {
        return -1;
    }

    // Recursive Case: Move towards the end of the array
    int isFound = lastOccurenceFinder(arr, key, ++i);

    // After recursion, check if the key matches and if it's the first match from the end
    if (arr[i] == key && isFound == -1) {
        return i;
    }
    
    // Return the found index or the last known match
    return isFound;
}
```

### Main Function

```java
public static void main(String[] args) {
    int arr[] = {1, 2, 3, 1};
    System.out.println(lastOccurenceFinder(arr, 7, 0));
}
```

- **`arr[]`**: The array in which we’re searching for the key.
- **`key`**: The element we want to find (in this case, `7`).
- **Output**: The program outputs `-1` because `7` is not found in the array.

### 🛠️ Dry Run

Let’s walk through the execution of `lastOccurenceFinder(arr, 7, 0)` step-by-step:

1. **First Call**: `lastOccurenceFinder(arr, 7, 0)`
   - `i == 0`, `arr[0] == 1`, calls `lastOccurenceFinder(arr, 7, 1)`

2. **Second Call**: `lastOccurenceFinder(arr, 7, 1)`
   - `i == 1`, `arr[1] == 2`, calls `lastOccurenceFinder(arr, 7, 2)`

3. **Third Call**: `lastOccurenceFinder(arr, 7, 2)`
   - `i == 2`, `arr[2] == 3`, calls `lastOccurenceFinder(arr, 7, 3)`

4. **Fourth Call**: `lastOccurenceFinder(arr, 7, 3)`
   - `i == 3`, `arr[3] == 1`, calls `lastOccurenceFinder(arr, 7, 4)` (base case reached)

5. **Base Case Reached**: `lastOccurenceFinder(arr, 7, 4)`
   - `i == 4`, returns `-1` (no occurrence of `7` found).

Now, returning up the call stack:

- **Fourth Call** returns `-1` to the third call.
- **Third Call** returns `-1` to the second call.
- **Second Call** returns `-1` to the first call.

Finally, the main function outputs `-1` because `7` is not found in the array.

### 🧩 Complexity Analysis

- **Time Complexity**: `O(n)` where `n` is the length of the array, as we visit each element once.
- **Space Complexity**: `O(n)` due to the recursion call stack, with one call per element.

## 🎯 Key Points

- This program demonstrates a **recursive search** for the **last occurrence** of a key in an array.
- **Efficiency**: The function checks every element from the beginning, even though it stops early once the last occurrence is found.
- This approach can be helpful for finding the last occurrence without needing to traverse the entire array again in reverse.

---

This explanation provides an insightful look at the recursive approach for finding the last occurrence of an element. Happy coding! 😊