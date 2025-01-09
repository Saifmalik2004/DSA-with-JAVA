public class Fibonacci {

    // Method to calculate the nth Fibonacci number
    public static int fibonacci(int n) {
        // Handle invalid input
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci sequence is not defined for negative numbers");
        }

        // Base cases: return n if it is 0 or 1
        if (n == 1 || n == 0) {
            return n;
        }

        // Recursive case: sum of the previous two Fibonacci numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        // Calculate the 5th Fibonacci number and print the result
        int result = fibonacci(5);
        System.out.println("5th Fibonacci number is: " + result);
    }
}
