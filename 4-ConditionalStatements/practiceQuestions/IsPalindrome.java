import java.util.Scanner;

public class IsPalindrome {
    public static void main(String[] args) {
        // Automatically close Scanner after use
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a number to check if it's a palindrome:");
            int num = sc.nextInt(); // Read the input number

            int original = num, reverse = 0, remainder;
            while (num != 0) {
                remainder = num % 10; // Get last digit
                reverse = reverse * 10 + remainder; // Add last digit to reverse
                num /= 10; // Remove last digit from num
            }

            // Check if the original number matches the reverse
            if (original == reverse) {
                System.out.println(original + " is a palindrome.");
            } else {
                System.out.println(original + " is not a palindrome.");
            }
        }
    }
}
