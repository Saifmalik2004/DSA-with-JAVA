import java.util.Scanner;

public class Calculator {
    public static void calculator(double num1, double num2, char operator) {
        double result;

        switch (operator) {
            case '+' -> {
                result = num1 + num2;
                System.out.println("The result is: " + result);
            }
            case '-' -> {
                result = num1 - num2;
                System.out.println("The result is: " + result);
            }
            case '*' -> {
                result = num1 * num2;
                System.out.println("The result is: " + result);
            }
            case '/' -> {
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("The result is: " + result);
                } else {
                    System.out.println("Cannot divide by zero.");
                }
            }
            default -> System.out.println("Invalid operator.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers and an operator (+, -, *, /):");
        double number1 = sc.nextDouble();
        double number2 = sc.nextDouble();
        char operator = sc.next().charAt(0);
        calculator(number1, number2, operator);
        sc.close();
    }
}
