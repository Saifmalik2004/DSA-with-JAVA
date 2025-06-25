
//output this pattern is:
// * 
// * *
// * * *
// * * * *
// * * * * *
// * * * * * *
public class p1_SimpleHalfPyramid {
    
    // Method to print a simple half pyramid
    public static void printSimpleHalfPyramid(int n) {
        // Loop through each row
        for (int i = 1; i <= n; i++) {
            // Inner loop to print '*' for each column in the row
            for (int k = 1; k <= i; k++) {
                System.out.print("* "); // Print '*' for the current row
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        printP(6); // Call the method with 6 rows
    }

    public static void printP(int n) {
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
