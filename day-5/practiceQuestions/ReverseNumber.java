import java.util.Scanner; // Import the Scanner class for user input

// Explanation: Reversing a number involves reversing its digits. 
// For example, the reverse of 12345 is 54321. This can be done by extracting the last digit repeatedly.
public class ReverseNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number to reverse: "); // Prompt user for input
            int num = scanner.nextInt(); // Read the input
            
            int reversed = 0; // Variable to store the reversed number
            // Reverse the number by extracting digits
            while (num != 0) {
                int digit = num % 10; // Get the last digit
                reversed = reversed * 10 + digit; // Build the reversed number
                num /= 10; // Remove the last digit
            }
            System.out.println("Reversed number: " + reversed); // Display the reversed number
        }
    }
}