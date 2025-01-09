//output of this pattern is this:
// *             *
// * *         * *
// * * *     * * *
// * * * * * * * *
// * * * * * * * *
// * * *     * * *
// * *         * *
// *             *

public class ButterflyPattern {
    
    // Method to print a butterfly pattern
    public static void butterflyPattern(int n) {
        // Upper half of the butterfly
        for (int i = 1; i <= n; i++) {
            // Left wing (stars)
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // Print '*' for the left wing
            }
            // Middle spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  "); // Print spaces in the middle
            }
            // Right wing (stars)
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // Print '*' for the right wing
            }
            System.out.println(); // Move to the next line after finishing a row
        }

        // Lower half of the butterfly (inverted)
        for (int i = n; i >= 1; i--) {
            // Left wing (stars)
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // Print '*' for the left wing
            }
            // Middle spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  "); // Print spaces in the middle
            }
            // Right wing (stars)
            for (int j = 1; j <= i; j++) {
                System.out.print("* "); // Print '*' for the right wing
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        butterflyPattern(6); // Call the method with 6 rows
    }
}
