public class AlphaReverse {
    

        public static void pattern7(int n) {
            for (int i = 1; i <= n; i++) {
                int ch = 65 + (n - 1); // Start from nth letter (e.g., E for n=5)
                for (int j = 1; j <= i; j++) {
                    System.out.print((char)(ch) + " "); // Print the current character
                    ch--; // Move backward in the alphabet
                }
                System.out.println(); // Move to the next row
            }
        }
    
        public static void main(String[] args) {
            // Test the pattern
            int n = 5; // Set the number of rows
            pattern7(n);
        }
    
    
}
