import java.util.Scanner; // Import the Scanner class for user input

// File: SumOfOddNumbers.java
public class SumOfOddNumber {
    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a number N to calculate the sum of odd numbers up to N: ");
            int n = scanner.nextInt(); // Read the input
            
            int sum = 0; // Initialize sum to zero
            for (int i = 1; i <= n; i += 2) {
                sum += i; // Add odd numbers to the sum
            }
            // Display the result
            System.out.println("Sum of odd numbers up to " + n + ": " + sum);
        }
    }
}
