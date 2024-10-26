import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        // Use try-with-resources to close Scanner automatically
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a number to check if it's prime:");
            int num = sc.nextInt(); // Read the number input

            boolean prime = true;
            if (num < 2) {
                prime = false; // Numbers less than 2 are not prime
            } else {
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        prime = false;
                        break; // Exit loop if a factor is found
                    }
                }
            }

            // Output if the number is prime or not
            if (prime) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is not a prime number.");
            }
        }
    }
}
