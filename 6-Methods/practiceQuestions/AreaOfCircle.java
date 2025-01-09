import java.util.Scanner;

public class AreaOfCircle {

    // Function to calculate the area of a circle
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius; // Formula for area of a circle
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking the radius as input
        System.out.println("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        // Displaying the area of the circle
        System.out.println("The area of the circle is: " + calculateArea(radius));
    }
}