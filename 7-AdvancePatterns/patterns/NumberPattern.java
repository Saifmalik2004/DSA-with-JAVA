/**
 * Generates a concentric number pattern for a given `n`.
 *
 * Example for n = 4:
 * 4444444
 * 4333334
 * 4322234
 * 4321234
 * 4322234
 * 4333334
 * 4444444
 */

 public class NumberPattern {

    /**
     * Generates and prints the number pattern based on the given `n`.
     *
     * @param n The size of the pattern.
     */
    public static void getNumberPattern(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                // Calculate the minimum distance from any edge
                int top = i;
                int left = j;
                int right = (2 * n - 2) - j;
                int down = (2 * n - 2) - i;

                // Determine the value to print
                System.out.print(n - Math.min(Math.min(top, down), Math.min(left, right)));
            }
            System.out.println(); // Move to the next line
        }
    }

    public static void main(String[] args) {
        // Test the pattern with a given size
        int n = 4;
        getNumberPattern(n);
    }
}
