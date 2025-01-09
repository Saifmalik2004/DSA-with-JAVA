// Explanation: An Armstrong number (or narcissistic number) is a number that is equal to the sum of its own digits raised to the power of the number of digits.
// For example, 153 is an Armstrong number because 1^3 + 5^3 + 3^3 = 153.

import java.util.Scanner; // Import the Scanner class for user input

public class ArmstrongNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: "); // Prompt user for input
            int number = scanner.nextInt(); // Read the number from user input
            
            int original = number;  // Store the original number for comparison
            int sum = 0;  // Initialize sum to store the sum of powers of digits
            int n = String.valueOf(number).length();  // Get the number of digits

            // Loop to calculate the sum of digits raised to the power of the number of digits
            while (number != 0) {
                int digit = number % 10;  // Get the last digit
                sum += Math.pow(digit, n);  // Add the digit raised to the power of n
                number /= 10;  // Remove the last digit
            }
            // Check if the original number is equal to the sum
            System.out.println(original + " is Armstrong: " + (original == sum));
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid integer.");
        }
    }
}
