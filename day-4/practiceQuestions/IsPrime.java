import java.util.Scanner;

public class IsPrime {
    public static void isPrime(int num) {
        boolean prime = true;
        if (num < 2) {
            prime = false;
        } else {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }
        }
        if (prime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check if it's prime:");
        int num = sc.nextInt();
        isPrime(num);
        sc.close();
    }
}
