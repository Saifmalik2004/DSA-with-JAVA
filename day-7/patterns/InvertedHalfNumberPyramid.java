//output of this pattern is:
// 1 2 3 4 5 6 
// 1 2 3 4 5
// 1 2 3 4
// 1 2 3
// 1 2
// 1

public class InvertedHalfNumberPyramid {
    
    // Method to print an inverted half pyramid with numbers
    public static void printInvertedNumberPyramid(int rows) {
        // Loop through each row
        for (int i = 1; i <= rows; i++) {
            // Inner loop to print numbers in decreasing order
            for (int j = 1; j <= rows - i + 1; j++) {
                System.out.print(j + " "); // Print numbers in the row
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        printInvertedNumberPyramid(6); // Call the method with 6 rows
    }
}
