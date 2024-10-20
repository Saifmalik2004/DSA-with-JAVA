import java.util.Scanner;

public class SimpleInterest {

    // Function to calculate simple interest
    public static double calculateInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100; // Formula for simple interest
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for principal, rate, and time
        System.out.println("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        System.out.println("Enter the rate of interest: ");
        double rate = scanner.nextDouble();

        System.out.println("Enter the time (in years): ");
        double time = scanner.nextDouble();

        // Displaying the calculated simple interest
        System.out.println("The simple interest is: " + calculateInterest(principal, rate, time));
    }
}
