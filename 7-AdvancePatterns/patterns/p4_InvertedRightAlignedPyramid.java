//output of this pattern is:
// * * * * * * 
//   * * * * *
//     * * * *
//       * * *
//         * *
//           *
public class p4_InvertedRightAlignedPyramid {
    
    // Method to print an inverted right-aligned half pyramid
    public static void printInvertedRightAlignedPyramid(int rows) {
        // Loop through each row
        for (int i = 1; i <= rows; i++) {
            // Inner loop to print spaces for alignment
            for (int j = 0; j < i; j++) {
                System.out.print("  "); // Print spaces for right alignment
            }
            // Inner loop to print '*' for the inverted pyramid
            for (int j = 0; j < rows - i + 1; j++) {
                System.out.print("* "); // Print '*' for the pyramid
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        printP(6); // Call the method with 6 rows
    }

    public static void printP(int row) {

        for (int i = 0; i <row; i++) {
            
            for (int j = 0; j < i; j++) {
                System.err.print("  ");
            }
            for (int k = 0; k < row-i; k++) {
                System.out.print("* ");
            }
            System.out.println();

        }
        
    }
}
