import java.util.Scanner; // Import the Scanner class for user input

// Explanation: Similar to numbers, a string is a palindrome if it reads the same backward as forward. 
// For example, "madam" is a palindrome.

public class PalindromeStringChecker {
    // Function to check if a string is palindrome
    public static boolean isPalindrome(String str) {
        int n = str.length();
        // Check characters from the start and end moving towards the center
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;  // If characters don't match, it's not a palindrome
            }
        }
        return true;  // If all characters match, it is a palindrome
    }

    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a string to check if it is a palindrome: ");
            String str = scanner.nextLine();  // Read the input
            
            // Check and display if the string is a palindrome
            System.out.println("\"" + str + "\" is palindrome: " + isPalindrome(str));
        }
    }
}
