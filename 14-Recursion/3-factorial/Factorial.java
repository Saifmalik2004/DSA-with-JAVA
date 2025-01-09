public class Factorial {

    // Method to calculate the factorial of a given number n
    public static int factorial(int n) {
        // Base case: if n is 1, return 1 since factorial of 1 is 1
        if (n == 1) {
            return 1;
        }
        
        // Recursive case: multiply n by the factorial of (n - 1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        // Calculate the factorial of 5 and print the result
        int result = factorial(5);
        System.out.println("Factorial of 5 is: " + result);
    }
}
