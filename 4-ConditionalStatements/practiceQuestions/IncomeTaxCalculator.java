import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        // Automatically close the Scanner resource
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter your income to calculate tax:");
            double income = sc.nextDouble(); // Read the income amount

            double tax;
            if (income <= 50000) {
                tax = income * 0.05; // 5% tax rate
            } else if (income <= 100000) {
                tax = income * 0.1; // 10% tax rate
            } else {
                tax = income * 0.2; // 20% tax rate
            }
            System.out.println("Your tax is: $" + tax); // Output calculated tax
        }
    }
}
