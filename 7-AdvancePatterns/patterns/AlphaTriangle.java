public class AlphaTriangle {
    public static void palinPyramid(int n) {
        // Outer loop for rows
        for (int i = 0; i < n; i++) {

            // Inner loop for spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" "); // Prints spaces to align the pyramid
            }

            // Variable to store the character starting from 'A'
            char c = 'A';
            // Calculate the midpoint for the row
            int breakPoint = (2 * i + 1) / 2;

            // Inner loop for printing characters
            for (int k = 1; k <= 2 * i + 1; k++) {
                System.out.print(c); // Prints the current character
                if (k <= breakPoint) {
                    c++; // Increment character until the midpoint
                } else {
                    c--; // Decrement character after the midpoint
                }
            }
            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Call the function with n = 5
        palinPyramid(5);
    }
}

/*
Output:
    A
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA
*/
