import java.util.Scanner; // Import the Scanner class for user input

// Explanation: Similar to numbers, a string is a palindrome if it reads the same backward as forward. 
// For example, "madam" is a palindrome.

public class PalindromeStringChecker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string to check if it is a palindrome: "); // Prompt user for input
            String str = scanner.nextLine(); // Read the input
            
            int n = str.length();
            // Check characters from the start and end moving towards the center
            boolean isPalindrome = true; // Assume the string is a palindrome
            for (int i = 0; i < n / 2; i++) {
                if (str.charAt(i) != str.charAt(n - 1 - i)) {
                    isPalindrome = false; // If characters don't match, it's not a palindrome
                    break;
                }
            }
            System.out.println("\"" + str + "\" is palindrome: " + isPalindrome); // Display if the string is a palindrome
        }
    }
}