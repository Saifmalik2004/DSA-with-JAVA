/*
Expected Output:

E
E D
E D C
E D C B
E D C B A

*/

public class p23_AlphaReverse {

    // Method to print the reverse alphabet triangle pattern
    public static void pattern7(int n) {
        for (int i = 1; i <= n; i++) {
            int ch = 65 + (n - 1); // Start from nth letter (ASCII of 'A' is 65, so 65+(n-1) gives last letter in row 1)

            for (int j = 1; j <= i; j++) {
                System.out.print((char)(ch) + " "); // Print the current character
                ch--; // Move backward in the alphabet
            }

            System.out.println(); // Move to the next row
        }
    }

    public static void main(String[] args) {
        // Test the pattern with n = 5
        int n = 5;
        pattern7(n);
    }
}

