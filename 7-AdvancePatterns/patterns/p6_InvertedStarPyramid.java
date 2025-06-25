/*
Output of this pattern (for row = 6):

* * * * * * * * * * * 
  * * * * * * * * * 
    * * * * * * * 
      * * * * * 
        * * * 
          * 

*/

public class p6_InvertedStarPyramid {

    // Method to print an inverted full pyramid of stars
    public static void printP(int row) {
        
        // Loop through each row
        for (int i = 0; i < row; i++) {

            // Print leading spaces (double space for alignment)
            for (int k = 0; k < i; k++) {
                System.out.print("  ");
            }

            // Print decreasing stars (2*(row - i) - 1 stars per row)
            for (int j = 0; j < 2 * (row - i) - 1; j++) {
                System.out.print("* ");
            }

            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printP(6); // Calling the method with 6 rows
    }
}
