import java.util.Scanner; // Import the Scanner class for user input

/*
 * Explanation: The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones,
 * usually starting with 0 and 1.
 * For example, the sequence begins: 0, 1, 1, 2, 3, 5, 8, etc.
 */
public class Fibonacci {
    // Executor to test the function
    public static void main(String[] args) {
        // Try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt user for input
            System.out.print("Enter the number of terms in the Fibonacci sequence to display: ");
            int n = scanner.nextInt(); // Read the number of terms
            
            // Check if the input is valid (greater than 0)
            if (n <= 0) {
                System.out.println("Please enter a positive integer greater than 0.");
            } else {
                // Print the first two numbers of the Fibonacci sequence
                int a = 0, b = 1;
                System.out.print(a + " " + b + " ");
                
                // Generate and print the Fibonacci sequence up to n terms
                for (int i = 3; i <= n; i++) {
                    int next = a + b; // Calculate next Fibonacci number
                    System.out.print(next + " "); // Print the next number
                    a = b; // Update a and b for the next iteration
                    b = next;
                }
            }
        } catch (Exception e) {
            // Handle invalid input by displaying an error message
            System.out.println("Invalid input! Please enter a valid integer.");
        }
    }
}
