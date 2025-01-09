import java.util.Scanner;

public class OddOrEven {
    public static void main(String[] args) {
        // Close Scanner automatically after use
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number to check if it's odd or even:");
            int num = sc.nextInt(); // Read the number input

            // Determine if the number is odd or even and print the result
            if (num % 2 == 0) {
                System.out.println(num + " is Even.");
            } else {
                System.out.println(num + " is Odd.");
            }
        }
    }
}
