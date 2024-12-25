import java.util.Stack;

public class StackJFC {

    // Method to check if the two characters are matching parentheses
    public static boolean match(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        return false;  // Return false if the characters do not match
    }

    // Method to check if the parentheses in the expression are balanced
    public static boolean parenthesis(String expression) {
        Stack<Character> s = new Stack<>();  // Stack to store opening parentheses

        // Traverse the expression character by character
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);  // Get the current character

            // If the character is an opening parenthesis, push it to the stack
            if (current == '(' || current == '{' || current == '[') {
                s.push(current);
            } 
            // If the character is a closing parenthesis
            else if (current == ')' || current == '}' || current == ']') {
                // Check if the stack is empty or if the top element of the stack doesn't match
                if (s.isEmpty() || !match(s.pop(), current)) {
                    return false;  // Return false if not balanced
                }
            }
        }

        // Return true if the stack is empty, indicating that all parentheses are matched
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String str = "[{]";  // Test string with unbalanced parentheses
        System.out.println(parenthesis(str));  // Should print false, because the parentheses are not balanced
    }
}
