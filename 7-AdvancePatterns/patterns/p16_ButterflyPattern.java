//output of this pattern is this:
// *             *
// * *         * *
// * * *     * * *
// * * * * * * * *
// * * * * * * * *
// * * *     * * *
// * *         * *
// *             *

public class p16_ButterflyPattern {
    
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
        printP(4); // Call the method with 6 rows
    }

public static void printP(int n) {

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i+1; j++) {
            System.out.print("* ");
        }
        for (int k = 0; k < 2*(n-(i+1)); k++) {
            System.out.print("  ");
        }
        for (int l = 0; l < i+1; l++) {
            System.out.print("* ");
        }
        System.out.println();
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n-i; j++) {
            System.out.print("* ");
        }
        for (int k = 0; k < 2*i; k++) {
            System.out.print("  ");
        }
        for (int l = 0; l < n-i; l++) {
            System.out.print("* ");
        }
        System.out.println();
    }
    
}

    
}
//output of this pattern is this:
// *             *
// * *         * *
// * * *     * * *
// * * * * * * * *
// * * * * * * * *
// * * *     * * *
// * *         * *
// *             *