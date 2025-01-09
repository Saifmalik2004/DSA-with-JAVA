import java.util.Scanner; // Import the Scanner class for user input

/*
 * Explanation: The GCD (Greatest Common Divisor) is the largest number that divides two or more numbers without leaving a remainder.
 * For example, the GCD of 48 and 18 is 6.
 */

 public class GCD {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first number: "); // Prompt user for input
            int num1 = scanner.nextInt(); // Read the first number
            
            System.out.print("Enter second number: "); // Prompt user for input
            int num2 = scanner.nextInt(); // Read the second number
            
            int a = num1; 
            int b = num2;
            while (b != 0) {
                int temp = b; 
                b = a % b;  // Update b to the remainder of a divided by b
                a = temp;  // Update a to the previous b
            }
            System.out.println("GCD of " + num1 + " and " + num2 + ": " + a); // Display the GCD
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid integers.");
        }
    }
}