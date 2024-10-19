import java.util.Scanner; // Import the Scanner class

// Explanation: A prime number is a natural number greater than 1 that cannot be formed by multiplying two smaller natural numbers.
// In other words, a prime number has only two factors: 1 and itself.
public class CheckPrime {
    // Function to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;  // Numbers less than 2 are not prime
        for (int i = 2; i <= Math.sqrt(number); i++) {  // Check divisibility
            if (number % i == 0) return false;  // If divisible, not prime
        }
        return true;  // If not divisible by any number, it is prime
    }

    // Executor to test the function
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in) // Create a Scanner object to read input
        ) {
            System.out.print("Enter a number: "); // Prompt user for input
            int num = scanner.nextInt(); // Read the number from user input
            System.out.println(num + " is prime: " + isPrime(num)); // Check if the number is prime
            // Close the scanner to prevent resource leaks
        } // Prompt user for input
    }
}
