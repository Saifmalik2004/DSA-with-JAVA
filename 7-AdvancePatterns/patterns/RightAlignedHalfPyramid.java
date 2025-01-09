//output of this pattern is:
// * 
// * *
// * * *
// * * * *
// * * * * *
// * * * * * *
public class RightAlignedHalfPyramid {
    
    // Method to print a right-aligned half pyramid
    public static void printRightAlignedPyramid(int rows) {
        // Loop through each row
        for (int i = 1; i <= rows; i++) {
            // Inner loop to print spaces for alignment
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  "); // Print spaces for right alignment
            }
            // Inner loop to print '*' for the pyramid
            for (int j = 0; j < i; j++) {
                System.out.print("* "); // Print '*' for the pyramid
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        printRightAlignedPyramid(6); // Call the method with 6 rows
    }
}
