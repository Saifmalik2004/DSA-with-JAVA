//output of this pattern is:
//      * 
//     *** 
//    ***** 
//   ******* 
//  ********* 
//   ******* 
//    ***** 
//     *** 
//      * 

public class p7_DiamondPattern {
    
    // Method to print a diamond pattern
    public static void diamondPattern(int n) {
        // Upper half of the diamond
        for (int i = 1; i <= n; i++) {
            // Print leading spaces for alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  "); // Print spaces for alignment
            }
            // Print stars for the diamond
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* "); // Print '*' for the diamond shape
            }
            System.out.println(); // Move to the next line after finishing a row
        }

        // Lower half of the diamond
        for (int i = n - 1; i >= 1; i--) {
            // Print leading spaces for alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  "); // Print spaces for alignment
            }
            // Print stars for the diamond
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* "); // Print '*' for the diamond shape
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        diamondPattern(6); // Call the method with 6 rows
    }


   
}
