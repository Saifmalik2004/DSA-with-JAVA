import java.util.Scanner;

public class CheckPassOrFail {
    public static void checkPassOrFail(int marks) {
        switch (marks / 10) {
            case 10, 9 -> System.out.println("Grade: A");
            case 8 -> System.out.println("Grade: B");
            case 7 -> System.out.println("Grade: C");
            case 6 -> System.out.println("Grade: D");
            default -> System.out.println("Fail");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your marks to check if you pass or fail:");
        int marks = sc.nextInt();
        checkPassOrFail(marks);
        sc.close();
    }
}
