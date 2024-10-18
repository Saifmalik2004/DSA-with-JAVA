import java.util.Scanner;

public class PrimeNumbersInRange {

    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to print all prime numbers in the range from 1 to end
    public static void primeNumbersInRange(int end) {
        System.out.println("Prime numbers between 1 and " + end + " are:");
        for (int i = 1; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ending number of the range (starting from 1):");
        int end = sc.nextInt();

        primeNumbersInRange(end);
        sc.close();
    }
}
