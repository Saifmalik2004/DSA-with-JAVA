//output of this pattern is:
//           * * * * * * 
//         *         *
//       *         *
//     *         *
//   *         *
// * * * * * *
public class p12_HollowRhombus {
    
    // Method to print the hollow rhombus pattern
    public static void hollowRohmbas(int rows) {
        int cols = rows; // Number of columns is equal to the number of rows (square shape)
        
        // Loop for each row
        for (int i = 1; i <= rows; i++) {
            // Print leading spaces for alignment
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  "); // Two spaces for proper alignment
            }

            // Loop for each column in the current row
            for (int j = 1; j <= rows; j++) {
                // Print '*' for the first and last rows, first column, or last column
                if (i == 1 || i == rows || j == 1 || j == cols) {
                    System.out.print("* "); // Print the star with a trailing space
                } else {
                    // Print space for the hollow part of the rhombus
                    System.out.print("  ");
                }
            }
            
            // Move to the next line after printing the current row
            System.out.println();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Call the method with 6 rows
        hollowRohmbas(6);
    }
}
