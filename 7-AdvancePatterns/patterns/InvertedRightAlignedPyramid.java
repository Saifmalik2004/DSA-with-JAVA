//output of this pattern is:
// * * * * * * 
//   * * * * *
//     * * * *
//       * * *
//         * *
//           *
public class InvertedRightAlignedPyramid {
    
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
        printInvertedRightAlignedPyramid(6); // Call the method with 6 rows
    }
}
