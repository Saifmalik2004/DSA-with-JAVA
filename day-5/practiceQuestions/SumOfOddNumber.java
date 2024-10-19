// File: SumOfOddNumbers.java
public class SumOfOddNumber {
    // Function to calculate sum of odd numbers up to n
    public static int sumOddNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

    // Executor to test the function
    public static void main(String[] args) {
        int n = 15;
        System.out.println("Sum of odd numbers up to " + n + ": " + sumOddNumbers(n));
    }
}
