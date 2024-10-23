import java.util.Scanner;

public class SmallestNumber {

    // Function to find the smallest of three numbers
    public static int findSmallest(int num1, int num2, int num3) {
        int smallest = num1; // Assume num1 is the smallest
    
        if (num2 < smallest) {
            smallest = num2; // Update if num2 is smaller
        }
        
        if (num3 < smallest) {
            smallest = num3; // Update if num3 is smaller
        }
        
        return smallest; // Return the smallest number
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
