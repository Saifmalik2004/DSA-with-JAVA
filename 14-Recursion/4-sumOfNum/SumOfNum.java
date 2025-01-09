public class SumOfNum {

    // Method to calculate the sum of numbers from 1 to n
    public static int sumOfNum(int n) {
        // Base case: if n is 1, return 1 since sum of first 1 number is 1
        if (n == 1) {
            return 1;
        }
        
        // Recursive case: add n to the sum of numbers from 1 to (n-1)
        return n + sumOfNum(n - 1);
    }

    public static void main(String[] args) {
        // Calculate the sum of numbers from 1 to 5 and print the result
        int result = sumOfNum(5);
        System.out.println("Sum of numbers from 1 to 5 is: " + result);
    }
}
