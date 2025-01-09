import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the scanner
        try (Scanner sc = new Scanner(System.in)) {
            // Prompt the user to enter two numbers and an operator
            System.out.println("Enter two numbers and an operator (+, -, *, /):");
            
            System.out.print("Enter First numbers :");
            // Read the first number input from the user
            double num1 = sc.nextDouble();

            System.out.print("Enter Second numbers :");
            // Read the second number input from the user
            double num2 = sc.nextDouble();

            System.out.print("Enter operator numbers :");
            // Read the operator input from the user
            char operator = sc.next().charAt(0);

            // Variable to store the result of the calculation
            double result;

            String resultstr="The result is : ";
            // Use a switch statement to perform the correct operation based on the operator
            
            switch (operator) {
                // If the operator is '+', add num1 and num2
                case '+' -> {
                    result = num1 + num2;
                    System.out.println(resultstr + result);
                }
                // If the operator is '-', subtract num2 from num1
                case '-' -> {
                    result = num1 - num2;
                    System.out.println(resultstr + result);
                }
                // If the operator is '*', multiply num1 and num2
                case '*' -> {
                    result = num1 * num2;
                    System.out.println(resultstr + result);
                }
                // If the operator is '/', divide num1 by num2 (if num2 is not zero)
                case '/' -> {
                    if (num2 != 0) { // Check if the divisor is not zero
                        result = num1 / num2;
                        System.out.println(resultstr + result);
                    } else {
                        System.out.println("Cannot divide by zero."); // Error message if division by zero
                    }
                }
                // If an invalid operator is entered, show an error message
                default -> System.out.println("Invalid operator.");
            }
        } // Scanner automatically closed here
    }
}
