// Explanation: The sum of digits of a number is simply adding all the individual digits together. For example, for the number 1234, the sum is 1 + 2 + 3 + 4 = 10.
public class SumOfDigits {
    // Function to calculate the sum of digits of a number
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;  // Add the last digit to the sum
            number /= 10;  // Remove the last digit from the number
        }
        return sum;
    }

    // Executor to test the function
    public static void main(String[] args) {
        int num = 1234;
        System.out.println("Sum of digits of " + num + ": " + sumOfDigits(num));
    }
}
