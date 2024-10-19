import java.util.Scanner; // Import the Scanner class

// Explanation: A prime number is a natural number greater than 1 that cannot be formed by multiplying two smaller natural numbers.
// In other words, a prime number has only two factors: 1 and itself.

public class CheckPrime {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Create a Scanner object to read input
            System.out.print("Enter a number: "); // Prompt user for input
            int number = scanner.nextInt(); // Read the number from user input
            
            if (number <= 1) {
                System.out.println(number + " is prime: false");  // Numbers less than 2 are not prime
            } else {
                boolean isPrime = true; // Assume the number is prime
                for (int i = 2; i <= Math.sqrt(number); i++) {  // Check divisibility
                    if (number % i == 0) {
                        isPrime = false; // If divisible, not prime
                        break;
                    }
                }
                System.out.println(number + " is prime: " + isPrime); // Display the result
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid integers.");
        }
    }
}