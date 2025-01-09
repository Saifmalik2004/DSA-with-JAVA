import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        // Automatically close Scanner with try-with-resources
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter first numbers:");
            int num1 = sc.nextInt(); // Read first number
            System.out.println("Enter second numbers:");
            int num2 = sc.nextInt(); // Read second number
            System.out.println("Enter third numbers:");
            int num3 = sc.nextInt(); // Read third number

            // Determine and print the largest number
            if (num1 >= num2 && num1 >= num3) {
                System.out.println("The largest number is: " + num1);
            } else if (num2 >= num1 && num2 >= num3) {
                System.out.println("The largest number is: " + num2);
            } else {
                System.out.println("The largest number is: " + num3);
            }
        }
    }
}
