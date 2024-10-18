import java.util.Scanner;

public class IsPalindrome {
    public static void isPalindrome(int num) {
        int original = num, reverse = 0, remainder;
        while (num != 0) {
            remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num /= 10;
        }
        if (original == reverse) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to check if it's a palindrome:");
        int num = sc.nextInt();
        isPalindrome(num);
        sc.close();
    }
}
