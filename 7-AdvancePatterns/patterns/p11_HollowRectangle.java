// output of this pattern :
// * * * * * * * * * 
// *               *
// *               *
// *               *
// * * * * * * * * *

public class p11_HollowRectangle {
    
    // Method to print a hollow rectangle
    public static void hollow_rec(int toRows, int toCols) {
        // Loop through each row
        for (int i = 1; i <= toRows; i++) {
            // Inner loop to print each column
            for (int j = 1; j <= toCols; j++) {
                // Print '*' for the borders or space for the hollow part
                if (i == 1 || i == toRows || j == 1 || j == toCols) {
                    System.out.print("* "); // Print '*' at the border
                } else {
                    System.out.print("  "); // Print space for the hollow part
                }
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        printP(5, 9); // Call the method with 5 rows and 6 columns
    }

    public static void printP(int row,int col){
        for (int i = 1; i <=row; i++) {
            for (int j = 1; j <=col; j++) {
                if((i==1 || j==1) || (j==col || i==row)){
                System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
        System.out.println();

        }
    }
}
