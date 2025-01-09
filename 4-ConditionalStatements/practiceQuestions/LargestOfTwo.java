import java.util.Scanner;

public class LargestOfTwo {
    public static void main(String[] args) {
        // Automatically close Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter two numbers:");
            int num1 = sc.nextInt(); // Read first number
            int num2 = sc.nextInt(); // Read second number

            // Check and display which number is larger, or if they're equal
            if (num1 > num2) {
                System.out.println("The largest number is: " + num1);
            } else if (num2 > num1) {
                System.out.println("The largest number is: " + num2);
            } else {
                System.out.println("Both numbers are equal.");
            }
        }
    }
}
