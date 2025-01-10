// The output of this pattern is:
// ***********
//  *********
//   *******
//    *****
//     ***
//      *
//     ***
//    *****
//   *******
//  *********
// ***********

public class HourGlass {

    // Method to print the hourglass pattern
    public static void hourGlass(int n) {
       
        // Loop for the upper half of the hourglass (inverted pyramid)
        for (int i = n; i >= 1; i--) {
           
            // Print spaces to shift the stars to the right
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
           
            // Print stars for the current row
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
           
            // Move to the next line after printing spaces and stars
            System.out.println();
        }
       
        // Loop for the lower half of the hourglass (pyramid)
        for (int i = 2; i <= n; i++) {
           
            // Print spaces to shift the stars to the right
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
           
            // Print stars for the current row
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
           
            // Move to the next line after printing spaces and stars
            System.out.println();
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        hourGlass(6); // Call the method with 6 rows
    }
}
