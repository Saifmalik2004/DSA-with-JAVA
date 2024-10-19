import java.util.Scanner; // Import the Scanner class

// Explanation: Counting the number of digits in a number can be done by repeatedly dividing the number by 10 until it becomes 0.

public class CountDigits {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Create a Scanner object to read input
            System.out.print("Enter a number: "); // Prompt user for input
            int number = scanner.nextInt(); // Read the number from user input
            
            // Check for negative numbers
            if (number < 0) {
                number = -number; // Convert to positive for digit count
            }
            
            int count = 0; // Initialize count
            while (number != 0) {
                count++;  // Increment count for each digit
                number /= 10;  // Remove the last digit
            }
            System.out.println("Number of digits: " + count); // Display the digit count
        }
    }
}