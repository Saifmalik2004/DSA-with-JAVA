import java.util.Scanner;

public class PrimeNumbersInRange {
    public static void main(String[] args) {
        // Prompt the user to enter the upper limit for the range
        try ( // Create a Scanner object to read input from the user
                Scanner sc = new Scanner(System.in)) {
            // Prompt the user to enter the upper limit for the range
            System.out.println("Enter the ending number of the range (starting from 1):");
            int end = sc.nextInt();
            // Display a message showing the range of prime numbers that will be printed
            System.out.println("Prime numbers between 1 and " + end + " are:");
            // Loop through each number from 1 to the user-defined end
            for (int i = 1; i <= end; i++) {
                boolean isPrime = true; // Assume the current number i is prime
                
                // Check if i is less than 2, which is not a prime number
                if (i < 2) {
                    isPrime = false;
                } else {
                    // Loop from 2 to half of i to check if any number divides i
                    for (int j = 2; j <= i / 2; j++) {
                        // If i is divisible by j, it is not prime
                        if (i % j == 0) {
                            isPrime = false; // Set isPrime to false if a divisor is found
                            break; // Exit the loop since we found a divisor
                        }
                    }
                }
                
                // If isPrime is still true, i is a prime number
                if (isPrime) {
                    System.out.println(i); // Print the prime number
                }
            }
           
        }
    }
}
