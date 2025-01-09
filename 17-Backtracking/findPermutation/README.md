# Permutations of a String

## Problem Statement
Given a string, find and print all the permutations of its characters. A permutation is a rearrangement of the characters of the string, and for a string of length `n`, there are `n!` (factorial of `n`) possible permutations.

---

## Why is this Problem Important?

Permutations are a fundamental concept in computer science and mathematics. They are used in solving problems like:
- **String reordering**: Generating all possible passwords or arrangements of letters.
- **Game design**: Arranging elements in all possible orders.
- **Combinatorics**: Understanding permutations is essential in probability and optimization.

By learning how to solve this, you'll strengthen your skills in recursion, backtracking, and string manipulation.

---

## Approach to Solve the Problem

The idea is to recursively generate all possible arrangements of the string by selecting one character at a time, appending it to the result, and exploring further permutations with the remaining characters.

1. **Recursive Function**:
    - Remove one character at a time from the string.
    - Add the removed character to the result (partial answer).
    - Recursively call the function with the remaining characters.

2. **Base Case**:
    - When the input string is empty, the result is complete, and we print it.

3. **Iterative Step**:
    - Loop through each character of the string, remove it, and generate new substrings for recursive processing.

---

## Example Walkthrough

### Input:
`str = "abc"`

### Steps:

1. Start with an empty result `ans = ""`.
2. Choose the first character, `a`:
    - Remaining string: `"bc"`
    - Add `a` to `ans`: `ans = "a"`
    - Recursively find permutations of `"bc"`.

3. Choose `b` from `"bc"`:
    - Remaining string: `"c"`
    - Add `b` to `ans`: `ans = "ab"`
    - Recursively find permutations of `"c"`.

4. Finally, choose `c`:
    - Remaining string: `""`
    - Add `c` to `ans`: `ans = "abc"`
    - Base case reached: print `"abc"`.

5. Backtrack and choose other characters (e.g., `b` first, then `a`, and so on).

### Output:
```
abc
acb
bac
bca
cab
cba
```

---

## Code Walkthrough

Here's the Java implementation to solve this problem:

```java
public class FindPermutation {
    // Method to find and print all permutations of a given string
    public static void findPermutation(String str, String ans) {
        // Base case: if string is empty, print the current permutation
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Loop through the string to choose each character
        for (int i = 0; i < str.length(); i++) {
            // Remove the current character and generate a new string
            String newString = str.substring(0, i) + str.substring(i + 1);

            // Recursive call: add the current character to 'ans' and process the remaining string
            findPermutation(newString, ans + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        // Input string
        String str = "abc";

        // Find and print all permutations
        findPermutation(str, "");
    }
}
```

---

## Time and Space Complexity

### Time Complexity:
- For a string of length `n`, there are `n!` permutations.
- In each recursive call, a substring is created (`O(n)`).
- Total complexity: **O(n × n!)**

### Space Complexity:
- The recursion stack goes as deep as the length of the string (`O(n)`).
- Additionally, new substrings are created at each level of recursion.
- Space complexity: **O(n²)** (due to substring creation and recursion depth).

---

## Why Use Recursion?

This problem is a classic example of solving using **recursion**:
- It simplifies the problem by breaking it down into smaller subproblems.
- Helps us explore all possible permutations without explicitly generating combinations beforehand.

---

## Visual Representation

Here's a visual representation of the recursive calls:

```
              abc
          /    |     \
         a     b      c
       / |     | \    | \
      bc  cb  ac  ca  ab  ba
     /    |    |    |    |    \
    c     b    c    a    b     a
```

This tree structure shows how each character is chosen and removed, leading to smaller subproblems until the base case is reached.

---

## Fun Fact

For larger strings, the number of permutations grows exponentially!  
For example:
- A string of 3 characters (`abc`) has `3! = 6` permutations.
- A string of 4 characters (`abcd`) has `4! = 24` permutations.
- A string of 10 characters has `10! = 3,628,800` permutations!

---

## How to Test

### Input:
`str = "xyz"`

### Output:
```
xyz
xzy
yxz
yzx
zxy
zyx
```

### Try Different Inputs:
- `"ab"` (simpler case)
- `"abcd"` (more complex case)
- Edge case: `""` (empty string)

---

## Practice Challenge

1. Modify the program to return a list of permutations instead of printing them.
2. Can you optimize the program to avoid creating new substrings at each step?

---

This problem not only improves your understanding of recursion but also builds a strong foundation for solving combinatorics-related problems. Happy coding! 😊