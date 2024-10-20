import java.util.Scanner;

public class SmallestNumber {

    // Function to find the smallest of three numbers
    public static int findSmallest(int num1, int num2, int num3) {
        // Using Math.min to find the smallest number
        return Math.min(num1, Math.min(num2, num3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking three numbers as input
        System.out.println("Enter the first number: ");
        int number1 = scanner.nextInt();

        System.out.println("Enter the second number: ");
        int number2 = scanner.nextInt();

        System.out.println("Enter the third number: ");
        int number3 = scanner.nextInt();

        // Displaying the smallest number
        System.out.println("The smallest number is: " + findSmallest(number1, number2, number3));
    }
}
