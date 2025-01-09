

# FirstOccurrence 🔍

This Java program uses recursion to find the **first occurrence** of a given element (or "key") in an array. If the element is found, it returns the index of its first occurrence; if not, it returns `-1`.

## 📋 How It Works

### Key Components of the Code

- **Base Case 1**: If the current element matches the key, the function returns the current index (`i`) as the location of the first occurrence.
- **Base Case 2**: If we reach the last element in the array without finding the key, the function returns `-1`, meaning the key is not present.
- **Recursive Case**: If the current element does not match the key, we make a recursive call with the next index (`i + 1`), continuing to search until we reach one of the base cases.

### Code Walkthrough

```java
public static int findFirst(int[] arr, int key, int i) {
    // Base Case 1: If the current element matches the key, return the index
    if (arr[i] == key) {
        return i;
    }
    // Base Case 2: If we've reached the end of the array and haven’t found the key, return -1
    else if (i == arr.length - 1) {
        return -1;
    }
    // Recursive Case: Move to the next index
    return findFirst(arr, key, i + 1);
}
```

### Main Function

```java
public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 7, 67, 8, 7};
    System.out.println(findFirst(arr, 7, 0));
}
```

- **`arr`**: The array in which we’re searching for the key.
- **`key`**: The element we want to find (in this case, `7`).
- **Output**: The program outputs the index of the first occurrence of `7` in the array, which is `5`.

## 🛠️ Dry Run

Let’s walk through the execution of `findFirst(arr, 7, 0)` step-by-step:

1. **First Call**: `findFirst(arr, 7, 0)`
   - Checks `arr[0] == 7` → false
   - Calls `findFirst(arr, 7, 1)`

2. **Second Call**: `findFirst(arr, 7, 1)`
   - Checks `arr[1] == 7` → false
   - Calls `findFirst(arr, 7, 2)`

3. **Third Call**: `findFirst(arr, 7, 2)`
   - Checks `arr[2] == 7` → false
   - Calls `findFirst(arr, 7, 3)`

4. **Fourth Call**: `findFirst(arr, 7, 3)`
   - Checks `arr[3] == 7` → false
   - Calls `findFirst(arr, 7, 4)`

5. **Fifth Call**: `findFirst(arr, 7, 4)`
   - Checks `arr[4] == 7` → false
   - Calls `findFirst(arr, 7, 5)`

6. **Sixth Call**: `findFirst(arr, 7, 5)`
   - Checks `arr[5] == 7` → true
   - Returns `5` (index of the first occurrence of `7`)

All previous calls will return `5` up the stack until we get the final result in `main()`.

### 🧩 Complexity Analysis

- **Time Complexity**: `O(n)` where `n` is the length of the array, as each element is checked once in the worst case.
- **Space Complexity**: `O(n)` due to the recursive call stack, with one call per element until the base case is met.

## 🎯 Key Points

- The program demonstrates a **simple recursive search** to find the first occurrence of a key in an array.
- **Efficiency**: This method is effective for finding the first occurrence but can be optimized for larger arrays or frequently used search operations.

---

This explanation provides a strong foundation in recursion and introduces the idea of recursive search logic. Happy coding! 😊