import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void incomeTaxCalculator(double income) {
        double tax;
        if (income <= 50000) {
            tax = income * 0.05;  // 5% tax
        } else if (income <= 100000) {
            tax = income * 0.1;   // 10% tax
        } else {
            tax = income * 0.2;   // 20% tax
        }
        System.out.println("Your tax is: $" + tax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your income to calculate tax:");
        double income = sc.nextDouble();
        incomeTaxCalculator(income);
        sc.close();
    }
}
