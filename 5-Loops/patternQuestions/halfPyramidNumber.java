// This pattern forms a half pyramid using numbers.
// Each row contains numbers starting from 1 up to the row number.
// The output looks like this:
// 1 
// 1 2 
// 1 2 3 
// 1 2 3 4 
// 1 2 3 4 5 


public class halfPyramidNumber {
    public static void main(String[] args) {
        int n = 5;  // Number of rows for the pyramid

        // Loop for each row
        for (int i = 1; i <= n; i++) {
            // Print numbers for the current row
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");  // Print numbers from 1 to i
            }
            System.out.println();  // Move to the next line after each row
        }
    }
}
