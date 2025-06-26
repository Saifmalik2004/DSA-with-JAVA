/**
 * Expected Output for n = 5:
  
   *  *  *  *  *  *  *  *  *  * 
   *  *  *  *        *  *  *  * 
   *  *  *              *  *  * 
   *  *                    *  * 
   *                          * 
   *                          * 
   *  *                    *  * 
   *  *  *              *  *  * 
   *  *  *  *        *  *  *  * 
   *  *  *  *  *  *  *  *  *  * 
 */

 public class p10_SpaceDiamond {
    public static void spaceStarPattern(int n) {
        // Upper half of the pattern
        for (int i = 0; i < n; i++) {
            // Print left stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" * ");
            }
            // Print middle spaces
            for (int k = 1; k <= 2 * i; k++) {
                System.out.print("   ");
            }
            // Print right stars
            for (int l = 1; l <= n - i; l++) {
                System.out.print(" * ");
            }
            System.out.println(); // Print newline for the current row
        }
        
        // Lower half of the pattern
        for (int i = 1; i <= n; i++) {
            // Print left stars
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            // Print middle spaces
            for (int k = 1; k <= 2 * (n - i); k++) {
                System.out.print("   ");
            }
            // Print right stars
            for (int l = 1; l <= i; l++) {
                System.out.print(" * ");
            }
            System.out.println(); // Print newline for the current row
        }
    }

    public static void main(String[] args) {
        // Set the number of rows for the pattern
        int n = 20;

        // Call the method to print the pattern
        spaceStarPattern(n);
    }

    

}
