import java.util.Scanner; // Import the Scanner class for user input

// Explanation: Reversing a number involves reversing its digits. 
// For example, the reverse of 12345 is 54321. This can be done by extracting the last digit repeatedly.
public class ReverseNumber {
    // Function to reverse the digits of a number
    public static int reverseNumber(int number) {
        int reversed = 0;
        // Reverse the number by extracting digits
        while (number != 0) {
            int digit = number % 10;  // Get the last digit
            reversed = reversed * 10 + digit;  // Append the digit in reverse order
            number /= 10;  // Remove the last digit from the number
        }
        return reversed;  // Return the reversed number
    }

    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter a number to reverse: ");
            int num = scanner.nextInt();  // Read the input
            
            // Display the original and reversed number
            System.out.println("Original Number: " + num);
            System.out.println("Reversed Number: " + reverseNumber(num));
        }
    }
}
