// UnaryOperator.java
public class UnaryOperator {
    public static void main(String[] args) {
        int x = 10;

        // Unary plus
        System.out.println("Unary plus: " + (+x));

        // Unary minus
        System.out.println("Unary minus: " + (-x));

        // Increment operator
        System.out.println("Increment operator (x++): " + (x++)); // Post-increment
        System.out.println("After post-increment, x: " + x); // x is now 11

        // Decrement operator
        System.out.println("Decrement operator (--x): " + (--x)); // Pre-decrement
        System.out.println("After pre-decrement, x: " + x); // x is now 10
    }
}
