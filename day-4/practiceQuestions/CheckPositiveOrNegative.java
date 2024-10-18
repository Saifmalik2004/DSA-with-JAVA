import java.util.Scanner;

public class CheckPositiveOrNegative {
    public static void checkPositiveOrNegative(int num) {
        String result = (num >= 0) ? "Positive" : "Negative";
        System.out.println(num + " is " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check if it's positive or negative:");
        int num = sc.nextInt();
        checkPositiveOrNegative(num);
        sc.close();
    }
}
