

public class HollowDiamond {
    public static void starPattern(int n) {
        // Upper half
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int k = 1; k <= n - i; k++) {
                System.out.print("   ");
            }
            // Print the first star
            System.out.print(" * ");
            // Print spaces inside the diamond
            for (int k = 1; k < 2 * (i - 1); k++) {
                System.out.print("   ");
            }
            // Print the second star (only if it's not the first row)
            if (i != 1) {
                System.out.print(" * ");
            }
            System.out.println(); // Move to the next row
        }
    
        // Lower half
        for (int i = 1; i < n; i++) {
            // Print leading spaces
            for (int k = 1; k <= i; k++) {
                System.out.print("   ");
            }
            // Print the first star
            System.out.print(" * ");
            // Print spaces inside the diamond
            for (int k = 1; k < 2 * (n - i - 1); k++) {
                System.out.print("   ");
            }
            // Print the second star (only if it's not the last row)
            if (i != n - 1) {
                System.out.print(" * ");
            }
            System.out.println(); // Move to the next row
        }
    }

    public static void main(String[] args) {
        starPattern(5);
    }
}
