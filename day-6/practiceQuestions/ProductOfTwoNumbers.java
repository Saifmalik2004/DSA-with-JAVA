import java.util.Scanner;

public class ProductOfTwoNumbers {

    // Function to return the product of two numbers
    public static int multiply(int num1, int num2) {
        return num1 * num2; // multiply the two  numbers and return
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking two numbers as input
        System.out.println("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.println("Enter the second number: ");
        int number2 = scanner.nextInt();

        // Displaying the Product of the two numbers
        System.out.println("The Product of " + number1 + " and " + number2 + " is: " + multiply(number1, number2));
    }
}
