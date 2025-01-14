import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner for input
        System.out.print("Enter a number: ");
        int number = Math.abs(scanner.nextInt()); // Get absolute value of the number
        int count = 0;

        do {
            count++;
            number /= 10; // Remove last digit
        } while (number != 0);

        System.out.println("Number of digits: " + count); // Display the count
    }
}
