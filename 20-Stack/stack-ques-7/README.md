# Duplicate Parentheses Problem Explained 🎯

## Problem Statement ❓
The **Duplicate Parentheses Problem** asks us to determine if a given mathematical expression contains any redundant parentheses. 

For example:
- **Input:** `((a+b))`
  **Output:** `true` (It’s invalid because the second pair of parentheses is redundant.)
- **Input:** `(a + (b * c))`
  **Output:** `false` (No redundancy, all parentheses are needed.)

---

## Approach 🛠️
We use a **stack** to solve this problem efficiently.

### Steps:
1. Traverse the string character by character.
2. Push all characters except closing brackets `)` onto the stack.
3. When encountering a closing bracket:
   - Pop elements from the stack until an opening bracket `(` is found.
   - If no characters are between the parentheses (i.e., count of popped characters is less than 1), it indicates redundancy.
4. If no redundancy is found after traversal, return `false`. Otherwise, return `true`.

---

## Algorithm (Pseudocode) 📃
```text
Function hasDuplicateParentheses(expression):
    Initialize stack = empty

    For each character in expression:
        If character is NOT ')':
            Push character onto stack
        Else:
            Initialize count = 0
            While top of stack is not '(':
                Pop from stack
                Increment count
            If count < 1:
                Return true (redundant parentheses found)
            Else:
                Pop the '(' from stack

    Return false (no redundancy found)
```

---

## Java Implementation 💻
```java
import java.util.Stack;

public class StackJFC {
    // Function to check for duplicate parentheses
    public static boolean duplicateParenthesis(String expression) {
        Stack<Character> s = new Stack<>(); // Stack to store characters

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            // Push all characters except closing parentheses
            if (current != ')') {
                s.push(current);
            } else {
                int count = 0;

                // Pop characters until an opening parenthesis is found
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }

                // If no characters were inside the parentheses, they are redundant
                if (count < 1) {
                    return true;
                } else {
                    s.pop(); // Pop the opening parenthesis
                }
            }
        }

        return false; // No redundancy found
    }

    public static void main(String[] args) {
        String str = "((2))"; // Example input
        System.out.println(duplicateParenthesis(str)); // Should print true
    }
}
```

---

## Dry Run Example 🔍
Let’s evaluate the input `((2))` step by step:

### Input: `((2))`
1. **`(`**: Push onto stack → Stack: `(`.
2. **`(`**: Push onto stack → Stack: `((`.
3. **`2`**: Push onto stack → Stack: `((2`.
4. **`)`**: Closing bracket:
   - Pop `2` → Count = 1 → Stack: `((`.
   - Pop `(` → Stack: `(`.
   - No redundancy here.
5. **`)`**: Closing bracket:
   - No characters between parentheses → Redundancy found.

Result: The expression contains duplicate parentheses.

---

## Step-by-Step Code Explanation 🔎

### 1. **Function Header and Stack Initialization:**
```java
Stack<Character> s = new Stack<>();
```
- A stack is initialized to keep track of characters as we traverse the string.

### 2. **Traversing the String:**
```java
for (int i = 0; i < expression.length(); i++) {
    char current = expression.charAt(i);
```
- The `for` loop iterates through each character of the string.

### 3. **Pushing Non-Closing Brackets:**
```java
if (current != ')') {
    s.push(current);
}
```
- Any character that is not a closing parenthesis is pushed onto the stack.

### 4. **Handling Closing Parentheses:**
```java
if (current == ')') {
    int count = 0;
    while (s.peek() != '(') {
        s.pop();
        count++;
    }
```
- When encountering a closing parenthesis, we pop elements from the stack until an opening parenthesis `(` is found.
- A `count` variable is used to track the number of popped elements.

### 5. **Checking for Redundancy:**
```java
if (count < 1) {
    return true;
}
```
- If no characters were found between the parentheses (i.e., `count < 1`), redundancy is detected, and `true` is returned.

### 6. **Cleaning Up:**
```java
s.pop();
```
- The opening parenthesis `(` is popped from the stack after processing.

### 7. **Final Result:**
```java
return false;
```
- If the stack is empty after traversal, no redundancy is found, and `false` is returned.

---

## Complexity Analysis 📊

### Time Complexity:
- **O(n):** Each character is processed once, and each push/pop operation takes O(1).

### Space Complexity:
- **O(n):** In the worst case, the stack stores all characters from the expression.

---

## Key Takeaways 🎉
- Redundant parentheses can be detected using a stack by counting characters between matching pairs.
- Efficient traversal and stack operations ensure optimal performance.

Happy coding! 🚀

