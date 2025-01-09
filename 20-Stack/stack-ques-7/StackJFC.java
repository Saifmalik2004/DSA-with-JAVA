import java.util.Stack;

public class StackJFC {

    // Method to check if there are any duplicate parentheses in the expression
    public static boolean duplicateParenthesis(String expression) {
        Stack<Character> s = new Stack<>(); // Stack to store parentheses
        
        // Traverse the expression character by character
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);  // Get the current character

            // If the character is not a closing parenthesis, push it to the stack
            if (current != ')') {
                s.push(current);
            } 
            // If the character is a closing parenthesis
            else {
                int count = 0;
                
                // Pop elements from the stack until we encounter an opening parenthesis
                while (s.peek() != '(') {
                    s.pop();
                    count++;  // Count how many elements are between the parentheses
                }
                
                // If no elements are found between the parentheses, it means there are duplicate parentheses
                if (count < 1) {
                    return true;  // Return true if duplicate parentheses are found
                } else {
                    s.pop();  // Pop the opening parenthesis
                }
            }
        }

        return false;  // Return false if no duplicate parentheses are found
    }

    public static void main(String[] args) {
        String str = "((2))";  // Test string with duplicate parentheses
        System.out.println(duplicateParenthesis(str));  // Should print true
    }
}
