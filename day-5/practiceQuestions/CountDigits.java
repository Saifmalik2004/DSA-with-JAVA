import java.util.Scanner; // Import the Scanner class

// Explanation: Counting the number of digits in a number can be done by repeatedly dividing the number by 10 until it becomes 0.

public class CountDigits {
    // Function to count the number of digits in a number
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;  // Increment count for each digit
            number /= 10;  // Remove the last digit
        }
        return count;
    }

    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in) // Create a Scanner object to read input
        ) {
            System.out.print("Enter a number: "); // Prompt user for input
            int num = scanner.nextInt(); // Read the number from user input
            // Check for negative numbers
            if (num < 0) {
                num = -num; // Convert to positive for digit count
            }   System.out.println("Number of digits in " + num + ": " + countDigits(num));
            // Close the scanner to prevent resource leaks
        } 
    }
}
