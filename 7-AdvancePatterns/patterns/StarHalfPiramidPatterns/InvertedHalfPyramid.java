//Output of this pattern is:
// * * * * * * 
// * * * * *
// * * * *
// * * *
// * *
// *

public class InvertedHalfPyramid {
    
    // Method to print an inverted half pyramid
    public static void printInvertedHalfPyramid(int rows) {
        // Loop through each row
        for (int i = 1; i <= rows; i++) {
            // Inner loop to print '*' for each column in the row
            for (int j = 0; j < rows - i + 1; j++) {
                System.out.print("* "); // Print '*' for the inverted pyramid
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        printInvertedHalfPyramid(6); // Call the method with 6 rows
    }
}
