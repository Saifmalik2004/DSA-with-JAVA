import java.util.Scanner;

public class CheckPassOrFail {
    public static void checkPassOrFail(int marks) {
        switch (marks / 10) {
            case 9: case 10:
                System.out.println("Grade: A");
                break;
            case 8:
                System.out.println("Grade: B");
                break;
            case 7:
                System.out.println("Grade: C");
                break;
            case 6:
                System.out.println("Grade: D");
                break;
            default:
                System.out.println("Fail");
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
