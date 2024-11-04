

# Remove Duplicates from String

## Problem Statement

Write a function that removes duplicate characters from a given string while preserving the order of the original characters. You are not allowed to use data structures like `HashSet` or `LinkedHashSet` to solve this problem.

### Example

- **Input**: `"programming"`
- **Output**: `"progamin"`

## Approach

The goal is to iterate through each character in the string and build a new result string that contains each character only once in the order of its first appearance. This can be achieved using `StringBuilder` and checking each character as we iterate through the original string.

### Steps to Solve the Problem

1. **Initialize the Result String**: Start by creating an empty `StringBuilder` object called `result` to store unique characters in the order they appear.

2. **Loop Through the Characters**: Use a `for` loop to go through each character in the input string.

3. **Check for Duplicates**: For each character:
   - Convert the character to a `String` using `String.valueOf()`.
   - Use the `indexOf()` method on `result` to check if this character already exists in the result string.
   - If `indexOf()` returns `-1`, this means the character is not in `result`, so we add it.
   - If `indexOf()` returns a non-negative value, skip this character as it is already in `result`.

4. **Return the Result**: Convert the `StringBuilder` to a string and return it as the final result.

### Code

```java
public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();  // Stores unique characters in order
        
        for (char currentChar : str.toCharArray()) {
            // Check if currentChar is not in result
            if (result.indexOf(String.valueOf(currentChar)) == -1) {
                result.append(currentChar);  // Append the unique character
            }
        }
        return result.toString();  // Convert StringBuilder to String and return
    }

    public static void main(String[] args) {
        String input = "programming";
        System.out.println(removeDuplicates(input));  // Output: "progamin"
    }
}
```

### Explanation of Key Parts

1. **StringBuilder**: `StringBuilder` is used to efficiently build the result string as it is mutable and supports appending characters without creating new string objects each time.
  
2. **indexOf Method**:
   - The `indexOf()` method checks if a specific character (converted to `String`) is present in `result`.
   - If `indexOf()` returns `-1`, it means the character has not been added to `result`, so we append it.
   - If it returns a non-negative number, this character already exists in `result`, so we skip it to avoid duplicates.

3. **Character Order**: Since we are appending characters only if they appear the first time, the result will maintain the order of first appearance of each character from the original string.

### Complexity Analysis

- **Time Complexity**: `O(n * m)`, where `n` is the length of the input string and `m` is the length of the `result` string at any point. `indexOf()` has a linear time complexity, so checking each character in `result` makes the overall complexity around `O(n^2)` in the worst case.
- **Space Complexity**: `O(n)`, where `n` is the length of the input string, as we are using a `StringBuilder` to store the unique characters.

### Example Walkthrough

For input `"programming"`:

1. **First Character ('p')**:
   - `indexOf("p")` on `result` gives `-1` (not found), so append `"p"`.
2. **Second Character ('r')**:
   - `indexOf("r")` gives `-1`, so append `"r"`.
3. Continue this process, only appending characters when `indexOf()` returns `-1`, to get the final result: `"progamin"`.

## Conclusion

This solution effectively removes duplicate characters from a string without additional data structures, preserving the original order of characters.