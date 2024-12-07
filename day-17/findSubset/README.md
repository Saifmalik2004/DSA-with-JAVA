

# Generating All Subsets of a String Using Recursion

This project demonstrates how to use recursion to generate **all subsets** of a given string. It is a common problem in computer science and helps understand recursive thinking, breaking problems into smaller parts.

---

## Table of Contents

1. [What Are Subsets?](#what-are-subsets)
2. [How Does This Program Work?](#how-does-this-program-work)
3. [Code Walkthrough](#code-walkthrough)
4. [Recursion Tree](#recursion-tree)
5. [Time and Space Complexity](#time-and-space-complexity)
6. [How to Run This Code](#how-to-run-this-code)

---

## What Are Subsets?

A **subset** of a string is a collection of characters that can be derived from the string by including or excluding each character. For example, the subsets of "abc" are:

```
null (empty set), a, b, c, ab, ac, bc, abc
```

---

## How Does This Program Work?

This program uses a recursive function to explore two choices for each character of the string:

1. Include the character in the current subset.
2. Exclude the character from the current subset.

The program continues until it has processed all characters, at which point it prints the resulting subset.

---

## Code Walkthrough

### Main Function

```java
public static void main(String[] args) {
    String str = "abc"; // Input string
    subsetFinder(str, "", 0); // Start recursion with an empty subset and index 0
}
```

### Recursive Function: `subsetFinder`

```java
public static void subsetFinder(String str, String ans, int i) {
    if (i == str.length()) { 
        // Base case: If we've processed all characters
        if (ans.length() == 0) {
            System.out.println("null"); // Print "null" for the empty subset
        } else {
            System.out.println(ans); // Print the subset
        }
        return; 
    }

    // Recursive case 1: Include the current character
    subsetFinder(str, ans + str.charAt(i), i + 1);

    // Recursive case 2: Exclude the current character
    subsetFinder(str, ans, i + 1);
}
```

- **Base Case**: When the index `i` equals the length of the string, the recursion stops, and the current subset is printed.
- **Recursive Steps**:
  - Include the current character (`ans + str.charAt(i)`).
  - Exclude the current character (`ans` remains unchanged).

---

## Recursion Tree

Here’s a visualization of how the function works for the input `abc`:

```
                          subsetFinder("abc", "", 0)
                       /                             \
            subsetFinder("abc", "a", 1)        subsetFinder("abc", "", 1)
             /                \                     /                \
subsetFinder("abc", "ab", 2)  subsetFinder("abc", "a", 2)  subsetFinder("abc", "b", 2)  subsetFinder("abc", "", 2)
  /    \               /    \                /    \                /    \
"abc"  "ab"         "ac"   "a"            "bc"   "b"            "c"    "null"
```

**Key Points**:
1. Each level of the tree represents a decision for one character (include or exclude).
2. The process stops when all characters are processed.

---

## Output for Input `abc`

```
abc
ab
ac
a
bc
b
c
null
```

---

## Time and Space Complexity

### Time Complexity

- At each character, there are **two choices**: include or exclude.
- For a string of length `n`, the recursion tree has `2^n` nodes.
- **Time complexity**: **O(2^n)**.

### Space Complexity

- The maximum depth of the recursion tree is `n` (the length of the string).
- Each recursive call uses stack space.
- **Space complexity**: **O(n)**.

---

## How to Run This Code

1. Copy the code into a file named `FindSubset.java`.
2. Compile the program:
   ```bash
   javac FindSubset.java
   ```
3. Run the program:
   ```bash
   java FindSubset
   ```

You can change the input string in the `main` function to test other cases.

---

## Conclusion

This program is an excellent example of recursion and backtracking. By systematically including and excluding characters, it generates all subsets of a string. Understanding the recursion tree and complexity is key to mastering this concept. Experiment with different strings to deepen your understanding!

