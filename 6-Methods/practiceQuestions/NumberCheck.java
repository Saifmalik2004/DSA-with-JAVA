import java.util.Scanner;

public class NumberCheck {

    // Function to check if a number is positive, negative, or zero
    public static String checkNumber(int num) {
        if (num > 0) {
            return "Positive";
        } else if (num < 0) {
            return "Negative";
        } else {
            return "Zero";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking a number as input
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        // Displaying if the number is positive, negative, or zero
        System.out.println("The number " + number + " is " + checkNumber(number));
    }
}
