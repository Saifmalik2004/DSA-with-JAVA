import java.util.Scanner;

// Parent class (Calculator)
class Calculator {

    // Method Overloading (Addition)
    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    // Method Overloading (Subtraction)
    public double subtract(double a, double b) {
        return a - b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    // Method Overloading (Multiplication)
    public double multiply(double a, double b) {
        return a * b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    // Method Overloading (Division)
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Integer.MIN_VALUE;
        }
        return a / b;
    }
}

// Child class (AdvancedCalculator) extending Calculator
class AdvancedCalculator extends Calculator {

    // Overriding the add method (polymorphism)
    @Override
    public double add(double a, double b) {
        System.out.println("Advanced Add Method: Adding two doubles");
        return super.add(a, b);  // Call parent method
    }

    @Override
    public int add(int a, int b) {
        System.out.println("Advanced Add Method: Adding two integers");
        return super.add(a, b);  // Call parent method
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        // Create an instance of AdvancedCalculator (demonstrating polymorphism)
        Calculator calc = new AdvancedCalculator();

        try ( // Create a scanner object for taking user input
                Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Java Polymorphic Calculator!");
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.print("\nEnter choice (1/2/3/4): ");
            int choice = scanner.nextInt();
            double result = 0;
            switch (choice) {
                case 1 -> {
                    result = calc.add(num1, num2);  // Polymorphic call
                    System.out.println("Result: " + result);
                }
                case 2 -> {
                    result = calc.subtract(num1, num2);
                    System.out.println("Result: " + result);
                }
                case 3 -> {
                    result = calc.multiply(num1, num2);
                    System.out.println("Result: " + result);
                }
                case 4 -> {
                    result = calc.divide(num1, num2);
                    if (!Double.isNaN(result)) {
                        System.out.println("Result: " + result);
                    }
                }
                default -> System.out.println("Invalid choice! Please enter a valid operation.");
            }
            
        }
    }
}
