# Valid Parentheses Problem Explained 🎯

## Problem Statement ❓
The **Valid Parentheses Problem** asks us to determine whether a string containing brackets (like `()`, `{}`, `[]`) is valid. A valid string must:

1. Open brackets be closed in the correct order.
2. Each open bracket must have a corresponding matching close bracket.

For example:
- **Input:** `{[()]}`
  **Output:** `true` (It’s valid because all brackets match correctly.)
- **Input:** `{[}`
  **Output:** `false` (The brackets are not properly matched.)

---

## Approach 🛠️
We use a **stack** to solve this problem efficiently.

### Steps:
1. Traverse the string character by character.
2. Push **opening brackets** onto the stack.
3. For **closing brackets**:
   - Check if the stack is empty (if it’s empty, the string is invalid).
   - Pop the top element and verify that it matches the current closing bracket.
   - If they don’t match, return `false`.
4. At the end of traversal, if the stack is empty, the string is valid. Otherwise, it’s invalid.

---

## Algorithm (Pseudocode) 📃
```text
Function isValid(expression):
    Initialize stack = empty

    For each character in expression:
        If character is an opening bracket:
            Push character onto the stack
        Else if character is a closing bracket:
            If stack is empty OR top of stack doesn’t match character:
                Return false
            Else:
                Pop from stack

    Return true if stack is empty, otherwise false
```

---

## Java Implementation 💻
```java
import java.util.Stack;

public class StackJFC {

    // Function to check if two brackets match
    public static boolean match(char a, char b) {
        if (a == '(' && b == ')') return true;
        if (a == '{' && b == '}') return true;
        if (a == '[' && b == ']') return true;
        return false;
    }

    // Function to check if the parentheses in the expression are valid
    public static boolean parenthesis(String expression) {
        Stack<Character> s = new Stack<>(); // Stack to store opening brackets

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            // Push opening brackets onto the stack
            if (current == '(' || current == '{' || current == '[') {
                s.push(current);
            } 
            // For closing brackets, check for matching pairs
            else if (current == ')' || current == '}' || current == ']') {
                if (s.isEmpty() || !match(s.pop(), current)) {
                    return false; // If stack is empty or brackets don’t match
                }
            }
        }

        return s.isEmpty(); // Valid if stack is empty at the end
    }

    public static void main(String[] args) {
        String str = "[{]}"; // Example input
        System.out.println(parenthesis(str)); // Should print false
    }
}
```

---

## Dry Run Example 🔍
Let’s evaluate the input `{[()]}` step by step:

### Input: `{[()]}`
1. **`{`**: Opening bracket, push onto stack → Stack: `{`.
2. **`[`**: Opening bracket, push onto stack → Stack: `{[`.
3. **`(`**: Opening bracket, push onto stack → Stack: `{[(`.
4. **`)`**: Closing bracket, matches `(` → Pop → Stack: `{[`.
5. **`]`**: Closing bracket, matches `[` → Pop → Stack: `{`.
6. **`}`**: Closing bracket, matches `{` → Pop → Stack: `[]` (empty).

Result: The string is valid.

---

## Complexity Analysis 📊

### Time Complexity:
- **O(n):** Each character is processed once, and each push/pop operation takes O(1).

### Space Complexity:
- **O(n):** In the worst case, the stack stores all opening brackets.

---

## Key Takeaways 🎉
- Stacks are perfect for solving problems involving nested structures, like parentheses.
- Ensuring stack is empty at the end guarantees proper closure of all brackets.

Happy coding! 🚀

