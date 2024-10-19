import java.util.Scanner; // Import the Scanner class for user input

/*
 * Explanation: The GCD (Greatest Common Divisor) is the largest number that divides two or more numbers without leaving a remainder.
 * For example, the GCD of 48 and 18 is 6.
 */
public class GCD {
    // Function to calculate the GCD of two numbers
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b; 
            b = a % b;  // Update b to the remainder of a divided by b
            a = temp;  // Update a to the previous b
        }
        return a;  // When b becomes 0, a is the GCD
    }

    // Executor to test the function
    public static void main(String[] args) {
        // Try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt(); // Read the first number
            
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt(); // Read the second number
            
            // Calculate and display the GCD
            System.out.println("GCD of " + num1 + " and " + num2 + ": " + gcd(num1, num2));
        } catch (Exception e) {
            // Handle invalid input by displaying an error message
            System.out.println("Invalid input! Please enter valid integers.");
        }
    }
}
