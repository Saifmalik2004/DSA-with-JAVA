import java.util.Scanner;

public class CheckPositiveOrNegative {
    public static void main(String[] args) {
        // Use try-with-resources for automatic Scanner closure
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number to check if it's positive or negative:");
            int num = sc.nextInt(); // Read the number input

            // Check if the number is positive or negative using a ternary operator
            String result = (num >= 0) ? "Positive" : "Negative";
            System.out.println(num + " is " + result); // Print the result
        }
    }
}
