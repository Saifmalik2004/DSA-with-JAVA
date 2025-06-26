//output of this pattern is:
//      1 
//     2 2
//    3 3 3
//   4 4 4 4
//  5 5 5 5 5
// 6 6 6 6 6 6
public class p14_NumberPyramid {
    
    // Method to print a number pyramid
    public static void numberPyramid(int n) {
        // Loop through each row
        for (int i = 1; i <= n; i++) {
            // Print leading spaces for alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" "); // Print spaces for alignment
            }
            // Print numbers in the row starting from 1
            for (int j = 1; j <= i; j++) {
                System.out.print(i+" "); // Print '1' for each number in the row
            }
            System.out.println(); // Move to the next line after finishing a row
        }
    }

    public static void main(String[] args) {
        numberPyramid(6); // Call the method with 6 rows
    }
}

