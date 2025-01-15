import java.util.Scanner; // Import the Scanner class for user input

// Explanation: The sum of digits of a number is simply adding all the individual digits together. 
// For example, for the number 1234, the sum is 1 + 2 + 3 + 4 = 10.
public class SumOfDigits {
    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a number to calculate the sum of its digits: ");
            int number = scanner.nextInt(); // Read the input
            
            int sum = 0; // Initialize sum to zero
            while (number != 0) {
                sum += number % 10; // Add the last digit to the sum
                number /= 10; // Remove the last digit from the number
            }
            // Display the result
            System.out.println("Sum of digits: " + sum);
        }
    }
}
