import java.util.Scanner;

public class FindAverage {

    // Function to calculate the average of three numbers
    public static double calculateAverage(int num1, int num2, int num3) {
        return (num1 + num2 + num3) / 3.0; // Calculate average and return
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

        // Displaying the calculated average
        System.out.println("The average of the three numbers is: " + calculateAverage(number1, number2, number3));
    }
}
