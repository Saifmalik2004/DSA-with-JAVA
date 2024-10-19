    /*
     * Explanation: 
     * Natural numbers are positive integers starting from 1. 
     * The sum of the first N natural numbers can be found using the formula 
     * n(n + 1) / 2 or by adding each number from 1 to N.
     */
public class SumOfNaturalNumbers {
    // Function to calculate the sum of first n natural numbers
    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;  // Add each natural number to the sum
        }
        return sum;
    }

    // Executor to test the function
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Sum of first " + n + " natural numbers: " + sumOfNaturalNumbers(n));
    }
}
