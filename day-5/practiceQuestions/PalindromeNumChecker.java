import java.util.Scanner; // Import the Scanner class for user input

// Explanation: A palindrome is a number that remains the same when its digits are reversed. 
// For example, 121 and 12321 are palindromes.
public class PalindromeNumChecker {
    // Function to check if a number is palindrome
    public static boolean isPalindrome(int number) {
        int original = number;  // Store original number
        int reversed = 0;
        // Reverse the number
        while (number != 0) {
            int digit = number % 10;  // Get the last digit
            reversed = reversed * 10 + digit;  // Build the reversed number
            number /= 10;  // Remove the last digit
        }
        return original == reversed;  // Check if original is equal to reversed
    }

    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a number to check if it is a palindrome: ");
            int num = scanner.nextInt();  // Read the input
            
            // Check and display if the number is a palindrome
            System.out.println(num + " is palindrome: " + isPalindrome(num));
        }
    }
}
