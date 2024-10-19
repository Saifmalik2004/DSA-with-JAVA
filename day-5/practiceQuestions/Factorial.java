import java.util.Scanner; // Import the Scanner class for user input

/*
 * Explanation: The factorial of a non-negative integer N is the product of all positive integers less than or equal to N.
 * It is denoted by N!.
 * For example, 5! = 5 × 4 × 3 × 2 × 1 = 120.
 */
public class Factorial {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a non-negative integer to calculate its factorial: "); // Prompt user for input
            int n = scanner.nextInt(); // Read the input
            
            // Check if the input is valid (non-negative)
            if (n < 0) {
                System.out.println("Factorial is not defined for negative integers.");
            } else {
                int fact = 1;  // Initialize factorial to 1
                // Loop to calculate factorial
                for (int i = 2; i <= n; i++) {
                    fact *= i;  // Multiply each number up to n
                }
                System.out.println("Factorial of " + n + ": " + fact); // Display the factorial
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid non-negative integer.");
        }
    }
}