import java.util.Stack;

public class StackJFC {

    // Method to reverse a string using a stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();  // Create a stack to hold characters
        int i = 0;
        
        // Push each character of the string onto the stack
        while (i < str.length()) {
            s.push(str.charAt(i));
            i++;
        }
        
        // Build the reversed string by popping elements from the stack
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            result.append(s.peek());  // Append the top element to the result
            s.pop();  // Remove the top element from the stack
        }
        
        // Return the reversed string
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "saifmalik";  // Input string
        System.out.println(reverseString(str));  // Print the reversed string
    }
}
