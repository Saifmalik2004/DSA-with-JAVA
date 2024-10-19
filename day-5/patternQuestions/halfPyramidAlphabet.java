// This pattern forms a half pyramid using uppercase letters (A-Z).
// Each row contains letters starting from A up to the row number.
// The output looks like this:
// A 
// A B 
// A B C 
// A B C D 
// A B C D E 

public class halfPyramidAlphabet {
    public static void main(String[] args) {
        int n = 5;  // Number of rows for the pyramid
        char alphabet = 'A';  // Starting character

        // Loop for each row
        for (int i = 1; i <= n; i++) {
            // Print alphabets for the current row
            for (int j = 1; j <= i; j++) {
                System.out.print(alphabet + " ");  // Print current alphabet
                alphabet++;  // Move to the next alphabet
            }
            System.out.println();  // Move to the next line after each row
        }
    }
}
