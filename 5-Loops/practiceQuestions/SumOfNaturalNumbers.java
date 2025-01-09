import java.util.Scanner; // Import the Scanner class for user input

/*
 * Explanation: 
 * Natural numbers are positive integers starting from 1. 
 * The sum of the first N natural numbers can be found using the formula 
 * n(n + 1) / 2 or by adding each number from 1 to N.
 */
public class SumOfNaturalNumbers {
    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a number N to calculate the sum of the first N natural numbers: ");
            int n = scanner.nextInt(); // Read the input
            
            int sum = 0; // Initialize sum to zero
            for (int i = 1; i <= n; i++) {
                sum += i; // Add each natural number to the sum
            }
            // Display the result
            System.out.println("Sum of first " + n + " natural numbers: " + sum);
        }
    }
}
