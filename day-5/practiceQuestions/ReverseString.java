import java.util.Scanner; // Import the Scanner class for user input

// Explanation: A string is a sequence of characters. 
// Reversing a string means writing it backward. 
// For example, the reverse of "Hello" is "olleH".
public class ReverseString {
    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a string to reverse: ");
            String input = scanner.nextLine(); // Read the input
            
            String reversed = ""; // Variable to hold the reversed string
            // Reverse the string by appending characters in reverse order
            for (int i = input.length() - 1; i >= 0; i--) {
                reversed += input.charAt(i); // Append each character in reverse order
            }
            
            // Display the original and reversed string
            System.out.println("Original String: " + input);
            System.out.println("Reversed String: " + reversed);
        }
    }
}
