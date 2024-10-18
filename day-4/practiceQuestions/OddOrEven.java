import java.util.Scanner;

public class OddOrEven {
    public static void oddOrEven(int num) {
        if (num % 2 == 0) {
            System.out.println(num + " is Even.");
        } else {
            System.out.println(num + " is Odd.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check if it's odd or even:");
        int num = sc.nextInt();
        oddOrEven(num);
        sc.close();
    }
}
