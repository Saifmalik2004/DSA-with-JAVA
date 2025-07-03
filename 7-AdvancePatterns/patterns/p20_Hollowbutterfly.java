public class p20_Hollowbutterfly {
    public static void main(String[] args) {
        printPattern(4);
    }

    public static void printPattern(int n) {
        // Upper Half
        for (int i = 1; i <= n; i++) {
            // Left wing
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }

            // Center space between wings
            for (int k = 1; k <= 2 * (n - i); k++) {
                System.out.print("  ");
            }

            // Right wing (mirror of left)
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }

            System.out.println();
        }

        // Lower Half
        for (int i = n; i >= 1; i--) {
            // Left wing
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }

            // Center space between wings
            for (int k = 1; k <= 2 * (n - i); k++) {
                System.out.print("  ");
            }

            // Right wing (mirror of left)
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }

            System.out.println();
        }
    }
}

/*
Output when n = 4:

*             * 
* *         * * 
*   *     *   * 
*     * *     * 
*     * *     * 
*   *     *   * 
* *         * * 
*             * 
*/
