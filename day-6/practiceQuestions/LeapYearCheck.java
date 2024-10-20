import java.util.Scanner;

public class LeapYearCheck {

    // Function to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        // A leap year is divisible by 4, but not divisible by 100 unless divisible by 400
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking a year as input
        System.out.println("Enter a year: ");
        int year = scanner.nextInt();

        // Displaying whether the year is a leap year or not
        if (isLeapYear(year)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}
