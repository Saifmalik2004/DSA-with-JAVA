import java.util.Scanner; // Import the Scanner class for user input

/*
 * Explanation: The factorial of a non-negative integer N is the product of all positive integers less than or equal to N.
 * It is denoted by N!.
 * For example, 5! = 5 × 4 × 3 × 2 × 1 = 120.
 */
public class Factorial {
    // Function to calculate factorial
    public static int factorial(int n) {
        int fact = 1;  // Initialize factorial to 1
        // Loop to calculate factorial
        for (int i = 2; i <= n; i++) {
            fact *= i;  // Multiply each number up to n
        }
        return fact;  // Return the calculated factorial
    }

    // Executor to test the function
    public static void main(String[] args) {
        // Try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a non-negative integer to calculate its factorial: ");
            int n = scanner.nextInt();  // Read the input
            
            // Check if the input is valid (non-negative)
            if (n < 0) {
                System.out.println("Factorial is not defined for negative integers.");
            } else {
                // Display the factorial of the entered number
                System.out.println("Factorial of " + n + ": " + factorial(n));
            }
        } catch (Exception e) {
            // Handle any exceptions that may occur
            System.out.println("Invalid input! Please enter a valid non-negative integer.");
        }
    }
}
