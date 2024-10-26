import java.util.Scanner;

public class CheckPassOrFail {
    public static void main(String[] args) {
        // Automatically close the Scanner after use
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter your marks to check if you pass or fail:");
            int marks = sc.nextInt(); // Input the marks

            // Determine grade based on marks
            switch (marks / 10) {
                case 10, 9 -> System.out.println("Grade: A");
                case 8 -> System.out.println("Grade: B");
                case 7 -> System.out.println("Grade: C");
                case 6 -> System.out.println("Grade: D");
                default -> System.out.println("Fail"); // Below 60 is a fail
            }
        } // Scanner auto-closes here
    }
}
