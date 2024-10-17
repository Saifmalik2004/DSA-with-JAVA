// AssignmentOperator.java
public class AssignmentOperator {
    public static void main(String[] args) {
        int x = 10;

        // Assign
        System.out.println("Assign: " + (x));

        // Add and assign
        x += 5; // equivalent to x = x + 5
        System.out.println("Add and assign (x += 5): " + x);

        // Subtract and assign
        x -= 3; // equivalent to x = x - 3
        System.out.println("Subtract and assign (x -= 3): " + x);
    }
}
