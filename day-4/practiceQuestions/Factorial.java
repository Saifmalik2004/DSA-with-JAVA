import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        // Scanner will automatically close after try block
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number to find its factorial:");
            int num = sc.nextInt(); // Read the input number

            int fact = 1; // Initialize factorial variable
            for (int i = 1; i <= num; i++) {
                fact *= i; // Multiply fact by i
            }
            System.out.println("The factorial of " + num + " is: " + fact); // Output result
        }
    }
}
